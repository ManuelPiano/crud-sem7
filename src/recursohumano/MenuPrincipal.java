/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursohumano;
import java.sql.SQLException;
import java.util.Scanner;
public class MenuPrincipal {
    public static void main(String[] args) throws SQLException {
        desplegarmenu();
    }
        public static void desplegarmenu()throws SQLException {
            Scanner opcionSeleccionada =new Scanner(System.in);
            String opcionmenu;
            //menu a desplegar
            System.out.println("*************************************");
            System.out.println("|       CRUD DE JAVA EN CONSOLA     |");
            System.out.println("*************************************");
            System.out.println("| Opciones:                         |");
            System.out.println("|           1. Crear Registros      |");
            System.out.println("|           2. Consultar Registros  |");
            System.out.println("|           3. Actualizar Registros |");
            System.out.println("|           4. Eliminar Registros   |");
            System.out.println("|           5. Salir                |");
            System.out.println("*************************************");
            System.out.println("Seleccionar Opcion: ");
            opcionmenu = opcionSeleccionada.next();
            //Despliegue de menu basado en la opcion seleccionada
            switch (opcionmenu) {
                case "1":
                    //Create create = new Create();
                    break;
                case "2":
                    //Read read = new Read();
                    break;
                case "3":
                    //Update update = new Update();
                    break;
                case "4":
                    //Delete delete = new Delete();
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Seleccion Invalida!");
                    break;         
        }  
    }
}
