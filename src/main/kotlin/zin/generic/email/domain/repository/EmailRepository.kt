package zin.generic.email.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import zin.generic.email.domain.EmailDispatch
import zin.generic.email.domain.EmailAddress

interface EmailRepository: JpaRepository<EmailDispatch, Long> {

    fun findByAccount(account: EmailAddress): EmailDispatch?
}
