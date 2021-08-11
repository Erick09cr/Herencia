
package herencia;

import java.io.*;
import javax.swing.*;

public class archivo {
    public static String marca="";
    public static String modelo="";
    public static void agregar(){
        try{ 
         marca=JOptionPane.showInputDialog(null,"Digite la marca:");   
         modelo=JOptionPane.showInputDialog(null,"Digite el modelo:");
    
         DataOutputStream d=new DataOutputStream(new FileOutputStream("datos.dat",true));
         d.writeUTF(marca);
         d.writeUTF(modelo);
         
         JOptionPane.showMessageDialog(null,"¡Registro almacenado!");
         d.close();
        }
        catch(IOException ex){
           JOptionPane.showMessageDialog(null,ex.getMessage());
        }
     }
     public static void buscar(){
        String linea=""; 
        try{
          DataInputStream di=new DataInputStream(new FileInputStream("datos.dat"));
         try{
           while(true){
              marca=di.readUTF();
              modelo=di.readUTF();
              linea=linea+marca+" "+modelo+"\n";
           } 
         }
         catch(EOFException ex){
           di.close();
         }
         JOptionPane.showMessageDialog(null,linea);
        }
        catch(FileNotFoundException ex){
           JOptionPane.showMessageDialog(null,"Archivo no encontrado");
        }
        catch(IOException ex){
           JOptionPane.showMessageDialog(null,"Error al buscar");
        }
     }
     public static void editar(){
        String marc="";
        marc=JOptionPane.showInputDialog(null,"Digite la marca del registro a modificar:");
        try{
          DataInputStream di=new DataInputStream(new FileInputStream("datos.dat"));
          DataOutputStream ds=new DataOutputStream(new FileOutputStream("temp.dat"));
          try{
            while(true){
               marca=di.readUTF();
               modelo=di.readUTF();
               
               if (marc.equals(marca)){
                  marca=JOptionPane.showInputDialog(null,"Digite la nueva marca:");
                  modelo=JOptionPane.showInputDialog(null,"Digite el nuevo modelo:");
                  
               }
               ds.writeUTF(marca);
               ds.writeUTF(modelo);
               
            }
          }
          catch(EOFException ex){
            di.close();
            ds.close();
            mover();
          }
        }
        catch(FileNotFoundException ex){
          JOptionPane.showMessageDialog(null,"Archivo no encontrado");
        }
        catch(IOException ex){
          JOptionPane.showMessageDialog(null,"Error al leer");
        }
     }
     public static void eliminar(){
        String marc="";
        marc=JOptionPane.showInputDialog(null,"Digite la marca del registro a eliminar:");
        try{
          DataInputStream di=new DataInputStream(new FileInputStream("datos.dat"));
          DataOutputStream ds=new DataOutputStream(new FileOutputStream("temp.dat"));
          try{
            while(true){
               marca=di.readUTF();
               modelo=di.readUTF();
              
               if (!marc.equals(marca)){
                   ds.writeUTF(marca);
                   ds.writeUTF(modelo);
                   
               }
            }   
          }
          catch(EOFException ex){
            di.close();
            ds.close();
            mover();
          }
        }
        catch(FileNotFoundException ex){
          JOptionPane.showMessageDialog(null,"Archivo no encontrado");
        }
        catch(IOException ex){
          JOptionPane.showMessageDialog(null,"Error al leer");
        }
     }
     public static void mover(){
        try{
          DataInputStream di=new DataInputStream(new FileInputStream("temp.dat"));
          DataOutputStream ds=new DataOutputStream(new FileOutputStream("datos.dat"));
          try{
            while(true){
               marca=di.readUTF();
               modelo=di.readUTF();
               ds.writeUTF(marca);
               ds.writeUTF(modelo);
            }
          }
          catch(EOFException ex){
            di.close();
            ds.close();
          }
        }
        catch(FileNotFoundException ex){
           JOptionPane.showMessageDialog(null,"Archivo no encontrado");
        }
        catch(IOException ex){
          JOptionPane.showMessageDialog(null,"Error al leer");
        }
     }
}


