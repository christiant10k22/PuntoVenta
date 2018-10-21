/*
    Clase que declara el objeto de tipo usuario
*/
package cignusSoft.modelo;

/**
 *
 * @author chris
 */
public class Usuario {
    private int id;
    private int usuario;
    private int contrasenia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(int contrasenia) {
        this.contrasenia = contrasenia;
    }
}
