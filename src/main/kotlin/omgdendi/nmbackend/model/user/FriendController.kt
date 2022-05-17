package omgdendi.nmbackend.model.user

import omgdendi.nmbackend.common.FakeContext
import omgdendi.nmbackend.common.StringMap
import omgdendi.nmbackend.common.UserId
import omgdendi.nmbackend.common.message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/friends")
class FriendController @Autowired constructor(val friendService: FriendService) {
    @PostMapping("{friendId}")
    fun addFriend(@PathVariable friendId: UserId): StringMap {
        friendService.addFriend(FakeContext.USER_ID, friendId)
        return message("added to friends")
    }

    @DeleteMapping("{friendId}")
    fun removeFriend(@PathVariable friendId: UserId): StringMap {
        friendService.removeFriend(FakeContext.USER_ID, friendId)
        return message("removed from friends")
    }
}