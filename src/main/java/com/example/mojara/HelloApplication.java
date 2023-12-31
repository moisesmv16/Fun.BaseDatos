package com.example.mojara;

import componentes.ButtonCell;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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
    private VBox vbox1,vbox2,vbox3,vbox4,vbox5,vboxcategorias,vboxPlatillos1;

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

        Image imghombre = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\descarga.jpg");
        ImageView imvhom = new ImageView(imghombre);
        imvhom.setFitWidth(300);
        imvhom.setFitHeight(300);
        imvhom.setPreserveRatio(false);

        btnHombre = new Button();
        btnHombre.setGraphic(imvhom);
        btnHombre.setPrefWidth(300);
        btnHombre.setPrefHeight(300);
        btnHombre.setStyle("-fx-background-color: transparent;"); // Establecer el fondo del botón como transparente

        Image imgmujer = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\mujer.jpg");
        ImageView imvmujer = new ImageView(imgmujer);
        imvmujer.setFitWidth(300);
        imvmujer.setFitHeight(300);

        btnMujer = new Button();
        btnMujer.setGraphic(imvmujer);
        btnMujer.setPrefWidth(300);
        btnMujer.setPrefHeight(300);// Establecer el fondo del botón como transparente

        btnMujer.setOnAction(event -> {
            MenuPrincipalMojara();
            AlertaMujer();
        });

        btnHombre.setOnAction(event -> {
            MenuPrincipalMojara();
            AlertaHombre();
        });

        hboxLoginusu.getChildren().setAll(btnHombre, new Separator(), btnMujer);
        hboxLogin.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY))); // Fondo del HBox
        Scene PlatilloEscena = new Scene(hboxLogin, 600, 400);
        MenuLogin.setScene(PlatilloEscena);
        MenuLogin.setTitle("Selecciona tu usuario...");
        MenuLogin.show();

    }

    private void MenuPrincipalMojara() {
        /*restaurateDAO = new RestaurateDAO();
        tvbRestaurante = new TableView<RestaurateDAO>();
        CrearTabla();*/
        MenuPrincipal = new Stage();
        hboxPrincipal = new HBox();
        //btnDetallePedido = new Button("DetallePedido");

        Image imgPlatillo = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\plat.jpg");
        ImageView imvpla = new ImageView(imgPlatillo);
        imvpla.setFitWidth(150);
        imvpla.setFitHeight(150);
        imvpla.setPreserveRatio(false);
        btnPlatillos = new Button();
        btnPlatillos.setGraphic(imvpla);

        Image imgpromo = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\pro.jpg");
        ImageView imvpromo = new ImageView(imgpromo);
        imvpromo.setFitWidth(150);
        imvpromo.setFitHeight(150);
        imvpromo.setPreserveRatio(false);
        btnPromo = new Button();
        btnPromo.setGraphic(imvpromo);

        Image imgre = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\re.png");
        ImageView imvre = new ImageView(imgre);
        imvre.setFitWidth(150);
        imvre.setFitHeight(150);
        imvre.setPreserveRatio(false);
        btnReservacion = new Button();
        btnReservacion.setGraphic(imvre);



        btnPlatillos.setPrefWidth(150);
        btnPlatillos.setPrefHeight(150);

        btnPromo.setPrefWidth(150);
        btnPromo.setPrefHeight(150);


        btnReservacion.setPrefWidth(150);
        btnReservacion.setPrefHeight(150);

        btnPromo.setOnAction(event -> PantallaPromo());
        btnReservacion.setOnAction(event -> {
            PantallaReserva();
        });


        btnPlatillos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MenuPlatillos = new Stage();
                vboxcategorias = new VBox();
                hboxcategorias = new HBox(vboxcategorias);

                Image imgha = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\hapla.png");
                ImageView imvha = new ImageView(imgha);
                imvha.setFitWidth(200);
                imvha.setFitHeight(200);
                imvha.setPreserveRatio(false);
                btnHamburguesas = new Button();
                btnHamburguesas.setGraphic(imvha);


                Image imgbebi = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\beb.png");
                ImageView imvbeb = new ImageView(imgbebi);
                imvbeb.setFitWidth(200);
                imvbeb.setFitHeight(200);
                imvbeb.setPreserveRatio(false);
                btnBebidas = new Button();
                btnBebidas.setGraphic(imvbeb);


                Image imgac = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\acompa.jpg");
                ImageView imvac = new ImageView(imgac);
                imvac.setFitWidth(200);
                imvac.setFitHeight(200);
                imvac.setPreserveRatio(false);
                btnAcompañante = new Button();
                btnAcompañante.setGraphic(imvac);

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
                hboxcategorias.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY))); // Fondo del HBox
                // Crear la escena y mostrar la nueva ventana
                Scene PlatilloEscena = new Scene(hboxcategorias, 600, 400); // Ajusta el tamaño según tus necesidades
                MenuPlatillos.setScene(PlatilloEscena);
                MenuPlatillos.setTitle("Selecciona...");
                MenuPlatillos.show();
            }
        });

        vbox1 = new VBox();
        vbox1.setSpacing(35);
        vbox1.getChildren().addAll(btnPlatillos,btnPromo,btnReservacion);

        Image imgca = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\caja.png");
        ImageView imvca = new ImageView(imgca);
        imvca.setFitWidth(150);
        imvca.setFitHeight(150);
        imvca.setPreserveRatio(false);
        btnCaja = new Button();
        btnCaja.setGraphic(imvca);


        Image imgme = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\mesa.png");
        ImageView imvme = new ImageView(imgme);
        imvme.setFitWidth(150);
        imvme.setFitHeight(150);
        imvme.setPreserveRatio(false);
        btnMesas = new Button();
        btnMesas.setGraphic(imvme);


        Image imgde = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\por.png");
        ImageView imvde = new ImageView(imgde);
        imvde.setFitWidth(150);
        imvde.setFitHeight(150);
        imvde.setPreserveRatio(false);
        btnDescu = new Button();
        btnDescu.setGraphic(imvde);


        btnCaja.setPrefWidth(150);
        btnCaja.setPrefHeight(150);


        btnMesas.setPrefWidth(150);
        btnMesas.setPrefHeight(150);

        btnDescu.setPrefWidth(150);
        btnDescu.setPrefHeight(150);

        btnCaja.setOnAction(event -> {
            PantallaCaja();
        });

        btnMesas.setOnAction(event -> PantallaMesa());

        btnDescu.setOnAction(event -> {
            PantallaDescuentos();
        });


        vbox2 = new VBox();
        vbox2.setSpacing(35);
        vbox2.getChildren().addAll(btnCaja,btnMesas,btnDescu);

        Image imgde11 = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\coment.jpg");
        ImageView imvde11 = new ImageView(imgde11);
        imvde11.setFitWidth(150);
        imvde11.setFitHeight(150);
        imvde11.setPreserveRatio(false);
        btnComentarios = new Button();
        btnComentarios.setGraphic(imvde11);

        Image imgde12 = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\pedi.png");
        ImageView imvde12 = new ImageView(imgde12);
        imvde12.setFitWidth(150);
        imvde12.setFitHeight(150);
        imvde12.setPreserveRatio(false);
        btnPedido = new Button();
        btnPedido.setGraphic(imvde12);

        Image imgde13 = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\hecho.jpg");
        ImageView imvde13 = new ImageView(imgde13);
        imvde13.setFitWidth(150);
        imvde13.setFitHeight(150);
        imvde13.setPreserveRatio(false);
        btnHecho = new Button();
        btnHecho.setGraphic(imvde13);


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


        btnHecho.setPrefWidth(150);
        btnHecho.setPrefHeight(150);

        btnHecho.setOnAction(event ->{
            HechoCon();
        });

        vbox3 = new VBox();
        vbox3.setSpacing(35);
        vbox3.getChildren().addAll(btnComentarios,btnPedido,btnHecho);

        Image imgde22 = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\emple.jpg");
        ImageView imvde22 = new ImageView(imgde22);
        imvde22.setFitWidth(150);
        imvde22.setFitHeight(150);
        imvde22.setPreserveRatio(false);
        btnEmpleados = new Button();
        btnEmpleados.setGraphic(imvde22);

        Image imgde23 = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\ingr.jpg");
        ImageView imvde23 = new ImageView(imgde23);
        imvde23.setFitWidth(150);
        imvde23.setFitHeight(150);
        imvde23.setPreserveRatio(false);
        btnIngre = new Button();
        btnIngre.setGraphic(imvde23);

        Image imgde24 = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\pago.jpg");
        ImageView imvde24 = new ImageView(imgde24);
        imvde24.setFitWidth(150);
        imvde24.setFitHeight(150);
        imvde24.setPreserveRatio(false);
        btnPago = new Button();
        btnPago.setGraphic(imvde24);

        btnEmpleados.setPrefWidth(150);
        btnEmpleados.setPrefHeight(150);

        btnEmpleados.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MenuEmpleado = new Stage();
                hboxEmpleado = new HBox();

                Image imgde = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\chef.png");
                ImageView imvde = new ImageView(imgde);
                imvde.setFitWidth(150);
                imvde.setFitHeight(150);
                imvde.setPreserveRatio(false);
                btnChef = new Button();
                btnChef.setGraphic(imvde);

                Image imgde01 = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\repa.png");
                ImageView imvde01 = new ImageView(imgde01);
                imvde01.setFitWidth(150);
                imvde01.setFitHeight(150);
                imvde01.setPreserveRatio(false);
                btnRepartidor = new Button();
                btnRepartidor.setGraphic(imvde01);

                Image imgde02 = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\pin.jpg");
                ImageView imvde02 = new ImageView(imgde02);
                imvde02.setFitWidth(150);
                imvde02.setFitHeight(150);
                imvde02.setPreserveRatio(false);
                btnPinche = new Button();
                btnPinche.setGraphic(imvde02);

                btnChef.setPrefHeight(200);
                btnChef.setPrefWidth(200);

                btnRepartidor.setPrefWidth(200);
                btnRepartidor.setPrefHeight(200);

                btnPinche.setPrefHeight(200);
                btnPinche.setPrefWidth(200);

                btnChef.setOnAction(event ->{
                    Asignarchef();
                    AlertaChef();
                });

                btnRepartidor.setOnAction(event ->{
                    AsignarRepa();
                    AlertaRepa();
                });

                btnPinche.setOnAction(event ->{
                    Asignarpinche();
                    AlertaPinche();
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

        restaurateDAO = new RestaurateDAO();
        tvbRestaurante = new TableView<RestaurateDAO>();
        CrearTabla();

        Image imgdp = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\car.png");
        ImageView imvdp = new ImageView(imgdp);
        imvdp.setFitWidth(150);
        imvdp.setFitHeight(150);
        imvdp.setPreserveRatio(false);
        btnDetallePedido = new Button();
        btnDetallePedido.setGraphic(imvdp);

        btnDetallePedido.setPrefWidth(150);
        btnDetallePedido.setPrefHeight(150);
        btnDetallePedido.setOnAction(event -> {
            TablaPedido();
        });
        vbox5 = new VBox();
        vbox5.setSpacing(35);
        vbox5.getChildren().addAll(btnDetallePedido);


        hboxPrincipal = new HBox(vbox1,new Separator(),vbox2,new Separator(),vbox3,new Separator(),vbox4,new Separator(),vbox5);
        Scene segundaEscena = new Scene(hboxPrincipal, 200, 150);
        MenuPrincipal.setScene(segundaEscena);
        MenuPrincipal.setTitle("Menu Principal");
        MenuPrincipal.show();
    }

    private void PantallaHamburguesa(){
        MenuHamburguesas = new Stage();
        VBox vboxhamburguesas = new VBox();
        HBox hboxhamburguesas = new HBox(vboxhamburguesas);

        Image imgse = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\hamsen.jpg");
        ImageView imvse = new ImageView(imgse);
        imvse.setFitWidth(200);
        imvse.setFitHeight(200);
        imvse.setPreserveRatio(false);
        btnsencilla = new Button();
        btnsencilla.setGraphic(imvse);

        Image imgdo = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\hamdoble.jpg");
        ImageView imvdo = new ImageView(imgdo);
        imvdo.setFitWidth(200);
        imvdo.setFitHeight(200);
        imvdo.setPreserveRatio(false);
        btndoble = new Button();
        btndoble.setGraphic(imvdo);

        Image imgha = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\hamwa.jpg");
        ImageView imvha = new ImageView(imgha);
        imvha.setFitWidth(200);
        imvha.setFitHeight(200);
        imvha.setPreserveRatio(false);
        btnhawaiana = new Button();
        btnhawaiana.setGraphic(imvha);



        // Configuración de los nuevos botones
        btnsencilla.setPrefWidth(200);
        btnsencilla.setPrefHeight(200);

        btndoble.setPrefWidth(200);
        btndoble.setPrefHeight(200);

        btnhawaiana.setPrefWidth(200);
        btnhawaiana.setPrefHeight(200);

        btnsencilla.setOnAction(event -> {
            AsignarSencilla();
            AlertaSencilla();
        });

        btndoble.setOnAction(event -> {
            AsignarDoble();
            AlertaDoble();
        });

        btnhawaiana.setOnAction(event -> {
            AsignarHawa();
            AlertaHawa();
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

        Image imgre = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\coca.jpg");
        ImageView imvre = new ImageView(imgre);
        imvre.setFitWidth(200);
        imvre.setFitHeight(200);
        imvre.setPreserveRatio(false);
        btnRefresco = new Button();
        btnRefresco.setGraphic(imvre);


        Image imgag = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\agua.jpg");
        ImageView imvag = new ImageView(imgag);
        imvag.setFitWidth(200);
        imvag.setFitHeight(200);
        imvag.setPreserveRatio(false);
        btnAgua = new Button();
        btnAgua.setGraphic(imvag);

        Image imgte = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\te.jpg");
        ImageView imvte = new ImageView(imgte);
        imvte.setFitWidth(200);
        imvte.setFitHeight(200);
        imvte.setPreserveRatio(false);
        btnTeHelado = new Button();
        btnTeHelado.setGraphic(imvag);

        // Configuración de los nuevos botones
        btnRefresco.setPrefWidth(200);
        btnRefresco.setPrefHeight(200);

        btnAgua.setPrefWidth(200);
        btnAgua.setPrefHeight(200);

        btnTeHelado.setPrefWidth(200);
        btnTeHelado.setPrefHeight(200);

        btnRefresco.setOnAction(event -> {
            Asignarcoca();
            AlertaCoca();
        });

        btnAgua.setOnAction(event -> {
            Asignaragua();
            AlertaAgua();
        });

        btnTeHelado.setOnAction(event ->{
            Asignarte();
            AlertaTe();
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

        Image imgag = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\papas.jpg");
        ImageView imvag = new ImageView(imgag);
        imvag.setFitWidth(200);
        imvag.setFitHeight(200);
        imvag.setPreserveRatio(false);
        btnPapas = new Button();
        btnPapas.setGraphic(imvag);

        Image imga = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\ali.jpg");
        ImageView imva = new ImageView(imga);
        imva.setFitWidth(200);
        imva.setFitHeight(200);
        imva.setPreserveRatio(false);
        btnAlitas = new Button();
        btnAlitas.setGraphic(imva);

        Image imgagl = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\nug.jpg");
        ImageView imvagl = new ImageView(imgagl);
        imvagl.setFitWidth(200);
        imvagl.setFitHeight(200);
        imvagl.setPreserveRatio(false);
        btnNuget = new Button();
        btnNuget.setGraphic(imvagl);
        // Configuración de los nuevos botones
        btnPapas.setPrefWidth(200);
        btnPapas.setPrefHeight(200);

        btnAlitas.setPrefWidth(200);
        btnAlitas.setPrefHeight(200);

        btnNuget.setPrefWidth(200);
        btnNuget.setPrefHeight(200);

        btnPapas.setOnAction(event -> {
            Asignarpapas();
            AlertaPapas();
        });

        btnAlitas.setOnAction(event -> {
            Asignaralitas();
            AlertaAlitas();
        });

        btnNuget.setOnAction(event ->{
            Asignarnuget();
            AlertaNuget();
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

        Image imgca = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\carne.jpg");
        ImageView imvca = new ImageView(imgca);
        imvca.setFitWidth(200);
        imvca.setFitHeight(200);
        imvca.setPreserveRatio(false);
        btnCarne = new Button();
        btnCarne.setGraphic(imvca);

        Image imgpan = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\pan.jpg");
        ImageView imvpan = new ImageView(imgpan);
        imvpan.setFitWidth(200);
        imvpan.setFitHeight(200);
        imvpan.setPreserveRatio(false);
        btnPan = new Button();
        btnPan.setGraphic(imvpan);

        Image imgag = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\jit.jpg");
        ImageView imvag = new ImageView(imgag);
        imvag.setFitWidth(200);
        imvag.setFitHeight(200);
        imvag.setPreserveRatio(false);
        btnTomate = new Button();
        btnTomate.setGraphic(imvag);

        // Configuración de los nuevos botones
        btnCarne.setPrefWidth(200);
        btnCarne.setPrefHeight(200);

        btnPan.setPrefWidth(200);
        btnPan.setPrefHeight(200);

        btnTomate.setPrefWidth(200);
        btnTomate.setPrefHeight(200);

        btnCarne.setOnAction(event -> {
            AsignarCarne();
            AlertaCarne();
        });

        btnPan.setOnAction(event -> {
            AsignarPan();
            AlertaPan();
        });

        btnTomate.setOnAction(event ->{
            AsignarToma();
            AlertaTomate();
        });
        vboxingre.getChildren().addAll(btnCarne, btnPan, btnTomate);

        Image imgnu = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\nu.jpg");
        ImageView imvnu = new ImageView(imgnu);
        imvnu.setFitWidth(200);
        imvnu.setFitHeight(200);
        imvnu.setPreserveRatio(false);
        btnNu = new Button();
        btnNu.setGraphic(imvag);


        Image imgali = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\al.jpg");
        ImageView imvali = new ImageView(imgali);
        imvali.setFitWidth(200);
        imvali.setFitHeight(200);
        imvali.setPreserveRatio(false);
        btnAli = new Button();
        btnAli.setGraphic(imvag);


        Image imgpa = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\pap.jpg");
        ImageView imvpa = new ImageView(imgpa);
        imvpa.setFitWidth(200);
        imvpa.setFitHeight(200);
        imvpa.setPreserveRatio(false);
        btnPapa = new Button();
        btnPapa.setGraphic(imvpa);

        btnNu.setPrefWidth(200);
        btnNu.setPrefHeight(200);

        btnAli.setPrefWidth(200);
        btnAli.setPrefHeight(200);

        btnPapa.setPrefWidth(200);
        btnPapa.setPrefHeight(200);

        btnNu.setOnAction(event -> {
            Asignarnu();
            AlertaNug();
        });

        btnAli.setOnAction(event ->{
            Asignarali();
            AlertaAlita();
        });

        btnPapa.setOnAction(event ->{
            Asignarpapa();
            AlertaPapa();
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

        Image img2 = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\x2.jpg");
        ImageView imv2 = new ImageView(img2);
        imv2.setFitWidth(200);
        imv2.setFitHeight(200);
        imv2.setPreserveRatio(false);
        btnmesax2 = new Button();
        btnmesax2.setGraphic(imv2);


        Image img4 = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\x4.jpg");
        ImageView imv4 = new ImageView(img4);
        imv4.setFitWidth(200);
        imv4.setFitHeight(200);
        imv4.setPreserveRatio(false);
        btnmesax4 = new Button();
        btnmesax4.setGraphic(imv4);

        Image img6 = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\x6.jpg");
        ImageView imv6 = new ImageView(img6);
        imv6.setFitWidth(200);
        imv6.setFitHeight(200);
        imv6.setPreserveRatio(false);
        btnmesa6 = new Button();
        btnmesa6.setGraphic(imv6);

        // Configuración de los nuevos botones
        btnmesax2.setPrefWidth(200);
        btnmesax2.setPrefHeight(200);

        btnmesax4.setPrefWidth(200);
        btnmesax4.setPrefHeight(200);

        btnmesa6.setPrefWidth(200);
        btnmesa6.setPrefHeight(200);

        btnmesax2.setOnAction(event -> {
            AsignarMesax2();
            Alertax2();
        });

        btnmesax4.setOnAction(event -> {
            AsignarMesax4();
            Alertax4();
        });

        btnmesa6.setOnAction(event ->{
            AsignarMesax6();
            Alertax6();
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

        Image imgnu = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\bts.jpg");
        ImageView imvnu = new ImageView(imgnu);
        imvnu.setFitWidth(200);
        imvnu.setFitHeight(200);
        imvnu.setPreserveRatio(false);
        btnbts = new Button();
        btnbts.setGraphic(imvnu);



        Image imgnu1 = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\estu.jpg");
        ImageView imvnu1 = new ImageView(imgnu1);
        imvnu1.setFitWidth(200);
        imvnu1.setFitHeight(200);
        imvnu1.setPreserveRatio(false);
        btnestu = new Button();
        btnestu.setGraphic(imvnu1);


        Image imgnu2 = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\2x1.jpg");
        ImageView imvnu2 = new ImageView(imgnu2);
        imvnu2.setFitWidth(200);
        imvnu2.setFitHeight(200);
        imvnu2.setPreserveRatio(false);
        btn2x1 = new Button();
        btn2x1.setGraphic(imvnu2);


        // Configuración de los nuevos botones
        btnbts.setPrefWidth(200);
        btnbts.setPrefHeight(200);

        btnestu.setPrefWidth(200);
        btnestu.setPrefHeight(200);

        btn2x1.setPrefWidth(200);
        btn2x1.setPrefHeight(200);

        btnbts.setOnAction(event -> {
            AsignarBTS();
            AlertaBts();
        });

        btnestu.setOnAction(event -> {
            AsignarEstu();
            AlertaEstu();
        });

        btn2x1.setOnAction(event ->{
            Asignar2x1();
            Alerta2x1();
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

        Image imgde = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\or.png");
        ImageView imvde = new ImageView(imgde);
        imvde.setFitWidth(200);
        imvde.setFitHeight(200);
        imvde.setPreserveRatio(false);
        btnordenar = new Button();
        btnordenar.setGraphic(imvde);

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

        Image imgnu = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\like.png");
        ImageView imvnu = new ImageView(imgnu);
        imvnu.setFitWidth(200);
        imvnu.setFitHeight(200);
        imvnu.setPreserveRatio(false);
        btnBueno = new Button();
        btnBueno.setGraphic(imvnu);


        Image imgnu1 = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\malo.jpg");
        ImageView imvnu1 = new ImageView(imgnu1);
        imvnu1.setFitWidth(200);
        imvnu1.setFitHeight(200);
        imvnu1.setPreserveRatio(false);
        btnMalo = new Button();
        btnMalo.setGraphic(imvnu1);


        // Configuración de los nuevos botones
        btnBueno.setPrefWidth(200);
        btnBueno.setPrefHeight(200);

        btnMalo.setPrefWidth(200);
        btnMalo.setPrefHeight(200);

        btnBueno.setOnAction(event -> {
            AsignarcomeBueno();
            AlertaBueno();
        });

        btnMalo.setOnAction(event -> {
            AsignarcomeMalo();
            AlertaMalo();
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

        Image imgnu = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\-5.jpg");
        ImageView imvnu = new ImageView(imgnu);
        imvnu.setFitWidth(200);
        imvnu.setFitHeight(200);
        imvnu.setPreserveRatio(false);
        btn5 = new Button();
        btn5.setGraphic(imvnu);



        Image imgnu2 = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\-10.jpg");
        ImageView imvnu2 = new ImageView(imgnu2);
        imvnu2.setFitWidth(200);
        imvnu2.setFitHeight(200);
        imvnu2.setPreserveRatio(false);
        btn10 = new Button();
        btn10.setGraphic(imvnu2);


        Image imgnu3 = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\-15.jpg");
        ImageView imvnu3 = new ImageView(imgnu3);
        imvnu3.setFitWidth(200);
        imvnu3.setFitHeight(200);
        imvnu3.setPreserveRatio(false);
        btn15 = new Button();
        btn15.setGraphic(imvnu3);

        // Configuración de los nuevos botones
        btn5.setPrefWidth(200);
        btn5.setPrefHeight(200);

        btn10.setPrefWidth(200);
        btn10.setPrefHeight(200);

        btn15.setPrefWidth(200);
        btn15.setPrefHeight(200);


        btn5.setOnAction(event -> {
            Asignar5();
            Alertades5();
        });

        btn10.setOnAction(event ->{
            Asignar10();
            Alertades10();
        });

        btn15.setOnAction(event -> {
            Asignar15();
            Alertades15();
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

        Image imgde = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\ver.png");
        ImageView imvde = new ImageView(imgde);
        imvde.setFitWidth(200);
        imvde.setFitHeight(200);
        imvde.setPreserveRatio(false);
        btnhechocon = new Button();
        btnhechocon.setGraphic(imvde);

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

        Image imgnu = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\caja.png");
        ImageView imvnu = new ImageView(imgnu);
        imvnu.setFitWidth(200);
        imvnu.setFitHeight(200);
        imvnu.setPreserveRatio(false);
        btnverCaja = new Button();
        btnverCaja.setGraphic(imvnu);



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


        Image imgnu = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\efe.jpg");
        ImageView imvnu = new ImageView(imgnu);
        imvnu.setFitWidth(200);
        imvnu.setFitHeight(200);
        imvnu.setPreserveRatio(false);
        btnefec  = new Button();
        btnefec.setGraphic(imvnu);


        Image imgnu2 = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\tar.png");
        ImageView imvnu2 = new ImageView(imgnu2);
        imvnu2.setFitWidth(200);
        imvnu2.setFitHeight(200);
        imvnu2.setPreserveRatio(false);
        btntarjeta = new Button();
        btntarjeta.setGraphic(imvnu2);

        // Configuración de los nuevos botones
        btnefec.setPrefWidth(200);
        btnefec.setPrefHeight(200);

        btntarjeta.setPrefWidth(200);
        btntarjeta.setPrefHeight(200);

        btnefec.setOnAction(event -> {
            AsigarPagoefec();
            AlertaEfectivo();
        });

        btntarjeta.setOnAction(event -> {
            AsigarPagotar();
            AlertaTarjeta();
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

        Image imgnu = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\2.png");
        ImageView imvnu = new ImageView(imgnu);
        imvnu.setFitWidth(200);
        imvnu.setFitHeight(200);
        imvnu.setPreserveRatio(false);
        btnReser2 = new Button();
        btnReser2.setGraphic(imvnu);


        Image imgnu2 = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\4.png");
        ImageView imvnu2 = new ImageView(imgnu2);
        imvnu2.setFitWidth(200);
        imvnu2.setFitHeight(200);
        imvnu2.setPreserveRatio(false);
        btnReser4 = new Button();
        btnReser4.setGraphic(imvnu2);


        Image imgnu3 = new Image("C:\\Users\\Hp\\IdeaProjects\\Mojara\\src\\main\\java\\imagenes\\6.png");
        ImageView imvnu3 = new ImageView(imgnu3);
        imvnu3.setFitWidth(200);
        imvnu3.setFitHeight(200);
        imvnu3.setPreserveRatio(false);
        btnreser6 = new Button();
        btnreser6.setGraphic(imvnu3);


        // Configuración de los nuevos botones
        btnReser2.setPrefWidth(200);
        btnReser2.setPrefHeight(200);

        btnReser4.setPrefWidth(200);
        btnReser4.setPrefHeight(200);

        btnreser6.setPrefWidth(200);
        btnreser6.setPrefHeight(200);

        btnReser2.setOnAction(event -> {
            AsignarReserva2();
            AlertaReser2();
        });

        btnReser4.setOnAction(event -> {
            AsignarReserva4();
            AlertaReser4();
        });

        btnreser6.setOnAction(event ->{
            AsignarReserva6();
            AlertaReser6();
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
        /*TableColumn<RestaurateDAO,Integer> tbcldCat = new TableColumn<>("ID platillo");
        tbcldCat.setCellValueFactory(new PropertyValueFactory<>("IDplatillo"));*/
        TableColumn<RestaurateDAO,String> tbcldCat2 = new TableColumn<>("Nombre");
        tbcldCat2.setCellValueFactory(new PropertyValueFactory<>("nombrePlatillo"));
        tbcldCat2.setPrefWidth(200);

        TableColumn<RestaurateDAO,String> borrar = new TableColumn<>("Borrar");
        borrar.setCellFactory(
                new Callback<TableColumn<RestaurateDAO, String>, TableCell<RestaurateDAO, String>>() {
                    @Override
                    public TableCell<RestaurateDAO, String> call(TableColumn<RestaurateDAO, String> RestaurateDAOStringTableColumn) {
                        return new ButtonCell(2);
                    }
                }
        );


        tvbRestaurante.getColumns().addAll(tbcldCat2,borrar);
        tvbRestaurante.setItems(restaurateDAO.LISTARPlatillo());
    }

    private void actualizarTabla() {
        tvbRestaurante.getItems().setAll(restaurateDAO.LISTARPlatillo());
    }

    private void AlertaHombre(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bienvenido");
        alert.setHeaderText(null);
        alert.setContentText("Bienvenido a Bayleys Caballero");

        alert.showAndWait();
    }

    private void AlertaMujer(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bienvenido");
        alert.setHeaderText(null);
        alert.setContentText("Bienvenido a Bayleys Dama");

        alert.showAndWait();
    }

    private void AlertaChef(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Chef");
        alert.setHeaderText(null);
        alert.setContentText("El chef tiene 10 años de practica en el area de comida" +
                "rapida, asi que confia en el.");

        alert.showAndWait();
    }

    private void AlertaRepa(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Repartidor");
        alert.setHeaderText(null);
        alert.setContentText("El repartidor es el mas rapido de celaya si" +
                "no llega en 30 minutos su comida es gratis.");

        alert.showAndWait();
    }

    private void AlertaPinche(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ayudante de cocina");
        alert.setHeaderText(null);
        alert.setContentText("El ayudante de cocina es una persona muy capaz" +
                "que tiene gran experiencia.");

        alert.showAndWait();
    }

    private void AlertaSencilla(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Hamburguesa Sencilla.");
        alert.setHeaderText(null);
        alert.setContentText("Selecciono una hamburguesa sencilla.");
        alert.showAndWait();
    }
    private void AlertaDoble(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Hamburguesa Doble.");
        alert.setHeaderText(null);
        alert.setContentText("Selecciono una hamburguesa doble.");
        alert.showAndWait();
    }
    private void AlertaHawa(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Hamburguesa Hawaiana.");
        alert.setHeaderText(null);
        alert.setContentText("Selecciono una hamburguesa Hawaiana.");
        alert.showAndWait();
    }

    private void AlertaCoca(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Coca-cola.");
        alert.setHeaderText(null);
        alert.setContentText("Selecciono una Coca-cola de 600ml.");
        alert.showAndWait();
    }

    private void AlertaAgua(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Agua.");
        alert.setHeaderText(null);
        alert.setContentText("Selecciono una Agua de 600ml.");
        alert.showAndWait();
    }

    private void AlertaTe(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Te Helado.");
        alert.setHeaderText(null);
        alert.setContentText("Selecciono un Te de 600ml.");
        alert.showAndWait();
    }

    private void AlertaPapas(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Papas Fritas.");
        alert.setHeaderText(null);
        alert.setContentText("Selecciono una orden de Papas Fritas.");
        alert.showAndWait();
    }

    private void AlertaAlitas(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alitas Picantes.");
        alert.setHeaderText(null);
        alert.setContentText("Selecciono una orden de Alitas Picantes.");
        alert.showAndWait();
    }

    private void AlertaNuget(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Nuget.");
        alert.setHeaderText(null);
        alert.setContentText("Selecciono una orden de Nugets.");
        alert.showAndWait();
    }

    private void AlertaCarne(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Carne.");
        alert.setHeaderText(null);
        alert.setContentText("La carne de hamburguesa es de la mas alta calidad.");
        alert.showAndWait();
    }
    private void AlertaPan(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pan.");
        alert.setHeaderText(null);
        alert.setContentText("El pan de hamburguesa es de la mas alta calidad.");
        alert.showAndWait();
    }
    private void AlertaTomate(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Jitomate.");
        alert.setHeaderText(null);
        alert.setContentText("El jitomate es de la mas alta calidad.");
        alert.showAndWait();
    }
    private void AlertaAlita(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alita.");
        alert.setHeaderText(null);
        alert.setContentText("Alita es freca, de la empresa bachoco.");
        alert.showAndWait();
    }
    private void AlertaPapa(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Papa.");
        alert.setHeaderText(null);
        alert.setContentText("La papa es fresca de la mas alta calidad.");
        alert.showAndWait();
    }
    private void AlertaNug(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Nuget.");
        alert.setHeaderText(null);
        alert.setContentText("Nuget fresco, de la empresa bachoco.");
        alert.showAndWait();
    }

    private void Alertax2(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Reserva mesa para 2.");
        alert.setHeaderText(null);
        alert.setContentText("Se ha hecho su reserva para 2 personas.");
        alert.showAndWait();
    }
    private void Alertax4(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Reserva mesa para 4.");
        alert.setHeaderText(null);
        alert.setContentText("Se ha hecho su reserva para 4 personas.");
        alert.showAndWait();
    }
    private void Alertax6(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Reserva mesa para 6.");
        alert.setHeaderText(null);
        alert.setContentText("Se ha hecho su reserva para 6 personas.");
        alert.showAndWait();
    }
    private void AlertaBts(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Combo BTS.");
        alert.setHeaderText(null);
        alert.setContentText("Proximamente disponible este producto.");
        alert.showAndWait();
    }
    private void AlertaEstu(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Combo Estudiantil.");
        alert.setHeaderText(null);
        alert.setContentText("Presenta tu credencial en ventanilla y llevate una sorpresa.");
        alert.showAndWait();
    }
    private void Alerta2x1(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Combo 2 x 1.");
        alert.setHeaderText(null);
        alert.setContentText("Disponible hasta 2024....");
        alert.showAndWait();
    }

    private void AlertaBueno(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Comentario Bueno.");
        alert.setHeaderText(null);
        alert.setContentText("Gracias por tu comentario bueno.");
        alert.showAndWait();
    }
    private void AlertaMalo(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Comentario Malo.");
        alert.setHeaderText(null);
        alert.setContentText("Gracias por tu comentario :( ");
        alert.showAndWait();
    }

    private void Alertades5(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Descuento del 5%.");
        alert.setHeaderText(null);
        alert.setContentText("Se ha seleccionado el descuento del 5%.");
        alert.showAndWait();
    }
    private void Alertades10(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Descuento del 10%.");
        alert.setHeaderText(null);
        alert.setContentText("Se ha seleccionado el descuento del 10%.");
        alert.showAndWait();
    }
    private void Alertades15(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Descuento del 15%.");
        alert.setHeaderText(null);
        alert.setContentText("Se ha seleccionado el descuento del 15%.");
        alert.showAndWait();
    }
    private void AlertaEfectivo(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pago Tarjeta.");
        alert.setHeaderText(null);
        alert.setContentText("Pase a ventanilla a pagar.");
        alert.showAndWait();
    }
    private void AlertaTarjeta(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Descuento del 15%.");
        alert.setHeaderText(null);
        alert.setContentText("Pase a ventanilla a pagar.");
        alert.showAndWait();
    }
    private void AlertaReser2(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Reservaciones.");
        alert.setHeaderText(null);
        alert.setContentText("Se ha solicitado su reservacion para 2 personas.");
        alert.showAndWait();
    }
    private void AlertaReser4(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Reservaciones.");
        alert.setHeaderText(null);
        alert.setContentText("Se ha solicitado su reservacion para 4 personas");
        alert.showAndWait();
    }
    private void AlertaReser6(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Reservaciones.");
        alert.setHeaderText(null);
        alert.setContentText("Se ha solicitado su reservacion para 6 personas.");
        alert.showAndWait();
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