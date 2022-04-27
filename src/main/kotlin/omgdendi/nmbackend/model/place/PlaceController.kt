package omgdendi.nmbackend.model.place

import omgdendi.nmbackend.common.PlaceId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/places")
class PlaceController @Autowired constructor() {
    @PostMapping("{placeId}/pictures")
    fun addPictureToPlace(@PathVariable placeId: PlaceId) {
        // то же самое что edit
        TODO()
    }

    @DeleteMapping("{placeId}/pictures")
    fun deletePictureFromPlace(@PathVariable placeId: PlaceId) {
        TODO()
    }

    @GetMapping("{placeId}")
    fun getPlaceInfo(@PathVariable placeId: PlaceId) {
        TODO()
    }
}