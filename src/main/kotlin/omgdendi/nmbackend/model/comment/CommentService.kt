package omgdendi.nmbackend.model.comment

import omgdendi.nmbackend.common.*
import omgdendi.nmbackend.model.place.PlaceService
import omgdendi.nmbackend.model.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CommentService @Autowired constructor(
    val userService: UserService,
    val placeService: PlaceService,
    val commentRepository: CommentRepository
) {
    fun addCommentToPlace(placeId: PlaceId, authorId: UserId, text: String) {
        val author = userService.getById(authorId)
        val place = placeService.getPlaceById(placeId)
        val comment = Comment(author = author, text = text, place = place)
        commentRepository.save(comment)
        place.comments.add(comment)
    }

    fun removeComment(subject: UserId, placeId: PlaceId, commentId: CommentId) {
        val comment = getCommentById(commentId)
        if (comment.author.id != subject) throw RestrictedActionException("Removing other user's comments is forbidden")

        val place = placeService.getPlaceById(placeId)
        place.comments.remove(comment)

        commentRepository.delete(comment)
    }

    fun editComment(subject: UserId, commentId: CommentId, text: String) {
        val comment = getCommentById(commentId)
        if (comment.author.id != subject) throw RestrictedActionException("Editing other user's comments is forbidden")
        comment.text = text
    }

    fun getCommentById(id: CommentId) = commentRepository.getById(id)
}