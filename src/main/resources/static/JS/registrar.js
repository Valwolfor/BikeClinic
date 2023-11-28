$(document).ready(function () {
    checkPassword();
    $("#form-register").submit(function (event) {
        event.preventDefault();
        registrarMecanico();
        
    });
});//hay un error solo carga una vez. 

function checkPassword() {
    $('#password, #confirm-password').on('keyup', function () {
        if ($('#password').val() === $('#confirm-password').val()) {
            $('#message').html(' Coincide :D.').css('color', 'green');
        } else
            $('#message').html(' La contraseña no coincide.').css('color', 'red');
    });
}

function registrarMecanico() {
    let idUsuario = $("#idMec").val();
    let nombre = $("#firtsName").val();
    let primerApellido = $("#lastName").val();
    let segundooApellido = $("#lastName2").val();
//    let estado = "Activo";
//    let rol = "Mecánico";
    let correo = $("#email").val();
    let password = $("#password").val();
    let passwordConf = $("#confirm-password").val();
    let numeroContacto = $("#numero-contacto").val();
    if (password === passwordConf){
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletMecanicoRegistro",
            data: $.param({
                idUsuario: idUsuario,
                nombre: nombre,
                primerApellido: primerApellido,
                segundooApellido: segundooApellido,
                estado: "Activo",
                rol: "Mecánico",
                correo: correo,
                password: password,
                numeroContacto: numeroContacto
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);
                if (parsedResult !== false) {
                    $("#register-success").removeClass("d-none");
                    let correo = parsedResult['correo'];
                    document.location.href = "home.html?correo= " + correo;

                } else {
                    $("#register-error").removeClass("d-none");
                }
            }
        });
    } else {
        $("#password-error").removeClass("d-none");
    }
}