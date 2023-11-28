package com.cs2340.armadillo.View;

import static com.cs2340.armadillo.Models.MapLayout.mapNum;

import android.media.Image;
import android.widget.ImageView;

import com.cs2340.armadillo.Models.Enemies;
import com.cs2340.armadillo.Models.MapLayout;
import com.cs2340.armadillo.Models.Player;
import com.cs2340.armadillo.Models.PlayerT;

public class MoveUp implements Direction {
    MapLayout map = new MapLayout(mapNum);
    int[][] layout = map.getLayout();

    public void move(Player player, Enemies enemies) {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 28; j++) {
                System.out.print(layout[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println("player coords: (" + player.getX() + ", " + player.getY() + ")");

        if (player.playerCanMove(0, layout)){
            player.changeYPos(0, -player.getSpeed());

            for (int i = 0; i < enemies.getEnemyList().size(); i = i + 1) {
                EnemyView enemy = enemies.findE(i);
                enemy.moveEnemy(enemy, player, layout);
            }
        }
        if ((player.getX() >= 700 && player.getX() < 732)
                && (player.getY() >= 700 && player.getY() <= 732)
        ) {
            if (player.getPowerupID() == 1) {
                player.setHP(30);
            } else if (player.getPowerupID() == 2) {
                player.setSpeed(30);
            } else if (player.getPowerupID() == 3) {
                player.setSprite((player.getSpriteID() + 1)%3);
            }
        }
    }
//    public void move(PlayerT player) {
//        player.changePos(0, -20);
//    }
}
