package com.hida.hr

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(EmployeeType)
class EmployeeTypeSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "code should be alpha numeric or underscore"() {
        given: "a new employee type"
        EmployeeType type = new EmployeeType(description: "with invalid code", status: "ACTIVE", lastModifiedBy: "me")
        when: "code is invalid (contains char other than alpha numeric or underscore)"
        type.code = "invalid code"
        then: "system won't allow it to be saved"
        shouldFail { type.save(failOnError: true)}

        when: "code is valid"
        type.code = "ABC_01"
        then: "it should be saved successfully"
        type.save(failOnError: true)
        and: "id is automatically generated"
        type.id
    }

    void "code should be unique"() {

    }
    void "description can be null"() {

    }
    void "status must be either ACTIVE or INACTIVE"() {

    }
}
