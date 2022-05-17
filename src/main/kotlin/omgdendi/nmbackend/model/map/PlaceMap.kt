package omgdendi.nmbackend.model.map

import omgdendi.nmbackend.common.MapId
import omgdendi.nmbackend.model.place.Place
import omgdendi.nmbackend.model.user.User
import javax.persistence.*

@Entity
class PlaceMap(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: MapId = 0,

    @ManyToOne
    var owner: User,

    @Column
    var title: String,

    @ManyToMany
    var editors: MutableList<User> = mutableListOf(),

    @OneToMany
    var places: MutableList<Place> = mutableListOf(),
)