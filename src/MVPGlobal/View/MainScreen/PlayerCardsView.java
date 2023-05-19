package MVPGlobal.View.MainScreen;

import MVPGlobal.Model.Card;
import MVPGlobal.View.UISettings;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class PlayerCardsView extends StackPane  {

    private UISettings uiSettings;

    public ArrayList<Card> playerCards = new ArrayList<Card>();
    private Image card;
    private ImageView cardView;
    private Image cardTwo;
    private ImageView cardViewTwo;

    private Image cardThree;
    private ImageView cardViewThree;



    public PlayerCardsView(UISettings uiSettings) {
        this.uiSettings = uiSettings;
        initialiseNodes();
        layoutNodes();
        addCard();
    }

    private void initialiseNodes() {
      /*  this.card = new Image("images/cards/clubs2.png");
        cardView = new ImageView(card);
        this.cardTwo = new Image("images/cards/clubs7.png");
        cardViewTwo = new ImageView(cardTwo);
        this.cardThree = new Image("images/cards/heartsK.png");
        cardViewThree = new ImageView(cardThree); */

    }

    private void layoutNodes() {
        this.setAlignment(Pos.CENTER);

    }

    //Methods

    public void addCard(){
        getChildren().clear();
        int x = 0;
        int r = -2;
        int y = 0;
        for (Card c : playerCards) {
            String cardNamePath = c.getSuit() + c.getCardNumb();
            try{
                card = new Image(uiSettings.getCardImage().toUri().toURL() + cardNamePath + ".png");}
            catch(MalformedURLException ex){}

            ImageView cardView = new ImageView(card);
            cardView.setPreserveRatio(true);
            cardView.setFitWidth(uiSettings.getCardWidth());
            cardView.setFitHeight(uiSettings.getCardHeight());
            cardView.setTranslateX(uiSettings.getCardOffsetX() * x);

            if(playerCards.size() <= 2 && r == -2) {
                r = -1;
            }
            cardView.setRotate(uiSettings.getCardRotate() * r);
            cardView.setTranslateY(-(uiSettings.getCardOffsetY() + (y*4)));
            getChildren().add(cardView);
            x++;
            r++;

            if(y < ((playerCards.size()/2)-1)){
                y++;
            }else{y--;};

        }
    }


    // Getters
    ArrayList<Card> getPlayerCards() {
        return playerCards;
    }
}
