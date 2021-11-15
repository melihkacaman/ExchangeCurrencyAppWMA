import locals.CurrencyDefinitionProcess;

public class CurrencyDefinition {
    private String code;
    private String name;

    public CurrencyDefinition(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
