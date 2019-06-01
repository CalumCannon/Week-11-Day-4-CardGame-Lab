import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {
/*
Deal two cards to a dealer and a player
Compare the hands
Determine the winner from who has the highest value hand
*/

    Deck deck;
    ArrayList<Player> players;
    Player player;
    Player dealer;
    Game game;

    @Before
    public void setup() {

        deck = new Deck();
        player = new Player();
        dealer = new Player();
        players = new ArrayList<Player>();
        players.add(player);
        players.add(dealer);

        game = new Game(players, deck);
    }

    @Test
    public void testDealingToDealerAndPlayer() {

        //Deal cards
        game.dealCards();
        assertEquals(2, player.handSize());
        assertEquals(2, dealer.handSize());
    }

    @Test
    public void testGamePlayerWin(){
        game.dealCards();
        game.pickWinner();
    }



}
