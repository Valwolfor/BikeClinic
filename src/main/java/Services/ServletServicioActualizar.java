
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
@WebServlet(name = "ServletServicioActualizar", urlPatterns = {"/ServletServicioActualizar"})
public class ServletServicioActualizar extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public ServletServicioActualizar(){
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServicioController servicioC = new ServicioController();
        
        int idServicio = Integer.parseInt(request.getParameter("idServicio"));
        String nombreServicio = request.getParameter("nombreServicio");
        String detalleServicio = request.getParameter("detalleServicio");
        double valorServicio = Double.parseDouble(request.getParameter("valorServicio"));
        
        String registroStr = servicioC.actualizarServicio(idServicio, nombreServicio, detalleServicio, valorServicio);
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
