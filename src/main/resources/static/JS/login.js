$(document).ready(function () {
    $("#form-login").submit(function (event) {
        event.preventDefault();
        autenticarUsuario();
    });
});

function autenticarUsuario() {
    let email = $("#email").val();
    let password = $("#password").val();

    fetch('http://localhost:8090/motorclinic/api/users/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            email: email,
            password: password
        })
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Error en la solicitud');
            }
        })
        .then(result => {
            console.log(result);
            $("#login-error").addClass("d-none");
            let correo = result['email'];
            let rolAdmin = "ADMIN";
            console.log(rolAdmin);
            if ($("#rol").prop("checked")) {
                document.location.href = "home.html?correo=" + correo;
            } else {
                document.location.href = "mecanico.html?correo=" + correo;
            }
        })
        .catch(error => {
            console.error('Error de inicio de sesión:', error);
            $("#login-error").removeClass("d-none");
        });
}
