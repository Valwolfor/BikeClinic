
package Beans;

import java.util.Date;

/**
 *
 * @author BMO
 */
public class OrdenDeServicio {
     private int idOrden;
    //formato: YYYY-MM-DD, new SimpleDateFormat("dd-MM-yyyy").format(objeto creado con Date))
    private Date date;
    private String nombreCliente;
    private String nombreMecanico;
    private String placaMoto;
    private String motivo;
    private String descripcionDiagnostico;
    private String documentos;
    private String anticipo;
    private double valorAnticipo;
    private String autorizacionRuta;
    private int idEstado;

    public OrdenDeServicio(Date date, String nombreCliente, String nombreMecanico, String placaMoto, String motivo, String descripcionDiagnostico, String documentos, String anticipo, double valorAnticipo, String autorizacionRuta, int idEstado) {
        this.date = date;
        this.nombreCliente = nombreCliente;
        this.nombreMecanico = nombreMecanico;
        this.placaMoto = placaMoto;
        this.motivo = motivo;
        this.descripcionDiagnostico = descripcionDiagnostico;
        this.documentos = documentos;
        this.anticipo = anticipo;
        this.valorAnticipo = valorAnticipo;
        this.autorizacionRuta = autorizacionRuta;
        this.idEstado = idEstado;
    }
    

    public OrdenDeServicio(int idOrden, Date date, String nombreCliente, String nombreMecanico, String placaMoto, String motivo, String descripcionDiagnostico, String documentos, String anticipo, double valorAnticipo, String autorizacionRuta, int idEstado) {
        this.idOrden = idOrden;
        this.date = date;
        this.nombreCliente = nombreCliente;
        this.nombreMecanico = nombreMecanico;
        this.placaMoto = placaMoto;
        this.motivo = motivo;
        this.descripcionDiagnostico = descripcionDiagnostico;
        this.documentos = documentos;
        this.anticipo = anticipo;
        this.valorAnticipo = valorAnticipo;
        this.autorizacionRuta = autorizacionRuta;
        this.idEstado = idEstado;
    }

    public OrdenDeServicio(int idOrden, int idEstado) {
        this.idOrden = idOrden;
        this.idEstado = idEstado;
    }

    
    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreMecanico() {
        return nombreMecanico;
    }

    public void setNombreMecanico(String nombreMecanico) {
        this.nombreMecanico = nombreMecanico;
    }

    public String getPlacaMoto() {
        return placaMoto;
    }

    public void setPlacaMoto(String placaMoto) {
        this.placaMoto = placaMoto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDescripcionDiagnostico() {
        return descripcionDiagnostico;
    }

    public void setDescripcionDiagnostico(String descripcionDiagnostico) {
        this.descripcionDiagnostico = descripcionDiagnostico;
    }

    public String getDocumentos() {
        return documentos;
    }

    public void setDocumentos(String documentos) {
        this.documentos = documentos;
    }

    public String getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(String anticipo) {
        this.anticipo = anticipo;
    }

    public double getValorAnticipo() {
        return valorAnticipo;
    }

    public void setValorAnticipo(double valorAnticipo) {
        this.valorAnticipo = valorAnticipo;
    }

    public String getAutorizacionRuta() {
        return autorizacionRuta;
    }

    public void setAutorizacionRuta(String autorizacionRuta) {
        this.autorizacionRuta = autorizacionRuta;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public String toString() {
        return "OrdenDeServicio{" + 
                "idOrden=" + idOrden + 
                ", date=" + date + 
                ", nombreCliente=" + nombreCliente + 
                ", nombreMecanico=" + nombreMecanico + 
                ", placaMoto=" + placaMoto + 
                ", motivo=" + motivo + 
                ", descripcionDiagnostico=" + descripcionDiagnostico + 
                ", documentos=" + documentos + 
                ", anticipo=" + anticipo + 
                ", valorAnticipo=" + valorAnticipo + 
                ", autorizacionRuta=" + autorizacionRuta + ", idEstado=" + idEstado + 
                '}';
    }
    
}

