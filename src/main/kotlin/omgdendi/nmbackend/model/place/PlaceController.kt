package omgdendi.nmbackend.model.place

import omgdendi.nmbackend.common.PlaceId
import omgdendi.nmbackend.common.StringMap
import omgdendi.nmbackend.media.MediaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/places")
class PlaceController @Autowired constructor(
    val placeService: PlaceService,
    val mediaService: MediaService,
) {
    @PostMapping("{placeId}/pictures")
    fun addPictureToPlace(@PathVariable placeId: PlaceId, @RequestParam("file") file: MultipartFile): StringMap {
        return mapOf(
            "message" to "picture added to place",
            "file" to mediaService.saveFile(file)
        )
    }

    @DeleteMapping("{placeId}/pictures")
    fun deletePictureFromPlace(@PathVariable placeId: PlaceId) {
        TODO()
    }

    @GetMapping("{placeId}")
    fun getPlaceInfo(@PathVariable placeId: PlaceId): Place {
        return placeService.getPlaceById(placeId)
    }
}