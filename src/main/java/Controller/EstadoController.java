
package Controller;

import Beans.Status;
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
public class EstadoController implements IEstadoController {

    @Override
    public String listarEstado() {
          //Para los Json
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        String sql = "SELECT o.idOrden AS moto, e.*  FROM estado e JOIN orden_servicios o ON o.estado = e.idEstado";

        List<String> listaEstados = new ArrayList<>();
        try {
            Statement st = conn.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            //List para guardar objeticos :D
            while (rs.next()) {
                int moto = rs.getInt("moto");
                int idEstado = rs.getInt("idEstado");
                String indicadores = rs.getString("indicadores");
                String desIndicadores = rs.getString("desIndicadores");
                String aceite = rs.getString("aceite");
                String nivelAceite = rs.getString("nivelAceite");
                String liquidoFrenos = rs.getString("liquidoFrenos");
                String liquidoEmbrague = rs.getString("liquidoEmbrague");
                String liquidoRefrigerante = rs.getString("liquidoRefrigerante");
                String lucesAptas = rs.getString("lucesAptas");
                String espejos = rs.getString("espejos");
                String claxon = rs.getString("claxon");
                String tanque = rs.getString("tanque");
                String llantaDelantera = rs.getString("llantaDelantera");
                String llantaTrasera = rs.getString("llantaTrasera");
                String motor = rs.getString("motor");
                String chasis = rs.getString("chasis");
                String acelerador = rs.getString("acelerador");
                String escape = rs.getString("escape");
                String trasmision = rs.getString("trasmision");
                String embrague = rs.getString("embrague");
                String frenos = rs.getString("frenos");
                String cadena = rs.getString("cadena");
                String apoyaPies = rs.getString("apoyaPies");
                String kilometraje = rs.getString("kilometraje");
                String combustible = rs.getString("combustible");
                
//                Se crea objeto y se vuelve json.
                Status estado = new Status(moto, idEstado, indicadores, desIndicadores, aceite, nivelAceite, liquidoFrenos, liquidoEmbrague, liquidoRefrigerante, lucesAptas, espejos, claxon, tanque, llantaDelantera, llantaTrasera, motor, chasis, acelerador, escape, trasmision, embrague, frenos, cadena, apoyaPies, kilometraje,  combustible);

                //Para agregarle
                listaEstados.add(gson.toJson(estado));

            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar con la BD en listar estados " + e.getMessage());
        } finally {
            conn.desconectar();
        }

        return gson.toJson(listaEstados);
    }

    @Override
    public String registrarEstado(String indicadores, String desIndicadores, String aceite, String nivelAceite, String liquidoFrenos, String liquidoEmbrague, String liquidoRefrigerante, String lucesAptas, String espejos, String claxon, String tanque, String llantaDelantera, String llantaTrasera, String motor, String chasis, String acelerador, String escape, String trasmision, String embrague, String frenos, String cadena, String apoyaPies, String kilometraje, String combustible) {
    
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        String sql = "INSERT into estado  (indicadores, desIndicadores, aceite, nivelAceite, liquidoFrenos, liquidoEmbrague, liquidoRefrigerante, lucesAptas, espejos, claxon, tanque, llantaDelantera, llantaTrasera, motor, chasis, acelerador, escape, trasmision, embrague, frenos, cadena, apoyaPies, kilometraje, combustible) VALUES('" + indicadores + "', '" + desIndicadores + "', '" + aceite + "', '" + nivelAceite + "', '" + liquidoFrenos + "', '" + liquidoEmbrague + "', '" + liquidoRefrigerante + "', '" + lucesAptas + "', '" + espejos + "', '" + claxon + "', '" + tanque + "', '" + llantaDelantera + "', '" + llantaTrasera + "','" + motor + "', '" + chasis + "', '" + acelerador + "', '" + escape + "', '" + trasmision + "', '" + embrague + "', '" + frenos + "', '" + cadena + "', '" + apoyaPies + "', " + kilometraje + ", '" + combustible + "')";
        try {
            Statement st = conn.conectar().createStatement();
            st.executeUpdate(sql);

            Status estado = new Status(indicadores, desIndicadores, aceite, nivelAceite, liquidoFrenos, liquidoEmbrague, liquidoRefrigerante, lucesAptas, espejos, claxon, tanque, llantaDelantera, llantaTrasera, motor, chasis, acelerador, escape, trasmision, embrague, frenos, cadena, apoyaPies, kilometraje, combustible);

            st.close();
            System.out.println("Se realizó el registro de la moto.");
            return gson.toJson(estado);

        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la BD en registrar estado controller : " + e.getMessage());
        } finally {
            conn.desconectar();
        }
        return "false";
    }

    @Override
    public String buscarEstado(String kilometraje) {
        
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        String sql = "SELECT * FROM estado WHERE kilometraje = '" + kilometraje + "'";

        try {
            Statement st = conn.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);

            rs.next();
            int idEstado = Integer.parseInt(rs.getString("idEstado"));

            Status moto = new Status(idEstado, kilometraje);

            st.close();
            System.out.println("Se realizó la consulta del estado.");
            return gson.toJson(moto);

        } catch (Exception e) {
            System.out.println("No se pudo relizar la busqueda del estado, por: " + e.toString());
        } finally {
            conn.desconectar();
        }

        return "false";
    }
    
}
