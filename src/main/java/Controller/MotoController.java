package Controller;

import Beans.Motorcycle;
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
public class MotoController implements IMotoController {

    @Override
    public String listarMotos() {
        //Para los Json
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        String sql = "SELECT m.*, CONCAT(c.nombre, ' ', c.primerApellido) AS Cliente FROM motos m JOIN clientes c ON c.idCliente = m.Clientes_idCliente";

        List<String> listaMotos = new ArrayList<>();
        try {
            Statement st = conn.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            //List para guardar objeticos :D
            while (rs.next()) {
                String placa = rs.getString("placaMoto");
                String idMotor = rs.getString("idMotor");
                String idChasis = rs.getString("idChasis");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String añoRegistro = rs.getString("añoRegistro");
                int idCliente = rs.getInt("Clientes_idCliente");
                String nombreCliente = rs.getString("Cliente");

//                Se crea objeto y se vuelve json.
                Motorcycle moto = new Motorcycle(placa, idMotor, idChasis, marca, modelo, añoRegistro, idCliente, nombreCliente);

                //Para agregarle
                listaMotos.add(gson.toJson(moto));

            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar con la BD en listar motos " + e.getMessage());
        } finally {
            conn.desconectar();
        }

        return gson.toJson(listaMotos);

    }

    @Override
    public String registrarMoto(String placa, String idMotor, String idChasis, String marca, String modelo, String añoRegistro, int idCliente) {
        
    
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        String sql = "INSERT into motos  (placaMoto, idMotor, idChasis, marca, modelo, añoRegistro, Clientes_idCliente) VALUES('" + placa + "', '" + idMotor + "', '" + idChasis + "', '" + marca + "', '" + modelo + "', '" + añoRegistro + "', " + idCliente + ")";
        try {
            Statement st = conn.conectar().createStatement();
            st.executeUpdate(sql);

            Motorcycle moto = new Motorcycle(placa, idMotor, idChasis, marca, modelo, añoRegistro, idCliente);

            st.close();
            System.out.println("Se realizó el registro de la moto.");
            return gson.toJson(moto);

        } catch (Exception e) {
            System.out.println("No se pudo conectar a la BD en registrar moto controller : " + e.getMessage());
        } finally {
            conn.desconectar();
        }
        return "false";
    }

    @Override
    public String buscarMoto(String placaMoto) {

        Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        String sql = "SELECT * FROM motos WHERE placaMoto = '" + placaMoto + "'";

        try {
            Statement st = conn.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);

            rs.next();
            String placa = placaMoto;
            String idMotor = rs.getString("idMotor");
            String idChasis = rs.getString("idChasis");
            String marca = rs.getString("marca");
            String modelo = rs.getString("modelo");
            String añoRegistro = rs.getString("añoRegistro");
            int idCliente = rs.getInt("Clientes_idCliente");

            Motorcycle moto = new Motorcycle(placa, idMotor, idChasis, marca, modelo, añoRegistro, idCliente);

            st.close();
            System.out.println("Se realizó la consulta de la moto.");
            return gson.toJson(moto);

        } catch (Exception e) {
            System.out.println("No se pudo relizar la busqueda de la moto, por: " + e.toString());
        } finally {
            conn.desconectar();
        }

        return "false";
    }
}
