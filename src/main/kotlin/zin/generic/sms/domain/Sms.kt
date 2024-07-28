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
    companion object {
        fun create(account: PhoneNumber, message: String, purpose: SmsPurpose) =
            Sms(account = account, message = message, purpose = purpose)
    }

    fun buildRequest() = "Sending sms to ${account.account} with message: $message"
}
