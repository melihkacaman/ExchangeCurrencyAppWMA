package models;

import local.CurrDefinition;

import java.util.List;

public class Home {
    private String name;
    private List<CurrDefinition> currencies;
    private CurrDefinition popularCurr;

    public Home(String name, List<CurrDefinition> currencies) {
        this.name = name;
        this.currencies = currencies;
    }

    public Home(String name) {
        this.name = name;
    }

    public Home(String name, CurrDefinition popularCurr) {
        this.name = name;
        this.popularCurr = popularCurr;
    }

    public Home() {
    }

    public Home(List<CurrDefinition> currencies) {
        this.currencies = currencies;
    }

    public String getName() {
        return name;
    }

    public List<CurrDefinition> getCurrencies() {
        return currencies;
    }
}
