package zin.generic.email.domain

import zin.generic.Account

class EmailAddress(
    override var account: String,
) : Account(account)
