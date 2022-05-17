package omgdendi.nmbackend.model.map

import omgdendi.nmbackend.common.MapId
import omgdendi.nmbackend.model.place.Place
import omgdendi.nmbackend.model.user.User
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class PlaceMap(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: MapId = 0,

    @ManyToOne
    var owner: User,

    @ManyToMany
    var editors: MutableList<User> = mutableListOf(),

    @OneToMany
    var places: MutableList<Place> = mutableListOf(),
)