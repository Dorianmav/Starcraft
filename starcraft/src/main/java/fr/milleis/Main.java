package fr.milleis;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Timer;
import javax.swing.JFrame;

import fr.milleis.behavior.impl.Find;
import fr.milleis.character.BigDigger;
import fr.milleis.character.Digger;
import fr.milleis.listener.MouseClickListener;
import fr.milleis.ui.Base;
import fr.milleis.ui.MyCanvas;
import fr.milleis.ui.Ore;

public class Main {
    public static JFrame jFrame;

    public static MyCanvas myCanvas;

    public static ArrayList<Digger> workers = new ArrayList<>();
    public static ArrayList<BigDigger> bigWorkers = new ArrayList<>();

    public static ArrayList<Ore> ores = new ArrayList<>();

    public static ArrayList<Base> bases = new ArrayList<>();

    public static int frameHeight;
    public static int frameWidth;

    public static Base milleis;

    public static Timer timer;

    public static Thread thread;

    public static void main(String[] args) {

        jFrame = new JFrame("Starcraft");
        myCanvas = new MyCanvas();

        frameWidth = 760;
        frameHeight = 660;

        jFrame.setSize(frameWidth, frameHeight);
        jFrame.setContentPane(myCanvas);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MouseClickListener mouseClickListener = new MouseClickListener(jFrame);
        jFrame.addMouseListener(mouseClickListener);

        

        milleis = new Base(20, (frameHeight / 2) - 30, 50, 50);

        bases.add(milleis);

        Ore or = new Ore("or", 700, 100, Color.YELLOW);
        Ore rubis = new Ore("rubis", 500, 290, Color.red);
        Ore saphir = new Ore("Saphir", 100, 450, Color.blue);
        Ore emerald = new Ore("Emeraude", 450, 550, Color.green);

        ores.add(or);
        ores.add(rubis);
        ores.add(saphir);
        ores.add(emerald);

        Digger arthur = new Digger(70, (milleis.y - 30));

        workers.add(arthur);

        arthur.behavior = new Find();

        new Thread(new Runnable() {

            @Override
            public void run() {

                while (true) {

                    for (Digger digger : (ArrayList<Digger>) workers.clone()) {
                        digger.behavior.run(digger);
                    }
                    for (BigDigger bigDigger : (ArrayList<BigDigger>) bigWorkers.clone()) {
                        bigDigger.behavior.run(bigDigger);
                    }
                    try {
                        Thread.sleep(10);

                        myCanvas.repaint();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }).start();
        

    }
}