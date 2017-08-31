package com.example.juan.prototipofinal;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActividadTipo1 extends AppCompatActivity implements View.OnClickListener {

    CargarDatosPreguntas puente = new CargarDatosPreguntas();

    Actividad[] actividades1 = puente.darActividades();
    //Lista de numeros para evitar que el ramdon se repita
    ArrayList numerosGenerados = new ArrayList();


    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private View poView;
    int scorePregunta = 0;


    Button opcion1Actividad1, opcion1Actividad2, opcion1Actividad3, opcion1Actividad4;
    ImageView imagenActividadTipo1;
    TextView desripcionPregunta, actividadTipo1;
    String tags = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_tipo1);

        SharedPreferences sharedPreferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        int valorRonda = sharedPreferences.getInt("ronda", 0);

        if (valorRonda == 20) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("See my Score");
            alerta.setMessage("Do you want see your Score?" + " " + valorRonda);
            alerta.setPositiveButton("Score", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    startActivity(new Intent(ActividadTipo1.this, ScoreRegister.class));
                }
            });
            alerta.setNegativeButton("Stars", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(ActividadTipo1.this, ScoreEstrellas.class));
                    dialog.cancel();
                }
            });
            alerta.show();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("ronda", 1);
            editor.commit();
        } else {


            SharedPreferences.Editor editor = sharedPreferences.edit();
            valorRonda += 1;
            editor.putInt("ronda", valorRonda);
            editor.commit();

        }

        actividadTipo1 = (TextView) findViewById(R.id.DescripcionActividadTipo1);
        desripcionPregunta = (TextView) findViewById(R.id.PreguntaActividadTipo1);
        opcion1Actividad1 = (Button) findViewById(R.id.Opcion1ActividadTipo1);
        opcion1Actividad2 = (Button) findViewById(R.id.Opcion2ActividadTipo1);
        opcion1Actividad3 = (Button) findViewById(R.id.Opcion3ActividadTipo1);
        opcion1Actividad4 = (Button) findViewById(R.id.Opcion4ActividadTipo1);

        imagenActividadTipo1 = (ImageView) findViewById(R.id.ImagenActividadTipo1);

        opcion1Actividad1.setOnClickListener(this);
        opcion1Actividad2.setOnClickListener(this);
        opcion1Actividad3.setOnClickListener(this);
        opcion1Actividad4.setOnClickListener(this);

        try {
            cambiarValoresActividadTipo1();
        } catch (Exception e) {
            startActivity(new Intent(ActividadTipo1.this, ActividadTipo4.class));
        }

    }


    //Metodo encargado de generar los aleatorios y verificar que no se repitan

    public int darNumeroAleatorio() {
        try {
            int valor = actividades1[0].darPreguntas().size() + 1;
            int preguntaAleatoria = (int) (Math.random() * valor);
            if (numerosGenerados.size() < (actividades1[0].darPreguntas().size() - 0) + 1) {
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
        } catch (Exception e) {

            return 0;
        }
    }

    public void cambiarValoresActividadTipo1() {

        int numero = darNumeroAleatorio();
        desripcionPregunta.setText(actividades1[0].darDescripcion());
        int[] f1 = {R.mipmap.img1, R.mipmap.img2, R.mipmap.img3, R.mipmap.img4, R.mipmap.img5, R.mipmap.img6, R.mipmap.img7, R.mipmap.img8, R.mipmap.img9, R.mipmap.img10, R.mipmap.img11, R.mipmap.img12, R.mipmap.img13, R.mipmap.img14, R.mipmap.img15, R.mipmap.img16, R.mipmap.img17, R.mipmap.img18, R.mipmap.img19, R.mipmap.img2, R.mipmap.img21, R.mipmap.img22, R.mipmap.img23, R.mipmap.img24, R.mipmap.img25, R.mipmap.img26};
        opcion1Actividad1.setText(actividades1[0].darPreguntas().get(numero).darOpcion2());
        opcion1Actividad2.setText(actividades1[0].darPreguntas().get(numero).darOpcion1());
        opcion1Actividad3.setText(actividades1[0].darPreguntas().get(numero).darOpcion3());
        opcion1Actividad4.setText(actividades1[0].darPreguntas().get(numero).darOpcion4());
        desripcionPregunta.setText(actividades1[0].darPreguntas().get(numero).darDescripcion());
        imagenActividadTipo1.setImageResource(f1[actividades1[0].darPreguntas().get(numero).darImagen()]);
        tags = actividades1[0].darPreguntas().get(numero).darTags();
        scorePregunta = actividades1[0].darPreguntas().get(numero).darScore();
    }

    public void cargarPreguntasNivel2( int nivel2)
    {
        int numero = darNumeroAleatorio();
        desripcionPregunta.setText(actividades1[0].darDescripcion());
        if(actividades1[0].darPreguntas().get(numero).darNivel()==nivel2)
        {
            int[] f1 = {R.mipmap.img1, R.mipmap.img2, R.mipmap.img3, R.mipmap.img4, R.mipmap.img5, R.mipmap.img6, R.mipmap.img7, R.mipmap.img8, R.mipmap.img9, R.mipmap.img10, R.mipmap.img11, R.mipmap.img12, R.mipmap.img13, R.mipmap.img14, R.mipmap.img15, R.mipmap.img16, R.mipmap.img17, R.mipmap.img18, R.mipmap.img19, R.mipmap.img2, R.mipmap.img21, R.mipmap.img22, R.mipmap.img23, R.mipmap.img24, R.mipmap.img25, R.mipmap.img26};
            opcion1Actividad1.setText(actividades1[0].darPreguntas().get(numero).darOpcion2());
            opcion1Actividad2.setText(actividades1[0].darPreguntas().get(numero).darOpcion1());
            opcion1Actividad3.setText(actividades1[0].darPreguntas().get(numero).darOpcion3());
            opcion1Actividad4.setText(actividades1[0].darPreguntas().get(numero).darOpcion4());
            desripcionPregunta.setText(actividades1[0].darPreguntas().get(numero).darDescripcion());
            imagenActividadTipo1.setImageResource(f1[actividades1[0].darPreguntas().get(numero).darImagen()]);
            tags = actividades1[0].darPreguntas().get(numero).darTags();
            scorePregunta = actividades1[0].darPreguntas().get(numero).darScore();
        }
    }

    private class RegistrarPuntosActividadTipo1 extends AsyncTask<Void, Void, Void> {

        String mensajeError = "";
        String[] categorias = null;

        @Override
        protected Void doInBackground(Void... params) {
            Puntaje conexion = new Puntaje(ActividadTipo1.this, "BaseDatosEPA", null, 1);
            SQLiteDatabase bd = conexion.getWritableDatabase();
            categorias = tags.split(",");
            try {
                if (categorias.length == 1) {
                    String sqlConsulta = "SELECT " + categorias[0] + " FROM registroPuntaje";
                    Cursor resultado = bd.rawQuery(sqlConsulta, null);
                    if (resultado.moveToFirst()) {
                        int puntajeInicial1 = resultado.getInt(0);
                        int puntajeGuardar1 = puntajeInicial1 + scorePregunta;
                        ContentValues contenedor = new ContentValues();
                        contenedor.put(categorias[0], puntajeGuardar1);
                        bd.update("registroPuntaje", contenedor, null, null);
                        resultado.close();
                        bd.close();
                    } else {
                        mensajeError += sqlConsulta;
                    }
                } else {
                    String sqlConsulta = "SELECT " + categorias[0] + "," + categorias[1] + " FROM registroPuntaje";
                    Cursor resultado = bd.rawQuery(sqlConsulta, null);
                    if (resultado.moveToFirst()) {
                        int puntajeInicial1 = resultado.getInt(0);
                        int puntajeInicial2 = resultado.getInt(1);
                        int puntajeGuardar1 = puntajeInicial1 + scorePregunta;
                        int puntajeGuardar2 = puntajeInicial2 + scorePregunta;
                        ContentValues contenedor = new ContentValues();
                        contenedor.put(categorias[0], puntajeGuardar1);
                        contenedor.put(categorias[1], puntajeGuardar2);
                        bd.update("registroPuntaje", contenedor, null, null);
                        resultado.close();
                        bd.close();
                    } else {
                        mensajeError += sqlConsulta;
                    }
                }


            } catch (Exception e) {
                mensajeError += e.getMessage();
            }


            return null;
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
        if (v == opcion1Actividad1) {


            layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            poView = layoutInflater.inflate(R.layout.popupincorrect, null);
            popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

            poView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    popupWindow.dismiss();
                    startActivity(new Intent(ActividadTipo1.this, ActividadTipo4.class));
                    return true;
                }
            });


        } else if (v == opcion1Actividad2) {

            layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            poView = layoutInflater.inflate(R.layout.popupcorrect, null);
            popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

            poView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    popupWindow.dismiss();
                    startActivity(new Intent(ActividadTipo1.this, ActividadTipo4.class));
                    RegistrarPuntosActividadTipo1 registro = new RegistrarPuntosActividadTipo1();
                    registro.execute();
                    return true;
                }
            });


        } else if (v == opcion1Actividad3) {

            layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            poView = layoutInflater.inflate(R.layout.popupincorrect, null);
            popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

            poView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    popupWindow.dismiss();
                    startActivity(new Intent(ActividadTipo1.this, ActividadTipo4.class));
                    return true;
                }
            });

        } else {

            layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            poView = layoutInflater.inflate(R.layout.popupincorrect, null);
            popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

            poView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    popupWindow.dismiss();
                    startActivity(new Intent(ActividadTipo1.this, ActividadTipo4.class));
                    return true;
                }
            });

        }

    }
}
