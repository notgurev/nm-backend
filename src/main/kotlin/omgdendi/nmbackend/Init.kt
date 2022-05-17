package omgdendi.nmbackend

import lombok.extern.slf4j.Slf4j
import omgdendi.nmbackend.common.makeFriends
import omgdendi.nmbackend.model.comment.CommentService
import omgdendi.nmbackend.model.map.MapService
import omgdendi.nmbackend.model.place.PlaceService
import omgdendi.nmbackend.model.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Slf4j
@Component
class Init @Autowired constructor(
    val userService: UserService,
    val mapService: MapService,
    val placeService: PlaceService,
    val commentService: CommentService
) {
    @EventListener(ApplicationReadyEvent::class)
    @Transactional
    fun init() {
        if (userService.userRepository.count() > 0) {
            println("--- --- --- Already initialized --- --- ---")
            return
        }
        val notgurev = userService.createUser("Никита", "Гурьев", "notgurev", "<todo>")
        val omgdendi = userService.createUser("Абай", "Байтаков", "omgdendi", "<todo>")
        val sealOfTime = userService.createUser("Матвей", "Вдовицын", "sealOfTime", "<todo>")

        val m1 = mapService.createMap(notgurev.id, "Университеты СПб")

        mapService.addEditorsToMap(m1.id, listOf(omgdendi.id, sealOfTime.id))
        mapService.removeEditorFromMap(m1.id, sealOfTime.id)

        val p1 = mapService.addPlaceToMap(
            m1.id, "ИТМО",
            "Крутой универ", 100f, 200f, notgurev.id
        )
        val p2 = mapService.addPlaceToMap(
            m1.id, "СПбГУ",
            "привет", 2f, 4f, omgdendi.id
        )

        commentService.addCommentToPlace(p1.id, notgurev.id, "Я тут учусь")
        commentService.addCommentToPlace(p1.id, omgdendi.id, "Я тоже тут учусь")

        commentService.addCommentToPlace(p2.id, omgdendi.id, "вау")

        makeFriends(notgurev, omgdendi)

        println("--- --- --- Init complete --- --- ---")
    }
}