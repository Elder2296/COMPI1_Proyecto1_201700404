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
import javax.swing.JFrame;


/**
 *
 * @author elari
 */
public class Principal extends javax.swing.JFrame {
    public static ArrayList<error> listaErrores = new ArrayList<error>();
    
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btnReportes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAnalizar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        btnReportes.setText("Reportes");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        btnAnalizar1.setText("Analizar");
        btnAnalizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnAnalizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalizar1)
                    .addComponent(btnReportes))
                .addGap(56, 56, 56)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
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
    private javax.swing.JButton btnAnalizar1;
    private javax.swing.JButton btnReportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
