package blackJack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class hand {
    protected final List<Card> cards = new ArrayList<>();
    public int score() {
        int score = 0;
        for (Card card : cards) {
            score += card.value();
        }
        return score;
    }
    public void addCards(Card[] c) {
        Collections.addAll(cards, c);
    }
    public int size() {
        return cards.size();
    }
}
