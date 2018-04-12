package kotlinexamples.com.rcjson.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import kotlinexamples.com.rcjson.R;

import kotlinexamples.com.rcjson.adapter.UserRCAdapter;
import kotlinexamples.com.rcjson.model.UserDetails;
import kotlinexamples.com.rcjson.networkcalls.APIClient;
import kotlinexamples.com.rcjson.networkcalls.APIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AlbumFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AlbumFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlbumFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String TAG = "message";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Context context;
    RecyclerView recyclerView;
    UserRCAdapter userRCAdapter;
    RecyclerView.LayoutManager layoutManager;
    APIInterface apiInterface;
    private List<UserDetails> userList;
    TextView albumhdr;


    private OnFragmentInteractionListener mListener;

    public AlbumFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlbumFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlbumFragment newInstance(String param1, String param2) {
        AlbumFragment fragment = new AlbumFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        userList = new ArrayList<>();

        View view = inflater.inflate((R.layout.fragment_album), container, false);

        initRecyclerview(view);
        makeServiceCalls();

        // Inflate the layout for this fragment
        return view;
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

    private void initRecyclerview(View view) {

        recyclerView = view.findViewById(R.id.recyclerview);
        albumhdr = view.findViewById(R.id.albumhdr);

        userRCAdapter = new UserRCAdapter(getActivity(), userList);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        //recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(userRCAdapter);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       /* if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
