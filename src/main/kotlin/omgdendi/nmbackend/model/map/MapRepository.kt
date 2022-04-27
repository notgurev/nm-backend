package omgdendi.nmbackend.model.map

import omgdendi.nmbackend.common.MapId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MapRepository : JpaRepository<PlaceMap, MapId> {
}