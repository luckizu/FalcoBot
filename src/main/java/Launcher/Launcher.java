/*package Launcher;


import FalcoBot.Eventi.ONOFF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
;



public  class Launcher extends JFrame implements ActionListener {


    public static void initialFrame() {
        new Launcher();


    }

    Launcher() {

        JButton Installa;
        JButton Opzioni;
        JCheckBox ONOFF;


        this.setTitle("FalcoBOt");
        this.setSize(300, 150);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setResizable(false);

        Installa = new JButton("Installa");
        Installa.setBounds(25, 60, 75, 30);
        this.add(Installa);
        Installa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                                           JFrame Installato = new JFrame("Installazione Effettuata");
                                           Installato.setBounds(300, 300, 310, 100);
                                           Installato.setLayout(null);
                                           Installato.setBackground(Color.gray);
                                           Installato.setResizable(false);


                                           Installato.setLocationRelativeTo(null);
                                           Installato.setVisible(true);


                                       }
                                   });

        Opzioni = new JButton("Opzioni");
        Opzioni.setBounds(125, 60, 90, 30);
        this.add(Opzioni);


        ONOFF = new JCheckBox("ON/OFF");
        ONOFF.setBounds(185, 10, 75, 30);
        this.add(ONOFF);

        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ONOFF.addItemListener(new ONOFF());
       /* ONOFF.addItemListener(new ItemListener()) /*{
            public void itemStateChanged(ItemEvent event) {
                boolean ONOFF = event.getStateChange() == ItemEvent.SELECTED;
                boolean Main = event.getItemSelectable() != null;
                try {
                    BotMain.BotMain(ONOFF, Main);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }


        });





    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}

*/

