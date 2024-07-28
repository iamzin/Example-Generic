package zin.generic.email.domain

import jakarta.persistence.Embeddable

@Embeddable
data class EmailAddress(
    val account: String,
)
