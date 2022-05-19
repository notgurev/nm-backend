package omgdendi.nmbackend.model.user.dto

import omgdendi.nmbackend.common.UserId
import omgdendi.nmbackend.model.user.User

data class UserSmallDTO(
    var id: UserId,
    var firstname: String,
    var lastName: String,
    var username: String
) {
    companion object {
        fun fromUser(u: User): UserSmallDTO {
            return UserSmallDTO(
                id = u.id,
                firstname = u.firstname,
                lastName = u.lastName,
                username = u.username
            )
        }
    }
}