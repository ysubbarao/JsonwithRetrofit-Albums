package kotlinexamples.com.rcjson.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by subbaraoy on 4/4/18.
 */

public class UserDetails {


    @SerializedName("postId")
    private int postId;

    @SerializedName("id")
    private int ID;

    @SerializedName("name")
    private  String name;

    @SerializedName("email")
    private  String email;

    @SerializedName("body")
    private String body;

    public int getPostId() {
        return postId;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
