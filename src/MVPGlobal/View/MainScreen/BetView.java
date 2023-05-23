package MVPGlobal.View.MainScreen;

import MVPGlobal.View.UISettings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.MalformedURLException;

public class BetView extends VBox  {

    private UISettings uiSettings;
    private Label setBetAmount;
    private TextField betAmount;
    private Button arrowUp;
    private Button arrowDown;
    private Image arrowUpIcon;
    private Image arrowDownIcon;

    public BetView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        this.setBetAmount = new Label("Your bet: ");
        this.betAmount = new TextField("");
        try{
            this.arrowUpIcon = new Image(uiSettings.getArrowUp().toUri().toURL().toString(), 18, 18, false, false);
        }
        catch(MalformedURLException ex){};
        this.arrowUp = new Button("", new ImageView(arrowUpIcon));
        try {
             this.arrowDownIcon = new Image(uiSettings.getArrowDown().toUri().toURL().toString(), 18, 18, false, false);
        }
        catch(MalformedURLException ex){};
        this.arrowDown = new Button("", new ImageView(arrowDownIcon));
        this.arrowDown.setVisible(false);
    }

    private void layoutNodes() {
        //ButtonsLeft
        HBox arrowButtonsBox = new HBox(arrowUp, arrowDown);
        arrowButtonsBox.setSpacing(uiSettings.getSpacing());
        arrowButtonsBox.setPadding(new Insets(uiSettings.getInsetsMargin()/2));

        this.setAlignment(Pos.CENTER);
        this.setSpacing(uiSettings.getSpacing()/2);
        this.setPadding(new Insets(uiSettings.getInsetsMargin()));
        this.setPrefWidth(uiSettings.getLowestRes()/85);

        this.getChildren().addAll(setBetAmount, betAmount, arrowButtonsBox);
    }

    // Getters

    Button getArrowUp() {return arrowUp;}

    Button getArrowDown() {return arrowDown;}

    TextField getBetAmount() {return betAmount;}

}
