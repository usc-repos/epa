package com.example.juan.prototipofinal;

/**
 * Created by Juan on 27/04/2016.
 */
public class Pregunta
{

    //Atributos

    private String descripcionPregunta;
    private int imagen;
    private int sonido;
    private String opc1;
    private String opc2;
    private String opc3;
    private String opc4;
    private int score;
    private String tags;
    private int nivel;

    //Constructor

    public Pregunta(String nDes, int nImg,int nSound,String nOpcion1,String nOpcion2,String nOpcion3,String nOpcion4, int nScore, String nTags, int nNviel)
    {

        descripcionPregunta= nDes;
        imagen= nImg;
        sonido= nSound;
        opc1=nOpcion1;
        opc2=nOpcion2;
        opc3=nOpcion3;
        opc4=nOpcion4;
        score= nScore;
        tags = nTags;
        nivel = nNviel;

    }

    //Metodos de consulta

    public String darDescripcion()
    {

        return descripcionPregunta;
    }

    public int darImagen()
    {

        return imagen;
    }

    public int darSonido ()
    {

        return sonido;
    }

    public String darOpcion1()
    {

        return opc1;
    }
    public String darOpcion2()
    {

        return opc2;
    }
    public String darOpcion3()
    {

        return opc3;
    }
    public String darOpcion4()
    {

        return opc4;
    }

    public int darScore()
    {

        return score;
    }

    public String darTags()
    {

        return tags;
    }

    public int darNivel()
    {
        return nivel;
    }

}
