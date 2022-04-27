package omgdendi.nmbackend.model.user

import omgdendi.nmbackend.FakeContext
import omgdendi.nmbackend.common.UserId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/friends")
class FriendController @Autowired constructor(val friendService: FriendService) {
    @PostMapping("{friendId}")
    fun addFriend(@PathVariable friendId: UserId) {
        friendService.addFriend(FakeContext.USER_ID, friendId)
    }

    @DeleteMapping("{friendId}")
    fun removeFriend(@PathVariable friendId: UserId) {
        friendService.removeFriend(FakeContext.USER_ID, friendId)
    }
}