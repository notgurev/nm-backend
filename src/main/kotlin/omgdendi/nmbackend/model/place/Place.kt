package omgdendi.nmbackend.model.place

import omgdendi.nmbackend.model.comment.Comment

typealias URL = String

class Coordinates

class Place(
    val pictureUrl: URL,
    val coordinates: Coordinates,
    val title: String,
    val description: String,
    val comments: List<Comment>
) {
}