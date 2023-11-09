
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
@WebServlet(name = "ServletMotoBuscar", urlPatterns = {"/ServletMotoBuscar"})
public class ServletMotoBuscar extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    public ServletMotoBuscar(){
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        MotoController motoC = new MotoController();
        
        String placaMoto = request.getParameter("placaMoto");
        
        String registroStr = motoC.buscarMoto(placaMoto);
        
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
