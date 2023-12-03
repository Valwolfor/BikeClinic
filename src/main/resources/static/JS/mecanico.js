let idClienteO;
let idMOtoO;
let estadoO;
let placaMotoO;
let servicios;
let productos;
let idOrden;

$(document).ready(function () {

    validarCliente();
    validarMoto();
    obtenerListaMecanicos();
    obtenerProductos();
    obtenerServicios();
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

    $(document).ready(function () {
        const checkboxDocumentos = document.getElementById('flexSwitchCheckDocumentos');
        const documentosInput = document.getElementById('documentos');

        // Agregar evento de cambio al checkbox de documentos
        checkboxDocumentos.addEventListener('change', function () {
            documentosInput.disabled = !checkboxDocumentos.checked;
            documentosInput.value = ''; // Limpiar el campo de texto si se deshabilita
        });

        // Evento de cambio para el checkbox de anticipo
        $("#flexSwitchCheckAnticipo").change(function () {
            let valorAnticipoInput = document.getElementById("valAnticipo");

            // Verificar si el checkbox de anticipo está marcado para habilitar/deshabilitar el campo de valor del anticipo
            if (this.checked) {
                valorAnticipoInput.disabled = false; // Habilita el campo del valor del anticipo
            } else {
                valorAnticipoInput.disabled = true; // Deshabilita el campo del valor del anticipo
                valorAnticipoInput.value = ""; // Restablece el valor del campo si el checkbox no está marcado
            }
        });

        $("#btnReMotivo").click(function (event) {
            event.preventDefault();
            let anticipoCheckbox = document.getElementById("flexSwitchCheckAnticipo");
            let valorAnticipoInput = document.getElementById("valAnticipo");

            // Verificar si el anticipo está marcado y si el valor del anticipo es necesario
            if (anticipoCheckbox.checked && valorAnticipoInput.value === "") {
                // Si el anticipo está marcado pero no se ingresó valor, muestra un mensaje de error
                alert("Debe ingresar un valor para el anticipo.");
                return; // Detiene la ejecución de la función en este punto
            }

            registrarMotivo();
        });
    });

    document.getElementById('btnTerminar').addEventListener('click', function (event) {
        event.preventDefault();

        const confirmar = confirm("¿Seguro que desea terminar el registro de la Orden de Servicio?");

        if (confirmar) {
            // Recargar la página para reiniciar todas las variables
            location.reload();
        }
    });

    document.getElementById('btnRegistroAdd').addEventListener('click', function (event) {
        event.preventDefault();
        registrarRegistro();
    });

    document.getElementById('tbodyMecServicios').addEventListener('click', function (event) {
        if (event.target.classList.contains('btnBorrar')) {
            const rowToDelete = event.target.closest('tr');
            const id = event.target.dataset.id;

            borrarRegistro(id, rowToDelete);
        }
    });

    $("#flexRadioIndicadoresN").change(function (event) {
        event.preventDefault();
        let indicadores = document.querySelector('input[name=flexRadioIndicadores]:checked').value;
        if (indicadores !== 'No apto') {
            desIndicadores = "";
            $("#alertDesc-estado").addClass("d-none");
            $("#DescripcionInd").prop('disabled', true);
        } else {
            $("#DescripcionInd").prop('disabled', false);
            desIndicadores = $("#DescripcionInd").val();
            $("#alertDesc-estado").removeClass("d-none");
        }
    });

    $("#flexRadioIndicadoresA").change(function (event) {
        event.preventDefault();
        let indicadores = document.querySelector('input[name=flexRadioIndicadores]:checked').value;
        if (indicadores !== 'No apto') {
            desIndicadores = "";
            $("#alertDesc-estado").addClass("d-none");
            $("#DescripcionInd").prop('disabled', true);
        } else {
            $("#DescripcionInd").prop('disabled', false);
            desIndicadores = $("#DescripcionInd").val();
            $("#alertDesc-estado").removeClass("d-none");
        }
    });

});


function checkCorreo() {
    $('#Correo, #CorreoC').on('keyup', function () {
        if ($('#Correo').val() === $('#CorreoC').val()) {
            $('#message').html(' Coinciden.').css('color', 'green');
        } else
            $('#message').html(' Los correos no coinciden.').css('color', 'red');
    });
}

//ZONA de Cliente
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


