package zin.generic.sms.domain

import jakarta.persistence.*

@Entity
class Sms(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Embedded
    var account: PhoneNumber,

    var message: String,

    var purpose: SmsPurpose,
) {
    fun buildRequest() = "Sending sms to ${account.account} with message: $message"
}
