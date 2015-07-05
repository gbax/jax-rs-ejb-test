var Utils = (function() {
    var firstName;
    var secondName;
    var middleName;
    var birthDate;
    function load() {
        firstName = $("#firstName");
        secondName  = $("#secondName");
        middleName = $("#middleName");
        birthDate = $("#birthDate");
        birthDate.datepicker({
            dateFormat: "dd.mm.yy"
        });
        $.ajax({
            type: "GET",
            url: "/simplegroup/main/getPerson",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(person) {
                console.log(person);
                birthDate.datepicker('setDate', parseDate(person.birthDate));
                firstName.val(person.firstName);
                secondName.val(person.secondName);
                middleName.val(person.middleName);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert("Error: " + textStatus + " errorThrown: " + errorThrown);
            }
        });
    }

    function save() {
        var bDayFormatted = birthDate.datepicker("getDate").format("yyyy-mm-dd");
        $.ajax({
            type: "POST",
            url:"/simplegroup/main/savePerson",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            async: false,
            data: JSON.stringify({ birthDate: bDayFormatted  ,
                firstName: firstName.val(),
                secondName: secondName.val(),
                middleName: middleName.val()
            }),
            success: function () {
                alert("Saved")
            },
            error: function (textStatus, errorThrown) {
                alert(textStatus)
            }
        });
    }

    function parseDate(input) {
        var parts = input.split('-');
        return new Date(parts[0], parts[1]-1, parts[2]);
    }

    return {
        load: load,
        save: save
    };
})();