/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Analizadores.A_lexico;
import Analizadores.Sintactico;
import Tools.Expresion;
import Tools.Nodo;
import Tools.error;
import java.awt.Desktop;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


/**
 *
 * @author elari
 */
public class Principal extends javax.swing.JFrame {
    public static ArrayList<error> listaErrores = new ArrayList<error>();
    public static ArrayList<InfoImage> Arboles =new ArrayList();
    public static ArrayList<InfoImage> grafosSiguientes =new ArrayList();
    public static ArrayList<InfoImage> grafosTransiciones =new ArrayList();
    public static int narbol=0;
    public static int nsiguiente=0;
    
    /**
     * Creates new form Principal
     */
    public Principal() {
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.ponerImagen();
    }
    public void ponerImagen(){
        ImageIcon icon=new ImageIcon("C:/Users/elari/Desktop/2021/1er Semestre/ReportesCompi1/Arboles_201700404/ExpReg1.jpg");
        Image imgscale=icon.getImage().getScaledInstance(lblimage.getWidth(), lblimage.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoscale=new ImageIcon(imgscale);
        lblimage.setIcon(iconoscale);
    }
    
    public static void generarReportesHTML() throws IOException{
        FileWriter fichero= null;
        PrintWriter pw=null;
        try{
            String path = "Reporteerrores.html";
                    fichero = new FileWriter(path);
                    pw = new PrintWriter(fichero);
                    //comenzamos a escribir el html
                    pw.println("<html>");
                    pw.println("<head><title>REPORTE DE ERRORES</title></head>");
                    pw.println("<body>");
                    pw.println("<div align=\"center\">");
                    pw.println("<h1>Reporte de Errores</h1>");
                    pw.println("<br></br>");
                    pw.println("<table border=1>");
                    pw.println("<tr>");
                    pw.println("<td>ERROR</td>");
                    pw.println("<td>DESCRIPCION</td>");
                    pw.println("<td>FILA</td>");
                    pw.println("<td>COLUMNA</td>");
                    pw.println("</tr>");
                    for(int i=0;i<listaErrores.size();i++){
                        pw.println("<tr>");
                        pw.println("<td>"+listaErrores.get(i).getTipo()+"</td>");
                        pw.println("<td>"+listaErrores.get(i).getDescripcion()+"</td>");
                        pw.println("<td>"+listaErrores.get(i).getFila()+"</td>");
                        pw.println("<td>"+listaErrores.get(i).getColumna()+"</td>");
                        pw.println("</tr>");
                    }
                    pw.println("</table>");
                    pw.println("</div");
                    pw.println("</body>");
                    pw.println("</html>");
                    Desktop.getDesktop().open(new File(path));
        
        }catch(Exception e){
            
        }finally{
            if(null!=fichero){
                fichero.close();
            }
        }
        try {
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    public void galery(String opcion){
        if(opcion.equals("Arboles")){
            this.ponerArbol();
        }else if(opcion.equals("Siguientes")){
            this.ponerSiguiente();
            
        }else if(opcion.equals("Transiciones")){
            
        }else if(opcion.equals("Automatas")){
            
        }
        
    }
    
    public void ponerArbol(){
        if(narbol>Principal.Arboles.size()-1){
            narbol=0;
        }
        if(narbol<0){
            narbol=Principal.Arboles.size()-1;
        }
        lblNombre.setText(Principal.Arboles.get(narbol).getTitle());
        ImageIcon icon=new ImageIcon(Principal.Arboles.get(narbol).getPath());
        Image imgscale=icon.getImage().getScaledInstance(lblimage.getWidth(), lblimage.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoscale=new ImageIcon(imgscale);
        lblimage.setIcon(iconoscale);
        
        
    }
   
    public void ponerSiguiente(){
        if(nsiguiente>Principal.grafosSiguientes.size()-1){
            nsiguiente=0;
        }
        
        if(nsiguiente<0){
            nsiguiente=Principal.grafosSiguientes.size()-1;
        }
        lblNombre.setText(Principal.grafosSiguientes.get(nsiguiente).getTitle());
        ImageIcon icon=new ImageIcon(Principal.grafosSiguientes.get(nsiguiente).getPath());
        Image imgscale=icon.getImage().getScaledInstance(lblimage.getWidth(), lblimage.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoscale=new ImageIcon(imgscale);
        lblimage.setIcon(iconoscale);
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btnReportes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAnalizar1 = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        btnAbrir1 = new javax.swing.JButton();
        btnAbrir2 = new javax.swing.JButton();
        btnAbrir3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        lblimage = new javax.swing.JLabel();
        btnAbrir4 = new javax.swing.JButton();
        btnAbrir5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lblNombre = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        btnReportes.setText("Analizar Entradas");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        jLabel1.setText("Salida");

        btnAnalizar1.setText("Generar Automatas");
        btnAnalizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizar1ActionPerformed(evt);
            }
        });

        btnAbrir.setText("Guardar");

        btnAbrir1.setText("Abrir");

        btnAbrir2.setText("json");

        btnAbrir3.setText("Guardar como");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ver Imagenes", "Arboles", "Siguientes", "Transiciones", "Automatas" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox1MouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jComboBox1MouseReleased(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        btnAbrir4.setText("Siguiente");
        btnAbrir4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrir4ActionPerformed(evt);
            }
        });

