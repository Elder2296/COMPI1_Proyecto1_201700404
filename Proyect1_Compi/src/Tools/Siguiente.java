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
public class Siguiente {
    private int id;
    private String terminal;
    private LinkedList<Integer> follows;
    
    public Siguiente(int id, String terminal){
        this.id=id;
        this.terminal=terminal;
        this.follows=new LinkedList();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public LinkedList<Integer> getFollows() {
        return follows;
    }

    public void setFollows(LinkedList<Integer> follows) {
        this.follows = follows;
    }
    
    public void exist(int id){
        int encontro=0;
        for (int elemento: this.follows){
            if(elemento==id){
                encontro=1;
            }
        }
        if (encontro!=1) addFollow(id); 
        
    }
    private void addFollow(int follow){
        
        this.follows.add(follow);
    
    }
    
    
    
}
