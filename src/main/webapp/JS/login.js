$(document).ready(function () {
    $("#form-login").submit(function (event) {
        event.preventDefault();
        autenticarUsuario();
    });
});

function autenticarUsuario() {
    let email = $("#email").val();
    let password = $("#password").val();

    $.ajax({
        type: "POST",
        url: "http://localhost:8090/motorclinic/api/users/login",
        contentType: "application/json", // Especificar el tipo de contenido JSON
        data: JSON.stringify({
            email: email,
            password: password
        }),
        success: function (result) {
            if (result) {
                console.log(result);
                $("#login-error").addClass("d-none");
                let correo = result['email'];
                let rolAdmin = "ADMIN";
                console.log(rolAdmin)
                if ($("#rol").prop("checked")) {
                    document.location.href = "home.html?correo=" + correo;

                } else {
                    document.location.href = "mecanico.html?correo=" + correo;
                }
            } else {
                $("#login-error").removeClass("d-none");
            }
        },
        error: function (error) {
            console.error('Error de inicio de sesión:', error);
            $("#login-error").removeClass("d-none");
        }
    });
}