function registrarCliente() {
    let tipoID = $("#Documento").val();
    let idCliente = $("#Identificacion").val();
    let nombre = $("#Cliente").val();
    let primerApellido = $("#Papellido").val();
    let segundoApellido = $("#Sapellido").val();
    let correo = $("#Correo").val();
    let numeroContacto = $("#Telefono").val();

    fetch("http://localhost:8090/motorclinic/api/customers", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            typeId: tipoID,
            firstName: nombre,
            lastName: primerApellido + ' ' + segundoApellido,
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

                idClienteO = parsedResult.id;
                pasarPestannaCliente();
                console.log("Se registró correctamente el cliente");
            } else {
                $("#register-cliente").removeClass("d-none");
            }
        })
        .catch(error => {
            console.error('Error al registrar el cliente:', error);
        });
}


function actualizarCliente(tipoId, idCliente, nombre, primerApellido, segundoApellido, correo, numeroContacto) {
    fetch(`http://localhost:8090/motorclinic/api/customers/${idCliente}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            typeId: tipoId,
            firstName: nombre,
            lastName: primerApellido + ' ' + segundoApellido,
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
                pasarPestannaCliente();
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

                idClienteO = parsedResult.id;
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
                    pasarPestannaCliente();
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


function pasarPestannaCliente() {

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
async function buscarMoto(placaMoto) {
    try {
        const response = await fetch(`http://localhost:8090/motorclinic/api/motorcycles/plate/${placaMoto}`);
        if (!response.ok) {
            throw new Error('No se pudo obtener la motocicleta');
        }
        const data = await response.json();
        if (data) {
            if (data.customer.id !== idClienteO) {
                alert('La moto ya está registrada, pero pertenece a otro cliente');

                throw new Error('La moto pertenece a otro cliente');
            }
            console.log(`La moto ${placaMoto} ya está registrada`);
            idMOtoO = data.id
            placaMotoO = data.plate;

            // Asignar datos a los campos del formulario. Creo que ni es necesario. Ademas nisiquiera está bien
            document.getElementById('Placa').value = placaMoto;
            document.getElementById('Motor').value = data.engineId;
            document.getElementById('Chasis').value = data.chassisId;
            document.getElementById('Marca').value = data.brand;
            document.getElementById('Modelo').value = data.model;
            document.getElementById('Anio').value = data.registrationYear;
            // Bloquear el campo de identificación
            document.getElementById('Identificacion').disabled = true;
            // Asignar valores a variables globales
            placaMotoO = placaMoto;
            idClienteO = data.Clientes_idCliente;
            alert('La moto ya está registrada');
            pasarPestannaMoto();
            // TODO: Lógica adicional si es necesario
        } else {
            console.log(`La moto ${placaMotoO} no está registrada`);
        }
    } catch (error) {
        console.error('Error al buscar la motocicleta:', error);
    }
}


//Falta
async function registrarMoto() {
    try {
        let placaMoto = $("#Placa").val();
        let idMotor = $("#Motor").val();
        let idChasis = $("#Chasis").val();
        let marca = $("#Marca").val();
        let modelo = $("#Modelo").val();
        let anioRegistro = $("#Anio").val();
        let Clientes_idCliente = idClienteO;

        // Datos a enviar en la solicitud POST
        const data = {
            plate: placaMoto,
            engineId: idMotor,
            chassisId: idChasis,
            brand: marca,
            model: modelo,
            registrationYear: anioRegistro,
            customer: {
                id: Clientes_idCliente
            }
        };

        const response = await fetch("http://localhost:8090/motorclinic/api/motorcycles", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

        if (!response.ok) {
            throw new Error('No se pudo registrar la motocicleta');
        }

        const parsedResult = await response.json();
        if (parsedResult !== false) {

            idMOtoO = parsedResult.id;
            pasarPestannaMoto();
            console.log("Se registró correctamente la moto");
        } else {
            $("#register-moto").removeClass("d-none");
        }
    } catch (error) {
        console.error('Error al registrar la motocicleta:', error);
    }
}

//Funciona validado
function pasarPestannaMoto() {

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
//TODO futuro validarlo con los datos de login. Ni idea que era lo que quería :P
//No aun
function obtenerListaMecanicos() {

    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://localhost:8090/motorclinic/api/users/by-role?role=MECHANIC",
        success: function (result) {
            if (result !== false) {
                mostrarMecanicos(result);

            } else {
                console.log("Hubo un problema al llamar los datos de lista mecánicos en la zona de mecánico.");
            }
        }
    });
}

