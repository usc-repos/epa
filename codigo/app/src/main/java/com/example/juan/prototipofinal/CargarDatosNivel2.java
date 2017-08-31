package com.example.juan.prototipofinal;

import java.util.ArrayList;

/**
 * Created by Juan.Cabuyales on 13/11/2016.
 */

public class CargarDatosNivel2 {


    private ArrayList<Pregunta> preguntas1;
    private ArrayList<Pregunta> preguntas2;
    private ArrayList<Pregunta> preguntas3;
    private ArrayList<Pregunta> preguntas4;

    private Actividad[] actividades;

    public CargarDatosNivel2() {
        preguntas1 = new ArrayList<>();
        preguntas2 = new ArrayList<>();
        preguntas3 = new ArrayList<>();
        preguntas4 = new ArrayList<>();
        actividades = new Actividad[4];
        cargarPreguntasActividadNivel2();

    }


    public void cargarActividades() {
        actividades[0] = new Actividad("1", "Select the correct option", preguntas1);
        actividades[1] = new Actividad("2", "Unscramble the sentence", preguntas2);
        actividades[2] = new Actividad("3", "Listening", preguntas3);
        actividades[3] = new Actividad("4", "Choose the correct option", preguntas4);
    }


    public void cargarPreguntasActividadNivel2() {
        cargarActividades();
        int i = 0;
        do {
            if (actividades[i].darTipo().equalsIgnoreCase("1")) {

            } else if (actividades[i].darTipo().equalsIgnoreCase("2")) {
                actividades[i].darPreguntas().add(new Pregunta("Is she from Cali?", 0, 0, null, null, null, null, 3, "sentenceconstruction,yesnoquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("Are they American?", 0, 0, null, null, null, null, 3, "sentenceconstruction,yesnoquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("Is English difficult?", 0, 0, null, null, null, null, 3, "sentenceconstruction,yesnoquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("Is he reading a book?", 0, 0, null, null, null, null, 3, "sentenceconstruction,yesnoquestions,presentcontinuous", 2));
                actividades[i].darPreguntas().add(new Pregunta("Are you dancing salsa?", 0, 0, null, null, null, null, 3, "sentenceconstruction,yesnoquestions,presentcontinuous", 2));
                actividades[i].darPreguntas().add(new Pregunta("Is it interesting?", 0, 0, null, null, null, null, 3, "sentenceconstruction,yesnoquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("Are they studying English?", 0, 0, null, null, null, null, 3, "sentenceconstruction,yesnoquestions,presentcontinuous", 2));
                actividades[i].darPreguntas().add(new Pregunta("Is your brother swimming?", 0, 0, null, null, null, null, 3, "sentenceconstruction,yesnoquestions,presentcontinuous", 2));
                actividades[i].darPreguntas().add(new Pregunta("Am I right?", 0, 0, null, null, null, null, 3, "sentenceconstruction,yesnoquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("Where are your books?", 0, 0, null, null, null, null, 3, "sentenceconstruction,whquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("Where is your mother from?", 0, 0, null, null, null, null, 3, "sentenceconstruction,whquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("What are your classes like?", 0, 0, null, null, null, null, 3, "sentenceconstruction,whquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("Who is your best friend?", 0, 0, null, null, null, null, 3, "sentenceconstruction,whquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("How old are you?", 0, 0, null, null, null, null, 3, "sentenceconstruction,whquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("What is your mother's first name?", 0, 0, null, null, null, null, 3, "sentenceconstruction,whquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("When is your birthday?", 0, 0, null, null, null, null, 3, "sentenceconstruction,whquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("Where is Alba traveling to?", 0, 0, null, null, null, null, 3, "sentenceconstruction,whquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("When is your English class?", 0, 0, null, null, null, null, 3, "sentenceconstruction,whquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("How is your English pronunciation improving?", 0, 0, null, null, null, null, 3, "sentenceconstruction,whquestions,presentcontinuous", 2));
            } else if (actividades[0].darTipo().equalsIgnoreCase("3")) {

            } else {
                actividades[i].darPreguntas().add(new Pregunta("She is ___", 0, 0, "English", "America", "England", "Europe", 2, "countriesandnationalities,affirmativemode", 2));
                actividades[i].darPreguntas().add(new Pregunta("They are ___", 0, 0, "Turkish", "Turkian", "Turkey", "Asia", 2, "countriesandnationalities,affirmativemode", 2));
                actividades[i].darPreguntas().add(new Pregunta("I am ___", 0, 0, "French", "France", "Francese", "Francian", 2, "countriesandnationalities,affirmativemode", 2));
                actividades[i].darPreguntas().add(new Pregunta("We are ___", 0, 0, "Lebanese", "Lebanon", "Lebanesian", "Lebanish", 2, "countriesandnationalities,affirmativemode", 2));
                actividades[i].darPreguntas().add(new Pregunta("You are ___", 0, 0, "Swiss", "Sweaden", "Switzerland", "Swissian", 2, "countriesandnationalities,affirmativemode", 2));
                actividades[i].darPreguntas().add(new Pregunta("He is ___", 0, 0, "Austrian", "Australia", "Austrich", "Austria", 2, "countriesandnationalities,affirmativemode", 2));
                actividades[i].darPreguntas().add(new Pregunta("They are ___", 0, 0, "Vietnamese", "Vietnamitan", "Vietnamite", "Vietnam", 2, "countriesandnationalities,affirmativemode", 2));
                actividades[i].darPreguntas().add(new Pregunta("We are ___", 0, 0, "Malaysian", "Malasish", "Malayan", "Malaysia", 2, "countriesandnationalities,affirmativemode", 2));
                actividades[i].darPreguntas().add(new Pregunta("She is ___", 0, 0, "Hungarian", "Hungary", "Hungarianese", "Hungarich", 2, "countriesandnationalities,affirmativemode", 2));
                actividades[i].darPreguntas().add(new Pregunta("I am ___", 0, 0, "Polish", "Poland", "Polonian", "Polonese", 2, "countriesandnationalities,affirmativemode", 2));
                actividades[i].darPreguntas().add(new Pregunta("Where is ___ pen?", 0, 0, "my", "me", "mine", "minee", 1, "possessiveadjectives,whquestions", 2));
                actividades[i].darPreguntas().add(new Pregunta("___ pen is blue.", 0, 0, "Your", "Yours", "Me", "You", 1, "possessiveadjectives,affirmativemode", 2));
                actividades[i].darPreguntas().add(new Pregunta(" ___ bag is black.", 0, 0, "Her", "She", "Me", "Your", 1, "possessiveadjectives,affirmativemode", 2));
                actividades[i].darPreguntas().add(new Pregunta("___ teacher is nice", 0, 0, "Our", "Me", "She", "Ours", 1, "possessiveadjectives,affirmativemode,identifyingpluralforms", 2));
                actividades[i].darPreguntas().add(new Pregunta("I have a dog. ___ name is Rocky.", 0, 0, "Its", "It's", "Me", "Mine", 1, "possessiveadjectives,affirmativemode", 2));
                actividades[i].darPreguntas().add(new Pregunta("Is this___ dog?", 0, 0, "your", "you", "we", "yours", 1, "possessiveadjectives,yesnoquestions", 2));
                actividades[i].darPreguntas().add(new Pregunta("Is this___ classroom?", 0, 0, "our", "you", "ours", "mine", 1, "possessiveadjectives,yesnoquestions", 2));
                actividades[i].darPreguntas().add(new Pregunta("Is this___ house?", 0, 0, "your", "yours", "me", "you", 1, "possessiveadjectives,yesnoquestions", 2));
                actividades[i].darPreguntas().add(new Pregunta("Is that___ pen?", 0, 0, "my", "mine", "me", "minee", 1, "possessiveadjectives,yesnoquestions", 2));
                actividades[i].darPreguntas().add(new Pregunta("Is that___ friend?", 0, 0, "our", "we", "you", "ours", 1, "possessiveadjectives,yesnoquestions", 2));
                actividades[i].darPreguntas().add(new Pregunta("___ she sleeping?", 0, 0, "Is", "Its", "It's", "Not is", 1, "conjugationoftheverbtobe,yesnoquestions,presentcontinuous", 2));
                actividades[i].darPreguntas().add(new Pregunta("___ they in class?", 0, 0, "Are", "Is", "It's", "Not are", 1, "conjugationoftheverbtobe,yesnoquestions,identifyingpluralforms,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("___ you smart?", 0, 0, "Are", "Not are", "Isn't", "Is", 1, "conjugationoftheverbtobe,yesnoquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("___ it great?", 0, 0, "Is", "Not is", "Be", "Are", 1, "conjugationoftheverbtobe,yesnoquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("___ you carpenters?", 0, 0, "Are", "is", "It's", "Am", 1, "conjugationoftheverbtobe,yesnoquestions,identifyingpluralforms,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("___ she your sister?", 0, 0, "Is", "It's", "Am", "Are", 1, "conjugationoftheverbtobe,yesnoquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("I___ working at the office", 0, 0, "Am", "Is", "It's", "Are", 1, "conjugationoftheverbtobe,affirmativemode,presentcontinuous", 2));
                actividades[i].darPreguntas().add(new Pregunta("What ___ on my desk?", 0, 0, "Is", "It", "It's", "Is it", 1, "conjugationoftheverbtobe,whquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("Where ___ it?", 0, 0, "Is", "It", "Isn't", "It's", 1, "conjugationoftheverbtobe,whquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("Where ___ they going?", 0, 0, "Are", "It", "Aren't", "Is", 1, "conjugationoftheverbtobe,whquestions,identifyingpluralforms,presentcontinuous", 2));
                actividades[i].darPreguntas().add(new Pregunta("Who ___ it?", 0, 0, "Is", "It's", "Am", "Are", 1, "conjugationoftheverbtobe,whquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("Where ___ you living?", 0, 0, "Are", "Aren't", "Am", "Is", 1, "conjugationoftheverbtobe,whquestions,presentcontinuous", 2));
                actividades[i].darPreguntas().add(new Pregunta("Where ___the teacher?", 0, 0, "Is", "It's", "Am", "Are", 1, "conjugationoftheverbtobe,whquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("Tim ___ tall.", 0, 0, "Is", "Are", "Am", "Not is", 1, "conjugationoftheverbtobe,affirmativemode,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("Helena ___ ten.", 0, 0, "Is", "Are", "It's", "Has", 1, "conjugationoftheverbtobe,affirmativemode,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("They ___ four years old.", 0, 0, "Are", "Have", "It", "Is", 1, "conjugationoftheverbtobe,affirmativemode,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("Where ___ the flowers?", 0, 0, "Are", "Aren't", "Am", "Is", 1, "conjugationoftheverbtobe,whquestions,identifyingpluralforms,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("___ he your brother?", 0, 0, "Is", "Not is", "It's", "Are", 1, "conjugationoftheverbtobe,yesnoquestions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta(" I ___ short .", 0, 0, "Am", "Is", "Are", "It's", 1, "conjugationoftheverbtobe,affirmativemode,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("It is___.", 0, 0, "Moroccan", "Morokish", "Morokian", "Moorokian", 1, "countriesandnationalities,", 2));
                actividades[i].darPreguntas().add(new Pregunta("Chile is in ___.", 0, 0, "South America", "Africa", "Central America", "Europe", 1, "countriesandnationalities,", 2));
                actividades[i].darPreguntas().add(new Pregunta("India is in ___.", 0, 0, "Asia", "America", "Europe", "Africa", 1, "countriesandnationalities,", 2));
                actividades[i].darPreguntas().add(new Pregunta("Italy is in ___.", 0, 0, "Europe", "Asia", "America", "Africa", 1, "countriesandnationalities,", 2));
                actividades[i].darPreguntas().add(new Pregunta("Vienna  is the capital of ___.", 0, 0, "Austria", "Norway", "Asia", "Australia", 1, "countriesandnationalities,", 2));
                actividades[i].darPreguntas().add(new Pregunta("Canberra  is the capital of ___.", 0, 0, "Australia", "Austria", "Europe", "Zealand", 1, "countriesandnationalities,", 2));
                actividades[i].darPreguntas().add(new Pregunta("Lima  is the capital of ___. ", 0, 0, "Peru", "Uruguay", "Bolivia", "Chile", 1, "countriesandnationalities,", 2));
                actividades[i].darPreguntas().add(new Pregunta("Cairo  is the capital of ___.", 0, 0, "Egypt", "Turkey", "Syria", "Lebanon", 1, "countriesandnationalities,", 2));
                actividades[i].darPreguntas().add(new Pregunta("Athens  is the capital of ___.", 0, 0, "Greece", "Turkey", "Italy", "Spain", 1, "countriesandnationalities,", 2));
                actividades[i].darPreguntas().add(new Pregunta("Bangkok is the capital of ___.", 0, 0, "Thailand", "Turkey", "Indonesia", "Malaysia", 1, "countriesandnationalities,", 2));
                actividades[i].darPreguntas().add(new Pregunta("Helsinki is the capital of ___.", 0, 0, "Finland", "Poland", "England", "Denmark", 1, "countriesandnationalities,", 2));
                actividades[i].darPreguntas().add(new Pregunta("I study ___ the morning.", 0, 0, "In", "On", "At", "It", 1, "prepositionsoftime,", 2));
                actividades[i].darPreguntas().add(new Pregunta("I sleep ___ the afternoon.", 0, 0, "In", "On", "At", "It", 1, "prepositionsoftime,", 2));
                actividades[i].darPreguntas().add(new Pregunta("I work ___ night.", 0, 0, "At", "On", "In", "It", 1, "prepositionsoftime,", 2));
                actividades[i].darPreguntas().add(new Pregunta("I play ___ 5:00 P.M.", 0, 0, "At", "On", "In", "It", 1, "prepositionsoftime,", 2));
                actividades[i].darPreguntas().add(new Pregunta("I am ___ the office.", 0, 0, "In", "On", "At", "It", 1, "prepositionsofplace,", 2));
                actividades[i].darPreguntas().add(new Pregunta("The plural of kiss is ___.", 0, 0, "kisses", "kisss", "kissed", "kiss", 1, "pluralforms,", 2));
                actividades[i].darPreguntas().add(new Pregunta("The plural of woman is ___.", 0, 0, "women", "woman's", "woman", "womans", 1, "pluralforms,", 2));
                actividades[i].darPreguntas().add(new Pregunta("The plural of man is ___.", 0, 0, "men's", "men", "man", "mans", 1, "pluralforms,", 2));
                actividades[i].darPreguntas().add(new Pregunta("The plural of person is ___.", 0, 0, "people", "peoples", "person", "persons", 1, "pluralforms,", 2));
                actividades[i].darPreguntas().add(new Pregunta("My name is Bob, (Bob) ___ have a girlfriend. Her name is Ashley", 0, 0, "I", "You", "He", "She", 1, "correctuseofpronouns,", 2));
                actividades[i].darPreguntas().add(new Pregunta("(Peter) ___ has a little cat.", 0, 0, "He", "You", "I", "She", 1, "correctuseofpronouns,", 2));
                actividades[i].darPreguntas().add(new Pregunta("My aunt lives in Miami. (My uncle) ___ visits us frequently.", 0, 0, "She", "You", "He", "We", 1, "correctuseofpronouns,", 2));
                actividades[i].darPreguntas().add(new Pregunta("(My uncle and I) ___ love to go out and eat pizza.", 0, 0, "We", "You", "He", "She", 1, "correctuseofpronouns,identifyingpluralforms", 2));
                actividades[i].darPreguntas().add(new Pregunta("Tomas and his sister ___ students in U.S.C.", 0, 0, "Are", "Isn't", "Is", "They're", 1, "identifyingpluralforms,conjugation", 2));
                actividades[i].darPreguntas().add(new Pregunta("My brothers ___ here now, they went to the cinema.", 0, 0, "Aren't", "Are", "Is", "They're", 1, "identifyingpluralforms,negativemode,conjugation", 2));
                actividades[i].darPreguntas().add(new Pregunta("My mother ___ in the bedroom, but she’s asleep.", 0, 0, "Is", "Are", "Is", "Isn't", 1, "conjugation,", 2));
                actividades[i].darPreguntas().add(new Pregunta("You and I ___ good friends.", 0, 0, "Are", "Am", "Is", "They're", 1, "conjugation,identifyingpluralforms", 2));
                actividades[i].darPreguntas().add(new Pregunta("The glasses ___ on the table, They’re in your purse.", 0, 0, "Aren't", "Are", "Is", "They're", 1, "identifyingpluralforms,negativemode,conjugation", 2));
                actividades[i].darPreguntas().add(new Pregunta("I think I know you, ___ name is Rachel, isn’t it?", 0, 0, "Your", "His", "My", "Her", 1, "possessiveadjectives,", 2));
                actividades[i].darPreguntas().add(new Pregunta("Eduardo has a girlfriend, ___ name is Angela.", 0, 0, "His", "My", "Your", "Her", 1, "possessiveadjectives,", 2));
                actividades[i].darPreguntas().add(new Pregunta("I’m a fan of Shakira, ___ last name is Mebarak.", 0, 0, "Her", "His", "Your", "My", 1, "possessiveadjectives,", 2));
                actividades[i].darPreguntas().add(new Pregunta("My cousin never ___ meat. She’s a vegetarian.", 0, 0, "eats", "eat", "eating", "ate", 1, "conjugation,presentsimple,thirdpersonconjugation", 2));
                actividades[i].darPreguntas().add(new Pregunta("The new airport ___ a modern train system to connect each building.", 0, 0, "Has", "Have", "Use", "Gets", 1, "conjugation,thirdpersonconjugation,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("Let’s go to Unicentro and ___ a nice movie.", 0, 0, "watch", "watches", "watching", "watched", 1, "conjugation,identifyingpluralforms,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("Does ___ MIO route stop near the U.S.C?", 0, 0, "Your", "You're", "My", "Mine", 1, "possessiveadjectives,", 2));
                actividades[i].darPreguntas().add(new Pregunta("___ an intelligent person.", 0, 0, "You're", "Your", "My", "Mine", 1, "correctuseofpronouns,", 2));
                actividades[i].darPreguntas().add(new Pregunta("___ quiz is almost finished.", 0, 0, "Your", "Your", "You're", "Mine", 1, "possessiveadjectives,", 2));
                actividades[i].darPreguntas().add(new Pregunta("Have you told ___ friends about the new discotheque?", 0, 0, "Your", "You're", "My", "Mine", 1, "possessiveadjectives,", 2));
                actividades[i].darPreguntas().add(new Pregunta("Where did you buy ___ sweater you're wearing?", 0, 0, "That", "This", "Those", "These", 1, "demonstratives,", 2));
                actividades[i].darPreguntas().add(new Pregunta("Waiter, ___ cookies taste funny.", 0, 0, "These", "Those", "This", "That", 1, "demonstratives,identifyingpluralforms", 2));
                actividades[i].darPreguntas().add(new Pregunta("___ house is old but that one on the other side of the street is quite new.", 0, 0, "This", "That", "These", "Those", 1, "demonstratives,", 2));
                actividades[i].darPreguntas().add(new Pregunta("If ___ kid doesn't stop screaming, I'm going to another restaurant now!", 0, 0, "That", "This", "Those", "These", 1, "demonstratives,", 2));
                actividades[i].darPreguntas().add(new Pregunta("I wish ___ students from the next classroom would stop talking so loudly.", 0, 0, "Those", "These", "This", "That", 1, "demonstratives,identifyingpluralforms", 2));
                actividades[i].darPreguntas().add(new Pregunta("Look at ___ earrings I'm wearing. I bought them in Jardín Plaza.", 0, 0, "These", "Those", "This", "That", 1, "demonstratives,identifyingpluralforms", 2));
                actividades[i].darPreguntas().add(new Pregunta("Steve is ___ boy at the back of the class.", 0, 0, "That", "This", "Those", "These", 1, "demonstratives,", 2));
                actividades[i].darPreguntas().add(new Pregunta("Don't do it like that. Do it like ___.", 0, 0, "This", "That", "These", "Those", 1, "demonstratives,", 2));
                actividades[i].darPreguntas().add(new Pregunta("What ___ his first and last names?", 0, 0, "Are", "Is", "Isn't", "Aren't", 1, "questions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("Where ___ Diego from?", 0, 0, "Is", "Are", "Am", "Aren't", 1, "questions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("What ___ your girlfriend like?", 0, 0, "Is", "Does", "Are", "Doesn't", 1, "questions,presentsimple", 2));
                actividades[i].darPreguntas().add(new Pregunta("It’s cold tonight ___ I never wear a sweater or a jacket.", 0, 0, "But", "And", "", "", 1, "conjunctionsandbut,", 2));
                actividades[i].darPreguntas().add(new Pregunta("There’s a TV at home ___ the antenna seems to be broken.", 0, 0, "But", "And", "", "", 1, "conjunctionsandbut,", 2));
                actividades[i].darPreguntas().add(new Pregunta("I have a new movie ___ I think it’s a pirate copy.", 0, 0, "But", "And", "", "", 1, "conjunctionsandbut,", 2));
                actividades[i].darPreguntas().add(new Pregunta("Look at this video, the images are all blurry ___ the sound isn’t good either.", 0, 0, "And", "But", "", "", 1, "conjunctionsandbut,", 2));
                actividades[i].darPreguntas().add(new Pregunta("The swimming pool looks perfectly clean ___ it’s under maintenance.", 0, 0, "But", "And", "", "", 1, "conjunctionsandbut,", 2));
                actividades[i].darPreguntas().add(new Pregunta("That person over there looks suspicious ___ I think he’s not a thief.", 0, 0, "But", "And", "", "", 1, "conjunctionsandbut,", 2));
                actividades[i].darPreguntas().add(new Pregunta("It’s cold ___ I never wear a jacket, I don’t like to carry extra clothes.", 0, 0, "But", "And", "", "", 1, "conjunctionsandbut,", 2));
                actividades[i].darPreguntas().add(new Pregunta("I don’t smoke ___ I never drink alcoholic beverages.", 0, 0, "And", "But", "", "", 1, "conjunctionsandbut,", 2));
                actividades[i].darPreguntas().add(new Pregunta("Pedro wants to see the soccer game ___ Flora is already watching it.", 0, 0, "And", "But", "", "", 1, "conjunctionsandbut,", 2));
                actividades[i].darPreguntas().add(new Pregunta("The lake is beautiful ___ there are crocodiles in there. We can’t swim.", 0, 0, "But", "And", "", "", 1, "conjunctionsandbut,", 2));
            }
            i++;
        } while (i < actividades.length);
    }


    public Actividad[] darActividadesNivel2() {
        return actividades;
    }


}
