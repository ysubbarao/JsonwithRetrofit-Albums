package kotlinexamples.com.rcjson.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import kotlinexamples.com.rcjson.R;
import kotlinexamples.com.rcjson.model.UserDetails;
import kotlinexamples.com.rcjson.adapter.UserRCAdapter;
import kotlinexamples.com.rcjson.networkcalls.APIClient;
import kotlinexamples.com.rcjson.networkcalls.APIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "message";
    Context context;


    RecyclerView recyclerView;
    UserRCAdapter userRCAdapter;
    RecyclerView.LayoutManager layoutManager;
    APIInterface apiInterface;
    private List<UserDetails> userList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        //initiaterecyclerview
        initiateRecyclerview();

        // make call async tasks
        makeServiceCalls();

       /*DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL );
       recyclerView.addItemDecoration(dividerItemDecoration);*/

    }

    private void makeServiceCalls() {
        apiInterface = APIClient.getApiClient().create(APIInterface.class);


        Call<ArrayList<UserDetails>> call = apiInterface.getUserDetails();
        // Call<UserDetails> call = apiInterface.getUserDetails();
        call.enqueue(new Callback<ArrayList<UserDetails>>() {
            @Override
            public void onResponse(Call<ArrayList<UserDetails>> call, Response<ArrayList<UserDetails>> response) {
               // userList.addAll(response.body().bookstore);
                userList.addAll(response.body());
                Log.d(TAG, "userList values " + userList.toString());
                userRCAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<UserDetails>> call, Throwable t) {
                Log.d(TAG, "onfailure " + t.getLocalizedMessage());
            }
        });
    }

    private void initiateRecyclerview() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        userRCAdapter = new UserRCAdapter(MainActivity.this, userList);
        recyclerView.setAdapter(userRCAdapter);
    }

}
