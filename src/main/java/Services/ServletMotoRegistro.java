package Services;

import Controller.MotoController;
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
@WebServlet(name = "ServletMotoRegistro", urlPatterns = {"/ServletMotoRegistro"})
public class ServletMotoRegistro extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    public ServletMotoRegistro() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MotoController motoC = new MotoController();
        
        String placaMoto = request.getParameter("placaMoto");
        String idMotor = request.getParameter("idMotor");
        String idChasis = request.getParameter("idChasis");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String anioRegistro = request.getParameter("anioRegistro");
        int Clientes_idCliente = Integer.parseInt(request.getParameter("Clientes_idCliente"));
        
        String registroStr = motoC.registrarMoto(placaMoto, idMotor, idChasis, marca, modelo, anioRegistro, Clientes_idCliente);
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
