findGasStations();

function findGasStations() {
    $('#btnFindGasStation').click(function () {
        $.ajax({
            url: `http://localhost:8080/api/vi/gasStation/nearby?latitude=${$('#yourLatitude').val()}&longitude=${$('#yourLongitude').val()}`,
            method: 'GET',
            dataType: 'json',
            success: function (result) {
                for (const station of result) {
                    const row = `<tr>
                                <th scope="row">${station.id}</th>
                                <td>${station.name}</td>
                                <td>${station.address}</td>
                            </tr>`;
                    $('#tblGasStation').append(row);
                }

            },
            error: function (xhr, status, error) {
                console.log("Error occurred: " + error);
            }
        })
    });
}