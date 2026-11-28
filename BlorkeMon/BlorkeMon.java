import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GottaSnatchEmAll {

    private final Set<String> cards = new HashSet<>();

    public Set<String> newCollection(List<String> cardList) {
        this.cards.addAll(cardList);
        return new HashSet<>(this.cards);
    }

    public boolean addCard(String card) {
        return this.cards.add(card);
    }

    public boolean canTrade(Set<String> obj1, Set<String> obj2) {
        return !obj1.containsAll(obj2) && !obj2.containsAll(obj1);
    }

    public Set<String> commonCards(List<Set<String>> cardsList) {
        if(cardsList == null || cardsList.isEmpty()) {
            return Collections.emptySet();
        }

        Set<String> common = new HashSet<>(cardsList.getFirst());
        for(int i=1; i < cardsList.size(); ++i) {
            common.retainAll(cardsList.get(i));
            if(common.isEmpty()) {
                break;
            }
        }

        return common;
    }

    public Set<String> allCards(List<Set<String>> cardsList) {
        Set<String> allUniqueCards = new HashSet<>(cardsList.getFirst());
        for (Set<String> cards : cardsList) {
            if (cards != null) {
                allUniqueCards.addAll(cards);
            }
        }

        return allUniqueCards;
    }
}

public class BlorkeMon {
    public static void main(String[] args) {

        GottaSnatchEmAll game = new GottaSnatchEmAll();

        // 1. Create player collections
        GottaSnatchEmAll player1 = new GottaSnatchEmAll();
        GottaSnatchEmAll player2 = new GottaSnatchEmAll();
        GottaSnatchEmAll player3 = new GottaSnatchEmAll();

        Set<String> deck1 = player1.newCollection(
            List.of("Blorkachu", "Charblork", "Blorkbasaur", "Blorkachu")
        );

        Set<String> deck2 = player2.newCollection(
            List.of("Blorkachu", "Squirtblork", "Mewblork")
        );

        Set<String> deck3 = player3.newCollection(
            List.of("Blorkachu", "Blorkbasaur", "Eeveeblork")
        );

        System.out.println("=== PLAYER COLLECTIONS ===");
        System.out.println("Deck 1: " + deck1);
        System.out.println("Deck 2: " + deck2);
        System.out.println("Deck 3: " + deck3);
        System.out.println();

        // 2. Test addCard()
        System.out.println("=== ADD CARD ===");

        System.out.println(
            "Adding Pidgeblork: " + player1.addCard("Pidgeblork")
        );

        System.out.println(
            "Adding Blorkachu (duplicate): " + player1.addCard("Blorkachu")
        );

        System.out.println("Updated Player 1: " +
            player1.newCollection(List.of())
        );
        System.out.println();

        // 3. Test canTrade()
        System.out.println("=== TRADING ===");

        Set<String> subsetDeck = Set.of("Blorkachu");

        System.out.println(
            "Can Deck 1 and Deck 2 trade? " +
            game.canTrade(deck1, deck2)
        );

        System.out.println(
            "Can Deck 1 and subsetDeck trade? " +
            game.canTrade(deck1, subsetDeck)
        );
        System.out.println();

        // 4. Test commonCards()
        System.out.println("=== COMMON CARDS ===");

        List<Set<String>> allDecks = List.of(deck1, deck2, deck3);

        System.out.println(
            "Common cards across all decks: " +
            game.commonCards(allDecks)
        );
        System.out.println();

        // 5. Test allCards()
        System.out.println("=== ALL UNIQUE CARDS ===");

        System.out.println(
            "All unique cards combined: " +
            game.allCards(allDecks)
        );
    }
}
