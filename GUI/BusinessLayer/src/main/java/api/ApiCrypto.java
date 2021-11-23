package api;

import com.google.gson.GsonBuilder;
import common.Crypto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;

public class ApiCrypto {
    private static final String BASE_URL = "https://api.nomics.com/v1/";
    private static ApiCrypto apiCrypto = null;
    private Retrofit retrofit;

    private ArrayList<Crypto> cryptos;

    private ApiCrypto(){
        this.cryptos = new ArrayList<>();
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

    }

    private static ApiCrypto getInstance(){
        if (apiCrypto == null){
            apiCrypto = new ApiCrypto();
        }

        return apiCrypto;
    }

    static public List<Crypto> getData(){
        ApiCrypto apiCrypto = ApiCrypto.getInstance();
        ApiCryptoAbstract apiCryptoAbstract = apiCrypto.retrofit.create(ApiCryptoAbstract.class);

        Call<List<Crypto>> call = apiCryptoAbstract.getData();
        call.enqueue(new Callback<List<Crypto>>() {
            @Override
            public void onResponse(Call<List<Crypto>> call, Response<List<Crypto>> response) {
                if (response.isSuccessful()){
                    for (Crypto crypto : response.body()) {
                        System.out.println(crypto.price + " - " + crypto.currency);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Crypto>> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return null;
    }
}
