package omgdendi.nmbackend.model.map

import omgdendi.nmbackend.model.place.Place
import omgdendi.nmbackend.model.user.User

class PlaceMap(
    val editors: List<User>,
    val places: List<Place>,
    val public: Boolean
) {

}