function obtenerServicios() {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://localhost:8090/motorclinic/api/services",
        success: function (result) {
            if (result !== false) {
                servicios = result;
                mostrarServicios(result);
            } else {
                console.log("Hubo un problema al llamar los datos de lista de servicios.");
            }
        },
        error: function (error) {
            console.error('Hubo un error al obtener los servicios:', error);
        }
    });
}

function obtenerProductos() {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://localhost:8090/motorclinic/api/products",
        success: function (result) {
            if (result !== false) {
                productos = result
                mostrarProductos(result);
            } else {
                console.log("Hubo un problema al llamar los datos de lista de productos.");
            }
        },
        error: function (error) {
            console.error('Hubo un error al obtener los productos:', error);
        }
    });
}


//Funciona Validado
function mostrarMecanicos(listaMecanicos) {

    let selects = "";
    $.each(listaMecanicos, function (index, mecanico) {

        if (mecanico.status === "ACTIVE") {
            mecanicoActivo = mecanico;
        }
        selects += '<option value="' + mecanicoActivo.id + '" >' +
            mecanicoActivo.firstName + ' ' + mecanicoActivo.lastName +
            '</option>';
    });
    $('#Mecanico').html(selects);
}

function mostrarServicios(listaServicios) {

    let selects = "";
    $.each(listaServicios, function (index, servicio) {

        selects += '<option value="' + servicio.idService + '" >' +
            servicio.serviceName +
            '</option>';
    });
    $('#servicios').html(selects);
}

function mostrarProductos(listaProductos) {

    let selects = "";
    $.each(listaProductos, function (index, producto) {

        selects += '<option value="' + producto.idProduct + '" >' +
            producto.productName +
            '</option>';
    });
    $('#productos').html(selects);
}

//ZONA estado
//Funciona, Checkbox sin check funcionando.
//Falta validadores que no se llenó un elemento.
// debería no dejar registrar con el mismo km
function registrarEstado() {
    let indicadores = document.querySelector('input[name=flexRadioIndicadores]:checked').value;

    let aceite = document.querySelector('input[name=flexRadioAceite]:checked').value;
    let nivelAceite = document.querySelector('input[name=flexRadioAceiteNivel]:checked').value;
    let liquidoFrenos = document.querySelector('input[name=flexRadioLFrenos]:checked').value;
    let liquidoEmbrague = document.querySelector('input[name=flexRadioLEmbrague]:checked').value;
    let liquidoRefrigerante = document.querySelector('input[name=flexRadioLRefrigerante]:checked').value;

    let lucesAptas = [];
    document.querySelectorAll('input[type=checkbox][name="lucesAptas"]:checked').forEach(function (el) {
        lucesAptas.push(el.value);
    });

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

    fetch("http://localhost:8090/motorclinic/api/status", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            indicators: indicadores,
            indicatorsDesc: desIndicadores, // Descomentar si es necesario manejar la descripción
            oil: aceite,
            oilLevel: nivelAceite,
            brakeFluid: liquidoFrenos,
            clutchFluid: liquidoEmbrague,
            coolant: liquidoRefrigerante,
            lightsGood: lucesAptas.join(", "),
            mirrors: espejos,
            horn: claxon,
            tank: tanque,
            frontTire: llantaDelantera,
            rearTire: llantaTrasera,
            engine: motor,
            chassis: chasis,
            throttle: acelerador,
            exhaust: escape,
            transmission: trasmision,
            clutch: embrague,
            brakes: frenos,
            chain: cadena,
            footPegs: apoyaPies,
            mileage: kilometraje,
            fuel: combustible,
        }),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al registrar el estado');
            }
            return response.json();
        })
        .then(parsedResult => {
            if (parsedResult !== false) {
                estadoO = parsedResult.id
                pasarPestannaEstado();
                console.log("Se registró correctamente el estado");
            } else {
                $("#register-estado").removeClass("d-none");
            }
        })
        .catch(error => {
            console.error('Error al registrar el estado:', error);
            // Handle the error as needed
        });
}

