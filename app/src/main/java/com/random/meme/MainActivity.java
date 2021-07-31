package com.random.meme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    EditText toped,boted;
    TextView tv1,tv2;
    Button okay,save,bgimage;
    ImageView iv;
    OutputStream outputStream;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        toped=findViewById(R.id.edit1);
        boted=findViewById(R.id.edit2);
        tv1=findViewById(R.id.textView);
        tv2=findViewById(R.id.textView2);
        okay=findViewById(R.id.okbutton);
        save=findViewById(R.id.save);
        iv=findViewById(R.id.imageView);
        bgimage=findViewById(R.id.button4);
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    if(s1!=null && s2!=null) {

                    tv1.setText(toped.getText());
                    tv2.setText(boted.getText());





               // }
            }
        });

        Intent itn=getIntent();
      int x=  itn.getIntExtra("bgid",0);
        switch(x)
        {
            case 1:
                iv.setImageResource(R.drawable.success_kid);
                break;
            case 2:
                iv.setImageResource(R.drawable.meme1);
                break;
            case 3:
                iv.setImageResource(R.drawable.meme2);
                break;
            case 4:
                iv.setImageResource(R.drawable.i_normally_dont);
                break;
            case 5:
                iv.setImageResource(R.drawable.art_meme);
                break;
            case 6:
                iv.setImageResource(R.drawable.baby);
                break;
            case 7:
                iv.setImageResource(R.drawable.artmeme2);
                break;


            default:
        }


        //code to save
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File sdcard= Environment.getExternalStorageDirectory();
                File dir=new File(sdcard.getAbsolutePath()+"/MEME/");
                String fileName = String.format("%d.jpg", System.currentTimeMillis());
                dir.mkdirs();
                File img=new File(dir,fileName);
               // BitmapDrawable drawable=(BitmapDrawable) iv.getDrawable();
               // Bitmap bm=drawable.getBitmap();
            //capturing view for screenshot of the overlay portion
                View  activityView  = getWindow().getDecorView().findViewById(R.id.constraintLayout);
         Bitmap  bm= getScreenShot(activityView);
                try {
                    outputStream=new FileOutputStream(img);
                    bm.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
                    Toast.makeText(getApplicationContext(),"Meme saved!!",Toast.LENGTH_LONG);

                    outputStream.flush();
                    outputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });



        bgimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it=new Intent(getApplicationContext(),changebg.class);
                startActivity(it);
            }
        });

    }
    private Bitmap getScreenShot(View view ){

        Bitmap returnedbitmap=Bitmap.createBitmap(view.getWidth(),view.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(returnedbitmap);
        Drawable bgdrawable=view.getBackground();
        if (bgdrawable!=null){
            bgdrawable.draw(canvas);
        }
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return returnedbitmap;

    }



}