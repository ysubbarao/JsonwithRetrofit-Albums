package kotlinexamples.com.rcjson.activity;

import android.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import kotlinexamples.com.rcjson.R;
import kotlinexamples.com.rcjson.fragment.AlbumFragment;
import kotlinexamples.com.rcjson.model.UserDetails;
import kotlinexamples.com.rcjson.adapter.UserRCAdapter;
import kotlinexamples.com.rcjson.networkcalls.APIClient;
import kotlinexamples.com.rcjson.networkcalls.APIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "message";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        getFragmentInit();

       /*DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL );
       recyclerView.addItemDecoration(dividerItemDecoration);*/

    }

    private void getFragmentInit() {

        AlbumFragment albumFragment = new AlbumFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction.add(R.id.framlayout,albumFragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }





}
