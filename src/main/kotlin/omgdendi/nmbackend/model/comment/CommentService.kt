package omgdendi.nmbackend.model.comment

import omgdendi.nmbackend.common.CommentId
import omgdendi.nmbackend.common.CommonException
import omgdendi.nmbackend.common.PlaceId
import omgdendi.nmbackend.common.UserId
import omgdendi.nmbackend.model.place.PlaceService
import omgdendi.nmbackend.model.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CommentService @Autowired constructor(
    val userService: UserService, val placeService: PlaceService, val commentRepository: CommentRepository
) {
    fun addCommentToPlace(placeId: PlaceId, authorId: UserId, text: String) {
        val author = userService.getUserById(authorId)
        val place = placeService.getPlaceById(placeId)
        val comment = Comment(author = author, text = text, place = place)
        commentRepository.save(comment)
        place.comments.add(comment)
    }

    fun removeComment(subject: UserId, commentId: CommentId) {
        val comment = getCommentById(commentId)
        if (comment.author.id != subject) throw CommonException("Removing other user's comments is forbidden")
        commentRepository.delete(comment) // todo delete from list?
    }

    fun editComment(subject: UserId, commentId: CommentId, text: String) {
        val comment = getCommentById(commentId)
        if (comment.author.id != subject) throw CommonException("Editing other user's comments is forbidden")
        comment.text = text
    }

    fun getCommentById(id: CommentId): Comment {
        return commentRepository.findById(id)
            .orElseThrow { IllegalArgumentException("Comment with id = $id not found") }
        // todo сделать этот метод generic
    }
}