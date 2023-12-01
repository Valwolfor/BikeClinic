let idClienteO;
let placaMotoO;
let estadoO;
let idOrden;

$(document).ready(function () {

    validarCliente();
    validarMoto();
    obtenerListaMecanicos();
    checkCorreo();

//Correcto, para botón registrar. sin validar.
    $("#btnSubmitUser").click(function (event) {
        event.preventDefault();
        registrarCliente();

    });

    $("#btnMoto").click(function (event) {
        event.preventDefault();
        registrarMoto();

    });

    $("#btnAddEstado").click(function (event) {
        event.preventDefault();
        registrarEstado();

    });
    
    $("#flexRadioIndicadoresN").change( function (event) {
        event.preventDefault();
        let indicadores = document.querySelector('input[name=flexRadioIndicadores]:checked').value;
        if (indicadores !== 'No apto') {
            desIndicadores = null;
            $("#alertDesc-estado").addClass("d-none");
            $("#DescripcionInd").prop('disabled', true);
        } else {
            $("#DescripcionInd").prop('disabled', false);
            desIndicadores = $("#DescripcionInd").val();
            $("#alertDesc-estado").removeClass("d-none");
        }
    });
    
    $("#flexRadioIndicadoresA").change( function (event) {
        event.preventDefault();
        let indicadores = document.querySelector('input[name=flexRadioIndicadores]:checked').value;
        if (indicadores !== 'No apto') {
            desIndicadores = null;
            $("#alertDesc-estado").addClass("d-none");
            $("#DescripcionInd").prop('disabled', true);
        } else {
            $("#DescripcionInd").prop('disabled', false);
            desIndicadores = $("#DescripcionInd").val();
            $("#alertDesc-estado").removeClass("d-none");
        }
    });
    
});

//ok js, Validado, para confirmar correo
function checkCorreo() {
    $('#Correo, #CorreoC').on('keyup', function () {
        if ($('#Correo').val() === $('#CorreoC').val()) {
            $('#message').html(' Coinciden.').css('color', 'green');
        } else
            $('#message').html(' Los correos no coinciden.').css('color', 'red');
    });
}

//ZONA de Cliente
//Funciona Validado,
function validarCliente() {

    let idCliente;
    $("#Identificacion").on('keyup', function (event) {
        event.preventDefault();
        idCliente = $("#Identificacion").val();
        console.log("el id es: " + idCliente);
        buscarCliente(idCliente);
    });
    //no necesito if, busqueda hace el llamado de actualizar
}

//Funciona, validado.
function registrarCliente() {
    let tipoID = $("#Documento").val();
    let idCliente = $("#Identificacion").val();
    let nombre = $("#Cliente").val();
    let primerApellido = $("#Papellido").val();
    let segundoApellido = $("#Sapellido").val();
    let correo = $("#Correo").val();
    let numeroContacto = $("#Telefono").val();
    idClienteO = idCliente;

    fetch("http://localhost:8090/motorclinic/api/customers", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            typeId: tipoID,
            firstName: nombre,
            lastName: primerApellido+ ' ' + segundoApellido,
            email: correo,
            contactNumber: numeroContacto
        })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Hubo un problema al registrar el cliente');
            }
            return response.json();
        })
        .then(parsedResult => {
            if (parsedResult !== false) {
                pasarPestañaCliente();
                console.log("Se registró correctamente el cliente");
            } else {
                $("#register-cliente").removeClass("d-none");
            }
        })
        .catch(error => {
            console.error('Error al registrar el cliente:', error);
        });
}


