package omgdendi.nmbackend.model.user

import omgdendi.nmbackend.common.StringMap
import omgdendi.nmbackend.common.UserId
import omgdendi.nmbackend.common.message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/friends")
class FriendController @Autowired constructor(val friendService: FriendService) {
    @PostMapping("{friendId}")
    fun addFriend(@PathVariable friendId: UserId, @RequestHeader("Authorization") subject: UserId): StringMap {
        friendService.addFriend(subject, friendId)
        return message("added to friends")
    }

    @DeleteMapping("{friendId}")
    fun removeFriend(@PathVariable friendId: UserId, @RequestHeader("Authorization") subject: UserId): StringMap {
        friendService.removeFriend(subject, friendId)
        return message("removed from friends")
    }

    @GetMapping
    fun getFriends(@RequestHeader("Authorization") subject: UserId) = friendService.getFriends(subject)
}