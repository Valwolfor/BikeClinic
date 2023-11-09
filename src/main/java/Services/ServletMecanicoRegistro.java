package Services;

import Controller.UsuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BMO
 */
@WebServlet(name = "ServletMecanicoRegistro", urlPatterns = {"/ServletMecanicoRegistro"})
public class ServletMecanicoRegistro extends HttpServlet {

    //    Para pasar la info por el protocolo http
    private static final long serialVersionUID = 1L;

    public ServletMecanicoRegistro() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioController usuario = new UsuarioController();
               
        int id = Integer.parseInt(request.getParameter("idUsuario"));
        String nombre = request.getParameter("nombre");
        String primerApellido = request.getParameter("primerApellido");
        String segundoApellido = request.getParameter("segundooApellido");
        String estado = request.getParameter("estado");
        String rol = request.getParameter("rol");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        String numeroContacto = request.getParameter("numeroContacto");
         
        //Guardar el resultado
        String result = usuario.registerMecanico(id, nombre, primerApellido, segundoApellido, estado, rol, correo, password, numeroContacto);

        //Los response html.
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

    }
}
