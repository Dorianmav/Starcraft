package fr.milleis.character;

import fr.milleis.Main;
import fr.milleis.behavior.Behavior;

public class BigDigger extends Digger {

    public BigDigger() {
        this.x = Main.milleis.x + 50;
        this.y = Main.milleis.y;
        this.r = 40;
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