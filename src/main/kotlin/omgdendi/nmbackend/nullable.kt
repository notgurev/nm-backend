package omgdendi.nmbackend

import java.util.*

val <T> Optional<T>.nullable: T?
    get() = this.orElseGet { null }