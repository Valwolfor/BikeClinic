//Para llamar métodos. 
$(document).ready(function () {

    obtenerListaMoto();
    obtenerListaOrdenes();
    obtenerListaMecanicos();
    obtenerServicios();
    obtenerProductos();
    cambiarEstadoMecanico();
    datosToServicio();
    datosToProducto();
    // obtenerListaRegistros();


// Registrar servicio offcanvas
    $("#form-servicio").submit(function (event) {
        event.preventDefault();
        registrarServicio();

    });
// //Registrar producto offcanvas
    $("#form-producto").submit(function (event) {
        event.preventDefault();
        registrarProducto();

    });

});


function datosToServicio() {
    let idServicio;
    let nombreServicio;
    let valorServicio;

    $(document).on('click', '.btn-edit-servicio', function (event) {
        event.preventDefault();
        idServicio = $(this).parent().parent().children().first().text();
        nombreServicio = $(this).parent().parent().children().first().next().text();
        detalleServicio = $(this).parent().parent().children().first().next().next().text();
        valorServicio = $(this).parent().parent().children().first().next().next().next().text();
        console.log($(this).parent().parent().children().first().text());

        $('#form-servicio-actualizar').removeClass('d-none');

        $('#idLblServicioAc').val(idServicio);
        $('#nameServicioAc').val(nombreServicio);
        $('#desServicioAc').val(detalleServicio);
        $('#valServicioAc').val(valorServicio);

        $(document).on('click', '#btnActServicioAc', function (event) {
            event.preventDefault();
            console.log(document.getElementById("idLblServicioAc").value);
            idServicio = document.getElementById("idLblServicioAc").value;
            nombreServicio = document.getElementById("nameServicioAc").value;
            detalleServicio = document.getElementById("desServicioAc").value;
            valorServicio = document.getElementById("valServicioAc").value;

            actualizarServicio(idServicio, nombreServicio, detalleServicio, valorServicio);
            $('#form-servicio-actualizar').addClass('d-none');

            console.log($(this).parent().parent().children().first().text());
        });
    });
}

//Actualizar botón
function datosToProducto() {
    let idProducto;
    let nombre;
    let valorProducto, canProducto;

    $(document).on('click', '.btn-edit-producto', function (event) {
        event.preventDefault();
        idProducto = $(this).parent().parent().children().first().text();
        nombre = $(this).parent().parent().children().first().next().text();
        valorProducto = $(this).parent().parent().children().first().next().next().text();
        console.log($(this).parent().parent().children().first().text());

        $('#form-producto-actualizar').removeClass('d-none');

        $('#idLblProductoAc').val(idProducto);
        $('#nameProductoAc').val(nombre);
        $('#valProductoAc').val(valorProducto);

        $(document).on('click', '#btnActProductoAc', function (event) {
            event.preventDefault();
            console.log(document.getElementById("idLblProductoAc").value);
            idProducto = document.getElementById("idLblProductoAc").value;
            nombre = document.getElementById("nameProductoAc").value;
            valorProducto = document.getElementById("valProductoAc").value;
            canProducto = document.getElementById("canProductoAc").value;
            actualizarProducto(idProducto, nombre, valorProducto, canProducto);
            $('#form-producto-actualizar').addClass('d-none');

            console.log($(this).parent().parent().children().first().text());
        });
    });
}

//Mecáncos
function obtenerListaMecanicos() {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://localhost:8090/motorclinic/api/users/by-role?role=MECHANIC",
        success: function (result) {
            if (result !== false) {
                mostrarMecanicos(result);
            } else {
                console.log("Hubo un problema al llamar los datos de lista mecánicos");
            }
        },
        error: function (xhr, status, error) {
            console.log("Error al obtener los datos de lista mecánicos:", error);
        }
    });
}


function mostrarMecanicos(listaMecanicos) {
    let tabla = "";
    listaMecanicos.forEach(mecanico => {
        tabla += `<tr>
            <td>${mecanico.id}</td>
            <td>${mecanico.firstName} ${mecanico.lastName}</td>
            <td>${mecanico.email}</td>
            <td>${mecanico.contactNumber}</td>
            <td>
                <div class="form-check form-switch">
                    <input class="form-check-input" type="checkbox" role="switch" id="estado-mecanico" ${mecanico.status === "ACTIVE" ? 'checked' : ''}>
                    <label class="form-check-label" for="estado-mecanico">${mecanico.status}</label>
                </div>
            </td>
        </tr>`;
    });

    $('#tbody').html(tabla);
}

