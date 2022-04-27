package omgdendi.nmbackend.model.comment

import omgdendi.nmbackend.FakeContext
import omgdendi.nmbackend.common.CommentId
import omgdendi.nmbackend.common.PlaceId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class CommentController @Autowired constructor(val commentService: CommentService) {
    @PostMapping("{placeId}/comments")
    fun addCommentToPlace(@RequestBody text: String, @PathVariable placeId: PlaceId) {
        commentService.addCommentToPlace(placeId, FakeContext.USER_ID, text)
    }

    @DeleteMapping("/comments/{commentId}")
    fun removeCommentFromPlace(@PathVariable commentId: CommentId) {
        commentService.removeComment(FakeContext.USER_ID, commentId)
    }

    @PostMapping("/comments/{commentId}")
    fun editComment(@PathVariable commentId: CommentId, @RequestBody text: String) {
        commentService.editComment(FakeContext.USER_ID, commentId, text)
    }
}