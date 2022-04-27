package omgdendi.nmbackend.model.user

import omgdendi.nmbackend.common.UserId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService @Autowired constructor(val userRepository: UserRepository) {
    fun getUserById(id: UserId): User {
        return userRepository.findById(id).orElseThrow { IllegalArgumentException("User with id = $id not found") }
    }

    fun getUsersByIds(it: Iterable<UserId>): Iterable<User> {
        return userRepository.findAllById(it)
    }
}