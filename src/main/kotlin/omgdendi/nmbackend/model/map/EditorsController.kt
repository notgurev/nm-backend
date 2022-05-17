package omgdendi.nmbackend.model.map

import omgdendi.nmbackend.common.MapId
import omgdendi.nmbackend.common.UserId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/maps")
class EditorsController @Autowired constructor(
    val mapService: MapService
) {
    data class AddEditorsRequest(val editors: List<UserId>)

    @PostMapping("/{mapId}/editors")
    fun addEditorsToMap(@RequestBody request: AddEditorsRequest, @PathVariable mapId: MapId) {
        mapService.addEditorsToMap(mapId, request.editors)
    }

    @DeleteMapping("/{mapId}/editors/{editorId}")
    fun removeEditorFromMap(@PathVariable mapId: MapId, @PathVariable editorId: UserId) {
        mapService.removeEditorFromMap(mapId, editorId)
    }
}