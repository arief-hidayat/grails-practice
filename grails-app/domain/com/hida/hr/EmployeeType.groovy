package com.hida.hr

import org.joda.time.LocalDateTime

class EmployeeType {

    String code
    String description

    String status

    String lastModifiedBy
    LocalDateTime lastModifiedAt = LocalDateTime.now()

    static constraints = {
        code matches: "[A-Z0-9_]+", unique: true
        description nullable: true
        status inList: ["ACTIVE", "INACTIVE"]
    }
}
