package com.example.mojara;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import conexion.Conexion;
import java.io.IOException;

public class HelloApplication extends Application {
    private Scene escena;
    private Stage MenuPrincipal;
    private Button btnPlatillos,btnBebidas,btnDetallePedido,btnPromo;
    private Button btnCaja,btnMesas,btnReservacion,btnDescu;
    private Button btnComentarios,btnPedido,btnSuge,btnHecho,
                   btnEmpleados,btnIngre,btnPago;
    private VBox vbox1,vbox2,vbox3;

    private HBox hboxPrincipal;

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
        Button botonEntrada = new Button("Entrada");
        botonEntrada.setOnAction(event -> {
            MenuPrincipalMojara();
        });
        StackPane root = new StackPane();
        root.getChildren().add(botonEntrada);
        escena = new Scene(root, 300, 250);
        stage.setScene(escena);
        stage.setTitle("Registrece para iniciar");
        stage.show();
    }

    private void MenuPrincipalMojara() {

        MenuPrincipal = new Stage();
        hboxPrincipal = new HBox();
        btnDetallePedido = new Button("DetallePedido");
        btnPlatillos = new Button("Platillos");
        btnBebidas = new Button("Bebidas");
        btnPromo = new Button("Promos");

        btnDetallePedido.setPrefWidth(150);
        btnDetallePedido.setPrefHeight(150);

        btnPlatillos.setPrefWidth(150);
        btnPlatillos.setPrefHeight(150);

        btnBebidas.setPrefWidth(150);
        btnBebidas.setPrefHeight(150);

        btnPromo.setPrefWidth(150);
        btnPromo.setPrefHeight(150);

        vbox1 = new VBox();
        vbox1.setSpacing(35);
        vbox1.getChildren().addAll(btnDetallePedido,btnPlatillos,btnBebidas,btnPromo);

        btnCaja = new Button("Cajas");
        btnMesas = new Button("Mesas");
        btnDescu = new Button("Descuentos");
        btnReservacion = new Button("Reservaciones");

        btnCaja.setPrefWidth(150);
        btnCaja.setPrefHeight(150);

        btnMesas.setPrefWidth(150);
        btnMesas.setPrefHeight(150);

        btnDescu.setPrefWidth(150);
        btnDescu.setPrefHeight(150);

        btnReservacion.setPrefWidth(150);
        btnReservacion.setPrefHeight(150);

        vbox2 = new VBox();
        vbox2.setSpacing(35);
        vbox2.getChildren().addAll(btnCaja,btnMesas,btnDescu,btnReservacion);

        btnComentarios = new Button("Comentarios");
        btnPedido = new Button("Pedidos");
        btnSuge = new Button("Sugerencia");
        btnHecho = new Button("Hecho con");

        btnComentarios.setPrefWidth(150);
        btnComentarios.setPrefHeight(150);

        btnPedido.setPrefWidth(150);
        btnPedido.setPrefHeight(150);

        btnSuge.setPrefWidth(150);
        btnSuge.setPrefHeight(150);

        btnHecho.setPrefWidth(150);
        btnHecho.setPrefHeight(150);

        vbox3 = new VBox();
        vbox3.setSpacing(35);
        vbox3.getChildren().addAll(btnComentarios,btnPedido,btnSuge,btnHecho);

        hboxPrincipal = new HBox(vbox1,new Separator(),vbox2,new Separator(),vbox3);
        Scene segundaEscena = new Scene(hboxPrincipal, 200, 150);
        MenuPrincipal.setScene(segundaEscena);
        MenuPrincipal.setTitle("Menu Principal");
        MenuPrincipal.show();
    }



    public static void main(String[] args) {
        launch();
    }
}