package omgdendi.nmbackend.model.user

import omgdendi.nmbackend.common.UserId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, UserId>