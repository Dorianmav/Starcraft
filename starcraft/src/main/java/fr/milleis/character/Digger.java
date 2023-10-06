package fr.milleis.character;

import fr.milleis.Main;
import fr.milleis.behavior.Behavior;
import fr.milleis.behavior.Behaviorable;
import fr.milleis.ui.Ore;

public class Digger implements Behaviorable {

    public Behavior behavior;

    public int x;
    public int y;
    public int r;

    public Ore target;

    public Digger(int x, int y) {
        this.x = x;
        this.y = y;
        this.r = 20;
        this.target = null;
    }

    public Digger() {
        this.x = Main.milleis.x + 50;
        this.y = Main.milleis.y;
        this.r = 20;
        this.target = null;
    }

    @Override
    public Behavior getBehavior() {
        return behavior;
    }

    @Override
    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

}