// Motos
function obtenerListaMoto() {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://localhost:8090/motorclinic/api/motorcycles",
        success: function (result) {
            if (result !== false) {
                mostrarMotos(result);
            } else {
                console.log("Hubo un problema al llamar los datos de lista HVmotos");
            }
        },
        error: function (xhr, status, error) {
            console.log("Error al obtener la lista de motos:", error);
        }
    });
}

// TODO: limitar ancho a cierta altura, luego scroll
function mostrarMotos(listaMotos) {
    let tarjeta = "";

    $.each(listaMotos, function (index, moto) {
        tarjeta += '<article class="m-2 ">' +
            '<div class="container col-4 ">' +
            '<div class="card" style="width: 17rem;">' +
            '<img src="./img/moto.jpg" class="card-img-top" alt="logo-moto">' +
            '<div class="card-body bg-dark rounded">' +
            '<h5 class="card-title text-white">' + moto.plate + '</h5>' +
            '<p class="card-text text-white">' + moto.brand + ' ' + moto.model + '</p>' +
            '</div>' +
            '<ul class="list-group list-group-flush">' +
            '<li class="list-group-item">' + '<strong>ID Cliente:</strong> ' + moto.customer.id + '</li>' +
            '<li class="list-group-item">' + '<strong>Nombre:</strong> ' + moto.customer.firstName + ' ' + moto.customer.lastName + '</li>' +
            '<li class="list-group-item">' + '<strong>Año modelo:</strong> ' + moto.registrationYear + '</li>' +
            '</ul>' +
            '<div class="card-body text-center">' +
            '<button type="button" class="activar-modal btn btn-dark" data-bs-toggle="modal" data-bs-target="#' + moto.plate + '">' +
            'Ver ordenes de servicio' +
            '</button>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</article>';
    });

    $('.tarjetero').html(tarjeta);
}


//Ordenes de servicio
function obtenerListaOrdenes() {
    fetch('http://localhost:8090/motorclinic/api/service-orders', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Hubo un problema al llamar los datos de lista Ordenes de servicio');
            }
            return response.json();
        })
        .then(parsedResult => {
            if (parsedResult !== false) {
                mostrarOrdenes(parsedResult);
                console.log(parsedResult)
            } else {
                console.log('No se recibieron datos válidos de la lista de órdenes de servicio');
            }
        })
        .catch(error => {
            console.error('Error al obtener la lista de órdenes de servicio:', error);
        });
}


