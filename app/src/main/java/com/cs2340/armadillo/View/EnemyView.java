package com.cs2340.armadillo.View;


import android.content.Context;

import androidx.appcompat.widget.AppCompatImageView;

import com.cs2340.armadillo.Models.*;
import com.cs2340.armadillo.R;

public class EnemyView extends AppCompatImageView {
    Enemy enemy;
    private float enemyX;
    private float enemyY;
    private boolean rightTrue;
    private boolean upTrue;
    private static final int enemyWidth = 32;
    private static final int enemyHeight = 32;
    public EnemyView (Context context, Enemy enemy, float xPos, float yPos) {
        super(context);
        this.enemy = enemy;
        setSprite(this.enemy.getSpriteID());

        this.enemyX = xPos;
        this.enemyY = yPos;

        this.setX(this.enemyX);
        this.setY(this.enemyY);

        this.rightTrue = true;
        this.upTrue = true;

        this.setMaxHeight(40);
        this.setMaxWidth(50);
    }

    public float getX() {
        return this.enemyX;
    }

    public float getY() {
        return this.enemyY;
    }

    public void changeX(float x) {
        if (this.enemyX < 10) {
            this.enemyX = 10;
        } else if (this.enemyX > 1310) {
            this.enemyX = 1310;
        } else {
            this.enemyX = enemyX + x;
        }

        this.setX(this.enemyX);
    }
    public void changeY(float y) {
        if (this.enemyY < 10) {
            this.enemyY = 10;
        } else if (this.enemyY > 2760) {
            this.enemyY = 2760;
        } else {
            this.enemyY = enemyY + y;
        }

        this.setY(this.enemyY);
    }

    public void switchRight() {
        if (this.rightTrue) {
            this.rightTrue = false;
        } else {
            this.rightTrue = true;
        }
    }

    public void switchUp() {
        if (this.upTrue) {
            this.upTrue = false;
        } else {
            this.upTrue = true;
        }
    }

    public boolean enemyCanMove(int direction, int[][] layout) {
        switch(direction) {
            case 0:
                if (layout[(int)Math.floor((enemyY-20)/100)][(int)Math.floor((enemyX/100))] > 0) {
                    return false;
                }

                break;
            case 1:
                if (layout[(int)Math.floor(((enemyY+enemyHeight+21)/100))][(int)Math.floor(enemyX/100)] > 0) {
                    return false;
                }

                break;
            case 2:
                if (layout[(int)Math.floor(enemyY/100)][(int)Math.floor((enemyX-20)/100)] > 0) {
                    return false;
                }

                break;
            case 3:
                if (layout[(int)Math.floor(enemyY/100)][(int)Math.floor((enemyX+enemyWidth+20)/100)] > 0) {
                    return false;
                }

                break;
        }
        return true;
    }

    public void moveEnemy(EnemyView enemyEntity, int[][] layout) {
        switch (enemyEntity.enemy.getSpriteID()) {
            case 1:
                if (enemyEntity.rightTrue) {
                    // check if hit wall
                    if(enemyEntity.enemyCanMove(3, layout)) {
                        // move enemy right
                        enemyEntity.changeX(20);
                    } else {
                        enemyEntity.switchRight(); // changes direction to left (rightTrue = false)
                    }
                } else {
                    if(enemyEntity.enemyCanMove(2, layout)) {
                        enemyEntity.changeX(-20);
                    } else {
                        enemyEntity.switchRight(); // changes direction to left (rightTrue = true)
                    }
                }
        }
    }

    public void setSprite(int sprite) {
        if (sprite == 1) {
            this.setImageResource(R.drawable.coyote);
        } else if (sprite == 2) {
            this.setImageResource(R.drawable.coyote);
        } else {
            this.setImageResource(R.drawable.coyote);
        }
    }
}