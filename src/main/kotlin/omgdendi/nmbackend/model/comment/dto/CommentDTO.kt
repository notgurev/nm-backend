
package omgdendi.nmbackend.model.comment.dto

import omgdendi.nmbackend.common.CommentId
import omgdendi.nmbackend.model.comment.Comment
import omgdendi.nmbackend.model.user.dto.UserSmallDTO

data class CommentDTO(
    var id: CommentId,
    var author: UserSmallDTO,
    var text: String
) {
    constructor(c: Comment) : this(c.id, UserSmallDTO(c.author), c.text)
}