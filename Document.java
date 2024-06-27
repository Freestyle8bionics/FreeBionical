import javax.annotation.processing.Generated;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.html.ImageView;
import javax.imageio.ImageIO;
import javax.imageio.plugins.bmp.*;
import javax.imageio.plugins.jpeg.*;
import javax.imageio.plugins.tiff.*;
import javax.imageio.stream.ImageInputStreamImpl;
import javax.sound.midi.*;
import javax.imageio.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.color.ICC_ProfileGray;
import java.awt.color.ICC_ProfileRGB;
import java.awt.color.ProfileDataException;
import java.awt.desktop.UserSessionEvent;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.font.TextAttribute;
import java.awt.font.TextHitInfo;
import java.awt.font.TextLayout.CaretPolicy;
import java.awt.font.TextMeasurer;
import java.awt.font.TransformAttribute;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.lang.ClassNotFoundException.*;
import java.applet.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.Writer;
import java.sql.*;

public class Document {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Essay");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a text area for editing
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem undoMenuItem = new JMenuItem("Undo");
        // undoMenuItem.setOnAction(event -> textArea.undo());
        // undoMenuItem.setAccelerator(javafx.scene.input.KeyCombination.keyCombination("CTRL+Z"));
        fileMenu.add(undoMenuItem);

        JMenuItem redoMenuItem = new JMenuItem("Redo");

        fileMenu.add(redoMenuItem);

        JMenuItem copyMenuItem = new JMenuItem("Copy");
        copyMenuItem.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                // textArea.copy(StoreFunc());
           } 
        });
        fileMenu.add(copyMenuItem);

        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        fileMenu.add(newMenuItem);

        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        String content = new String(Files.readAllBytes(Paths.get(selectedFile.getAbsolutePath())));
                        textArea.setText(content);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Error opening file: " + ex.getMessage());
                    }
                }
            }
        });
        fileMenu.add(openMenuItem);

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        Files.write(Paths.get(selectedFile.getAbsolutePath()), textArea.getText().getBytes());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Error saving file: " + ex.getMessage());
                    }
                }
            }
        });
        fileMenu.add(saveMenuItem);

        JMenuItem pagesetupMenuItem = new JMenuItem("Page Setup");
        // pagesetupMenuItem.addActionListener(new D)

        fileMenu.add(pagesetupMenuItem);

        JMenuItem printMenuItem = new JMenuItem("Print");
        printMenuItem.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            // Get the text to be printed
            String textToPrint = textArea.getText();

            // Create a PrinterJob object
            PrinterJob printJob = PrinterJob.getPrinterJob();

            // Set up the print dialog
            if (printJob.printDialog()) {
              try {
                // Print the text using the default page format
                printJob.print();
                JOptionPane.showMessageDialog(frame, "Printing complete!");
              } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(frame, "Error printing: " + ex.getMessage());
              }
            }
          }
        });  
        fileMenu.add(printMenuItem);

        JMenu homeMenu = new JMenu("Edit");
        JMenuItem TextfontMenuItem = new JMenuItem("Text Font");
        TextfontMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textArea.setText("");
            }
        });
        homeMenu.add(TextfontMenuItem);

        JMenuItem textcolorMenuItem = new JMenuItem("Text Colour");
        textcolorMenuItem.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // TODO Auto-generated method stub
                // stateChanged(e) {
                // int BLUECOMPONENT = 0;
                // int GREENCOMPONENT = 0;
                // int BLUECOMPONENT = 0;
                // } {
                // java.awt.color.ICC_ProfileRGB.BLUECOMPONENT;
                // java.awt.color.ICC_ProfileRGB.GREENCOMPONENT;
                // java.awt.color.ICC_ProfileRGB.REDCOMPONENT;
                // };
            }
        });
        homeMenu.add(textcolorMenuItem);

        JMenu insertMenu = new JMenu("Insert");
        JMenuItem ImageMenuItem = new JMenuItem("Images");
        ImageMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        BufferedImage image = ImageIO.read(selectedFile);
                    // Insert the image into the text area (explained below)
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Error opening image: " + ex.getMessage());
                    }
                    // Assuming 'image' is the BufferedImage from previous step



                }
            }
        });
        insertMenu.add(ImageMenuItem);

        JMenuItem tableMenuItem =new JMenuItem("Table");
        tableMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        insertMenu.add(tableMenuItem);

        JMenu artistMenu = new JMenu("Artist");


        JMenu designMenu = new JMenu("Design");

        JMenu LayoutMenu = new JMenu("Layout");

        JMenu referenceMenu = new JMenu("Reference");

        JMenu mailMenu = new JMenu("Mail");

        JMenu revieweMenu = new JMenu("Review");

        JMenu vieweMenu = new JMenu("View");

        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutMenuItem = new JMenuItem("About");

        helpMenu.add(aboutMenuItem);


        menuBar.add(fileMenu);
        menuBar.add(homeMenu);
        menuBar.add(insertMenu);
        menuBar.add(artistMenu);
        menuBar.add(designMenu);
        menuBar.add(LayoutMenu);
        menuBar.add(referenceMenu);
        menuBar.add(mailMenu);
        menuBar.add(revieweMenu);
        menuBar.add(vieweMenu);
        menuBar.add(helpMenu);


        // Add the menu bar and the text area to the frame
        frame.setJMenuBar(menuBar);
        frame.add(scrollPane);

        frame.setSize(600, 400);
        frame.setVisible(true);
        // frame.setLayout()
    }
}