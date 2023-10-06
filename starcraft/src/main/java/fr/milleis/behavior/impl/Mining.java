package fr.milleis.behavior.impl;

import java.util.Timer;
import java.util.TimerTask;

import fr.milleis.behavior.Behavior;
import fr.milleis.behavior.Behaviorable;
import fr.milleis.character.Digger;

public class Mining implements Behavior {

    boolean launched = false;
    Digger digger;

    @Override
    public void run(Behaviorable behaviorable) {

        digger = (Digger) behaviorable;
        if (launched)
            return;
        launched = true;
        Timer timer = new Timer();
        TimerTask dig = new TimerTask() {
            @Override
            public void run() {
                System.out.println("I've finished mining, I'm going back to base");

                behaviorable.setBehavior(new GoBase());
            }
        };
        timer.schedule(dig, 3000);
    }

}