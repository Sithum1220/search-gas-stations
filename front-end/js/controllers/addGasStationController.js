saveGasStation();

function saveGasStation() {
    $('#btnSaveGasStation').click(function () {
            const data = {
                id: $('#id').val(),
                name: $('#name').val(),
                address: $('#address').val(),
                latitude: $('#latitude').val(),
                longitude: $('#longitude').val()
            }

            $.ajax({
                url: 'http://localhost:8080/api/vi/gasStation/save',
                method: 'POST',
                data: JSON.stringify(data),
                contentType: "application/json",
                success: function (result) {
                    alert("Successfully Saved");
                    clearInputs();
                }
            })
    })
}

function clearInputs() {
    $('#id').val('');
    $('#name').val('');
    $('#address').val('');
    $('#latitude').val('');
    $('#longitude').val('');
}