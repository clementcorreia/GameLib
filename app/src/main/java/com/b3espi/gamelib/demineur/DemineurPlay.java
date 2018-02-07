package com.b3espi.gamelib.demineur;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.b3espi.gamelib.R;

import static android.R.color.holo_green_light;
import static android.R.color.holo_red_light;
import static android.R.color.white;

public class DemineurPlay extends AppCompatActivity {
    int compteur_cases;
    TextView affichage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //this.setContentView(R.layout.demineur);

        final ActionBar actionBar = getActionBar();
        main();
    }
    void main(){
        final Button[][] listeboutons = new Button[10][10];
        partie_en_cours(start(), listeboutons);
        Button recommencer = (Button)findViewById(R.id.button103);
        recommencer.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                recommencer();
            }
        });
        affichage = (TextView) findViewById(R.id.textv);
        compteur_cases = 0;
    }

    void partie_en_cours(final int[][] bomb_grid, final Button[][] listeboutons){
        // la liste des boutons du demineur

        listeboutons[0][0] = (Button)findViewById(R.id.button2);
        listeboutons[0][1] = (Button)findViewById(R.id.button3);
        listeboutons[0][2] = (Button)findViewById(R.id.button4);
        listeboutons[0][3] = (Button)findViewById(R.id.button5);
        listeboutons[0][4] = (Button)findViewById(R.id.button6);
        listeboutons[0][5] = (Button)findViewById(R.id.button7);
        listeboutons[0][6] = (Button)findViewById(R.id.button8);
        listeboutons[0][7] = (Button)findViewById(R.id.button9);
        listeboutons[0][8] = (Button)findViewById(R.id.button10);
        listeboutons[0][9] = (Button)findViewById(R.id.button11);
        listeboutons[1][0] = (Button)findViewById(R.id.button12);
        listeboutons[1][1] = (Button)findViewById(R.id.button13);
        listeboutons[1][2] = (Button)findViewById(R.id.button14);
        listeboutons[1][3] = (Button)findViewById(R.id.button15);
        listeboutons[1][4] = (Button)findViewById(R.id.button16);
        listeboutons[1][5] = (Button)findViewById(R.id.button17);
        listeboutons[1][6] = (Button)findViewById(R.id.button18);
        listeboutons[1][7] = (Button)findViewById(R.id.button19);
        listeboutons[1][8] = (Button)findViewById(R.id.button20);
        listeboutons[1][9] = (Button)findViewById(R.id.button21);
        listeboutons[2][0] = (Button)findViewById(R.id.button22);
        listeboutons[2][1] = (Button)findViewById(R.id.button23);
        listeboutons[2][2] = (Button)findViewById(R.id.button24);
        listeboutons[2][3] = (Button)findViewById(R.id.button25);
        listeboutons[2][4] = (Button)findViewById(R.id.button26);
        listeboutons[2][5] = (Button)findViewById(R.id.button27);
        listeboutons[2][6] = (Button)findViewById(R.id.button28);
        listeboutons[2][7] = (Button)findViewById(R.id.button29);
        listeboutons[2][8] = (Button)findViewById(R.id.button30);
        listeboutons[2][9] = (Button)findViewById(R.id.button31);
        listeboutons[3][0] = (Button)findViewById(R.id.button32);
        listeboutons[3][1] = (Button)findViewById(R.id.button33);
        listeboutons[3][2] = (Button)findViewById(R.id.button34);
        listeboutons[3][3] = (Button)findViewById(R.id.button35);
        listeboutons[3][4] = (Button)findViewById(R.id.button36);
        listeboutons[3][5] = (Button)findViewById(R.id.button37);
        listeboutons[3][6] = (Button)findViewById(R.id.button38);
        listeboutons[3][7] = (Button)findViewById(R.id.button39);
        listeboutons[3][8] = (Button)findViewById(R.id.button40);
        listeboutons[3][9] = (Button)findViewById(R.id.button41);
        listeboutons[4][0] = (Button)findViewById(R.id.button42);
        listeboutons[4][1] = (Button)findViewById(R.id.button43);
        listeboutons[4][2] = (Button)findViewById(R.id.button44);
        listeboutons[4][3] = (Button)findViewById(R.id.button45);
        listeboutons[4][4] = (Button)findViewById(R.id.button46);
        listeboutons[4][5] = (Button)findViewById(R.id.button47);
        listeboutons[4][6] = (Button)findViewById(R.id.button48);
        listeboutons[4][7] = (Button)findViewById(R.id.button49);
        listeboutons[4][8] = (Button)findViewById(R.id.button50);
        listeboutons[4][9] = (Button)findViewById(R.id.button51);
        listeboutons[5][0] = (Button)findViewById(R.id.button52);
        listeboutons[5][1] = (Button)findViewById(R.id.button53);
        listeboutons[5][2] = (Button)findViewById(R.id.button54);
        listeboutons[5][3] = (Button)findViewById(R.id.button55);
        listeboutons[5][4] = (Button)findViewById(R.id.button56);
        listeboutons[5][5] = (Button)findViewById(R.id.button57);
        listeboutons[5][6] = (Button)findViewById(R.id.button58);
        listeboutons[5][7] = (Button)findViewById(R.id.button59);
        listeboutons[5][8] = (Button)findViewById(R.id.button60);
        listeboutons[5][9] = (Button)findViewById(R.id.button61);
        listeboutons[6][0] = (Button)findViewById(R.id.button62);
        listeboutons[6][1] = (Button)findViewById(R.id.button63);
        listeboutons[6][2] = (Button)findViewById(R.id.button64);
        listeboutons[6][3] = (Button)findViewById(R.id.button65);
        listeboutons[6][4] = (Button)findViewById(R.id.button66);
        listeboutons[6][5] = (Button)findViewById(R.id.button67);
        listeboutons[6][6] = (Button)findViewById(R.id.button68);
        listeboutons[6][7] = (Button)findViewById(R.id.button69);
        listeboutons[6][8] = (Button)findViewById(R.id.button70);
        listeboutons[6][9] = (Button)findViewById(R.id.button71);
        listeboutons[7][0] = (Button)findViewById(R.id.button72);
        listeboutons[7][1] = (Button)findViewById(R.id.button73);
        listeboutons[7][2] = (Button)findViewById(R.id.button74);
        listeboutons[7][3] = (Button)findViewById(R.id.button75);
        listeboutons[7][4] = (Button)findViewById(R.id.button76);
        listeboutons[7][5] = (Button)findViewById(R.id.button77);
        listeboutons[7][6] = (Button)findViewById(R.id.button78);
        listeboutons[7][7] = (Button)findViewById(R.id.button79);
        listeboutons[7][8] = (Button)findViewById(R.id.button80);
        listeboutons[7][9] = (Button)findViewById(R.id.button81);
        listeboutons[8][0] = (Button)findViewById(R.id.button82);
        listeboutons[8][1] = (Button)findViewById(R.id.button83);
        listeboutons[8][2] = (Button)findViewById(R.id.button84);
        listeboutons[8][3] = (Button)findViewById(R.id.button85);
        listeboutons[8][4] = (Button)findViewById(R.id.button86);
        listeboutons[8][5] = (Button)findViewById(R.id.button87);
        listeboutons[8][6] = (Button)findViewById(R.id.button88);
        listeboutons[8][7] = (Button)findViewById(R.id.button89);
        listeboutons[8][8] = (Button)findViewById(R.id.button90);
        listeboutons[8][9] = (Button)findViewById(R.id.button91);
        listeboutons[9][0] = (Button)findViewById(R.id.button92);
        listeboutons[9][1] = (Button)findViewById(R.id.button93);
        listeboutons[9][2] = (Button)findViewById(R.id.button94);
        listeboutons[9][3] = (Button)findViewById(R.id.button95);
        listeboutons[9][4] = (Button)findViewById(R.id.button96);
        listeboutons[9][5] = (Button)findViewById(R.id.button97);
        listeboutons[9][6] = (Button)findViewById(R.id.button98);
        listeboutons[9][7] = (Button)findViewById(R.id.button99);
        listeboutons[9][8] = (Button)findViewById(R.id.button100);
        listeboutons[9][9] = (Button)findViewById(R.id.button101);
        for(int row=0; row<10; row++) {
            for(int col=0; col<10; col++) {
                final int colIndex = col;
                final int rowIndex = row;
                final Button bouton = listeboutons[row][col];
                bouton.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        le_clic(colIndex, rowIndex, bomb_grid, bouton, listeboutons, "clic");
                    }
                });
                bouton.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (bouton.getText()!="?"){
                            bouton.setText("?");
                        }
                        else{
                            bouton.setText(" ");
                        }
                        return true;
                    }
                });
            }
        }
    }

    public void le_clic(final int posi, final int posj, final int[][]bomb_grid, Button appelant, final Button[][] listeboutons, String action){
        String affiche = String.valueOf(bomb_grid[posi][posj]);

        if (action!="defaite"){if (action!="victoire"){compteur_cases += 1;}}
        if (Integer.valueOf(affiche)==0){
            affiche=" ";
            if (action!="defaite"){expansion(posi, posj, listeboutons, bomb_grid);}
        }
        else if (Integer.valueOf(affiche)>8){
            affiche="*";
            if (action!="defaite"){if (action!="victoire"){defaite(listeboutons, bomb_grid);}}
        }
        if (action!="" || affiche!="*") {
            appelant.setText(affiche);
            appelant.setClickable(false);
            appelant.setBackgroundColor(getResources().getColor(white));
            if (affiche=="*"){
                if (action=="victoire"){
                    appelant.setBackgroundColor(getResources().getColor(holo_green_light));
                }
                else{
                    appelant.setBackgroundColor(getResources().getColor(holo_red_light));
                }
                appelant.setTextColor(getResources().getColor(white));
            }
        }
        if (action !="victoire"){
            if (compteur_cases==90){
                victoire(listeboutons, bomb_grid);
            }
        }
    }

    void defaite(final Button[][] listeboutons, final int[][] bomb_grid){
        //ma vie est suffisante pour resumer cette fonction.
        affichage.setText("DEFAITE");
        affichage.setTextColor(getResources().getColor(holo_red_light));
        for(int row=0; row<10; row++) {
            for(int col=0; col<10; col++) {
                final int colIndex = col;
                final int rowIndex = row;
                final Button bouton = listeboutons[row][col];
                le_clic(colIndex, rowIndex, bomb_grid, bouton, listeboutons, "defaite");
            }
        }
    }


    void victoire(final Button[][] listeboutons, final int[][] bomb_grid){
        // cette chose inconnue
        //ma vie est suffisante pour resumer cette fonction.
        affichage.setText("VICTOIRE");
        affichage.setTextColor(getResources().getColor(holo_green_light));
        for(int row=0; row<10; row++) {
            for(int col=0; col<10; col++) {
                final int colIndex = col;
                final int rowIndex = row;
                final Button bouton = listeboutons[row][col];
                le_clic(colIndex, rowIndex, bomb_grid, bouton, listeboutons, "victoire");
            }
        }
    }

    void expansion(int posi, int posj, final Button[][] listeboutons, final int[][]bomb_grid){
        // quand on clic sur une case vide ca decouvre toutes les cases autour
//        System.out.println(posi);
//        System.out.println(posj);
//        le_clic(posi+1, posj, bomb_grid, listeboutons[posi+1][posj], listeboutons, "expansion");
//        le_clic(posi+1, posj, bomb_grid, listeboutons[posi+1][posj], listeboutons, "expansion");
//        le_clic(posi+1, posj+1, bomb_grid, listeboutons[posi+1][posj+1], listeboutons, "expansion");
//        le_clic(posi, posj+1, bomb_grid, listeboutons[posi][posj+1], listeboutons, "expansion");
//        le_clic(posi-1, posj+1, bomb_grid, listeboutons[posi-1][posj+1], listeboutons, "expansion");
//        le_clic(posi-1, posj, bomb_grid, listeboutons[posi-1][posj], listeboutons, "expansion");
//        le_clic(posi-1, posj-1, bomb_grid, listeboutons[posi-1][posj-1], listeboutons, "expansion");
//        le_clic(posi, posj-1, bomb_grid, listeboutons[posi][posj-1], listeboutons, "expansion");
//        le_clic(posi+1, posj+1, bomb_grid, listeboutons[posi+1][posj-1], listeboutons, "expansion");

//        if (posi==0){
//            le_clic(posi+1, posj+1, bomb_grid, listeboutons[posi+1][posj+1], listeboutons, "expansion");
//            le_clic(posi+1, posj, bomb_grid, listeboutons[posi][posj+1], listeboutons, "expansion");
//            if(posj!=9){
//                le_clic(posi, posj+1, bomb_grid, listeboutons[posi+1][posj], listeboutons, "expansion");
//            }
//        }

    }

    int[][] generation_grille(){
        final int[][]bomb_grid= Grid.grid(10);
        return bomb_grid;
    }

    int[][] start(){
        int bomb_grid[][] = generation_grille();
        this.setContentView(R.layout.activity_demineur_play);
        return bomb_grid;
    }

    public void recommencer(){
        main();
    }

}