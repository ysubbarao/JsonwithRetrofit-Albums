package kotlinexamples.com.rcjson.networkcalls;

import java.util.ArrayList;

import kotlinexamples.com.rcjson.model.UserDetails;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by subbaraoy on 4/5/18.
 */

public interface APIInterface {

    //@POST("comments?postId=1")
    @GET("/comments?postId=1")
    Call<ArrayList<UserDetails>> getUserDetails();
}
