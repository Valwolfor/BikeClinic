
package Services;

import Controller.HVMotoController;
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
@WebServlet(name = "ServletHVmotoListar", urlPatterns = {"/ServletHVmotoListar"})
public class ServletHVmotoListar extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletHVmotoListar() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          HVMotoController hvController = new HVMotoController();
        //toma los datos de la BD y los manda a JS-Json de la intefaz
//        String correo = request.getParameter("correo");
        String hvsStr = hvController.listarHVMoto();
        
        response.setContentType("text/html;charset=UTF-8");
        //Imprime el resultado.
        PrintWriter out = response.getWriter();
        out.println(hvsStr);
       
        out.flush();
        out.close();
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    

}
