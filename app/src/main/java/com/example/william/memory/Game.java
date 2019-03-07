package com.example.william.memory;

import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

enum GameState{
    INSTANCE;

    enum Theme {COULEURS,DRAPEAUX}
    enum Difficulty {EASY,MEDIUM,HARD,INSANE}

    private Difficulty difficulty;
    private int nbCartes;
    private Theme theme;

    private GameState(){
        theme = Theme.COULEURS;
    }

    public void setNbCartes(int nbCartes){
        this.nbCartes = nbCartes;
    }

    public int getNbCartes(){
        return nbCartes;
    }

    public Theme getTheme(){
        return theme;
    }

    public void changeDifficulty(){

    }

    public void setDifficulty(Difficulty difficulty){

    }

    public Difficulty getDifficulty(){
        return difficulty;
    }

    public void changeTheme(){
        if(theme == Theme.COULEURS) theme = Theme.DRAPEAUX;
        else if(theme == Theme.DRAPEAUX) theme = Theme.COULEURS;
    }

    public void setTheme(Theme theme){
        this.theme = theme;
    }
}

public class Game extends AppCompatActivity {
    ImageView iv11, iv12, iv13, iv14, iv21, iv22, iv23, iv24, iv31, iv32, iv33, iv34, iv41, iv42, iv43, iv44;
    int[] images = {0,0,0,0,0,0,0,0};
    int paires = 0;
    Button restart_button;
    Button return_button;
    //Button change_theme_button;


    boolean retournees;
    int nombreCarte = 1;    // première ou deuxième carte retournée ?
    int carte1, carte2;
    int clic1, clic2;
    Integer[] listeCartes = {11,12,13,14,15,16,17,18,11,12,13,14,15,16,17,18};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        retournees = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        GameState.INSTANCE.setNbCartes(8);

        return_button = findViewById(R.id.return_button);

        return_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        restart_button = findViewById(R.id.restart_button);

