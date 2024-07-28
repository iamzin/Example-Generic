package zin.generic.sms.domain

import jakarta.persistence.Embeddable

@Embeddable
data class PhoneNumber(
    val account: String,
)
