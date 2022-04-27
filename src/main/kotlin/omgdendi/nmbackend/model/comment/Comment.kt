package omgdendi.nmbackend.model.comment

import omgdendi.nmbackend.common.CommentId
import omgdendi.nmbackend.model.place.Place
import omgdendi.nmbackend.model.user.User

class Comment(
    var id: CommentId = 0,
    val author: User,
    var text: String,
    val place: Place
)