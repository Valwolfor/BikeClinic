//Para llamar métodos. 
$(document).ready(function () {

    obtenerListaMoto();
    // obtenerListaOrdenes();
    obtenerListaMecanicos();
    // obtenerServicios();
    // obtenerProductos();
    // cambiarEstadoMecanico();
    datosToServicio();
    datosToProducto();


//Registrar servicio offcanvas
//     $("#form-servicio").submit(function (event) {
//         event.preventDefault();
//         registrarServicio();
//
//     });
// //Registrar producto offcanvas
//     $("#form-producto").submit(function (event) {
//         event.preventDefault();
//         registrarProducto();
//
//     });


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
    let valorProducto;

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
            actualizarProducto(idProducto, nombre, valorProducto);
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
        error: function(xhr, status, error) {
            console.log("Error al obtener la lista de motos:", error);
        }
    });
}

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
// function obtenerListaOrdenes() {
//
//     $.ajax({
//         type: "GET",
//         dataType: "html",
//         url: "./ServletOrndeListar",
//         success: function (result) {
//             let parsedResult = JSON.parse(result);
//             if (parsedResult !== false) {
//                 mostrarOrdenes(parsedResult);
//
//             } else {
//                 console.log("Hubo un problema al llamar los datos de lista Ordenes de servicio");
//             }
//         }
//     });
// }

