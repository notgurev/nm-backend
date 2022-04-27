package omgdendi.nmbackend.model.map

import omgdendi.nmbackend.common.CommonException
import omgdendi.nmbackend.common.MapId
import omgdendi.nmbackend.common.UserId
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
    fun createMap(ownerId: UserId, title: String, editorIds: List<UserId>?) {
        val owner = userService.getUserById(ownerId)
        val editors = editorIds?.let { userService.getUsersByIds(it) } ?: mutableListOf()
        val map = PlaceMap(owner = owner, editors = editors as MutableList<User>)
        mapRepository.save(map)
    }

    fun deleteMap(subject: UserId, mapId: MapId) {
        val map = getMapById(mapId)
        if (map.owner.id != subject) throw CommonException("Removing other user's maps is forbidden")
        mapRepository.delete(map) // remove from user's created maps?
    }

    fun addPlaceToMap(mapId: MapId, title: String, description: String, latitude: Float, longitude: Float) {
        TODO("Not yet implemented")
    }

    fun getMapById(id: MapId): PlaceMap {
        return mapRepository.findById(id).orElseThrow { IllegalArgumentException("Map with id = $id not found") }
    }
}