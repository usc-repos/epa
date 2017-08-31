package com.example.juan.prototipofinal;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class ScoreEstrellas extends AppCompatActivity {


    ImageButton imagenButon1,imagenButon2,imagenButon3,imagenButon4,imagenButon5,imagenButon6,imagenButon7,
            imagenButon8,imagenButon9,imagenButon10,imagenButon11,imagenButon12,imagenButon13,imagenButon14,imagenButon15,
            imagenButon16,imagenButon17,imagenButon18,imagenButon19,imagenButon20,imagenButon21,imagenButon22,imagenButon23,
            imagenButon24,imagenButon25,imagenButon26,imagenButon27,imagenButon28,imagenButon29,imagenButon30,imagenButon31,
            imagenButon32,imagenButon33,imagenButon34,imagenButon35,imagenButon36,imagenButon37,imagenButon38,imagenButon39,
            imagenButon40,imagenButon41,imagenButon42,imagenButon43,imagenButon44,imagenButon45,imagenButon46,imagenButon47,
            imagenButon48,imagenButon49,imagenButon50,imagenButon51,imagenButon52,imagenButon53,imagenButon54,imagenButon55,
            imagenButon56,imagenButon57,imagenButon58,imagenButon59,imagenButon60,imagenButon61,imagenButon62,imagenButon63,
            imagenButon64,imagenButon65,imagenButon66,imagenButon67,imagenButon68,imagenButon69,imagenButon70,imagenButon71,
            imagenButon72,imagenButon73,imagenButon74,imagenButon75,imagenButon76,imagenButon77,imagenButon78,imagenButon79,
            imagenButon80,imagenButon81,imagenButon82,imagenButon83,imagenButon84,imagenButon85,imagenButon86,imagenButon87;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_estrellas);
        imagenButon1 = (ImageButton) findViewById(R.id.imageButton1);
        imagenButon2 = (ImageButton) findViewById(R.id.imageButton2);
        imagenButon3 = (ImageButton) findViewById(R.id.imageButton3);
        imagenButon4 = (ImageButton) findViewById(R.id.imageButton4);
        imagenButon5 = (ImageButton) findViewById(R.id.imageButton5);
        imagenButon6 = (ImageButton) findViewById(R.id.imageButton6);
        imagenButon7 = (ImageButton) findViewById(R.id.imageButton7);
        imagenButon8 = (ImageButton) findViewById(R.id.imageButton8);
        imagenButon9 = (ImageButton) findViewById(R.id.imageButton9);
        imagenButon10 = (ImageButton) findViewById(R.id.imageButton10);
        imagenButon11 = (ImageButton) findViewById(R.id.imageButton11);
        imagenButon12 = (ImageButton) findViewById(R.id.imageButton12);
        imagenButon13 = (ImageButton) findViewById(R.id.imageButton13);
        imagenButon14 = (ImageButton) findViewById(R.id.imageButton14);
        imagenButon15 = (ImageButton) findViewById(R.id.imageButton15);
        imagenButon16 = (ImageButton) findViewById(R.id.imageButton16);
        imagenButon17 = (ImageButton) findViewById(R.id.imageButton17);
        imagenButon18 = (ImageButton) findViewById(R.id.imageButton18);
        imagenButon19 = (ImageButton) findViewById(R.id.imageButton19);
        imagenButon20 = (ImageButton) findViewById(R.id.imageButton20);
        imagenButon21 = (ImageButton) findViewById(R.id.imageButton21);
        imagenButon22 = (ImageButton) findViewById(R.id.imageButton22);
        imagenButon23 = (ImageButton) findViewById(R.id.imageButton23);
        imagenButon24 = (ImageButton) findViewById(R.id.imageButton24);
        imagenButon25 = (ImageButton) findViewById(R.id.imageButton25);
        imagenButon26 = (ImageButton) findViewById(R.id.imageButton26);
        imagenButon27 = (ImageButton) findViewById(R.id.imageButton27);
        imagenButon28 = (ImageButton) findViewById(R.id.imageButton28);
        imagenButon29 = (ImageButton) findViewById(R.id.imageButton29);
        imagenButon30 = (ImageButton) findViewById(R.id.imageButton30);
        imagenButon31 = (ImageButton) findViewById(R.id.imageButton31);
        imagenButon32 = (ImageButton) findViewById(R.id.imageButton32);
        imagenButon33 = (ImageButton) findViewById(R.id.imageButton33);
        imagenButon34 = (ImageButton) findViewById(R.id.imageButton34);
        imagenButon35 = (ImageButton) findViewById(R.id.imageButton35);
        imagenButon36 = (ImageButton) findViewById(R.id.imageButton36);
        imagenButon37 = (ImageButton) findViewById(R.id.imageButton37);
        imagenButon38 = (ImageButton) findViewById(R.id.imageButton38);
        imagenButon39 = (ImageButton) findViewById(R.id.imageButton39);
        imagenButon40 = (ImageButton) findViewById(R.id.imageButton40);
        imagenButon41 = (ImageButton) findViewById(R.id.imageButton41);
        imagenButon42 = (ImageButton) findViewById(R.id.imageButton42);
        imagenButon43 = (ImageButton) findViewById(R.id.imageButton43);
        imagenButon44 = (ImageButton) findViewById(R.id.imageButton44);
        imagenButon45 = (ImageButton) findViewById(R.id.imageButton45);
        imagenButon46 = (ImageButton) findViewById(R.id.imageButton46);
        imagenButon47 = (ImageButton) findViewById(R.id.imageButton47);
        imagenButon48 = (ImageButton) findViewById(R.id.imageButton48);
        imagenButon49 = (ImageButton) findViewById(R.id.imageButton49);
        imagenButon50 = (ImageButton) findViewById(R.id.imageButton50);
        imagenButon51 = (ImageButton) findViewById(R.id.imageButton51);
        imagenButon52 = (ImageButton) findViewById(R.id.imageButton52);
        imagenButon53 = (ImageButton) findViewById(R.id.imageButton53);
        imagenButon54 = (ImageButton) findViewById(R.id.imageButton54);
        imagenButon55 = (ImageButton) findViewById(R.id.imageButton55);
        imagenButon56 = (ImageButton) findViewById(R.id.imageButton56);
        imagenButon57 = (ImageButton) findViewById(R.id.imageButton57);
        imagenButon58 = (ImageButton) findViewById(R.id.imageButton58);
        imagenButon59 = (ImageButton) findViewById(R.id.imageButton59);
        imagenButon60 = (ImageButton) findViewById(R.id.imageButton60);
        imagenButon61 = (ImageButton) findViewById(R.id.imageButton61);
        imagenButon62 = (ImageButton) findViewById(R.id.imageButton62);
        imagenButon63 = (ImageButton) findViewById(R.id.imageButton63);
        imagenButon64 = (ImageButton) findViewById(R.id.imageButton64);
        imagenButon65 = (ImageButton) findViewById(R.id.imageButton65);
        imagenButon66 = (ImageButton) findViewById(R.id.imageButton66);
        imagenButon67 = (ImageButton) findViewById(R.id.imageButton67);
        imagenButon68 = (ImageButton) findViewById(R.id.imageButton68);
        imagenButon69 = (ImageButton) findViewById(R.id.imageButton69);
        imagenButon70 = (ImageButton) findViewById(R.id.imageButton70);
        imagenButon71 = (ImageButton) findViewById(R.id.imageButton71);
        imagenButon72 = (ImageButton) findViewById(R.id.imageButton72);
        imagenButon73 = (ImageButton) findViewById(R.id.imageButton73);
        imagenButon74 = (ImageButton) findViewById(R.id.imageButton74);
        imagenButon75 = (ImageButton) findViewById(R.id.imageButton75);
        imagenButon76 = (ImageButton) findViewById(R.id.imageButton76);
        imagenButon77 = (ImageButton) findViewById(R.id.imageButton77);
        imagenButon78 = (ImageButton) findViewById(R.id.imageButton78);
        imagenButon79 = (ImageButton) findViewById(R.id.imageButton79);
        imagenButon80 = (ImageButton) findViewById(R.id.imageButton80);
        imagenButon81 = (ImageButton) findViewById(R.id.imageButton81);
        imagenButon82 = (ImageButton) findViewById(R.id.imageButton82);
        imagenButon83 = (ImageButton) findViewById(R.id.imageButton83);
        imagenButon84 = (ImageButton) findViewById(R.id.imageButton84);
        imagenButon85 = (ImageButton) findViewById(R.id.imageButton85);
        imagenButon86 = (ImageButton) findViewById(R.id.imageButton86);
        imagenButon87 = (ImageButton) findViewById(R.id.imageButton87);

    }

}
