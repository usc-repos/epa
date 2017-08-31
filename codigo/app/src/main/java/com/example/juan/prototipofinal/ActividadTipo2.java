package com.example.juan.prototipofinal;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class ActividadTipo2 extends AppCompatActivity implements View.OnClickListener {

    TextView palabra1Actividad2, palabra2Actividad2, palabra3Actividad2, palabra4Actividad2, palabra5Actividad2, palabra6Actividad2,
            completar1Actividad2, completar2Actividad2, completar3Actividad2, completar4Actividad2, completar5Actividad2, completar6Actividad2;
    Button btnCheck;
    ArrayList numerosGenerados = new ArrayList();
    int scoreActividad2 = 0;
    int numeroAleatorio = 0;

    CargarDatosPreguntas conexion = new CargarDatosPreguntas();
    Actividad actividades2[];



    String tagsActividad2 = null;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private View poView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_tipo2);

        SharedPreferences sharedPreferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        int valorRonda = sharedPreferences.getInt("ronda", 0);

        if (valorRonda == 20) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("See my Score");
            alerta.setMessage("Do you want see your Score?");
            alerta.setPositiveButton("Score", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    startActivity(new Intent(ActividadTipo2.this, ScoreRegister.class));
                }
            });
            alerta.setNegativeButton("Stars", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    startActivity(new Intent(ActividadTipo2.this, ScoreEstrellas.class));
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


        btnCheck = (Button) findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(this);

        //Frases que se deben poner en desorden para organizar
        palabra1Actividad2 = (TextView) findViewById(R.id.palabra1Actividad2);
        palabra2Actividad2 = (TextView) findViewById(R.id.palabra2Actividad2);
        palabra3Actividad2 = (TextView) findViewById(R.id.palabra3Actividad2);
        palabra4Actividad2 = (TextView) findViewById(R.id.palabra4Actividad2);
        palabra5Actividad2 = (TextView) findViewById(R.id.palabra5Actividad2);
        palabra6Actividad2 = (TextView) findViewById(R.id.palabra6Actividad2);


        //cajas de texto para acomodar la palabra segun le usuario de la app
        completar1Actividad2 = (TextView) findViewById(R.id.espacio1Actividad2);
        completar2Actividad2 = (TextView) findViewById(R.id.espacio2Actividad2);
        completar3Actividad2 = (TextView) findViewById(R.id.espacio3Actividad2);
        completar4Actividad2 = (TextView) findViewById(R.id.espacio4Actividad2);
        completar5Actividad2 = (TextView) findViewById(R.id.espacio5Actividad2);
        completar6Actividad2 = (TextView) findViewById(R.id.espacio6Actividad2);


        palabra1Actividad2.setOnLongClickListener(longListen);
        palabra2Actividad2.setOnLongClickListener(longListen);
        palabra3Actividad2.setOnLongClickListener(longListen);
        palabra4Actividad2.setOnLongClickListener(longListen);
        palabra5Actividad2.setOnLongClickListener(longListen);
        palabra6Actividad2.setOnLongClickListener(longListen);
        completar1Actividad2.setOnDragListener(dropListener);
        completar2Actividad2.setOnDragListener(dropListener);
        completar3Actividad2.setOnDragListener(dropListener);
        completar4Actividad2.setOnDragListener(dropListener);
        completar5Actividad2.setOnDragListener(dropListener);
        completar6Actividad2.setOnDragListener(dropListener);

        palabra1Actividad2.setMovementMethod(new ScrollingMovementMethod());
        palabra2Actividad2.setMovementMethod(new ScrollingMovementMethod());
        palabra3Actividad2.setMovementMethod(new ScrollingMovementMethod());
        palabra4Actividad2.setMovementMethod(new ScrollingMovementMethod());
        palabra5Actividad2.setMovementMethod(new ScrollingMovementMethod());
        palabra6Actividad2.setMovementMethod(new ScrollingMovementMethod());

        SharedPreferences niveles = getSharedPreferences("niveles", Context.MODE_PRIVATE);
        int nivel = niveles.getInt("niveles", 0);
        if(nivel==1)
        {
            actividades2 = conexion.darActividades();
        }
        else if (nivel == 2) {
            CargarDatosNivel2 datosNivel2 = new CargarDatosNivel2();
            actividades2 = datosNivel2.darActividadesNivel2();
            Log.i("Nivel", "" + nivel);
        }
        else if(nivel==3)
        {
            CargarDatosNivel3 datosNivel3 = new CargarDatosNivel3();
            actividades2 = datosNivel3.darActividadesNivel3();
            Log.i("Nivel", "" + nivel);
        }
        else if (nivel==5)
        {
            CargarDatosNivel5 datosNivel5 = new CargarDatosNivel5();
            actividades2 = datosNivel5.darActividadesNivel5();
            Log.i("Nivel", "" + nivel);
        }
        modificarDatosActividad2();


    }

    private class RegistrarPuntosActividadTipo2 extends AsyncTask<Void, Void, Void> {
        String mensajeError = "";
        String[] categorias = null;

        @Override
        protected Void doInBackground(Void... params) {
            Puntaje conexionBase = new Puntaje(ActividadTipo2.this, "BaseDatosEPA", null, 1);
            SQLiteDatabase bd = conexionBase.getWritableDatabase();
            categorias = tagsActividad2.split(",");
            try {
                if (categorias.length == 2) {
                    String sqlConsulta = "SELECT " + categorias[0] + "," + categorias[1] + " FROM registroPuntaje";
                    Cursor resultado = bd.rawQuery(sqlConsulta, null);
                    if (resultado.moveToFirst()) {
                        int puntajeInicial1 = resultado.getInt(0);
                        int puntajeInicial2 = resultado.getInt(1);
                        int puntajeGuardar1 = puntajeInicial1 + scoreActividad2;
                        int puntajeGuardar2 = puntajeInicial2 + scoreActividad2;
                        ContentValues contenedor = new ContentValues();
                        contenedor.put(categorias[0], puntajeGuardar1);
                        contenedor.put(categorias[1], puntajeGuardar2);
                        bd.update("registroPuntaje", contenedor, null, null);
                        resultado.close();
                        bd.close();
                    }

                } else {
                    String sqlConsulta = "SELECT " + categorias[0] + "," + categorias[1] + "," + categorias[2] + " FROM registroPuntaje";
                    Cursor resultado = bd.rawQuery(sqlConsulta, null);
                    if (resultado.moveToFirst()) {
                        int puntajeInicial1 = resultado.getInt(0);
                        int puntajeInicial2 = resultado.getInt(1);
                        int puntajeIinical3 = resultado.getInt(2);
                        int puntajeGuardar1 = puntajeInicial1 + scoreActividad2;
                        int puntajeGuardar2 = puntajeInicial2 + scoreActividad2;
                        int puntajeGuardar3 = puntajeIinical3 + scoreActividad2;
                        ContentValues contenedor = new ContentValues();
                        contenedor.put(categorias[0], puntajeGuardar1);
                        contenedor.put(categorias[1], puntajeGuardar2);
                        contenedor.put(categorias[2], puntajeGuardar3);
                        bd.update("registroPuntaje", contenedor, null, null);
                        resultado.close();
                        bd.close();
                    }
                }
            } catch (Exception e) {
                mensajeError += e.getMessage();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(ActividadTipo2.this, mensajeError, Toast.LENGTH_LONG).show();
        }
    }


    public int darNumeroAleatorio() {
        try {
            int valor = actividades2[1].darPreguntas().size() + 1;
            int preguntaAleatoria = (int) (Math.random() * valor);
            if (numerosGenerados.size() < (actividades2[1].darPreguntas().size())) {
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

    public void modificarDatosActividad2() {

        numeroAleatorio = darNumeroAleatorio();
        if(numeroAleatorio>=actividades2[1].darPreguntas().size())
        {
            numeroAleatorio=darNumeroAleatorio();
        }
        else {
            String descripcion = actividades2[1].darPreguntas().get(numeroAleatorio).darDescripcion();
            scoreActividad2 = actividades2[1].darPreguntas().get(numeroAleatorio).darScore();
            tagsActividad2 = actividades2[1].darPreguntas().get(numeroAleatorio).darTags();
            String[] descomposicion = descripcion.split(" ");
            if (descomposicion.length == 3) {
                palabra1Actividad2.setText(descomposicion[1]);
                palabra2Actividad2.setText(descomposicion[0]);
                palabra3Actividad2.setText(descomposicion[2]);
                completar4Actividad2.setVisibility(View.INVISIBLE);
                completar5Actividad2.setVisibility(View.INVISIBLE);
                completar6Actividad2.setVisibility(View.INVISIBLE);
            } else if (descomposicion.length == 4) {
                palabra1Actividad2.setText(descomposicion[3]);
                palabra2Actividad2.setText(descomposicion[0]);
                palabra3Actividad2.setText(descomposicion[2]);
                palabra4Actividad2.setText(descomposicion[1]);
                completar5Actividad2.setVisibility(View.INVISIBLE);
                completar6Actividad2.setVisibility(View.INVISIBLE);
            } else if (descomposicion.length == 5) {
                palabra1Actividad2.setText(descomposicion[4]);
                palabra2Actividad2.setText(descomposicion[0]);
                palabra3Actividad2.setText(descomposicion[3]);
                palabra4Actividad2.setText(descomposicion[2]);
                palabra5Actividad2.setText(descomposicion[1]);
                completar6Actividad2.setVisibility(View.INVISIBLE);
            } else {
                palabra1Actividad2.setText(descomposicion[5]);
                palabra2Actividad2.setText(descomposicion[2]);
                palabra3Actividad2.setText(descomposicion[1]);
                palabra4Actividad2.setText(descomposicion[3]);
                palabra5Actividad2.setText(descomposicion[0]);
                palabra6Actividad2.setText(descomposicion[4]);
            }
        }


    }


    View.OnLongClickListener longListen = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            DragShadow dragShadow = new DragShadow(v);
            ClipData data = ClipData.newPlainText("", "");
            v.startDrag(data, dragShadow, v, 0);
            return false;
        }
    };

    View.OnDragListener dropListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int drapEvent = event.getAction();
            switch (drapEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    TextView objetivo = (TextView) v;
                    TextView arrastrado = (TextView) event.getLocalState();
                    objetivo.setText(arrastrado.getText());
                    break;

            }
            return true;
        }
    };

    @Override
    public void onClick(View v) {
        if (v == btnCheck) {
            SharedPreferences niveles = getSharedPreferences("niveles", Context.MODE_PRIVATE);
            if (niveles.getInt("niveles", 1) == 1) {
                String descripcionComprobar = actividades2[1].darPreguntas().get(numeroAleatorio).darDescripcion();
                String[] provisonal = descripcionComprobar.split(" ");
                if (provisonal.length == 3) {
                    String respuesta = completar1Actividad2.getText().toString() + " " + completar2Actividad2.getText().toString() + " " + completar3Actividad2.getText().toString();

                    if (descripcionComprobar.equalsIgnoreCase(respuesta)) {
                        layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                        popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                        popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                        poView.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                popupWindow.dismiss();
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo3.class));
                                RegistrarPuntosActividadTipo2 registro = new RegistrarPuntosActividadTipo2();
                                registro.execute();
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
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo3.class));
                                return true;
                            }
                        });

                    }
                } else if (provisonal.length == 4) {
                    String respuesta = completar1Actividad2.getText().toString() + " " + completar2Actividad2.getText().toString() + " " + completar3Actividad2.getText().toString() + " " + completar4Actividad2.getText().toString();

                    if (descripcionComprobar.equalsIgnoreCase(respuesta)) {
                        layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                        popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                        popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                        poView.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                popupWindow.dismiss();
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo3.class));
                                RegistrarPuntosActividadTipo2 registro = new RegistrarPuntosActividadTipo2();
                                registro.execute();
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
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo3.class));
                                return true;
                            }
                        });
                    }
                } else if (provisonal.length == 5) {
                    String respuesta = completar1Actividad2.getText().toString() + " " + completar2Actividad2.getText().toString() + " " + completar3Actividad2.getText().toString() + " " + completar4Actividad2.getText().toString() + " " + completar5Actividad2.getText().toString();

                    if (descripcionComprobar.equalsIgnoreCase(respuesta)) {
                        layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                        popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                        popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                        poView.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                popupWindow.dismiss();
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo3.class));
                                RegistrarPuntosActividadTipo2 registro = new RegistrarPuntosActividadTipo2();
                                registro.execute();
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
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo3.class));
                                return true;
                            }
                        });
                    }
                } else {
                    String respuesta = completar1Actividad2.getText().toString() + " " + completar2Actividad2.getText().toString() + " " + completar3Actividad2.getText().toString() + " " + completar4Actividad2.getText().toString() + " " + completar5Actividad2.getText().toString() + " " + completar6Actividad2.getText().toString();

                    if (descripcionComprobar.equalsIgnoreCase(respuesta)) {
                        layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                        popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                        popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                        poView.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                popupWindow.dismiss();
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo3.class));
                                RegistrarPuntosActividadTipo2 registro = new RegistrarPuntosActividadTipo2();
                                registro.execute();
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
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo3.class));
                                return true;
                            }
                        });
                    }

                }
            }
            /**
             * Validaciones para las preguntas del nivel 2
             */
            else if (niveles.getInt("niveles", 1) == 2) {
                String descripcionComprobar = actividades2[1].darPreguntas().get(numeroAleatorio).darDescripcion();
                String[] provisonal = descripcionComprobar.split(" ");
                if (provisonal.length == 3) {
                    String respuesta = completar1Actividad2.getText().toString() + " " + completar2Actividad2.getText().toString() + " " + completar3Actividad2.getText().toString();

                    if (descripcionComprobar.equalsIgnoreCase(respuesta)) {
                        layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                        popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                        popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                        poView.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                popupWindow.dismiss();
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                RegistrarPuntosActividadTipo2 registro = new RegistrarPuntosActividadTipo2();
                                registro.execute();
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
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                return true;
                            }
                        });

                    }
                } else if (provisonal.length == 4) {
                    String respuesta = completar1Actividad2.getText().toString() + " " + completar2Actividad2.getText().toString() + " " + completar3Actividad2.getText().toString() + " " + completar4Actividad2.getText().toString();

                    if (descripcionComprobar.equalsIgnoreCase(respuesta)) {
                        layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                        popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                        popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                        poView.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                popupWindow.dismiss();
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                RegistrarPuntosActividadTipo2 registro = new RegistrarPuntosActividadTipo2();
                                registro.execute();
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
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                return true;
                            }
                        });
                    }
                } else if (provisonal.length == 5) {
                    String respuesta = completar1Actividad2.getText().toString() + " " + completar2Actividad2.getText().toString() + " " + completar3Actividad2.getText().toString() + " " + completar4Actividad2.getText().toString() + " " + completar5Actividad2.getText().toString();

                    if (descripcionComprobar.equalsIgnoreCase(respuesta)) {
                        layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                        popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                        popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                        poView.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                popupWindow.dismiss();
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                RegistrarPuntosActividadTipo2 registro = new RegistrarPuntosActividadTipo2();
                                registro.execute();
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
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                return true;
                            }
                        });
                    }
                } else {
                    String respuesta = completar1Actividad2.getText().toString() + " " + completar2Actividad2.getText().toString() + " " + completar3Actividad2.getText().toString() + " " + completar4Actividad2.getText().toString() + " " + completar5Actividad2.getText().toString() + " " + completar6Actividad2.getText().toString();

                    if (descripcionComprobar.equalsIgnoreCase(respuesta)) {
                        layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                        popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                        popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                        poView.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                popupWindow.dismiss();
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                RegistrarPuntosActividadTipo2 registro = new RegistrarPuntosActividadTipo2();
                                registro.execute();
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
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                return true;
                            }
                        });
                    }
                }
            }
            else if(niveles.getInt("niveles", 1) == 3)
            {
                String descripcionComprobar = actividades2[1].darPreguntas().get(numeroAleatorio).darDescripcion();
                String[] provisonal = descripcionComprobar.split(" ");
                if (provisonal.length == 3) {
                    String respuesta = completar1Actividad2.getText().toString() + " " + completar2Actividad2.getText().toString() + " " + completar3Actividad2.getText().toString();

                    if (descripcionComprobar.equalsIgnoreCase(respuesta)) {
                        layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                        popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                        popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                        poView.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                popupWindow.dismiss();
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                RegistrarPuntosActividadTipo2 registro = new RegistrarPuntosActividadTipo2();
                                registro.execute();
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
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                return true;
                            }
                        });

                    }
                } else if (provisonal.length == 4) {
                    String respuesta = completar1Actividad2.getText().toString() + " " + completar2Actividad2.getText().toString() + " " + completar3Actividad2.getText().toString() + " " + completar4Actividad2.getText().toString();

                    if (descripcionComprobar.equalsIgnoreCase(respuesta)) {
                        layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                        popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                        popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                        poView.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                popupWindow.dismiss();
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                RegistrarPuntosActividadTipo2 registro = new RegistrarPuntosActividadTipo2();
                                registro.execute();
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
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                return true;
                            }
                        });
                    }
                } else if (provisonal.length == 5) {
                    String respuesta = completar1Actividad2.getText().toString() + " " + completar2Actividad2.getText().toString() + " " + completar3Actividad2.getText().toString() + " " + completar4Actividad2.getText().toString() + " " + completar5Actividad2.getText().toString();

                    if (descripcionComprobar.equalsIgnoreCase(respuesta)) {
                        layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                        popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                        popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                        poView.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                popupWindow.dismiss();
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                RegistrarPuntosActividadTipo2 registro = new RegistrarPuntosActividadTipo2();
                                registro.execute();
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
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                return true;
                            }
                        });
                    }
                } else {
                    String respuesta = completar1Actividad2.getText().toString() + " " + completar2Actividad2.getText().toString() + " " + completar3Actividad2.getText().toString() + " " + completar4Actividad2.getText().toString() + " " + completar5Actividad2.getText().toString() + " " + completar6Actividad2.getText().toString();

                    if (descripcionComprobar.equalsIgnoreCase(respuesta)) {
                        layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                        popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                        popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                        poView.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                popupWindow.dismiss();
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                RegistrarPuntosActividadTipo2 registro = new RegistrarPuntosActividadTipo2();
                                registro.execute();
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
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                return true;
                            }
                        });
                    }
                }
            }
            else if(niveles.getInt("niveles", 1) == 5)
            {
                String descripcionComprobar = actividades2[1].darPreguntas().get(numeroAleatorio).darDescripcion();
                String[] provisonal = descripcionComprobar.split(" ");
                if (provisonal.length == 3) {
                    String respuesta = completar1Actividad2.getText().toString() + " " + completar2Actividad2.getText().toString() + " " + completar3Actividad2.getText().toString();

                    if (descripcionComprobar.equalsIgnoreCase(respuesta)) {
                        layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                        popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                        popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                        poView.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                popupWindow.dismiss();
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                RegistrarPuntosActividadTipo2 registro = new RegistrarPuntosActividadTipo2();
                                registro.execute();
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
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                return true;
                            }
                        });

                    }
                } else if (provisonal.length == 4) {
                    String respuesta = completar1Actividad2.getText().toString() + " " + completar2Actividad2.getText().toString() + " " + completar3Actividad2.getText().toString() + " " + completar4Actividad2.getText().toString();

                    if (descripcionComprobar.equalsIgnoreCase(respuesta)) {
                        layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                        popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                        popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                        poView.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                popupWindow.dismiss();
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                RegistrarPuntosActividadTipo2 registro = new RegistrarPuntosActividadTipo2();
                                registro.execute();
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
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                return true;
                            }
                        });
                    }
                } else if (provisonal.length == 5) {
                    String respuesta = completar1Actividad2.getText().toString() + " " + completar2Actividad2.getText().toString() + " " + completar3Actividad2.getText().toString() + " " + completar4Actividad2.getText().toString() + " " + completar5Actividad2.getText().toString();

                    if (descripcionComprobar.equalsIgnoreCase(respuesta)) {
                        layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                        popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                        popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                        poView.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                popupWindow.dismiss();
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                RegistrarPuntosActividadTipo2 registro = new RegistrarPuntosActividadTipo2();
                                registro.execute();
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
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                return true;
                            }
                        });
                    }
                } else {
                    String respuesta = completar1Actividad2.getText().toString() + " " + completar2Actividad2.getText().toString() + " " + completar3Actividad2.getText().toString() + " " + completar4Actividad2.getText().toString() + " " + completar5Actividad2.getText().toString() + " " + completar6Actividad2.getText().toString();

                    if (descripcionComprobar.equalsIgnoreCase(respuesta)) {
                        layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                        popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                        popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                        poView.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                popupWindow.dismiss();
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                RegistrarPuntosActividadTipo2 registro = new RegistrarPuntosActividadTipo2();
                                registro.execute();
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
                                startActivity(new Intent(ActividadTipo2.this, ActividadTipo4.class));
                                return true;
                            }
                        });
                    }
                }
            }
        }


    }
}