// Entonces socio, haga lo siguiente, dos funciones llamando estado y registros(con servlets y controller
// Luego llame un par de funciones que va declarar dentro de mostrarOrdenes que setten los datos dentro de accordeons
function mostrarOrdenes(listaOrdenes) {
    let modal = "";
    $.each(listaOrdenes, function (index, orden) {

        modal += '<article>' +
            '<!-- Scrollable modal -->' +
            '<!-- Vertically centered scrollable modal -->' +
            '<div class="cajitas modal-dialog modal-dialog-centered modal-dialog-scrollable ">' +
            '<div class="modal fade" id="' + orden.motorcycle.plate + '" data-bs-backdrop="static" data-bs-keyboard="false" ' +
            'tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">' +
            '<div class="modal-dialog">' +
            '<div class="modal-content">' +
            '<div class="modal-header bg-dark border-top border-start border-end border-3 ">' +
            '<h5 class="modal-title text-white" id="staticBackdropLabel"><strong>Registro de moto: </strong>' +
            orden.motorcycle.plate + '</h5>' +
            '<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>' +
            '</div>' +
            '<div id="ordenes" class="ordenes modal-body border border border-3 border-dark" style="--bs-border-opacity: .8;">';
        verOrdenesPorMoto();

        function verOrdenesPorMoto() {
            $.each(listaOrdenes, function (index, ordenPorM) {

                if (ordenPorM.motorcycle.plate === orden.motorcycle.plate) {
                    modal += '<!--AQUÍ inician los accordeon-->' +
                        '<div class="accordion accordion-flush" id="accordionFlushOrdenes">' +
                        '<div class="accordion-item">' +
                        '<h2 class="accordion-header" id="flush-heading-' + ordenPorM.id + '">' +
                        '<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse-' +
                        ordenPorM.id + '" aria-expanded="false" aria-controls="flush-collapse-' + ordenPorM.id + '">' +
                        '<strong>Ordén de Servicio:  #</strong>' + ordenPorM.id +
                        '</button>' +
                        '</h2>' +
                        '<div id="flush-collapse-' + ordenPorM.id + '" class="accordion-collapse collapse" aria-labelledby="flush-heading-' +
                        ordenPorM.id + '" data-bs-parent="#accordionFlushOrdenes">' +
                        '<div class="accordion-body">' +
                        '<ul class="list-group list-group-flush">' +
                        '<li class="list-group-item"><strong>Fecha de ingreso:  </strong>' + ordenPorM.date + '</li>' +
                        '<li class="list-group-item"><strong>Motivo de ingreso:  </strong>' + ordenPorM.reason + '</li>' +
                        '<li class="list-group-item"><strong>Diagnóstico:  </strong>' + ordenPorM.diagnosticDesc + '</li>' +
                        '<li class="list-group-item"><strong>Documentos en resguardo:  </strong>' + ordenPorM.documents + '</li>' +
                        '<li class="list-group-item"><strong>Realiza anticipo:  </strong>' + ordenPorM.advance + '</li>' +
                        '<li class="list-group-item"><strong>Valor anticipo:  </strong>$' + ordenPorM.advanceValue + '</li>' +
                        '<li id="orden-' + ordenPorM.id + '"class="orden-' + ordenPorM.id + ' list-group-item">' +
                        '<strong>Autorización prueba de ruta:  </strong>' + ordenPorM.routeAuth + '</li>' +
                        '<li id="orden-registro-' + ordenPorM.id + '"class="orden-registro-' + ordenPorM.id +
                        ' list-group-item"><strong>Servicios y productos por Orden</strong></li>' +
                        '</ul>' +
                        '</div>' +
                        '</div>' +
                        '</div>' +
                        '</div>';
                }

            });
            // mostrarEstado(listaOrdenes)

        }

        modal += '<div class="modal-footer mb-3">' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</article>';
    });
    $('.modale').html(modal);
}
//
// function mostrarEstado(listaOrdenes) {
//     let accordeon = "";
//
//     //moto es en realidad el id de la orden.
//     $.each(listaOrdenes, function (index, estado) {
// //
//         accordeon += '<div class="accordion accordion-flush" id="accordionFlushEstados">' +
//             '<div class="accordion-item">' +
//             '<h2 class="accordion-header" id="flush-heading-estados-' + estado.status.id + '">' +
//             '<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse-estados-' +
//             estado.id + '" aria-expanded="false" aria-controls="flush-collapse-estados-' + estado.status.id + '">' +
//             '<strong>Estado:  #</strong> ' + estado.status.id + ' de la orden: ' + estado.id +
//             '</button>' +
//             '</h2>' +
//             '<div id="flush-collapse-estados-' + estado.status.id + '" class="accordion-collapse collapse" aria-labelledby="flush-heading-estados-' +
//             estado.status.id + '" data-bs-parent="#accordionFlushEstados">';
//         verEstadosPorOrden();
//
//         function verEstadosPorOrden() {
//             $.each(listaOrdenes, function (index, estadoPorO) {
//
//                 //solo poner las ordenes de está moto.
//                 if (estadoPorO.id === estado.id) {
//                     accordeon += '<div class="accordion-body">' +
//                         '<ul class="list-group list-group">' +
//                         '<li class="list-group-item"><strong>Kilometraje:  </strong>' + estadoPorO.mileage + '</li>' +
//                         '<li class="list-group-item"><strong>Indicadores:  </strong>' + estadoPorO.indicators + '</li>' +
//                         '<li class="list-group-item"><strong>Detalle indicadores:  </strong>' + estadoPorO.indicatorsDesc + '</li>' +
//                         '</ul>' +
//                         '<ul class="list-group list-group">' +
//                         '<li class="list-group-item"><strong>Aceite:  </strong>' + estadoPorO.oil + '</li>' +
//                         '<li class="list-group-item"><strong>Nivel aceite:  </strong>' + estadoPorO.oilLevel + '</li>' +
//                         '<li class="list-group-item"><strong>Nivel de combustible  </strong>$' + estadoPorO.fuel + '</li>' +
//                         '</ul>' +
//                         '<ul class="list-group list-group">' +
//                         '<li class="list-group-item"><strong>Liquido de frenos:  </strong>' + estadoPorO.brakeFluid + '</li>' +
//                         '<li class="list-group-item"><strong>Liquido de embrague:  </strong>' + estadoPorO.clutchFluid + '</li>' +
//                         '<li class="list-group-item"><strong>Liquido refrigerante:  </strong>' + estadoPorO.coolant + '</li>' +
//                         '</ul>' +
//                         '<ul class="list-group list-group">' +
//                         '<li class="list-group-item"><strong>Luces:  </strong>' + estadoPorO.lightsGood + '</li>' +
//                         '<li class="list-group-item"><strong>Espejos:  </strong>' + estadoPorO.mirrors + '</li>' +
//                         '<li class="list-group-item"><strong>Claxon:  </strong>' + estadoPorO.horn + '</li>' +
//                         '</ul>' +
//                         '<ul class="list-group list-group">' +
//                         '<li class="list-group-item"><strong>Tanque:  </strong>' + estadoPorO.tank + '</li>' +
//                         '<li class="list-group-item"><strong>Llanta delantera:  </strong>' + estadoPorO.frontTire + '</li>' +
//                         '<li class="list-group-item"><strong>Llanta trasera:  </strong>' + estadoPorO.rearTire + '</li>' +
//                         '</ul>' +
//                         '</ul>' +
//                         '<ul class="list-group list-group">' +
//                         '<li class="list-group-item"><strong>Motor:  </strong>' + estadoPorO.engine + '</li>' +
//                         '<li class="list-group-item"><strong>Chasis:  </strong>' + estadoPorO.chassis + '</li>' +
//                         '<li class="list-group-item"><strong>Acelerador:  </strong>' + estadoPorO.throttle + '</li>' +
//                         '</ul>' +
//                         '</ul>' +
//                         '<ul class="list-group list-group">' +
//                         '<li class="list-group-item"><strong>Escape:  </strong>' + estadoPorO.exhaust + '</li>' +
//                         '<li class="list-group-item"><strong>Trasmisión:  </strong>' + estadoPorO.transmission + '</li>' +
//                         '<li class="list-group-item"><strong>Embrague:  </strong>' + estadoPorO.clutch + '</li>' +
//                         '</ul>' +
//                         '<ul class="list-group list-group">' +
//                         '<li class="list-group-item"><strong>Frenos:  </strong>' + estadoPorO.brakes + '</li>' +
//                         '<li class="list-group-item"><strong>Cadena:  </strong>' + estadoPorO.chain + '</li>' +
//                         '<li class="list-group-item"><strong>Apoya pies:  </strong>' + estadoPorO.footPegs + '</li>' +
//                         '</ul>' +
//                         '</div>' +
//                         '</div>' +
//                         '</div>' +
//                         '</div>';
//
//                     try {
//                         clase = ".orden-" + estadoPorO.id;
//                         $(clase).html(accordeon);
//                     } catch (e) {
//                         console.log(e);
//                     }
//                 } //termina if estados por ordenes
//             });//foreach
//             accordeon = "";
//         }
//     });
// }

