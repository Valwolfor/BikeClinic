
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
@WebServlet(name = "ServletProductoRegistrar", urlPatterns = {"/ServletProductoRegistrar"})
public class ServletProductoRegistrar extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    public ServletProductoRegistrar(){
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ProductoController productoC = new ProductoController();

        String nombre = request.getParameter("nombre");
        double valorProducto = Double.parseDouble(request.getParameter("valorProducto"));

        //Guardar el resultado
        String result = productoC.registrarProducto(nombre, valorProducto);

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
