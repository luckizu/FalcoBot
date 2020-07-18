package FalcoBot.Eventi;

import Database.OttenimentoUtenti;
import Database.Utenti;
import FalcoBot.Comandi.Comandi;
import Ranking.AddExpTxt;
import javafx.concurrent.Task;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class RecieveMessage  extends ListenerAdapter {
    String Utente;
    Map<String, Integer> counter = new HashMap<>();
    Boolean cs = false;
    List<String> Membri = new ArrayList<>();
    Timer time;
    TimerTask task;


    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        if (e.getAuthor().isBot()) {
        } else if (e.getMessage().getContentRaw().equals("/help") || e.getMessage().getContentRaw().equals("/stat")) {

        } else {
            System.out.println("Messaggio ricevuto");
            this.Utente = e.getAuthor().getName();
            Boolean nope = false;
            if (cs) {

                for(int x = 0; x< Membri.size(); x++){
                    if(Membri.get(x).equals(Utente)){
                      int z = counter.get(Utente) + 1;
                        counter.replace(Utente, z);
                        nope = true;
                    }

                }
                if(nope){
                } else {
                    Membri.add(Utente);
                    counter.put(Utente, 1);
                }

            } else {
                Start();
                this.cs = true;
                this.counter.put(Utente, 1);
                this.Membri.add(Utente);
            }
            if (counter.get(Utente) <= 3) {
                AddExpTxt Add = new AddExpTxt(this.Utente);

                if (Add.getLivellato()) {
                    OttenimentoUtenti UT = new OttenimentoUtenti(Utente);
                    EmbedBuilder Em = new EmbedBuilder();
                    if (Add.getCambioRuolo()) {
                        Em.setTitle(Utente + " é salito di livello");
                        Em.setDescription(Utente + " è salito al livello " + UT.getLvl() + " adesso sei un " + UT.getRuolo());
                        Em.setColor(0x3333ff);
                        e.getGuild().getDefaultChannel().sendMessage(Em.build()).queue();
                        List<Message> ms = e.getChannel().getHistory().retrievePast(1).complete();
                        ms.get(0).delete().queueAfter(10, TimeUnit.SECONDS);

                    } else {
                        Em.setTitle(Utente + " é salito di livello");
                        Em.setDescription(Utente + " è salito al livello " + UT.getLvl());
                        Em.setColor(0x3333ff);
                          e.getGuild().getDefaultChannel().sendMessage(Em.build()).queue();
                        List<Message> ms = e.getChannel().getHistory().retrievePast(1).complete();
                        ms.get(0).delete().queueAfter(10, TimeUnit.SECONDS);

                    }

                }


            }
        }
    }

    private void Start(){
        time = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
               Membri.clear();
               counter.clear();
               time.cancel();
               cs = false;
            }
        };

        time.scheduleAtFixedRate(task, 60000,60000);
        }



    }

