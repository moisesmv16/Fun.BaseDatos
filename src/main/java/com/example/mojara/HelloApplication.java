package com.example.mojara;

import componentes.ButtonCell;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import conexion.Conexion;
import javafx.util.Callback;
import modelos.RestaurateDAO;

import java.io.IOException;

public class HelloApplication extends Application {
    private Scene escena;
    private Stage MenuPrincipal,MenuPlatillos,MenuHamburguesas,MenuBebidas,MenuAcompañantes;
    private Stage MenuEmpleado,MenuIngre;
    private Button btnPlatillos,btnBebidas,btnDetallePedido,btnPromo;
    private Button btnCaja,btnMesas,btnReservacion,btnDescu;
    private Button btnComentarios,btnPedido,btnSuge,btnHecho,
                   btnEmpleados,btnIngre,btnPago;
    private Button btnHamburguesas,btnBebida,btnAcompañante;

    private Button btnAgua,btnRefresco,btnTeHelado;

    private Button btnsencilla,btndoble,btnhawaiana;
    private Button btnPapas,btnAlitas,btnNuget;
    private Button btnHombre, btnMujer;
    private Button btnRepartidor,btnChef,btnPinche;
    private Button btnPan,btnCarne,btnTomate,btnPapa,btnAli,btnNu;
    private Button btnmesax2,btnmesax4,btnmesa6;
    private Button btn2x1,btnestu,btnbts;
    private Button btnordenar;
    private Button btnBueno,btnMalo;
    private Button btn5,btn10,btn15,btnhechocon;
    private Button btnverCaja,btnefec,btntarjeta;
    private Button btnReser2,btnReser4,btnreser6,btnActu;
    private VBox vbox1,vbox2,vbox3,vbox4,vboxcategorias,vboxPlatillos1;

    private HBox hboxPrincipal,hboxcategorias,hboxLogin,hboxLoginusu;
    private HBox hboxEmpleado,hboxEmpleado1;
    private RestaurateDAO restaurateDAO;
    private TableView<RestaurateDAO>tvbRestaurante;

    @Override
    public void start(Stage stage) throws IOException {
        connectToDB();
        Login(stage);
    }

    public void connectToDB(){
        Conexion.createConnection();
        System.out.println("Conexion establecida");
    }
    private void Login(Stage stage) {
        Stage MenuLogin = new Stage();
        hboxLoginusu = new HBox();
        hboxLogin = new HBox(hboxLoginusu);
        btnHombre = new Button("HOMBRE");
        btnMujer = new Button("MUJER");

        btnHombre.setPrefWidth(300);
        btnHombre.setPrefHeight(300);

        btnMujer.setPrefWidth(300);
        btnMujer.setPrefHeight(300);

        btnHombre.setOnAction(event -> {
            MenuPrincipalMojara();
            AsignarHombreusu();
        });

        btnMujer.setOnAction(event ->{
            MenuPrincipalMojara();
            AsignarMujerUsu();
        });

        hboxLoginusu.getChildren().setAll(btnHombre,btnMujer);
        Scene PlatilloEscena = new Scene(hboxLogin, 600, 400); // Ajusta el tamaño según tus necesidades
        MenuLogin.setScene(PlatilloEscena);
        MenuLogin.setTitle("Selecciona tu usuario...");
        MenuLogin.show();

    }

