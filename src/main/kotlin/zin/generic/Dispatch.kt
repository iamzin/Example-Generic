package zin.generic

import jakarta.persistence.*

@MappedSuperclass
abstract class Dispatch<A: Account, P: Purpose>(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Embedded
    open var account: A,

    var message: String,

    @Enumerated(EnumType.STRING)
    var purpose: P,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is Dispatch<*,*>) return false

        if (id == null || other.id == null) return false

        return id == other.id
    }

    override fun hashCode(): Int = id?.hashCode() ?: 0
}
