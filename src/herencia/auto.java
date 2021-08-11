
package herencia;

public class auto extends ctransporte {
    String transmision="";
    
    public void asignarTransmision(String trans){
        transmision=trans;
    }
    public String obtenerTransmision(){
        return   transmision;
    }
}
