package com.example.juan.prototipofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by juan on 10/07/2016.
 */
public class Puntaje extends SQLiteOpenHelper
{
    public Puntaje(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

              db.execSQL("CREATE TABLE registroPuntaje (login TEXT, password TEXT,listeningSkills INTEGER,clothes INTEGER,colors INTEGER,answeringtoquestion INTEGER,animals INTEGER," +
              "places INTEGER,adjectives INTEGER,numbers INTEGER,food INTEGER,countriesandnationalities INTEGER,pluralnouns INTEGER,sports INTEGER,sentenceconstruction INTEGER,affirmativemode INTEGER," +
              "negativemode INTEGER,usingtheauxilircorrect INTEGER,correctuseofpronouns INTEGER,yesnoquestions INTEGER,whquestions INTEGER,presentsimple INTEGER,identifyingpluralforms INTEGER,presentcontinuous INTEGER,possessiveadjectives INTEGER," +
              "conjugation INTEGER,questions INTEGER,usinginfinitiveformcorrectly INTEGER,thirdpersonconjugation INTEGER,demonstratives INTEGER,conjunctionsandbut INTEGER,pluralforms INTEGER,conjugationoftheverbtobe INTEGER,usingthecorrectverb INTEGER," +
                      "prepositionsoftime INTEGER,prepositionsofplace INTEGER,jobs INTEGER,family INTEGER)");
   }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
