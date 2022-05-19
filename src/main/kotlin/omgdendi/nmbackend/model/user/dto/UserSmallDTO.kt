package omgdendi.nmbackend.model.user.dto

import omgdendi.nmbackend.common.UserId
import omgdendi.nmbackend.model.user.User

data class UserSmallDTO(
    var id: UserId,
    var firstname: String,
    var lastName: String,
    var username: String
) {
    constructor(u: User) : this(u.id, u.firstname, u.lastName, u.username)
}