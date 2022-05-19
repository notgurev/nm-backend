package omgdendi.nmbackend.model.comment

import omgdendi.nmbackend.common.CommentId
import omgdendi.nmbackend.model.place.Place
import omgdendi.nmbackend.model.user.User
import omgdendi.nmbackend.model.user.dto.UserSmallDTO
import javax.persistence.*

@Entity
class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: CommentId = 0,

    @ManyToOne
    val author: User,

    @Column
    var text: String,

    @ManyToOne
    val place: Place
)

