package fr.milleis.behavior.impl;

import java.util.ArrayList;

import fr.milleis.Main;
import fr.milleis.behavior.Behavior;
import fr.milleis.behavior.Behaviorable;
import fr.milleis.character.Digger;
import fr.milleis.ui.Ore;

public class Find implements Behavior{

    Digger digger;

     @Override
    public void run(Behaviorable behaviorable) {
        digger = (Digger) behaviorable;
        
        System.out.println("I'm looking for an ore");
        Ore nearestOre = findNearPoint((ArrayList<Ore>) Main.ores.clone(), digger);

        if (nearestOre != null) {
            System.out.println("Find! Nearest point: (" + nearestOre.name + " at " + nearestOre.x + ", " + nearestOre.y + ") I'm going to mine");
            digger.target = nearestOre;
            behaviorable.setBehavior(new GoWork());

        } else {
            System.out.println("No points in the array.");
        }
        
    }


    public static Ore findNearPoint(ArrayList<Ore> arrayList, Digger targePoint){
        if(arrayList == null || arrayList.isEmpty()){
            return null;
        }

        Ore nearestOre = arrayList.get(0);
        double minDistance = distance(nearestOre, targePoint);

        for(Ore ore : arrayList){
            double currentDistance = distance(ore, targePoint);
            if(currentDistance < minDistance){
                minDistance = currentDistance;
                nearestOre = ore;
            }
        }

        return nearestOre;
    }

    private static double distance(Ore p1, Digger p2){
        int dx = p2.x - p1.x;
        int dy =p2.y - p1.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    
}