
package Controller;

import java.util.Date;

/**
 *
 * @author BMO
 */
public interface IOrdenController {
    public String listarOrdenes();
    
    public String registrarOrden(Date date, String nombreCliente, String nombreMecanico, String placaMoto, String motivo, String descripcionDiagnostico, String documentos, String anticipo, double valorAnticipo, String autorizacionRuta, int idEstado);
    
    public String buscarOrden(int estado);
}
