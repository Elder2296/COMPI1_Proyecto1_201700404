/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

/**
 *
 * @author elari
 */
public class Arbol {
    public Nodo raiz;
    
    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }
    
    public void graficarSintactico(){
        String grafica= "Digraph Arbol_Sintactio {\n\n"+"\n\n}";
    }
    
}
