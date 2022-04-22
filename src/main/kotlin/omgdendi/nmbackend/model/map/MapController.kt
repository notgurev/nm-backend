package omgdendi.nmbackend.model.map

import omgdendi.nmbackend.common.MapId
import omgdendi.nmbackend.common.UserId
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/maps")
class MapController {
    data class CreateMapRequest(val name: String, val public: Boolean, val editors: List<UserId>)

    @PostMapping
    fun createMap(@RequestBody createMapRequest: CreateMapRequest) {
        TODO()
    }

    @DeleteMapping("/{mapId}")
    fun deleteMap(@PathVariable mapId: MapId) {
        TODO()
    }

    @PostMapping("/{mapId}/places")
    fun addPlaceToMap(@PathVariable mapId: MapId) {
        TODO()
    }

    @GetMapping("/{mapId}")
    fun getMapInfo(@PathVariable mapId: MapId) {
        TODO()
    }
}