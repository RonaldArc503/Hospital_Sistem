/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Hopital;

import Clases.Empleados;
import Clases.Hospital;
import conexion.Conexion;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Win10
 */
public class Gestionar_Hospitales extends javax.swing.JFrame {

    /**
     * Creates new form Gestionar_Hospitales
     */
    public Gestionar_Hospitales() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jHospitalTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jHospitalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(jHospitalTable);

        jLabel1.setText("Gestion Hospital");

        jButton1.setText("Hospitales");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Empleados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Pacientes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1021, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         // Crear la conexión
    Conexion oconn = new Conexion();

    // Consultar hospitales
    ArrayList<Hospital> listaHospitales = oconn.consultarHospitales();

    // Obtener el modelo de la tabla y limpiar el modelo actual (en caso de que haya datos)
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("Nombre");
    modelo.addColumn("Dirección");
    modelo.addColumn("Capacidad Cuartos");
    modelo.addColumn("Capacidad Pacientes");
    modelo.addColumn("Tipo Programa");
    modelo.addColumn("Departamento");
    modelo.addColumn("Municipio");
    modelo.addColumn("Equipo Médico");
    
    // Asegúrate de que la lista no es null y tiene datos
    if (listaHospitales != null && !listaHospitales.isEmpty()) {
        // Agregar los datos de cada hospital a la tabla
        for (Hospital hospital : listaHospitales) {
            Object[] fila = new Object[8]; // Número de columnas (8 en este caso)
            fila[0] = hospital.getNombre(); // Nombre del hospital
            fila[1] = hospital.getDireccion(); // Dirección del hospital
            fila[2] = hospital.getCapacidadCuartos(); // Capacidad de cuartos
            fila[3] = hospital.getCapacidadPacientes(); // Capacidad de pacientes
            fila[4] = hospital.getTipoPrograma(); // Nombre del tipo de programa
            fila[5] = hospital.getDepartamento(); // Nombre del departamento
            fila[6] = hospital.getMunicipio(); // Nombre del municipio
            fila[7] = hospital.getEquipoMedico(); // Nombre del equipo médico

            modelo.addRow(fila); // Agregar la fila a la tabla
        }
    } else {
        // Manejo de la situación donde no se encontraron hospitales
        System.out.println("No se encontraron hospitales.");
    }

    // Establecer el modelo a la tabla
    jHospitalTable.setModel(modelo);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Crear la conexión
    Conexion oconn = new Conexion();

    // Consultar empleados
    ArrayList<Empleados> listaEmpleados = oconn.consultarEmpleados();

    // Obtener el modelo de la tabla y limpiar el modelo actual (en caso de que haya datos)
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("Nombre");
    modelo.addColumn("Apellido");
    modelo.addColumn("Correo");
    modelo.addColumn("Área");
    modelo.addColumn("Cargo");
    modelo.addColumn("Teléfono");
    modelo.addColumn("Edad");

    // Asegúrate de que la lista no es null y tiene datos
    if (listaEmpleados != null && !listaEmpleados.isEmpty()) {
        // Agregar los datos de cada empleado a la tabla
        for (Empleados empleado : listaEmpleados) {
            Object[] fila = new Object[7]; // Número de columnas (7 en este caso)
            fila[0] = empleado.getNombre(); // Nombre del empleado
            fila[1] = empleado.getApellido(); // Apellido del empleado
            fila[2] = empleado.getCorreo(); // Correo del empleado
            fila[3] = empleado.getArea(); // Área del empleado
            fila[4] = empleado.getCargo(); // Cargo del empleado
            fila[5] = empleado.getTelefono(); // Teléfono del empleado
            fila[6] = empleado.getEdad(); // Edad del empleado

            modelo.addRow(fila); // Agregar la fila a la tabla
        }
    } else {
        // Manejo de la situación donde no se encontraron empleados
        System.out.println("No se encontraron empleados.");
    }

    // Establecer el modelo a la tabla
    jHospitalTable.setModel(modelo); // Cambia "jEmplead
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gestionar_Hospitales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestionar_Hospitales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestionar_Hospitales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestionar_Hospitales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestionar_Hospitales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JTable jHospitalTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
