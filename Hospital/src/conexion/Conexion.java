package conexion;

import Clases.Hospital;
import Clases.Empleados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Conexion {
    private Connection conn;
    private Statement stm;

    public Conexion() {
        try {
            // Cargar el driver de Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Establecer conexión con Oracle (ajusta la URL, usuario y contraseña según tu configuración)
            conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.3.1:1521:XE", "system", "ronald2003");
            //modificar con tu ip y credenciales
            stm = this.conn.createStatement();
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    public Connection getServer() {
        return conn;
    }

    // Método para realizar consultas
    public ResultSet consultar(String pSQL) {
        try {
            return stm.executeQuery(pSQL);
        } catch (Exception ee) {
            ee.printStackTrace();
            return null;
        }
    }

    // Método para consultar usuarios
/*    public ArrayList<usuarios> consultarUsuarios() {
        try {
            // Ejecutar la consulta SQL para obtener los usuarios
            ResultSet rs = this.consultar("SELECT * FROM usuarios ORDER BY usuario;");
            ArrayList<usuarios> listaUsuarios = new ArrayList<>();
            
            while (rs.next()) {
                usuarios usuario = new usuarios();
                usuario.setId(rs.getInt("id_usuario")); // Ajusta según el nombre de la columna en tu tabla
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContrasena(rs.getString("contrasena")); // Normalmente no querrías recuperar contraseñas directamente
                listaUsuarios.add(usuario);
            }
            
            return listaUsuarios;
        } catch (Exception ee) {
            ee.printStackTrace();
            return null;
        }
    }
*/
    // Método para verificar el estado de la conexión
    public void verificarConexion() {
        if (conn != null) {
            System.out.println("La conexión está activa.");
        } else {
            System.out.println("No ha conexion :/");
        }
    }
    
 // Método para consultar hospitales con INNER JOIN
public ArrayList<Hospital> consultarHospitales() {
    try {
        // Consulta con INNER JOIN para obtener los nombres de las tablas relacionadas
        ResultSet rs = this.consultar("SELECT h.nombre, h.direccion, h.capacidad_cuartos, h.capacidad_pacientes, "
                + "tp.tipo AS tipoPrograma, d.departamento AS departamento, "
                + "m.municipio AS municipio, am.nombre AS equipoMedico "
                + "FROM Hospitales h "
                + "INNER JOIN Tipo_Programa tp ON h.idTipoPrograma = tp.idTipoPrograma "
                + "INNER JOIN Departamentos d ON h.idDepartamento = d.idDepartamento "
                + "INNER JOIN Municipios m ON h.idMunicipio = m.idMunicipio "
                + "INNER JOIN Almacen_Medico am ON h.idEquipo = am.idEquipo");

        ArrayList<Hospital> listaHospitales = new ArrayList<>();

        while (rs.next()) {
            Hospital hospital = new Hospital(
                rs.getString("nombre"),
                rs.getString("direccion"),
                rs.getInt("capacidad_cuartos"),
                rs.getInt("capacidad_pacientes"),
                rs.getString("tipoPrograma"),
                rs.getString("departamento"),
                rs.getString("municipio"),
                rs.getString("equipoMedico")
            );
            listaHospitales.add(hospital);
        }

        return listaHospitales;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

// Método para consultar empleados con INNER JOIN
public ArrayList<Empleados> consultarEmpleados() {
    try {
        // Consulta con INNER JOIN para obtener los datos de usuario sin mostrar los ID
        ResultSet rs = this.consultar("SELECT u.nombre AS nombreUsuario, u.apellido, u.correo, "
                + "a.area, c.cargo, e.telefono, e.edad "
                + "FROM Empleado e "
                + "INNER JOIN Usuarios u ON e.idUsuario = u.idUsuario "
                + "INNER JOIN Areas a ON e.idArea = a.idArea "
                + "INNER JOIN Cargo c ON e.idCargo = c.idCargo");

        ArrayList<Empleados> listaEmpleados = new ArrayList<>();

        while (rs.next()) {
            Empleados empleado = new Empleados(
                rs.getString("nombreUsuario"),
                rs.getString("apellido"),
                rs.getString("correo"),
                rs.getString("telefono"), // Asegúrate de que el orden y los nombres coincidan
                rs.getInt("edad"),
                rs.getString("area"),
                rs.getString("cargo")
            );
            listaEmpleados.add(empleado);
        }

        return listaEmpleados;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}


}
