import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Scanner;

public class runner {

    public static void main(String[] args) {

        Deck deck = new Deck();
        Player player = new Player();
        Player dealer = new Player();
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player);
        players.add(dealer);

        deck.shuffle();

        Game game = new Game(players, deck);

        System.out.println("Press enter to deal cards");
        Scanner scanner = new Scanner(System.in);

        game.dealCards();

        playerLoop(game);
        dealerLoop(game);

        compareHands(game);

    }

    public static void playerLoop(Game game){

        System.out.println("You have");


        for(Card card : game.getPlayer().returnHand()){
            System.out.println(card.getRank() + " " + card.getSuit());
        }

        String handValueMessage = "Hand value is "  + game.getPlayer().getHandValue();
        System.out.println(handValueMessage);

        if(game.getPlayer().isBust()){
            System.out.println("Bust");
            return;
        }

        System.out.println("Would you like to twist or stick?");

        Scanner scanner = new Scanner(System.in);
        String stickOrTwist = scanner.nextLine();

        if(stickOrTwist.equals("Twist") || stickOrTwist.equals("twist")){

            //deal card
            game.dealCardToPlayer();
            //loop again
            playerLoop(game);

        }else if(stickOrTwist.equals("Stick") || stickOrTwist.equals("stick")  ) {
                return;
        } else {
            playerLoop(game);
        }
    }

    public static void dealerLoop(Game game){

        System.out.println("Dealer has ");


        for(Card card : game.getDealer().returnHand()){
            System.out.println(card.getRank() + " " + card.getSuit());
        }

        if(game.getDealer().isBust()){
            System.out.println("Dealer is bust");
            return;
        }

        String handValueMessage = "Dealer hand value is "  + game.getDealer().getHandValue();
        System.out.println(handValueMessage);

        if(game.getDealer().getHandValue() < 16){
            //TWIST
            //deal card
            game.dealCardToDealer();
            //loop again
            dealerLoop(game);

        }

    }

    public static void compareHands(Game game){
       if(game.pickWinner() == game.getPlayer()){
           System.out.println("You won, well done");
       }else{
           System.out.println("Dealer won, you're shite");
       }
    }
}
