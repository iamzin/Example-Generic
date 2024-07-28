package zin.generic.email.application

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.transaction.annotation.Transactional
import zin.generic.email.domain.Email
import zin.generic.email.domain.EmailAddress
import zin.generic.email.domain.EmailPurpose
import zin.generic.email.domain.repository.EmailRepository

@SpringBootTest
@Transactional
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class EmailServiceTest(
    private val emailService: EmailService,
    private val emailRepository: EmailRepository,
) {
    lateinit var account: String
    lateinit var email: Email

    @BeforeEach
    fun setUp() {
        account = "eunzin.park@gmail.com"
        email = Email(
            account = EmailAddress(account),
            message = "Hello, World!",
            purpose = EmailPurpose.NEWSLETTER,
        ).also { emailRepository.save(it) }
    }

    @Test
    fun `sendEmail()`() {
        val result = emailService.sendEmail(account)

        result shouldBe "Sending email to $account with message: Hello, World!"
    }
}
