package kh.edu.rupp.visitme.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import kh.edu.rupp.visitme.R;
import kh.edu.rupp.visitme.adapter.HistoryAdapter;
import kh.edu.rupp.visitme.api.ApiService;
import kh.edu.rupp.visitme.databinding.ActivityUserBinding;
import kh.edu.rupp.visitme.model.History;
import kh.edu.rupp.visitme.model.Profile;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserActivity extends Activity {

    private ActivityUserBinding binding;
    private ImageView coverImage;
    private ImageView profileImage;
    private TextView nameTextView;
    private RecyclerView orderHistoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        coverImage = binding.coverImage;
        profileImage = binding.profileImage;
        nameTextView = binding.userName;
        orderHistoryRecyclerView = binding.orderHistoryList;



        // Initialize Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://smlp-pub.s3.ap-southeast-1.amazonaws.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of your ApiService interface
        ApiService apiService = retrofit.create(ApiService.class);

        // Replace "your_profile_endpoint" with the actual endpoint from your API
        Call<Profile> profileCall = apiService.loadProfile();

        // Make network request asynchronously
        profileCall.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (response.isSuccessful()) {
                    // Load images using Picasso
                    Picasso.get().load(response.body().getCoverImage()).into(binding.coverImage);
                    Picasso.get().load(response.body().getProfileImage()).into(binding.profileImage);

                    // Set the user's name
                    String fullName = response.body().getFullName();
                    nameTextView.setText(fullName);
                } else {
                    // Handle error
                }
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                // Handle failure
            }
        });

        // Replace "your_order_history_endpoint" with the actual endpoint from your API
        Call<List<History>> historyCall = apiService.loadHistory();

        // Make network request asynchronously
        historyCall.enqueue(new Callback<List<History>>() {
            @Override
            public void onResponse(Call<List<History>> call, Response<List<History>> response) {
                if (response.isSuccessful()) {
                    // Assuming your OrderHistory model has appropriate getters
                    List<History> orderHistoryList = response.body();

                    // Create an adapter for your RecyclerView
                    HistoryAdapter historyAdapter = new HistoryAdapter(orderHistoryList);

                    // Set the adapter to the RecyclerView
                    orderHistoryRecyclerView.setAdapter(historyAdapter);

                    // LinearLayoutManager for vertical scrolling
                    LinearLayoutManager layoutManager = new LinearLayoutManager(UserActivity.this);
                    orderHistoryRecyclerView.setLayoutManager(layoutManager);

                } else {
                    // Handle error
                }
            }

            @Override
            public void onFailure(Call<List<History>> call, Throwable t) {
                // Handle failure
            }
        });


    }
}


