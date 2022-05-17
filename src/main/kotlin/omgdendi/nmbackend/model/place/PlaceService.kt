package omgdendi.nmbackend.model.place

import omgdendi.nmbackend.common.PlaceId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PlaceService @Autowired constructor(val placeRepository: PlaceRepository) {
    fun getPlaceById(id: PlaceId) = placeRepository.getById(id)
}