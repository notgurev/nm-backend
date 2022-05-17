package omgdendi.nmbackend.model.map

import omgdendi.nmbackend.common.MapId
import omgdendi.nmbackend.common.StringMap
import omgdendi.nmbackend.common.UserId
import omgdendi.nmbackend.common.message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/maps")
class MapController @Autowired constructor(val mapService: MapService) {
    data class CreateMapRequest(val name: String, val editors: List<UserId>?)

    @PostMapping
    fun createMap(
        @RequestBody createMapRequest: CreateMapRequest,
        @RequestHeader("Authorization") subject: UserId
    ): StringMap {
        mapService.createMap(subject, createMapRequest.name, createMapRequest.editors)
        return message("map created")
    }

    @DeleteMapping("/{mapId}")
    fun deleteMap(
        @PathVariable mapId: MapId,
        @RequestHeader("Authorization") subject: UserId
    ): StringMap {
        mapService.deleteMap(subject, mapId)
        return message("map deleted")
    }

    data class AddPlaceRequest(
        var latitude: Float = 0.0f,
        var longitude: Float = 0.0f,
        var title: String,
        var description: String = "",
    )

    @PostMapping("/{mapId}/places")
    fun addPlaceToMap(
        @PathVariable mapId: MapId,
        @RequestBody req: AddPlaceRequest,
        @RequestHeader("Authorization") subject: UserId
    ): StringMap {
        mapService.addPlaceToMap(mapId, req.title, req.description, req.latitude, req.longitude, subject)
        return message("place added to map")
    }

    @GetMapping("/{mapId}")
    fun getMapInfo(@PathVariable mapId: MapId): PlaceMap {
        return mapService.getMapById(mapId)
    }

    @GetMapping
    fun getAllMaps() = mapService.getAllMaps()
}