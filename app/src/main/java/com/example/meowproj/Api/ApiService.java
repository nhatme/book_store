package com.example.meowproj.Api;

import com.example.meowproj.Api.Model.OneProduct.RootOneProduct;
import com.example.meowproj.Api.Model.Product.RootProduct;
import com.example.meowproj.Api.Model.Login;
import com.example.meowproj.Api.Model.LoginRequest;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

//    Interceptor interceptor = chain -> {
//        Request request = chain.request();
//        Request.Builder builder = request.newBuilder();
//        builder.addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6Im5oYXRuZW9rQG5oYXRkZXYyay5pZC52biIsInVzZXJJZCI6IjY1YTAxNDE0Nzk4NzE4NGFmMTRhNmUyMiIsImlhdCI6MTcwNTkyMTE0MCwiZXhwIjoxNzA1OTI4MzQwfQ.GjLiJ3vaZ1dqXMWkB_VEoJG8mhSk2B-bsedd6QiXWBc");
//        return chain.proceed(builder.build());
//    };

    UpdateAuthToken interceptorToken = new UpdateAuthToken();
    OkHttpClient.Builder okBuilder = new OkHttpClient.Builder().addInterceptor(interceptorToken);
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://api-book-store-78sd.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okBuilder.build())
            .build()
            .create(ApiService.class);

    @POST("users/login")
    Call<Login> login(@Body LoginRequest loginRequest);
    @GET("products")
    Call<RootProduct> getAllProducts();
    @GET("products/{itemId}")
    Call<RootOneProduct> getOneProduct(@Path("itemId") String itemId);
}
