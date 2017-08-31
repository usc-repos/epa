package com.example.juan.prototipofinal;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;


public class Niveles extends AppCompatActivity implements View.OnClickListener {
    ImageButton level1,level2,level3,level4,level5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveles);


        level1= (ImageButton) findViewById(R.id.imgNivel1);
        level2= (ImageButton) findViewById(R.id.imgNivel2);
        level3= (ImageButton) findViewById(R.id.imgNivel3);
        level4= (ImageButton) findViewById(R.id.imgNivel4);
        level5= (ImageButton) findViewById(R.id.imgNivel5);

        level1.setOnClickListener(this);
        level2.setOnClickListener(this);
        level3.setOnClickListener(this);
        level4.setOnClickListener(this);
        level5.setOnClickListener(this);

    }



    @Override
    public void onClick(View v)
    {
        if(v==level1)
        {
            SharedPreferences niveles = getSharedPreferences("niveles",MODE_PRIVATE);
            SharedPreferences.Editor escribirNiveles = niveles.edit();
            escribirNiveles.putInt("niveles",1);
            escribirNiveles.commit();
            startActivity(new Intent(this,ActividadTipo1.class));

        }
        else if(v==level2)
        {
            SharedPreferences niveles = getSharedPreferences("niveles",MODE_PRIVATE);
            SharedPreferences.Editor escribirNiveles = niveles.edit();
            escribirNiveles.putInt("niveles",2);
            escribirNiveles.commit();
            startActivity(new Intent(this,ActividadTipo2.class));
        }
        else if(v==level3)
        {
            SharedPreferences niveles = getSharedPreferences("niveles",MODE_PRIVATE);
            SharedPreferences.Editor escribirNiveles = niveles.edit();
            escribirNiveles.putInt("niveles",3);
            escribirNiveles.commit();
            startActivity(new Intent(this,ActividadTipo2.class));
        }
        else if(v==level4)
        {
            SharedPreferences niveles = getSharedPreferences("niveles",MODE_PRIVATE);
            SharedPreferences.Editor escribirNiveles = niveles.edit();
            escribirNiveles.putInt("niveles",5);
            escribirNiveles.commit();
            startActivity(new Intent(this,ActividadTipo2.class));
        }
    }





    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == event.KEYCODE_BACK)
        {
            startActivity(new Intent(this,Login.class));
        }
        return super.onKeyDown(keyCode, event);
    }



}
