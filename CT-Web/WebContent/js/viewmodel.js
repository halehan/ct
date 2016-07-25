function customerViewModel() {
    var self = this;

    self.customerList = ko.observableArray();

    self.getCustomers = function () {
        $.ajax({
            type: 'GET',   
            url: 'http://localhost:8080/CT-Web/api/patient/list',
            contentType: "application/javascript",
            dataType: "jsonp",
            success: function(data) {
                var observableData = ko.mapping.fromJS(data);
                var array = observableData();
                self.customerList(array);
            },
            error:function(jq, st, error){
                alert(error);
            }
        });
    };
}

$(document).ready(function () {
    ko.applyBindings(new customerViewModel());
});