//Funciona, validado
function actualizarCliente(tipoId, idCliente, nombre, primerApellido, segundoApellido, correo, numeroContacto) {
    fetch(`http://localhost:8090/motorclinic/api/customers/${idCliente}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            typeId: tipoId,
            firstName: nombre,
            lastName: primerApellido,
            email: correo,
            contactNumber: numeroContacto
        })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Hubo un problema al actualizar los datos del cliente');
            }
            return response.json();
        })
        .then(parsedResult => {
            if (parsedResult !== false) {
                alert("Actualización exitosa");
                pasarPestañaCliente();
                console.log(`Se actualizó el cliente: ${idCliente}`);
                // Si hay algo que hacer con la tabla, se puede construir aquí
            } else {
                $("#actualizar.cliente").removeClass("d-none");
            }
        })
        .catch(error => {
            console.error('Error al actualizar el cliente:', error);
        });
}


//Funciona validado.
function buscarCliente(idCliente) {
    fetch(`http://localhost:8090/motorclinic/api/customers/${idCliente}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Hubo un problema al llamar los datos del cliente');
            }
            return response.json();
        })
        .then(parsedResult => {
            if (parsedResult !== false) {

                console.log(`El usuario ${idCliente} ya está registrado`);
                // Setear datos del cliente en el formulario
                document.getElementById('Documento').value = parsedResult.typeId;
                $("#Identificacion").val(idCliente);
                $("#Cliente").val(parsedResult.firstName);
                $("#Papellido").val(parsedResult.lastName);
                $("#Sapellido").val("");
                $("#Correo").val(parsedResult.email);
                $("#CorreoC").val(parsedResult.email);
                $("#Telefono").val(parsedResult.contactNumber);
                // Bloquea id
                $("#Identificacion").prop('disabled', true);
                // Asigna en la global
                idClienteO = idCliente;

                if (confirm("El cliente ya está registrado, ¿desea actualizar sus datos?")) {
                    alert("Cuando actualice los datos debe dar click en el botón de 'Editar Registro'");
                    $("#btnSubmitUser").prop('disabled', true);
                    $("#btnEditUser").prop('disabled', false);

                    // Da espacio a actualizar los nuevos datos
                    $("#btnEditUser").click(function (event) {
                        event.preventDefault();
                        // Recolecta nuevos datos
                        let tipoId = $("#Documento").val();
                        let idCliente = $("#Identificacion").val();
                        let nombre = $("#Cliente").val();
                        let primerApellido = $("#Papellido").val();
                        let segundoApellido = $("#Sapellido").val();
                        let correo = $("#Correo").val();
                        let numeroContacto = $("#Telefono").val();
                        // Llama función
                        actualizarCliente(tipoId, idCliente, nombre, primerApellido, segundoApellido, correo, numeroContacto);
                    });
                } else {
                    pasarPestañaCliente();
                }
            } else {
                console.log(`El usuario ${idCliente} no está registrado`);
                $("#btnEditUser").prop('disabled', true);
                // Podría ir un alert sobre que no está registrado.
            }
        })
        .catch(error => {
            console.error('Error al obtener datos del cliente:', error);
        });
}


//Funciona validado.
function pasarPestañaCliente() {

    //remueve clases y habilita pestañas
    //nav link.
    $("#nav-cliente-tab").removeClass("active");
    $('#nav-cliente-tab').prop('aria-selected', false);
    $("#nav-cliente-tab").prop('disabled', true);
    //panel (creo que se puede hacer en una sola.
    $("#nav-cliente").removeClass("show");
    $("#nav-cliente").removeClass("active");

    //next tab
    $("#nav-moto-tab").addClass("active");
    $('#nav-moto-tab').prop('aria-selected', true);
    $("#nav-moto-tab").prop('disabled', false);
    //panel
    $("#nav-moto").addClass("show");
    $("#nav-moto").addClass("active");
}

//ZONA de moto
//Funciona validado
function validarMoto() {

    let placaMoto;
    $("#Placa").on('keyup', function (event) {
        event.preventDefault();
        placaMoto = document.getElementById('Placa').value;
        console.log("La placa es: " + placaMoto);
        buscarMoto(placaMoto);
    });
}

//Funciona validado
function buscarMoto(placaMoto) {
//buscará por id returnará booleano, tal vez también los datos. 
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletMotoBuscar",
        data: $.param({
            placaMoto: placaMoto
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                console.log("La moto: " + placaMoto + " ya está registrada");
                //setear datos del cliente en el formulario
                //setear recibe datos, si se mete paramentro en val() se pueden setear
                $("#Placa").val(placaMoto);
                $("#Motor").val(parsedResult.idMotor);
                $("#Chasis").val(parsedResult.idChasis);
                $("#Marca").val(parsedResult.marca);
                $("#Modelo").val(parsedResult.modelo);
                $("#Anio").val(parsedResult.anioRegistro);
                //bloquea id
                $("#Identificacion").prop('disabled', true);
                //asigna en la global, pues es irrelevante para esto el if pues no se puede cambiar el id.
                placaMotoO = placaMoto;
                idClienteO = parsedResult.Clientes_idCliente;
                alert("La moto ya está registrada");
                pasarPestañaMoto();
                // TODO FUTURO : algo de verificar si id cliente y placa encontrada son de una persona

            } else {
                console.log("La moto :" + placaMotoO + ", no está resgistrado");
            }
        }
    });
}

