package api;

import com.google.gson.GsonBuilder;
import common.Crypto;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

    }

    private static ApiCrypto getInstance(){
        if (apiCrypto == null){
            apiCrypto = new ApiCrypto();
        }

        return apiCrypto;
    }

    static public Observable<List<Crypto>> getObservableForCrypto(){
        ApiCrypto apiCrypto = ApiCrypto.getInstance();
        ApiCryptoAbstract apiCryptoAbstract = apiCrypto.retrofit.create(ApiCryptoAbstract.class);

        return apiCryptoAbstract.getData();
    }
}
