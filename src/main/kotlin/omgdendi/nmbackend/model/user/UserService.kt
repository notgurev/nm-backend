package omgdendi.nmbackend.model.user

import omgdendi.nmbackend.common.UserId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService @Autowired constructor(val userRepository: UserRepository) {
    fun getById(id: UserId) = userRepository.getById(id)

    fun getByUsername(username: String) = userRepository.getByUsername(username)

    fun getUsersByIds(IDs: Iterable<UserId>): Iterable<User> {
        return userRepository.findAllById(IDs)
    }

    fun createUser(firstname: String, lastname: String, username: String, password: String): User {
        val u = User(firstname = firstname, lastName = lastname, username = username, password = password)
        return userRepository.save(u)
    }
}