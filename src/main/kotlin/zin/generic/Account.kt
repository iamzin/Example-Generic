package zin.generic

import jakarta.persistence.Embeddable

@Embeddable
abstract class Account(
    open var account: String,
)
