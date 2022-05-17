package omgdendi.nmbackend.model.comment

import omgdendi.nmbackend.common.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class CommentController @Autowired constructor(
    val commentService: CommentService
) {
    @PostMapping("/{placeId}/comments")
    fun addCommentToPlace(
        @RequestBody text: String,
        @PathVariable placeId: PlaceId,
        @RequestHeader("Authorization") subject: UserId
    ): JSON {
        val comment = commentService.addCommentToPlace(placeId, subject, text)
        return mapOf("message" to "comment added", "id" to comment.id)
    }

    @DeleteMapping("/{placeId}/comments/{commentId}")
    fun removeCommentFromPlace(
        @PathVariable commentId: CommentId,
        @PathVariable placeId: PlaceId,
        @RequestHeader("Authorization") subject: UserId
    ): JSON {
        commentService.removeComment(subject, placeId, commentId)
        return message("comment removed")
    }

    @PostMapping("/{placeId}/comments/{commentId}")
    fun editComment(
        @PathVariable commentId: CommentId,
        @RequestBody text: String,
        @PathVariable placeId: PlaceId,
        @RequestHeader("Authorization") subject: UserId
    ): JSON {
        commentService.editComment(subject, commentId, text)
        return message("comment edited")
    }
}