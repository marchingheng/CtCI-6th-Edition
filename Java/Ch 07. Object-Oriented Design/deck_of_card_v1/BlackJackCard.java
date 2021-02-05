package deck_of_card_v1;

public class BlackJackCard extends Card{
    public BlackJackCard(Suit suit, int faceValue){
        super(suit, faceValue);
    }

    public int getValue(){
        if (isFaceCard()){
            return 10;
        }
        return faceValue;
    }

    public int getMaxValue(){
        if (isAce()){
            return 11;
        }
        return getValue();
    }
    
    public int getMinValue(){
        if (isAce()){
            return 1;
        }
        return getValue();
    }

    public boolean isAce(){
        return faceValue == 1;
    }

    public boolean isFaceCard() {
        return faceValue >= 11 && faceValue <= 13;
    }
}
