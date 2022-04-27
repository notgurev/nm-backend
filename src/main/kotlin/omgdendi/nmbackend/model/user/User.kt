package omgdendi.nmbackend.model.user

import omgdendi.nmbackend.common.UserId
import omgdendi.nmbackend.model.map.PlaceMap

class User(
    var id: UserId = 0,
    var firstname: String,
    var lastName: String,
    var username: String,
    var password: String,
    var friends: MutableList<User> = mutableListOf(),
    var createdPlaceMaps: MutableList<PlaceMap> = mutableListOf()
) {
}