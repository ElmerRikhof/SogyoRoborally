package roborally.domain;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDeck {

    private List<String> chosencardsp1 = new ArrayList<>();
    private List<String> chosencardsp2 = new ArrayList<>();
    private static List<String> carddeck = new ArrayList<>(List.of("moveone", "movetwo", "movethree", "turnleft", "turnright", "turnaround", "moveone", "movetwo", "movethree", "turnleft", "turnright", "turnaround", "moveone", "movetwo", "movethree", "turnleft", "turnright", "turnaround", "moveone", "movetwo", "movethree", "turnleft", "turnright", "turnaround", "moveone", "movetwo", "movethree", "turnleft", "turnright", "turnaround"));
    private static List<String> usedcardstack = new ArrayList<>(List.of());
    private List<String> carddeckp1 = generateCardDeckP1(carddeck, 9);
    private List<String> carddeckp2 = generateCardDeckP2(carddeck, 9);


    //player 1
    public List<String> getCarddeckp1() {
        return carddeckp1;
    }

    public void setCarddeckp1(List<String> deckp1) {
        this.carddeckp1 = deckp1;
    }
    
    public void chosenCardsP1(String str) {
        chosencardsp1.add(str);
        updateCardDeckP1(chosencardsp1);
        chosencardsp1.remove(str);
    }


    public void updateCardDeckP1(List<String> chosencardsp1) {

        for (String item : chosencardsp1) {
        carddeckp1.remove(item); 
        }

        Random random = new Random();
        while (carddeckp1.size() < 9) {
            int randomIndex = random.nextInt(carddeck.size());
            String randomString = carddeck.get(randomIndex);
            carddeckp1.add(randomString);
            carddeck.remove(randomString);
            usedcardstack.add(randomString);
            if (carddeck.size() == 0){
                shuffleCardDeck();
            }
        }
    }

    public static List<String> generateCardDeckP1(List<String> carddeck, int count) {
        List<String> carddeckp1 = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int maxIndexDeck = carddeck.size();
            int randomIndexNumber = random.nextInt(maxIndexDeck);
            String randomString = carddeck.get(randomIndexNumber);
            carddeckp1.add(randomString);
            carddeck.remove(randomString);
            usedcardstack.add(randomString);
        }
        return carddeckp1;
    }


    //Player2 
    public List<String> getCarddeckp2() {
        return carddeckp2;
    }

    public void setCarddeckp2(List<String> deckp2) {
        this.carddeckp2 = deckp2;
    }

    public void chosenCardsP2(String str) {
        chosencardsp2.add(str);
        updateCardDeckP2(chosencardsp2);
        chosencardsp2.remove(str);
    }

    private void updateCardDeckP2(List<String> chosencardsp2) {
    
        for (String item : chosencardsp2) {
            carddeckp2.remove(item);
        }

        Random random = new Random();
        while (carddeckp2.size() < 9) {
            int randomIndex = random.nextInt(carddeck.size());
            String randomString = carddeck.get(randomIndex);
            carddeckp2.add(randomString);
            carddeck.remove(randomString);
            usedcardstack.add(randomString);
            if (carddeck.size() == 0){
                shuffleCardDeck();
            }
        }
    }

    public static List<String> generateCardDeckP2(List<String> carddeck, int count) {
        List<String> carddeckp2 = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int maxIndex = carddeck.size();
            int randomIndex = random.nextInt(maxIndex);
            String randomString1 = carddeck.get(randomIndex);
            carddeckp2.add(randomString1);
            carddeck.remove(randomString1);
            usedcardstack.add(randomString1);
        }
        return carddeckp2;
    }

    public void shuffleCardDeck(){
        for (String item : usedcardstack) {
        carddeck.add(item);
        }
        emptyUsedCardStack();
    }

    public void emptyUsedCardStack(){
            usedcardstack.clear();
    }
}