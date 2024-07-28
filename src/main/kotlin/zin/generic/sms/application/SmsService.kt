package zin.generic.sms.application

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import zin.generic.sms.domain.PhoneNumber
import zin.generic.sms.domain.SmsDispatch
import zin.generic.sms.domain.SmsPurpose
import zin.generic.sms.domain.repository.SmsRepository

@Service
@Transactional
class SmsService(
    private val smsRepository: SmsRepository,
) {
    fun registerSms(account: String, message: String, purpose: SmsPurpose): SmsDispatch {
        val phoneNumber = PhoneNumber(account)

        return SmsDispatch.create(phoneNumber, message, purpose)
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
