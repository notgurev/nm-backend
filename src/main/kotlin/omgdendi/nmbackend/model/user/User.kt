package omgdendi.nmbackend.model.user

import omgdendi.nmbackend.common.UserId
import omgdendi.nmbackend.model.map.PlaceMap
import javax.persistence.*

@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UserId = 0L,

    @Column
    var firstname: String,

    @Column
    var lastName: String,

    @Column
    var username: String,

    @Column
    var password: String,

    @ManyToMany
    var friends: MutableList<User> = mutableListOf(),

    @OneToMany
    var createdPlaceMaps: MutableList<PlaceMap> = mutableListOf()
) {
}