//Funciona validado
function registrarMoto() {

    let placaMoto = $("#Placa").val();
    let idMotor = $("#Motor").val();
    let idChasis = $("#Chasis").val();
    let marca = $("#Marca").val();
    let modelo = $("#Modelo").val();
    let anioRegistro = $("#Anio").val();
    let Clientes_idCliente = idClienteO;
    //asigna en la global, pues es irrelevante para esto el if pues no se puede cambiar el id.
    //si no existe se ejecutará está cuando se de click en el botón enviar.
    placaMotoO = placaMoto;

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletMotoRegistro",
        data: $.param({
            placaMoto: placaMoto,
            idMotor: idMotor,
            idChasis: idChasis,
            marca: marca,
            modelo: modelo,
            anioRegistro: anioRegistro,
            Clientes_idCliente: Clientes_idCliente
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                pasarPestañaMoto();
                console.log("Se registró correctamente la moto");
            } else {
                //ta listo esto.
                $("#register-moto").removeClass("d-none");
            }
        }
    });
}

//Funciona validado
function pasarPestañaMoto() {

    //remueve clases y habilita pestañas
    //nav link.
    $("#nav-moto-tab").removeClass("active");
    $('#nav-moto-tab').prop('aria-selected', false);
    $("#nav-moto-tab").prop('disabled', true);
    //panel (creo que se puede hacer en una sola.
    $("#nav-moto").removeClass("show");
    $("#nav-moto").removeClass("active");

    //next tab
    $("#nav-estado-tab").addClass("active");
    $('#nav-estado-tab').prop('aria-selected', true);
    $("#nav-estado-tab").prop('disabled', false);
    //panel
    $("#nav-estado").addClass("show");
    $("#nav-estado").addClass("active");
}

//ZONA Mecánico para ponerlo en select 
//TODO futuro validarlo con los datos de login.
//Funciona Validado
function obtenerListaMecanicos() {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletMecanicosListar",
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                mostrarMecanicos(parsedResult);

            } else {
                console.log("Hubo un problema al llamar los datos de lista mecánicos en la zona de mecánico.");
            }
        }
    });
}

//Funciona Validado
function mostrarMecanicos(listaMecanicos) {

    let selects = "";
    $.each(listaMecanicos, function (index, mecanico) {

        mecanico = JSON.parse(mecanico);
        if (mecanico.estado === "Activo") {
            mecanicoActivo = mecanico;
        }
        selects += '<option value="' + mecanicoActivo.id + '" >' +
                mecanicoActivo.nombre + ' ' + mecanicoActivo.primerApellido + ' ' + mecanicoActivo.segundoApellido +
                '</option>';
    });
    $('#Mecanico').html(selects);
}

//ZONA estado
//Funciona, Checkbox sin check funcionando.
//Valida indicadores ok.
// debería no dejar registrar con el mismo km
function registrarEstado() {

    let indicadores = document.querySelector('input[name=flexRadioIndicadores]:checked').value;
    desIndicadores;

//    if (indicadores === 'No apto') {
//        $("#DescripcionInd").prop('disabled', false);
//        desIndicadores = $("#DescripcionInd").val();
//        $("#alertDesc-estado").removeClass("d-none");
//    } else {
//        desIndicadores = null;
//    }

    let aceite = document.querySelector('input[name=flexRadioAceite]:checked').value;
    let nivelAceite = document.querySelector('input[name=flexRadioAceiteNivel]:checked').value;
    let liquidoFrenos = document.querySelector('input[name=flexRadioLFrenos]:checked').value;
    let liquidoEmbrague = document.querySelector('input[name=flexRadioLEmbrague]:checked').value;
    let liquidoRefrigerante = document.querySelector('input[name=flexRadioLRefrigerante]:checked').value;
    
    let lucesAptas = (document.querySelector('input[value=Farola]:checked') ? document.querySelector('input[value=Farola]:checked').value: null);
    lucesAptas += (document.querySelector('input[value=Stop]:checked') ? ", " + document.querySelector('input[value=Stop]:checked').value: null);
    lucesAptas += (document.querySelector('input[value=Direcionales]:checked') ? ", " + document.querySelector('input[value=Direcionales]:checked').value: null);
    lucesAptas += (document.querySelector('input[value=Auxiliares]:checked') ? ", " + document.querySelector('input[value=Auxiliares]:checked').value: null);

    let espejos = document.querySelector('input[name=flexRadioEspejo]:checked').value;
    let claxon = document.querySelector('input[name=flexRadioClaxon]:checked').value;
    let tanque = document.querySelector('input[name=flexRadioTanque]:checked').value;
    let llantaDelantera = document.querySelector('input[name=flexRadioLDelantera]:checked').value;
    let llantaTrasera = document.querySelector('input[name=flexRadioLTrasera]:checked').value;
    let motor = document.querySelector('input[name=flexRadioMotor]:checked').value;
    let chasis = document.querySelector('input[name=flexRadioChasis]:checked').value;
    let acelerador = document.querySelector('input[name=flexRadioAcelerador]:checked').value;
    let escape = document.querySelector('input[name=flexRadioEscape]:checked').value;
    let trasmision = document.querySelector('input[name=flexRadioTrasmision]:checked').value;
    let embrague = document.querySelector('input[name=flexRadioEmbrague]:checked').value;
    let frenos = document.querySelector('input[name=flexRadioFreno]:checked').value;
    let cadena = document.querySelector('input[name=flexRadioCadena]:checked').value;
    let apoyaPies = document.querySelector('input[name=flexRadioApoya]:checked').value;
    let kilometraje = document.getElementById('Kilometraje').value;
    let combustible = document.querySelector('input[name=flexRadioGas]:checked').value;

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletEstadoRegistro",
        data: $.param({
            indicadores: indicadores,
            desIndicadores: desIndicadores,
            aceite: aceite,
            nivelAceite: nivelAceite,
            liquidoFrenos: liquidoFrenos,
            liquidoEmbrague: liquidoEmbrague,
            liquidoRefrigerante: liquidoRefrigerante,
            lucesAptas: lucesAptas,
            espejos: espejos,
            claxon: claxon,
            tanque: tanque,
            llantaDelantera: llantaDelantera,
            llantaTrasera: llantaTrasera,
            motor: motor,
            chasis: chasis,
            acelerador: acelerador,
            escape: escape,
            trasmision: trasmision,
            embrague: embrague,
            frenos: frenos,
            cadena: cadena,
            apoyaPies: apoyaPies,
            kilometraje: kilometraje,
            combustible: combustible

        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                obtenerIdEstado(kilometraje);
                pasarPestañaEstado();

                console.log("Se registró correctamente el estado");
            } else {
                //ta listo esto.
                $("#register-estado").removeClass("d-none");
            }
        }
    });
}

