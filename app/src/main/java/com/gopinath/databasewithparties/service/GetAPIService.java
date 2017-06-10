package com.gopinath.databasewithparties.service;

import com.gopinath.databasewithparties.model.Student;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by gopinath on 10/06/17.
 */

public interface GetAPIService {
    @GET("/retrieve.php")
    Call<List<Student>> getPeopleDetails();
}
