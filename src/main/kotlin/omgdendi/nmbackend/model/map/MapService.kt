package omgdendi.nmbackend.model.map

import omgdendi.nmbackend.common.CommonException
import omgdendi.nmbackend.common.MapId
import omgdendi.nmbackend.common.UserId
import omgdendi.nmbackend.model.place.Place
import omgdendi.nmbackend.model.user.User
import omgdendi.nmbackend.model.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MapService @Autowired constructor(
    val mapRepository: MapRepository,
    val userService: UserService
) {
    fun createMap(ownerId: UserId, title: String, editorIds: List<UserId>? = null) {
        val owner = userService.getById(ownerId)
        val editors = editorIds?.let { userService.getUsersByIds(it) } ?: mutableListOf()
        val map = PlaceMap(owner = owner, editors = editors as MutableList<User>, title = title)
        owner.createdPlaceMaps.add(map)
        mapRepository.save(map)
    }

    fun deleteMap(subject: UserId, mapId: MapId) {
        val map = getMapById(mapId)
        if (map.owner.id != subject) throw CommonException("Removing other user's maps is forbidden")
        map.owner.createdPlaceMaps.remove(map)
        mapRepository.delete(map)
    }

    fun addPlaceToMap(mapId: MapId, title: String, description: String, latitude: Float, longitude: Float) {
        val m = mapRepository.getById(mapId)
        val p = Place(latitude = latitude, longitude = longitude, description = description, title = title)
        m.places.add(p)
    }

    fun getMapById(id: MapId) = mapRepository.getById(id)
}