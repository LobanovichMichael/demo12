package org.example.demo12;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public class HelloController {

    boolean isCross = true;

    @FXML
    protected HBox field;

    @FXML
    protected Label winLabel;

    @FXML
    protected void onButtonClick(ActionEvent event) {
        Button button = (Button)event.getSource();
        if (!button.getText().equals("")) {
            return;
        }
        String text;
        if (isCross) {
            text = "X";
        } else {
            text = "O";
        }
        isCross = !isCross;
        button.setText(text);
        if (!isWin().equals("")) {
            winLabel.setText("Игра окончена! Победили: " + isWin());
            field.setDisable(true);
        }
    }


    private String isWin() {
        ArrayList<VBox> vBoxes = new ArrayList<>();
        for (Node n : field.getChildren()) {
            vBoxes.add((VBox)n);
        }

        for (VBox vbox : vBoxes) {
            ObservableList<Node> oneCol = vbox.getChildren(); // Получаем все кнопки
//            if (
//                    !((Button) oneCol.get(0)).getText().isEmpty() && ((Button)oneCol.get(0)).getText().equals(((Button)oneCol.get(1)).getText())
//                            && ((Button)oneCol.get(0)).getText().equals(((Button)oneCol.get(2)).getText())
//
//            ) {
//            return ((Button)oneCol.get(0)).getText();
//        }
            if (isButtonsTextEquals((Button)oneCol.get(0), (Button)oneCol.get(1), (Button)oneCol.get(2))) {
                return ((Button)oneCol.get(0)).getText();
            }
        }

        for (int i = 0; i < 3; i++) {
//            if (
//                    !((Button)vBoxes.get(0).getChildren().get(i)).getText().isEmpty() && ((Button)vBoxes.get(0).getChildren().get(i)).getText().equals(((Button)vBoxes.get(1).getChildren().get(i)).getText())
//                    && ((Button)vBoxes.get(0).getChildren().get(i)).getText().equals(((Button)vBoxes.get(2).getChildren().get(i)).getText())
//            ) {
//                return ((Button)vBoxes.get(0).getChildren().get(i)).getText();
//            }

            if (isButtonsTextEquals((Button)vBoxes.get(0).getChildren().get(i),
                    (Button)vBoxes.get(1).getChildren().get(i), (Button)vBoxes.get(2).getChildren().get(i))) {
                return ((Button)vBoxes.get(0).getChildren().get(i)).getText();
            }
        }

//        if ( !((Button)vBoxes.get(0).getChildren().get(0)).getText().isEmpty() && ((Button)vBoxes.get(0).getChildren().get(0)).getText()
//                .equals(((Button)vBoxes.get(1).getChildren().get(1)).getText()) &&
//
//                ((Button)vBoxes.get(0).getChildren().get(0)).getText()
//                        .equals(((Button)vBoxes.get(2).getChildren().get(2)).getText())) {
//            return ((Button)vBoxes.get(0).getChildren().get(0)).getText();
//        }

        if (isButtonsTextEquals((Button)vBoxes.get(0).getChildren().get(0),
                (Button)vBoxes.get(1).getChildren().get(1), (Button)vBoxes.get(2).getChildren().get(2))) {
            return ((Button)vBoxes.get(0).getChildren().get(0)).getText();
        }


//        if (!((Button)vBoxes.get(2).getChildren().get(0)).getText().isEmpty() && ((Button)vBoxes.get(2).getChildren().get(0)).getText()
//                .equals(((Button)vBoxes.get(1).getChildren().get(1)).getText()) &&
//
//                ((Button)vBoxes.get(2).getChildren().get(0)).getText()
//                        .equals(((Button)vBoxes.get(0).getChildren().get(2)).getText())) {
//            return ((Button)vBoxes.get(2).getChildren().get(0)).getText();
//        }

        if (isButtonsTextEquals((Button)vBoxes.get(2).getChildren().get(0),
                (Button)vBoxes.get(1).getChildren().get(1),
                (Button)vBoxes.get(2).getChildren().get(0)
        )) {
            return ((Button)vBoxes.get(2).getChildren().get(0)).getText();
        }

        return "";
    }


    private boolean isButtonsTextEquals(Button a, Button b, Button c) {
        return a.getText().equals(b.getText()) && a.getText().equals(c.getText()) && !a.getText().isEmpty();
    }

}