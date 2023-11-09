package Services;

import Controller.EstadoController;
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
@WebServlet(name = "ServletEstadoRegistro", urlPatterns = {"/ServletEstadoRegistro"})
public class ServletEstadoRegistro extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletEstadoRegistro() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EstadoController estadoC = new EstadoController();

        String indicadores = request.getParameter("aceite");
        String desIndicadores = request.getParameter("aceite");
        String aceite = request.getParameter("aceite"); 
        String nivelAceite = request.getParameter("nivelAceite");
        String liquidoFrenos = request.getParameter("liquidoFrenos"); 
        String liquidoEmbrague = request.getParameter("liquidoEmbrague");
        String liquidoRefrigerante = request.getParameter("luiquidoRefrigerante"); 
        String lucesAptas = request.getParameter("lucesAptas");
        String espejos = request.getParameter("espejos"); 
        String claxon = request.getParameter("claxon");
        String tanque = request.getParameter("tanque"); 
        String llantaDelantera = request.getParameter("llantaDelantera");
        String llantaTrasera = request.getParameter("llantaTrasera"); 
        String motor = request.getParameter("motor");
        String chasis = request.getParameter("chasis"); 
        String acelerador = request.getParameter("acelerador");
        String escape = request.getParameter("escape"); 
        String trasmision = request.getParameter("trasmision");
        String embrague = request.getParameter("embrague"); 
        String frenos = request.getParameter("frenos");
        String cadena = request.getParameter("cadena"); 
        String apoyaPies = request.getParameter("apoyaPies");
        String kilometraje = request.getParameter("kilometraje"); 
        String combustible = request.getParameter("combustible");
        
        String registroStr = estadoC.registrarEstado(indicadores, desIndicadores, aceite, nivelAceite, liquidoFrenos, liquidoEmbrague, liquidoRefrigerante, lucesAptas, espejos, claxon, tanque, llantaDelantera, llantaTrasera, motor, chasis, acelerador, escape, trasmision, embrague, frenos, cadena, apoyaPies, kilometraje, combustible);
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
