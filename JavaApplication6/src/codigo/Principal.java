/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;

/**
 *
 * @author elari
 */
public class Principal {
    public static void main(String[] args) {
            String ruta ="C:/Users/elari/Desktop/2021/1er Semestre/Lab Compi1/Proyecto 1/COMPI1_Proyecto1_201700404/JavaApplication6/src/codigo/lexer.flex";
            generarLexer(ruta);
    }
    
    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        
        JFlex.Main.generate(archivo);
        
    
    }
    
    
}
