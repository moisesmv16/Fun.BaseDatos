package modelos;

import conexion.Conexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RestaurateDAO {

    private int idCategoria;
    private String nombre;

    private int IDplatillo;

    private int IDempleado;
    private String nombreEmpleado;
    private String cargo;

    public int getIDempleado() {
        return IDempleado;
    }

    public void setIDempleado(int IDempleado) {
        this.IDempleado = IDempleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getIDplatillo() {
        return IDplatillo;
    }

    public void setIDplatillo(int IDplatillo) {
        this.IDplatillo = IDplatillo;
    }

    public String getNombreplatillo() {
        return nombreplatillo;
    }

    public void setNombreplatillo(String nombreplatillo) {
        this.nombreplatillo = nombreplatillo;
    }

    private String nombreplatillo;
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int insertarCategoria(String nombreCategoria) {
        int idCategoria = -1;
        try {
            // Insertar una nueva categoría
            String insertCategoriaQuery = "INSERT INTO categoria (nombre) VALUES (?)";
            PreparedStatement pstmtCategoria = Conexion.conexion.prepareStatement(insertCategoriaQuery, Statement.RETURN_GENERATED_KEYS);
            pstmtCategoria.setString(1, nombreCategoria);
            pstmtCategoria.executeUpdate();
            // Obtener el idCategoria de la categoría recién creada
            ResultSet id = pstmtCategoria.getGeneratedKeys();
            if (id.next()) {
                idCategoria = id.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idCategoria;
    }

    public int insertarPlatillo(String nombrePlatillo,int idCategoria) {
        int IDplatillo = -1;
        try {
            // Insertar un nuevo platillo y asignarle la categoría
            String insertPlatilloQuery = "INSERT INTO platillo (nombre,idCategoria) VALUES (?, ?)";
            PreparedStatement pstmtPlatillo = Conexion.conexion.prepareStatement(insertPlatilloQuery, Statement.RETURN_GENERATED_KEYS);
            pstmtPlatillo.setString(1, nombrePlatillo);
            pstmtPlatillo.setInt(2, idCategoria);
            pstmtPlatillo.executeUpdate();

            ResultSet id = pstmtPlatillo.getGeneratedKeys();
            if(id.next()){
                IDplatillo = id.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IDplatillo;
    }

    public int insertarEmpleado(String nombreEmpleado, String cargo) {
        int IDempleado = -1;
        try {
            // Insertar un nuevo empleado
            String insertEmpleadoQuery = "INSERT INTO empleado (nombre, cargo) VALUES (?, ?)";
            PreparedStatement pstmtEmpleado = Conexion.conexion.prepareStatement(insertEmpleadoQuery, Statement.RETURN_GENERATED_KEYS);
            pstmtEmpleado.setString(1, nombreEmpleado);
            pstmtEmpleado.setString(2, cargo);
            pstmtEmpleado.executeUpdate();

            ResultSet id = pstmtEmpleado.getGeneratedKeys();
            if (id.next()) {
                IDempleado = id.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IDempleado;
    }

    public int insertarIngrediente(String nombreIngrediente, int cantidad) {
        int IDIngrediente = -1;
        try {
            // Insertar un nuevo ingrediente
            String insertIngredienteQuery = "INSERT INTO ingredientes (nombre, cantidad) VALUES (?, ?)";
            PreparedStatement pstmtIngrediente = Conexion.conexion.prepareStatement(insertIngredienteQuery, Statement.RETURN_GENERATED_KEYS);
            pstmtIngrediente.setString(1, nombreIngrediente);
            pstmtIngrediente.setInt(2, cantidad);
            pstmtIngrediente.executeUpdate();

            ResultSet id = pstmtIngrediente.getGeneratedKeys();
            if (id.next()) {
                IDIngrediente = id.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IDIngrediente;
    }

    public int insertarMesa(String numeroMesa, int capacidad) {
        int mesaID = -1;
        try {
            // Insertar una nueva mesa
            String insertMesaQuery = "INSERT INTO mesa (Numero, capacidad) VALUES (?, ?)";
            PreparedStatement pstmtMesa = Conexion.conexion.prepareStatement(insertMesaQuery, Statement.RETURN_GENERATED_KEYS);
            pstmtMesa.setString(1, numeroMesa);
            pstmtMesa.setInt(2, capacidad);
            pstmtMesa.executeUpdate();

            ResultSet id = pstmtMesa.getGeneratedKeys();
            if (id.next()) {
                mesaID = id.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mesaID;
    }

    public int insertarPromocion(String nombrePromocion, String descripcionPromocion, int idPlatillo) {
        int IDpromocion = -1;
        try {
            // Insertar una nueva promoción
            String insertPromocionQuery = "INSERT INTO promociones (nombre, descripcion, IDplatillo) VALUES (?, ?, ?)";
            PreparedStatement pstmtPromocion = Conexion.conexion.prepareStatement(insertPromocionQuery, Statement.RETURN_GENERATED_KEYS);
            pstmtPromocion.setString(1, nombrePromocion);
            pstmtPromocion.setString(2, descripcionPromocion);
            pstmtPromocion.setInt(3, idPlatillo);
            pstmtPromocion.executeUpdate();

            ResultSet id = pstmtPromocion.getGeneratedKeys();
            if (id.next()) {
                IDpromocion = id.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IDpromocion;
    }

    public int insertarUsuario(String nombreUsuario, String contrasena) {
        int IDUsuario = -1;
        try {
            // Insertar un nuevo usuario
            String insertUsuarioQuery = "INSERT INTO usuario (nombre, contrasena) VALUES (?, ?)";
            PreparedStatement pstmtUsuario = Conexion.conexion.prepareStatement(insertUsuarioQuery, Statement.RETURN_GENERATED_KEYS);
            pstmtUsuario.setString(1, nombreUsuario);
            pstmtUsuario.setString(2, contrasena);
            pstmtUsuario.executeUpdate();

            ResultSet id = pstmtUsuario.getGeneratedKeys();
            if (id.next()) {
                IDUsuario = id.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IDUsuario;
    }

    public int insertarPedido(int idUsuario, int idEmpleado, int mesaID) {
        int idPedido = -1;
        try {
            // Insertar un nuevo pedido
            String insertPedidoQuery = "INSERT INTO pedido (IDUsuario, IDempleado, MesaID) VALUES (?, ?, ?)";
            PreparedStatement pstmtPedido = Conexion.conexion.prepareStatement(insertPedidoQuery, Statement.RETURN_GENERATED_KEYS);
            pstmtPedido.setInt(1, idUsuario);
            pstmtPedido.setInt(2, idEmpleado);
            pstmtPedido.setInt(3, mesaID);
            pstmtPedido.executeUpdate();

            ResultSet id = pstmtPedido.getGeneratedKeys();
            if (id.next()) {
                idPedido = id.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idPedido;
    }

    public int insertarComentario(String textoComentario, int idPedido) {
        int IDcomentario = -1;
        try {
            // Insertar un nuevo comentario y asignarle el pedido
            String insertComentarioQuery = "INSERT INTO comentario (comentario, IDpedido) VALUES (?, ?)";
            PreparedStatement pstmtComentario = Conexion.conexion.prepareStatement(insertComentarioQuery, Statement.RETURN_GENERATED_KEYS);
            pstmtComentario.setString(1, textoComentario);
            pstmtComentario.setInt(2, idPedido);
            pstmtComentario.executeUpdate();

            ResultSet id = pstmtComentario.getGeneratedKeys();
            if (id.next()) {
                IDcomentario = id.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IDcomentario;
    }

    public int insertarDescuento(double porcentaje, int idPedido) {
        int IDdescuento = -1;
        try {
            // Insertar un nuevo descuento
            String insertDescuentoQuery = "INSERT INTO Descuentos (porcentaje, IDpedido) VALUES (?, ?)";
            PreparedStatement pstmtDescuento = Conexion.conexion.prepareStatement(insertDescuentoQuery, Statement.RETURN_GENERATED_KEYS);
            pstmtDescuento.setDouble(1, porcentaje);
            pstmtDescuento.setInt(2, idPedido);
            pstmtDescuento.executeUpdate();

            ResultSet id = pstmtDescuento.getGeneratedKeys();
            if (id.next()) {
                IDdescuento = id.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IDdescuento;
    }

    public boolean insertarHechoCon(int idPlatillo, int idIngredientes) {
        try {
            // Insertar una nueva relación en la tabla hechocon
            String insertHechoConQuery = "INSERT INTO hechocon (IDplatillo, IDIngredientes) VALUES (?, ?)";
            PreparedStatement pstmtHechoCon = Conexion.conexion.prepareStatement(insertHechoConQuery);
            pstmtHechoCon.setInt(1, idPlatillo);
            pstmtHechoCon.setInt(2, idIngredientes);
            pstmtHechoCon.executeUpdate();

            return true; // La inserción fue exitosa
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Hubo un error en la inserción
        }
    }

    public int insertarCaja(double saldoInicial, double saldoFinal) {
        int cajaID = -1;
        try {
            // Insertar una nueva caja
            String insertCajaQuery = "INSERT INTO caja (saldoInicial, saldoFinal) VALUES (?, ?)";
            PreparedStatement pstmtCaja = Conexion.conexion.prepareStatement(insertCajaQuery, Statement.RETURN_GENERATED_KEYS);
            pstmtCaja.setDouble(1, saldoInicial);
            pstmtCaja.setDouble(2, saldoFinal);
            pstmtCaja.executeUpdate();

            ResultSet id = pstmtCaja.getGeneratedKeys();
            if (id.next()) {
                cajaID = id.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cajaID;
    }

    public int insertarPago(String metodo, int total, int idPedido, int cajaID) {
        int IDpago = -1;
        try {
            // Insertar un nuevo pago
            String insertPagoQuery = "INSERT INTO pago (metodo, total, IDpedido, cajaID) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmtPago = Conexion.conexion.prepareStatement(insertPagoQuery, Statement.RETURN_GENERATED_KEYS);
            pstmtPago.setString(1, metodo);
            pstmtPago.setInt(2, total);
            pstmtPago.setInt(3, idPedido);
            pstmtPago.setInt(4, cajaID);
            pstmtPago.executeUpdate();

            ResultSet id = pstmtPago.getGeneratedKeys();
            if (id.next()) {
                IDpago = id.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IDpago;
    }

    public int insertarReserva(int numPersonas, String fecha, int mesaID, int idUsuario) {
        int IDreserva = -1;
        try {
            // Insertar una nueva reserva
            String insertReservaQuery = "INSERT INTO Reserva (numPersonas, fecha, MesaID, IdUsuario) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmtReserva = Conexion.conexion.prepareStatement(insertReservaQuery, Statement.RETURN_GENERATED_KEYS);
            pstmtReserva.setInt(1, numPersonas);
            pstmtReserva.setString(2, fecha);
            pstmtReserva.setInt(3, mesaID);
            pstmtReserva.setInt(4, idUsuario);
            pstmtReserva.executeUpdate();

            ResultSet id = pstmtReserva.getGeneratedKeys();
            if (id.next()) {
                IDreserva = id.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return IDreserva;
    }

    /*public int insertarUsuario(String nombreUsuario) {
        int idPedido = -1;
        try {
            // Insertar una nueva categoría
            String insertCategoriaQuery = "INSERT INTO Pedido (cliente) VALUES (?)";
            PreparedStatement pstmtCategoria = Conexion.conexion.prepareStatement(insertCategoriaQuery, Statement.RETURN_GENERATED_KEYS);
            pstmtCategoria.setString(1, nombreUsuario);
            pstmtCategoria.executeUpdate();
            // Obtener el idCategoria de la categoría recién creada
            ResultSet id = pstmtCategoria.getGeneratedKeys();
            if (id.next()) {
                idPedido = id.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idPedido;
    }*/




    /*public void insertarCompra(int idPlatillo, int idPedido, int Precio, int Total, int Cantidad) {
        try {
            // Insertar una nueva compra asignándole la categoría y el pedido
            String insertCompraQuery = "INSERT INTO DetallePedido (idPlatillo, idPedido, Precio, Total, Cantidad) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmtCompra = Conexion.conexion.prepareStatement(insertCompraQuery);
            pstmtCompra.setInt(1, idPlatillo);
            pstmtCompra.setInt(2, idPedido);
            pstmtCompra.setInt(3, Precio);
            pstmtCompra.setInt(4, Total);
            pstmtCompra.setInt(5, Cantidad);
            pstmtCompra.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    /*public void eliminarTodo() {
        try {

            String queryDetalle = "DELETE FROM DetallePedido";
            Statement stmtDetalle = Conexion.conexion.createStatement();
            stmtDetalle.executeUpdate(queryDetalle);

            // Luego, elimina los registros de la tabla "Pedido"
            String queryPedido = "DELETE FROM Pedido";
            Statement stmtPedido = Conexion.conexion.createStatement();
            stmtPedido.executeUpdate(queryPedido);

            String queryPlatillo = "DELETE FROM Platillo";
            Statement stmtPlatillo = Conexion.conexion.createStatement();
            stmtPlatillo.executeUpdate(queryPlatillo);

            String queryCategorias = "DELETE FROM Categorias";
            Statement stmtCategorias = Conexion.conexion.createStatement();
            stmtCategorias.executeUpdate(queryCategorias);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public ObservableList<RestaurateDAO> LISTARPRODUCTOS(){
        ObservableList<RestaurateDAO> ListTaq = FXCollections.observableArrayList();
        RestaurateDAO objC;
        try{
            String query = "SELECT * FROM platillo";
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                objC = new RestaurateDAO();
                objC.setIDplatillo(res.getInt("IDplatillo"));
                objC.setNombreplatillo(res.getString("nombre"));
                ListTaq.add(objC);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ListTaq;
    }

    /*public ObservableList<RestaurateDAO> LISTARCATEGORIAS(){
        ObservableList<RestaurateDAO> ListTaq = FXCollections.observableArrayList();
        RestaurateDAO objC;
        try{
            String query = "SELECT * FROM categoria";
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                objC = new RestaurateDAO();
                objC.setIdCategoria(res.getInt("idCategoria"));
                objC.setNombre(res.getString("nombre"));
                ListTaq.add(objC);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ListTaq;
    }*/


   /* public void ELIMINARPLATILLO(){
        try{
            String query = "DELETE FROM DetallePedido WHERE idPlatillo = "+this.idPlatillo;
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

    public void ELIMINARPLATILLOTODO(){
        try{
            String query = "DELETE FROM platillo WHERE IDplatillo = "+this.IDplatillo;
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void ELIMINARCATEGORIANUEVA(){
        try{
            String query = "DELETE FROM categoria WHERE idCategoria = "+this.idCategoria;
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
