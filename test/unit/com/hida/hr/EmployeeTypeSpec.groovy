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

        given : "employee type ABC is exist in the database"
        EmployeeType typeABC = new EmployeeType(code: "ABC", description: "ABC is valid code", status: "ACTIVE", lastModifiedBy: "me")
        typeABC.save(failOnError: true, flush: true)
        typeABC.id
        when: "we tried to create another record with the same code"
        EmployeeType type = new EmployeeType(code: "ABC", description: "other new record with same code", status: "ACTIVE", lastModifiedBy: "me")
        then: "system won't allow it to be saved"
        shouldFail { type.save(failOnError: true)}

    }
    void "description can be null"() {
        given: "a new employee type record with no description"
        EmployeeType typeABC = new EmployeeType(code: "ABC", status: "ACTIVE", lastModifiedBy: "me")
        when: "it's saved into database"
        typeABC.save(failOnError: true)
        then: "it can be saved successfully"
        typeABC.id

    }
    void "status must be either ACTIVE or INACTIVE"() {
        given: "a new employee type with invalid status"
        EmployeeType type = new EmployeeType(code: "ABC", status: "INVALID STATUS HERE", lastModifiedBy: "me")
        when: "status is invalid (neither ACTIVE nor INACTIVE)"
        type.status = "INVALID STATUS HERE"
        then: "system won't allow it to be saved"
        shouldFail { type.save(failOnError: true)}

        when: "status is set to ACTIVE"
        type.status = "ACTIVE"
        then: "it should be saved successfully"
        type.save(failOnError: true)


        when: "status is changed to INACTIVE"
        type.status = "INACTIVE"
        then: "it should be saved successfully"
        type.save(failOnError: true)

    }
}
