package kotlinexamples.com.rcjson.networkcalls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by subbaraoy on 4/5/18.
 */

public class APIClient {

   // public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
   public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    public static Retrofit retrofit;

    public static Retrofit getApiClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }

}