// function obtenerListaRegistros() {
//     fetch('http://localhost:8090/motorclinic/api/records', {
//         method: 'GET',
//         headers: {
//             'Content-Type': 'application/json'
//         }
//     })
//         .then(response => {
//             if (!response.ok) {
//                 console.log(response)
//                 throw new Error('Hubo un problema al llamar los datos de lista registros producto-servicio');
//             }
//             return response.json();
//         })
//         .then(parsedResultRegistros => {
//             if (parsedResultRegistros !== false) {
//                 mostrarRegistro(parsedResultRegistros);
//             } else {
//                 console.log('No se recibieron datos válidos de la lista de registros producto-servicio');
//             }
//         })
//         .catch(error => {
//             console.error('Error al obtener la lista de registros producto-servicio:', error);
//         });
// }


// function mostrarRegistro(listaRegistros) {
//     let accordeonR = "";
//     //moto es en realidad el id de la orden.
//     $.each(listaRegistros, function (index, registro) {
//
//         accordeonR += '<div class="cajitas ">' +
//             '<div id="ordenes" class="ordenes modal-body border border border-3 border-dark" style="--bs-border-opacity: .4;">' +
//             '<strong> Registros de la orden</strong>';
//
//         verRegistrosPorOrden();
//
//         function verRegistrosPorOrden() {
//             $.each(listaRegistros, function (index, registroPorO) {
//
//                 //solo poner las ordenes de está moto.
//                 if (registroPorO.order.id === registro.order.id) {
//                     accordeonR += '<div class="accordion accordion-flush" id="accordionFlushRegistros">' +
//                         '<div class="accordion-item">' +
//                         '<h2 class="accordion-header" id="flush-heading-registros-' + registroPorO.id + '">' +
//                         '<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse-registros-' +
//                         registroPorO.id + '" aria-expanded="false" aria-controls="flush-collapse-registros-' +
//                         registroPorO.id + '">' +
//                         '<strong>Registro:  #</strong> ' + registroPorO.id + ' de la orden: ' + registroPorO.order.id +
//                         '</button>' +
//                         '</h2>' +
//                         '<div id="flush-collapse-registros-' + registroPorO.id + '" class="accordion-collapse collapse" ' +
//                         'aria-labelledby="flush-heading-registros-' + registroPorO.id + '" data-bs-parent="#accordionFlushRegistros">' +
//                         '<div class="accordion-body">' +
//                         '<ul class="list-group list-group">' +
//                         '<li class="list-group-item"><strong>Producto:  </strong>' + registroPorO.product.productName + '</li>' +
//                         '<li class="list-group-item"><strong>Valor producto:  </strong>' + registroPorO.product.productValue + '</li>' +
//                         '<li class="list-group-item"><strong>Detalle Servicio:  </strong>' + registroPorO.service.serviceName + '</li>' +
//                         '</ul>' +
//                         '<ul class="list-group list-group">' +
//                         '<li class="list-group-item"><strong>Detalle servicio:  </strong>' + registroPorO.service.serviceDetail + '</li>' +
//                         '<li class="list-group-item"><strong>Valor servicio:  </strong>' + registroPorO.service.serviceValue + '</li>' +
//                         '<li class="list-group-item"><strong>Aprobado por cliente.  </strong>$' + registroPorO.approved + '</li>' +
//                         '</ul>' +
//                         '</div>' +
//                         '</div>' +
//                         '</div>' +
//                         '</div>';
//
//                 } //termina if estados por ordenes
//             });//foreach
//         }
//
//         accordeonR += '</div>';
//         try {
//             clase = ".orden-registro-" + registroPorO.order.id;
//             $(clase).html(accordeonR);
//         } catch (e) {
//             console.log(e);
//         }
//         accordeonR = "";
//     });
// }

