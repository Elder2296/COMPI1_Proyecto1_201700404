/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores;

/**
 *
 * @author elari
 */
public class G_Sintactico {
    
    public static void main(String[] args) {
            String[] opciones = new String[7];
            
            opciones[0]="-parser";
            
            opciones[1]="src/Analizadores";
            
            opciones[2]="-symbols";
            
            opciones[3]="Simbolos";
            
            opciones[4]="-parser";
            
            opciones[5]="Sintactico";
            
            opciones[6]="src/Analizadores/A_sintactico.cup";
            try{
                java_cup.Main.main(opciones);
            
            }catch(Exception ex){
            
                System.out.println(ex);
            }
            
            
    }
    
}
