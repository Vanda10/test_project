package kh.edu.rupp.visitme.api;

import java.util.List;

import kh.edu.rupp.visitme.model.Profile;
import kh.edu.rupp.visitme.model.History;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("final/profile.json")
    Call<Profile> loadProfile();

    @GET("final/history.json")
    Call<List<History>> loadHistory();
}

