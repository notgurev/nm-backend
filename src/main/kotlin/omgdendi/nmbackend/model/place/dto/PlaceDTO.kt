package omgdendi.nmbackend.model.place.dto

import omgdendi.nmbackend.common.PlaceId
import omgdendi.nmbackend.model.comment.dto.CommentDTO
import omgdendi.nmbackend.model.place.Place

data class PlaceDTO(
    var id: PlaceId,
    var picturePath: String?,
    var latitude: Float,
    var longitude: Float,
    var title: String,
    var description: String,
    var comments: List<CommentDTO>
) {
    constructor(p: Place) : this(
        p.id, p.picturePath, p.latitude, p.longitude, p.title, p.description, p.comments.map { CommentDTO(it) }
    )
}