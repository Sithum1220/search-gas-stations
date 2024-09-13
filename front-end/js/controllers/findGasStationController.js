findGasStations();

// Function definition for finding nearby gas stations based on the user's latitude and longitude
function findGasStations() {

    $('#btnFindGasStation').click(function () {
        // AJAX call to send a GET request to the server to find nearby gas stations
        $.ajax({
            // API endpoint for finding nearby gas stations, including latitude and longitude from the input fields
            url: `http://localhost:8080/api/vi/gasStation/nearby?latitude=${$('#yourLatitude').val()}&longitude=${$('#yourLongitude').val()}`,
            method: 'GET',
            dataType: 'json',
            success: function (result) {
                $('#tblStations tbody').empty();  // Clear the table body before appending new rows

                // Loop through each station in the result array
                for (const station of result) {
                    // Create a table row with station data (id, name, address)
                    const row = `<tr>
                                    <th scope="row">${station.id}</th>
                                    <td>${station.name}</td>
                                    <td>${station.address}</td>
                                </tr>`;
                    // Append the newly created row to the table with id 'tblStations'
                    $('#tblStations').append(row);
                }

                // Clear the input fields after displaying the results
                clearInput();
            },
            error: function (xhr, status, error) {
                console.log("Error occurred: " + error);
            }
        })
    });
}

// Function to clear input fields after retrieving gas station data
function clearInput() {
    $('#yourLatitude').val('');
    $('#yourLongitude').val('');
}
