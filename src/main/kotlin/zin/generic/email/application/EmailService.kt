package zin.generic.email.application

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import zin.generic.email.domain.Email
import zin.generic.email.domain.EmailAddress
import zin.generic.email.domain.EmailPurpose
import zin.generic.email.domain.repository.EmailRepository

@Service
@Transactional
class EmailService(
    private val emailRepository: EmailRepository,
) {
    fun registerEmail(account: String, message: String, purpose: EmailPurpose): Email {
        val emailAddress = EmailAddress(account)

        return Email.create(emailAddress, message, purpose)
            .also { emailRepository.save(it) }
    }

    fun sendEmail(account: String): String {
        val email = emailRepository.findByAccount(EmailAddress(account))
            ?: throw IllegalArgumentException("Email not found")

        // print하는 것으로 api를 호출하여 실제 발송하는 것을 대체한다.
        return email.buildRequest()
            .also { println(it) }
    }
}
