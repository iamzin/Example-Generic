package zin.generic.sms.application

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
import zin.generic.sms.domain.PhoneNumber
import zin.generic.sms.domain.Sms
import zin.generic.sms.domain.SmsPurpose
import zin.generic.sms.domain.repository.SmsRepository

@SpringBootTest
@Transactional
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class SmsServiceTest(
    private val smsService: SmsService,
    private val smsRepository: SmsRepository,
) {
    lateinit var account: String
    lateinit var sms: Sms

    @BeforeEach
    fun setUp() {
        account = "01012345678"
        sms = Sms(
            account = PhoneNumber(account),
            message = "Hello, World!",
            purpose = SmsPurpose.ACCOUNT_ACTIVATION,
        ).also { smsRepository.save(it) }
    }

    @Test
    fun `sendEmail()`() {
        val result = smsService.sendSms(account)

        result shouldBe "Sending sms to $account with message: Hello, World!"
    }
}
