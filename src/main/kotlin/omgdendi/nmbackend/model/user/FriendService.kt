package omgdendi.nmbackend.model.user

import omgdendi.nmbackend.common.UserId
import omgdendi.nmbackend.nullable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class FriendService @Autowired constructor(val userRepository: UserRepository) {
    fun addFriend(subject: UserId, friend: UserId) { // todo test
        userRepository.findById(subject).nullable?.apply {
            userRepository.findById(friend).nullable?.let {
                if (!this.friends.contains(it)) {
                    this.friends.add(it)
                }
            }
        }
    }

    fun removeFriend(subject: UserId, friend: UserId) { // todo test
        userRepository.findById(subject).nullable?.apply {
            userRepository.findById(friend).nullable?.let {
                if (this.friends.contains(it)) {
                    this.friends.remove(it)
                }
            }
        }
    }
}