package conexion;

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
            conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.16:1521:xe", "system", "ronald2003");
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
}
