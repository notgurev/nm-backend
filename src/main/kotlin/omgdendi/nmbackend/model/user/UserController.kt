package omgdendi.nmbackend.model.user

import omgdendi.nmbackend.common.UserId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/user")
class UserController @Autowired constructor(val userService: UserService) {


    @GetMapping("/{userId}")
    fun getUser(@RequestHeader("Authorization") subject: UserId, @PathVariable userId: UserId) = userService.getById(subject)
}