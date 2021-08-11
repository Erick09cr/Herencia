
package herencia;

import java.io.*;
import javax.swing.*;

public class ctransporte {
    String marca="", modelo="";
    int anno=0;
    
    public void asignarMarca(String mar){
        marca=mar;
    }
    public void asignarModelo(String mod){
        modelo=mod;
    }
    public void asignarAnno(int an){
        anno=an;
    }
    public String obtenerMarca(){
        return marca;
    }
    public String obtenerModelo(){
        return modelo;
    }
    public int obtenerAnno(){
        return anno;
    }
}

