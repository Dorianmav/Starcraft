package fr.milleis.behavior.impl;

import fr.milleis.Main;
import fr.milleis.behavior.Behavior;
import fr.milleis.behavior.Behaviorable;
import fr.milleis.character.Digger;

public class GoBase implements Behavior {

    Digger digger;

    @Override
    public void run(Behaviorable behaviorable) {
        digger = (Digger) behaviorable;
        if (digger.x > Main.milleis.x + 10) {
            digger.x -= 10;
        } else if (digger.x < Main.milleis.x + 10) {
            digger.x += 10;
        }
        if (digger.y > Main.milleis.y - 10) {
            digger.y -= 10;
        } else if (digger.y < Main.milleis.y - 10) {
            digger.y += 10;
        }
        if (digger.x == Main.milleis.x + 10 && digger.y == Main.milleis.y - 10) {
            behaviorable.setBehavior(new Store());
        }

    }

}