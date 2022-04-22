package omgdendi.nmbackend.model.user

import omgdendi.nmbackend.common.UserId
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/friends")
class FriendController {
    @PostMapping("{friendId}")
    fun addFriend(@PathVariable friendId: UserId) {
        TODO()
    }

    @DeleteMapping("{friendId}")
    fun removeFriend(@PathVariable friendId: UserId) {
        TODO()
    }
}