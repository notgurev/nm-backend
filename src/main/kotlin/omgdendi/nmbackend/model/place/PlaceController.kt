package omgdendi.nmbackend.model.place

import omgdendi.nmbackend.common.JSON
import omgdendi.nmbackend.common.PlaceId
import omgdendi.nmbackend.common.message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/places")
class PlaceController @Autowired constructor(
    val placeService: PlaceService,
) {
    @PostMapping("{placeId}/pictures")
    fun addPictureToPlace(@PathVariable placeId: PlaceId, @RequestParam("file") file: MultipartFile): JSON {
        val filename = placeService.addPictureToPlace(placeId, file)
        return mapOf("message" to "picture added to place", "file" to filename)
    }

    @DeleteMapping("{placeId}/pictures")
    fun deletePictureFromPlace(@PathVariable placeId: PlaceId): JSON {
        return message("not implemented")
    }

    @GetMapping("{placeId}")
    fun getPlaceInfo(@PathVariable placeId: PlaceId): Place {
        return placeService.getPlaceById(placeId)
    }
}