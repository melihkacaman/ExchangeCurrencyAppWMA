package locals;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDefinitionProcess {
    static private List<CurrencyDefinition> currencies = readCurrencies();

    private CurrencyDefinitionProcess(){

    }

    private static List<CurrencyDefinition> readCurrencies(){
        JSONParser jsonParser = new JSONParser();

        try(FileReader reader = new FileReader("Resource/currencies.json")) {
            Object obj = jsonParser.parse(reader);

            JSONArray currencyList = (JSONArray) obj;
            System.out.println(currencyList);

            List<CurrencyDefinition> favouriteCurrencies = new ArrayList<>();
            for (Object currency : currencyList) {
                JSONObject cr = (JSONObject) currency;
                CurrencyDefinition newCurrencyDefinition =
                        new CurrencyDefinition((String) cr.get("code"),(String) cr.get("name"));
                favouriteCurrencies.add(newCurrencyDefinition);
            }

            return favouriteCurrencies;

        } catch (IOException | ParseException e) {
            return null;
        }
    }

    public static List<CurrencyDefinition> getCurrencies(){
        return currencies;
    }

    public static CurrencyDefinition getCurrencyFromSelectedItem(String selectedItem){
        String items[] = selectedItem.split("-");
        String code = items[0];

        return getCurrencyFromCode(code);
    }

    public static CurrencyDefinition getCurrencyFromCode(String code){
        for (CurrencyDefinition c : currencies) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }

        return null;
    }
}