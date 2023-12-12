package componentes;

import javafx.scene.control.*;
import modelos.RestaurateDAO;

import java.util.Optional;

public class ButtonCell extends TableCell<RestaurateDAO,String> {
    private Button btnCelda;
    private int opc;
    private TableView<RestaurateDAO> tbvRestaurante;
    private TableView<RestaurateDAO> tbvResta;
    private RestaurateDAO objRes;

    public ButtonCell(int opc){
        this.opc = opc;
        String txtBtn = this.opc == 1 ? "Editar" : "Eliminar";
        btnCelda=new Button(txtBtn);
        btnCelda.setOnAction(event -> accionBoton());
    }

    private void accionBoton(){
        tbvRestaurante = ButtonCell.this.getTableView();
        objRes = tbvRestaurante.getItems().get(ButtonCell.this.getIndex());

        if(this.opc ==1){
            //new CategoriaForm(tbvTaquerias, objCat);
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Topicos Avanzados de Programacion");
            alert.setHeaderText("Confirmacion del sistema");
            alert.setContentText("¿Deseas eliminar?");

            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
                objRes.eliminarTodo();
                tbvRestaurante.setItems(objRes.LISTARPlatillo());
                tbvRestaurante.refresh();
            }
        }
    }
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty){
            this.setGraphic(btnCelda);
        }
    }
}
