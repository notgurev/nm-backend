package omgdendi.nmbackend.model.map

import omgdendi.nmbackend.common.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/maps")
class MapController @Autowired constructor(val mapService: MapService) {
    data class CreateMapRequest(val name: String, val editors: List<UserId>?)

    @PostMapping
    fun createMap(@RequestBody createMapRequest: CreateMapRequest): StringMap {
        mapService.createMap(FakeContext.USER_ID, createMapRequest.name, createMapRequest.editors)
        return message("map created")
    }

    @DeleteMapping("/{mapId}")
    fun deleteMap(@PathVariable mapId: MapId): StringMap {
        mapService.deleteMap(FakeContext.USER_ID, mapId)
        return message("map deleted")
    }

    data class AddPlaceRequest(
        var latitude: Float = 0.0f,
        var longitude: Float = 0.0f,
        var title: String,
        var description: String = "",
    )

    @PostMapping("/{mapId}/places")
    fun addPlaceToMap(@PathVariable mapId: MapId, @RequestBody req: AddPlaceRequest): StringMap {
        mapService.addPlaceToMap(mapId, req.title, req.description, req.latitude, req.longitude)
        return message("place added to map")
    }

    @GetMapping("/{mapId}")
    fun getMapInfo(@PathVariable mapId: MapId): PlaceMap {
        return mapService.getMapById(mapId)
    }

    @GetMapping
    fun getAllMaps() = mapService.getAllMaps()
}