        restart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restart();
            }
        });

        iv11 = findViewById(R.id.iv11);
        iv12 = findViewById(R.id.iv12);
        iv13 = findViewById(R.id.iv13);
        iv14 = findViewById(R.id.iv14);
        iv21 = findViewById(R.id.iv21);
        iv22 = findViewById(R.id.iv22);
        iv23 = findViewById(R.id.iv23);
        iv24 = findViewById(R.id.iv24);
        iv31 = findViewById(R.id.iv31);
        iv32 = findViewById(R.id.iv32);
        iv33 = findViewById(R.id.iv33);
        iv34 = findViewById(R.id.iv34);
        iv41 = findViewById(R.id.iv41);
        iv42 = findViewById(R.id.iv42);
        iv43 = findViewById(R.id.iv43);
        iv44 = findViewById(R.id.iv44);

        iv11.setTag("0");
        iv12.setTag("1");
        iv13.setTag("2");
        iv14.setTag("3");
        iv21.setTag("4");
        iv22.setTag("5");
        iv23.setTag("6");
        iv24.setTag("7");
        iv31.setTag("8");
        iv32.setTag("9");
        iv33.setTag("10");
        iv34.setTag("11");
        iv41.setTag("12");
        iv42.setTag("13");
        iv43.setTag("14");
        iv44.setTag("15");

        initCartes(GameState.INSTANCE.getTheme());
        Collections.shuffle(Arrays.asList(listeCartes));

        iv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carte = Integer.parseInt((String) v.getTag());
                clic(carte, iv11);

            }
        });
        iv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carte = Integer.parseInt((String) v.getTag());
                clic(carte,iv12);
            }
        });
        iv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carte = Integer.parseInt((String) v.getTag());
                clic(carte,iv13);
            }
        });
        iv14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carte = Integer.parseInt((String) v.getTag());
                clic(carte,iv14);
            }
        });
        iv21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carte = Integer.parseInt((String) v.getTag());
                clic(carte,iv21);
            }
        });
        iv22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carte = Integer.parseInt((String) v.getTag());
                clic(carte,iv22);
            }
        });
        iv23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carte = Integer.parseInt((String) v.getTag());
                clic(carte,iv23);
            }
        });
        iv24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carte = Integer.parseInt((String) v.getTag());
                clic(carte,iv24);
            }
        });
        iv31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carte = Integer.parseInt((String) v.getTag());
                clic(carte,iv31);
            }
        });
        iv32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carte = Integer.parseInt((String) v.getTag());
                clic(carte,iv32);
            }
        });
        iv33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carte = Integer.parseInt((String) v.getTag());
                clic(carte,iv33);
            }
        });
        iv34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carte = Integer.parseInt((String) v.getTag());
                clic(carte,iv34);
            }
        });
        iv41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carte = Integer.parseInt((String) v.getTag());
                clic(carte,iv41);
            }
        });
        iv42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carte = Integer.parseInt((String) v.getTag());
                clic(carte,iv42);
            }
        });
        iv43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carte = Integer.parseInt((String) v.getTag());
                clic(carte,iv43);
            }
        });
        iv44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int carte = Integer.parseInt((String) v.getTag());
                clic(carte,iv44);
            }
        });

    }

    private void initCartes(GameState.Theme theme){
        if(theme == GameState.Theme.COULEURS) {
            images[0] = R.drawable.blanc;
            images[1] = R.drawable.bleu;
            images[2] = R.drawable.jaune;
            images[3] = R.drawable.noir;
            images[4] = R.drawable.orange;
            images[5] = R.drawable.rouge;
            images[6] = R.drawable.rose;
            images[7] = R.drawable.vert;
        }
        if(theme == GameState.Theme.DRAPEAUX){
            int[] res = {R.drawable.brazil,R.drawable.czech_republic,R.drawable.european_union,R.drawable.finland,R.drawable.france,R.drawable.germany,R.drawable.greece,R.drawable.israel,R.drawable.italy,R.drawable.luxembourg,R.drawable.palestine,R.drawable.russia,R.drawable.spain,R.drawable.sweden,R.drawable.turkey,R.drawable.ukraine,R.drawable.united_kingdom,R.drawable.united_states_of_america,R.drawable.venezuela,R.drawable.vietnam};
            Random r = new Random();
            int result;
            for(int i = 0; i < 8; i++){
                do{
                    result = r.nextInt(res.length);
                }while(res[result]==R.drawable.question);
                images[i] = res[result];
                res[result] = R.drawable.question;

            }

        }
    }



    public void restart(){
        this.recreate();
    }

    private void retourne(int idCarte,ImageView iv){
        //affichage
        if (listeCartes[idCarte] == 11) {
            iv.setImageResource(images[0]);
        } else if (listeCartes[idCarte] == 12) {
            iv.setImageResource(images[1]);
        } else if (listeCartes[idCarte] == 13) {
            iv.setImageResource(images[2]);
        } else if (listeCartes[idCarte] == 14) {
            iv.setImageResource(images[3]);
        } else if (listeCartes[idCarte] == 15) {
            iv.setImageResource(images[4]);
        } else if (listeCartes[idCarte] == 16) {
            iv.setImageResource(images[5]);
        } else if (listeCartes[idCarte] == 17) {
            iv.setImageResource(images[6]);
        } else if (listeCartes[idCarte] == 18) {
            iv.setImageResource(images[7]);
        }
        //
    }

    private void clic(int idCarte, ImageView iv){
        if(!retournees) {
            retourne(idCarte,iv);
            if (nombreCarte == 1) { //cas première carte retournée
                carte1 = listeCartes[idCarte];
                clic1 = idCarte;
                nombreCarte = 2;
            } else if (nombreCarte == 2) {
                clic2 = idCarte;
                if(!(clic2 == clic1)) {
                    retournees = true;
                    carte2 = listeCartes[idCarte];

                    nombreCarte = 1;

                    Handler hand = new Handler();
                    hand.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            test();
                            retournees = false;
                        }
                    }, 750);
                }

            }

        }
    }

    private void test(){
        if(carte1 == carte2){
            paires++;
            if(clic1 == 0){
                iv11.setVisibility(View.INVISIBLE);
            } else if(clic1 == 1){
                iv12.setVisibility(View.INVISIBLE);
            } else if(clic1 == 2){
                iv13.setVisibility(View.INVISIBLE);
            } else if(clic1 == 3){
                iv14.setVisibility(View.INVISIBLE);
            } else if(clic1 == 4){
                iv21.setVisibility(View.INVISIBLE);
            } else if(clic1 == 5){
                iv22.setVisibility(View.INVISIBLE);
            } else if(clic1 == 6){
                iv23.setVisibility(View.INVISIBLE);
            } else if(clic1 == 7){
                iv24.setVisibility(View.INVISIBLE);
            } else if(clic1 == 8){
                iv31.setVisibility(View.INVISIBLE);
            } else if(clic1 == 9){
                iv32.setVisibility(View.INVISIBLE);
            } else if(clic1 == 10){
                iv33.setVisibility(View.INVISIBLE);
            } else if(clic1 == 11){
                iv34.setVisibility(View.INVISIBLE);
            } else if(clic1 == 12){
                iv41.setVisibility(View.INVISIBLE);
            } else if(clic1 == 13){
                iv42.setVisibility(View.INVISIBLE);
            } else if(clic1 == 14){
                iv43.setVisibility(View.INVISIBLE);
            } else if(clic1 == 15){
                iv44.setVisibility(View.INVISIBLE);
            }
            if(clic2 == 0){
                iv11.setVisibility(View.INVISIBLE);
            } else if(clic2 == 1){
                iv12.setVisibility(View.INVISIBLE);
            } else if(clic2 == 2){
                iv13.setVisibility(View.INVISIBLE);
            } else if(clic2 == 3){
                iv14.setVisibility(View.INVISIBLE);
            } else if(clic2 == 4){
                iv21.setVisibility(View.INVISIBLE);
            } else if(clic2 == 5){
                iv22.setVisibility(View.INVISIBLE);
            } else if(clic2 == 6){
                iv23.setVisibility(View.INVISIBLE);
            } else if(clic2 == 7){
                iv24.setVisibility(View.INVISIBLE);
            } else if(clic2 == 8){
                iv31.setVisibility(View.INVISIBLE);
            } else if(clic2 == 9){
                iv32.setVisibility(View.INVISIBLE);
            } else if(clic2 == 10){
                iv33.setVisibility(View.INVISIBLE);
            } else if(clic2 == 11){
                iv34.setVisibility(View.INVISIBLE);
            } else if(clic2 == 12){
                iv41.setVisibility(View.INVISIBLE);
            } else if(clic2 == 13){
                iv42.setVisibility(View.INVISIBLE);
            } else if(clic2 == 14){
                iv43.setVisibility(View.INVISIBLE);
            } else if(clic2 == 15){
                iv44.setVisibility(View.INVISIBLE);
            }
            if(paires==GameState.INSTANCE.getNbCartes()){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setMessage(R.string.dialog_message)
                        .setTitle(R.string.dialog_title);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        } else{
            iv11.setImageResource(R.drawable.question);
            iv12.setImageResource(R.drawable.question);
            iv13.setImageResource(R.drawable.question);
            iv14.setImageResource(R.drawable.question);
            iv21.setImageResource(R.drawable.question);
            iv22.setImageResource(R.drawable.question);
            iv23.setImageResource(R.drawable.question);
            iv24.setImageResource(R.drawable.question);
            iv31.setImageResource(R.drawable.question);
            iv32.setImageResource(R.drawable.question);
            iv33.setImageResource(R.drawable.question);
            iv34.setImageResource(R.drawable.question);
            iv41.setImageResource(R.drawable.question);
            iv42.setImageResource(R.drawable.question);
            iv43.setImageResource(R.drawable.question);
            iv44.setImageResource(R.drawable.question);
        }

    }

}
