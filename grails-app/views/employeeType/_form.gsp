<%@ page import="com.hida.hr.EmployeeType" %>



<div class="form-group ${hasErrors(bean: employeeTypeInstance, field: 'code', 'has-error')} required">
	<label for="code">
		<g:message code="employeeType.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField class="form-control" name="code" pattern="${employeeTypeInstance.constraints.code.matches}" value="${employeeTypeInstance?.code}" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: employeeTypeInstance, field: 'description', 'has-error')} ">
	<label for="description">
		<g:message code="employeeType.description.label" default="Description" />
		
	</label>
	<g:textField class="form-control" name="description" value="${employeeTypeInstance?.description}" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: employeeTypeInstance, field: 'status', 'has-error')} required">
	<label for="status">
		<g:message code="employeeType.status.label" default="Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:select class="form-control" name="status" from="${employeeTypeInstance.constraints.status.inList}" value="${employeeTypeInstance?.status}" valueMessagePrefix="employeeType.status" noSelection="['': '']" readonly="${show ?: false}"/>
</div>

<div class="form-group ${hasErrors(bean: employeeTypeInstance, field: 'lastModifiedAt', 'has-error')} required">
	<label for="lastModifiedAt">
		<g:message code="employeeType.lastModifiedAt.label" default="Last Modified At" />
		<span class="required-indicator">*</span>
	</label>
	<bs:dateTimePicker id="employeeTypeInstance-lastModifiedAt" field="lastModifiedAt" value="${employeeTypeInstance?.lastModifiedAt}"  readonly="${show ?: false}"></bs:dateTimePicker>
</div>

<div class="form-group ${hasErrors(bean: employeeTypeInstance, field: 'lastModifiedBy', 'has-error')} required">
	<label for="lastModifiedBy">
		<g:message code="employeeType.lastModifiedBy.label" default="Last Modified By" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField class="form-control" name="lastModifiedBy" value="${employeeTypeInstance?.lastModifiedBy}" readonly="${show ?: false}"/>
</div>

