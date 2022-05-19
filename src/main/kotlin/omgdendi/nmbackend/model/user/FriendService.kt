package omgdendi.nmbackend.model.user

import omgdendi.nmbackend.common.exceptions.CommonException
import omgdendi.nmbackend.common.UserId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class FriendService @Autowired constructor(val userRepository: UserRepository) {
    fun addFriend(subject: UserId, friend: UserId) {
        val first = userRepository.getById(subject)
        val second = userRepository.getById(friend)
        if (first.friends.contains(second)) throw CommonException("User already in friend list")
        first.friends.add(second)
    }

    fun removeFriend(subject: UserId, friend: UserId) {
        val first = userRepository.getById(subject)
        val second = userRepository.getById(friend)
        if (!first.friends.contains(second)) throw CommonException("User not present in friend list")
        first.friends.remove(second)
    }

    fun getFriends(subject: UserId): List<User> {
        return userRepository.getById(subject).friends
    }
}