
package herencia;

import javax.swing.*;
import java.io.*;

public class Herencia {

    
    public static void main(String[] args) {
      menu();
    }   
    public static void menu(){
        archivo a=new archivo();
        String menu="       MENU PRINCIPAL\n\n1.Agregar\n2.Editar\n3.Eliminar\n4.Consultar\n5.Salir\n\nDigite su opción:";
        int op=Integer.parseInt(JOptionPane.showInputDialog(null,menu));
        switch(op){
            case 1:{a.agregar();menu();break;}
            case 2:{a.editar();menu();break;}
            case 3:{a.eliminar();menu();break;}
            case 4:{a.buscar();menu();break;}
            case 5:{System.exit(0);break;}
            default:{JOptionPane.showMessageDialog(null,"¡Opción incorrecta!");menu();}
        }
    }
}
