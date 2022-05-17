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
import omgdendi.nmbackend.model.user.User
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
        userRepository.saveAll(
            listOf(
                User(
                    firstname = "Nikita", lastName = "Gurev",
                    username = "notgurev", password = "<todo>",
                    friends = mutableListOf(), createdPlaceMaps = mutableListOf()
                ),
                User(
                    firstname = "Abay", lastName = "Baytakov",
                    username = "omgdendi", password = "<todo>",
                    friends = mutableListOf(), createdPlaceMaps = mutableListOf()
                ),
            )
        )

        val notgurev: User = userRepository.findByUsername("notgurev")!!
        val omgdendi: User = userRepository.findByUsername("omgdendi")!!

        var m = PlaceMap(owner = notgurev, title = "test map")
        notgurev.createdPlaceMaps.add(m)
        m = mapRepository.save(m)

        m.editors.add(omgdendi)

        var p = Place(title = "test place")
        p = placeRepository.save(p)

        makeFriends(notgurev, omgdendi)
    }
}