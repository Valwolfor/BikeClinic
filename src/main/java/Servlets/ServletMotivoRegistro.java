package Servlets;

import Controller.OrdenController;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BMO
 */
@WebServlet(name = "ServletMotivoRegistro", urlPatterns = {"/ServletMotivoRegistro"})
public class ServletMotivoRegistro extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletMotivoRegistro() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        OrdenController estadoC = new OrdenController();

        String date2 = request.getParameter("fecha");
        String formatPattern = "YYYY/MM/dd";
        SimpleDateFormat formatter = new SimpleDateFormat(formatPattern);
        date2= formatter.format(LocalDateTime.now());
        try {
            Date date = formatter.parse(date2);//puede fallar.

            String nombreCliente = request.getParameter("cliente");
            String nombreMecanico = request.getParameter("mecanico");
            String placaMoto = request.getParameter("moto");
            String motivo = request.getParameter("motivo");
            String descripcionDiagnostico = request.getParameter("descripcionDiagnostico");
            String documentos = request.getParameter("documentos");
            String anticipo = request.getParameter("anticipo");
            double valorAnticipo = Double.parseDouble(request.getParameter("valorAnticipo"));
            String autorizacionRuta = request.getParameter("autorizacionRuta");
            int idEstado = Integer.parseInt(request.getParameter("estado"));

            String registroStr = estadoC.registrarOrden(date, nombreCliente, nombreMecanico, placaMoto, motivo, descripcionDiagnostico, documentos, anticipo, valorAnticipo, autorizacionRuta, idEstado);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(registroStr);
            out.flush();
            out.close();
        } catch (ParseException ex) {
            Logger.getLogger(ServletMotivoRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
