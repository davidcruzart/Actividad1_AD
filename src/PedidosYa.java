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

