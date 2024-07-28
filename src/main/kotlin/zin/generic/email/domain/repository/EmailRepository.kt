package zin.generic.email.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import zin.generic.email.domain.Email
import zin.generic.email.domain.EmailAddress

interface EmailRepository: JpaRepository<Email, Long> {

    fun findByAccount(account: EmailAddress): Email?
}
