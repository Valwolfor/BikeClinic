package Services;

import Controller.EstadoController;
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
@WebServlet(name = "ServletEstadoBuscar", urlPatterns = {"/ServletEstadoBuscar"})
public class ServletEstadoBuscar extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletEstadoBuscar() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EstadoController estadoC = new EstadoController();

        String kilometraje = request.getParameter("kilometraje");

        String registroStr = estadoC.buscarEstado(kilometraje);

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println(registroStr);
        out.flush();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
