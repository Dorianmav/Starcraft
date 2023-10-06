package fr.milleis.ui;

import java.awt.Color;

public class Ore {

    public String name;
    public int x;
    public int y;
    public Color color; 

    public int rayon;
    public int deposit;
    public int coin;
    public int occupant;



    public Ore(String name, int x, int y, Color color) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.color = color;
        this.rayon = 10 + (int)(Math.random() * 60 - 10);
        this.deposit = 10;
        this.coin = 10;
        this.occupant = 0;
    }

    
    public boolean isWorth(){
        boolean itIs = false;
        while(deposit != 0){
            itIs = true;
        }
        return itIs;
    }

    public boolean isFull(){
        return occupant == 1;
    }
    

}