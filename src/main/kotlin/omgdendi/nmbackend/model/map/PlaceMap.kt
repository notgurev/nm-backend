package omgdendi.nmbackend.model.map

import omgdendi.nmbackend.common.MapId
import omgdendi.nmbackend.model.place.Place
import omgdendi.nmbackend.model.user.User

class PlaceMap(
    var id: MapId = 0,
    var owner: User,
    var editors: MutableList<User> = mutableListOf(),
    var places: MutableList<Place> = mutableListOf(),
)