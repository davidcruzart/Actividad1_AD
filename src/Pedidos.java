import java.io.Serializable;

public class Pedidos implements Serializable {

    private static final long serialVersionUID = 5678L;
    private int id, clienteId, cantidad;
    private String producto;

    public Pedidos(int id, int clienteId, String producto, int cantidad) {
        this.id = id;
        this.clienteId = clienteId;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Pedidos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "id=" + id +
                ", clienteId=" + clienteId +
                ", cantidad=" + cantidad +
                ", producto='" + producto + '\'' +
                '}';
    }
}

