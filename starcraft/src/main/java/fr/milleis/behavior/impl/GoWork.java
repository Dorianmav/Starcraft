package fr.milleis.behavior.impl;

import fr.milleis.Main;
import fr.milleis.behavior.Behavior;
import fr.milleis.behavior.Behaviorable;
import fr.milleis.character.Digger;

public class GoWork implements Behavior {

    Digger digger;

    @Override
    public void run(Behaviorable behaviorable) {
        digger = (Digger) behaviorable;

        if (digger.x > digger.target.x) {
            digger.x -= 10;
        } else if (digger.x < digger.target.x) {
            digger.x += 10;
        }
        if (digger.y > digger.target.y) {
            digger.y -= 10;
        } else if (digger.y < digger.target.y) {
            digger.y += 10;
        }
        if (digger.x == digger.target.x && digger.y == digger.target.y) {
          
            digger.target.deposit--;

            if (digger.target.deposit <= 0) {
                Main.ores.remove(digger.target);
            }

            behaviorable.setBehavior(new Mining());
        }

    }

}