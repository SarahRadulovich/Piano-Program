/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pianoprogram;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
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
public class Run {

    //JFrame is global
    //So is a string called noteType
    //This varible changes as the user changes which notes they want
    String noteType;
    JFrame frame = new JFrame();
    String noteNames[] = new String[257];
    String[] notes = new String[257];

    //the centre method in this class
    public void createAndShowGUI() {
        //Staff is the paintConponent class that draws the staves
        Staff staff = new Staff();

        //two panels, one at the top of the frame, one at the botton
        JPanel upperPanel = new JPanel();
        JPanel lowerPanel = new JPanel();

        //The buttons for the user experience
        JButton helpBtn = new JButton("Instructions");
        JButton playBtn = new JButton("Play");
        JButton clearBtn = new JButton("Next");
        JButton screenshot = new JButton("Save Your Work");
        JLabel helpLabel = new JLabel("Click the note you want, then click the staff where you want to place your notes.");

        //Just adding a blank label to correctly space the frame
        JLabel label = new JLabel("             ");

        //Note type buttons
        JButton sixteenthNote = new JButton("Sixteenth Note");
        JButton eighthNote = new JButton("Eighth Note");
        JButton quarterNote = new JButton("Quarter Note");
        JButton halfNote = new JButton("Half Note");
        JButton wholeNote = new JButton("Whole Note");

        //MouseListener for saving the user's process
        //see ScreenshotMouseListener
        //see the methods down below
        //these are the MouseListeners for the note buttons
        sixteenthMouse(sixteenthNote);
        eighthMouse(eighthNote);
        quarterMouse(quarterNote);
        halfMouse(halfNote);
        wholeMouse(wholeNote);
        screenshotMouse(screenshot);

        //the MouseListener for the staff
        staff.addMouseListener(new MouseListener() {
            int a = 0;

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                SoundFileNames filepath = new SoundFileNames();
                //When the user clicks a note type button they assign the String noteType a name
                //if the name corresponds to the correct one, this MouseListener will send the X and Y coordinates
                //to the staff class and will repaint the screen to show it
                // int a is only used to count how many clicks the user has had
                a++;
                if ("sixteenth".equals(noteType)) {
                    if (a > 0) {
                        staff.sixteenthLocation[a][0] = e.getX();
                        staff.sixteenthLocation[a][1] = e.getY();
                        staff.repaint();

                        noteNames[a] = "sixteenth";
                        notes = filepath.soundFileNames(notes, a, e.getY());
                    }
                }
                if ("eighth".equals(noteType)) {
                    if (a > 0) {
                        staff.eighthLocation[a][0] = e.getX();
                        staff.eighthLocation[a][1] = e.getY();
                        staff.repaint();

                        noteNames[a] = "eighth";
                        notes = filepath.soundFileNames(notes, a, e.getY());
                    }
                }
                if ("quarter".equals(noteType)) {
                    if (a > 0) {
                        staff.quarterLocation[a][0] = e.getX();
                        staff.quarterLocation[a][1] = e.getY();
                        staff.repaint();
                        noteNames[a] = "quarter";
                        filepath.soundFileNames(notes, a, e.getY());

                    }
                }
                if ("half".equals(noteType)) {
                    if (a > 0) {
                        staff.halfLocation[a][0] = e.getX();
                        staff.halfLocation[a][1] = e.getY();
                        staff.repaint();

                        noteNames[a] = "half";
                        notes = filepath.soundFileNames(notes, a, e.getY());
                    }
                }
                if ("whole".equals(noteType)) {
                    if (a > 0) {
                        staff.wholeLocation[a][0] = e.getX();
                        staff.wholeLocation[a][1] = e.getY();
                        staff.repaint();

                        noteNames[a] = "whole";
                        notes = filepath.soundFileNames(notes, a, e.getY());
                    }
                }

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
        //The MouseListener for the play button
        staff.clearMouse(clearBtn);
        playMouse(playBtn);
        

        //setting the layout for the whole frame
        frame.setLayout(new BorderLayout());

        //setting the layout for both panels
        upperPanel.setLayout(new FlowLayout());
        lowerPanel.setLayout(new FlowLayout());

        //adding the user buttons to upper panel
        upperPanel.add(playBtn);
        upperPanel.add(clearBtn);
        upperPanel.add(screenshot);
        upperPanel.add(helpLabel);

        //adding the note buttons to lower panel
        lowerPanel.add(sixteenthNote);
        lowerPanel.add(eighthNote);
        lowerPanel.add(quarterNote);
        lowerPanel.add(halfNote);
        lowerPanel.add(wholeNote);

        //adding the panels to different parts of the frame
        frame.add(staff, BorderLayout.CENTER);
        frame.add(upperPanel, BorderLayout.PAGE_START);
        frame.add(lowerPanel, BorderLayout.PAGE_END);
        frame.add(label, BorderLayout.LINE_START);

        //organizing my frame attributes
        frame.setSize(950, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    //Here are the methods for the MouseListeners
    public void playMouse(JButton playBtn) {
        playBtn.addMouseListener(new MouseListener() {
            Audio audio = new Audio();

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

                for (int i = 0; i < notes.length; i++) {

                    if (notes[i] != null) {

                        if ("quarter".equals(noteNames[i])) {

                            try {

                                audio.playSound(notes[i], 250);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        if ("half".equals(noteNames[i])) {
                            try {
                                audio.playSound(notes[i], 500);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        if ("whole".equals(noteNames[i])) {
                            try {
                                audio.playSound(notes[i], 1000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        if ("eighth".equals(noteNames[i])) {
                            try {
                                audio.playSound(notes[i], 125);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        if ("sixteenth".equals(noteNames[i])) {
                            try {
                                audio.playSound(notes[i], 62);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } else {

                    }
                }
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

    public void sixteenthMouse(JButton sixteenthNote) {
        //adding a new MouseListener for the sixteenth note
        //When the mouse is pressed, noteType changes to the appropriate note type.
        sixteenthNote.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                noteType = "sixteenth";
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

    public void eighthMouse(JButton eighthNote) {
        //adding a new MouseListener for the eighth note
        //When the mouse is pressed, noteType changes to the appropriate note type.
        eighthNote.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                noteType = "eighth";
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

    public void quarterMouse(JButton quarterNote) {
        //adding a new MouseListener for the quarter note
        //When the mouse is pressed, noteType changes to the appropriate note type.
        quarterNote.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                noteType = "quarter";
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

    public void halfMouse(JButton halfNote) {
        //adding a new MouseListener for the half note
        //When the mouse is pressed, noteType changes to the appropriate note type.
        halfNote.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                noteType = "half";
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

    public void wholeMouse(JButton wholeNote) {
        //adding a new MouseListener for the whole note
        //When the mouse is pressed, noteType changes to the appropriate note type.
        wholeNote.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                noteType = "whole";
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

    public void screenshotMouse(JButton screenshot) {
        
        screenshot.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                try {
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            ImageIO.write(screenFullImage, "jpg", new File("D:\\screenshot.jpg"));

            System.out.println("A full screenshot saved!");
        } catch (AWTException | IOException ex) {
            System.err.println(ex);
        }

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
