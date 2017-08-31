package com.example.juan.prototipofinal;

import android.app.Activity;
import android.content.SharedPreferences;

import java.util.ArrayList;

/**
 * Created by juan on 31/07/2016.
 */
public class CargarDatosPreguntas
{
    


    private ArrayList<Pregunta> preguntas1;
    private ArrayList<Pregunta> preguntas2;
    private ArrayList<Pregunta> preguntas3;
    private ArrayList<Pregunta> preguntas4;

    private Actividad [] actividades;

    public CargarDatosPreguntas()
    {
        preguntas1 = new ArrayList<>();
        preguntas2 = new ArrayList<>();
        preguntas3 = new ArrayList<>();
        preguntas4=  new ArrayList<>();
        actividades = new Actividad [4];
        cargarPreguntasActividad();

    }
    
    

public Actividad [] darActividades()
{
    return actividades;
}

    public void cargarActividades()
    {
        actividades[0] = new Actividad("1", "Select the correct option", preguntas1);
        actividades[1] = new Actividad("2", "Unscramble the sentence", preguntas2);
        actividades[2] = new Actividad("3", "Listening",  preguntas3);
        actividades[3] = new Actividad("4", "Choose the correct option",preguntas4);
    }


    public void cargarPreguntasActividad()
    {
        cargarActividades();
        for (int i=0; i<actividades.length;i++)
        {
            if(actividades[i].darTipo().equalsIgnoreCase("1"))
            {
                actividades[i].darPreguntas().add(new Pregunta("What is this?", 0, 0, "Sweater", "Dress", "Blouse", "Shirt", 1, "clothes",1));
                actividades[i].darPreguntas().add(new Pregunta("What colors do you see?", 0, 0, "Dark red and beige", "Red and brown", "Wine and beige", "Light red and brown", 1, "colors",1));
                actividades[i].darPreguntas().add(new Pregunta("What is this sweater like?", 0, 0, "It's long sleeved", "Yes, I like this sweater", "I don't like it", "It's single colored", 2, "clothes,answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What color do you see?", 1, 0, "Aquamarine", "Dark blue", "Blue", "Sky", 1, "colors",1));
                actividades[i].darPreguntas().add(new Pregunta("What is this?", 1, 0, "Blouse", "Dress", "Sweater", "Shirt", 1, "clothes",1));
                actividades[i].darPreguntas().add(new Pregunta("What is this blouse like?", 1, 0, "It's long sleeved", "Yes, I like this blouse", "I don't like it", "It's colorful", 2, "clothes,answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What is this piece of clothing like?", 2, 0, "Armhole sleeved", "Yes, I like this blouse", "I don't like it", "It's colorful", 2, "clothes,answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What is this?", 2, 0, "It's an armhole sleeved shirt", "It's a sweater", "It's a jacket", "It's a long sleeved blouse", 1, "clothes",1));
                actividades[i].darPreguntas().add(new Pregunta("What colors do you see?", 2, 0, "Dark and light blue", "Aquamarine and light blue", "green and blue", "Green", 1, "colors",1));
                actividades[i].darPreguntas().add(new Pregunta("What color do you see?", 3, 0, "Purple", "Aquamarine", "Green", "Light blue", 1, "colors",1));
                actividades[i].darPreguntas().add(new Pregunta("What is this?", 3, 0, "It's a button down shirt", "It's an armhole sleeved shirt", "It's a short sleeved blouse", "It's a long sleeved t shirt", 1, "clothes",1));
                actividades[i].darPreguntas().add(new Pregunta("What is this?", 4, 0, "It's a dress", "It's a button down shirt", "It's a short sleeved blouse", "It's a skirt", 1, "clothes",1));
                actividades[i].darPreguntas().add(new Pregunta("What colors do you see?", 4, 0, "Green and light green", "Aquamarine and green", "Green and blue", "Light green", 1, "colors",1));
                actividades[i].darPreguntas().add(new Pregunta("Does this dress have a belt?", 4, 0, "Yes, it does", "It has a belt", "No, it doesn't", "It has a loong skirt", 1, "answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What's the skirt like?", 4, 0, "It's long", "It's short", "Yes, it's long", "No, it's short", 1, "answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What's this animal?", 5, 0, "It's an elephant", "It's a sea elephant", "It's big", "It's gray", 1, "animals,answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What's this animal like?", 5, 0, "It's big", "Yes, I like the elephants", "It's an elephant", "I like elephants", 1, "animals,answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("Where does this animal live?", 5, 0, "In Africa", "In Asia", "It lives at home", "In the north pole", 1, "places,answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What are its ears like?", 5, 0, "They're big", "It's big", "It's an elephant", "I like elephants", 1, "adjectives,answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("Where is this place?", 6, 0, "In Asia", "In Africa", "It's the Tah Mahal", "It's a princess tomb", 1, "places,answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What is this place called?", 6, 0, "It's the Tah Mahal", "It's in Africa", "It's in Asia", "It's in India", 1, "places,answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What was this monuments built for?", 6, 0, "It's a princess tomb", "It's the Tah Mahal", "It's in Asia", "It's in India", 2, "answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What are these?", 7, 0, "They're children's pictures", "They're childrens pictures", "They're children pictures", "They're child pictures", 1, "answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What are these pictures like?", 7, 0, "They're colorful", "Yes, they're beautiful", "They're children", "They're child pictures", 1, "adjectives,answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("How many mice do you see?", 8, 0, "6", "5", "4", "3", 1, "answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What are these?", 8, 0, "They are mice", "They're mouse", "They're a mouse", "It's mouses", 2, "animals,answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What are they like?", 8, 0, "They are small", "They're mice", "They're a mouse", "Yes, it's a mouse", 2, "adjectives,answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What color are they?", 8, 0, "They are beige", "They're mice", "Big", "Yes, they're beige", 1, "colors,answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("How many tomatoes do you see?", 9, 0, "Four", "Five", "Fourteen", "Fourty", 1, "numbers,answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What are these?", 9, 0, "Tomatoes", "Tomatos", "Tomato", "Ketchup", 1, "food,answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What color are these?", 9, 0, "Red", "Yes, they're red", "They are red, green", "They're green, after red", 1, "answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What country is this?", 10, 0, "Spain", "Italy", "France", "England", 1, "countriesandnationalities",1));
                actividades[i].darPreguntas().add(new Pregunta("Where is this country?", 10, 0, "Europe", "Latin America", "Asia", "Africa", 1, "countriesandnationalities",1));
                actividades[i].darPreguntas().add(new Pregunta("What are people from Spain called?", 10, 0, "Spaniard", "Spain", "Yes, they're Spanish", "Ala Madrid!", 1, "countriesandnationalities",1));
                actividades[i].darPreguntas().add(new Pregunta("What's the capital city of Spain?", 10, 0, "Madrid", "Spain", "Barcelona", "Lisbon", 1, "countriesandnationalities",1));
                actividades[i].darPreguntas().add(new Pregunta("What are these?", 11, 0, "Boxes", "Box's", "Box", "A boxes", 1, "pluralnouns",1));
                actividades[i].darPreguntas().add(new Pregunta("How many boxes do you see?", 11, 0, "A lot", "Much", "36", "126", 1, "answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What color are these?", 11, 0, "Brown", "Light beige", "Gray", "They're boxes", 1, "answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What are these monuments?", 12, 0, "Egypt", "Lebanon", "Israel", "Lybia", 1, "places",1));
                actividades[i].darPreguntas().add(new Pregunta("Where are these monuments?", 12, 0, "Africa", "Asia", "North America", "Mexico", 1, "places",1));
                actividades[i].darPreguntas().add(new Pregunta("Where can you see this animal?", 13, 0, "Asia", "Africa", "South America", "Yes, in the zoo", 2, "answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What's this animals called?", 13, 0, "Tiger", "Lion", "Mountain lion", "Leopard", 1, "animals",1));
                actividades[i].darPreguntas().add(new Pregunta("What's this animal like?", 13, 0, "It's big and dangerous", "It's a tiger", "I like tigers", "Oh, yes. I like tigers", 2, "answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What's he wearing?", 14, 0, "Shorts", "A short", "A shorts", "Pants", 2, "clothes,answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("What sports does he play?", 14, 0, "Soccer", "He play football", "American football", "Soccer shoes", 1, "sports,answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("How do you spell the name of this animal?", 15, 0, "Kangaroo", "Cangaru", "Cangaroo", "Kanguroo", 1, "animals",1));
                actividades[i].darPreguntas().add(new Pregunta("Where would you see this sign?", 15, 0, "By the road", "In a building", "At home", "In the park", 1, "answeringtoquestion",1));
                actividades[i].darPreguntas().add(new Pregunta("Where would you see this animal?", 15, 0, "Australia", "Africa", "The Antarctic", "Asia", 1, "places",1));
                actividades[i].darPreguntas().add(new Pregunta("Where is this tower?", 16, 0, "In Toronto, Canada", "In Paris, France", "In Madrid, Spain", "In Tokyo, Japan", 2, "places",1));
                actividades[i].darPreguntas().add(new Pregunta("Where is this tower?", 16, 0, "In North America", "In South America", "In Europe", "In Asia", 2, "places",1));
                actividades[i].darPreguntas().add(new Pregunta("What are these?", 17, 0, "Potatoes", "Patatoes", "Potatos", "Yes, they're potatos", 1, "pluralnouns",1));
                actividades[i].darPreguntas().add(new Pregunta("What sports is this?", 18, 0, "Soccer", "English football", "American football", "Rugby", 1, "sports",1));
                actividades[i].darPreguntas().add(new Pregunta("What sports is this?", 19, 0, "Baseball", "Volleyball", "Beisboll", "Golf", 1, "sports",1));
                actividades[i].darPreguntas().add(new Pregunta("What sports is this?", 20, 0, "Tennis", "Squash", "Softbol", "Baseball", 1, "sports",1));
                actividades[i].darPreguntas().add(new Pregunta("What is this animal called?", 21, 0, "Llama", "Lama", "South american camel", "South american donkey", 1, "animals",1));
                actividades[i].darPreguntas().add(new Pregunta("Where would you see this animal?", 21, 0, "South America", "Africa", "North America", "Asia", 1, "places",1));
                actividades[i].darPreguntas().add(new Pregunta("Where would you see this animals?", 21, 0, "In Peru", "In Portugal", "In Australia", "In Canada", 1, "places",1));
                actividades[i].darPreguntas().add(new Pregunta("Where is this tower?", 22, 0, "In Italy", "In Portugal", "In Belgium", "In Germany", 1, "places",1));
                actividades[i].darPreguntas().add(new Pregunta("Where is this tower?", 22, 0, "In Europe", "In Asia", "In Africa", "In America", 1, "places",1));
                actividades[i].darPreguntas().add(new Pregunta("Where is this tower?", 23, 0, "In Europe", "In Asia", "In Africa", "In America", 1, "places",1));
                actividades[i].darPreguntas().add(new Pregunta("Where is this tower?", 23, 0, "In Paris, France", "In Madrid, Spain", "In Stocholm, Denmark", "In Stuttgart, Germany", 1, "places",1));
                actividades[i].darPreguntas().add(new Pregunta("Where Can you see replicas of the Eiffel tower?", 23, 0, "In Tokyo and Las Vegas", "In Madrid and Lisbon", "In Bangkock, and Jakarta", "In Rio de Janeiro, and Los Angeles", 3, "places",1));
                actividades[i].darPreguntas().add(new Pregunta("What sports is this?", 24, 0, "Basketball", "Baseball", "Softball", "Horseball", 1, "sports",1));
                actividades[i].darPreguntas().add(new Pregunta("What flag is this?", 25, 0, "Chile", "Texas", "Georgia", "Panama", 1, "places",1));
            } else if (actividades[i].darTipo().equalsIgnoreCase("2")) {
                actividades[i].darPreguntas().add(new Pregunta("Robert doesn't study here", 0, 0, null, null, null, null, 3, "sentenceconstruction,affirmativemode,Auxiliary",1));
                actividades[i].darPreguntas().add(new Pregunta("Alicia’s last name is Soto", 0, 0, null, null, null, null, 3, "sentenceconstruction,affirmativemode",1));
                actividades[i].darPreguntas().add(new Pregunta("Andrea is from Pasto", 0, 0, null, null, null, null, 3, "sentenceconstruction,affirmativemode",1));
                actividades[i].darPreguntas().add(new Pregunta("Linda is a good player tennis", 0, 0, null, null, null, null, 3, "sentenceconstruction,affirmativemode",1));
                actividades[i].darPreguntas().add(new Pregunta("My English class is interesting", 0, 0, null, null, null, null, 3, "sentenceconstruction,affirmativemode",1));
                actividades[i].darPreguntas().add(new Pregunta("I am happy to hear that", 0, 0, null, null, null, null, 3, "sentenceconstruction,affirmativemode",1));
                actividades[i].darPreguntas().add(new Pregunta("Susan is my sister", 0, 0, null, null, null, null, 3, "sentenceconstruction,affirmativemode",1));
                actividades[i].darPreguntas().add(new Pregunta("English is not difficult", 0, 0, null, null, null, null, 3, "sentenceconstruction,negativemode",1));
                actividades[i].darPreguntas().add(new Pregunta("My parents are not from Cali", 0, 0, null, null, null, null, 3, "sentenceconstruction,negativemode",1));
                actividades[i].darPreguntas().add(new Pregunta("Are you O.K?", 0, 0, null, null, null, null, 3, "sentenceconstruction,yesnoquestions",1));
                actividades[i].darPreguntas().add(new Pregunta("Is your teacher Ms.Ramos?", 0, 0, null, null, null, null, 3, "sentenceconstruction,yesnoquestions",1));
                actividades[i].darPreguntas().add(new Pregunta("Are your classmates good students?", 0, 0, null, null, null, null, 3, "sentenceconstruction,yesnoquestions",1));
                actividades[i].darPreguntas().add(new Pregunta("Is your mother from Panama?", 0, 0, null, null, null, null, 3, "sentenceconstruction,yesnoquestions,countriesandnationalities",1));
                actividades[i].darPreguntas().add(new Pregunta("Is English your first language?", 0, 0, null, null, null, null, 3, "sentenceconstruction,yesnoquestions",1));
                actividades[i].darPreguntas().add(new Pregunta("Is his last name Gomez?", 0, 0, null, null, null, null, 3, "sentenceconstruction,yesnoquestions",1));
                actividades[i].darPreguntas().add(new Pregunta("What is your telephone number?", 0, 0, null, null, null, null, 3, "sentenceconstruction,whquestions",1));
            } else if (actividades[i].darTipo().equalsIgnoreCase("3")) {
                actividades[i].darPreguntas().add(new Pregunta("what's her full name?", 0, 0, "Ana Ramirez", "Anita", "Ana", "Ramirez", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("what's her nickname?", 0, 0, "Anita", "Ana Ramirez", "Ana", "Ramirez", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("what's her first name?", 0, 0, "Ana", "Ana Ramirez", "Anita", "Ramirez", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("what's her last name", 0, 0, "Ramirez", "Ana Ramirez", "Anita", "Ana", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("what's her job?", 0, 1, "She's a secretary", "She's a nurse", "She's a manager", "She's a engineer", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("How old is she", 0, 1, "she's 20", "she's 12", "she's 22", "she's 21", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What's her phone number?", 0, 1, "it's 312 560 8941", "It's 312 568 8941", "It's 312 560 9941", "It's 319 980 9900", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What's the address?", 0, 2, "Roosevelt Avenue, and 57 Street", "Ronald Avenue, and 17 Street", "Ross Avenue, and 37 Street", "Ross Avenue, and 47 Street", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What's the apartment number?", 0, 2, "202", "212", "222", "102", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What happens today?", 0, 3, "It's her first English class", "It's her birthday", "She travels to the U.S.", "She graduates", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What's her name?", 0, 4, "Ana", "Lana", "Juana", "Donna", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("How is his family?", 0, 4, "They're OK", "It's OK", "He's OK", "I'm OK", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What's her last name?", 0, 4, "The audio doesn't say", "Sanders", "Morgan", "Smith", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What letter do you hear?", 0, 5, "A", "I", "E", "U", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What letter do you hear?", 0, 6, "C", "Z", "X", "S", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What letter do you hear?", 0, 7, "E", "I", "A", "O", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What letter do you hear?", 0, 8, "G", "W", "K", "J", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What letter do you hear?", 0, 9, "I", "E", "A", "U", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What letter do you hear?", 0, 10, "J", "K", "P", "G", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What letter do you hear?", 0, 11, "S", "Z", "X", "C", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What letter do you hear?", 0, 12, "X", "Z", "S", "C", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What letter do you hear?", 0, 13, "Z", "S", "X", "C", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What word do you hear?", 0, 14, "Cake", "Calf", "King", "Ache", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What word do you hear?", 0, 15, "Tape", "Cape", "Type", "Ape", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What word do you hear?", 0, 16, "Metal", "Fetal", "Mother", "Letal", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What word do you hear?", 0, 17, "Kind", "King", "Keen", "Camp", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What word do you hear?", 0, 18, "Shop", "Chopper", "Ship", "Sheep", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What word do you hear?", 0, 19, "Cute", "Mute", "Key", "Kiut", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What word do you hear?", 0, 20, "Dollar", "Willard", "Ronald", "Donald", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What word do you hear?", 0, 21, "Price", "Mice", "Nice", "Peace", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What word do you hear?", 0, 22, "Pull", "Whool", "Dull", "Full", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What number do you hear?", 0, 23, "11", "37", "17", "100", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What number do you hear?", 0, 24, "12", "20", "2", "120", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What number do you hear?", 0, 25, "13", "33", "31", "30", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What number do you hear?", 0, 26, "14", "4", "40", "44", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What number do you hear?", 0, 27, "15", "25", "50", "5", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What number do you hear?", 0, 28, "16", "60", "6", "66", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What number do you hear?", 0, 29, "17", "70", "27", "7", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What number do you hear?", 0, 30, "18", "81", "80", "8", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What number do you hear?", 0, 31, "19", "9", "91", "90", 1, "listeningSkills",1));
                actividades[i].darPreguntas().add(new Pregunta("What number do you hear?", 0, 32, "20", "12", "21", "2", 1, "listeningSkills",1));
            } else {
                actividades[i].darPreguntas().add(new Pregunta("Are you from Colombia?", 0, 0, "Yes, I am", "Yes, I'm", "Yes, I do", "Nothing", 1, "answeringtoquestion,yesnoquestions,presentsimple,countriesandnationalities",1));
                actividades[i].darPreguntas().add(new Pregunta("Is he retired?", 0, 0, "Yes, he is", "Yes, he's", "Yes, I do", "Nothing", 1, "answeringtoquestion,yesnoquestions,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("Are they married?", 0, 0, "Yes, they are", "Yes, they do", "Yes, they're", "No, you aren't", 1, "answeringtoquestion,yesnoquestions,identifyingpluralforms,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("Is Mrs. Lopez pretty?", 0, 0, "Yes, she is", "Yes,she's", "Yes, she is", "She's ugly", 1, "answeringtoquestion,yesnoquestions,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("Are you in English 1?", 0, 0, "Yes, I am", "Yes, I'm", "Yes, am I", "I'm in English classes", 1, "answeringtoquestion,yesnoquestions,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("Are you intelligent?", 0, 0, "Yes, we are", "Yes, are we", "Yes, we're", "We are very smart", 1, "answeringtoquestion,yesnoquestions,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("Is Ecuador a big country?", 0, 0, "No, it isn't", "Yes, I do", "It's big", "Yes, it's", 1, "answeringtoquestion,yesnoquestions,presentsimple,countriesandnationalities",1));
                actividades[i].darPreguntas().add(new Pregunta("Are they listening to music?", 0, 0, "No, they aren't", "Yes, they're", "Yes, they do", "They are listening to music", 1, "answeringtoquestion,yesnoquestions,identifyingpluralforms,presentcontinuous",1));
                actividades[i].darPreguntas().add(new Pregunta("Are you free?", 0, 0, "Yes, I am", "Yes, I do", "Yes, they do", "I'm free", 1, "answeringtoquestion,yesnoquestions,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("Are you a student?", 0, 0, "Yes, I am", "Yes, they do", "Yes, I do", "Yes, I'm", 1, "answeringtoquestion,yesnoquestions,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("This is Sara._____ last name is Castro", 0, 0, "Her", "Its", "They", "Nothing", 1, "correctuseofpronouns,affirmativemode,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("This is Mr.Orozco. _____ last name is Carlos", 0, 0, "His", "Her", "Its", "Nothing", 1, "correctuseofpronouns,affirmativemode,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("My sister is a student. _____ is ten", 0, 0, "She", "Her", "Hers", "Nothing", 1, "correctuseofpronouns,affirmativemode,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("My shoes are beautiful. _____ are expensive,too", 0, 0, "They", "Their", "Our", "Nothing", 1, "correctuseofpronouns,affirmativemode,identifyingpluralforms,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("Cali is a nice city. _____ is clean,too", 0, 0, "It", "Its", "He", "Nothing", 1, "correctuseofpronouns,affirmativemode,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("Ana and Antonio are married. _____ are happy", 0, 0, "They", "Their", "Them", "theirs", 1, "correctuseofpronouns,affirmativemode,presentsimple,identifyingpluralforms",1));
                actividades[i].darPreguntas().add(new Pregunta("_____ university is the best", 0, 0, "My", "You", "Its", "Nothing", 1, "correctuseofpronouns,affirmativemode,presentsimple,possessiveadjectives",1));
                actividades[i].darPreguntas().add(new Pregunta("Susan is from Italy. _____ is Italian", 0, 0, "She", "Hers", "Her", "He", 1, "correctuseofpronouns,affirmativemode,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("Luis and Gloria are students. _____ parents are doctors", 0, 0, "Their", "Our", "Them", "The", 1, "correctuseofpronouns,affirmativemode,presentsimple,identifyingpluralforms",1));
                actividades[i].darPreguntas().add(new Pregunta("I am teacher. _____ job is great", 0, 0, "My", "You", "His", "Nothing", 1, "correctuseofpronouns,affirmativemode,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("Hector _____ Canadian, but he lives in Canada", 0, 0, "isn't", "aren't", "to be", "Is", 1, "conjugation,negativemode,presentsimple,countriesandnationalities",1));
                actividades[i].darPreguntas().add(new Pregunta("They _____ doctors", 0, 0, "aren't", "to be", "isn't", "are", 1, "conjugation,negativemode,identifyingpluralforms,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("She _____ at home", 0, 0, "isn't", "aren't", "to be", "are", 1, "conjugation,negativemode,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("We _____ sad", 0, 0, "aren't", "not be", "isn't", "is", 1, "conjugation,negativemode,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("I _____ happy", 0, 0, "am", "isn't", "are", "is", 1, "conjugation,affirmativemode,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("They _____ big", 0, 0, "aren't", "are", "not be", "isn't", 1, "conjugation,negativemode,identifyingpluralforms,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("You _____ from Colombia, you're Colombian", 0, 0, "are", "isn't", "am", "is", 1, "conjugation,affirmativemode,presentsimple,countriesandnationalities",1));
                actividades[i].darPreguntas().add(new Pregunta("You and I _____ friends", 0, 0, "are", "is", "am", "isn't", 1, "conjugation,affirmativemode,identifyingpluralforms,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("I _____ fine", 0, 0, "am", "is", "are", "not am", 1, "conjugation,affirmativemode,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("It _____ free", 0, 0, "is", "are", "am", "not is", 1, "conjugation,affirmativemode,presentsimple",1));
                actividades[i].darPreguntas().add(new Pregunta("The plural of box is _____", 0, 0, "boxes", "boxs", "box", "boxxes", 1, "pluralnouns",1));
                actividades[i].darPreguntas().add(new Pregunta("The plural of child is _____", 0, 0, "children", "children's", "childrens", "childs", 1, "pluralnouns",1));
                 actividades[i].darPreguntas().add(new Pregunta("The plural of wife is _____", 0, 0, "wives", "wifs", "wife", "wifes", 1, "pluralnouns",1));
                 actividades[i].darPreguntas().add(new Pregunta("The plural of knife is _____", 0, 0, "knives", "knifes", "knifeses", "knifs", 1, "pluralnouns",1));
                 actividades[i].darPreguntas().add(new Pregunta("The plural of mouse is _____", 0, 0, "mice", "mouses", "mouse", "mouse's", 1, "pluralnouns",1));
                 actividades[i].darPreguntas().add(new Pregunta("The plural of monkey is _____", 0, 0, "monkeys", "monkys", "monkey's", "monkies", 1, "pluralnouns",1));
                 actividades[i].darPreguntas().add(new Pregunta("The plural of quiz is _____", 0, 0, "quizzes", "quices", "quizs", "quiz", 1, "pluralnouns",1));
                 actividades[i].darPreguntas().add(new Pregunta("The plural of tomato is _____", 0, 0, "tomatoes", "tomato's", "tomato", "tomatos", 1, "pluralnouns",1));
                 actividades[i].darPreguntas().add(new Pregunta("The plural of deer is _____", 0, 0, "deer", "deeres", "deers", "deer's", 1, "pluralnouns",1));
                 actividades[i].darPreguntas().add(new Pregunta("The plural of potato is _____", 0, 0, "potatoes", "potato's", "potatoeses", "potato", 1, "pluralnouns",1));
                 actividades[i].darPreguntas().add(new Pregunta("20", 0, 0, "twenty", "twelve", "two", "tweenty", 1, "numbers",1));
                 actividades[i].darPreguntas().add(new Pregunta("13", 0, 0, "Thirteen", "three", "thirty", "thirten", 1, "numbers",1));
                 actividades[i].darPreguntas().add(new Pregunta("15", 0, 0, "Fifteen", "Five", "Fifty", "fiften", 1, "numbers",1));
                 actividades[i].darPreguntas().add(new Pregunta("12", 0, 0, "Twelve", "Twenty", "Thrirteen", "tweelve", 1, "numbers",1));
                 actividades[i].darPreguntas().add(new Pregunta("17", 0, 0, "Seventeen", "Seven", "Seventy", "seventen", 1, "numbers",1));
                 actividades[i].darPreguntas().add(new Pregunta("3", 0, 0, "Three", "Thirteen", "tree", "tre", 1, "numbers",1));
                 actividades[i].darPreguntas().add(new Pregunta("16", 0, 0, "Sixteen", "Six", "Sixty", "Sixten", 1, "numbers",1));
                 actividades[i].darPreguntas().add(new Pregunta("19", 0, 0, "Nineteen", "Ninety", "Nine", "nineten", 1, "numbers",1));
                 actividades[i].darPreguntas().add(new Pregunta("14", 0, 0, "Fourteen", "Forty", "Fourtin", "Four", 1, "numbers",1));
                 actividades[i].darPreguntas().add(new Pregunta("8", 0, 0, "Eight", "Eigth", "Eighty", "Eighteen", 1, "numbers",1));
                 actividades[i].darPreguntas().add(new Pregunta("___ are you today?", 0, 0, "Why", "What", "When", "how", 1, "questions,presentsimple",1));
                 actividades[i].darPreguntas().add(new Pregunta("___ is your address?", 0, 0, "What", "Which", "Where", "When", 1, "questions,presentsimple",1));
                 actividades[i].darPreguntas().add(new Pregunta("___ is she?", 0, 0, "Who", "Why", "When", "What", 1, "questions,presentsimple",1));
                 actividades[i].darPreguntas().add(new Pregunta("___ are these?", 0, 0, "What", "Why", "How", "When", 1, "questions,presentsimple,identifyingpluralforms",1));
                 actividades[i].darPreguntas().add(new Pregunta("___ is your family?", 0, 0, "How", "Why", "When", "Who", 1, "questions,presentsimple",1));
                 actividades[i].darPreguntas().add(new Pregunta("___ are your books?", 0, 0, "Where", "How many", "Who", "When", 1, "questions,presentsimple",1));
                 actividades[i].darPreguntas().add(new Pregunta("___ are your classes?", 0, 0, "How", "Who", "How much", "What", 1, "questions,presentsimple",1));
                 actividades[i].darPreguntas().add(new Pregunta("___ is your English class?", 0, 0, "What time", "Who", "What", "What hour", 1, "questions,presentsimple",1));
                 actividades[i].darPreguntas().add(new Pregunta("___ do you spell that?", 0, 0, "How", "How much", "When", "What", 1, "questions,presentsimple",1));
                 actividades[i].darPreguntas().add(new Pregunta("___ is your best friend?", 0, 0, "Why", "What", "Who", "When", 1, "questions,presentsimple",1));
                 actividades[i].darPreguntas().add(new Pregunta("My name is Tom.(Tom) _____ am Colombian.This is my family", 0, 0, "I", "You", "He", "She", 1, "correctuseofpronouns",1));
                 actividades[i].darPreguntas().add(new Pregunta("My mother's name is Sara.(Sara) _____ is from the U.S.", 0, 0, "She", "You", "He", "We", 1, "correctuseofpronouns",1));
                 actividades[i].darPreguntas().add(new Pregunta("Steve is my dad.(My dad) _____ is a photographer", 0, 0, "He", "You", "I", "She", 1, "correctuseofpronouns",1));
                 actividades[i].darPreguntas().add(new Pregunta("On this picture you can see William.(William) _____ is my brother", 0, 0, "He", "You", "He", "She", 1, "correctuseofpronouns",1));
                 actividades[i].darPreguntas().add(new Pregunta("(Carlos and I) _____ are twins", 0, 0, "We", "You", "He", "She", 1, "correctuseofpronouns,identifyingpluralforms",1));
                 actividades[i].darPreguntas().add(new Pregunta("(Betty, Susan and I) _____ live in Bucaramanga", 0, 0, "We", "You", "He", "She", 1, "correctuseofpronouns,identifyingpluralforms",1));
                 actividades[i].darPreguntas().add(new Pregunta("I live in Palmira.(Palmira) _____ isn't far from Cali", 0, 0, "It", "You", "He", "She", 1, "correctuseofpronouns",1));
                 actividades[i].darPreguntas().add(new Pregunta("Buga and Cali are two cities.(Buga and Cali) _____ are in Cauca Valley", 0, 0, "They", "You", "He", "She", 1, "correctuseofpronouns,identifyingpluralforms",1));
                 actividades[i].darPreguntas().add(new Pregunta("(The temperature) _____ is usually hot in our city", 0, 0, "It", "You", "He", "She", 1, "correctuseofpronouns",1));
                 actividades[i].darPreguntas().add(new Pregunta("(My family and I) _____ love to live in London,England", 0, 0, "We", "You", "He", "She", 1, "correctuseofpronouns,identifyingpluralforms",1));
                 actividades[i].darPreguntas().add(new Pregunta("A: What's your name?   B: _____Claudia", 0, 0, "It's", "Am", "Is", "Be", 1, "correctuseofpronouns",1));
                 actividades[i].darPreguntas().add(new Pregunta("My new car _____parked in the garage now", 0, 0, "Is", "Are", "Am", "It's", 1, "conjugation,presentsimple",1));
                 actividades[i].darPreguntas().add(new Pregunta("My mother and my father _____ both architects", 0, 0, "are", "they're", "is", "isn't", 1, "conjugation,presentsimple",1));
                 actividades[i].darPreguntas().add(new Pregunta("Mike! Stop playing there, you _____ very inconsiderate", 0, 0, "are", "is", "aren't", "isn't", 1, "conjugation,presentsimple",1));
                 actividades[i].darPreguntas().add(new Pregunta("I'm happy _____ a very good student", 0, 0, "to be", "am", "is", "are", 1, "conjugation,usinginfinitiveformcorrectly,presentsimple",1));
                 actividades[i].darPreguntas().add(new Pregunta("My best friend and I love _____ tennis every weekend", 0, 0, "to play", "play", "to playing", "plays", 1, "conjugation,usinginfinitiveformcorrectly,identifyingpluralforms,presentsimple",1));
                 actividades[i].darPreguntas().add(new Pregunta("Carolina _____ to school by bus, now she can take the MIO", 0, 0, "goes", "go", "went", "was", 1, "conjugation,thirdpersonconjugation,presentsimple",1));
                 actividades[i].darPreguntas().add(new Pregunta("I always _____ for the English exams for a few days", 0, 0, "study", "studies", "studying", "cant studied", 1, "conjugation,presentsimple",1));
                 actividades[i].darPreguntas().add(new Pregunta("Where did you put _____ wallet? I need to take out some money", 0, 0, "your", "you're", "Nothing", "Nothing", 1, "possessiveadjectives",1));
                 actividades[i].darPreguntas().add(new Pregunta("So I told my boss: _____ the most ridiculous person I've ever seen!", 0, 0, "You're", "Your", "Nothing", "Nothing", 1, "correctuseofpronouns",1));
                 actividades[i].darPreguntas().add(new Pregunta("Did you see _____ girls that just went by?", 0, 0, "those", "these", "this", "taht", 1, "demonstratives,identifyingpluralforms",1));
                 actividades[i].darPreguntas().add(new Pregunta("I don't like this car. I like _____ one over there", 0, 0, "that", "this", "those", "these", 1, "demonstratives",1));
                 actividades[i].darPreguntas().add(new Pregunta("_____ you a dedicated student?", 0, 0, "Are", "Is", "Do", "Does", 1, "questions,presentsimple",1));
                 actividades[i].darPreguntas().add(new Pregunta("What _____ your nickname?", 0, 0, "Is", "are", "am", "where", 1, "questions,presentsimple",1));
                 actividades[i].darPreguntas().add(new Pregunta("_____ your family from America?", 0, 0, "Is", "Are", "Do", "Does", 1, "questions,presentsimple",1));
                 actividades[i].darPreguntas().add(new Pregunta("Look, the sky is cloudy _____ I'm optimistic.Let's go to the beach", 0, 0, "but", "and", "Nothing", "Nothing", 1, "conjunctionsandbut",1));
                 actividades[i].darPreguntas().add(new Pregunta("They're going to do the homework _____ play Nintendo this afternoon", 0, 0, "and", "but", "Nothing", "Nothing", 1, "conjunctionsandbut",1));
                 actividades[i].darPreguntas().add(new Pregunta("I'd love to go to San Andres _____ I'm afraid of flying on an airplane", 0, 0, "but", "and", "Nothing", "Nothing", 1, "conjunctionsandbut",1));
                 actividades[i].darPreguntas().add(new Pregunta("My sister doesn't eat meat _____ sometimes she eats some eggs", 0, 0, "but", "and", "Nothing", "Nothing", 1, "conjunctionsandbut",1));
                 actividades[i].darPreguntas().add(new Pregunta("Today it's getting cloudy _____ I think it's going to rain later", 0, 0, "but", "and", "Nothing", "Nothing", 1, "conjunctionsandbut",1));
                 actividades[i].darPreguntas().add(new Pregunta("You skirt _____ your blouse don't match.The combination isn't OK.", 0, 0, "and", "but", "Nothing", "Nothing", 1, "conjunctionsandbut",1));
                 actividades[i].darPreguntas().add(new Pregunta("Thanks for the invitation _____ I have to study for an exam", 0, 0, "but", "and", "Nothing", "Nothing", 1, "conjunctionsandbut",1));
                 actividades[i].darPreguntas().add(new Pregunta("I want to go to the concert _____ the tickets are sold out already", 0, 0, "but", "and", "Nothing", "Nothing", 1, "conjunctionsandbut",1));
                 actividades[i].darPreguntas().add(new Pregunta("The movie is excellent _____ the end is really confusing", 0, 0, "but", "and", "Nothing", "Nothing", 1, "conjunctionsandbut",1));
                 actividades[i].darPreguntas().add(new Pregunta("The quiz was easy _____ I'm not sure about two or three questions", 0, 0, "but", "and", "Nothing", "Nothing", 1, "conjunctionsandbut",1));
            }
        }
    }



}