    private void MenuPrincipalMojara() {
        restaurateDAO = new RestaurateDAO();
        tvbRestaurante = new TableView<>();
        CrearTabla();
        MenuPrincipal = new Stage();
        hboxPrincipal = new HBox();
        //btnDetallePedido = new Button("DetallePedido");
        btnPlatillos = new Button("Platillos");
        btnBebidas = new Button("Bebidas");
        btnPromo = new Button("Promos");

        //btnDetallePedido.setPrefWidth(150);
        //btnDetallePedido.setPrefHeight(150);
        //btnDetallePedido.setOnAction(event -> {
           //TablaPedido();
        //});

        btnPlatillos.setPrefWidth(150);
        btnPlatillos.setPrefHeight(150);

        btnBebidas.setPrefWidth(150);
        btnBebidas.setPrefHeight(150);

        btnPromo.setPrefWidth(150);
        btnPromo.setPrefHeight(150);
        btnPromo.setOnAction(event -> PantallaPromo());

        btnPlatillos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MenuPlatillos = new Stage();
                vboxcategorias = new VBox();
                hboxcategorias = new HBox(vboxcategorias);

                btnHamburguesas = new Button("Hamburguesas");
                btnBebidas = new Button("bebidas");
                btnAcompañante = new Button("acompañante");

                // Configuración de los nuevos botones
                btnHamburguesas.setPrefWidth(200);
                btnHamburguesas.setPrefHeight(200);

                btnBebidas.setPrefWidth(200);
                btnBebidas.setPrefHeight(200);

                btnAcompañante.setPrefWidth(200);
                btnAcompañante.setPrefHeight(200);

                btnHamburguesas.setOnAction(event -> {
                    PantallaHamburguesa();
                    AbrirCategoriaHambu();
                });

                btnBebidas.setOnAction(event -> {
                    PantallaBedidas();
                    AbrirCategoriaBebida();
                });

                btnAcompañante.setOnAction(event -> {
                    PantallaAcompañante();
                    AbrirCategoriaAcompa();
                });
                // Agregar los nuevos botones al contenedor
                vboxcategorias.getChildren().addAll(btnHamburguesas, btnBebidas, btnAcompañante);

                // Crear la escena y mostrar la nueva ventana
                Scene PlatilloEscena = new Scene(hboxcategorias, 600, 400); // Ajusta el tamaño según tus necesidades
                MenuPlatillos.setScene(PlatilloEscena);
                MenuPlatillos.setTitle("Selecciona...");
                MenuPlatillos.show();
            }
        });

        vbox1 = new VBox();
        vbox1.setSpacing(35);
        vbox1.getChildren().addAll(btnPlatillos,btnBebidas,btnPromo);

        btnCaja = new Button("Cajas");
        btnMesas = new Button("Mesas");
        btnDescu = new Button("Descuentos");
        btnReservacion = new Button("Reservaciones");

        btnCaja.setPrefWidth(150);
        btnCaja.setPrefHeight(150);
        btnCaja.setOnAction(event -> {
            PantallaCaja();
        });

        btnMesas.setPrefWidth(150);
        btnMesas.setPrefHeight(150);
        btnMesas.setOnAction(event -> PantallaMesa());

        btnDescu.setPrefWidth(150);
        btnDescu.setPrefHeight(150);
        btnDescu.setOnAction(event -> {
            PantallaDescuentos();
        });

        btnReservacion.setPrefWidth(150);
        btnReservacion.setPrefHeight(150);
        btnReservacion.setOnAction(event -> {
            PantallaReserva();
        });

        vbox2 = new VBox();
        vbox2.setSpacing(35);
        vbox2.getChildren().addAll(btnCaja,btnMesas,btnDescu,btnReservacion);

        btnComentarios = new Button("Comentarios");
        btnPedido = new Button("Pedidos");
        btnSuge = new Button("Sugerencia");
        btnHecho = new Button("Hecho con");

        btnComentarios.setPrefWidth(150);
        btnComentarios.setPrefHeight(150);

        btnComentarios.setOnAction(event -> {
            PantallaComentarios();
        });

        btnPedido.setPrefWidth(150);
        btnPedido.setPrefHeight(150);

        btnPedido.setOnAction(event -> {
            PantallaPedido();
        });

        btnSuge.setPrefWidth(150);
        btnSuge.setPrefHeight(150);

        btnHecho.setPrefWidth(150);
        btnHecho.setPrefHeight(150);

        btnHecho.setOnAction(event ->{
            HechoCon();
        });

        vbox3 = new VBox();
        vbox3.setSpacing(35);
        vbox3.getChildren().addAll(btnComentarios,btnPedido,btnSuge,btnHecho);

        btnEmpleados = new Button("Empleados");
        btnIngre = new Button("Ingredientes");
        btnPago = new Button("Pago");

        btnEmpleados.setPrefWidth(150);
        btnEmpleados.setPrefHeight(150);

        btnEmpleados.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MenuEmpleado = new Stage();
                hboxEmpleado = new HBox();

                btnChef = new Button("Chef");
                btnRepartidor = new Button("Repartidor");
                btnPinche = new Button("Pinche");

                btnChef.setPrefHeight(200);
                btnChef.setPrefWidth(200);

                btnRepartidor.setPrefWidth(200);
                btnRepartidor.setPrefHeight(200);

                btnPinche.setPrefHeight(200);
                btnPinche.setPrefWidth(200);

                btnChef.setOnAction(event ->{
                    Asignarchef();
                });

                btnRepartidor.setOnAction(event ->{
                    AsignarRepa();
                });

                btnPinche.setOnAction(event ->{
                    Asignarpinche();
                });

                hboxEmpleado.getChildren().addAll(btnChef,btnRepartidor,btnPinche);

                Scene PlatilloEscena = new Scene(hboxEmpleado, 600, 400); // Ajusta el tamaño según tus necesidades
                MenuEmpleado.setScene(PlatilloEscena);
                MenuEmpleado.setTitle("Selecciona...");
                MenuEmpleado.show();
            }
        });

        btnIngre.setPrefWidth(150);
        btnIngre.setPrefHeight(150);

        btnIngre.setOnAction(event -> {
            PantallaIngre();
        });

        btnPago.setPrefWidth(150);
        btnPago.setPrefHeight(150);
        btnPago.setOnAction(event -> {
            PantallaPago();
        });

        vbox4 = new VBox();
        vbox4.setSpacing(35);
        vbox4.getChildren().addAll(btnEmpleados,btnIngre,btnPago);

        hboxPrincipal = new HBox(vbox1,new Separator(),vbox2,new Separator(),vbox3,new Separator(),vbox4);
        Scene segundaEscena = new Scene(hboxPrincipal, 200, 150);
        MenuPrincipal.setScene(segundaEscena);
        MenuPrincipal.setTitle("Menu Principal");
        MenuPrincipal.show();
    }

    private void PantallaHamburguesa(){
        MenuHamburguesas = new Stage();
        VBox vboxhamburguesas = new VBox();
        HBox hboxhamburguesas = new HBox(vboxhamburguesas);

        btnsencilla = new Button("Hamburguesa sencilla");
        btndoble = new Button("Hamburguesa doble");
        btnhawaiana = new Button("Hamburguesa hawaina");

        // Configuración de los nuevos botones
        btnsencilla.setPrefWidth(200);
        btnsencilla.setPrefHeight(200);

        btndoble.setPrefWidth(200);
        btndoble.setPrefHeight(200);

        btnhawaiana.setPrefWidth(200);
        btnhawaiana.setPrefHeight(200);

        btnsencilla.setOnAction(event -> {
            AsignarSencilla();
        });

        btndoble.setOnAction(event -> {
            AsignarDoble();
        });

        btnhawaiana.setOnAction(event -> {
            AsignarHawa();
        });
        // Agregar los nuevos botones al contenedor
        vboxhamburguesas.getChildren().addAll(btnsencilla, btndoble, btnhawaiana);

        // Crear la escena y mostrar la nueva ventana
        Scene PlatilloEscena = new Scene(hboxhamburguesas, 600, 400); // Ajusta el tamaño según tus necesidades
        MenuHamburguesas.setScene(PlatilloEscena);
        MenuHamburguesas.setTitle("Selecciona...");
        MenuHamburguesas.show();
    }

    private void PantallaBedidas(){
        MenuBebidas = new Stage();
        VBox vboxbebidas = new VBox();
        HBox hboxbebidas = new HBox(vboxbebidas);

        btnRefresco = new Button("Coca Cola");
        btnAgua = new Button("Agua");
        btnTeHelado = new Button("Te Helado");

        // Configuración de los nuevos botones
        btnRefresco.setPrefWidth(200);
        btnRefresco.setPrefHeight(200);

        btnAgua.setPrefWidth(200);
        btnAgua.setPrefHeight(200);

        btnTeHelado.setPrefWidth(200);
        btnTeHelado.setPrefHeight(200);

        btnRefresco.setOnAction(event -> {
            Asignarcoca();
        });

        btnAgua.setOnAction(event -> {
            Asignaragua();
        });

        btnTeHelado.setOnAction(event ->{
            Asignarte();
        });
        // Agregar los nuevos botones al contenedor
        vboxbebidas.getChildren().addAll(btnRefresco, btnAgua, btnTeHelado);

        // Crear la escena y mostrar la nueva ventana
        Scene PlatilloEscena = new Scene(hboxbebidas, 600, 400); // Ajusta el tamaño según tus necesidades
        MenuBebidas.setScene(PlatilloEscena);
        MenuBebidas.setTitle("Selecciona...");
        MenuBebidas.show();
    }

    private void PantallaAcompañante(){
        MenuAcompañantes = new Stage();
        VBox vboxacompa = new VBox();
        HBox hboxacompa = new HBox(vboxacompa);

        btnPapas = new Button("papas");
        btnAlitas = new Button("Alitas");
        btnNuget = new Button("Nugets");

        // Configuración de los nuevos botones
        btnPapas.setPrefWidth(200);
        btnPapas.setPrefHeight(200);

        btnAlitas.setPrefWidth(200);
        btnAlitas.setPrefHeight(200);

        btnNuget.setPrefWidth(200);
        btnNuget.setPrefHeight(200);

        btnPapas.setOnAction(event -> {
            Asignarpapas();
        });

        btnAlitas.setOnAction(event -> {
            Asignaralitas();
        });

        btnNuget.setOnAction(event ->{
            Asignarnuget();
        });
        // Agregar los nuevos botones al contenedor
        vboxacompa.getChildren().addAll(btnPapas, btnAlitas, btnNuget);

        // Crear la escena y mostrar la nueva ventana
        Scene PlatilloEscena = new Scene(hboxacompa, 600, 400); // Ajusta el tamaño según tus necesidades
        MenuAcompañantes.setScene(PlatilloEscena);
        MenuAcompañantes.setTitle("Selecciona...");
        MenuAcompañantes.show();
    }

    private void PantallaIngre(){
        MenuIngre = new Stage();
        VBox vboxingre = new VBox();
        VBox vboxingre2 = new VBox();
        HBox hboxingre = new HBox(vboxingre,new Separator(),vboxingre2);

        btnCarne = new Button("Carne");
        btnPan = new Button("Pan");
        btnTomate = new Button("Jitomate");

        // Configuración de los nuevos botones
        btnCarne.setPrefWidth(200);
        btnCarne.setPrefHeight(200);

        btnPan.setPrefWidth(200);
        btnPan.setPrefHeight(200);

        btnTomate.setPrefWidth(200);
        btnTomate.setPrefHeight(200);

        btnCarne.setOnAction(event -> {
            AsignarCarne();
        });

        btnPan.setOnAction(event -> {
            AsignarPan();
        });

        btnTomate.setOnAction(event ->{
            AsignarToma();
        });
        vboxingre.getChildren().addAll(btnCarne, btnPan, btnTomate);

        btnNu = new Button("Nuget");
        btnAli = new Button("Alitas");
        btnPapa = new Button("Papa");

        btnNu.setPrefWidth(200);
        btnNu.setPrefHeight(200);

        btnAli.setPrefWidth(200);
        btnAli.setPrefHeight(200);

        btnPapa.setPrefWidth(200);
        btnPapa.setPrefHeight(200);

        btnNu.setOnAction(event -> {
            Asignarnu();
        });

        btnAli.setOnAction(event ->{
            Asignarali();
        });

        btnPapa.setOnAction(event ->{
            Asignarpapa();
        });
        Scene PlatilloEscena = new Scene(hboxingre, 600, 400); // Ajusta el tamaño según tus necesidades
        MenuIngre.setScene(PlatilloEscena);
        MenuIngre.setTitle("Selecciona...");
        MenuIngre.show();
    }

    private void PantallaMesa(){
        Stage MenuMesas = new Stage();
        VBox vboxMesa1 = new VBox();
        HBox hboxmesa = new HBox(vboxMesa1);

        btnmesax2 = new Button("Mesa para 2");
        btnmesax4 = new Button("Mesa para 4");
        btnmesa6 = new Button("Mesa para 6");

        // Configuración de los nuevos botones
        btnmesax2.setPrefWidth(200);
        btnmesax2.setPrefHeight(200);

        btnmesax4.setPrefWidth(200);
        btnmesax4.setPrefHeight(200);

        btnmesa6.setPrefWidth(200);
        btnmesa6.setPrefHeight(200);

        btnmesax2.setOnAction(event -> {
            AsignarMesax2();
        });

        btnmesax4.setOnAction(event -> {
            AsignarMesax4();
        });

        btnmesa6.setOnAction(event ->{
            AsignarMesax6();
        });
        // Agregar los nuevos botones al contenedor
        vboxMesa1.getChildren().addAll(btnmesax2, btnmesax4, btnmesa6);

        // Crear la escena y mostrar la nueva ventana
        Scene PlatilloEscena = new Scene(hboxmesa, 600, 400); // Ajusta el tamaño según tus necesidades
        MenuMesas.setScene(PlatilloEscena);
        MenuMesas.setTitle("Selecciona...");
        MenuMesas.show();
    }

    public void PantallaPromo(){
        Stage MenuPromo = new Stage();
        HBox hboxpromo1 = new HBox();
        HBox hboxpromo = new HBox(hboxpromo1);

        btnbts = new Button("promo bts");
        btnestu = new Button("Promo estudiantil");
        btn2x1 = new Button("2 por 1");

        // Configuración de los nuevos botones
        btnbts.setPrefWidth(200);
        btnbts.setPrefHeight(200);

        btnestu.setPrefWidth(200);
        btnestu.setPrefHeight(200);

        btn2x1.setPrefWidth(200);
        btn2x1.setPrefHeight(200);

        btnbts.setOnAction(event -> {
            AsignarBTS();
        });

        btnestu.setOnAction(event -> {
            AsignarEstu();
        });

        btn2x1.setOnAction(event ->{
            Asignar2x1();
        });
        // Agregar los nuevos botones al contenedor
        hboxpromo1.getChildren().addAll(btnbts, btnestu, btn2x1);

        // Crear la escena y mostrar la nueva ventana
        Scene PlatilloEscena = new Scene(hboxpromo, 600, 400); // Ajusta el tamaño según tus necesidades
        MenuPromo.setScene(PlatilloEscena);
        MenuPromo.setTitle("Selecciona...");
        MenuPromo.show();
    }

    public void PantallaPedido(){
        Stage MenuPedido = new Stage();
        HBox hboxped1 = new HBox();
        HBox hboxpedido = new HBox(hboxped1);

        btnordenar = new Button("ordenar");

        // Configuración de los nuevos botones
        btnordenar.setPrefWidth(200);
        btnordenar.setPrefHeight(200);

        btnordenar.setOnAction(event -> {
            AsignarPedido();
        });
        // Agregar los nuevos botones al contenedor
        hboxped1.getChildren().addAll(btnordenar);

        // Crear la escena y mostrar la nueva ventana
        Scene PlatilloEscena = new Scene(hboxpedido, 600, 400); // Ajusta el tamaño según tus necesidades
        MenuPedido.setScene(PlatilloEscena);
        MenuPedido.setTitle("Selecciona...");
        MenuPedido.show();
    }

    public void PantallaComentarios(){
        Stage Menucome = new Stage();
        HBox hboxcome1 = new HBox();
        HBox hboxcome = new HBox(hboxcome1);

        btnBueno = new Button("Bueno");
        btnMalo = new Button("Malo");


        // Configuración de los nuevos botones
        btnBueno.setPrefWidth(200);
        btnBueno.setPrefHeight(200);

        btnMalo.setPrefWidth(200);
        btnMalo.setPrefHeight(200);

        btnBueno.setOnAction(event -> {
            AsignarcomeBueno();
        });

        btnMalo.setOnAction(event -> {
            AsignarcomeMalo();
        });

        hboxcome1.getChildren().addAll(btnBueno, btnMalo);

        // Crear la escena y mostrar la nueva ventana
        Scene PlatilloEscena = new Scene(hboxcome, 600, 400); // Ajusta el tamaño según tus necesidades
        Menucome.setScene(PlatilloEscena);
        Menucome.setTitle("Selecciona...");
        Menucome.show();
    }

    public void PantallaDescuentos(){
        Stage MenuDES = new Stage();
        HBox hboxdes1 = new HBox();
        HBox hboxdescuento = new HBox(hboxdes1);

        btn5 = new Button("Descuento del 5");
        btn10 = new Button("Descuento del 10");
        btn15 = new Button("descuento de 15");

        // Configuración de los nuevos botones
        btn5.setPrefWidth(200);
        btn5.setPrefHeight(200);

        btn10.setPrefWidth(200);
        btn10.setPrefHeight(200);

        btn15.setPrefWidth(200);
        btn15.setPrefHeight(200);


        btn5.setOnAction(event -> {
            Asignar5();
        });

        btn10.setOnAction(event ->{
            Asignar10();
        });

        btn15.setOnAction(event -> {
            Asignar15();
        });

        // Agregar los nuevos botones al contenedor
        hboxdes1.getChildren().addAll(btn5,btn10,btn15);

        // Crear la escena y mostrar la nueva ventana
        Scene PlatilloEscena = new Scene(hboxdescuento, 600, 400); // Ajusta el tamaño según tus necesidades
        MenuDES.setScene(PlatilloEscena);
        MenuDES.setTitle("Selecciona...");
        MenuDES.show();
    }

    public void HechoCon(){
        Stage Menuhecho = new Stage();
        HBox hboxhecho1 = new HBox();
        HBox hboxhecho = new HBox(hboxhecho1);

        btnhechocon = new Button("ver");

        // Configuración de los nuevos botones
        btnhechocon.setPrefWidth(200);
        btnhechocon.setPrefHeight(200);

        btnhechocon.setOnAction(event -> {
            Asignarhecho();
        });

        hboxhecho1.getChildren().addAll(btnhechocon);

        // Crear la escena y mostrar la nueva ventana
        Scene PlatilloEscena = new Scene(hboxhecho, 600, 400); // Ajusta el tamaño según tus necesidades
        Menuhecho.setScene(PlatilloEscena);
        Menuhecho.setTitle("Selecciona...");
        Menuhecho.show();
    }

    public void PantallaCaja(){
        Stage MenuCaja = new Stage();
        HBox hboxcaja1 = new HBox();
        HBox hboxcaja = new HBox(hboxcaja1);

        btnverCaja = new Button("Caja Negocio");

        // Configuración de los nuevos botones
        btnverCaja.setPrefWidth(200);
        btnverCaja.setPrefHeight(200);

        btnverCaja.setOnAction(event -> {
            AsignarCaja();
        });

        hboxcaja1.getChildren().addAll(btnverCaja);

        // Crear la escena y mostrar la nueva ventana
        Scene PlatilloEscena = new Scene(hboxcaja, 600, 400); // Ajusta el tamaño según tus necesidades
        MenuCaja.setScene(PlatilloEscena);
        MenuCaja.setTitle("Selecciona...");
        MenuCaja.show();
    }

    public void PantallaPago(){
        Stage MenuPago = new Stage();
        HBox hboxpago1 = new HBox();
        HBox hboxpago = new HBox(hboxpago1);

        btnefec = new Button("Pago Efectivo");
        btntarjeta = new Button("Pago Tarjeta");

        // Configuración de los nuevos botones
        btnefec.setPrefWidth(200);
        btnefec.setPrefHeight(200);

        btntarjeta.setPrefWidth(200);
        btntarjeta.setPrefHeight(200);

        btnefec.setOnAction(event -> {
            AsigarPagoefec();
        });

        btntarjeta.setOnAction(event -> {
            AsigarPagotar();
        });

        hboxpago1.getChildren().addAll(btnefec,btntarjeta);

        // Crear la escena y mostrar la nueva ventana
        Scene PlatilloEscena = new Scene(hboxpago, 600, 400); // Ajusta el tamaño según tus necesidades
        MenuPago.setScene(PlatilloEscena);
        MenuPago.setTitle("Selecciona...");
        MenuPago.show();
    }

    public void PantallaReserva(){
        Stage MenuReserva = new Stage();
        HBox hboxreserva1 = new HBox();
        HBox hboxreserva = new HBox(hboxreserva1);

        btnReser2 = new Button("Reserva para 2");
        btnReser4 = new Button("Reserva para 4");
        btnreser6 = new Button("Reserva para 6");

        // Configuración de los nuevos botones
        btnReser2.setPrefWidth(200);
        btnReser2.setPrefHeight(200);

        btnReser4.setPrefWidth(200);
        btnReser4.setPrefHeight(200);

        btnreser6.setPrefWidth(200);
        btnreser6.setPrefHeight(200);

        btnReser2.setOnAction(event -> {
            AsignarReserva2();
        });

        btnReser4.setOnAction(event -> {
            AsignarReserva4();
        });

        btnreser6.setOnAction(event ->{
            AsignarReserva6();
        });

        hboxreserva1.getChildren().addAll(btnReser2,btnReser4,btnreser6);

        // Crear la escena y mostrar la nueva ventana
        Scene PlatilloEscena = new Scene(hboxreserva, 600, 400); // Ajusta el tamaño según tus necesidades
        MenuReserva.setScene(PlatilloEscena);
        MenuReserva.setTitle("Selecciona...");
        MenuReserva.show();
    }

    public void TablaPedido(){
        Stage MenuDetalle = new Stage();
        HBox hboxdetalle1 = new HBox();
        HBox hboxdetalle = new HBox(hboxdetalle1);

        btnActu = new Button("Actualizar");

        // Configuración de los nuevos botones
        btnActu.setPrefWidth(200);
        btnActu.setPrefHeight(200);

        btnActu.setOnAction(event -> {
            actualizarTabla();
        });

        hboxdetalle1.getChildren().addAll(tvbRestaurante,btnActu);

        // Crear la escena y mostrar la nueva ventana
        Scene PlatilloEscena = new Scene(hboxdetalle, 600, 400); // Ajusta el tamaño según tus necesidades
        MenuDetalle.setScene(PlatilloEscena);
        MenuDetalle.setTitle("Selecciona...");
        MenuDetalle.show();

        /*

        hboxTabla = new HBox(tvbRestaurante,btnActu);*/
    }


    private void CrearTabla(){
        TableColumn<RestaurateDAO,Integer> tbcldCat = new TableColumn<>("ID platillo");
        tbcldCat.setCellValueFactory(new PropertyValueFactory<>("IDplatillo"));

        TableColumn<RestaurateDAO,String> tbcldCat2 = new TableColumn<>("Nombre");
        tbcldCat2.setCellValueFactory(new PropertyValueFactory<>("nombrePlatillo"));
        tbcldCat2.setEditable(true);
        tbcldCat2.setPrefWidth(200);

        TableColumn<RestaurateDAO,String> borrar = new TableColumn<>("Borrar");
        borrar.setCellFactory(
                new Callback<TableColumn<RestaurateDAO, String>, TableCell<RestaurateDAO, String>>() {
                    @Override
                    public TableCell<RestaurateDAO, String> call(TableColumn<RestaurateDAO, String> taqueriasDAOStringTableColumn) {
                        return new ButtonCell(2);
                    }
                }
        );


        tvbRestaurante.getColumns().addAll(tbcldCat,tbcldCat2,borrar);
        tvbRestaurante.setItems(restaurateDAO.LISTARPRODUCTOS());
    }

    private void actualizarTabla() {
        tvbRestaurante.getItems().setAll(restaurateDAO.LISTARPRODUCTOS());
    }

    private int idCategoria=-1;
    private int IDplatillo=-1;
    private int IDempleado=-1;
    private int IDIngrediente=-1;
    private int mesaID=-1;
    private int IDpromocion=-1;
    private int IDUsuario=-1;
    private int idPedido=-1;
    private int IDcomentario=-1;
    private int IDdescuento=-1;
    private int cajaID=-1;
    private int IDpago=-1;
    private int IDreserva=-1;

    private void AbrirCategoriaHambu(){
        idCategoria = restaurateDAO.insertarCategoria("Hamburguesa");
    }

    private void AbrirCategoriaBebida(){
        idCategoria = restaurateDAO.insertarCategoria("Bebidas");
    }

    private void AbrirCategoriaAcompa(){
        idCategoria = restaurateDAO.insertarCategoria("Acompañante");
    }

    private void AsignarSencilla(){
        if(idCategoria != -1 ){
            IDplatillo = restaurateDAO.insertarPlatillo("Hamburguesa sencilla",idCategoria);
        }
    }

    private void AsignarDoble(){
        if(idCategoria != -1 ){
            IDplatillo = restaurateDAO.insertarPlatillo("Hamburguesa doble",idCategoria);
        }
    }

    private void AsignarHawa(){
        if(idCategoria != -1 ){
            IDplatillo = restaurateDAO.insertarPlatillo("Hamburguesa Hawaiana",idCategoria);
        }
    }

    private void Asignarcoca(){
        if(idCategoria != -1 ){
            IDplatillo = restaurateDAO.insertarPlatillo("coca cola 600ml.",idCategoria);
        }
    }

    private void Asignaragua(){
        if(idCategoria != -1 ){
            IDplatillo = restaurateDAO.insertarPlatillo("agua 600ml.",idCategoria);
        }
    }

    private void Asignarte(){
        if(idCategoria != -1 ){
            IDplatillo = restaurateDAO.insertarPlatillo("Te Helado 600ml.",idCategoria);
        }
    }

    private void Asignarpapas(){
        if(idCategoria != -1 ){
            IDplatillo = restaurateDAO.insertarPlatillo("Orden de papas fritas.",idCategoria);
        }
    }

    private void Asignaralitas(){
        if(idCategoria != -1 ){
            IDplatillo = restaurateDAO.insertarPlatillo("Orden de alitas.",idCategoria);
        }
    }

    private void Asignarnuget(){
        if(idCategoria != -1 ){
            IDplatillo = restaurateDAO.insertarPlatillo("Orden de Nugets.",idCategoria);
        }
    }

    private void Asignarchef(){
        IDempleado = restaurateDAO.insertarEmpleado("Arturo Islas","Chef Principal");
    }

    private void AsignarRepa(){
        IDempleado = restaurateDAO.insertarEmpleado("Moises Perez","Repartidor");
    }

    private void Asignarpinche(){
        IDempleado = restaurateDAO.insertarEmpleado("Alan Alvarado","Ayudante Cocina");
    }

    private void AsignarCarne(){
        IDIngrediente = restaurateDAO.insertarIngrediente("Carne de Hamburguesa",1);
    }
    private void AsignarPan(){
        IDIngrediente = restaurateDAO.insertarIngrediente("Pan de Hamburguesa",1);
    }
    private  void AsignarToma(){
        IDIngrediente = restaurateDAO.insertarIngrediente("Jitomate Fresco",1);
    }

    private  void Asignarnu(){
        IDIngrediente = restaurateDAO.insertarIngrediente("Nugget congelado",1);
    }
    private  void Asignarali(){
        IDIngrediente = restaurateDAO.insertarIngrediente("Alita congelada",1);
    }

    private void Asignarpapa(){
        IDIngrediente = restaurateDAO.insertarIngrediente("Papa Blanca",1);
    }

    private void AsignarMesax2(){
        mesaID = restaurateDAO.insertarMesa("Mesa uno",2);
    }
    private void AsignarMesax4(){
        mesaID = restaurateDAO.insertarMesa("Mesa dos",4);
    }
    private void AsignarMesax6(){
        mesaID = restaurateDAO.insertarMesa("Mesa tres",6);
    }

    private void Asignar2x1(){
        if(IDplatillo != -1 ){
            IDpromocion = restaurateDAO.insertarPromocion("2x1","Dos hamburguesas por una",IDplatillo);
        }
    }
    private void AsignarBTS(){
        if(IDplatillo != -1 ){
            IDpromocion = restaurateDAO.insertarPromocion("BTS","Hamburguesa sencilla con Juguete de Bts",IDplatillo);
        }
    }
    private void AsignarEstu(){
        if(IDplatillo != -1 ){
            IDpromocion = restaurateDAO.insertarPromocion("Lince","Hamburguesa sencilla con papas",IDplatillo);
        }
    }
    private void AsignarHombreusu(){
        IDUsuario = restaurateDAO.insertarUsuario("Hombre","1234");
    }

    private void AsignarMujerUsu(){
        IDUsuario = restaurateDAO.insertarUsuario("Mujer","4321");
    }

    private void AsignarPedido(){
        idPedido = restaurateDAO.insertarPedido(IDUsuario,IDempleado,mesaID);
    }

    private void AsignarcomeBueno(){
        if(idPedido != -1 ){
            IDcomentario = restaurateDAO.insertarComentario("La experiencia es muy buena",idPedido);
        }
    }

    private void AsignarcomeMalo(){
        if(idPedido != -1 ){
            IDcomentario = restaurateDAO.insertarComentario("La experiencia es muy mala",idPedido);
        }
    }

    private void Asignar5(){
        if(idPedido != -1 ){
            IDdescuento = restaurateDAO.insertarDescuento(5.0,idPedido);
        }
    }

    private void Asignar10(){
        if(idPedido != -1 ){
            IDdescuento = restaurateDAO.insertarDescuento(10.0,idPedido);
        }
    }

    private void Asignar15(){
        if(idPedido != -1 ){
            IDdescuento = restaurateDAO.insertarDescuento(15.0,idPedido);
        }
    }

    private void Asignarhecho(){
        if(IDplatillo != -1 && IDIngrediente != -1) {
            restaurateDAO.insertarHechoCon(IDplatillo,IDIngrediente);
        }
    }

    private void AsignarCaja(){
        cajaID = restaurateDAO.insertarCaja(0,1000);
    }

    private void AsigarPagoefec(){
        if(idPedido != 1 && cajaID !=1){
            IDpago = restaurateDAO.insertarPago("Efectivo",1000,idPedido,cajaID);
        }
    }

    private void AsigarPagotar(){
        if(idPedido != 1 && cajaID !=1){
            IDpago = restaurateDAO.insertarPago("Tarjeta",1000,idPedido,cajaID);
        }
    }

    private void AsignarReserva2(){
        if(mesaID != 1 && IDUsuario !=1){
            IDreserva = restaurateDAO.insertarReserva(2,"08/12/2023",mesaID,IDUsuario);
        }
    }

    private void AsignarReserva4(){
        if(mesaID != 1 && IDUsuario !=1){
            IDreserva = restaurateDAO.insertarReserva(4,"08/12/2023",mesaID,IDUsuario);
        }
    }

    private void AsignarReserva6(){
        if(mesaID != 1 && IDUsuario !=1){
            IDreserva = restaurateDAO.insertarReserva(6,"08/12/2023",mesaID,IDUsuario);
        }
    }
    public static void main(String[] args) {
        launch();
    }


}