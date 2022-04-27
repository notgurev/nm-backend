package omgdendi.nmbackend.model.place

import omgdendi.nmbackend.common.PlaceId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlaceRepository : JpaRepository<Place, PlaceId>