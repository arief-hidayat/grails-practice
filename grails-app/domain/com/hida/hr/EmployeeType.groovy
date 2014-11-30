package com.hida.hr

import org.joda.time.LocalDate
import org.joda.time.LocalDateTime

class EmployeeType {

    String code
    String description
    
    String status

    String lastModifiedBy
    LocalDateTime lastModifiedAt = LocalDateTime.now()

    static constraints = {
    }
}
