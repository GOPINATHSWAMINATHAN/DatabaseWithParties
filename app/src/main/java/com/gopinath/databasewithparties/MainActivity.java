package com.gopinath.databasewithparties;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.gopinath.databasewithparties.model.Student;
import com.gopinath.databasewithparties.service.ApiService;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

public class MainActivity extends AppCompatActivity {
    EditText one, two, three;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = (EditText) findViewById(R.id.my_id);
        two = (EditText) findViewById(R.id.name);
        three = (EditText) findViewById(R.id.address);


        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
setStudentDetails();
//                String id = one.getText().toString();
//                String name = two.getText().toString();
//                String address = three.getText().toString();
//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference myRef = database.getReference(id);
//                myRef.child("name").setValue(name);
//                myRef.child("address").setValue(address);

            }
        });
    }

    private void setStudentDetails() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.4/insertion.php")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);
        Student student = new Student();
        student.setId(Integer.parseInt(one.getText().toString()));
        student.setName(two.getText().toString());
        student.setAddress(three.getText().toString());

        Call<Student> call = service.insertStudentInfo(student.getId(), student.getName(), student.getAddress());
Toast.makeText(getApplicationContext(),"The values are"+student.getId()+" name is "+student.getName(),Toast.LENGTH_LONG).show();
    call.enqueue(new retrofit.Callback<Student>() {
        @Override
        public void onResponse(retrofit.Response<Student> response, Retrofit retrofit) {
            Toast.makeText(getApplicationContext(),"Inserted!!",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onFailure(Throwable t) {

        }
    });
    }
}
