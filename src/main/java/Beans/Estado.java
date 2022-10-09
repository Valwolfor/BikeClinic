package Beans;

/**
 *
 * @author BMO
 */
public class Estado {

    private int moto;
    private int idEstado;
    private String indicadores;
    private String desIndicadores;
    private String aceite;
    private String nivelAceite;
    private String liquidoFrenos;
    private String liquidoEmbrague;
    private String liquidoRefrigerante;
    private String lucesAptas;
    private String espejos;
    private String claxon;
    private String tanque;
    private String llantaDelantera;
    private String llantaTrasera;
    private String motor;
    private String chasis;
    private String acelerador;
    private String escape;
    private String trasmision;
    private String embrague;
    private String frenos;
    private String cadena;
    private String apoyaPies;
    private String kilometraje;
    private String combustible;

    public Estado(String indicadores, String desIndicadores, String aceite, String nivelAceite, String liquidoFrenos, String liquidoEmbrague, String liquidoRefrigerante, String lucesAptas, String espejos, String claxon, String tanque, String llantaDelantera, String llantaTrasera, String motor, String chasis, String acelerador, String escape, String trasmision, String embrague, String frenos, String cadena, String apoyaPies, String kilometraje, String combustible) {
        this.indicadores = indicadores;
        this.desIndicadores = desIndicadores;
        this.aceite = aceite;
        this.nivelAceite = nivelAceite;
        this.liquidoFrenos = liquidoFrenos;
        this.liquidoEmbrague = liquidoEmbrague;
        this.liquidoRefrigerante = liquidoRefrigerante;
        this.lucesAptas = lucesAptas;
        this.espejos = espejos;
        this.claxon = claxon;
        this.tanque = tanque;
        this.llantaDelantera = llantaDelantera;
        this.llantaTrasera = llantaTrasera;
        this.motor = motor;
        this.chasis = chasis;
        this.acelerador = acelerador;
        this.escape = escape;
        this.trasmision = trasmision;
        this.embrague = embrague;
        this.frenos = frenos;
        this.cadena = cadena;
        this.apoyaPies = apoyaPies;
        this.kilometraje = kilometraje;
        this.combustible = combustible;
    }
    
    public Estado(int moto, int idEstado, String indicadores, String desIndicadores, String aceite, String nivelAceite, String liquidoFrenos, String liquidoEmbrague, String liquidoRefrigerante, String lucesAptas, String espejos, String claxon, String tanque, String llantaDelantera, String llantaTrasera, String motor, String chasis, String acelerador, String escape, String trasmision, String embrague, String frenos, String cadena, String apoyaPies, String kilometraje, String combustible) {
        this.moto = moto;
        this.idEstado = idEstado;
        this.indicadores = indicadores;
        this.desIndicadores = desIndicadores;
        this.aceite = aceite;
        this.nivelAceite = nivelAceite;
        this.liquidoFrenos = liquidoFrenos;
        this.liquidoEmbrague = liquidoEmbrague;
        this.liquidoRefrigerante = liquidoRefrigerante;
        this.lucesAptas = lucesAptas;
        this.espejos = espejos;
        this.claxon = claxon;
        this.tanque = tanque;
        this.llantaDelantera = llantaDelantera;
        this.llantaTrasera = llantaTrasera;
        this.motor = motor;
        this.chasis = chasis;
        this.acelerador = acelerador;
        this.escape = escape;
        this.trasmision = trasmision;
        this.embrague = embrague;
        this.frenos = frenos;
        this.cadena = cadena;
        this.apoyaPies = apoyaPies;
        this.kilometraje = kilometraje;
        this.combustible = combustible;
    }

    public Estado(int idEstado, String kilometraje) {
        this.idEstado = idEstado;
        this.kilometraje = kilometraje;
    }

    public int getMoto() {
        return moto;
    }

