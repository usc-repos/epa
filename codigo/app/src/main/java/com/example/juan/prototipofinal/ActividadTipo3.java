package com.example.juan.prototipofinal;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActividadTipo3 extends AppCompatActivity implements View.OnClickListener {
    CargarDatosPreguntas puente= new CargarDatosPreguntas();
    Actividad [] actividades3=puente.darActividades();
    ArrayList numerosGenerados = new ArrayList();

    int numeroAleatorio=0;
    int scoreActividad3=0;
    String tagsActividad3=null;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private View poView;
    public int ESTADO = 1;
    public final static int PLAY = 1;

    ImageButton inciarReproduccion;
    Button opcion1Actividad3,opcion2Actividad3,opcion3Actividad3,opcion4Actividad3;
    TextView descripcionActividad,preguntaSonido;

    MediaPlayer sonido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_tipo3);

        SharedPreferences sharedPreferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        int valorRonda = sharedPreferences.getInt("ronda",0);

        if(valorRonda==20)
        {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("See my Score");
            alerta.setMessage("Do you want see your Score?");
            alerta.setPositiveButton("Score",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    dialog.cancel();
                    startActivity(new Intent(ActividadTipo3.this,ScoreRegister.class));
                }
            });
            alerta.setNegativeButton("Stars", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                   dialog.cancel();
                    startActivity(new Intent(ActividadTipo3.this,ScoreEstrellas.class));
                }
            });
            alerta.show();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("ronda",1);
            editor.commit();
        }
        else
        {

            SharedPreferences.Editor editor = sharedPreferences.edit();
            valorRonda+=1;
            editor.putInt("ronda",valorRonda);
            editor.commit();

        }

        inciarReproduccion = (ImageButton)findViewById(R.id.btnIniciarReproduccion);
        inciarReproduccion.setOnClickListener(this);

        opcion1Actividad3=(Button) findViewById(R.id.Opcion1Actividad3);
        opcion2Actividad3=(Button) findViewById(R.id.Opcion2Actividad3);
        opcion3Actividad3=(Button) findViewById(R.id.Opcion3Actividad3);
        opcion4Actividad3=(Button) findViewById(R.id.Opcion4Actividad3);

        opcion1Actividad3.setOnClickListener(this);
        opcion2Actividad3.setOnClickListener(this);
        opcion3Actividad3.setOnClickListener(this);
        opcion4Actividad3.setOnClickListener(this);

        descripcionActividad=(TextView) findViewById(R.id.DescripcionActividad3);
        preguntaSonido =(TextView) findViewById(R.id.preguntaSonido);
        try {
            modificarDatosSonido();
        }catch (Exception e)
        {
            startActivity(new Intent(ActividadTipo3.this,ActividadTipo1.class));
        }

 }


    protected void onPause() {

        super.onPause();
        if(sonido!=null)
        {
            sonido.release();

        }
    }

    public int darNumeroAleatorio()
    {
        try {
            int valor = actividades3[2].darPreguntas().size() + 1;
            int preguntaAleatoria = (int) (Math.random() * valor);
            if (numerosGenerados.size() < (actividades3[2].darPreguntas().size() - 0) + 1) {
                if (numerosGenerados.isEmpty()) {
                    numerosGenerados.add(preguntaAleatoria);
                    return preguntaAleatoria;
                } else {
                    if (numerosGenerados.contains(preguntaAleatoria)) {
                        return darNumeroAleatorio();
                    } else {
                        numerosGenerados.add(preguntaAleatoria);
                        return preguntaAleatoria;
                    }
                }
            } else {
                return -1;
            }
        }catch (Exception e)
        {

            return 0;
        }
    }

    public void modificarDatosSonido()
    {

            numeroAleatorio = darNumeroAleatorio();
            int[] f2 = {R.raw.sonido1, R.raw.sonido2, R.raw.sonido3, R.raw.sonido4, R.raw.sonido5, R.raw.sonido6, R.raw.sonido7, R.raw.sonido8, R.raw.sonido9, R.raw.sonido10, R.raw.sonido11, R.raw.sonido12, R.raw.sonido13, R.raw.sonido14, R.raw.sonido15,
                    R.raw.sonido16, R.raw.sonido17, R.raw.sonido18, R.raw.sonido19, R.raw.sonido20, R.raw.sonido21, R.raw.sonido22, R.raw.sonido23, R.raw.sonido24, R.raw.sonido25, R.raw.sonido26, R.raw.sonido27, R.raw.sonido28, R.raw.sonido29, R.raw.sonido30,
                    R.raw.sonido31, R.raw.sonido32, R.raw.sonido33};


            sonido = MediaPlayer.create(this, f2[actividades3[2].darPreguntas().get(numeroAleatorio).darSonido()]);
            sonido.setLooping(true);

            scoreActividad3 = actividades3[2].darPreguntas().get(numeroAleatorio).darScore();
            tagsActividad3 = actividades3[2].darPreguntas().get(numeroAleatorio).darTags();

            descripcionActividad.setText("Listening");
            preguntaSonido.setText(actividades3[2].darPreguntas().get(numeroAleatorio).darDescripcion());

            opcion1Actividad3.setText(actividades3[2].darPreguntas().get(numeroAleatorio).darOpcion3());
            opcion2Actividad3.setText(actividades3[2].darPreguntas().get(numeroAleatorio).darOpcion2());
            opcion3Actividad3.setText(actividades3[2].darPreguntas().get(numeroAleatorio).darOpcion4());
            opcion4Actividad3.setText(actividades3[2].darPreguntas().get(numeroAleatorio).darOpcion1());

    }

    private class RegistrarPuntosActividadTipo3 extends AsyncTask<Void,Void,Void>
    {
        String [] categorias = null;
        String mensajeError="";
        @Override
        protected Void doInBackground(Void... params)
        {

            Puntaje conexionBase  = new Puntaje(ActividadTipo3.this,"BaseDatosEPA",null,1);
            SQLiteDatabase bd = conexionBase.getWritableDatabase();
            categorias = tagsActividad3.split(",");
            try
            {
                if(categorias.length==1)
                {
                    String sqlConsulta = "SELECT " + categorias[0] + " FROM registroPuntaje";
                    Cursor resultado = bd.rawQuery(sqlConsulta, null);
                    if(resultado.moveToFirst())
                    {
                        int puntajeInicial1 = resultado.getInt(0);
                        int puntajeGuardar1 = puntajeInicial1 + scoreActividad3;
                        ContentValues contenedor = new ContentValues();
                        contenedor.put(categorias[0],puntajeGuardar1);
                        bd.update("registroPuntaje",contenedor,null,null);
                        resultado.close();
                        bd.close();
                    }
                    else
                    {
                        mensajeError+=sqlConsulta;
                    }
                }
                else if(categorias.length==2)
                {
                    String sqlConsulta = "SELECT " + categorias[0]+","+categorias[1]+" FROM registroPuntaje";
                    Cursor resultado = bd.rawQuery(sqlConsulta, null);
                    if(resultado.moveToFirst())
                    {
                        int puntajeInicial1 = resultado.getInt(0);
                        int puntajeInicial2 = resultado.getInt(1);
                        int puntajeGuardar1 = puntajeInicial1 + scoreActividad3;
                        int puntajeGuardar2 = puntajeInicial2+scoreActividad3;
                        ContentValues contenedor = new ContentValues();
                        contenedor.put(categorias[0],puntajeGuardar1);
                        contenedor.put(categorias[1],puntajeGuardar2);
                        bd.update("registroPuntaje",contenedor,null,null);
                        resultado.close();
                        bd.close();
                    }
                    else
                    {
                        mensajeError+=sqlConsulta;
                    }
                }
                else if(categorias.length==3)
                {
                    String sqlConsulta = "SELECT " + categorias[0]+","+categorias[1]+","+categorias[2]+" FROM registroPuntaje";
                    Cursor resultado = bd.rawQuery(sqlConsulta, null);
                    if(resultado.moveToFirst())
                    {
                        int puntajeInicial1 = resultado.getInt(0);
                        int puntajeInicial2 = resultado.getInt(1);
                        int puntajeInicial3 = resultado.getInt(2);
                        int puntajeGuardar1 = puntajeInicial1 + scoreActividad3;
                        int puntajeGuardar2 = puntajeInicial2+scoreActividad3;
                        int puntajeGuardar3= puntajeInicial3+scoreActividad3;
                        ContentValues contenedor = new ContentValues();
                        contenedor.put(categorias[0],puntajeGuardar1);
                        contenedor.put(categorias[1],puntajeGuardar2);
                        contenedor.put(categorias[2],puntajeGuardar3);
                        bd.update("registroPuntaje",contenedor,null,null);
                        resultado.close();
                        bd.close();
                    }
                    else
                    {
                        mensajeError+=sqlConsulta;
                    }
                }
                else
                {
                    String sqlConsulta = "SELECT " + categorias[0]+","+categorias[1]+","+categorias[2]+","+categorias[3]+" FROM registroPuntaje";
                    Cursor resultado = bd.rawQuery(sqlConsulta, null);
                    if(resultado.moveToFirst())
                    {
                        int puntajeInicial1 = resultado.getInt(0);
                        int puntajeInicial2 = resultado.getInt(1);
                        int puntajeInicial3 = resultado.getInt(2);
                        int puntajeInicial4 = resultado.getInt(3);
                        int puntajeGuardar1 = puntajeInicial1 + scoreActividad3;
                        int puntajeGuardar2 = puntajeInicial2+scoreActividad3;
                        int puntajeGuardar3= puntajeInicial3+scoreActividad3;
                        int puntajeGuardar4 = puntajeInicial4+scoreActividad3;
                        ContentValues contenedor = new ContentValues();
                        contenedor.put(categorias[0],puntajeGuardar1);
                        contenedor.put(categorias[1],puntajeGuardar2);
                        contenedor.put(categorias[2],puntajeGuardar3);
                        contenedor.put(categorias[3],puntajeGuardar4);
                        bd.update("registroPuntaje",contenedor,null,null);
                        resultado.close();
                        bd.close();
                    }
                    else
                    {
                        mensajeError+=sqlConsulta;
                    }
                }

            }
            catch (Exception e)
            {
                mensajeError+=e.getMessage();
            }

            return null;
        }




    }




    @Override
    public void onClick(View v)
    {

        if(v==inciarReproduccion)
        {
            switch (ESTADO)
            {
                case PLAY:
                    sonido.start();
                    sonido.setLooping(false);
            }
        }
        else if(v==opcion1Actividad3)
        {

                sonido.stop();
                layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                poView = layoutInflater.inflate(R.layout.popupincorrect, null);
                popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.showAtLocation(poView, Gravity.CENTER,0,0);

                poView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        startActivity(new Intent(ActividadTipo3.this, ActividadTipo1.class));

                        return true;
                    }
                });

        }
        else if(v==opcion2Actividad3)
        {

                sonido.stop();
                layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                poView = layoutInflater.inflate(R.layout.popupincorrect, null);
                popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.showAtLocation(poView, Gravity.CENTER,0,0);

                poView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        startActivity(new Intent(ActividadTipo3.this, ActividadTipo1.class));
                        return true;
                    }
                });


        }
        else if (v==opcion3Actividad3)
        {

                sonido.stop();
                layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                poView = layoutInflater.inflate(R.layout.popupincorrect, null);
                popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.showAtLocation(poView, Gravity.CENTER,0,0);

                poView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        startActivity(new Intent(ActividadTipo3.this, ActividadTipo1.class));
                        return true;
                    }
                });


        }
        else
        {

                sonido.stop();
                layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.showAtLocation(poView, Gravity.CENTER,0,0);

                poView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        startActivity(new Intent(ActividadTipo3.this, ActividadTipo1.class));
                        RegistrarPuntosActividadTipo3 registro = new RegistrarPuntosActividadTipo3();
                        registro.execute();
                        return true;
                    }
                });



        }
    }
}
