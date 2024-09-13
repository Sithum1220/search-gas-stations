navigate();

function navigate() {
 $('#addGas').click(function () {
     $('#findGasDiv').addClass('d-none');
     $('#addGasDiv').removeClass('d-none');
 })

    $('#findGas').click(function () {
        $('#addGasDiv').addClass('d-none');
        $('#findGasDiv').removeClass('d-none');
    })
}