function cambiarEstadoMecanico() {
    // Para cambiar el estado en la interfaz cuando se da clic en el switch button
    $(document).on('change', '#estado-mecanico', function (event) {
        event.preventDefault();
        let idUsuario = $(this).parent().parent().parent().children().first().text();
        let estado = $(this).parent().parent().parent().children().last().text();
        if (estado.trim() === 'ACTIVE') {
            estado = 'INACTIVE';
        } else {
            estado = 'ACTIVE';
        }

        fetch(`http://localhost:8090/motorclinic/api/users/${idUsuario}/change-status`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                status: estado
            })
        })
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error('Error al cambiar el estado del mecánico');
                }
            })
            .then(result => {
                if (result !== false) {
                    console.log("Funciona success");
                    obtenerListaMecanicos();
                } else {
                    console.log("Hubo un problema al cambiar estado mecánicos JS");
                }
            })
            .catch(error => {
                console.error('Error en la solicitud fetch:', error);
            });
    });
}

// Servicios
function registrarServicio() {
    let nombreServicio = $("#nameServicio").val();
    let detalleServicio = $("#desServicio").val();
    let valorServicio = $("#valServicio").val();

    fetch('http://localhost:8090/motorclinic/api/services', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            serviceName: nombreServicio,
            serviceDetail: detalleServicio,
            serviceValue: valorServicio
        })
    })
        .then(response => response.json())
        .then(parsedResult => {
            if (parsedResult !== false) {
                $("#register-success-ser").removeClass("d-none");
                obtenerServicios();
                location.reload();
            } else {
                $("#register-error-ser").removeClass("d-none");
            }
        })
        .catch(error => {
            console.error('Error al registrar el servicio:', error);
            // Manejar el error aquí si es necesario
        });
}


