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
public class Expresion {
    public Arbol raiz;
    public String id;
    public Expresion(String id, Arbol raiz){
        this.raiz=raiz;
        this.id=id;
        
    }

    public Arbol getArbol() {
        return raiz;
    }

    public void setRaiz(Arbol raiz) {
        this.raiz = raiz;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
