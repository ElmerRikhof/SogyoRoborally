package com.roborally.api.models;

import roborally.domain.CardDeck;
import java.util.List;

public class CardDeckDTO {
    
    private List<String> randomStrings;
    private List<String> randomStringsp2;

    public List<String> getRandomStringsP2() {
        return randomStringsp2;
    }

    public void setRandomStringsP2(List<String> randomStringsp2) {
        this.randomStringsp2 = randomStringsp2;
    }

    public List<String> getRandomStrings() {
        return randomStrings;
    }

    public void setRandomStrings(List<String> randomStrings) {
        this.randomStrings = randomStrings;
    }

    public CardDeckDTO(CardDeck randomStrings, CardDeck randomStringsp2){
        setRandomStrings(randomStrings.getCarddeckp1());
        setRandomStringsP2(randomStringsp2.getCarddeckp2());
    }
}
