package Clases;

/**
 *
 * @author Win10
 */
public class Empleados {
    private String nombre;       // Nombre del empleado
    private String apellido;     // Apellido del empleado
    private String correo;       // Correo del empleado
    private String telefono;      // Teléfono del empleado
    private int edad;            // Edad del empleado
    private String area;         // Área en la que trabaja el empleado
    private String cargo;        // Cargo del empleado

    // Constructor
    public Empleados(String nombre, String apellido, String correo, String telefono, int edad, String area, String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.edad = edad;
        this.area = area;
        this.cargo = cargo;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getEdad() {
        return edad;
    }

    public String getArea() {
        return area;
    }

    public String getCargo() {
        return cargo;
    }

    // Setters (if needed)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
