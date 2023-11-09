package Services;

import Controller.ClienteController;
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
@WebServlet(name = "ServletClienteActualizar", urlPatterns = {"/ServletClienteActualizar"})
public class ServletClienteActualizar extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletClienteActualizar() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ClienteController clienteC = new ClienteController();
        
        String tipoID = request.getParameter("tipoId");
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String primerApellido = request.getParameter("primerApellido");
        String segundoApellido = request.getParameter("segundoApellido");
        String correo = request.getParameter("correo");
        String numeroContacto = request.getParameter("numeroContacto");
        
        String registroStr = clienteC.actualizarCliente(tipoID, idCliente, nombre, primerApellido, segundoApellido, correo, numeroContacto);
        
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
