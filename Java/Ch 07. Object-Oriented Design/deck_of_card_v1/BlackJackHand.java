package deck_of_card_v1;

import java.util.ArrayList;
import java.util.List;

public class BlackJackHand extends Hand<BlackJackCard>{
    public int score(){
        List<Integer> scores = getAllPossibleScores();
        int maxScore = Integer.MIN_VALUE;
        int minScore = Integer.MAX_VALUE;
        for (int score: scores){
            if (score > 21 && score < minScore){
                minScore = score;
            }else if (score <= 21 && score > maxScore){
                maxScore = score;
            }
        }
        return maxScore == Integer.MIN_VALUE ? minScore:maxScore;
    }

    public List<Integer> getAllPossibleScores(){
    	List<Integer> scores = new ArrayList<Integer>();
        for (BlackJackCard card: cards){
            addCardToUpdateScore(scores, card);
        }
        return scores;
    }

    public void addCardToUpdateScore(List<Integer> scores, BlackJackCard card){
        if (cards.size() == 0){
            scores.add(0);
        }
        // this is always 0?
        int length = scores.size();
        for (int i = 0; i < length; i++) {
            int score = scores.get(i);
            scores.set(i, score + card.getMinValue());
            if (card.isAce()) {
                scores.add(score + card.getMaxValue());
            }
        }
    }

    public boolean isBusted(){
        return score() > 21;
    }

    public boolean isBlackJack(){
        if (cards.size() != 2){
            return false;
        }
        BlackJackCard card1 = cards.get(0);
        BlackJackCard card2 = cards.get(1);
        return (card1.isAce() && card2.isFaceCard()) || 
        		(card1.isFaceCard() && card2.isAce());
    }
}
