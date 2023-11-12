package com.cs2340.armadillo.Models;

public class Coyote implements Enemy {

    private int hp;
    private int dmg;
    private final int spriteID = 1;

    private int xPos = 0;

    private int yPos = 0;

    public Coyote() {
        hp = 5;
        dmg = 1;
    }
    public void setHP(int hp) {
        this.hp = hp;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    @Override
    public int getSpriteID() {
        return spriteID;
    }

    public void move() {
        xPos++;
        yPos++;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }
}