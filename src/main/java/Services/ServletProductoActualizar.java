
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
@WebServlet(name = "ServletProductoActualizar", urlPatterns = {"/ServletProductoActualizar"})
public class ServletProductoActualizar extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    public ServletProductoActualizar(){
        super();
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ProductoController productoC = new ProductoController();
        
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        String nombre = request.getParameter("nombre");
        double valorProducto = Double.parseDouble(request.getParameter("valorProducto"));        
        
        String registroStr = productoC.actualizarProducto(idProducto, nombre, valorProducto);
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
