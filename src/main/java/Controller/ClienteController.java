package Controller;

import Beans.Cliente;
import Connection.DBConnection;
import com.google.gson.Gson;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author BMO
 */
public class ClienteController implements IClienteController {

    @Override
    public String registrarCliente(String tipoID, int id, String nombre, String primerApellido, String segundoApellido, String correo, String numeroContacto) {

        Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        String sql = "INSERT into Clientes (idCliente, tipoId, nombre, primerApellido, segundoApellido, correo, numeroConctacto) VALUES(" + id + ", '" + tipoID + "', '" + nombre + "', '" + primerApellido + "', '" + segundoApellido + "', '" + correo + "', '" + numeroContacto + "')";
        try {
            Statement st = conn.conectar().createStatement();
            st.executeUpdate(sql);

            Cliente cliente = new Cliente(tipoID, id, nombre, primerApellido, segundoApellido, correo, numeroContacto);

            st.close();
            System.out.println("Se realizó el registro del cliente.");
            return gson.toJson(cliente);

        } catch (Exception e) {
            System.out.println("No se pudo conectar a la BD en registrar cliente controller : " + e.getMessage());
        } finally {
            conn.desconectar();
        }
        return "false";
    }

    @Override
    public String actualizarCliente(String tipoID, int id, String nombre, String primerApellido, String segundoApellido, String correo, String numeroContacto) {
        
        
        DBConnection conn = new DBConnection();
        String sql = "UPDATE Clientes set tipoId = '" + tipoID + "', nombre = '" + nombre + "', primerApellido = '" + primerApellido + "', segundoApellido = '" + segundoApellido + "', correo = '" + correo + "', numeroConctacto = '" + numeroContacto + "' WHERE idCliente = " + id;
        
        try {
            Statement st = conn.conectar().createStatement();
            st.executeUpdate(sql);
            System.out.println("Se realizó la actualización de manera exitosa.");
            
            return "true";
        } catch (Exception e) {
            System.out.println("No se pudo relizar la actualización del cliente, por: " + e.toString());
        } finally {
            conn.desconectar();
        }
        
        return "false";
    }

    @Override
    public String buscarCliente(int id) {
    
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        String sql = "SELECT * FROM Clientes WHERE idCliente = " + id;
        
        try {
            Statement st = conn.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            rs.next();
            String tipoID = rs.getString("tipoId");
            int idC = id;
            String nombre = rs.getString("nombre");
            String primerApellido = rs.getString("primerApellido");
            String segundoApellido = rs.getString("segundoApellido");
            String correo = rs.getString("correo");
            String numeroContacto = rs.getString("numeroConctacto");
            
            Cliente cliente = new Cliente(tipoID, idC, nombre, primerApellido, segundoApellido, correo, numeroContacto);

            st.close();
            System.out.println("Se realizó la consulta del cliente.");
            return gson.toJson(cliente);
            
        } catch (Exception e) {
            System.out.println("No se pudo relizar la busqueda del cliente, por: " + e.toString());
        } finally {
            conn.desconectar();
        }
        
        return "false";
    }

}
