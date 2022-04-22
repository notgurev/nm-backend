package omgdendi.nmbackend.model.user

import omgdendi.nmbackend.model.map.PlaceMap

class User(
    val firstname: String,
    val lastName: String,
    val username: String,
    val password: String,
    val friends: List<User>,
    val createdPlaceMaps: List<PlaceMap>
) {
}