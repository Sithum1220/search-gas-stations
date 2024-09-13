saveGasStation();

// Function definition for saving gas station data
function saveGasStation() {
    $('#btnSaveGasStation').click(function () {
        // Collecting form input values and storing them in the 'data' object
        const data = {
            id: $('#id').val(),
            name: $('#name').val(),
            address: $('#address').val(),
            latitude: $('#latitude').val(),
            longitude: $('#longitude').val()
        }

        // AJAX call to send a POST request to the server with the gas station data
        $.ajax({

            url: 'http://localhost:8080/api/vi/gasStation/save', // API endpoint for saving gas station
            method: 'POST',
            data: JSON.stringify(data),
            contentType: "application/json",
            success: function (result) {
                alert("Successfully Saved");

                // Clear the input fields after Save data
                clearInputs();
            }
        })
    })
}

// Function to clear input fields after saving gas station data
function clearInputs() {
    $('#id').val('');
    $('#name').val('');
    $('#address').val('');
    $('#latitude').val('');
    $('#longitude').val('');
}
