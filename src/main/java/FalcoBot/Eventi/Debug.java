package FalcoBot.Eventi;

import Database.*;
import FalcoBot.Comandi.CreateEMB;
import Ranking.LVLUP;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Debug extends ListenerAdapter {
    private String[] Messaggio;
    private String Membro;
    private int lvl;
    private List<Utenti> Membri = new ArrayList<>();
    private int cout = 0;
    private String id;
    private int EXP;
    private String Nome;
    private int MaxExp;
    private String Ruolo;
    private Boolean ca;

    public void onPrivateMessageReceived(PrivateMessageReceivedEvent e) {
        if (e.getAuthor().getName().equals("Luckizu")) {
            Messaggio = e.getMessage().getContentRaw().split(" ");
            if (Messaggio[1].equals(null)) {
                e.getChannel().sendMessage("Manca il nome utente");
            } else {
                Membro = Messaggio[1];
                switch (Messaggio[0]) {

                    case "reset":
                        Reset(Membro);


                        e.getChannel().sendMessage("Utente" + "resettato").queue();
                        return;
                    case "add":
                        if (Messaggio.length <2) {
                            e.getChannel().sendMessage("Mancanza esperienza").queue();
                            return;
                        } else {
                            Add(Membro, Integer.parseInt(Messaggio[2]));
                            e.getChannel().sendMessage("Esperienza aggiunta a " + Membro).queue();
                            return;
                        }

                    case "remove":
                        if (Messaggio.length <2) {
                            e.getChannel().sendMessage("Mancanza esperienza").queue();
                            return;
                        } else {
                            Remove(Membro, Integer.parseInt(Messaggio[2]));
                            e.getChannel().sendMessage("Esperienza aggiunta a " + Membro).queue();
                            return;
                        }


                    case "stat":

                        List<String> Field = new ArrayList<>();
                        Field.addAll(new CreateEMB(Membro).GetEMBauto());
                        EmbedBuilder Em = new EmbedBuilder();
                        Em.setTitle(Field.get(0));
                        Em.setColor(0x3333ff);
                        Em.addField(new MessageEmbed.Field(Field.get(1), Field.get(2), true));
                        Em.addField(new MessageEmbed.Field(Field.get(3), Field.get(4), true));
                        Em.addField(new MessageEmbed.Field(Field.get(5), Field.get(6), true));
                        Em.addField(new MessageEmbed.Field(Field.get(7), Field.get(8), true));
                        Em.addField(new MessageEmbed.Field(Field.get(9), Field.get(10), true));
                        e.getChannel().sendMessage(Em.build()).queue();
                        return;
                }
            }

        }
    }

    public void Reset(String Nome) {

        try {
            System.out.println("Aggiornamento");
            FileInputStream File = new FileInputStream(new DatabasePath().getPath());

            ObjectInputStream IN = new ObjectInputStream(File);

            for (int x = 0; x < File.available(); x++) {

                this.Membri.add((Utenti) IN.readObject());
                if (Membri.get(x).Nome.equals(Nome)) {
                    System.out.println(Membri.get(x).Nome + " ottenimento");
                    this.id = Membri.get(x).id;
                    this.cout = x;
                }

            }
            IN.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        this.Membri.set(cout, new Utenti(Nome, id, "ChinaAuuupa", 1, 0));

        try {
            FileOutputStream File1 = new FileOutputStream(new DatabasePath().getPath());
            ObjectOutputStream Out = new ObjectOutputStream(File1);
            System.out.println(Membri.get(cout).experienza + " esp cout " + cout);
            Out.flush();

            for (int x = 0; x < Membri.size(); x++) {
                System.out.println(Membri.get(x).Nome);
                Out.writeObject(Membri.get(x));


            }

            Out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void Add(String Nome, int esp) {
        OttenimentoUtenti OU = new OttenimentoUtenti(Nome);
        this.lvl = OU.getLvl();
        this.EXP = OU.getexp() + esp;
        this.ca = true;
        this.Nome = Nome;

        OttenimentoLivelli OL = new OttenimentoLivelli(lvl);


        this.MaxExp = OL.getMaxExp();
        this.id = OU.getid();
        this.Ruolo = OL.getRuolo();
        System.out.println("Partito add");

        while (this.ca) {
            LVLUP Up = new LVLUP(lvl, EXP, MaxExp);

            if (Up.getSalito() & lvl != 30) {
                System.out.println("Cc");
                this.EXP = Up.getExpSup();
                System.out.println("Salito");
                System.out.println(EXP + "aggiuntiva");
                this.lvl++;
                OttenimentoLivelli OT = new OttenimentoLivelli(lvl);
                if (EXP > OT.getMaxExp()) {
                    this.ca = true;
                } else {
                    AggiornamentoUtente ag = new AggiornamentoUtente(Nome, id, OT.getRuolo(), lvl, EXP);
                    System.out.println(OT.getRuolo() != Ruolo);
                    this.ca = false;
                }

            } else {
System.out.println("Cc");
                if (lvl == 30) {
                    System.out.println("Cap Massimo");

                    AggiornamentoUtente AG = new AggiornamentoUtente(Nome, id, Ruolo, lvl, MaxExp);
                    this.ca = false;

                } else {
                    System.out.println("Cap non massimo");
                    AggiornamentoUtente AG = new AggiornamentoUtente(Nome, id, Ruolo, lvl, EXP);
                    this.ca = false;
                }

            }

        }
    }
    private void Remove(String Nome, int esp) {
        OttenimentoUtenti OU = new OttenimentoUtenti(Nome);
        this.lvl = OU.getLvl();
        this.EXP = OU.getexp();
            if(EXP < esp){
                this.EXP = esp - EXP;
                this.lvl--;
                if(EXP < new OttenimentoLivelli(lvl).getMaxExp()){
                    this.EXP = new OttenimentoLivelli(lvl).getMaxExp() - EXP;
                } else if(EXP > esp){
                while (EXP> new OttenimentoLivelli(lvl).getMaxExp()) {
                    this.EXP = EXP - new OttenimentoLivelli(lvl).getMaxExp();
                    this.lvl--;

                }
            }else {

                    this.EXP = esp - EXP;
                }

        } else {
                this.EXP = EXP - esp;
            }

        this.Nome = Nome;

        OttenimentoLivelli OL = new OttenimentoLivelli(lvl);


        this.MaxExp = OL.getMaxExp();
        this.id = OU.getid();
        this.Ruolo = OL.getRuolo();
        System.out.println("Partito add");


                    AggiornamentoUtente ag = new AggiornamentoUtente(Nome, id, Ruolo, lvl, EXP);


            }

        }



