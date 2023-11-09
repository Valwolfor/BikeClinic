
package Services;

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
@WebServlet(name = "ServletUsuarioLogin", urlPatterns = {"/ServletUsuarioLogin"})
public class ServletUsuarioLogin extends HttpServlet {

//    Para pasar la info por el protocolo http
    private static final long serialVersionUID = 1L;
    
    //Constructor.
    public ServletUsuarioLogin(){
        super();
    }
    //Do get para tomar los datos y luego moverlos con el dopost.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioController usuario = new UsuarioController();
        //setea los datos que obtiene del JS-Json de la intefaz
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        
        //Pasa esos datos al metodo login de objeto de usuario Controler.
        String result = usuario.login(correo, password);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        
        //pa sacarlos por inactividad, por varios parametros que entran. No entender, revisar.
        out.flush();
        out.close();
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
