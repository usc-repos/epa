package com.example.juan.prototipofinal;

import java.util.ArrayList;

/**
 * Created by CODESA on 15/11/2016.
 */

public class CargarDatosNivel5
{
    private ArrayList<Pregunta> preguntas1;
    private ArrayList<Pregunta> preguntas2;
    private ArrayList<Pregunta> preguntas3;
    private ArrayList<Pregunta> preguntas4;

    private Actividad[] actividades;


    public CargarDatosNivel5() {
        preguntas1 = new ArrayList<>();
        preguntas2 = new ArrayList<>();
        preguntas3 = new ArrayList<>();
        preguntas4 = new ArrayList<>();
        actividades = new Actividad[4];
        cargarPreguntasActividadNivel5();

    }


    public void cargaractividades() {
        actividades[0] = new Actividad("1", "Select the correct option", preguntas1);
        actividades[1] = new Actividad("2", "Unscramble the sentence", preguntas2);
        actividades[2] = new Actividad("3", "Listening", preguntas3);
        actividades[3] = new Actividad("4", "Choose the correct option", preguntas4);
    }

    public void cargarPreguntasActividadNivel5() {
        cargaractividades();
        int i = 0;
        do {
            if (actividades[i].darTipo().equalsIgnoreCase("1"))
            {

            }
            else if (actividades[i].darTipo().equalsIgnoreCase("2"))
            {
                actividades[i].darPreguntas().add(new Pregunta ("Do you work for an international company?",0,0,"","","","",3,"sentenceconstruction,",1));
                actividades[i].darPreguntas().add(new Pregunta ("Do you clean your house everyday?",0,0,"","","","",3,"sentenceconstruction,",1));
                actividades[i].darPreguntas().add(new Pregunta ("Is Clara graduating son from college?",0,0,"","","","",3,"sentenceconstruction,",1));
                actividades[i].darPreguntas().add(new Pregunta ("Where do your grandparents live?",0,0,"","","","",3,"sentenceconstruction,",1));
            }
            else if (actividades[i].darTipo().equalsIgnoreCase("3"))
            {

            }
            else
            {
                actividades[i].darPreguntas().add(new Pregunta ("A salesperson works in a store.",0,0," salesperson"," waiter","chef","pilot",2,"jobs,",1));
                actividades[i].darPreguntas().add(new Pregunta ("A nurse works in a hospital, but he/she isn’t a doctor",0,0," nurse"," waiter","chef","pilot",2,"jobs,",1));
                actividades[i].darPreguntas().add(new Pregunta ("A flight attendant works for an airline, but he/she isn’t a pilot",0,0," flight attendant"," salesperson"," waiter"," chef",2,"jobs,",1));
                actividades[i].darPreguntas().add(new Pregunta ("A waitress works in a restaurant, but he/she doesn’t cook",0,0," waitress"," lawyer"," dentist"," cook",2,"jobs,",1));
                actividades[i].darPreguntas().add(new Pregunta ("A guide takes people on tours.",0,0, "guide"," fisherman"," fire fighter"," waitress",2,"jobs,",1));
                actividades[i].darPreguntas().add(new Pregunta ("A receptionist answers calls",0,0 ," receptionist"," pharmacist"," assistant"," cowboy",2,"jobs,",1));
                actividades[i].darPreguntas().add(new Pregunta ("A police officer patrols the city.",0,0 ,"police officer"," manager"," photographer"," cashier",2,"jobs,",1));
                actividades[i].darPreguntas().add(new Pregunta ("A lumberjack fells trees and transports the timber to a mill.",0,0," lumberjack"," carpenter"," guide"," cowboy",2,"jobs,",1));
                actividades[i].darPreguntas().add(new Pregunta ("A cowboy herds and tends cattle on a ranch",0,0," cowboy"," carpenter","singer"," lawyer",2,"jobs,",1));
                actividades[i].darPreguntas().add(new Pregunta ("An architect designs and builds projects.",0,0," architect"," web designer"," painter","artist",2,"jobs,",1));
                actividades[i].darPreguntas().add(new Pregunta ("A dancer works for the Postal Service mailroom clerk",0,0," dancer","server"," word processor"," waitress",2,"jobs,",1));
                actividades[i].darPreguntas().add(new Pregunta ("A cashier works at a cash register.",0,0," cashier"," baker"," cook"," office manager",2,"jobs,",1));
                actividades[i].darPreguntas().add(new Pregunta ("A disc jockey introduces and plays recorded songs for an audience.",0,0,"disc jockey","singer"," cook"," musician",2,"jobs,",1));
                actividades[i].darPreguntas().add(new Pregunta ("A personal shopper helps other people buy clothes.",0,0," personal shopper"," office manager"," fire fighter"," musician",2,"jobs,",1));
                actividades[i].darPreguntas().add(new Pregunta ("My father’s son is my brother grandfather",0,0,"brother grandfather"," fire fighter"," uncle"," sister",2,"family,",1));
                actividades[i].darPreguntas().add(new Pregunta ("My father’s brother is my uncle",0,0," uncle"," brother"," aunt"," grandfather",2,"family,",1));
                actividades[i].darPreguntas().add(new Pregunta ("My mother’s sister is my aunt",0,0," aunt"," grandmother"," sister -in-law"," uncle",2,"family,",1));
                actividades[i].darPreguntas().add(new Pregunta ("My brother’s wife is my sister-in-law",0,0," sister-in-law"," niece"," grandmother"," aunt",2,"family,",1));
                actividades[i].darPreguntas().add(new Pregunta ("My sister’s daughter  is my niece.",0,0," niece"," aunt"," cousin"," nephew",2,"family,",1));

            }
            i++;
        } while (i < actividades.length);

    }
    public Actividad[] darActividadesNivel5() {
        return actividades;
    }
}
