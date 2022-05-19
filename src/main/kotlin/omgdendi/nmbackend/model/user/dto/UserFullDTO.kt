package omgdendi.nmbackend.model.user.dto

import omgdendi.nmbackend.common.UserId
import omgdendi.nmbackend.model.map.dto.MapDTO
import omgdendi.nmbackend.model.user.User

data class UserFullDTO(
    var id: UserId,
    var firstname: String,
    var lastName: String,
    var username: String,
    var friends: List<UserSmallDTO>,
    var createdPlaceMaps: List<MapDTO>,
    var editableMaps: List<MapDTO>
) {
    constructor(u: User) : this(
        u.id, u.firstname, u.lastName, u.username,
        u.friends.map { UserSmallDTO(it) },
        u.createdPlaceMaps.map { MapDTO(it) },
        u.editableMaps.map { MapDTO(it) }
    )
}