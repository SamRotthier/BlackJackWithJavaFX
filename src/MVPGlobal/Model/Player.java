package MVPGlobal.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends CardHandler {
    private int playerBet;
    private int bank = 0;

    private String playerName;

    void placeBet(int bettingAmount) {
        boolean bettingAmountOk = true;
        while (bettingAmountOk) {
            if (bettingAmount <= 0) {
                //System.out.println("The house doesn't play for free");
            } else if (bettingAmount > bank) {
                //System.out.println("Looks like you're too broke, you are trying to bet more then what you have");
            } else {
                bettingAmountOk = false;
                bank -= bettingAmount;
            }
        }
    }

    void winRound() {
        bank += playerBet * 2;
    }

    void pushRound() {
        bank += playerBet;
    }

    void playerDouble(ArrayList<Card> Deck) {
        if (bank >= (playerBet * 2)) {
            bank -= playerBet;
            playerBet *= 2;
            hitCard(Deck);
        } else {
            System.out.println("Looks like you're too broke, you are trying to bet more then what you have");
        }
    }


    //Getter
    public int getBank() {
        return bank;
    }

    public int getPlayerBet() {
        return playerBet;
    }

    public String getPlayerName() {
        return playerName;
    }


    //setter
    public void setBank(int bank) {
        this.bank = bank;
    }

    public void setPlayerBet(int playerBet) {
        this.playerBet = playerBet;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    //Constructor
    Player() {
        playerBet = 0;
        bank = 500;
    }
}
