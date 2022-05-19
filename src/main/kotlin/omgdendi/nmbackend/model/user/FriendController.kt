package omgdendi.nmbackend.model.user

import omgdendi.nmbackend.common.JSON
import omgdendi.nmbackend.common.UserId
import omgdendi.nmbackend.common.message
import omgdendi.nmbackend.model.user.dto.UserSmallDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/friends")
class FriendController @Autowired constructor(val friendService: FriendService) {
    @PostMapping("{friendId}")
    fun addFriend(@PathVariable friendId: UserId, @RequestHeader("Authorization") subject: UserId): JSON {
        friendService.addFriend(subject, friendId)
        return message("added to friends")
    }

    @DeleteMapping("{friendId}")
    fun removeFriend(@PathVariable friendId: UserId, @RequestHeader("Authorization") subject: UserId): JSON {
        friendService.removeFriend(subject, friendId)
        return message("removed from friends")
    }

    @GetMapping
    fun getFriends(@RequestHeader("Authorization") subject: UserId): List<UserSmallDTO> {
        return friendService.getFriends(subject).map { UserSmallDTO.fromUser(it) }
    }
}