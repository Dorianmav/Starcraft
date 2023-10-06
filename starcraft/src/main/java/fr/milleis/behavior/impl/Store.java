package fr.milleis.behavior.impl;

import java.util.Timer;
import java.util.TimerTask;

import fr.milleis.Main;
import fr.milleis.behavior.Behavior;
import fr.milleis.behavior.Behaviorable;
import fr.milleis.character.Digger;

public class Store implements Behavior {

    boolean launched = false;
    Digger digger;

    @Override
    public void run(Behaviorable behaviorable) {
        digger = (Digger) behaviorable;
        if (launched)
            return;
        launched = true;
        Timer timer = new Timer();
        TimerTask store = new TimerTask() {
            @Override
            public void run() {
                Main.milleis.money += 10;
                System.out.println(digger.target.name + " deposited");

                behaviorable.setBehavior(new Find());
            }
        };
        timer.schedule(store, 2000);

    }

}