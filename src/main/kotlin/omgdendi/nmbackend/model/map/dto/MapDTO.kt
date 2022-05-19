package omgdendi.nmbackend.model.map.dto

import omgdendi.nmbackend.common.MapId
import omgdendi.nmbackend.common.PlaceId
import omgdendi.nmbackend.model.map.PlaceMap
import omgdendi.nmbackend.model.user.dto.UserSmallDTO

data class MapDTO(
    var id: MapId,
    var owner: UserSmallDTO,
    var title: String,
    var editors: List<UserSmallDTO>,
    var places: List<PlaceId>
) {
    companion object {
        fun fromPlaceMap(m: PlaceMap): MapDTO {
            return MapDTO(
                id = m.id,
                owner = UserSmallDTO.fromUser(m.owner),
                title = m.title,
                editors = m.editors.map { e -> UserSmallDTO.fromUser(e) },
                places = m.places.map { p -> p.id }
            )
        }
    }
}