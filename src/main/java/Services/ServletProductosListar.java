
package Services;

import Controller.ProductoController;
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
@WebServlet(name = "ServletProductosListar", urlPatterns = {"/ServletProductosListar"})
public class ServletProductosListar extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public ServletProductosListar(){
        super();
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductoController productoC = new ProductoController();
        
       String registroStr = productoC.obtenerProductos();
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
