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
@WebServlet(name = "ServletMecanicoModificarEstado", urlPatterns = {"/ServletMecanicoModificarEstado"})
public class ServletMecanicoModificarEstado extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletMecanicoModificarEstado() {
        super();
    }

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioController mecanico = new UsuarioController();

        int id = Integer.parseInt(request.getParameter("idUsuario"));
        String estado = request.getParameter("estado");

        String result = mecanico.modificarEstadoMecanico(id, estado);
        
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
