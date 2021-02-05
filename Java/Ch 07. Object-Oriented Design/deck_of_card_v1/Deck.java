package deck_of_card_v1;

import java.util.ArrayList;
import java.util.Random;

public class Deck <T extends Card>{
    private ArrayList<T> deckOfCards;
    // the index of the earliest available card
    private int dealtIndex = 0;

    public Deck(){
    }

    // try to avoid creating object of generic class, put them in the signature of method instead
    public void setDeckOfCards(ArrayList<T> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public T dealCard(){
        if (deckOfCards.size() == 0){
            return null;
        }
        T card = deckOfCards.get(dealtIndex);
        dealtIndex += 1;
        return card;
    }
    // check out other shuffle methods
    public void shuffle(){
        Random random = new Random();
        for (int i = 0; i < deckOfCards.size(); i++) {
            int index1 = random.nextInt(deckOfCards.size());
            int index2 = random.nextInt(deckOfCards.size());
            T card1 = deckOfCards.get(index1);
            T card2 = deckOfCards.get(index2);
            deckOfCards.set(index1, card2);
            deckOfCards.set(index2, card1);
        }
    }

    public int remainCardNumber(){
        return deckOfCards.size() - dealtIndex;
    }

}
