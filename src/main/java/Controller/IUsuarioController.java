
package Controller;

/**
 *
 * @author BMO
 */
public interface IUsuarioController {
    
    public String login (String correo, String password);
    
    public String registerMecanico (int id, String nombre, String primerApellido, String segundoApellido, String estado,  String rol, String correo, String password, String numeroContacto);
    
}
