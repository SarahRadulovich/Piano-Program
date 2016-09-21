/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pianoprogram;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Sarah Radulovich 
 * Due Date: Jan. 26, 2016
 */
public class Staff extends JComponent {

    //The Staff class is where the X/Y coordinates of each note is stored
    //And paints everything to the centre panel
    //Here are the global varibles for each type of note
    //Their size corresponds to the max amount they can have in a 4/4 time signature
    int[][] sixteenthLocation = new int[257][2];
    int[][] eighthLocation = new int[129][2];
    int[][] quarterLocation = new int[65][2];
    int[][] halfLocation = new int[33][2];
    int[][] wholeLocation = new int[17][2];

    //the method for painting to the screen
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.setColor(Color.BLACK);
        
        //The notes are drawn based on the X and Y coordinates of the note-arrays

        //looping the quarter note array, and printing to the screen if any have been clicked
        for (int i = 0; i <= 64; i++) {
            g.drawOval(quarterLocation[i][0], quarterLocation[i][1], 15, 10);
            g.drawLine((quarterLocation[i][0] + 15), (quarterLocation[i][1] + 5), (quarterLocation[i][0] + 15), (quarterLocation[i][1] - 35));
            g.fillOval(quarterLocation[i][0], quarterLocation[i][1], 15, 10);
        }

        //looping the half note array, and printing to the screen if any have been clicked
        for (int i = 0; i <= 32; i++) {
            g.drawOval(halfLocation[i][0], halfLocation[i][1], 15, 10);
            g.drawLine((halfLocation[i][0] + 15), (halfLocation[i][1] + 5), (halfLocation[i][0] + 15), (halfLocation[i][1] - 35));
        }

        //looping the whole note array, and printing to the screen if any have been clicked
        for (int i = 0; i <= 16; i++) {
            g.drawOval(wholeLocation[i][0], wholeLocation[i][1], 15, 10);
        }
        
        //looping the eighth note array, and printing to the screen if any have been clicked
        for (int i = 0; i <= 128; i++) {
            g.drawOval(eighthLocation[i][0], eighthLocation[i][1], 15, 10);
            g.drawLine((eighthLocation[i][0] + 15), (eighthLocation[i][1] + 5), (eighthLocation[i][0] + 15), (eighthLocation[i][1] - 35));
            g.fillOval(eighthLocation[i][0], eighthLocation[i][1], 15, 10);
            g.drawArc((eighthLocation[i][0] - 37), (eighthLocation[i][1] - 45), 60, 55, 15, 25);
        }
        
        //looping the sixteenth note arrya, and printing to the scrren if any have been clicked
        for (int i = 0; i <= 256; i++) {
            g.drawOval(sixteenthLocation[i][0], sixteenthLocation[i][1], 15, 10);
            g.drawLine((sixteenthLocation[i][0] + 15), (sixteenthLocation[i][1] + 5), (sixteenthLocation[i][0] + 15), (sixteenthLocation[i][1] - 35));
            g.fillOval(sixteenthLocation[i][0], sixteenthLocation[i][1], 15, 10);
            g.drawArc((sixteenthLocation[i][0] - 29), (sixteenthLocation[i][1] - 45), 50, 55, 15, 25);
            g.drawArc((sixteenthLocation[i][0] - 29), (sixteenthLocation[i][1] - 35), 50, 55, 15, 25);
        }

        //painting the treble cleff, bass cleff and the brace to the side of the staves
        try {
            BufferedImage treble = ImageIO.read(new File("treble2.png"));
            BufferedImage bass = ImageIO.read(new File("bass-cleff.png"));
            BufferedImage brace = ImageIO.read(new File("brace.png"));
            BufferedImage piano = ImageIO.read(new File ("piano.png"));

            g.drawImage(treble, 0, 65, this);
            g.drawImage(bass, 9, 195, this);
            g.drawImage(treble, 0, 285, this);
            g.drawImage(bass, 9, 415, this);
            g.drawImage(brace, 0, 40, this);
            g.drawImage(brace, 0, 262, this);
            g.drawImage(piano, 0, 0, this);

        } catch (IOException ex) {
            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
        }

        //instead of writing a new line for every g.drawLine I'd have to write,
        //I made two arrays and looped the g.drawLine with the appropriate locations
        int[] lineSpecsX = {70, 90, 110, 130, 150,
            180, 200, 220, 240, 260,
            290, 310, 330, 350, 370,
            400, 420, 440, 460, 480};

        int[] lineSpecsY = {10, 210, 410, 610, 810,};

        //the length of the staves
        for (int i = 0; i < 20; i++) {
            g.drawLine(10, lineSpecsX[i], 810, lineSpecsX[i]);
        }

        //the bars and their heights
        for (int i = 0; i < 5; i++) {
            g.drawLine(lineSpecsY[i], 70, lineSpecsY[i], 150);
            g.drawLine(lineSpecsY[i], 180, lineSpecsY[i], 260);
            g.drawLine(lineSpecsY[i], 290, lineSpecsY[i], 370);
            g.drawLine(lineSpecsY[i], 400, lineSpecsY[i], 480);
        }

    }
    
    public void clearMouse(JButton clearBtn) {
        clearBtn.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Run gui = new Run();
                
                for (int i = 0; i < 257; i++){
                    gui.noteNames[i]=null;
                    gui.noteType=null;
                    gui.notes[i]=null;
                }
                
                for (int i = 0; i < 257; i++) {
                    sixteenthLocation[i][0] = 0;
                    sixteenthLocation[i][1] = 0;
                    
                }
                for (int i = 0; i < 128; i++) {
                    eighthLocation[i][0] = 0;
                    eighthLocation[i][1] = 0;
                }
                for (int i = 0; i < 65; i++) {
                    quarterLocation[i][0] = 0;
                    quarterLocation[i][1] = 0;
                }
                for (int i = 0; i < 33; i++) {
                    halfLocation[i][0] = 0;
                    halfLocation[i][1] = 0;
                }
                for (int i = 0; i < 17; i++) {
                    wholeLocation[i][0] = 0;
                    wholeLocation[i][1] = 0;
                }
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

    }

}
