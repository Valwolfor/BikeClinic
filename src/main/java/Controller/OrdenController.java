
package Controller;

import Beans.OrdenDeServicio;
import Connection.DBConnection;
import com.google.gson.Gson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author BMO
 */
public class OrdenController implements IOrdenController{

    @Override
    public String listarOrdenes() {
        //Para los Json
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        String sql = "SELECT o.idOrden, o.fecha, CONCAT(c.nombre, ' ', c.primerApellido) AS Cliente, CONCAT(u.nombre, ' ', u.primerApellido) AS Mecánico, o.moto, o.motivo, o.descripcionDiagnostico, o.documentos, o.anticipo, o.valorAnticipo, o.autorizacionRuta, o.estado FROM Orden_servicios o JOIN Clientes c ON c.idCliente = o.cliente JOIN Usuarios u ON u.idUsuario = o.mecanico";

        List<String> listaOrdenes = new ArrayList<>();
        try {
            Statement st = conn.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            //List para guardar objeticos :D
            while (rs.next()) {
                int idOrden = rs.getInt("idOrden");
                String date = rs.getString("fecha");
                String nombreCliente = rs.getString("Cliente");
                String nombreMecanico = rs.getString("Mecánico");
                String placaMoto = rs.getString("moto");
                String motivo = rs.getString("motivo");
                String descripcionDiagnostico = rs.getString("descripcionDiagnostico");
                String documentos = rs.getString("documentos");
                String anticipo = rs.getString("anticipo");
                double valorAnticipo = rs.getDouble("valorAnticipo");
                String autorizacionRuta = rs.getString("autorizacionRuta");
                int idEstado = rs.getInt("estado");
                

//                Se crea objeto y se vuelve json.
                OrdenDeServicio orden = new OrdenDeServicio(idOrden, date, nombreCliente, nombreMecanico, placaMoto, motivo, descripcionDiagnostico, documentos, anticipo, valorAnticipo, autorizacionRuta, idEstado);

                //Para agregarle
                listaOrdenes.add(gson.toJson(orden));

            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar con la BD en listar motos " + e.getMessage());
        } finally {
            conn.desconectar();
        }

        return gson.toJson(listaOrdenes);
    }

    @Override
    public String registrarOrden(String date, String nombreCliente, String nombreMecanico, String placaMoto, String motivo, String descripcionDiagnostico, String documentos, String anticipo, double valorAnticipo, String autorizacionRuta, int idEstado) {
        
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        String sql = "INSERT into Orden_servicios  (fecha, cliente, mecanico, moto, documentos, valorAnticipo, descripcionDiagnostico, estado, autorizacionRuta, anticipo) VALUES('" + date + "', '" + nombreCliente + "', '" + nombreMecanico + "', '" + placaMoto + "', '" + documentos + "', '" + valorAnticipo + "', '" + motivo + "', '" + "', '" + idEstado + "', '" + autorizacionRuta + "', '" + anticipo + "')";
        try {
            Statement st = conn.conectar().createStatement();
            st.executeUpdate(sql);

            OrdenDeServicio orden = new OrdenDeServicio(date, nombreCliente, nombreMecanico, placaMoto, motivo, descripcionDiagnostico, documentos, anticipo, valorAnticipo, autorizacionRuta, idEstado);

            st.close();
            System.out.println("Se realizó el registro de la moto.");
            return gson.toJson(orden);

        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la BD en registrar Orden controller : " + e.getMessage());
        } finally {
            conn.desconectar();
        }
        return "false";
    }

    @Override
    public String buscarOrden(int idEstado) {
        
         Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        String sql = "SELECT * FROM Orden_servicios WHERE estado = '" + idEstado + "'";

        try {
            Statement st = conn.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);

            rs.next();
            int idOrden = Integer.parseInt(rs.getString("idEstado"));

            OrdenDeServicio orden = new OrdenDeServicio(idOrden,idEstado);

            st.close();
            System.out.println("Se realizó la consulta de la orden.");
            return gson.toJson(orden);

        } catch (NumberFormatException | SQLException e) {
            System.out.println("No se pudo relizar la busqueda del estado, por: " + e.toString());
        } finally {
            conn.desconectar();
        }

        return "false";
    }
    
}
