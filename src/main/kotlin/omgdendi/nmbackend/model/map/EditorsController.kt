package omgdendi.nmbackend.model.map

import omgdendi.nmbackend.common.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/maps")
class EditorsController @Autowired constructor(
    val mapService: MapService
) {
    data class AddEditorsRequest(val editors: List<UserId>)

    @PostMapping("/{mapId}/editors")
    fun addEditorsToMap(@RequestBody request: AddEditorsRequest, @PathVariable mapId: MapId): JSON {
        // todo auth
        mapService.addEditorsToMap(mapId, request.editors)
        return message("editors added to map")
    }

    @DeleteMapping("/{mapId}/editors/{editorId}")
    fun removeEditorFromMap(@PathVariable mapId: MapId, @PathVariable editorId: UserId): JSON {
        // todo auth
        mapService.removeEditorFromMap(mapId, editorId)
        return message("editor removed from map")
    }
}