package omgdendi.nmbackend.model.comment

import omgdendi.nmbackend.model.user.User

class Comment(
    val author: User,
    val text: String
) {
}