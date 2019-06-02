import java.util.ArrayList;

public class Player {

    ArrayList<Card> hand;

    public Player(){
        hand = new ArrayList<Card>();
    }

    public void addCardToHand(Card card){
        this.hand.add(card);
    }

    public int handSize() {
        return hand.size();
    }

    public int returnCardRank(){
        return hand.get(0).getRank().getValue();
    }

    public ArrayList<Card> returnHand(){
        return hand;
    }

    public int getHandValue(){
        int handValue = 0;
        for(Card card : hand){
          handValue += card.getValue();
        }

        if(handValue  > 21){
            if(hasAce()){
                System.out.println("Ace value is counting as 1");
                handValue -= 10;
            }
        }
        return handValue;
    }

    public boolean hasAce(){
        for(Card card : hand){
            if(card.getRank() == Rank.ACE){
                return true;
            }
        }
        return false;
    }


    public boolean isBust() {
        if(getHandValue() > 21){
            return true;
        }
        return false;
    }
}
