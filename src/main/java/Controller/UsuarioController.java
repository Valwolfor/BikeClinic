package Controller;

import Beans.Usuario;
import Connection.DBConnection;
import com.google.gson.Gson;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;

public class UsuarioController implements IUsuarioController {

    @Override
    public String login(String correo, String password) {
        //Para los Json
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        String sql = "SELECT * FROM Usuarios WHERE correo='" + correo + "'  and password='" + password + "'";
        try {
            PreparedStatement pstm = conn.conectar().prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idUsuario");
                String nombre = rs.getString("nombre");
                String primerApellido = rs.getString("primerApellido");
                String segundoApellido = rs.getString("segundooApellido");
                String numeroContacto = rs.getString("numeroContacto");
                String estado = rs.getString("estado");
                String rol = rs.getString("rol");

//                Se crea objeto y se vuelve json.
                Usuario usuario = new Usuario(estado, password, rol, id, nombre, primerApellido, segundoApellido, correo, numeroContacto);
                return gson.toJson(usuario);
            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar con la BD en el login " + e.getMessage());
        } finally {
            conn.desconectar();
        }

        return "false";
    }

    @Override
    public String registerMecanico(int id, String nombre, String primerApellido, String segundoApellido, String estado, String rol, String correo, String password, String numeroContacto) {
        //ASignación de Variables que no se colocan en front pero deben ir en persistencia. NO ES NECESARIO SE SETEAN EN EL JS.
//        estado = "Activo";
//        rol = "Mecánico";

        //Para los Json
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();

        //Consulta para setear.INSERT. Se actualiza.
        String sql = "INSERT INTO Usuarios values('" + id + "', '" + nombre + "', '" + primerApellido + "', '" + segundoApellido + "',  '" + correo + "', '" + numeroContacto + "', '" + estado + "', '" + password + "', '" + rol + "')";

        try {
            Statement st = conn.conectar().prepareStatement(sql);
//          Se ejecuta un update porque se está ejecutando.
            st.executeUpdate(sql);

//          Se crea objeto y se vuelve json.
            Usuario usuario = new Usuario(estado, password, rol, id, nombre, primerApellido, segundoApellido, correo, numeroContacto);
            st.close();
            System.out.println("Se realizó la consulta de actualizaciónen: " + usuario);
            //Regregar el objeto de Json
            return gson.toJson(usuario);

        } catch (SQLException e) {
            System.out.println("No se pudo conectar con la BD en el register() " + e.getMessage());
        } finally {
            conn.desconectar();
        }

        return "false";
    }

    @Override
    public String listarMecanicos() {

        //Para los Json
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        String sql = "SELECT * FROM Usuarios WHERE rol='Mecánico'";
        
        //Para no llamar la contraseña
        String password = null;
//        Iba a hacer la concatenación aquí mandando solo la variable nombre, pero mejor en el js. 
//        String primerApellido = null;
//        String segundoApellido = null;
        List<String> listaMecanicos = new ArrayList<>();
        try {
            Statement st = conn.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            //List para guardar objeticos :D
            
            while (rs.next()) {
                int id = rs.getInt("idUsuario");
                String nombre = rs.getString("nombre");
                String primerApellido = rs.getString("primerApellido");
                String segundoApellido = rs.getString("segundooApellido");
                String numeroContacto = rs.getString("numeroContacto");
                String estado = rs.getString("estado");
//                String password = rs.getString("password"); 
                String rol = rs.getString("rol");
                String correo = rs.getString("correo");
                
//                Se crea objeto y se vuelve json.
                Usuario mecanico = new Usuario(estado, password, rol, id, nombre, primerApellido, segundoApellido, correo, numeroContacto);
                
                //Para agregarle
                listaMecanicos.add(gson.toJson(mecanico));
                
            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar con la BD en listar mecánicos " + e.getMessage());
        } finally {
            conn.desconectar();
        }

        return gson.toJson(listaMecanicos);
    }

    @Override
    public String modificarEstadoMecanico(int id, String estado) {
        /*
        import java.sql.Timestamp;
        import java.util.Date;
        Timestamp fecha = new Timestamp(new Date().getTime());
        */ 
        
        DBConnection conn = new DBConnection();
        String sql = "UPDATE Usuarios set estado = '" + estado + "' WHERE idUsuario = '" + id + "' and rol = 'Mecánico'";
        try {
            Statement st = conn.conectar().createStatement();
            st.executeUpdate(sql);
            
            return "true";
        } catch (Exception e) {
            System.out.println("No se pudo relizar actualización de estado mecánico, por: " + e.toString());
        } finally {
            conn.desconectar();
        }
        return "false"; 
    }

}
