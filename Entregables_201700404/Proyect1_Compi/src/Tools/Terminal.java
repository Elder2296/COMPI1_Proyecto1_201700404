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
public class Terminal {
    private String terminal;
    private String estado;
    private LinkedList<Integer> aux;
    public Terminal(String terminal){
        this.terminal=terminal;
        this.estado="";
        this.aux=new LinkedList();
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public LinkedList<Integer> getAux(){
        return this.aux;
    }
    public void addItem(int element){
        this.aux.add(element);
    }
    
}
