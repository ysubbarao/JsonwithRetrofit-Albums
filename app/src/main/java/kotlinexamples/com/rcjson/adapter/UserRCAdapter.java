package kotlinexamples.com.rcjson.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kotlinexamples.com.rcjson.R;
import kotlinexamples.com.rcjson.activity.MainActivity;
import kotlinexamples.com.rcjson.model.UserDetails;

/**
 * Created by subbaraoy on 4/4/18.
 */

public class UserRCAdapter extends RecyclerView.Adapter<UserRCViewHolder> {

    Context context;
    LayoutInflater layoutInflater;
    MainActivity mainActivity;
    public static final String TAG = "message";
    private List<UserDetails> userList = new ArrayList<>();


    public UserRCAdapter(MainActivity mainActivity, List<UserDetails> userList) {
        this.userList = userList;
        this.mainActivity = mainActivity;
        // layoutInflater.from(mainActivity);

    }

    @Override
    public UserRCViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mainActivity).inflate(R.layout.albumdetails, parent, false);
        UserRCViewHolder userRCViewHolder = new UserRCViewHolder(view);

        Log.d(TAG, "userRCViewHolder");

        return userRCViewHolder;
    }

    @Override
    public void onBindViewHolder(UserRCViewHolder holder, int position) {

        holder.postId.setText(String.valueOf(userList.get(position).getPostId()));
        holder.id.setText(String.valueOf(userList.get(position).getID()));
        holder.name.setText(userList.get(position).getName());
        holder.email.setText(userList.get(position).getEmail());
        holder.body.setText(userList.get(position).getBody());


    }


    @Override
    public int getItemCount() {

        return userList.size();
    }
}
