import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PedidosYa {


   public void exportarClientes(String path){
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
       File parentDir = file.getParentFile();
       // Crear directorio si no existe
       if (parentDir != null && !parentDir.exists()) {
           parentDir.mkdirs();
       }
       try {
           printWriter = new PrintWriter(new FileWriter(file, true)); //false se sobreescibe
           printWriter.println("id, nombre, email");
           for (Clientes cliente : listaClientes){
               printWriter.println(cliente);
           }
       } catch (IOException e) {
           System.out.println("Error entrada fichero");;
       }finally{
           if (printWriter != null){
            printWriter.close(); }
       }

   }
    public void exportarPedidos(String path){
        List <Pedidos>listaPedidos = new ArrayList<>();
        listaPedidos.add(new Pedidos(1, 1, "AgeOfEmpires II", 200));
        listaPedidos.add(new Pedidos(2, 2, "Battlefield 6", 100));
        listaPedidos.add(new Pedidos(3, 3, "Silk Song",  5));
        listaPedidos.add(new Pedidos(3, 3, "OSU", 1));
        listaPedidos.add(new Pedidos(3, 3, "Cookie Clicker", 50));

        File file = new File(path);
        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(new FileWriter(file, true));
            printWriter.println("id, producto, cantidad");
            for (Pedidos pedido : listaPedidos){
                printWriter.println(pedido);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            printWriter.close();
        }
    }

    public void escribirObjetoClientes(String path){
       File file = new File(path);
       FileOutputStream fos = null;
       ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(new Clientes(4, "Borja", "borja@gmail.com"));
            oos.writeObject(new Clientes(4, "Nayara", "nayara@gmail.com"));
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        }catch (IOException e){
            System.out.println("No hay permisos de escritura");
        } finally {
            try {
                oos.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado de fichero");
            }
        }
    }

    public void escribirObjetoPedidos(String path){
        File file = new File(path);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(new Pedidos(4, 4, "Balatro", 1));
            oos.writeObject(new Pedidos(3, 1, "AgeOfEmpires II", 3));
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e){
            System.out.println("No hay permisos de escritura");
        } finally {
            try {
                oos.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado de fichero");
            }
        }
    }
    public void leerClienteObj(String path){
       File file = new File(path);
       FileInputStream fis = null;
       ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            Clientes cliente = null;

            while ((cliente = (Clientes) ois.readObject()) != null){
                System.out.println(cliente.getId());
                System.out.println(cliente.getNombre());
                System.out.println(cliente.getEmail());
            }

        }catch (FileNotFoundException e) {
            System.out.println("Error, el fichero no existe");;
        }catch(EOFException e){
            System.out.println("Fin de fichero");
        }catch (IOException e) {
            System.out.println("No hay permisos de escritura");
        }catch (ClassNotFoundException | ClassCastException e) {
            System.out.println("Error clase de lectura");
        } finally {
            try {
                ois.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado del fichero");
            }
        }
    }
    public void leerPedidosObj(String path){
        File file = new File(path);
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            Pedidos pedido = null;

            while ((pedido = (Pedidos) ois.readObject()) != null){
                System.out.println(pedido.getId());
                System.out.println(pedido.getClienteId());
                System.out.println(pedido.getCantidad());
                System.out.println(pedido.getProducto());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error, el fichero no existe");;
        }catch(EOFException e){
            System.out.println("Fin de fichero");
        }catch (IOException e) {
            System.out.println("No hay permisos de escritura");
        } catch (ClassNotFoundException | ClassCastException e) {
            System.out.println("Error clase de lectura");
        } finally {
            try {
                ois.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado del fichero");
            }
        }
    }

}

//*  public static void main(String[] args) {
//        //Aquí va la lógica para la exportación y el path
//
//
//    } */