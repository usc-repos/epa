package com.example.juan.prototipofinal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreRegister extends AppCompatActivity {

    TextView txtNumero28,txtNumero29,txtNumero30,txtNumero31,txtNumero32,txtNumero33,txtNumero34,txtNumero35,txtNumero36,
            txtNumero37,txtNumero38,txtNumero39,txtNumero40,txtNumero41,txtNumero42,txtNumero43,txtNumero44,txtNumero45,
            txtNumero46,txtNumero47,txtNumero48,txtNumero49,txtNumero50,txtNumero51,txtNumero52,txtNumero53,txtNumero54,
            txtNumero55,txtNumero59;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_register);
        txtNumero28 = (TextView) findViewById(R.id.textView28);
        txtNumero29 = (TextView) findViewById(R.id.textView29);
        txtNumero30 = (TextView) findViewById(R.id.textView30);
        txtNumero31 = (TextView) findViewById(R.id.textView31);
        txtNumero32 = (TextView) findViewById(R.id.textView32);
        txtNumero33 = (TextView) findViewById(R.id.textView33);
        txtNumero34 = (TextView) findViewById(R.id.textView34);
        txtNumero35 = (TextView) findViewById(R.id.textView35);
        txtNumero36 = (TextView) findViewById(R.id.textView36);
        txtNumero37 = (TextView) findViewById(R.id.textView37);
        txtNumero38 = (TextView) findViewById(R.id.textView38);
        txtNumero39 = (TextView) findViewById(R.id.textView39);
        txtNumero40 = (TextView) findViewById(R.id.textView40);
        txtNumero41 = (TextView) findViewById(R.id.textView41);
        txtNumero42 = (TextView) findViewById(R.id.textView42);
        txtNumero43 = (TextView) findViewById(R.id.textView43);
        txtNumero44 = (TextView) findViewById(R.id.textView44);
        txtNumero45 = (TextView) findViewById(R.id.textView45);
        txtNumero46 = (TextView) findViewById(R.id.textView46);
        txtNumero47 = (TextView) findViewById(R.id.textView47);
        txtNumero48 = (TextView) findViewById(R.id.textView48);
        txtNumero49 = (TextView) findViewById(R.id.textView49);
        txtNumero50 = (TextView) findViewById(R.id.textView50);
        txtNumero51 = (TextView) findViewById(R.id.textView51);
        txtNumero52 = (TextView) findViewById(R.id.textView52);
        txtNumero53 = (TextView) findViewById(R.id.textView53);
        txtNumero54 = (TextView) findViewById(R.id.textView54);
        txtNumero55 = (TextView) findViewById(R.id.textView55);
        txtNumero59 = (TextView) findViewById(R.id.textView59);
            editarPuntaje();

 }

    public void editarPuntaje()
    {
        try
        {

            Puntaje conexionBase  = new Puntaje(ScoreRegister.this,"BaseDatosEPA",null,1);
            SQLiteDatabase bd = conexionBase.getWritableDatabase();
            String sqlPuntajeUsuario = "SELECT * FROM registroPuntaje";
            Cursor puntajes = bd.rawQuery(sqlPuntajeUsuario,null);
            if(puntajes.moveToFirst())
            {

                do
                {

                    txtNumero28.setText(String.valueOf(puntajes.getInt(2)));
                    txtNumero29.setText(String.valueOf(puntajes.getInt(3)));
                    txtNumero30.setText(String.valueOf(puntajes.getInt(4)));
                    txtNumero31.setText(String.valueOf(puntajes.getInt(5)));
                    txtNumero32.setText(String.valueOf(puntajes.getInt(6)));
                    txtNumero33.setText(String.valueOf(puntajes.getInt(7)));
                    txtNumero34.setText(String.valueOf(puntajes.getInt(8)));
                    txtNumero35.setText(String.valueOf(puntajes.getInt(9)));
                    txtNumero36.setText(String.valueOf(puntajes.getInt(10)));
                    txtNumero37.setText(String.valueOf(puntajes.getInt(11)));
                    txtNumero38.setText(String.valueOf(puntajes.getInt(12)));
                    txtNumero39.setText(String.valueOf(puntajes.getInt(13)));
                    txtNumero40.setText(String.valueOf(puntajes.getInt(14)));
                    txtNumero41.setText(String.valueOf(puntajes.getInt(15)));
                    txtNumero42.setText(String.valueOf(puntajes.getInt(16)));
                    txtNumero43.setText(String.valueOf(puntajes.getInt(17)));
                    txtNumero59.setText(String.valueOf(puntajes.getInt(18)));
                    txtNumero44.setText(String.valueOf(puntajes.getInt(19)));
                    txtNumero45.setText(String.valueOf(puntajes.getInt(20)));
                    txtNumero46.setText(String.valueOf(puntajes.getInt(21)));
                    txtNumero47.setText(String.valueOf(puntajes.getInt(22)));
                    txtNumero48.setText(String.valueOf(puntajes.getInt(23)));
                    txtNumero49.setText(String.valueOf(puntajes.getInt(24)));
                    txtNumero50.setText(String.valueOf(puntajes.getInt(25)));
                    txtNumero51.setText(String.valueOf(puntajes.getInt(26)));
                    txtNumero52.setText(String.valueOf(puntajes.getInt(27)));
                    txtNumero53.setText(String.valueOf(puntajes.getInt(28)));
                    txtNumero54.setText(String.valueOf(puntajes.getInt(29)));
                    txtNumero55.setText(String.valueOf(puntajes.getInt(30)));


               }while(puntajes.moveToNext());
            }
            else
            {
                Toast.makeText(this,"NO HAY NADA",Toast.LENGTH_LONG).show();
            }


        }catch (Exception e)
        {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == event.KEYCODE_BACK)
        {
            startActivity(new Intent(ScoreRegister.this,ActividadTipo4.class));
        }
        return super.onKeyDown(keyCode, event);
    }
}
