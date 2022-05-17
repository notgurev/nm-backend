package omgdendi.nmbackend

import lombok.extern.slf4j.Slf4j
import omgdendi.nmbackend.common.makeFriends
import omgdendi.nmbackend.model.user.User
import omgdendi.nmbackend.model.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Slf4j
@Component
class Init @Autowired constructor(
    val userRepository: UserRepository,
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

        makeFriends(notgurev, omgdendi)
    }
}