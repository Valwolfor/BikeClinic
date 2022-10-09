
package Servlets;

import Controller.OrdenController;
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
@WebServlet(name = "ServletMotivoBuscar", urlPatterns = {"/ServletMotivoBuscar"})
public class ServletMotivoBuscar extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    public ServletMotivoBuscar(){
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrdenController ordenC = new OrdenController();
        
        int estado = Integer.parseInt(request.getParameter("estado"));
        
        String registroStr = ordenC.buscarOrden(estado);
        
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
