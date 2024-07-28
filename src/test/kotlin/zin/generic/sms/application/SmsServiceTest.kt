package zin.generic.sms.application

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.transaction.annotation.Transactional
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
    @Test
    fun `sendEmail()`() {
        val account = "01012345678"

        // register
        val sms = Sms.create(PhoneNumber(account), "Hello, World!", SmsPurpose.ACCOUNT_ACTIVATION)
            .also { smsRepository.save(it) }

        sms.id shouldNotBe null

        // send
        val result = smsService.sendSms(account)

        result shouldBe "Sending sms to $account with message: Hello, World!"
    }
}
