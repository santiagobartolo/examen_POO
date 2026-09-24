package uniquindio.edu.co;

public class Cliente {
    //los atributos del cliente, seria interesante una obcion donde el cliente se va sin pagar JAJJAJAJAJAJ
    private int documento;
    private String nombre;
    private String telefono;
    private String correoElectronico;

    public Cliente(int documento, String nombre, String telefono, String correoElectronico) {
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "documento=" + documento +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                '}';
    }
}
