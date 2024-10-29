package Clases;

public class Hospital {
    private String nombre;
    private String direccion;
    private int capacidadCuartos;
    private int capacidadPacientes;
    private String tipoPrograma;
    private String departamento;
    private String municipio;
    private String equipoMedico;

    // Constructor vacío
    public Hospital() {}

    // Constructor con todos los atributos (sin los IDs)
    public Hospital(String nombre, String direccion, int capacidadCuartos, int capacidadPacientes,
                    String tipoPrograma, String departamento, String municipio, String equipoMedico) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidadCuartos = capacidadCuartos;
        this.capacidadPacientes = capacidadPacientes;
        this.tipoPrograma = tipoPrograma;
        this.departamento = departamento;
        this.municipio = municipio;
        this.equipoMedico = equipoMedico;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCapacidadCuartos() {
        return capacidadCuartos;
    }

    public void setCapacidadCuartos(int capacidadCuartos) {
        this.capacidadCuartos = capacidadCuartos;
    }

    public int getCapacidadPacientes() {
        return capacidadPacientes;
    }

    public void setCapacidadPacientes(int capacidadPacientes) {
        this.capacidadPacientes = capacidadPacientes;
    }

    public String getTipoPrograma() {
        return tipoPrograma;
    }

    public void setTipoPrograma(String tipoPrograma) {
        this.tipoPrograma = tipoPrograma;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEquipoMedico() {
        return equipoMedico;
    }

    public void setEquipoMedico(String equipoMedico) {
        this.equipoMedico = equipoMedico;
    }

    // Método para mostrar la información del hospital
    @Override
    public String toString() {
        return "Hospital{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", capacidadCuartos=" + capacidadCuartos +
                ", capacidadPacientes=" + capacidadPacientes +
                ", tipoPrograma='" + tipoPrograma + '\'' +
                ", departamento='" + departamento + '\'' +
                ", municipio='" + municipio + '\'' +
                ", equipoMedico='" + equipoMedico + '\'' +
                '}';
    }
}
