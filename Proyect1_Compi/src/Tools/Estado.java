/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;


import java.util.LinkedList;

/**
 *
 * @author elari
 */
public class Estado {
    private String nombre;
    private LinkedList<Integer> elementos;
    private char utilizada;
    
    public Estado(String nombre){
        this.nombre=nombre;
        this.elementos=new LinkedList();
        this.utilizada='N';
    }

    public char getUtilizada() {
        return utilizada;
    }

    public void setUtilizada(char utilizada) {
        this.utilizada = utilizada;
    }
    
    public String getNombre() {
        return nombre;
    }

    public LinkedList<Integer> getElementos() {
        return elementos;
    }
    
    public void addElement(int sig){
        this.elementos.add(sig);
    }
    public void setListaElementos(LinkedList<Integer> listado){
        this.elementos=listado;
    }
    
    
}
