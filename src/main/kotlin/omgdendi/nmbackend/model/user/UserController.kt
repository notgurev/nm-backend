package omgdendi.nmbackend.model.user

import omgdendi.nmbackend.common.UserId
import omgdendi.nmbackend.model.user.dto.UserFullDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/user")
class UserController @Autowired constructor(val userService: UserService) {


    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: UserId) = UserFullDTO(userService.getById(userId))
}