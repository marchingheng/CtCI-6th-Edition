package deck_of_card_v1;



import java.util.ArrayList;

public class Hand <T extends Card>{
    protected ArrayList<T> cards;
    protected int score;

    public Hand(){
        cards = new ArrayList<T>();
        score = 0;
    }

    public int score(){
        for(T card: cards){
            score += card.getValue();
        }
        return score;
    }

    public void addCard(T card){
        cards.add(card);
    }
}
