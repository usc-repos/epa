package com.example.juan.prototipofinal;




import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;


public class Login extends AppCompatActivity implements View.OnClickListener {



    EditText txtLogin,txtPassword;
    Button btnLogin;
    CheckBox recordar;

    private int EstadoUsuario=1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtLogin = (EditText) findViewById(R.id.txtLogin);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        recordar = (CheckBox) findViewById(R.id.checkRemember);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        SharedPreferences preferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        String nombre = preferences.getString("marcado","");
        if(nombre!="")
        {
            txtLogin.setText(nombre);
        }
 }


    private class AsignacionPuntaje extends AsyncTask<Void,Void,Void>
    {
        String nombre="";
        String clave="";
        String mensaje="";
        boolean marcado=false;
        @Override
        protected void onPreExecute()
        {
            nombre = txtLogin.getText().toString();
            clave = txtPassword.getText().toString();
            if(recordar.isChecked())
            {
                marcado =true;
            }

        }


        @Override
        protected Void doInBackground(Void... params)
        {

            try {

                ingresarUsuario();
                SharedPreferences preferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                int sumaRonda=0;
                editor.putInt("ronda",sumaRonda);
                editor.putInt("estado",EstadoUsuario);
                editor.commit();
                if(marcado==true)
                {
                    editor.putString("marcado",nombre);
                    editor.commit();
                }

            }catch (Exception e)
            {
                mensaje+= e.getMessage();
            }

            return null;
        }


    }

    public void ingresarUsuario()
    {
        EstadoUsuario =2;
        String nombre= txtLogin.getText().toString();
        String clave = txtPassword.getText().toString();
        Puntaje conexionBase  = new Puntaje(Login.this,"BaseDatosEPA",null,1);
        SQLiteDatabase bd = conexionBase.getWritableDatabase();
        String sql="INSERT INTO registroPuntaje VALUES ("+"'"+nombre+"'"+","+"'"+clave+"'"+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+","+0+")";
        bd.execSQL(sql);

    }

    public void validarUsuario()
    {
        String nombre = txtLogin.getText().toString();
        String clave = txtPassword.getText().toString();
        Puntaje conexionBase  = new Puntaje(Login.this,"BaseDatosEPA",null,1);
        SQLiteDatabase bd = conexionBase.getWritableDatabase();
        String slqValidar ="SELECT * FROM registroPuntaje WHERE login='"+nombre+"'"+"AND password ='"+clave+"'";
        Cursor resultado = bd.rawQuery(slqValidar,null);
        if(resultado.moveToFirst())
        {
            startActivity(new Intent(this,Niveles.class));
        }
        else
        {
            Toast.makeText(this,"Incorrect Login or Password",Toast.LENGTH_SHORT).show();
        }

    }

  public void onClick(View v)
    {
         if(v==btnLogin)
         {
             SharedPreferences preferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
             int estado = preferences.getInt("estado",1);
             if(estado==1)
             {
                 AsignacionPuntaje registro = new AsignacionPuntaje();
                 registro.execute();
                 startActivity(new Intent(this,Niveles.class));
             }
             else
             {
                 validarUsuario();
             }
         }
    }

}
