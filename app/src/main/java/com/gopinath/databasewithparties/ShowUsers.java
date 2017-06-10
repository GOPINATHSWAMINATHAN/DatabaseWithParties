package com.gopinath.databasewithparties;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.gopinath.databasewithparties.model.Student;
import com.gopinath.databasewithparties.service.ApiService;
import com.gopinath.databasewithparties.service.GetAPIService;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class ShowUsers extends AppCompatActivity {
    ListView lv;
    Button retrieve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_users);
        lv=(ListView)findViewById(R.id.list_view);
        retrieve=(Button)findViewById(R.id.getData);
        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPeopleDetails();
            }
        });

    }

    public void getPeopleDetails()
    {
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://192.168.1.5/retrieve.php")
                .addConverterFactory(GsonConverterFactory.create()).build();
        GetAPIService service=retrofit.create(GetAPIService.class);
        Call<List<Student>> call=service.getPeopleDetails();
        call.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Response<List<Student>> response, Retrofit retrofit) {
ArrayList al=new ArrayList();
                List<Student> studentData=new ArrayList<Student>();
                studentData=response.body();
                String details="";

                for(int i=0;i<studentData.size();i++)
                {
                    String name=studentData.get(i).getName();
                    details+="Names are : "+name+"\n";
                    al.add(name);
                }
                ArrayAdapter ad=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,al);
                lv.setAdapter(ad);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }
}