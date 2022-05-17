package omgdendi.nmbackend.model.place

import omgdendi.nmbackend.common.PlaceId
import omgdendi.nmbackend.media.MediaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile

@Service
@Transactional
class PlaceService @Autowired constructor(
    val placeRepository: PlaceRepository,
    val mediaService: MediaService
) {
    fun getPlaceById(id: PlaceId) = placeRepository.getById(id)

    fun addPictureToPlace(placeId: PlaceId, file: MultipartFile): String {
        val filename = mediaService.saveFile(file)

        val place = getPlaceById(placeId)
        place.picturePath = filename

        return filename
    }
}