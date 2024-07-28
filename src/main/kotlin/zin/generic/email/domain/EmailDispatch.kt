package zin.generic.email.domain

import jakarta.persistence.Entity
import zin.generic.Dispatch

@Entity
class EmailDispatch(
    id: Long? = null,
    account: EmailAddress,
    message: String,
    purpose: EmailPurpose,
) : Dispatch<EmailAddress, EmailPurpose>(id, account, message, purpose) {
    companion object {
        fun create(account: EmailAddress, message: String, purpose: EmailPurpose) =
            EmailDispatch(account = account, message = message, purpose = purpose)
    }

    fun buildRequest() = "Sending email to ${account.account} with message: $message"
}
