package omgdendi.nmbackend.model.place

import omgdendi.nmbackend.common.Settings
import omgdendi.nmbackend.common.PlaceId
import omgdendi.nmbackend.common.URL
import omgdendi.nmbackend.model.comment.Comment
import javax.persistence.*

@Entity
class Place(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: PlaceId = 0,

    @Column
    var pictureUrl: URL? = Settings.DEFAULT_PICTURE,

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