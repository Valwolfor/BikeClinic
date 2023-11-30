// //Para llamar métodos.

$(document).ready(function () {

    obtenerListaEstados();
    obtenerListaRegistros();

});

// //Estados
function obtenerListaEstados() {
    fetch('http://localhost:8090/motorclinic/api/service-orders', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Hubo un problema al llamar los datos de lista Estados (ordenes)');
            }
            return response.json();
        })
        .then(parsedResult => {
            if (parsedResult !== false) {
                mostrarEstado(parsedResult);
            } else {
                console.log('No se recibieron datos válidos de la lista de estados (ordenes)');
            }
        })
        .catch(error => {
            console.error('Error al obtener la lista de estados (ordenes):', error);
        });
}

//
function mostrarEstado(listaEstados) {
    let accordeon = "";

    //moto es en realidad el id de la orden.
    $.each(listaEstados, function (index, estado) {
//
        accordeon += '<div class="accordion accordion-flush" id="accordionFlushEstados">' +
            '<div class="accordion-item">' +
            '<h2 class="accordion-header" id="flush-heading-estados-' + estado.status.id + '">' +
            '<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse-estados-' +
            estado.status.id + '" aria-expanded="false" aria-controls="flush-collapse-estados-' + estado.status.id + '">' +
            '<strong>Estado:  #</strong> ' + estado.status.id + ' de la orden: ' + estado.id +
            '</button>' +
            '</h2>' +
            '<div id="flush-collapse-estados-' + estado.status.id + '" class="accordion-collapse collapse" aria-labelledby="flush-heading-estados-' +
            estado.status.id + '" data-bs-parent="#accordionFlushEstados">';
        verEstadosPorOrden();

        function verEstadosPorOrden() {
            $.each(listaEstados, function (index, estadoPorO) {

                //solo poner las ordenes de está moto.
                if (estadoPorO.id === estado.id) {
                    accordeon += '<div class="accordion-body">' +
                        '<ul class="list-group list-group">' +
                        '<li class="list-group-item"><strong>Kilometraje:  </strong>' + estado.status.mileage + '</li>' +
                        '<li class="list-group-item"><strong>Indicadores:  </strong>' + estado.status.indicators + '</li>' +
                        '<li class="list-group-item"><strong>Detalle indicadores:  </strong>' + estado.status.indicatorsDesc + '</li>' +
                        '</ul>' +
                        '<ul class="list-group list-group">' +
                        '<li class="list-group-item"><strong>Aceite:  </strong>' + estado.status.oil + '</li>' +
                        '<li class="list-group-item"><strong>Nivel aceite:  </strong>' + estado.status.oilLevel + '</li>' +
                        '<li class="list-group-item"><strong>Nivel de combustible  </strong>' + estado.status.fuel + '</li>' +
                        '</ul>' +
                        '<ul class="list-group list-group">' +
                        '<li class="list-group-item"><strong>Liquido de frenos:  </strong>' + estado.status.brakeFluid + '</li>' +
                        '<li class="list-group-item"><strong>Liquido de embrague:  </strong>' + estado.status.clutchFluid + '</li>' +
                        '<li class="list-group-item"><strong>Liquido refrigerante:  </strong>' + estado.status.coolant + '</li>' +
                        '</ul>' +
                        '<ul class="list-group list-group">' +
                        '<li class="list-group-item"><strong>Luces:  </strong>' + estado.status.lightsGood + '</li>' +
                        '<li class="list-group-item"><strong>Espejos:  </strong>' + estado.status.mirrors + '</li>' +
                        '<li class="list-group-item"><strong>Claxon:  </strong>' + estado.status.horn + '</li>' +
                        '</ul>' +
                        '<ul class="list-group list-group">' +
                        '<li class="list-group-item"><strong>Tanque:  </strong>' + estado.status.tank + '</li>' +
                        '<li class="list-group-item"><strong>Llanta delantera:  </strong>' + estado.status.frontTire + '</li>' +
                        '<li class="list-group-item"><strong>Llanta trasera:  </strong>' + estado.status.rearTire + '</li>' +
                        '</ul>' +
                        '</ul>' +
                        '<ul class="list-group list-group">' +
                        '<li class="list-group-item"><strong>Motor:  </strong>' + estado.status.engine + '</li>' +
                        '<li class="list-group-item"><strong>Chasis:  </strong>' + estado.status.chassis + '</li>' +
                        '<li class="list-group-item"><strong>Acelerador:  </strong>' + estado.status.throttle + '</li>' +
                        '</ul>' +
                        '</ul>' +
                        '<ul class="list-group list-group">' +
                        '<li class="list-group-item"><strong>Escape:  </strong>' + estado.status.exhaust + '</li>' +
                        '<li class="list-group-item"><strong>Trasmisión:  </strong>' + estado.status.transmission + '</li>' +
                        '<li class="list-group-item"><strong>Embrague:  </strong>' + estado.status.clutch + '</li>' +
                        '</ul>' +
                        '<ul class="list-group list-group">' +
                        '<li class="list-group-item"><strong>Frenos:  </strong>' + estado.status.brakes + '</li>' +
                        '<li class="list-group-item"><strong>Cadena:  </strong>' + estado.status.chain + '</li>' +
                        '<li class="list-group-item"><strong>Apoya pies:  </strong>' + estado.status.footPegs + '</li>' +
                        '</ul>' +
                        '</div>' +
                        '</div>' +
                        '</div>' +
                        '</div>';
                    try {
                        clase = ".orden-" + estado.id;
                        $(clase).html(accordeon);
                    } catch (e) {
                        console.log(e);
                    }
                } //termina if estados por ordenes
            });//foreach
            accordeon = "";
        }
    });
}

