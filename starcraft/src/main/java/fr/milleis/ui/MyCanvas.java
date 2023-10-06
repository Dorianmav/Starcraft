package fr.milleis.ui;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import fr.milleis.Main;
import fr.milleis.character.BigDigger;
import fr.milleis.character.Digger;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MyCanvas extends JPanel {

    public BufferedImage minerImage;
    public BufferedImage bigMinerImage;

    @Override
    public void paintComponent(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());

        g.setColor(Color.BLACK);
        g.drawString("Minion: " + Main.workers.size(), 20, (Main.milleis.y + Main.milleis.height) - 10);
        g.drawString("Bigminion: " + Main.bigWorkers.size(), 20, (Main.milleis.y + Main.milleis.height) + 10);

        for (Base base : ((ArrayList<Base>) Main.bases.clone())) {
            g.setColor(Color.BLACK);
            g.drawString("Argent: " + base.money, base.x, base.y - 40);
            g.fillRect(base.x, base.y - 30, base.width, base.height);
            // System.out.println("position de la base en x: " + base.x);
        }
        int i = 1;

        for (Ore ore : ((ArrayList<Ore>) Main.ores.clone())) {
            g.setColor(Color.BLACK);
            g.drawString("Il reste " + ore.deposit + " " + ore.name + " à miner", 20, 20 * i++);

            g.setColor(ore.color);
            g.fillOval(ore.x, ore.y, ore.rayon, ore.rayon);
        }

        // Image ??
        try {
            BufferedImage originalMinerImage = ImageIO.read(new File("src\\main\\resources\\assets\\miner.PNG"));
            minerImage = resizeImage(originalMinerImage, 30, 30);

            BufferedImage originalBigMinerImage = ImageIO.read(new File("src\\main\\resources\\assets\\Bigminer.png"));
            bigMinerImage = resizeImage(originalBigMinerImage, 45, 45);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Digger dig : ((ArrayList<Digger>) Main.workers.clone())) {

            g.drawImage(minerImage, dig.x, dig.y, null);
        }

        for (BigDigger bigDigger : ((ArrayList<BigDigger>) Main.bigWorkers.clone())) {
            g.drawImage(bigMinerImage, bigDigger.x, bigDigger.y, null);
        }

        if (Main.ores.isEmpty()) {
            g.setColor(Color.WHITE);
            g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
            g.setColor(Color.GREEN);
            g.setFont(new Font("Serif", Font.BOLD, 50));
            g.drawString("Fin de la partie", (this.getWidth() / 2) - 175, (this.getHeight() / 2));
        }

    }

    public BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
        BufferedImage resizImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, width, height, null);
        g2d.dispose();
        return resizImage;
    }

}