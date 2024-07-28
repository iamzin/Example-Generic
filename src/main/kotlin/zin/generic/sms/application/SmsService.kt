package zin.generic.sms.application

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import zin.generic.email.domain.EmailAddress
import zin.generic.email.domain.repository.EmailRepository
import zin.generic.sms.domain.PhoneNumber
import zin.generic.sms.domain.Sms
import zin.generic.sms.domain.SmsPurpose
import zin.generic.sms.domain.repository.SmsRepository

@Service
@Transactional
class SmsService(
    private val smsRepository: SmsRepository,
) {
    fun registerSms(account: String, message: String, purpose: SmsPurpose): Sms {
        val phoneNumber = PhoneNumber(account)

        return Sms.create(phoneNumber, message, purpose)
            .also { smsRepository.save(it) }
    }

    fun sendSms(account: String): String {
        val sms = smsRepository.findByAccount(PhoneNumber(account))
            ?: throw IllegalArgumentException("Email not found")

        // print하는 것으로 api를 호출하여 실제 발송하는 것을 대체한다.
        return sms.buildRequest()
            .also { println(it) }
    }
}
