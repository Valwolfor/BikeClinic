$(document).ready(function () {
    $("#form-login").submit(function (event) {
        event.preventDefault();
        autenticarUsuario();
        
    });
    console.log("Funciona");
});

function autenticarUsuario() {
    let correo = $("#correo").val();
    let password = $("#password").val();
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            correo: correo,
            password: password
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                $("#login-error").addClass("d-none");
                let correo = parsedResult['correo'];
                let rolAdmin = "Administrador";
                if (parsedResult.rol === rolAdmin) {
                    if ($('#checkMec').prop('checked')) {
                        document.location.href = "mecanico.html?correo= " + correo;
                    } else {
                        document.location.href = "home.html?correo= " + correo;
                    }
                }else {
                    document.location.href = "mecanico.html?correo= " + correo;
                }
            } else {
                $("#login-error").removeClass("d-none");

            }

        }
    });
}