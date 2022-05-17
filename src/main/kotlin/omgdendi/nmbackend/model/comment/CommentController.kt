package omgdendi.nmbackend.model.comment

import omgdendi.nmbackend.common.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class CommentController @Autowired constructor(val commentService: CommentService) {
    @PostMapping("/{placeId}/comments")
    fun addCommentToPlace(@RequestBody text: String, @PathVariable placeId: PlaceId): StringMap {
        commentService.addCommentToPlace(placeId, FakeContext.USER_ID, text)
        return message("comment added")
    }

    @DeleteMapping("/{placeId}/comments/{commentId}")
    fun removeCommentFromPlace(@PathVariable commentId: CommentId, @PathVariable placeId: PlaceId): StringMap {
        commentService.removeComment(FakeContext.USER_ID, placeId, commentId)
        return message("comment removed")
    }

    @PostMapping("/{placeId}/comments/{commentId}")
    fun editComment(
        @PathVariable commentId: CommentId,
        @RequestBody text: String,
        @PathVariable placeId: PlaceId
    ): StringMap {
        commentService.editComment(FakeContext.USER_ID, commentId, text)
        return message("comment edited")
    }
}