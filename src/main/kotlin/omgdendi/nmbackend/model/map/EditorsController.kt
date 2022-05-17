package omgdendi.nmbackend.model.map

import omgdendi.nmbackend.common.MapId
import omgdendi.nmbackend.common.StringMap
import omgdendi.nmbackend.common.UserId
import omgdendi.nmbackend.common.message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/maps")
class EditorsController @Autowired constructor(
    val mapService: MapService
) {
    data class AddEditorsRequest(val editors: List<UserId>)

    @PostMapping("/{mapId}/editors")
    fun addEditorsToMap(@RequestBody request: AddEditorsRequest, @PathVariable mapId: MapId): StringMap {
        // todo auth
        mapService.addEditorsToMap(mapId, request.editors)
        return message("editors added")
    }

    @DeleteMapping("/{mapId}/editors/{editorId}")
    fun removeEditorFromMap(@PathVariable mapId: MapId, @PathVariable editorId: UserId): StringMap {
        // todo auth
        mapService.removeEditorFromMap(mapId, editorId)
        return message("editor removed")
    }
}