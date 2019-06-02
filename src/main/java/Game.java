import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private ArrayList<Player> players;
    private Deck deck;

    public Game(ArrayList<Player> players, Deck deck){
        this.players = players;
        this.deck = deck;
    }

    public Deck getDeck(){
        return deck;
    }

    public Player getPlayer(){
        return players.get(0);
    }

    public Player getDealer(){
        return players.get(1);
    }

    public void dealCards(){

        for(int i=0; i<2; i++) {
            for (Player player : players) {
                player.addCardToHand(deck.dealOne());
            }
        }
    }

    public Player pickWinner(){
        //Player bust
        if(getPlayer().getHandValue() >= 22){
            return getDealer();
        }

        //Dealer bust
        if(getDealer().getHandValue() >= 22){
            return getPlayer();
        }

        if(getPlayer().getHandValue() > getDealer().getHandValue()){
            return getPlayer();
        }else{
            return getDealer();
        }
    }

    public void dealCardToPlayer() {
        players.get(0).addCardToHand(deck.dealOne());
    }

    public void dealCardToDealer() {
        players.get(1).addCardToHand(deck.dealOne());
    }
}
