/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elari
 */
public class Nodo {
    public String token;
    public String lexema;
    public int id; 
    public Nodo hijoIzq;
    public Nodo hijoDer;
    private ArrayList<Integer> first=new ArrayList();
    private ArrayList<Integer> last=new ArrayList();
    
    
    private char anulabilidad;
    
    public ArrayList<Nodo> hijos = new ArrayList<Nodo>();
    
    public Nodo(String token, String lexema, int id, Nodo hijoIzq, Nodo hijoDer){
        this.token = token;
        this.lexema = lexema;
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
        this.id=id;
        this.anulabilidad=' ';
        if(id!=-1){
            this.first.add(id);
            this.last.add(id);
        }
        
        if(hijoIzq != null){
        this.hijos.add(hijoIzq);
        }
        if(hijoDer != null){
            this.hijos.add(hijoDer);
        }
        
    }

    public ArrayList<Integer> getFirst() {
        return first;
    }

    public void setFirst(ArrayList<Integer> first) {
        this.first = first;
    }

    public List<Integer> getLast() {
        return last;
    }

    public void setLast(ArrayList<Integer> last) {
        this.last = last;
    }
    public void setAnulabilidad(char anul){
        this.anulabilidad=anul;
    }
    public char getAnulabilidad(){
        return this.anulabilidad;
    }

    public Nodo getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(Nodo hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public Nodo getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(Nodo hijoDer) {
        this.hijoDer = hijoDer;
    }
    
    
    
    
}