//Entonces socio, haga lo siguiente, dos funciones llamando estado y registros(con servlets y controller
//Luego llame un par de funciones que va declarar dentro de mostrarOrdenes que setten los datos dentro de accordeons 
function mostrarOrdenes(listaOrdenes) {
    let modal = "";
    $.each(listaOrdenes, function (index, orden) {
        let ordenParsed = JSON.parse(orden);
        modal += '<article>' +
                '<!-- Scrollable modal -->' +
                '<!-- Vertically centered scrollable modal -->' +
                '<div class="cajitas modal-dialog modal-dialog-centered modal-dialog-scrollable ">' +
                '<div class="modal fade" id="' + ordenParsed.placaMoto + '" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">' +
                '<div class="modal-dialog">' +
                '<div class="modal-content">' +
                '<div class="modal-header bg-dark border-top border-start border-end border-3 ">' +
                '<h5 class="modal-title text-white" id="staticBackdropLabel"><strong>Registro de moto: </strong>' + ordenParsed.placaMoto + '</h5>' +
                '<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>' +
                '</div>' +
                '<div id="ordenes" class="ordenes modal-body border border border-3 border-dark" style="--bs-border-opacity: .8;">';
        verOrdenesPorMoto();
        function verOrdenesPorMoto() {

            $.each(listaOrdenes, function (index, ordenPorM) {
                let ordenMotoParsed = JSON.parse(ordenPorM);
                //solo poner las ordenes de está moto.
                if (ordenMotoParsed.placaMoto === ordenParsed.placaMoto) {

                    //Cambié de lugar el h2 y el button
                    modal += '<!--AQUÍ inician los accordeon-->' +
                            '<div class="accordion accordion-flush" id="accordionFlushOrdenes">' +
                            '<div class="accordion-item">' +
                            '<h2 class="accordion-header" id="flush-heading-' + ordenMotoParsed.idOrden + '">' +
                            '<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse-' + ordenMotoParsed.idOrden + '" aria-expanded="false" aria-controls="flush-collapse-' + ordenMotoParsed.idOrden + '">' +
                            '<strong>Ordén de Servicio:  #</strong>' + ordenMotoParsed.idOrden +
                            '</button>' +
                            '</h2>' +
                            '<div id="flush-collapse-' + ordenMotoParsed.idOrden + '" class="accordion-collapse collapse" aria-labelledby="flush-heading-' + ordenMotoParsed.idOrden + '" data-bs-parent="#accordionFlushOrdenes">' +
                            '<div class="accordion-body">' +
                            '<ul class="list-group list-group-flush">' +
                            '<li class="list-group-item"><strong>Fecha de ingreso:  </strong>' + ordenMotoParsed.date + '</li>' +
                            '<li class="list-group-item"><strong>Motivo de ingreso:  </strong>' + ordenMotoParsed.motivo + '</li>' +
                            '<li class="list-group-item"><strong>Diagnóstico:  </strong>' + ordenMotoParsed.descripcionDiagnostico + '</li>' +
                            '<li class="list-group-item"><strong>Documentos en resguardo:  </strong>' + ordenMotoParsed.documentos + '</li>' +
                            '<li class="list-group-item"><strong>Realiza anticipo:  </strong>' + ordenMotoParsed.anticipo + '</li>' +
                            '<li class="list-group-item"><strong>Valor anticipo:  </strong>$' + ordenMotoParsed.valorAnticipo + '</li>' +
                            '<li id="orden-' + ordenMotoParsed.idOrden + '"class="orden-' + ordenMotoParsed.idOrden + ' list-group-item"><strong>Autorización prueba de ruta:  </strong>' + ordenMotoParsed.autorizacionRuta + '</li>' +
                            '<li id="orden-registro-' + ordenMotoParsed.idOrden + '"class="orden-registro-' + ordenMotoParsed.idOrden + ' list-group-item"><strong>Servicios y productos por Orden</strong></li>' +
                            '<!--Cierra inicio de modal-->' +
                            '</ul>' +
                            '</div>' +
                            '</div>' +
                            '</div>' +
                            '</div>';
                } //termina if ordenes
            });
        }
        //termina el acordeon y el modal.
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


// function cambiarEstadoMecanico() {
//
//     //Para cambiar el estado en la interfaz cuando se da clic en el switch button
//     $(document).on('change', '#estado-mecanico', function (event) {
//         event.preventDefault();
//         let idUsuario = $(this).parent().parent().parent().children().first().text();
//         let estado = $(this).parent().parent().parent().children().last().text();
//         if (estado.trim() === 'Activo') {
//             estado = 'Inactivo';
//         } else {
//             estado = 'Activo';
//         }
//
//         $.ajax({
//             type: "GET",
//             dataType: "html",
//             url: "./ServletMecanicoModificarEstado",
//             data: $.param({
//                 idUsuario: idUsuario,
//                 estado: estado
//             }),
//             success: function (result) {
//                 let parsedResult = JSON.parse(result);
//                 if (parsedResult !== false) {
//                     console.log("Funciona success");
//                     obtenerListaMecanicos();
//                 } else {
//                     console.log("Hubo un problema al cambiar estado mecánicos JS");
//                 }
//             }
//         });
//     });
// }

//Servicios
// function registrarServicio() {
//
//     let nombreServicio = $("#nameServicio").val();
//     let detalleServicio = $("#desServicio").val();
//     let valorServicio = $("#valServicio").val();

    // $.ajax({
    //     type: "GET",
    //     dataType: "html",
    //     url: "./ServletServicioRegistrar",
    //     data: $.param({
    //         nombreServicio: nombreServicio,
    //         detalleServicio: detalleServicio,
    //         valorServicio: valorServicio
    //     }),
    //     success: function (result) {
    //         let parsedResult = JSON.parse(result);
    //         if (parsedResult !== false) {
    //             $("#register-success-ser").removeClass("d-none");
    //
    //         } else {
    //             $("#register-error-ser").removeClass("d-none");
    //         }
    //     }
    // });
// }


// function obtenerServicios() {

    // $.ajax({
    //     type: "GET",
    //     dataType: "html",
    //     url: "./ServletServiciosListar",
    //     success: function (result) {
    //         let parsedResult = JSON.parse(result);
    //         if (parsedResult !== false) {
    //             mostrarServicios(parsedResult);
    //
    //         } else {
    //             console.log("Hubo un problema al llamar los datos de lista servicios");
    //         }
    //     }
    // });
// }


function mostrarServicios(listaServicios) {

    let tabla = "";
    $.each(listaServicios, function (index, servicio) {

        servicioParsed = JSON.parse(servicio);
        tabla += '<tr>' +
                '<td>' + servicioParsed.idServicio + '</td>' +
                '<td>' + servicioParsed.nombreServicio + '</td>' +
                '<td>' + servicioParsed.detalleServicio + '</td>' +
                '<td>' + servicioParsed.valorServicio + '</td>' +
                '<td><button value="actualizar" title="actualizar" class="btn btn-primary btn-edit-servicio" id="btn-edit-servicio">Actualizar</button></td>' +
                '</tr>';
    });

    $('#tbodyServicios').html(tabla);
}


//todo tooodoo
// function actualizarServicio(idServicio, nombreServicio, detalleServicio, valorServicio) {
// ///revisar este tema del boton
//
//     $.ajax({
    //     type: "GET",
    //     dataType: "html",
    //     url: "./ServletServicioActualizar",
    //     data: $.param({
    //         idServicio: idServicio,
    //         nombreServicio: nombreServicio,
    //         detalleServicio: detalleServicio,
    //         valorServicio: valorServicio
    //     }),
    //     success: function (result) {
    //         let parsedResult = JSON.parse(result);
    //         if (parsedResult !== false) {
    //             $("#register-success-serAc").removeClass("d-none");
    //             $('#form-servicio-actualizar').addClass('d-none');
    //             console.log("actualización de servicio correcta");
    //             obtenerServicios();
    //         } else {
    //             $("#register-error-serAc").removeClass("d-none");
    //             console.log("Hubo un problema al actualizar los datos del servicio: " + idServicio);
    //         }
    //     }
    // });
// }

//Productos
// function registrarProducto() {
//
//     let nombre = $("#nameProducto").val();
    // let valorProducto = $("#valProducto").val();
    // $.ajax({
    //     type: "GET",
    //     dataType: "html",
    //     url: "./ServletProductoRegistrar",
    //     data: $.param({
    //         nombre: nombre,
    //         valorProducto: valorProducto
    //     }),
    //     success: function (result) {
    //         let parsedResult = JSON.parse(result);
    //         if (parsedResult !== false) {
    //             $("#register-success-pro").removeClass("d-none");
    //         } else {
    //             $("#register-error-pro").removeClass("d-none");
    //         }
    //     }
    // });
// }


// function obtenerProductos() {

    // $.ajax({
    //     type: "GET",
    //     dataType: "html",
    //     url: "./ServletProductosListar",
    //     success: function (result) {
    //         let parsedResult = JSON.parse(result);
    //         if (parsedResult !== false) {
    //             mostrarProductos(parsedResult);
    //
    //         } else {
    //             console.log("Hubo un problema al llamar los datos de lista productos");
    //         }
    //     }
    // });
// }


function mostrarProductos(listaProductos) {

    let tabla = "";
    $.each(listaProductos, function (index, producto) {

        productoParsed = JSON.parse(producto);
        tabla += '<tr>' +
                '<td>' + productoParsed.idProducto + '</td>' +
                '<td>' + productoParsed.nombre + '</td>' +
                '<td>' + productoParsed.valorProducto + '</td>' +
                '<td><button value="actualizar" title="actualizar" class="btn btn-primary btn-edit-producto" id="btn-edit-servicio">Actualizar</button></td>' +
                '</tr>';
    });

    $('#tbodyProductos').html(tabla);
}

//todoooo todooo
// function actualizarProducto(idProducto, nombre,  valorProducto) {

// $.ajax({
//         type: "GET",
//         dataType: "html",
//         url: "./ServletProductoActualizar",
//         data: $.param({
//             idProducto: idProducto,
//             nombre: nombre,
//             valorProducto: valorProducto
//         }),
//         success: function (result) {
//             let parsedResult = JSON.parse(result);
//             if (parsedResult !== false) {
//                 $("#register-success-proAc").removeClass("d-none");
//                 $('#form-producto-actualizar').addClass('d-none');
//                 console.log("actualización de producto correcta");
//                 obtenerProductos();
//             } else {
//                 $("#register-error-proAc").removeClass("d-none");
//                 console.log("Hubo un problema al actualizar los datos del producto: " + idServicio);
//             }
//         }
//     });
// }