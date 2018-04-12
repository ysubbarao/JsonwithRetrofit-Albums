package kotlinexamples.com.rcjson.adapter;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import kotlinexamples.com.rcjson.R;

/**
 * Created by subbaraoy on 4/4/18.
 */

public class UserRCViewHolder extends RecyclerView.ViewHolder {
    public static final String TAG = "message";


    TextView postId, id, name, email, body;

    public UserRCViewHolder(View itemView) {
        super(itemView);
        Log.d(TAG, "UserRCViewHolder");

        postId = itemView.findViewById(R.id.postId);
        id = itemView.findViewById(R.id.ID);
        name = itemView.findViewById(R.id.name);
        email = itemView.findViewById(R.id.email);
        body = itemView.findViewById(R.id.body);


    }
}
