package omgdendi.nmbackend.common

import omgdendi.nmbackend.model.user.User

fun makeFriends(first: User, second: User) {
    first.friends.add(second)
    second.friends.add(first)
}