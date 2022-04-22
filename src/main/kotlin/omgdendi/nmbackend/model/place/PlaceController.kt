package omgdendi.nmbackend.model.place

import omgdendi.nmbackend.common.CommentId
import omgdendi.nmbackend.common.PlaceId
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/places")
class PlaceController {
    @PostMapping("{placeId}/comments")
    fun addCommentToPlace(@RequestBody text: String, @PathVariable placeId: PlaceId) {
        TODO()
    }

    @DeleteMapping("{placeId}/comments/{commentId}")
    fun removeCommentFromPlace(@PathVariable commentId: CommentId, @PathVariable placeId: PlaceId) {
        TODO()
    }

    @PostMapping("{placeId}/comments/{commentId}")
    fun editComment(@PathVariable commentId: CommentId, @PathVariable placeId: PlaceId) {
        TODO()
    }

    @PostMapping("{placeId}/pictures")
    fun addPictureToPlace(@PathVariable placeId: PlaceId) {
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