package com.example.juan.prototipofinal;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

public class ActividadTipo4 extends AppCompatActivity implements View.OnClickListener {

    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private View poView;

    private int numero = 0;
    private int scoreActividad4 = 0;
    private String tagsActividad4 = null;

    TextView descripcionActividad4, textoActividad4;
    Button opcion1Actividad4, opcion2Actividad4, opcion3Actividad4, opcion4Actividad4;
    CargarDatosPreguntas conexion = new CargarDatosPreguntas();
    Actividad[] actividades4;
    ArrayList numerosGenerados = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_tipo4);

        SharedPreferences sharedPreferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        int valorRonda = sharedPreferences.getInt("ronda", 0);

        if (valorRonda == 20) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle("See my Score");
            alerta.setMessage("Do you want to see your Score?");
            alerta.setPositiveButton("Score", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    startActivity(new Intent(ActividadTipo4.this, ScoreRegister.class));
                }
            });
            alerta.setNegativeButton("Stars", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(ActividadTipo4.this, ScoreEstrellas.class));
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

        descripcionActividad4 = (TextView) findViewById(R.id.DescripcionActividad4);
        textoActividad4 = (TextView) findViewById(R.id.textoActividad4);

        opcion1Actividad4 = (Button) findViewById(R.id.opcion1Actividad4);
        opcion2Actividad4 = (Button) findViewById(R.id.opcion2Actividad4);
        opcion3Actividad4 = (Button) findViewById(R.id.opcion3Actividad4);
        opcion4Actividad4 = (Button) findViewById(R.id.opcion4Actividad4);

        opcion1Actividad4.setOnClickListener(this);
        opcion2Actividad4.setOnClickListener(this);
        opcion3Actividad4.setOnClickListener(this);
        opcion4Actividad4.setOnClickListener(this);

        SharedPreferences niveles = getSharedPreferences("niveles", Context.MODE_PRIVATE);
        int nivel = niveles.getInt("niveles", 0);
        if(nivel==1)
        {
            actividades4 = conexion.darActividades();
        }
       else if (nivel == 2) {
            CargarDatosNivel2 datosNivel2 = new CargarDatosNivel2();
            actividades4 = datosNivel2.darActividadesNivel2();
            Log.i("Tamaño", actividades4[3].darPreguntas().size() + "");
            Log.i("Nivel", "" + nivel);
        }
        else if(nivel==3)
        {
            CargarDatosNivel3 datosNivel3 = new CargarDatosNivel3();
            actividades4 = datosNivel3.darActividadesNivel3();
            Log.i("Tamaño", actividades4[3].darPreguntas().size() + "");
            Log.i("Nivel", "" + nivel);
        }
        else if(nivel==5)
        {
            CargarDatosNivel5 datosNivel5 = new CargarDatosNivel5();
            actividades4 = datosNivel5.darActividadesNivel5();
            Log.i("Tamaño", actividades4[3].darPreguntas().size() + "");
            Log.i("Nivel", "" + nivel);
        }

        modificacionDatosActividad4();
    }


    public int darnumero() {
        try {
            int valor = actividades4[3].darPreguntas().size();
            int preguntaAleatoria = (int) (Math.random() * valor);
            if (numerosGenerados.size() < (actividades4[3].darPreguntas().size())) {
                if (numerosGenerados.isEmpty()) {
                    numerosGenerados.add(preguntaAleatoria);
                    return preguntaAleatoria;
                } else {
                    if (numerosGenerados.contains(preguntaAleatoria)) {
                        return darnumero();
                    } else {
                        numerosGenerados.add(preguntaAleatoria);
                        return preguntaAleatoria;
                    }
                }
            } else {
                return -1;
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            return 0;
        }
    }

    public void modificacionDatosActividad4() {

        numero = darnumero();
        int tamaño = actividades4[1].darPreguntas().size();
        if(numero>=actividades4[1].darPreguntas().size())
        {
            modificacionDatosActividad4();
        }
        else {
            descripcionActividad4.setText("Choose the correct option");
            textoActividad4.setText(actividades4[3].darPreguntas().get(numero).darDescripcion());
            Log.i("desc. Pregunta", actividades4[3].darPreguntas().get(numero).darDescripcion());
            tagsActividad4 = actividades4[3].darPreguntas().get(numero).darTags();
            Log.i("Opciones Pregunta", actividades4[3].darPreguntas().get(numero).darOpcion1() + " " + actividades4[3].darPreguntas().get(numero).darOpcion2() + " "
                    + actividades4[3].darPreguntas().get(numero).darOpcion3() + " " + actividades4[3].darPreguntas().get(numero).darOpcion4());
            if (actividades4[3].darPreguntas().get(numero).darOpcion4().equalsIgnoreCase("") && actividades4[3].darPreguntas().get(numero).darOpcion3().equalsIgnoreCase("")) {
                opcion3Actividad4.setVisibility(View.INVISIBLE);
                opcion4Actividad4.setVisibility(View.INVISIBLE);
                opcion1Actividad4.setText(actividades4[3].darPreguntas().get(numero).darOpcion2());
                opcion2Actividad4.setText(actividades4[3].darPreguntas().get(numero).darOpcion1());

            } else {
                opcion1Actividad4.setText(actividades4[3].darPreguntas().get(numero).darOpcion2());
                opcion2Actividad4.setText(actividades4[3].darPreguntas().get(numero).darOpcion4());
                opcion3Actividad4.setText(actividades4[3].darPreguntas().get(numero).darOpcion1());
                opcion4Actividad4.setText(actividades4[3].darPreguntas().get(numero).darOpcion3());
                scoreActividad4 = actividades4[3].darPreguntas().get(numero).darScore();

            }
        }


    }

    private class RegistrarPuntosActividadTipo4 extends AsyncTask<Void, Void, Void> {
        String[] categorias = null;
        String mensajeError = "";


        @Override
        protected Void doInBackground(Void... params) {
            try
            {
            Puntaje conexionBase = new Puntaje(ActividadTipo4.this, "BaseDatosEPA", null, 1);
            SQLiteDatabase bd = conexionBase.getWritableDatabase();
            categorias = tagsActividad4.split(",");

                if (categorias.length == 1) {
                    String sqlConsulta = "SELECT " + categorias[0] + " FROM registroPuntaje";
                    Cursor resultado = bd.rawQuery(sqlConsulta, null);
                    if (resultado.moveToFirst()) {
                        int puntajeInicial1 = resultado.getInt(0);
                        int puntajeGuardar1 = puntajeInicial1 + scoreActividad4;
                        ContentValues contenedor = new ContentValues();
                        contenedor.put(categorias[0], puntajeGuardar1);
                        bd.update("registroPuntaje", contenedor, null, null);
                        resultado.close();
                        bd.close();
                    } else {
                        mensajeError += sqlConsulta;
                    }
                } else if (categorias.length == 2) {
                    String sqlConsulta = "SELECT " + categorias[0] + "," + categorias[1] + " FROM registroPuntaje";
                    Cursor resultado = bd.rawQuery(sqlConsulta, null);
                    if (resultado.moveToFirst()) {
                        int puntajeInicial1 = resultado.getInt(0);
                        int puntajeInicial2 = resultado.getInt(1);
                        int puntajeGuardar1 = puntajeInicial1 + scoreActividad4;
                        int puntajeGuardar2 = puntajeInicial2 + scoreActividad4;
                        ContentValues contenedor = new ContentValues();
                        contenedor.put(categorias[0], puntajeGuardar1);
                        contenedor.put(categorias[1], puntajeGuardar2);
                        bd.update("registroPuntaje", contenedor, null, null);
                        resultado.close();
                        bd.close();
                    } else {
                        mensajeError += sqlConsulta;
                    }
                } else if (categorias.length == 3) {
                    String sqlConsulta = "SELECT " + categorias[0] + "," + categorias[1] + "," + categorias[2] + " FROM registroPuntaje";
                    Cursor resultado = bd.rawQuery(sqlConsulta, null);
                    if (resultado.moveToFirst()) {
                        int puntajeInicial1 = resultado.getInt(0);
                        int puntajeInicial2 = resultado.getInt(1);
                        int puntajeInicial3 = resultado.getInt(2);
                        int puntajeGuardar1 = puntajeInicial1 + scoreActividad4;
                        int puntajeGuardar2 = puntajeInicial2 + scoreActividad4;
                        int puntajeGuardar3 = puntajeInicial3 + scoreActividad4;
                        ContentValues contenedor = new ContentValues();
                        contenedor.put(categorias[0], puntajeGuardar1);
                        contenedor.put(categorias[1], puntajeGuardar2);
                        contenedor.put(categorias[2], puntajeGuardar3);
                        bd.update("registroPuntaje", contenedor, null, null);
                        resultado.close();
                        bd.close();
                    } else {
                        mensajeError += sqlConsulta;
                    }
                } else {
                    String sqlConsulta = "SELECT " + categorias[0] + "," + categorias[1] + "," + categorias[2] + "," + categorias[3] + " FROM registroPuntaje";
                    Cursor resultado = bd.rawQuery(sqlConsulta, null);
                    if (resultado.moveToFirst()) {
                        int puntajeInicial1 = resultado.getInt(0);
                        int puntajeInicial2 = resultado.getInt(1);
                        int puntajeInicial3 = resultado.getInt(2);
                        int puntajeInicial4 = resultado.getInt(3);
                        int puntajeGuardar1 = puntajeInicial1 + scoreActividad4;
                        int puntajeGuardar2 = puntajeInicial2 + scoreActividad4;
                        int puntajeGuardar3 = puntajeInicial3 + scoreActividad4;
                        int puntajeGuardar4 = puntajeInicial4 + scoreActividad4;
                        ContentValues contenedor = new ContentValues();
                        contenedor.put(categorias[0], puntajeGuardar1);
                        contenedor.put(categorias[1], puntajeGuardar2);
                        contenedor.put(categorias[2], puntajeGuardar3);
                        contenedor.put(categorias[3], puntajeGuardar4);
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
    public void onClick(View v) {

        SharedPreferences niveles = getSharedPreferences("niveles", Context.MODE_PRIVATE);
        if (niveles.getInt("niveles", 1) == 1) {
            if (v == opcion1Actividad4) {


                layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                poView = layoutInflater.inflate(R.layout.popupincorrect, null);
                popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                poView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        startActivity(new Intent(ActividadTipo4.this, ActividadTipo2.class));
                        return true;
                    }
                });


            } else if (v == opcion2Actividad4) {
                if (actividades4[3].darPreguntas().get(numero).darOpcion3().equalsIgnoreCase("") && actividades4[3].darPreguntas().get(numero).darOpcion4().equalsIgnoreCase("")) {
                    layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                    poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                    popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);
                    poView.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            popupWindow.dismiss();
                            startActivity(new Intent(ActividadTipo4.this, ActividadTipo2.class));
                            RegistrarPuntosActividadTipo4 registro = new RegistrarPuntosActividadTipo4();
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
                            startActivity(new Intent(ActividadTipo4.this, ActividadTipo2.class));
                            return true;
                        }
                    });
                }

            } else if (v == opcion3Actividad4) {

                layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                poView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        startActivity(new Intent(ActividadTipo4.this, ActividadTipo2.class));
                        RegistrarPuntosActividadTipo4 registro = new RegistrarPuntosActividadTipo4();
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
                        startActivity(new Intent(ActividadTipo4.this, ActividadTipo2.class));
                        return true;
                    }
                });

            }
        }
        /**
         * Validaciones para el nivel 2
         */
        else if (niveles.getInt("niveles", 1) == 2) {

            if (v == opcion1Actividad4) {

                layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                poView = layoutInflater.inflate(R.layout.popupincorrect, null);
                popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                poView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        startActivity(new Intent(ActividadTipo4.this, ActividadTipo2.class));
                        return true;
                    }
                });

            } else if (v == opcion2Actividad4) {
                if (actividades4[3].darPreguntas().get(numero).darOpcion3().equalsIgnoreCase("") && actividades4[3].darPreguntas().get(numero).darOpcion4().equalsIgnoreCase("")) {
                    layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                    poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                    popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);
                    poView.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            popupWindow.dismiss();
                            startActivity(new Intent(ActividadTipo4.this, ActividadTipo2.class));
                            RegistrarPuntosActividadTipo4 registro = new RegistrarPuntosActividadTipo4();
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
                            startActivity(new Intent(ActividadTipo4.this, ActividadTipo2.class));
                            return true;
                        }
                    });
                }

            } else if (v == opcion3Actividad4) {

                layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                poView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        startActivity(new Intent(ActividadTipo4.this, ActividadTipo2.class));
                        RegistrarPuntosActividadTipo4 registro = new RegistrarPuntosActividadTipo4();
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
                        startActivity(new Intent(ActividadTipo4.this, ActividadTipo2.class));
                        return true;
                    }
                });

            }

        }
        else if (niveles.getInt("niveles", 1) == 3) {

            if (v == opcion1Actividad4) {

                layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                poView = layoutInflater.inflate(R.layout.popupincorrect, null);
                popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                poView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        startActivity(new Intent(ActividadTipo4.this, ActividadTipo2.class));
                        return true;
                    }
                });

            } else if (v == opcion2Actividad4) {
                if (actividades4[3].darPreguntas().get(numero).darOpcion3().equalsIgnoreCase("") && actividades4[3].darPreguntas().get(numero).darOpcion4().equalsIgnoreCase("")) {
                    layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                    poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                    popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);
                    poView.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            popupWindow.dismiss();
                            startActivity(new Intent(ActividadTipo4.this, ActividadTipo2.class));
                            RegistrarPuntosActividadTipo4 registro = new RegistrarPuntosActividadTipo4();
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
                            startActivity(new Intent(ActividadTipo4.this, ActividadTipo2.class));
                            return true;
                        }
                    });
                }

            } else if (v == opcion3Actividad4) {

                layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                poView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        startActivity(new Intent(ActividadTipo4.this, ActividadTipo2.class));
                        RegistrarPuntosActividadTipo4 registro = new RegistrarPuntosActividadTipo4();
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
                        startActivity(new Intent(ActividadTipo4.this, ActividadTipo2.class));
                        return true;
                    }
                });

            }

        }
        else if (niveles.getInt("niveles", 1) == 5) {

            if (v == opcion1Actividad4) {

                layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                poView = layoutInflater.inflate(R.layout.popupincorrect, null);
                popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                poView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        startActivity(new Intent(ActividadTipo4.this, ActividadTipo2.class));
                        return true;
                    }
                });

            } else if (v == opcion2Actividad4) {
                if (actividades4[3].darPreguntas().get(numero).darOpcion3().equalsIgnoreCase("") && actividades4[3].darPreguntas().get(numero).darOpcion4().equalsIgnoreCase("")) {
                    layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                    poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                    popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);
                    poView.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            popupWindow.dismiss();
                            startActivity(new Intent(ActividadTipo4.this, ActividadTipo2.class));
                            RegistrarPuntosActividadTipo4 registro = new RegistrarPuntosActividadTipo4();
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
                            startActivity(new Intent(ActividadTipo4.this, ActividadTipo2.class));
                            return true;
                        }
                    });
                }

            } else if (v == opcion3Actividad4) {

                layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                poView = layoutInflater.inflate(R.layout.popupcorrect, null);
                popupWindow = new PopupWindow(poView, RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.showAtLocation(poView, Gravity.CENTER, 0, 0);

                poView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        startActivity(new Intent(ActividadTipo4.this, ActividadTipo2.class));
                        RegistrarPuntosActividadTipo4 registro = new RegistrarPuntosActividadTipo4();
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
                        startActivity(new Intent(ActividadTipo4.this, ActividadTipo2.class));
                        return true;
                    }
                });

            }

        }
    }
}


