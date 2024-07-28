package zin.generic.email.application

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import zin.generic.email.domain.EmailAddress
import zin.generic.email.domain.repository.EmailRepository

@Service
@Transactional
class EmailService(
    private val emailRepository: EmailRepository,
) {
    fun sendEmail(account: String): String {
        val email = emailRepository.findByAccount(EmailAddress(account))
            ?: throw IllegalArgumentException("Email not found")

        // print하는 것으로 api를 호출하여 실제 발송하는 것을 대체한다.
        return email.buildRequest()
            .also { println(it) }
    }
}
