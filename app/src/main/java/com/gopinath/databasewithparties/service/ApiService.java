package com.gopinath.databasewithparties.service;

import com.google.gson.annotations.SerializedName;
import com.gopinath.databasewithparties.model.Student;

import java.util.List;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by gopinath on 09/06/17.
 */

public interface ApiService {

    @FormUrlEncoded
    @POST("insertion.php")
    Call<Student> insertStudentInfo(@Field("id")int id,@Field("name")String name, @Field("address") String address);

@GET("/retrieve.php")
Call<List<Student>> getPeopleDetails();


}
