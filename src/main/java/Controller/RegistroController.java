package Controller;

import Beans.RegistroProductoServicio;
import Connection.DBConnection;
import com.google.gson.Gson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BMO
 */
public class RegistroController implements IRegistroController {

    @Override
    public String listarRegistros() {

        Gson gson = new Gson();
        DBConnection conn = new DBConnection();
        String sql = "SELECT r.orden, r.idServiciosProductos, p.nombre, p.valorProducto, s.nombreProceso, s.detalleProceso, s.valorProceso, r.aprobado FROM Registro_servicios_y_productos r JOIN Productos p ON p.idProducto = r.producto JOIN Servicios s ON s.idServicio = r.servicio";

        List<String> listaRegistros = new ArrayList<>();

        try {
            Statement st = conn.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int idOrden = rs.getInt("orden");
                int idRegistro = rs.getInt("idServiciosProductos");
                String nombreProducto = rs.getString("nombre");
                double valorProducto = rs.getDouble("valorProducto");
                String nombreServicio = rs.getString("nombreProceso");
                String detalleServicio = rs.getString("detalleProceso");
                double valorServicio = rs.getDouble("valorProceso");
                String aprobado = rs.getString("aprobado");

//                Se crea objeto y se vuelve json.
                RegistroProductoServicio registro = new RegistroProductoServicio(idOrden, idRegistro, nombreProducto, valorProducto, nombreServicio, detalleServicio, valorServicio, aprobado);

                //Para agregarle
                listaRegistros.add(gson.toJson(registro));

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.desconectar();
        }
        return gson.toJson(listaRegistros);
    }
}
