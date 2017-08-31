package com.example.juan.prototipofinal;

import java.util.ArrayList;

/**
 * Created by Juan on 27/04/2016.
 */
public class Actividad
{
    //Atributos
    //nuevo comentario
    private String tipo;
    private String descripcion;
    private ArrayList<Pregunta> preguntas;

    public Actividad(String nTipo, String nDes, ArrayList<Pregunta> nPreguntas)
    {
        tipo = nTipo;
        descripcion= nDes;
        preguntas = nPreguntas == null ? new ArrayList<Pregunta>() : nPreguntas;
    }

    //metodos de consulta

    public String darTipo()
    {
        return tipo;
    }

    public String darDescripcion()
    {
        return descripcion;
    }

    public ArrayList<Pregunta> darPreguntas()
    {
        return preguntas;
    }

    public void setQuestions(ArrayList<Pregunta> nPreguntas)
    {
        preguntas = nPreguntas;
    }

    //Metodos de inserción de datos
}
