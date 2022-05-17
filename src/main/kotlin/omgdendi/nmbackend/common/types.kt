package omgdendi.nmbackend.common

typealias UserId = Long
typealias MapId = Long
typealias PlaceId = Long
typealias CommentId = Long
typealias StringMap = Map<String, String>

typealias URL = String

fun message(text: String) = mutableMapOf("message" to text) as StringMap