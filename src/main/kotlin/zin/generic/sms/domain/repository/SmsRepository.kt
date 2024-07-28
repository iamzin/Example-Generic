package zin.generic.sms.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import zin.generic.sms.domain.PhoneNumber
import zin.generic.sms.domain.SmsDispatch

interface SmsRepository: JpaRepository<SmsDispatch, Long> {
    fun findByAccount(account: PhoneNumber): SmsDispatch?
}
