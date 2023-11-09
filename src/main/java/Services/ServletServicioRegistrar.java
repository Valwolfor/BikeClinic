package Services;

import Controller.ServicioController;
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
@WebServlet(name = "ServletServicioRegistrar", urlPatterns = {"/ServletServicioRegistrar"})
public class ServletServicioRegistrar extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletServicioRegistrar() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServicioController servicioC = new ServicioController();

        String nombreServicio = request.getParameter("nombreServicio");
        String detalleServicio = request.getParameter("detalleServicio");
        double valorServicio = Double.parseDouble(request.getParameter("valorServicio"));

        //Guardar el resultado
        String result = servicioC.registrarServicio(nombreServicio, detalleServicio, valorServicio);

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
