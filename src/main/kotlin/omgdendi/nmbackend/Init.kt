package omgdendi.nmbackend

import lombok.extern.slf4j.Slf4j
import omgdendi.nmbackend.common.makeFriends
import omgdendi.nmbackend.model.comment.CommentService
import omgdendi.nmbackend.model.map.MapRepository
import omgdendi.nmbackend.model.map.MapService
import omgdendi.nmbackend.model.map.PlaceMap
import omgdendi.nmbackend.model.place.Place
import omgdendi.nmbackend.model.place.PlaceRepository
import omgdendi.nmbackend.model.place.PlaceService
import omgdendi.nmbackend.model.user.UserRepository
import omgdendi.nmbackend.model.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Slf4j
@Component
class Init @Autowired constructor(
    val userRepository: UserRepository,
    val mapRepository: MapRepository,
    val placeRepository: PlaceRepository,

    val userService: UserService,
    val mapService: MapService,
    val placeService: PlaceService,
    val commentService: CommentService
) {
    @EventListener(ApplicationReadyEvent::class)
    @Transactional
    fun init() {
        userService.createUser("Nikita", "Gurev", "notgurev", "<todo>")
        userService.createUser("Abay", "Baytakov", "omgdendi", "<todo>")

        val notgurev = userService.getByUsername("notgurev")
        val omgdendi = userService.getByUsername("omgdendi")

        mapService.createMap(notgurev.id, "notgurev's first map")

        var p = Place(title = "test place")
        p = placeRepository.save(p)

        makeFriends(notgurev, omgdendi)
    }
}