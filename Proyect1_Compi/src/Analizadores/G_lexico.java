/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores;

import java.io.File;

/**
 *
 * @author elari
 */
public class G_lexico {
    
    public static void main(String[] args) {
            String path="C:/Users/elari/Desktop/2021/1er Semestre/Lab Compi1/Proyecto 1/COMPI1_Proyecto1_201700404/Proyect1_Compi/src/Analizadores/Lexico.jflex";
            generarLexer(path);
    }
    public static void generarLexer(String path){
        File file = new File(path);
        jflex.Main.generate(file);
    
    }
    
}
