package recursohumano;

import java.sql.*;//libresrias para la conexiones a la bd 

import java.sql.Connection;
import java.sql.SQLException;



public class ConexionCRUD {
    
    /*Ruta de la base de datos del sevidor 127.0.0.1, el puerto 3306 y el nombre de la base de datos bd_recurso_humano*/
    private final String servidor = "jdbc:mysql:/127.0.0.1:3306/bd_recurso_humano";    
    //nmbre del usuario
    private final String usuario = "root";
    //clabe del usuario de la base de datos
    private final String clave = "";
    //libreria de mysql
    private final String driverConector ="com,mysql.jdbc.Drive";
    //objeto de la clase connection del paquete java.sql
    private static Connection conexion; 
    
    public ConexionCRUD (){
        try{
            Class.forName(driverConector);//Levantar el driver
            //Establecer conexion
            conexion=DriverManager.getConnection(servidor, usuario, clave);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Conexion fallida! Error! :" + e.getMessage());
        }
    }
    
    public Connection getConnection(){
        return conexion; //Debuelve el objeto conexxion
    }
}

    public void guardarRegistros(String tabla, String camposTabla, String valoresCampos){
    //caragar la conexion
    ConexionCRUD conectar = new ConexionCRUD();
    Connection cone = conectar.getConnection();
    try{
         //Definir la sentencia sql
         String sqlQueryStmt = "INSERT INTO" + tabla + "("+ camposTabla + ") VALUES ( " + valoresCampos + ");";
         //Estableser la cominicacion entre nustras aplicaciones java y la base de datos
         Statement stmt; //Enviar sentencia a la base de datos
         stmt = cone.createStatement();
         stmt.executeUpdate(sqlQueryStmt);//ejecutal al conexion sql
         //Cerrar el Statement y la conxion; se cierran en orden inverso de como se han abierto
         stmt.close();
         cone.close():
         System.out.println("Reguistro guardado corectamente!");
    }catch(Exeption e){
     System.out.println(e.getMenssage());
    }
}  
 
    public void actualizarEliminarRegistros(Srting tabla, Srting valoresCamposNuevos, Srting condicion){
    //cargar la conexion
    ConexionCRUD conectar = new conexionCRUD();
    Connection cone = conectar.getConnection();
    try{
        Statement stmt;
        String sqlQueryStmt;
        //Verificar que valoresCamposNuevos venga vacia y asi seleccionar borrar o actualizar registro
        if(valoresCamposnuevos.isEmpty()){
            sqlQueryStmt = "DELETE FROM" + tabla + "WHERE" + condicion + ";"; 
       }else{
            sqlQueryStmt = "UPDATE" + tabla + "SET" + valoresCamposNuevos + "WHERE" + condicion + ";";
    }
    stmt = cone.ceateStatement();
    stmt.executeUpdate(sqlQueryStmt);
    stmt.close();
    cone.close();
    }catch (SQLException ex){
       System.out.printl("Ha ocurrido el siguiente error :" + ex.getMessage());
   }
}
 
    public void desplegarRegistros(String tablaBuscar, String campoBuscar, String condicionBuscar) throws SQLException{
    //cargar conexion
    conexionCRUD conectar = new conexionCRUD();
    connection cone = conectar.getConnection();
 try {
       Statement stmt;
       String sqlQueryStmt;
       if (condicionBuscar.equals("")){
       }else{
           sqlQueryStmt="SELEC" + camposBuscar + "FROM" + tablaBuscar + ";";
       }
       stmt = cone.createStatement();
       stmt.executeQuery(sqlQueryStmt);
       //le indicamos la consulta de la tabla y le pasamos por argumentos nuestra sentencia
       try(ResultSet miResultSet = stmt.executeQuery(sqlQueryStmt)){
          if (miResultSet.next()) { //ubica el cursor de la primera fila de la tabla de resultado  
              ResultSetMetaData metaData = miResultSet.getMetaData();
              int numColumnas = metaData.getColumnCount(); //obtener el numero de columnas de la consulta
              System.out.print("<<REGISTROS ALMACENADOS>>");
              System.out.print();
              
            for (int i = 1; i <= numColumnas; i++){
            //muestra los titlos de las columnas y %-20\t indiva la separacion entre columnas
            System.out.printf("%-20s\t", metaData.getColumnName(i));
            }
            System.out.println();
            do{
                for (int i = 1; i <= numColumnas; i++){
                     System.out.printf("%-20s\t", miResultSet.getObject(i));
                }
                 System.out.printl();
            } while (miResulSet.nex());  
            System.out.printl();
        } else {
            System.out.println("no se a encontrado registros");
        }
        miResulSet.close(); //Cerrar el ResulSet
    }finally{
         //Cerrar el Statement y la conexion; se cieerran en orden inverso de como se han abierto
          stmt.close();
          cone.close();
        }
    } catch (SQLExcetion ex) {
        System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
        }
    }
}

