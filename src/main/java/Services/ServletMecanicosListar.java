
package Services;

import Beans.Usuario;
import Controller.UsuarioController;
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
@WebServlet(name = "ServletMecanicosListar", urlPatterns = {"/ServletMecanicosListar"})
public class ServletMecanicosListar extends HttpServlet {

    //    Para pasar la info por el protocolo http
    private static final long serialVersionUID = 1L;
    
    public ServletMecanicosListar() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UsuarioController mecanicos = new UsuarioController();
        //toma los datos de la BD y los manda a JS-Json de la intefaz
//        String correo = request.getParameter("correo");
        String mecanicosStr = mecanicos.listarMecanicos();
        
        response.setContentType("text/html;charset=UTF-8");
        //Imprime el resultado.
        PrintWriter out = response.getWriter();
        out.println(mecanicosStr);
       
        out.flush();
        out.close();
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    
}
