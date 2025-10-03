import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PedidosYa {

    public static void main(String[] args) {

    }
   public static void exportarClientes(String path){
       List <Clientes>listaClientes = new ArrayList<>();
       listaClientes.add(new Clientes(1,"Xavi","xavi@email.com"));
       listaClientes.add(new Clientes(2,"Unai","unai@email.com"));
       listaClientes.add(new Clientes(3,"David", "david@email.com"));

       //Añado el File - Xavi.

       File file = new File(path);
       PrintWriter printWriter = null;

       //añado el try catch y sus excepciones,
       // OJO! TRUQUI:
       // Seleccionas el codigo, te pones encima sale la opcion Surround alli metes try catch y te lo envuelve
       try {
           printWriter = new PrintWriter(new FileWriter(file, true));
           printWriter.println("id, nombre, email");
           for (Clientes cliente : listaClientes){
               printWriter.println(cliente);
           }
       } catch (IOException e) {
           throw new RuntimeException(e);
       }finally{
           printWriter.close();
       }

   }
    public static void exportarPedidos(String path){
        List <Pedidos>listaPedidos = new ArrayList<>();
        listaPedidos.add(new Pedidos(1, 1, "AgeOfEmpires II", 200));
        listaPedidos.add(new Pedidos(2, 2, "Battlefield 6", 100));
        listaPedidos.add(new Pedidos(3, 3, "Silk Song",  5));
        listaPedidos.add(new Pedidos(3, 3, "OSU", 1));
        listaPedidos.add(new Pedidos(3, 3, "Cookie Clicker", 50));
    }

}

