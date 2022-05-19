package omgdendi.nmbackend.model.map

import omgdendi.nmbackend.common.JSON
import omgdendi.nmbackend.common.MapId
import omgdendi.nmbackend.common.UserId
import omgdendi.nmbackend.common.message
import omgdendi.nmbackend.model.map.dto.MapDTO
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
    ): JSON {
        val map = mapService.createMap(subject, createMapRequest.name, createMapRequest.editors)
        return mapOf("message" to "map created", "id" to map.id)
    }

    @DeleteMapping("/{mapId}")
    fun deleteMap(
        @PathVariable mapId: MapId,
        @RequestHeader("Authorization") subject: UserId
    ): JSON {
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
    ): JSON {
        val p = mapService.addPlaceToMap(mapId, req.title, req.description, req.latitude, req.longitude, subject)
        return mapOf("message" to "place added to map", "id" to p.id)
    }

    @GetMapping("/{mapId}")
    fun getMapInfo(@PathVariable mapId: MapId) = MapDTO(mapService.getMapById(mapId))

    @GetMapping
    fun getAllMaps() = mapService.getAllMaps().map { MapDTO(it) }
}