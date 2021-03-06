package local;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CurrDefinitionProcess {
    public static List<CurrDefinition> currencies;

    static {
        try {
            currencies = readCurrencies();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private CurrDefinitionProcess() {
    }

    private static List<CurrDefinition> readCurrencies() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();

        FileReader reader = new FileReader("Resource/currencies.json");
        Object obj = jsonParser.parse(reader);

        JSONArray currencyList = (JSONArray) obj;
        System.out.println(currencyList);

        List<CurrDefinition> favouriteCurrencies = new ArrayList<>();
        for (Object currency : currencyList) {
            JSONObject cr = (JSONObject) currency;
            CurrDefinition newCurrencyDefinition =
                    new CurrDefinition((String) cr.get("code"), (String) cr.get("name"));
            favouriteCurrencies.add(newCurrencyDefinition);
        }

        return favouriteCurrencies;
    }

    public static CurrDefinition getCurrencyFromSelectedItem(String selectedItem){
        String items[] = selectedItem.split("-");
        String code = items[0];

        return getCurrencyFromCode(code);
    }

    public static CurrDefinition getCurrencyFromCode(String code){
        for (CurrDefinition c : currencies) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }

        return null;
    }
}


