package Main;

import FalcoBot.Comandi.AccessoTemporaneo;
import FalcoBot.Comandi.RicevimentoComandi;
import FalcoBot.Eventi.*;
import FalcoBot.SetBot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
//import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class BOTmain extends JDABuilder {
    String Titolo;
    String Nome;
    String Descrizione;
    int Livello;
    String Ruolo;
    JDA FalcoBot;
    TimerTask task;
    Timer timer;
    Boolean lc;
    Boolean active = false;
    Message ms;
    List<String> Messaggi = new ArrayList<>();
    Guild guild;
    TextChannel channel;
    public BOTmain() {


        try {
            FalcoBot = new JDABuilder(new SetBot().GetBotToken()).build();


            FalcoBot.addEventListener(new Voice());
            FalcoBot.addEventListener(new AccessoTemporaneo());
            FalcoBot.addEventListener(new Join());
            FalcoBot.addEventListener(new EntrataVocale());
            FalcoBot.addEventListener(new Leave());
            FalcoBot.getPresence().setStatus(OnlineStatus.ONLINE);
            FalcoBot.addEventListener(new RicevimentoComandi());
            FalcoBot.getPresence().setActivity(Activity.listening("Volando sopra i cieli"));
            FalcoBot.addEventListener(new Debug());
            FalcoBot.addEventListener(new ControlloUtenti());
            FalcoBot.addEventListener(new RecieveMessage());

            guild = FalcoBot.getGuildById("570173312051970050");
            timer = new Timer();
            task = new TimerTask() {
                @Override
                public void run() {
                    lc = Lettura();
                    if (lc) {
                        EmbedBuilder EN = new EmbedBuilder();
                        System.out.println(Titolo);
                        EN.setTitle(Titolo);
                        System.out.println(Descrizione);
                        EN.setDescription(Descrizione);
                        EN.setColor(0x3333ff);


                        guild.getDefaultChannel().sendMessage(ms).queue();
                        List<Message> ms = guild.getDefaultChannel().getHistory().retrievePast(1).complete();
                        ms.get(0).delete().queueAfter(10, TimeUnit.SECONDS);




                    }
                }
            };

            timer.scheduleAtFixedRate(task, 15000, 15000);


        } catch (LoginException e) {
            System.out.println("errore");
        }
    }

        public Boolean Lettura () {
            File file = new File("C:\\Users\\luckizu\\Documents\\FalcoBot\\caso.dat");
            if (file.exists()) {

                try {
                    FileInputStream File = new FileInputStream(file);
                    ObjectInputStream IN = new ObjectInputStream(File);

                    this.Nome = IN.readUTF();
                    System.out.println(Nome);
                    this.Livello = Integer.parseInt(IN.readUTF());
                    System.out.println(Livello);
                    this.Titolo = Nome + " è salito di livello";
                    if (Livello == 6 || Livello == 11 || Livello == 16 || Livello == 21 || Livello == 26 || Livello == 31 || Livello == 36 || Livello == 41 || Livello == 46 || Livello == 51 || Livello == 56 || Livello ==61 || Livello == 66 || Livello == 71 || Livello== 76 || Livello==81 || Livello== 86 || Livello == 91 || Livello == 96 || Livello == 100) {
                        this.Ruolo = IN.readUTF();
                        this.Descrizione = Nome + " è salito al livello " + Livello + " adesso sei un " + Ruolo;
                        IN.close();
                        file.delete();
                    } else {
                        this.Descrizione = Nome + " è salito al livello " + Livello;
                        IN.close();
                        file.delete();
                    }
                    file.delete();
                } catch (FileNotFoundException e) {

                } catch (IOException e) {

                }

                return true;
            } else {


                return false;
            }
        }
    }









