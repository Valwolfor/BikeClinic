//Para llamar métodos. 

$(document).ready(function () {

    obtenerListaEstados();

});

//Estados
function obtenerListaEstados() {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletEstadoListar",
        success: function (result) {
            let parsedResultEstados = JSON.parse(result);
            if (parsedResultEstados !== false) {
                mostrarEstado(parsedResultEstados);
            } else {
                console.log("Hubo un problema al llamar los datos de lista Estados");
            }
        }
    });
}


function mostrarEstado(listaEstados) {
    let accordeon = "";
    //moto es en realidad el id de la orden.
    $.each(listaEstados, function (index, estado) {
        let estadoParsed = JSON.parse(estado);
//       
        accordeon += '<div class="accordion accordion-flush" id="accordionFlushEstados">' +
                '<div class="accordion-item">' +
                '<h2 class="accordion-header" id="flush-heading-estados-' + estadoParsed.idEstado + '">' +
                '<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse-estados-' + estadoParsed.idEstado + '" aria-expanded="false" aria-controls="flush-collapse-estados-' + estadoParsed.idEstado + '">' +
                '<strong>Estado:  #</strong> ' + estadoParsed.idEstado + ' de la orden: ' + estadoParsed.moto +
                '</button>' +
                '</h2>' +
                '<div id="flush-collapse-estados-' + estadoParsed.idEstado + '" class="accordion-collapse collapse" aria-labelledby="flush-heading-estados-' + estadoParsed.idEstado + '" data-bs-parent="#accordionFlushEstados">';
        verEstadosPorOrden();
        function verEstadosPorOrden() {
            $.each(listaEstados, function (index, estadoPorO) {
                let estadoOrdenParsed = JSON.parse(estadoPorO);
                //solo poner las ordenes de está moto.
                if (estadoOrdenParsed.moto === estadoParsed.moto) {
                    accordeon += '<div class="accordion-body">' +
                            '<ul class="list-group list-group">' +
                            '<li class="list-group-item"><strong>Kilometraje:  </strong>' + estadoOrdenParsed.kilometraje + '</li>' +
                            '<li class="list-group-item"><strong>Indicadores:  </strong>' + estadoOrdenParsed.indicadores + '</li>' +
                            '<li class="list-group-item"><strong>Detalle indicadores:  </strong>' + estadoOrdenParsed.desIndicadores + '</li>' +
                            '</ul>' +
                            '<ul class="list-group list-group">' +
                            '<li class="list-group-item"><strong>Aceite:  </strong>' + estadoOrdenParsed.aceite + '</li>' +
                            '<li class="list-group-item"><strong>Nivel aceite:  </strong>' + estadoOrdenParsed.nivelAceite + '</li>' +
                            '<li class="list-group-item"><strong>Nivel de combustible  </strong>$' + estadoOrdenParsed.combustible + '</li>' +
                            '</ul>' +
                            '<ul class="list-group list-group">' +
                            '<li class="list-group-item"><strong>Liquido de frenos:  </strong>' + estadoOrdenParsed.liquidoFrenos + '</li>' +
                            '<li class="list-group-item"><strong>Liquido de embrague:  </strong>' + estadoOrdenParsed.liquidoEmbrague + '</li>' +
                            '<li class="list-group-item"><strong>Liquido refrigerante:  </strong>' + estadoOrdenParsed.liquidoRefrigerante + '</li>' +
                            '</ul>' +
                            '<ul class="list-group list-group">' +
                            '<li class="list-group-item"><strong>Luces:  </strong>' + estadoOrdenParsed.lucesAptas + '</li>' +
                            '<li class="list-group-item"><strong>Espejos:  </strong>' + estadoOrdenParsed.espejos + '</li>' +
                            '<li class="list-group-item"><strong>Claxon:  </strong>' + estadoOrdenParsed.claxon + '</li>' +
                            '</ul>' +
                            '<ul class="list-group list-group">' +
                            '<li class="list-group-item"><strong>Tanque:  </strong>' + estadoOrdenParsed.tanque + '</li>' +
                            '<li class="list-group-item"><strong>Llanta delantera:  </strong>' + estadoOrdenParsed.llantaDelantera + '</li>' +
                            '<li class="list-group-item"><strong>Llanta trasera:  </strong>' + estadoOrdenParsed.llantaTrasera + '</li>' +
                            '</ul>' +
                            '</ul>' +
                            '<ul class="list-group list-group">' +
                            '<li class="list-group-item"><strong>Motor:  </strong>' + estadoOrdenParsed.motor + '</li>' +
                            '<li class="list-group-item"><strong>Chasis:  </strong>' + estadoOrdenParsed.chasis + '</li>' +
                            '<li class="list-group-item"><strong>Acelerador:  </strong>' + estadoOrdenParsed.acelerador + '</li>' +
                            '</ul>' +
                            '</ul>' +
                            '<ul class="list-group list-group">' +
                            '<li class="list-group-item"><strong>Escape:  </strong>' + estadoOrdenParsed.escape + '</li>' +
                            '<li class="list-group-item"><strong>Trasmisión:  </strong>' + estadoOrdenParsed.trasmision + '</li>' +
                            '<li class="list-group-item"><strong>Embrague:  </strong>' + estadoOrdenParsed.embrague + '</li>' +
                            '</ul>' +
                            '<ul class="list-group list-group">' +
                            '<li class="list-group-item"><strong>Frenos:  </strong>' + estadoOrdenParsed.frenos + '</li>' +
                            '<li class="list-group-item"><strong>Cadena:  </strong>' + estadoOrdenParsed.cadena + '</li>' +
                            '<li class="list-group-item"><strong>Apoya pies:  </strong>' + estadoOrdenParsed.apoyaPies + '</li>' +
                            '</ul>' +
                            '</div>' +
                            '</div>' +
                            '</div>' +
                            '</div>';
                    try {
                        clase = ".orden-" + estadoParsed.moto;
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
