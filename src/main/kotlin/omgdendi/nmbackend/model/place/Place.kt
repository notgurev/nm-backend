package omgdendi.nmbackend.model.place

import omgdendi.nmbackend.common.PlaceId
import omgdendi.nmbackend.common.URL
import omgdendi.nmbackend.model.comment.Comment

class Place(
    var id: PlaceId = 0,
    var pictureUrl: URL?,
    var latitude: Float = 0.0f,
    var longitude: Float = 0.0f,
    var title: String,
    var description: String = "",
    var comments: MutableList<Comment> = mutableListOf()
)