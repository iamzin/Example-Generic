package zin.generic.sms.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import zin.generic.sms.domain.PhoneNumber
import zin.generic.sms.domain.Sms

interface SmsRepository: JpaRepository<Sms, Long> {
    fun findByAccount(account: PhoneNumber): Sms?
}
