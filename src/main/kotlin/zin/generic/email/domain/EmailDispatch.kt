package zin.generic.email.domain

import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class EmailDispatch(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Embedded
    var account: EmailAddress,

    var message: String,

    var purpose: EmailPurpose,
) {
    companion object {
        fun create(account: EmailAddress, message: String, purpose: EmailPurpose) =
            EmailDispatch(account = account, message = message, purpose = purpose)
    }

    fun buildRequest() = "Sending email to ${account.account} with message: $message"
}
