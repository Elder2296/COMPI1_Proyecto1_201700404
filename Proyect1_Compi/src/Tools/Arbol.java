/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Frame.Principal;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import Frame.InfoImage;


/**
 *
 * @author elari
 */
public class Arbol {
    public Nodo raiz;
    public String nombre;
    private String direc;
    private LinkedList<Siguiente> siguientes;
    private LinkedList<Traslado> traslados;
    private int cont;
    LinkedList<Traslado> tabladetraslados;
    
    public Arbol(Nodo raiz,String Nombre) {
        this.raiz = raiz;
        this.nombre=Nombre;
        this.direc="";
        this.siguientes=new LinkedList();
        this.traslados=new LinkedList();
        this.cont=-1;
        this.tabladetraslados=new LinkedList();
    }

    public String getNombre() {
        return nombre;
    }
    public Nodo getRaiz(){
        return this.raiz;
    }
    public void setRaiz(Nodo newraiz){
        this.raiz=newraiz;
    }
    
    
    public void graficarSintactico(){
        this.defSiguientes(this.raiz);
        //this.imprimirSiguientes();
        this.anul_de_Ramas(this.raiz);
        String grafica= "Digraph Arbol_Sintactio {\n\n"+Graficar(this.raiz,"0")+this.direc+"\n\n}";
        this.GenerarDot(grafica, this.nombre);
        //this.verTablaSiguientes();
        this.GenerarDotSiguientes(this.generarTablaSiguientes(), this.nombre);
        //this.generarTabladeTransiciones();
        
    }
    private String Graficar(Nodo nodo,String i){
        int n=0;
        String resultado="";
        String token= nodo.token;
        
        token=token.replace("\"", "'");
        
        resultado=" node [label =\""+token+"    "+nodo.id+"    "+ nodo.getAnulabilidad()+
                "    F:"+this.getFirsts(nodo)+"   L:"+this.getLasts(nodo) +"\"]"+ i+"\n";
        for(int j=0;j<nodo.hijos.size();j++){
            
            this.direc+=i+" -> "+i+n+"\n";
            resultado+= Graficar(nodo.hijos.get(j),""+i+n);
            n++;
            
        }
        
        if(!(nodo.lexema.equals(""))){
            String nodoToken = nodo.lexema;
            nodoToken=nodoToken.replace("\"","");
            resultado+= " node [label = \""+nodoToken+"    "+nodo.id+"    "+nodo.getAnulabilidad()+
                    "    F:"+this.getFirsts(nodo)+"   L:"+this.getLasts(nodo)+"\"]"+i+";\n";
            this.direc+= " node "+i+" -> node "+i+"\n";
        }
        
    
        return resultado;
    }
    private String getFirsts(Nodo nodo){
        String resultado="";
        
        for (int i = 0; i < nodo.getFirst().size(); i++) {
            if(resultado.equals("")){
                resultado+=nodo.getFirst().get(i).toString();
            }else{
                resultado+=","+nodo.getFirst().get(i).toString();
            }
            
        }
        return resultado;
    }
    
    private String getLasts(Nodo nodo){
        String resultado="";
        
        for (int i = 0; i < nodo.getLast().size(); i++) {
            if(resultado.equals("")){
                resultado=nodo.getLast().get(i).toString();
            }else{
                resultado+=","+nodo.getLast().get(i).toString();
            }
            
        }
        return resultado;
    }
    
