package com.example.ismael.teste;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ismael on 17/08/17.
 */

public interface RequestInterface {



    @GET("games/jsongames/")
    Call<BestGames> getJSON();
}
