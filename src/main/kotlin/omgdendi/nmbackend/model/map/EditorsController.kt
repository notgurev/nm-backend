package omgdendi.nmbackend.model.map

import omgdendi.nmbackend.common.MapId
import omgdendi.nmbackend.common.UserId
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/maps")
class EditorsController {
    data class AddEditorsRequest(val editors: List<UserId>)

    @PostMapping("/{mapId}/editors")
    fun addEditorsToMap(@RequestBody x: AddEditorsRequest, @PathVariable mapId: MapId) {
        TODO()
    }

    @DeleteMapping("/{mapId}/editors/{editorId}")
    fun deleteEditorsFromMap(@PathVariable mapId: MapId, @PathVariable editorId: UserId) {
        TODO()
    }
}