//Funciona
function pasarPestannaEstado() {

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

//ZONA ORDEN de servicio
//MOTIVO 
function registrarMotivo() {
    const currentDate = new Date();
    const year = currentDate.getFullYear();
    const month = String(currentDate.getMonth() + 1).padStart(2, '0'); // Añade un 0 inicial si es necesario
    const day = String(currentDate.getDate()).padStart(2, '0'); // Añade un 0 inicial si es necesario
    const formattedDate = `${year}-${month}-${day}`;
    const mecanico = document.getElementById('Mecanico').value;
    const motivo = document.getElementById('Motivo').value;
    const documentos = Array.from(document.querySelectorAll('input[type=checkbox][name=documentos]:checked'))
        .map(el => el.value).join(", ");
    const anticipo = document.getElementById("flexSwitchCheckAnticipo").checked ? "True" : "False";
    const valorAnticipo = anticipo === 'Sí' ? document.getElementById("valAnticipo").value : 0;
    const autorizacionRuta = document.getElementById("flexSwitchCheckRuta").checked ? "True" : "False";
    const descripcionDiagnostico = $("#Dmotivo").val();

    const data = {
        motorcycle: {id: idMOtoO},
        documents: documentos,
        motorcyclePlate: placaMotoO,
        status: {id: estadoO},
        mechanic: {id: mecanico},
        date: formattedDate,
        diagnosticDesc: descripcionDiagnostico,
        reason: motivo,
        routeAuth: autorizacionRuta,
        advance: anticipo,
        advanceValue: valorAnticipo,
    };

    fetch("http://localhost:8090/motorclinic/api/service-orders", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al registrar el motivo');
            }
            return response.json();
        })
        .then(parsedResult => {
            if (parsedResult !== false) {
                idOrden = parsedResult.id;
                pasarPestannaMotivo();
                console.log("Se registró correctamente la moto");
            } else {
                $("#register-moto").removeClass("d-none");
            }
        })
        .catch(error => {
            console.error('Error al registrar el motivo:', error);
            // Manejar el error según sea necesario
        });
}

function pasarPestannaMotivo() {
    // Remueve clases y habilita pestañas para "Motivo de ingreso"
    $("#nav-motivo-tab").removeClass("active");
    $('#nav-motivo-tab').prop('aria-selected', false);
    $("#nav-motivo-tab").prop('disabled', true);
    $("#nav-motivo").removeClass("show");
    $("#nav-motivo").removeClass("active");

    // Activa y muestra pestaña "Servicios a realizar"
    $("#nav-servicio-tab").addClass("active");
    $('#nav-servicio-tab').prop('aria-selected', true);
    $("#nav-servicio-tab").prop('disabled', false);
    $("#nav-servicio").addClass("show");
    $("#nav-servicio").addClass("active");
}

//REGISTROS
function registrarRegistro() {
    const servicioSeleccionado = document.getElementById('servicios').value;
    const productoSeleccionado = document.getElementById('productos').value;
    const aprobado = document.getElementById('checkboxAprobado').checked;

    // Verificar si se han seleccionado servicio y producto
    if (servicioSeleccionado !== "No seleccionado" && productoSeleccionado !== "No seleccionado") {
        // Crear el objeto con los datos del registro
        const nuevoRegistro = {
            service: {
                idService: servicioSeleccionado
            },
            product: {
                idProduct: productoSeleccionado
            },
            order: {
                id: idOrden
            },
            approved: aprobado
        };

        // Realizar la petición POST para enviar el registro al servidor
        fetch('http://localhost:8090/motorclinic/api/records', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(nuevoRegistro)
        })
            .then(response => {
                if (response.ok) {
                    return response.json(); // Convertir la respuesta a JSON
                } else {
                    throw new Error('Error al agregar el registro');
                }
            })
            .then(data => {
                // `data` contiene el cuerpo de la respuesta en formato JSON
                const tbody = document.getElementById('tbodyMecServicios');
                const newRow = document.createElement('tr');

                newRow.innerHTML = `
        <td>${data.service.idService} ${data.service.serviceName} ${data.service.serviceValue}</td>
        <td>${data.product.idProduct} ${data.service.productName} ${data.service.productValue}</td>
        <td>${data.approved ? 'Aprobado' : 'No Aprobado'}</td>
        <td><button class="btn btn-danger btn-sm btnBorrar" data-id="${data.id}">Borrar</button></td>
    `;

                tbody.appendChild(newRow);
                console.log('Registro agregado correctamente');
            })
            .catch(error => {
                console.error('Error en la petición:', error);
            });
    }
}

function borrarRegistro(id, row) {
    fetch(`http://localhost:8090/motorclinic/api/records/${id}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (response.ok) {
                row.remove();
                console.log('Registro eliminado correctamente');
            } else {
                console.error('Error al eliminar el registro');
            }
        })
        .catch(error => {
            console.error('Error en la petición:', error);
        });
}



