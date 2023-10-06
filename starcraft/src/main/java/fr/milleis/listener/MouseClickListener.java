package fr.milleis.listener;



import fr.milleis.Main;
import fr.milleis.behavior.impl.Find;
import fr.milleis.character.BigDigger;
import fr.milleis.character.Digger;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import java.awt.MouseInfo;
import java.awt.Point;

public class MouseClickListener extends MouseAdapter {

    private JFrame jFrame;

    public MouseClickListener(JFrame frame) {
        this.jFrame = frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point pointMouse = MouseInfo.getPointerInfo().getLocation();

        if (Main.milleis.contains(pointMouse) && Main.milleis.money >= 60) {
            var bigdigger = new BigDigger();
            bigdigger.behavior = new Find();
            Main.bigWorkers.add(bigdigger);
            Main.milleis.money -= 60;
            System.out.println("New Bigminion hired");
        }

        if (Main.milleis.contains(pointMouse) && Main.milleis.money >= 30) {
            var digger = new Digger();
            digger.behavior = new Find();
            Main.workers.add(digger);
            Main.milleis.money -= 30;
            System.out.println("New minion hired");
        }
    }
}
