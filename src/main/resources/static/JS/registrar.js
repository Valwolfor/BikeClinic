$(document).ready(function () {
    $("#form-register-mech").submit(function (event) {
        event.preventDefault();
        registrarMecanico();
    });

    $('#password, #confirm-password').on('keyup', function () {
        if ($('#password').val() === $('#confirm-password').val()) {
            $('#message').html(' Coincide :D.').css('color', 'green');
        } else {
            $('#message').html(' La contraseña no coincide.').css('color', 'red');
        }
    });
});

function registrarMecanico() {
    let nombre = $("#firtsName").val();
    let primerApellido = $("#lastName").val();
    let segundooApellido = $("#lastName2").val();
    let correo = $("#email").val();
    let password = $("#password").val();
    let passwordConf = $("#confirm-password").val();
    let numeroContacto = $("#numero-contacto").val();

    if (password === passwordConf) {
        // Envío de solicitud al servidor con Fetch
        fetch('http://localhost:8090/motorclinic/api/users', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                firstName: nombre,
                lastName: primerApellido + ' ' + segundooApellido,
                status: 'ACTIVE',
                roles: ["MECHANIC"],
                email: correo,
                password: password,
                contactNumber: numeroContacto
            })
        })
            .then(response => response.json())
            .then(parsedResult => {
                if (parsedResult !== false) {
                    $("#register-success").removeClass("d-none");
                    location.reload();
                } else {
                    $("#register-error").removeClass("d-none");
                }
            })
            .catch(error => {
                console.error('Error al registrar al mecánico:', error);
                // Manejar el error si la solicitud falla
                $("#register-error").removeClass("d-none");
            });
    } else {
        $("#password-error").removeClass("d-none");
    }
}
