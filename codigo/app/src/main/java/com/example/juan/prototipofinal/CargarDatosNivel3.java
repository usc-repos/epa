package com.example.juan.prototipofinal;

/**
 * Created by CODESA on 15/11/2016.
 */

import java.util.ArrayList;



public class CargarDatosNivel3
{
    private ArrayList<Pregunta> preguntas1;
    private ArrayList<Pregunta> preguntas2;
    private ArrayList<Pregunta> preguntas3;
    private ArrayList<Pregunta> preguntas4;

    private Actividad[] actividades;


    public CargarDatosNivel3() {
        preguntas1 = new ArrayList<>();
        preguntas2 = new ArrayList<>();
        preguntas3 = new ArrayList<>();
        preguntas4 = new ArrayList<>();
        actividades = new Actividad[4];
        cargarPreguntasActividadNivel3();

    }


    public void cargaractividades() {
        actividades[0] = new Actividad("1", "Select the correct option", preguntas1);
        actividades[1] = new Actividad("2", "Unscramble the sentence", preguntas2);
        actividades[2] = new Actividad("3", "Listening", preguntas3);
        actividades[3] = new Actividad("4", "Choose the correct option", preguntas4);
    }
    public void cargarPreguntasActividadNivel3() {
        cargaractividades();
        int i = 0;
        do {
            if(actividades[i].darTipo().equalsIgnoreCase("1"))
            {

            }
            else if(actividades[i].darTipo().equalsIgnoreCase("2"))
            {
                actividades[i].darPreguntas().add(new Pregunta("He is wearing a Brown tie ",0,0,"","","","",3,"sentenceconstruction",1));
                actividades[i].darPreguntas().add(new Pregunta("We are wearing yellow shirts" ,0,0,"","","","",3,"sentenceconstruction",1));
                actividades[i].darPreguntas().add(new Pregunta("I am not wearing jeans ",0,0,"","","","",3,"sentenceconstruction",1));
                actividades[i].darPreguntas().add(new Pregunta("She is not wearing sandals",0,0,"","","","",3, "sentenceconstruction",1));
                actividades[i].darPreguntas().add(new Pregunta("Are you wearing red sneakers?",0,0,"","","","",3,"sentenceconstruction",1));
                actividades[i].darPreguntas().add(new Pregunta("Is English your second language?",0,0,"","","","",3,"sentenceconstruction",1));
                actividades[i].darPreguntas().add(new Pregunta("Are they wearing black pants?",0,0,"","","","",3,"sentenceconstruction",1));
                actividades[i].darPreguntas().add(new Pregunta("Are these your shoes?",0,0,"","","","",3,"sentenceconstruction",1));
                actividades[i].darPreguntas().add(new Pregunta("What are their names?",0,0,"","","","",3,"sentenceconstruction",1));
                actividades[i].darPreguntas().add(new Pregunta("How old is your boyfriend?",0,0,"","","","",3,"sentenceconstruction",1));
                actividades[i].darPreguntas().add(new Pregunta("How old is your girlfriend?",0,0,"","","","",3,"sentenceconstruction",1));
            }
            else if(actividades[i].darTipo().equalsIgnoreCase("3"))
            {

            }
            else
            {
                actividades[i].darPreguntas().add(new Pregunta("My mother is wearing a dress",0,0," wearing"," using "," wears"," don't wear",1, "usingthecorrectverb",1));
                actividades[i].darPreguntas().add(new Pregunta("He is  using a dictionary", 0,0,"using"," wearing"," use"," don't use",1, "usingthecorrectverb",1));
                actividades[i].darPreguntas().add(new Pregunta("We are  using an app",0,0," using"," wearing"," use"," not use",1, "usingthecorrectverb",1));
                actividades[i].darPreguntas().add(new Pregunta("We are  using the laptop",0,0," using"," wearing"," use"," not use",1, "usingthecorrectverb",1));
                actividades[i].darPreguntas().add(new Pregunta("We aren’t from Japan",0,0,"aren’t"," isn't "," to be","are",1, "usingthecorrectverb",1));
                actividades[i].darPreguntas().add(new Pregunta("Our favorite colors are blue and white",0,0," are"," is "," isn’t","it’s",1, "usingthecorrectverb",1));
                actividades[i].darPreguntas().add(new Pregunta("They  are twenty years old",0,0," are"," is "," isn't","have",1,"usingthecorrectverb",1));
                actividades[i].darPreguntas().add(new Pregunta("What color is your hat?",0,0,"is","are","it's"," does",1, "usingthecorrectverb",1));
                actividades[i].darPreguntas().add(new Pregunta("What colors are your socks?",0,0," are"," it's"," is"," do",1, "usingthecorrectverb",1));
                actividades[i].darPreguntas().add(new Pregunta("What color are your jeans?",0,0," are"," is"," it's"," do",1, "usingthecorrectverb",1));
                actividades[i].darPreguntas().add(new Pregunta("What color is your underwear?",0,0," is"," it's ","are"," do",1, "usingthecorrectverb",1));
                actividades[i].darPreguntas().add(new Pregunta("What color is Mr Valderruten’s car?",0,0," is"," are "," it's"," do",1, "usingthecorrectverb",1));
                actividades[i].darPreguntas().add(new Pregunta("What color is her skirt?",0,0," is"," are"," it's", "its",1,"usingthecorrectverb",1));
                actividades[i].darPreguntas().add(new Pregunta("What color is his glasses?",0,0," are"," are"," it's", "its",1, "usingthecorrectverb",1));
                actividades[i].darPreguntas().add(new Pregunta("Dresses are for women.?",0,0," are"," is"," have"," do",1, "usingthecorrectverb",1));
                actividades[i].darPreguntas().add(new Pregunta("Suits are for men and  women",0,0," are"," is"," it's"," do",1, "usingthecorrectverb",1));
                actividades[i].darPreguntas().add(new Pregunta("Gloves are for men and  women",0,0,"are","is"," its"," have",1, "usingthecorrectverb",1));
                actividades[i].darPreguntas().add(new Pregunta("Is this your jacket?",0,0," Is"," It"," It’s"," Are",1, "usingthecorrectverb",1));
                actividades[i].darPreguntas().add(new Pregunta("Is this your umbrella?",0,0," Is"," It"," It’s"," Are",1, "usingthecorrectverb",1));
                actividades[i].darPreguntas().add(new Pregunta("My mother and I have a cat",0,0," have"," has"," to have"," having",1, "conjugation",1));
                actividades[i].darPreguntas().add(new Pregunta("My sister  has a bike.",0,0," has"," have"," to have"," having",1, "conjugation",1));
                actividades[i].darPreguntas().add(new Pregunta("We want to have a laptop",0,0," to have"," have"," has"," to having",1, "conjugation",1));
                actividades[i].darPreguntas().add(new Pregunta("He has a ball",0,0," to have"," have"," has"," to having",1, "conjugation",1));
                actividades[i].darPreguntas().add(new Pregunta("They have beautiful beaches in Australia",0,0," have"," has"," to have","  having",1, "conjugation",1));
                actividades[i].darPreguntas().add(new Pregunta("She has a book",0,0," has"," have"," to have", "don’t have",1, "conjugation",1));
                actividades[i].darPreguntas().add(new Pregunta("You and I are wearing watches",0,0," are wearing"," has"," am wearing"," don't has",1, "conjugation",1));
                actividades[i].darPreguntas().add(new Pregunta("They need to have cameras",0,0," to have"," have"," has","having",1, "conjugation",1));
                actividades[i].darPreguntas().add(new Pregunta("I am carrying an umbrella",0,0," am"," have"," has"," don't has",1, "conjugation",1));
                actividades[i].darPreguntas().add(new Pregunta("My mom has a radio",0,0," has"," have"," to have"," don't has",1, "conjugation",1));
                actividades[i].darPreguntas().add(new Pregunta("We work on weekdays.",0,0,"on"," in","at","an",1, "prepositionsoftime",1));
                actividades[i].darPreguntas().add(new Pregunta("I study in the evenings",0,0," in", "on"," at","a",1, "prepositionsoftime",1));
                actividades[i].darPreguntas().add(new Pregunta("On Mondays I relax",0,0," On", "In"," At", "The",1,"prepositionsoftime",1));
                actividades[i].darPreguntas().add(new Pregunta("I work on weekends.",0,0," on", "in"," at","a",1, "prepositionsoftime",1));
                actividades[i].darPreguntas().add(new Pregunta("I finish class at 4:00 pm.",0,0," at", "in"," on","a",1, "prepositionsoftime",1));
                actividades[i].darPreguntas().add(new Pregunta("I start class at 7:00 am",0,0," at", "in"," on","an",1, "prepositionsoftime",1));
                actividades[i].darPreguntas().add(new Pregunta("Bangkok isn't  in Japan",0,0," in", "on"," at","an",1, "prepositionsofplace",1));
                actividades[i].darPreguntas().add(new Pregunta("We are at home.",0,0," at","on","in","a",1, "prepositionsofplace",1));
                actividades[i].darPreguntas().add(new Pregunta("We are  at work",0,0," at","in","on","a",1, "prepositionsofplace",1));
                actividades[i].darPreguntas().add(new Pregunta("She lives in Pasto.",0,0," in","on","at","a",1, "prepositionsofplace",1));   
                actividades[i].darPreguntas().add(new Pregunta("100",0,0," One-hundred"," One-thousand"," Ten zero", "Ten hundred",1, "numbers",1));
                actividades[i].darPreguntas().add(new Pregunta("75",0,0," Seventy-five"," Sixty-five"," Fifty-five", "Seven five",1, "numbers",1));
                actividades[i].darPreguntas().add(new Pregunta("33",0,0,"Thirty-three","Thirty","Tree","Tree hundred",1, "numbers",1));
                actividades[i].darPreguntas().add(new Pregunta("13",0,0," Thirteen"," thirty"," third-ten", "thirteen thousand",1, "numbers",1));
                actividades[i].darPreguntas().add(new Pregunta("45",0,0,"Fourty-five"," fourteen-five"," fourty-fifth","Four-five",1," Numbers",1));
                actividades[i].darPreguntas().add(new Pregunta("67",0,0,"sixty-seven","sixteen-seven","sixty-seventh","six-seven",1, "numbers",1));
                actividades[i].darPreguntas().add(new Pregunta("85",0,0," eighty-five"," eighty-fifth"," eighteen-five","",1, "numbers",1));
                actividades[i].darPreguntas().add(new Pregunta("16",0,0," sixteen"," sixty"," six-ten","ten-six",1, "numbers",1));
                actividades[i].darPreguntas().add(new Pregunta("18",0,0," eighteen"," eight-ten"," eighty","one-eight",1, "numbers",1));
                actividades[i].darPreguntas().add(new Pregunta("91",0,0," ninety-one"," ninety-first"," nineteen-one","nine-one",1, "numbers",1));
                actividades[i].darPreguntas().add(new Pregunta("63",0,0,"sixty-three","thirty-six","sixteen-three","six-three",1,"numbers",1));
                actividades[i].darPreguntas().add(new Pregunta("40",0,0," fourty"," four-ten"," fourteen","four-zero",1, "numbers",1));
                actividades[i].darPreguntas().add(new Pregunta("23",0,0," twenty-three"," thirty-tew"," thirteen","two-three",1, "numbers",1));
                actividades[i].darPreguntas().add(new Pregunta("14",0,0,"fourteen"," four-ten"," fourty","one-four",1, "numbers",1));
                actividades[i].darPreguntas().add(new Pregunta("15",0,0," fifteen"," fiftyn"," fifty","ten-five",1, "numbers",1));
                actividades[i].darPreguntas().add(new Pregunta("11",0,0," eleven"," once"," one-ten","one-one",1, "numbers",1));
                actividades[i].darPreguntas().add(new Pregunta("17",0,0," seventeen"," seven-ten"," seventy","one-seven",1, "numbers",1));
                actividades[i].darPreguntas().add(new Pregunta("80",0,0," eighty"," eighteen"," eigthty-ten","eight-zero",1, "numbers",1));
                actividades[i].darPreguntas().add(new Pregunta("19",0,0," nineteen"," nine-ten","ninety","one-nine",1, "numbers",1));
                actividades[i].darPreguntas().add(new Pregunta("Dinner is ready.Is your brother ready to eat?",0,0," Is"," Are"," Am"," Aren't",1,"conjugation",1));
                actividades[i].darPreguntas().add(new Pregunta("A: Hi, I’m Nicolas.   B: Hi, Nicolas; I’m very pleased to meet you.",0,0," I'm"," He's"," She's"," Am",1,"conjugation",1));
                actividades[i].darPreguntas().add(new Pregunta("Mauricio Macri is very proud to be the president of Argentina",0,0," to be"," he's"," is"," isn't",1,"conjugation",1));
                actividades[i].darPreguntas().add(new Pregunta("Martin isn’t happy to see that his ex-girlfriend got married",0,0," isn't"," is"," are"," he's",1,"conjugation",1));
                actividades[i].darPreguntas().add(new Pregunta("After his car accident, Bernardo is lucky to be alive.",0,0," is"," isn't"," are"," he's",1,"conjugation",1));
                actividades[i].darPreguntas().add(new Pregunta("I’m from Lima, so my nationality is Peruvian.",0,0,"my"," his"," your"," her",1,"possessiveadjectives",1));
                actividades[i].darPreguntas().add(new Pregunta("Who’s that lady next to the window? What’s her name?",0,0," her"," his"," your"," my",1,"possessiveadjectives",1));
                actividades[i].darPreguntas().add(new Pregunta("Teacher, your classes are very nice. I love to practice English with you",0,0," your"," his"," my"," her",1,"possessiveadjectives",1));
                actividades[i].darPreguntas().add(new Pregunta("Veronica is in my class, and her boyfriend Juan is also my classmate.",0,0," her"," his"," your"," my",1,"possessiveadjectives",1));
                actividades[i].darPreguntas().add(new Pregunta("Hey! Don’t watch the T.V. so close from the screen.",0,0," watch"," watches"," watching"," watched",1," conjugation",1));
                actividades[i].darPreguntas().add(new Pregunta("My friend Pablo uses his palm computer for almost everything.",0,0," uses"," use"," have"," need",1," conjugation",1));
                actividades[i].darPreguntas().add(new Pregunta("I’m sorry, the manager doesn’t come on Saturdays.",0,0," come"," use"," have"," need",1," conjugation",1));
                actividades[i].darPreguntas().add(new Pregunta("My sister has insomnia. She can’t sleep at night.",0,0," sleep"," sleeps"," sleeping"," slept",1," conjugation",1));
            }
            i++;
        }while(i<actividades.length);
    }
    public Actividad[] darActividadesNivel3() {
        return actividades;
    }
}
