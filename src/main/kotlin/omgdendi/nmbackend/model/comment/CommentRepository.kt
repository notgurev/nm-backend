package omgdendi.nmbackend.model.comment

import omgdendi.nmbackend.common.CommentId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository : JpaRepository<Comment, CommentId>