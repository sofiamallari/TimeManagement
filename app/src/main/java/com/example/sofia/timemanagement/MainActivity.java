package com.example.sofia.timemanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    DatabaseReference dbref;
    TextView time_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button time_in=(Button) findViewById(R.id.time_in);
        Button time_out=(Button) findViewById(R.id.time_out);
        dbref = FirebaseDatabase.getInstance().getReference("time");
        time_view=(TextView) findViewById(R.id.time_view);

        time_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                in();
            }
        });

        time_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out();
            }
        });

    }
    public void in(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dformat = new SimpleDateFormat("MM-dd-yyyy");
        SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm:ss");
        String strTime = mdformat.format(calendar.getTime());
        String strDate = dformat.format(calendar.getTime());
        if(!strTime.isEmpty()) {

            String id = dbref.push().getKey();
            Time t = new Time(id, strDate,strTime);

            dbref.child(id).setValue(t);
            Toast.makeText(this,"Added" + id ,Toast.LENGTH_LONG).show();
        }
        else{
            time_view.setText(strDate);
            Toast.makeText(this,"Not Added",Toast.LENGTH_LONG).show();
        }

    }
    public void out(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dformat = new SimpleDateFormat("MM-dd-yyyy");
        SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm:ss");
        String strTime = mdformat.format(calendar.getTime());
        String strDate = dformat.format(calendar.getTime());
        if(!strTime.isEmpty()) {

            String id = dbref.push().getKey();
            Time t = new Time(id, strDate,strTime);

            dbref.child(id).setValue(t);
            Toast.makeText(this,"Added" + id ,Toast.LENGTH_LONG).show();
        }
        else{
            time_view.setText(strDate);
            Toast.makeText(this,"Not Added",Toast.LENGTH_LONG).show();
        }

    }


}
