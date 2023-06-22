package com.roborally.api.models;

import java.util.List;

public class PlayInputDTO {
    
    private List<String> chosenCards;
    private List<String> chosenCardsP2;
    
    public List<String> getChosenCards() {
        return chosenCards;
    }
    public void setChosenCards(List<String> chosenCards) {
        this.chosenCards = chosenCards;
    }
    public List<String> getChosenCardsP2() {
        return chosenCardsP2;
    }
    public void setChosenCardsP2(List<String> chosenCardsP2) {
        this.chosenCardsP2 = chosenCardsP2;
    }
    
}
