package common;

import local.CurrDefinition;

public class User {

    private static int idCounter = 0;

    private int id;
    private String name;
    private CurrDefinition popularCurrency;

    public User(String name, CurrDefinition popularCurrency) {
        this.name = name;
        this.popularCurrency = popularCurrency;

        this.id = idCounter++;
    }

    public String getName() {
        return name;
    }

    public CurrDefinition getPopularCurrency() {
        return popularCurrency;
    }
}
