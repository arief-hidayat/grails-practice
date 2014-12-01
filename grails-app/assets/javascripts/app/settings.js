// override whatever is required from core.settings.

//= require core.settings
//= require_self

App.dt.config.table = {
    Employee : { columns: [ { "data": "code" }, { "data": "jobTitle" }, { "data": "fullName" }, { "data": "type" } ] },
    EmployeeType : { columns: [ { "data": "code" } ] }
};

App.dt.config.customUrl = { /// for dataTable query
//        Asset : {
//            url : "only for custom",
//            data : function(){},
//            extraParams : function(request) { }
//        }
};