// //Registros
function obtenerListaRegistros() {
    fetch('http://localhost:8090/motorclinic/api/records', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => {
            if (!response.ok) {
                console.log(response)
                throw new Error('Hubo un problema al llamar los datos de lista registros producto-servicio');
            }
            return response.json();
        })
        .then(parsedResultRegistros => {
            if (parsedResultRegistros !== false) {
                mostrarRegistro(parsedResultRegistros);
            } else {
                console.log('No se recibieron datos válidos de la lista de registros producto-servicio');
            }
        })
        .catch(error => {
            console.error('Error al obtener la lista de registros producto-servicio:', error);
        });
}


function mostrarRegistro(listaRegistros) {
    let accordeonR = "";
    //moto es en realidad el id de la orden.
    $.each(listaRegistros, function (index, registro) {

        accordeonR += '<div class="cajitas ">' +
            '<div id="ordenes" class="ordenes modal-body border border border-3 border-dark" style="--bs-border-opacity: .4;">' +
            '<strong> Registros de la orden</strong>';

        verRegistrosPorOrden();

        function verRegistrosPorOrden() {
            $.each(listaRegistros, function (index, registroPorO) {

                //solo poner las ordenes de está moto.
                if (registroPorO.order.id === registro.order.id) {
                    accordeonR += '<div class="accordion accordion-flush" id="accordionFlushRegistros">' +
                        '<div class="accordion-item">' +
                        '<h2 class="accordion-header" id="flush-heading-registros-' + registroPorO.id + '">' +
                        '<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse-registros-' +
                        registroPorO.id + '" aria-expanded="false" aria-controls="flush-collapse-registros-' +
                        registroPorO.id + '">' +
                        '<strong>Registro:  #</strong> ' + registroPorO.id + ' de la orden: ' + registroPorO.order.id +
                        '</button>' +
                        '</h2>' +
                        '<div id="flush-collapse-registros-' + registroPorO.id + '" class="accordion-collapse collapse" ' +
                        'aria-labelledby="flush-heading-registros-' + registroPorO.id + '" data-bs-parent="#accordionFlushRegistros">' +
                        '<div class="accordion-body">' +
                        '<ul class="list-group list-group">' +
                        '<li class="list-group-item"><strong>Producto:  </strong>' + registroPorO.product.productName + '</li>' +
                        '<li class="list-group-item"><strong>Valor producto:  </strong>' + registroPorO.product.productValue + '</li>' +
                        '<li class="list-group-item"><strong>Detalle Servicio:  </strong>' + registroPorO.service.serviceName + '</li>' +
                        '</ul>' +
                        '<ul class="list-group list-group">' +
                        '<li class="list-group-item"><strong>Detalle servicio:  </strong>' + registroPorO.service.serviceDetail + '</li>' +
                        '<li class="list-group-item"><strong>Valor servicio:  </strong>' + registroPorO.service.serviceValue + '</li>' +
                        '<li class="list-group-item"><strong>Aprobado por cliente.  </strong>' + registroPorO.approved + '</li>' +
                        '</ul>' +
                        '</div>' +
                        '</div>' +
                        '</div>' +
                        '</div>';

                } //termina if estados por ordenes
            });//foreach
        }

        accordeonR += '</div>';
        try {
            clase = ".orden-registro-" + registro.order.id;
            $(clase).html(accordeonR);
        } catch (e) {
            console.log(e);
        }
        accordeonR = "";
    });
}
