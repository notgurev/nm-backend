package omgdendi.nmbackend.model.place

import omgdendi.nmbackend.common.PlaceId
import omgdendi.nmbackend.model.comment.Comment
import javax.persistence.*

@Entity
class Place(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: PlaceId = 0,

    @Column
    var picturePath: String? = null,

    @Column
    var latitude: Float = 0.0f,

    @Column
    var longitude: Float = 0.0f,

    @Column
    var title: String,

    @Column
    var description: String = "",

    @OneToMany
    var comments: MutableList<Comment> = mutableListOf()
)