    private void GenerarDot(String cadena,String nombre){
        FileWriter fichero = null;
        BufferedWriter bw=null;
        try{
            String ruta="C:/Users/elari/Desktop/2021/1er Semestre/ReportesCompi1/Arboles_201700404/";
            File file =new File(ruta+nombre+".dot");
            if(!file.exists()){
                file.createNewFile();
            }
            
            
            
            fichero = new FileWriter(file);
            
            bw =new BufferedWriter(fichero);
            
            bw.write(cadena);
            bw.close();
            fichero.close();
            Ejecutar(ruta,nombre,1);
//            escritor = new PrintWriter(fichero);
//            escritor.println(cadena);
//            escritor.close();
//            fichero.close();
//            Ejecutar(nombre);
        } catch (Exception e) {
            System.out.println("error en generar dot");
            e.printStackTrace();
        }
    }
    public void Ejecutar(String filepath,String filename,int tipoOper) throws IOException {
        
        String file_input_path = filepath+filename+".dot";
        String do_path = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
        
        String file_get_path =  filepath+filename+".jpg" ;
        try {
            ProcessBuilder pBuilder;
            pBuilder = new ProcessBuilder(do_path, "-Tjpg", "-o", file_get_path, file_input_path);
            pBuilder.redirectErrorStream(true);
            pBuilder.start();
            InfoImage info=new InfoImage(file_get_path,filename);
            
            if(tipoOper==1){
                Principal.Arboles.add(info);
            }else if(tipoOper==2){
                Principal.grafosSiguientes.add(info);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       
     
       //Desktop.getDesktop().open(new File(file_get_path));
    }

    public void defSiguientes(Nodo nodo){
        
        for (int i = 0; i < nodo.hijos.size(); i++) {
            if( nodo.hijos.get(i).getHijoIzq()==null && nodo.hijos.get(i).getHijoDer()==null){
                
                //System.out.println("Token: "+nodo.hijos.get(i).token+" anulabilidad: "+nodo.hijos.get(i).getAnulabilidad()+" ide "+nodo.hijos.get(i).id);
                Siguiente siguiente=new Siguiente(nodo.hijos.get(i).id,nodo.hijos.get(i).token);
                this.siguientes.add(siguiente);
            }
            defSiguientes(nodo.hijos.get(i));
    
            
            
        }
        
        
    
    }
    public void anul_de_Ramas(Nodo nodo){
        
        if(nodo.getAnulabilidad()==' '){
        
            int nanul=0;
        
            for (int i = 0; i < nodo.hijos.size(); i++) {
                if(nodo.hijos.get(i).getAnulabilidad()!=' '){//cuantos ya tienen N o A
                    nanul++;
                }
            
            }
            
            
            
            if(nanul==nodo.hijos.size()){// si todos los hijos ya tiene N o A
                
                ArrayList<Integer> f = new ArrayList();
                ArrayList<Integer> l = new ArrayList();
                
                if(nodo.token.equals(".")){
                    
                
                    if(nodo.hijoIzq.getAnulabilidad()=='A' && nodo.hijoDer.getAnulabilidad()=='A'){
                        nodo.setAnulabilidad('A');
                        
                    }else{
                        nodo.setAnulabilidad('N');
                    }
                    
                    if(nodo.hijoDer.getAnulabilidad()=='A'){
                        for (int i = 0; i < nodo.hijoIzq.getLast().size(); i++) {
                            l.add(nodo.hijoIzq.getLast().get(i));
                        }
                        for (int i = 0; i < nodo.hijoDer.getLast().size(); i++) {
                            l.add(nodo.hijoDer.getLast().get(i));
                            
                        }
                        
                        
                        
                        nodo.setLast(l);
                    }else if(nodo.hijoDer.getAnulabilidad()=='N'){
                        //System.out.println("ENTRO A ANULABLES");
                        for (int i = 0; i < nodo.hijoDer.getLast().size(); i++) {
                            l.add(nodo.hijoDer.getLast().get(i));
                        }
                        nodo.setLast(l);
                    }
                    
                    
                    if(nodo.hijoIzq.getAnulabilidad()=='A'){
                        for (int i = 0; i < nodo.hijoIzq.getFirst().size(); i++) {
                            f.add(nodo.hijoIzq.getFirst().get(i));
                        }
                        for (int i = 0; i < nodo.hijoDer.getFirst().size(); i++) {
                            f.add(nodo.hijoDer.getFirst().get(i));
                            
                        }
                        nodo.setFirst(f);
                    }else if(nodo.hijoIzq.getAnulabilidad()=='N'){
                        for (int i = 0; i < nodo.hijoIzq.getFirst().size(); i++) {
                            f.add(nodo.hijoIzq.getFirst().get(i));
                        }
                        nodo.setFirst(f);
                    }
                    
                    
                    for (int i = 0; i < nodo.hijoIzq.getLast().size(); i++) {// cada elemento last de hijoizquierdo
                     
                        for (int j = 0; j < this.siguientes.size(); j++) {
                            if(this.siguientes.get(j).getId()==nodo.hijoIzq.getLast().get(i)){
                                for (int k = 0; k < nodo.hijoDer.getFirst().size(); k++) {
                                    this.siguientes.get(j).exist(nodo.hijoDer.getFirst().get(k));
                                    
                                }
                            }
                            
                        }
                        
                        
                        /*for (int j = 0; j < nodo.hijoDer.getFirst().size(); j++) {
                            this.searchNext(nodo.hijoIzq.getLast().get(i)).exist(nodo.hijoDer.getFirst().get(j));//busca el siguiente con el id
                                                                                                                  //luego se verifica si existe 
                                                                                                                   // en los follow, de lo contrario se agregara
                            
                        }*/
                        
                    }
                    
                    
                    
                    
                    
                    
                    
                    
                
                }else if(nodo.token.equals("*") || nodo.token.equals("?")){
                    nodo.setAnulabilidad('A');
                    
                    if(nodo.hijoIzq!=null){
                        for (int j = 0; j < nodo.hijoIzq.getFirst().size(); j++) {
                            f.add(nodo.hijoIzq.getFirst().get(j));
                            
                        }
                        
                        for (int j = 0; j < nodo.hijoIzq.getLast().size(); j++) {
                            l.add(nodo.hijoIzq.getLast().get(j));
                            
                        }
                        
                    }else if(nodo.hijoDer!=null){
                        for (int j = 0; j < nodo.hijoDer.getFirst().size(); j++) {
                            f.add(nodo.hijoDer.getFirst().get(j));
                            
                        }
                        
                        for (int j = 0; j < nodo.hijoDer.getLast().size(); j++) {
                            l.add(nodo.hijoDer.getLast().get(j));
                            //System.out.println("last de * : "+nodo.hijoDer.getLast().get(j) );
                            
                        }
                        
                    }
                    if(nodo.token.equals("*")){
                        
                        
                        if(nodo.hijoIzq!=null){
                            for (int i = 0; i < nodo.hijoIzq.getLast().size(); i++) {// cada elemento last 
                     
                                for (int j = 0; j < this.siguientes.size(); j++) {
                                    
                                    if(this.siguientes.get(j).getId()==nodo.hijoIzq.getLast().get(i)){
                                        for (int k = 0; k < nodo.hijoIzq.getFirst().size(); k++) {
                                            this.siguientes.get(j).exist(nodo.hijoIzq.getFirst().get(k));
                                            
                                        }
                                    }
                                    
                                }
                        
                                /*for (int j = 0; j < nodo.hijoIzq.getFirst().size(); j++) {
                                    
                                    this.searchNext(nodo.hijoIzq.getLast().get(i)).exist(nodo.hijoIzq.getFirst().get(j));//busca el siguiente con el id
                                                                                                                  //luego se verifica si existe 
                                                                                                                   // en los follow, de lo contrario se agregara
                            
                                }*/
                        
                            }
                        }else if(nodo.hijoDer!=null){
                            
                            
                            
                            for (int i = 0; i < nodo.hijoDer.getLast().size(); i++) {// cada elemento last 
                     
                                for (int j = 0; j < this.siguientes.size(); j++) {
                                    if(this.siguientes.get(j).getId()==nodo.hijoDer.getLast().get(i)){
                                        for (int k = 0; k < nodo.hijoDer.getFirst().size(); k++) {
                                            this.siguientes.get(j).exist(nodo.hijoDer.getFirst().get(k));
                                            
                                        }
                                    }
                                }
                        
                                /*for (int j = 0; j < nodo.hijoDer.getFirst().size(); j++) {
                                    
                                    this.searchNext(nodo.hijoDer.getLast().get(i)).exist(nodo.hijoDer.getFirst().get(j));//busca el siguiente con el id
                                                                                                                  //luego se verifica si existe 
                                                                                                                   // en los follow, de lo contrario se agregara
                            
                                }*/
                        
                            }
                        }
                        
                        
                        
                        
                    }
                    
                    
                    
                    
                    
                    nodo.setFirst(f);
                    nodo.setLast(l);
                    
                    /*for (int i = 0; i < nodo.getLast().size(); i++) {
                        System.out.println("lista de last: "+nodo.getLast().get(i));
                        
                    }*/
                    
                
                
                }else if(nodo.token.equals("|")){
                    if(nodo.hijoIzq.getAnulabilidad()=='A' || nodo.hijoDer.getAnulabilidad()=='A'){
                        
                        
                        nodo.setAnulabilidad('A');
                        
                    }else{
                        nodo.setAnulabilidad('N');
                        
                    }
                    
                    
                    
                    
                    for (int i = 0; i < nodo.hijoIzq.getFirst().size(); i++) {
                            
                        f.add(nodo.hijoIzq.getFirst().get(i));
                    }
                    for (int i = 0; i < nodo.hijoDer.getFirst().size(); i++) {
                            
                        f.add(nodo.hijoDer.getFirst().get(i));
                    }
                    nodo.setFirst(f);
                    
                    for (int i = 0; i < nodo.hijoIzq.getLast().size(); i++) {
                            
                        l.add(nodo.hijoIzq.getLast().get(i));
                    }
                    for (int i = 0; i < nodo.hijoDer.getLast().size(); i++) {
                            
                        l.add(nodo.hijoDer.getLast().get(i));
                    }
                    nodo.setLast(l);
                    
                    
                    
                    
                }else if(nodo.token=="+"){
                    for(int i=0;i<nodo.hijos.size();i++){
                        if(nodo.hijos.get(i).getAnulabilidad()=='A'){
                            nodo.setAnulabilidad('A');
                        }else{
                            nodo.setAnulabilidad('N');
                        }
                        
                        
                    }
                    
                    if(nodo.hijoIzq!=null){
                        for (int j = 0; j < nodo.hijoIzq.getFirst().size(); j++) {
                            f.add(nodo.hijoIzq.getFirst().get(j));
                            
                        }
                        
                        for (int j = 0; j < nodo.hijoIzq.getLast().size(); j++) {
                            l.add(nodo.hijoIzq.getLast().get(j));
                            
                        }
                        
                    }else if(nodo.hijoDer!=null){
                        for (int j = 0; j < nodo.hijoDer.getFirst().size(); j++) {
                            f.add(nodo.hijoDer.getFirst().get(j));
                            
                        }
                        
                        for (int j = 0; j < nodo.hijoDer.getLast().size(); j++) {
                            l.add(nodo.hijoDer.getLast().get(j));
                            
                        }
                        
                    }
                    nodo.setFirst(f);
                    nodo.setLast(l);
                    
                    if(nodo.hijoIzq!=null){
                            for (int i = 0; i < nodo.hijoIzq.getLast().size(); i++) {// cada elemento last 
                     
                                for (int j = 0; j < this.siguientes.size(); j++) {
                                    
                                    if(this.siguientes.get(j).getId()==nodo.hijoIzq.getLast().get(i)){
                                        for (int k = 0; k < nodo.hijoIzq.getFirst().size(); k++) {
                                            this.siguientes.get(j).exist(nodo.hijoIzq.getFirst().get(k));
                                            
                                        }
                                    }
                                    
                                }
                        
                                
                        
                            }
                    }else if(nodo.hijoDer!=null){
                            
                            
                            
                            for (int i = 0; i < nodo.hijoDer.getLast().size(); i++) {// cada elemento last 
                     
                                for (int j = 0; j < this.siguientes.size(); j++) {
                                    if(this.siguientes.get(j).getId()==nodo.hijoDer.getLast().get(i)){
                                        for (int k = 0; k < nodo.hijoDer.getFirst().size(); k++) {
                                            this.siguientes.get(j).exist(nodo.hijoDer.getFirst().get(k));
                                            
                                        }
                                    }
                                }
                        
                                
                        
                            }
                    }
                    
                    
                    
                    
                    
                    
                }
                anul_de_Ramas(this.raiz);
            //aqui verifico el tipo de operacion
            }else{
                for(int i=0;i<nodo.hijos.size();i++){
                    if(nodo.hijos.get(i).getAnulabilidad()==' '){
                        anul_de_Ramas(nodo.hijos.get(i));
                    }
                }
            }
        }
    
    }
    
    public void imprimirSiguientes(){
        System.out.println("----------------------------------------------\n\n");
        for (int i = 0; i < this.siguientes.size(); i++) {
            System.out.println("id: "+this.siguientes.get(i).getId()+" token: "+this.siguientes.get(i).getTerminal());
            
        }
    }
    
    public Siguiente searchNext(int id){
        
        for(Siguiente elemento: this.siguientes){
            if(elemento.getId()==id){
                return elemento;
            }
        }
        return null;
    
    }
    
    public void verTablaSiguientes(){
        System.out.println("\n\nNo.------Id----Follows");
        for (Siguiente elemento: this.siguientes){
            System.out.print(elemento.getId()+"  ");
            System.out.print(elemento.getTerminal()+"  ");
            for (int element: elemento.getFollows()){
                System.out.print(element +", ");
            }
            System.out.println("\n");
            
            
        }
    }
    
    public String generarTablaSiguientes(){
        String result="";
        result="digraph G{\n\n";
        result+="node[ shape=record, fontname=\"Arial\"];\n ";
        String col1="No.";
        String col2="Terminal";
        String col3="Follow";
        for (Siguiente elemento: this.siguientes){
            
            
                col1+="|"+elemento.getId();
                
                
                
                
                col2+="|"+elemento.getTerminal().replace("\"", "'");
                
                String fol="";
                
                
                for (int i = 0; i < elemento.getFollows().size(); i++) {
                    if(fol.equals("")){
                        fol+=elemento.getFollows().get(i).toString();
                    }else{
                        fol+=", "+elemento.getFollows().get(i).toString();
                    }
                    
                }
                col3+="|"+fol;
            
        }
        
        result+="set1 [label=\"{"+col1+"} | {"+col2+"}|{"+col3+"}\"];";
        result+="\n}";
        
        return result;
    }
    private void GenerarDotSiguientes(String cadena,String nombre){
        FileWriter fichero = null;
        BufferedWriter bw=null;
        try{
            String ruta="C:/Users/elari/Desktop/2021/1er Semestre/ReportesCompi1/Siguientes_201700404/";
            File file =new File(ruta+nombre+".dot");
            if(!file.exists()){
                file.createNewFile();
            }
            
            
            
            fichero = new FileWriter(file);
            
            bw =new BufferedWriter(fichero);
            
            bw.write(cadena);
            bw.close();
            fichero.close();
            Ejecutar(ruta,nombre,2);

        } catch (Exception e) {
            System.out.println("error en generar dot");
            e.printStackTrace();
        }
    }
    
    public void generarTabladeTransiciones(){
        LinkedList<Terminal> lista=this.getTerminales();
        
        
        
        Estado init=new Estado(this.generarEstado());
        System.out.println("Firsts de la raiz\n");
        for (int i = 0; i < this.raiz.getFirst().size(); i++) {
            //System.out.println(this.raiz.getFirst().get(i));
            init.addElement(this.raiz.getFirst().get(i));
        }
        Traslado inicial=new Traslado(init,lista);
        
        this.tabladetraslados.add(inicial);
        boolean salida=false;
        while(salida!=true){
            for (int i = 0; i < this.traslados.size(); i++) {
                if(this.traslados.get(i).getEstado().getUtilizada()=='N'){
                    for(int j = 0;j<this.traslados.get(i).getEstado().getElementos().size();j++){//recorrer los elementos del estado
                        for (int k = 0; k < this.siguientes.size(); k++) {
                            if(this.traslados.get(i).getEstado().getElementos().get(j)==this.siguientes.get(k).getId()){
                                //aqui se comparan los elementos de los estados con los ids de la table de siguientes
                            }
                            
                        }
                    }
                    
                }
                
            }
            
            salida=true;
        }
        System.out.println("SI SALIO XD");
        
        
        
    }
    public String generarEstado(){
        this.cont++;
        return "S"+this.cont;
    }
    
    public LinkedList<Terminal> getTerminales(){
        LinkedList<Terminal> aux=new LinkedList();
        int c=0;
        for (Siguiente element: this.siguientes){
            if(c==0){
                aux.add(new Terminal(element.getTerminal()));
            }
            else{
                int encontro=0;
                for (int i = 0; i < aux.size(); i++) {
                    if(aux.get(i).getTerminal().equals(element.getTerminal()) || element.getTerminal().equals("#")){
                        encontro=1;
                    }
                    
                }
                
                if(encontro==0){
                    aux.add(new Terminal(element.getTerminal()));
                }
             }
            c++;
        }
        return aux;
    }
    
    
    
    
    
}
