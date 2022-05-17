package omgdendi.nmbackend.auth

import omgdendi.nmbackend.model.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController @Autowired constructor(
    val userService: UserService
) {
    data class RegisterRequest(val firstName: String, val lastName: String, val username: String, val password: String)

    @PostMapping("/register")
    fun register(@RequestBody x: RegisterRequest) {
        userService.createUser(x.firstName, x.lastName, x.username, x.password)
    }

    data class LoginRequest(val username: String, val password: String)

    @PostMapping("/login")
    fun login(@RequestBody x: LoginRequest) {
        // не используется
    }
}