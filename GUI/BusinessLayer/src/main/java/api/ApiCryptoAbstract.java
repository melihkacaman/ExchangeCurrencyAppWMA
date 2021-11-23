package api;

import common.Crypto;
import retrofit2.Call;
import retrofit2.http.GET;

import javax.annotation.processing.Generated;
import java.util.List;

public interface ApiCryptoAbstract {
    // GET, UPDATE, DELETE, POST
    // https://api.nomics.com/v1/prices?key=743fef512bfbcd6a506c533d4fd2b826a2680bed

    @GET("prices?key=743fef512bfbcd6a506c533d4fd2b826a2680bed")
    Call<List<Crypto>> getData();
}
