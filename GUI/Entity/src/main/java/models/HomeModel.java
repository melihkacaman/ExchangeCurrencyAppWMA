package models;

import local.CurrDefinition;

import java.util.List;

public class HomeModel {
    private String name;
    private List<CurrDefinition> currencies;
    private CurrDefinition popularCurr;

    public HomeModel(String name, List<CurrDefinition> currencies) {
        this.name = name;
        this.currencies = currencies;
    }

    public HomeModel(String name) {
        this.name = name;
    }

    public HomeModel(String name, CurrDefinition popularCurr) {
        this.name = name;
        this.popularCurr = popularCurr;
    }

    public HomeModel() {
    }

    public HomeModel(List<CurrDefinition> currencies) {
        this.currencies = currencies;
    }

    public String getName() {
        return name;
    }

    public List<CurrDefinition> getCurrencies() {
        return currencies;
    }
}
