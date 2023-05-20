package MVPGlobal.View.StartScreen;

import MVPGlobal.Model.*;
import MVPGlobal.View.*;
import MVPGlobal.View.AboutScreen.AboutScreenView;
import MVPGlobal.View.InfoScreen.InfoScreenView;
import MVPGlobal.View.MainScreen.MainScreenPresenter;
import MVPGlobal.View.MainScreen.MainScreenView;
import javafx.event.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.Region;
import javafx.stage.WindowEvent;

import javax.swing.*;
import java.net.MalformedURLException;

public class StartScreenPresenter {

    private BlackJackGame blackJackGame;
    private StartScreenView view;
    private MainScreenPresenter mainScreenPresenter;
    private UISettings uiSettings;
    //private AboutScreenView aboutView;

    private InfoScreenView infoScreenView;

    public StartScreenPresenter(BlackJackGame blackJackGame, StartScreenView view, UISettings uiSettings /*AboutScreenView aboutView*/) {
        this.blackJackGame = blackJackGame;
        this.view = view;
        this.uiSettings = uiSettings;
        updateView();
        EventHandlers();
    }

    private void updateView() {
    }

    private void EventHandlers() {
        view.getTransition().setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainScreenView msView = new MainScreenView(uiSettings);
                MainScreenPresenter msPresenter = new MainScreenPresenter(blackJackGame, msView, uiSettings);
                view.getScene().setRoot(msView);
                try {
                    msView.getScene().getStylesheets().add(uiSettings.getStyleSheetPath().toUri().toURL().toString());
                } catch (MalformedURLException ex) {
                    // // do nothing, if toURL-conversion fails, program can continue
                }
                msView.getScene().getWindow().sizeToScene();
                msView.getScene().getWindow().setX(uiSettings.getResX() / 20);
                msView.getScene().getWindow().setY(uiSettings.getResY() / 20);
                msView.getScene().getWindow().setHeight(9 * uiSettings.getResY() / 10);
                msView.getScene().getWindow().setWidth(9 * uiSettings.getResX() / 10);
                msPresenter.windowsHandler();

                startAlert();
            }
        });
    }

    public void windowsHandler() {
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
             @Override
             public void handle(WindowEvent event) {
                 final Alert stopWindow = new Alert(Alert.AlertType.ERROR);
                 stopWindow.setHeaderText("You can not yet close the application.");
                 stopWindow.setContentText("Try again after the program has started");
                 stopWindow.showAndWait();
                 event.consume(); } });
    }

    private void startAlert(){

        // Alert to start the game
        Alert startAlert = new Alert(Alert.AlertType.INFORMATION);
        startAlert.setTitle("Ready?");
        startAlert.setHeaderText("Welcome to BlackJack - Knights Of The Future!");
        startAlert.setContentText("This is the information you need to start.");
        ButtonType moreInfoBtn = new ButtonType("More Info", ButtonBar.ButtonData.HELP);
        ButtonType startBtn = new ButtonType("Start", ButtonBar.ButtonData.OK_DONE);
        startAlert.setResizable(true);
        startAlert.getDialogPane().setPrefSize(500,400);
        startAlert.show();

        DialogPane dialogPane = startAlert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("/stylesheets/BlackjackKnightsOfTheFuture.css").toExternalForm());
        dialogPane.getStyleClass().add("dialog");

        if (startAlert.getResult() == moreInfoBtn) {
            mainScreenPresenter.getInfoActionEvent();
        } else if(startAlert.getResult() == startBtn) {
            startAlert.close();
            //showDealButton();
        }
    }
}
