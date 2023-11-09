package Controller;

import Connection.DBConnection;
import com.google.gson.Gson;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BMO
 */
public class HVMotoController implements IHVMotoController {

    @Override
    public String listarHVMoto() {

        //Para los Json
        Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        String sql = "SELECT * FROM orden_servicios_idestado";

        List<String> listaHV = new ArrayList<>();
        try {
            Statement st = conn.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            //List para guardar objeticos :D
            while (rs.next()) {
                int idOrden = rs.getInt("Orden");
                String placaMoto = rs.getString("Placa");
                String nombreCliente = rs.getString("Cliente");
                String nombreMecanico = rs.getString("Mecánico");
                String motivo = rs.getString("motivo");
                String documentos = rs.getString("documentos");
                String anticipo = rs.getString("anticipo");
                double valorAnticipo = rs.getDouble("valorAnticipo");
                String autorizacionRuta = rs.getString("autorizacionRuta");
                Date date = rs.getDate("fecha");
                int idEstado = rs.getInt("idEstado");
                String descripcionDiagnostico = rs.getString("descripcionDiagnostico");
                String productoServicio = rs.getString("Productos para servicio");
                String servicios = rs.getString("Servicios");
                String aprobadoCliente = rs.getString("Aprobado por cliente");

//                Se crea objeto y se vuelve json.
                HVmoto hv = new HVmoto(idOrden, placaMoto, nombreCliente, nombreMecanico, motivo, documentos, anticipo, valorAnticipo, autorizacionRuta, date, idEstado, descripcionDiagnostico, productoServicio, servicios, aprobadoCliente);

                //Para agregarle
                listaHV.add(gson.toJson(hv));

            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar con la BD en listar mecánicos " + e.getMessage());
        } finally {
            conn.desconectar();
        }

        return gson.toJson(listaHV);

    }

}
