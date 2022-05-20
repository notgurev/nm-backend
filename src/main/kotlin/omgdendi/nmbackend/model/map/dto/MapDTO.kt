package omgdendi.nmbackend.model.map.dto

import omgdendi.nmbackend.common.MapId
import omgdendi.nmbackend.common.PlaceId
import omgdendi.nmbackend.model.map.PlaceMap
import omgdendi.nmbackend.model.place.dto.PlaceDTO
import omgdendi.nmbackend.model.user.dto.UserSmallDTO

data class MapDTO(
    var id: MapId,
    var owner: UserSmallDTO,
    var title: String,
    var editors: List<UserSmallDTO>,
    var places: List<PlaceDTO>
) {
    constructor(m: PlaceMap) : this(
        m.id,
        UserSmallDTO(m.owner),
        m.title,
        m.editors.map { e -> UserSmallDTO(e) },
        m.places.map { p -> PlaceDTO(p)}
    )
}