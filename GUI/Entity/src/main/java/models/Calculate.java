package models;

import local.CurrDefinition;

import java.util.List;

public class Calculate {
    private List<CurrDefinition> currDefinitionList;

    public Calculate(List<CurrDefinition> currDefinitionList) {
        this.currDefinitionList = currDefinitionList;
    }

    public List<CurrDefinition> getCurrDefinitionList() {
        return currDefinitionList;
    }
}
