package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Backgroun {

    public Backgroun() {

        if (!SystemTray.isSupported()) {
            System.out.println("non supportato");
            return;
        }

        final PopupMenu popum = new PopupMenu();
        final TrayIcon icon =
                new TrayIcon(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir") + "\\falcobot.png"));
        final SystemTray tray = SystemTray.getSystemTray();
        MenuItem exit = new MenuItem("Chiudi");

        popum.add(exit);
        icon.setPopupMenu(popum);
        try {
            tray.add(icon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }

        icon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "FalcoBot Operativo");
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tray.remove(icon);
                System.exit(0);
            }
        });


    }

    protected static Image createImage(String path, String description) {
        URL imageURL = Main.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Risorsa non trovata: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }

    }
}
