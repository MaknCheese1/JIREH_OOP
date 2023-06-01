/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;
import entidades.Menu;
import entidades.Restaurante;
import datos.Dt_Menu;
import datos.Dt_Restaurante;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
//import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ivandy
 */
public class FrmMenu extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenu
     */
    
    //Declaracion de objetos globales
    //listas
   private ArrayList<Menu> listaMenu = new ArrayList<Menu>();
   private ArrayList<Restaurante> listaRestaurante = new ArrayList<Restaurante>();
    //entidades
   private Menu M = new Menu();
   private Restaurante rest = new Restaurante();
    //datos
   private Dt_Menu dtm = new Dt_Menu();
   private Dt_Restaurante dtr = new Dt_Restaurante();
    //declaramos el modelo de datos de la tabla 
    DefaultTableModel myData = new DefaultTableModel();
    //declaramos un filtro de datos para la tabla
    TableRowSorter trsfiltro;

    
    public FrmMenu() {
        initComponents();
        llenarComboRest();
        llenarTabla();
        limpiarCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TxtMenuid = new javax.swing.JTextField();
        CbRestauranteid = new javax.swing.JComboBox<>();
        TxtNomMe = new javax.swing.JTextField();
        TxtDescripcion = new javax.swing.JTextField();
        TxtBuscar = new javax.swing.JTextField();
        BtnNuevo = new javax.swing.JButton();
        BtnGuardar = new javax.swing.JButton();
        BtnEditar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtabMenu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setText("MenuID:");

        jLabel2.setText("RestauranteID:");

        jLabel3.setText("Nombre_Menu:");

        jLabel4.setText("Descripcion:");

        jLabel5.setText("Buscar:");

        TxtMenuid.setEditable(false);
        TxtMenuid.setFocusable(false);
        TxtMenuid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtMenuidActionPerformed(evt);
            }
        });

        CbRestauranteid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..." }));

        TxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtBuscarKeyTyped(evt);
            }
        });

        BtnNuevo.setText("Nuevo");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });

        BtnGuardar.setText("Guardar");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        BtnEditar.setText("Editar");
        BtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtBuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtMenuid))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbRestauranteid, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtDescripcion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtNomMe, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnNuevo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnGuardar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnEditar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtMenuid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CbRestauranteid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnGuardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtNomMe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEliminar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        JtabMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "MenuID", "RestauranteID", "Nombre_Menu", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        JtabMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtabMenuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JtabMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        // TODO add your handling code here:
        //validamos que todos los campos sean ingresados por el usuario      
        if(TxtNomMe.getText().equals("") || TxtDescripcion.getText().equals("") || CbRestauranteid.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Todos los campos son requeridos!", 
                    "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        else{
            //construimos nuestro objeto con los valores del formulario
            
            M.setNombre_menu(TxtNomMe.getText());
            M.setDescripcion(TxtDescripcion.getText());
             rest = (Restaurante)this.CbRestauranteid.getItemAt(this.CbRestauranteid.getSelectedIndex());
            M.setRestauranteID(rest.getRestauranteID());
            M.setMenuID(M.getMenuID());
            
            //validamos que el id no exista en la tabla de la bd
            if(dtm.existeMenu(M)){
                JOptionPane.showMessageDialog(this, "El Id del Menu existe!", 
                    "ERROR", JOptionPane.WARNING_MESSAGE);
                TxtMenuid.setText("");
                TxtMenuid.grabFocus(); 
            }
            else{
                //validamos que el metodo guardar devuelve un true
                if(dtm.guardarMenu(M)){
                    JOptionPane.showMessageDialog (this, "El registro fue almacenado con éxito!", 
                      "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
                    actualizarTabla();
                    limpiarCampos();
                }
                else{
                   JOptionPane.showMessageDialog(this, 
                      "Revise los datos e intente nuevamente. Si el error persiste contacte al Administrador del Sistema.", 
                      "ERROR", JOptionPane.ERROR_MESSAGE); 
                }
            }
        }
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void TxtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyTyped
        // TODO add your handling code here:
                TxtNomMe.addKeyListener(new KeyAdapter(){
            //Se ejecuta cuando el usuario libera una tecla
            @Override
            public void keyReleased(final KeyEvent e){
                String cadena = (TxtNomMe.getText()).toUpperCase();
                TxtNomMe.setText(cadena);
                repaint();
            }
        });
    }//GEN-LAST:event_TxtBuscarKeyTyped

    private void JtabMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtabMenuMouseClicked
        // TODO add your handling code here:
       //obtenemos la fila seleccionada del jtable
        int fila = this.JtabMenu.getSelectedRow();
        int idRest = 0; //guarda el idLocations que se obtiene de la tabla
       int size = 0; //guarda la cantidad de elementos que hay en el jcombobx de Locations
        int pos = 1; //variable de control para recorrer las posiciones de los elementos en el jcombobox
        
        //asignamos los valores a los campos del formulario
        this.TxtMenuid.setText(this.JtabMenu.getValueAt(fila, 0).toString());
        this.TxtNomMe.setText(this.JtabMenu.getValueAt(fila, 2).toString());
        this.TxtDescripcion.setText(this.JtabMenu.getValueAt(fila, 3).toString());
    

        
        idRest= Integer.parseInt(this.JtabMenu.getValueAt(fila, 1).toString());
        System.out.println("idRLoc: "+idRest);
  
        
    }//GEN-LAST:event_JtabMenuMouseClicked

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
    }//GEN-LAST:event_BtnNuevoActionPerformed

    private void BtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarActionPerformed
        // TODO add your handling code here:
        //validamos que todos los campos sean ingresados por el usuario      
         if(TxtMenuid.getText().equals("") || TxtNomMe.getText().equals("") || TxtDescripcion.getText().equals("") || CbRestauranteid.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Todos los campos son requeridos!", 
                    "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        else{
            //construimos nuestro objeto con los valores del formulario
            M.setMenuID(Integer.parseInt(TxtMenuid.getText()));
            M.setNombre_menu(TxtNomMe.getText());
            M.setDescripcion(TxtDescripcion.getText());
            rest = (Restaurante)this.CbRestauranteid.getSelectedItem();
            M.setMenuID(M.getMenuID());
            
            //validamos que el metodo editar devuelve un true
            if(dtm.editarMen(M)){
                JOptionPane.showMessageDialog (this, "El registro fue actualizado con éxito!", 
                  "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
                actualizarTabla();
                limpiarCampos();

            }
            else{
               JOptionPane.showMessageDialog(this, 
                  "Revise los datos e intente nuevamente. Si el error persiste contacte al Administrador del Sistema.", 
                  "ERROR", JOptionPane.ERROR_MESSAGE); 
            }
        }
    }//GEN-LAST:event_BtnEditarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        // TODO add your handling code here:
        //validamos que todos los campos sean ingresados por el usuario      
         if(TxtMenuid.getText().equals("") || TxtNomMe.getText().equals("") || TxtDescripcion.getText().equals("") || CbRestauranteid.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Todos los campos son requeridos!", 
                    "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        else{
            //construimos nuestro objeto con los valores del formulario
            M.setMenuID(Integer.parseInt(TxtMenuid.getText()));
            M.setNombre_menu(TxtNomMe.getText());
            M.setNombre_menu(TxtDescripcion.getText());
            rest = (Restaurante)this.CbRestauranteid.getSelectedItem();
            M.setMenuID(M.getMenuID());
            
            //validamos que el metodo editar devuelve un true
            if(dtm.deleteMen(M)){
                JOptionPane.showMessageDialog (this, "El registro fue eliminado con éxito!", 
                  "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
                actualizarTabla();
                limpiarCampos();

            }
            else{
               JOptionPane.showMessageDialog(this, 
                  "Revise los datos e intente nuevamente. Si el error persiste contacte al Administrador del Sistema.", 
                  "ERROR", JOptionPane.ERROR_MESSAGE); 
            }
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void TxtMenuidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtMenuidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtMenuidActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }
    
    private void llenarComboRest(){
        //llenamos la lista
        listaRestaurante = dtr.listarRestaurante();
        //recorremos cada elemento de la lista y creamos el objeto
        for(Restaurante r: listaRestaurante){
            //asignamos el objeto creado al combobox
              this.CbRestauranteid.addItem(r);
        }
            
    }
    
    private void actualizarTabla(){
        myData.setColumnCount(0);
        myData.setRowCount(0);
        this.llenarTabla();
    }
    
    private void llenarTabla(){        
        //llenamos la lista
        listaMenu = dtm.listarMenu();
        
        //creamos un arraylist con las columnas del modelo
        ArrayList<Object> listNombreColumnas = new ArrayList<Object>();
        listNombreColumnas.add("MenuID");
        listNombreColumnas.add("RestauranteID");
        listNombreColumnas.add("Nombre_Menu");
        listNombreColumnas.add("Descripcion");
        //recorremos cada elemento del arraylist y creamos un objeto
        for(Object column : listNombreColumnas){
            //asignamos las columnas al modelo
            myData.addColumn(column);
        }
        
       //recorremos cada elemento de la lista y creamos el objeto
        for(Menu Me: listaMenu){
            Object[] dtMe = new Object[]{Me.getMenuID(), Me.getRestauranteID(), Me.getNombre_menu(), Me.getDescripcion()};
            //asignamos un arreglo de objetos a una fila del modelo
            myData.addRow(dtMe);
        }
        //Asignamos el modelo y/o coleccion de datos a la tabla
        JtabMenu.setModel(myData);
    }
    
    private void limpiarCampos(){
        this.TxtMenuid.setText("");
        this.TxtNomMe.setText("");
        this.TxtDescripcion.setText("");
        //this.jtf_buscar.setText("");
        this.CbRestauranteid.setSelectedIndex(0);
    }
    
    private void filtrarTabla(){
       trsfiltro.setRowFilter(RowFilter.regexFilter(TxtBuscar.getText(), 1));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JComboBox<Object> CbRestauranteid;
    private javax.swing.JTable JtabMenu;
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.JTextField TxtDescripcion;
    private javax.swing.JTextField TxtMenuid;
    private javax.swing.JTextField TxtNomMe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}