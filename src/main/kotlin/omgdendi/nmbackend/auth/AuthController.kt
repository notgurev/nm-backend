package omgdendi.nmbackend.auth

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController {
    data class RegisterRequest(val firstName: String, val lastName: String, val username: String, val password: String)

    @PostMapping("/register")
    fun register(@RequestBody x: RegisterRequest) {
        TODO()
    }

    data class LoginRequest(val username: String, val password: String)

    @PostMapping("/login")
    fun login(@RequestBody x: LoginRequest) {
        TODO()
    }
}