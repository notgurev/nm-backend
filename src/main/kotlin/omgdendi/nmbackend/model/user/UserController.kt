package omgdendi.nmbackend.model.user

import omgdendi.nmbackend.common.UserId
import omgdendi.nmbackend.model.user.dto.UserFullDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/user")
class UserController @Autowired constructor(val userService: UserService) {
    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: UserId) = UserFullDTO(userService.getById(userId))
}