//Funciona.
function obtenerIdEstado(kilometraje) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletEstadoBuscar",
        data: $.param({
            kilometraje: kilometraje
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                console.log("El estado con " + kilometraje + " ya está registrado");
                estadoO = parsedResult.idEstado;
            }
        }
    });
}

//Funciona
function pasarPestañaEstado() {

    //remueve clases y habilita pestañas
    //nav link.
    $("#nav-estado-tab").removeClass("active");
    $('#nav-estado-tab').prop('aria-selected', false);
    $("#nav-estado-tab").prop('disabled', true);
    //panel (creo que se puede hacer en una sola.
    $("#nav-estado").removeClass("show");
    $("#nav-estado").removeClass("active");

    //next tab
    $("#nav-motivo-tab").addClass("active");
    $('#nav-motivo-tab').prop('aria-selected', true);
    $("#nav-motivo-tab").prop('disabled', false);
    //panel
    $("#nav-motivo").addClass("show");
    $("#nav-motivo").addClass("active");
}
 
 
 // EsTOY AQUIIIIIII!!!
//ZONA ORDEN de servicio
//MOTIVO 
function registrarMotivo() {

    //idOrden autogenera Se debe obtener después
    fecha = new Date().getUTCFullYear();
    fecha += "-" + new Date().getUTCMonth();
    fecha += "-" + new Date().getUTCDate();
    let cliente = idClienteO;
    let mecanico = document.getElementById('Mecanico').value;
    let moto = placaMotoO;
    let motivo = document.getElementById('Motivo').value;
    let documentos = document.querySelector('input[value=Farola]:checked').value;
    documentos += ", " + document.querySelector('#inlineCheckbox2');
    documentos += ", " + document.querySelector('#inlineCheckbox3');
    let anticipo = document.getElementById("flexSwitchCheckAnticipo").value;

    let valorAnticipo;
    if (anticipo === 'Sí') {
        $("#valAnticipo").prop('disabled', false);
        valorAnticipo = $("#valAnticipo").val();
    } else {
        anticipo = "No";
        valorAnticipo = 0;
    }
    ;

    let autorizacionRuta = document.getElementById("flexSwitchCheckRuta").value;

    if (autorizacionRuta === 'Sí') {
    } else {
        autorizacionRuta = "No";
    }
    ;

    let descripcionDiagnostico = $("#Dmotivo").val();
    let estado = estadoO;

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletMotoRegistro",
        data: $.param({
            placaMoto: placaMoto,
            idMotor: idMotor,
            idChasis: idChasis,
            marca: marca,
            modelo: modelo,
            anioRegistro: anioRegistro,
            Clientes_idCliente: Clientes_idCliente
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                pasarPestañaMoto();
                console.log("Se registró correctamente la moto");
            } else {
                //ta listo esto.
                $("#register-moto").removeClass("d-none");
            }
        }
    });
}

