/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author elari
 */
public class Traslado {
    private Estado estado;
    private LinkedList<Terminal> terminales;
    
    public Traslado(Estado estado, LinkedList<Terminal> terminales){
        this.estado=estado;
        this.terminales=terminales;
    
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LinkedList<Terminal> getTerminales() {
        return terminales;
    }

    public void setTerminales(LinkedList<Terminal> terminales) {
        this.terminales = terminales;
    }
    
}