        btnAbrir5.setText("Anterior");
        btnAbrir5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrir5ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 0, 0));
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        lblNombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(btnAnalizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAbrir1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAbrir3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAbrir2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(btnAbrir5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAbrir4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblimage, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrir1)
                    .addComponent(btnAbrir)
                    .addComponent(btnAbrir3)
                    .addComponent(btnAbrir2)
                    .addComponent(btnAbrir4)
                    .addComponent(btnAbrir5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblimage, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1)
                            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAnalizar1)
                            .addComponent(btnReportes))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        try {
            this.generarReportesHTML();
            
            
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnAnalizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizar1ActionPerformed
        // TODO add your handling code here:
        Sintactico sintactico = new Sintactico(new A_lexico(new BufferedReader( new StringReader(txtArea.getText()))));
        try{
            
            sintactico.parse();
//            ---> Lo siguiente solo fue utilizado para fines de ejemplo 
//            A_lexico lexico = new A_lexico(new BufferedReader( new StringReader(txtArea.getText())));
//            
//            while(lexico.next_token().value != null){
//                System.out.println(lexico.next_token());
//            }
            
            
            
            LinkedList<Expresion> lista_er=sintactico.lista_er;
            this.jLabel1.setText("Analisis correcto Nexpresiones: "+lista_er.size());
            
            for (int i = 0; i < lista_er.size(); i++) {
                Nodo hijoder=new Nodo("#","",100,null,null);
                hijoder.setAnulabilidad('N');
                Nodo hijoizq=lista_er.get(i).getArbol().getRaiz();
                Nodo nuevoPadre= new Nodo(".","",-1,hijoizq,hijoder);
               
                lista_er.get(i).getArbol().setRaiz(nuevoPadre);
                if(lista_er.get(i)!=null){
                    lista_er.get(i).getArbol().graficarSintactico();
                    //System.out.println("Nodo Raiz: "+lista_er.get(i).getArbol().getRaiz().token);
                }
                
            }
            
            
        }catch(Exception ex){
            System.out.println(ex);
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            this.jLabel1.setText("Analisis incorrecto");
        }
    }//GEN-LAST:event_btnAnalizar1ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox1MouseReleased

    private void jComboBox1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox1MouseEntered

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        Object selectitem=jComboBox1.getSelectedItem();
        this.galery(selectitem.toString());
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnAbrir4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrir4ActionPerformed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedItem().toString()=="Arboles"){
            narbol++;
            this.ponerArbol();
            
        }else if(jComboBox1.getSelectedItem().toString()=="Siguientes"){
            nsiguiente++;
            this.ponerSiguiente();
        }
        
    }//GEN-LAST:event_btnAbrir4ActionPerformed

    private void btnAbrir5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrir5ActionPerformed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedItem().toString()=="Arboles"){
            narbol--;
            this.ponerArbol();
        }else if(jComboBox1.getSelectedItem().toString()=="Siguientes"){
            nsiguiente--;
            this.ponerSiguiente();
        
        }
    }//GEN-LAST:event_btnAbrir5ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnAbrir1;
    private javax.swing.JButton btnAbrir2;
    private javax.swing.JButton btnAbrir3;
    private javax.swing.JButton btnAbrir4;
    private javax.swing.JButton btnAbrir5;
    private javax.swing.JButton btnAnalizar1;
    private javax.swing.JButton btnReportes;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblimage;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}