    public void setMoto(int moto) {
        this.moto = moto;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(String indicadores) {
        this.indicadores = indicadores;
    }

    public String getDesIndicadores() {
        return desIndicadores;
    }

    public void setDesIndicadores(String desIndicadores) {
        this.desIndicadores = desIndicadores;
    }

    public String getAceite() {
        return aceite;
    }

    public void setAceite(String aceite) {
        this.aceite = aceite;
    }

    public String getNivelAceite() {
        return nivelAceite;
    }

    public void setNivelAceite(String nivelAceite) {
        this.nivelAceite = nivelAceite;
    }

    public String getLiquidoFrenos() {
        return liquidoFrenos;
    }

    public void setLiquidoFrenos(String liquidoFrenos) {
        this.liquidoFrenos = liquidoFrenos;
    }

    public String getLiquidoEmbrague() {
        return liquidoEmbrague;
    }

    public void setLiquidoEmbrague(String liquidoEmbrague) {
        this.liquidoEmbrague = liquidoEmbrague;
    }

    public String getLiquidoRefrigerante() {
        return liquidoRefrigerante;
    }

    public void setLiquidoRefrigerante(String liquidoRefrigerante) {
        this.liquidoRefrigerante = liquidoRefrigerante;
    }

    public String getLucesAptas() {
        return lucesAptas;
    }

    public void setLucesAptas(String lucesAptas) {
        this.lucesAptas = lucesAptas;
    }

    public String getEspejos() {
        return espejos;
    }

    public void setEspejos(String espejos) {
        this.espejos = espejos;
    }

    public String getClaxon() {
        return claxon;
    }

    public void setClaxon(String claxon) {
        this.claxon = claxon;
    }

    public String getTanque() {
        return tanque;
    }

    public void setTanque(String tanque) {
        this.tanque = tanque;
    }

    public String getLlantaDelantera() {
        return llantaDelantera;
    }

    public void setLlantaDelantera(String llantaDelantera) {
        this.llantaDelantera = llantaDelantera;
    }

    public String getLlantaTrasera() {
        return llantaTrasera;
    }

    public void setLlantaTrasera(String llantaTrasera) {
        this.llantaTrasera = llantaTrasera;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getAcelerador() {
        return acelerador;
    }

    public void setAcelerador(String acelerador) {
        this.acelerador = acelerador;
    }

    public String getEscape() {
        return escape;
    }

    public void setEscape(String escape) {
        this.escape = escape;
    }

    public String getTrasmision() {
        return trasmision;
    }

    public void setTrasmision(String trasmision) {
        this.trasmision = trasmision;
    }

    public String getEmbrague() {
        return embrague;
    }

    public void setEmbrague(String embrague) {
        this.embrague = embrague;
    }

    public String getFrenos() {
        return frenos;
    }

    public void setFrenos(String frenos) {
        this.frenos = frenos;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public String getApoyaPies() {
        return apoyaPies;
    }

    public void setApoyaPies(String apoyaPies) {
        this.apoyaPies = apoyaPies;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    @Override
    public String toString() {
        return "Estado{"
                + "moto=" + moto
                + ", idEstado=" + idEstado
                + ", indicadores=" + indicadores
                + ", desIndicadores=" + desIndicadores
                + ", aceite=" + aceite
                + ", nivelAceite=" + nivelAceite
                + ", liquidoFrenos=" + liquidoFrenos
                + ", liquidoEmbrague=" + liquidoEmbrague
                + ", liquidoRefrigerante=" + liquidoRefrigerante
                + ", lucesAptas=" + lucesAptas
                + ", espejos=" + espejos
                + ", claxon=" + claxon
                + ", tanque=" + tanque
                + ", llantaDelantera=" + llantaDelantera
                + ", llantaTrasera=" + llantaTrasera
                + ", motor=" + motor
                + ", chasis=" + chasis
                + ", acelerador=" + acelerador
                + ", escape=" + escape
                + ", trasmision=" + trasmision
                + ", embrague=" + embrague
                + ", frenos=" + frenos
                + ", cadena=" + cadena
                + ", apoyaPies=" + apoyaPies
                + ", kilometraje=" + kilometraje
                + ", combustible=" + combustible
                + '}';
    }
}
