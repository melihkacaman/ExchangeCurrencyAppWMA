package common;

import com.google.gson.annotations.SerializedName;

public class Crypto {
    @SerializedName("currency")
    public String currency;
    @SerializedName("price")
    public String price;
}