function obtenerServicios() {

    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://localhost:8090/motorclinic/api/services",
        success: function (result) {
            if (result !== false) {
                mostrarServicios(result);

            } else {
                console.log("Hubo un problema al llamar los datos de lista servicios");
            }
        }
    });
}

function mostrarServicios(listaServicios) {

    let tabla = "";
    $.each(listaServicios, function (index, servicio) {

        tabla += '<tr>' +
            '<td>' + servicio.idService + '</td>' +
            '<td>' + servicio.serviceName + '</td>' +
            '<td>' + servicio.serviceDetail + '</td>' +
            '<td>' + servicio.serviceValue + '</td>' +
            '<td><button value="actualizar" title="actualizar" class="btn btn-primary btn-edit-servicio" id="btn-edit-servicio">Actualizar</button></td>' +
            '</tr>';
    });

    $('#tbodyServicios').html(tabla);
}


function actualizarServicio(idServicio, nombreServicio, detalleServicio, valorServicio) {
    fetch(`http://localhost:8090/motorclinic/api/services/${idServicio}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            idService: idServicio,
            serviceName: nombreServicio,
            serviceDetail: detalleServicio,
            serviceValue: valorServicio
        })
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Error al actualizar el servicio');
            }
        })
        .then(result => {
            if (result !== false) {
                $("#register-success-serAc").removeClass("d-none");
                $('#form-servicio-actualizar').addClass('d-none');
                console.log("actualización de servicio correcta");
                obtenerServicios();
            } else {
                $("#register-error-serAc").removeClass("d-none");
                console.log("Hubo un problema al actualizar los datos del servicio: " + idServicio);
            }
        })
        .catch(error => {
            console.error('Error en la solicitud fetch:', error);
        });
}


//Productos
function registrarProducto() {
    let nombre = $("#nameProducto").val();
    let valorProducto = $("#valProducto").val();
    let canProducto = $("#canProducto").val();

    fetch('http://localhost:8090/motorclinic/api/products', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            productName: nombre,
            productValue: valorProducto,
            quantity: canProducto
        })
    })
        .then(response => response.json())
        .then(parsedResult => {
            if (parsedResult !== false) {
                $("#register-success-pro").removeClass("d-none");
                obtenerProductos();
                location.reload();
            } else {
                $("#register-error-pro").removeClass("d-none");
            }
        })
        .catch(error => {
            console.error('Error al registrar el producto:', error);
            // Manejar el error aquí si es necesario
        });
}


function obtenerProductos() {

    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://localhost:8090/motorclinic/api/products",
        success: function (result) {

            if (result !== false) {
                mostrarProductos(result);

            } else {
                console.log("Hubo un problema al llamar los datos de lista productos");
            }
        }
    });
}


function mostrarProductos(listaProductos) {

    let tabla = "";
    $.each(listaProductos, function (index, producto) {

        tabla += '<tr>' +
            '<td>' + producto.idProduct + '</td>' +
            '<td>' + producto.productName + '</td>' +
            '<td>' + producto.productValue + '</td>' +
            '<td>' + producto.quantity + '</td>' +
            '<td><button value="actualizar" title="actualizar" class="btn btn-primary btn-edit-producto" id="btn-edit-servicio">Actualizar</button></td>' +
            '</tr>';
    });

    $('#tbodyProductos').html(tabla);
}

//todoooo todooo
function actualizarProducto(idProducto, nombre, valorProducto, canProducto) {
    fetch(`http://localhost:8090/motorclinic/api/products/${idProducto}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            productName: nombre,
            productValue: valorProducto,
            quantity: canProducto
        })
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Error al actualizar el producto');
            }
        })
        .then(result => {
            if (result !== false) {
                $("#register-success-proAc").removeClass("d-none");
                $('#form-producto-actualizar').addClass('d-none');
                console.log("actualización de producto correcta");
                obtenerProductos();
            } else {
                $("#register-error-proAc").removeClass("d-none");
                console.log("Hubo un problema al actualizar los datos del producto: " + idProducto);
            }
        })
        .catch(error => {
            console.error('Error en la solicitud fetch:', error);
        });
}
