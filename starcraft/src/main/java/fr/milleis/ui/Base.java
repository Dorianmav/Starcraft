package fr.milleis.ui;

import java.awt.Rectangle;

import fr.milleis.Main;
import fr.milleis.character.Digger;

public class Base extends Rectangle {
    public int money;

    public Base(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.money = 0;
    }

    public void hireDigger() {
        var digger = new Digger();
        Main.workers.add(digger);
        money -= 30;
    }

}