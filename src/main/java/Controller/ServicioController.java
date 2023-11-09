package Controller;

import Beans.Service;
import Connection.DBConnection;
import com.google.gson.Gson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BMO
 */
public class ServicioController implements IServicioController {

    @Override
    public String obtenerServicios() {
        //Para los Json
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        String sql = "SELECT * FROM servicios";

        List<String> listaServicios = new ArrayList<>();
        try {
            Statement st = conn.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            //List para guardar objeticos :D

            while (rs.next()) {
                int idServicio = rs.getInt("idServicio");
                String nombreServicio = rs.getString("nombreProceso");
                String detalleServicio = rs.getString("detalleProceso");
                double valorServicio = rs.getDouble("valorProceso");
//                Se crea objeto y se vuelve json.
                Service servicioC = new Service(idServicio, nombreServicio, detalleServicio, valorServicio);

                //Para agregarle
                listaServicios.add(gson.toJson(servicioC));

            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar con la BD en obtener servicios" + e.getMessage());
        } finally {
            conn.desconectar();
        }

        return gson.toJson(listaServicios);
    }


    @Override
    public String actualizarServicio(int idServicio, String nombreServicio, String detalleServicio, double valorServicio) {
        
        DBConnection conn = new DBConnection();
        String sql = "UPDATE servicios set nombreProceso = '" + nombreServicio + "', detalleProceso = '" + detalleServicio + "', valorProceso = " + valorServicio + " WHERE idServicio = " + idServicio;
        try {
            Statement st = conn.conectar().createStatement();
            st.executeUpdate(sql);
            
            return "true";
        } catch (Exception e) {
            System.out.println("No se pudo relizar actualización de servicio controller, por: " + e.toString());
        } finally {
            conn.desconectar();
        }
        return "false"; 
    }

    @Override
    public String registrarServicio(String nombreServicio, String detalleServicio, double valorServicio) {

        //Para los Json
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();

        //Consulta para setear.INSERT. ID no se pasa porque es autoincremental
        String sql = "INSERT INTO servicios(nombreProceso, detalleProceso, valorProceso) values('" + nombreServicio + "', '" + detalleServicio + "', " + valorServicio + ")";

        try {
            Statement st = conn.conectar().createStatement();
//          Se ejecuta un update porque se está ejecutando.
            st.executeUpdate(sql);

//          Se crea objeto y se vuelve json.
            Service servicio = new Service(nombreServicio, detalleServicio, valorServicio);
            st.close();
            System.out.println("Se realizó la consulta de actualización en: " + servicio);
            //Regregar el objeto de Json
            return gson.toJson(servicio);

        } catch (SQLException e) {
            System.out.println("No se pudo conectar con la BD en el servicio " + e.getMessage());
        } finally {
            conn.desconectar();
        }

        return "false";
    }
}
