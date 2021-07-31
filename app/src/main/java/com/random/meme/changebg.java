package com.random.meme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class changebg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_changebg);
     //   ImageView iv=findViewById(R.id.imageView2);



      //image2();
    }
    public void image1(View view) {
        Intent it = new Intent(getApplicationContext(), MainActivity.class);
        it.putExtra("bgid", 1);
        startActivity(it);
    }
    public void image2(View view) {
        Intent it = new Intent(getApplicationContext(), MainActivity.class);
        it.putExtra("bgid", 2);
        startActivity(it);
    }
    public void image3(View view) {
        Intent it = new Intent(getApplicationContext(), MainActivity.class);
        it.putExtra("bgid", 3);
        startActivity(it);
    }
    public void image4(View view) {
        Intent it = new Intent(getApplicationContext(), MainActivity.class);
        it.putExtra("bgid", 4);
        startActivity(it);
    }

    public void image5(View view) {
        Intent it = new Intent(getApplicationContext(), MainActivity.class);
        it.putExtra("bgid", 5);
        startActivity(it);
    }
    public void image6(View view) {
        Intent it = new Intent(getApplicationContext(), MainActivity.class);
        it.putExtra("bgid", 6);
        startActivity(it);
    }
    public void image7(View view) {
        Intent it = new Intent(getApplicationContext(), MainActivity.class);
        it.putExtra("bgid", 7);
        startActivity(it);
    }

}