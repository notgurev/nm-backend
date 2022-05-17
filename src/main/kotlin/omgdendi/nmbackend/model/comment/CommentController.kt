package omgdendi.nmbackend.model.comment

import omgdendi.nmbackend.common.FakeContext
import omgdendi.nmbackend.common.CommentId
import omgdendi.nmbackend.common.PlaceId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class CommentController @Autowired constructor(val commentService: CommentService) {
    @PostMapping("/{placeId}/comments")
    fun addCommentToPlace(@RequestBody text: String, @PathVariable placeId: PlaceId) {
        commentService.addCommentToPlace(placeId, FakeContext.USER_ID, text)
    }

    @DeleteMapping("/{placeId}/comments/{commentId}")
    fun removeCommentFromPlace(@PathVariable commentId: CommentId, @PathVariable placeId: PlaceId) {
        commentService.removeComment(FakeContext.USER_ID, placeId, commentId)
    }

    @PostMapping("/{placeId}/comments/{commentId}")
    fun editComment(@PathVariable commentId: CommentId, @RequestBody text: String, @PathVariable placeId: PlaceId) {
        commentService.editComment(FakeContext.USER_ID, commentId, text)
    }
}