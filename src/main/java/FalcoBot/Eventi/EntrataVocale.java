package FalcoBot.Eventi;

import Database.OttenimentoUtenti;
import Ranking.AddExpTxt;
import Ranking.AddExpVoice;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;



public class EntrataVocale extends ListenerAdapter {
    int count;
    int c;
    int exp;
    List<String> Utente = new ArrayList<>();
    Timer timer = new Timer();

  /*  public void onGuildVoiceJoin(GuildVoiceJoinEvent e) {

        this.Utente.add(e.getMember().getEffectiveName()) ;



        TimerTask task = new TimerTask() {
            public void run() {
                count++;
                c++;
                System.out.println("Timer " + Utente);
                if (count < 1200) {
                    exp = 1;
                    if (c == 4) {
                        c = 0;
                        AddExpVoice Add = new AddExpVoice(Utente.get(), exp);
                        if (Add.getLivellato()) {
                            OttenimentoUtenti UT = new OttenimentoUtenti(Utente);
                            EmbedBuilder Em = new EmbedBuilder();
                            if (Add.getCambioRuolo()) {
                                Em.setTitle(Utente + " é salito di livello");
                                Em.setDescription(Utente + " è salito al livello " + UT.getLvl() + " adesso sei un " + UT.getRuolo());
                                Em.setColor(0x3333ff);
                                e.getGuild().getDefaultChannel().sendMessage(Em.build()).queue();


                            } else {
                                Em.setTitle(Utente + " é salito di livello");
                                Em.setDescription(Utente + " è salito al livello " + UT.getLvl());
                                Em.setColor(0x3333ff);
                                e.getGuild().getDefaultChannel().sendMessage(Em.build()).queue();


                            }

                        }
                    }


                } else if (count < 2400) {
                    exp = 2;
                    if (c == 4) {
                        c = 0;
                        AddExpVoice Add = new AddExpVoice(Utente, exp);
                        if (Add.getLivellato()) {
                            OttenimentoUtenti UT = new OttenimentoUtenti(Utente);
                            EmbedBuilder Em = new EmbedBuilder();
                            if (Add.getCambioRuolo()) {
                                Em.setTitle(Utente + " é salito di livello");
                                Em.setDescription(Utente + " è salito al livello " + UT.getLvl() + " adesso sei un " + UT.getRuolo());
                                Em.setColor(0x3333ff);
                                e.getGuild().getDefaultChannel().sendMessage(Em.build()).queue();


                            } else {
                                Em.setTitle(Utente + " é salito di livello");
                                Em.setDescription(Utente + " è salito al livello " + UT.getLvl());
                                Em.setColor(0x3333ff);
                                e.getGuild().getDefaultChannel().sendMessage(Em.build()).queue();


                            }

                        }
                    }
                } else if (count < 3600) {
                    exp = 3;
                    if (c == 4) {
                        c = 0;
                        AddExpVoice Add = new AddExpVoice(Utente, exp);
                        if (Add.getLivellato()) {
                            OttenimentoUtenti UT = new OttenimentoUtenti(Utente);
                            EmbedBuilder Em = new EmbedBuilder();
                            if (Add.getCambioRuolo()) {
                                Em.setTitle(Utente + " é salito di livello");
                                Em.setDescription(Utente + " è salito al livello " + UT.getLvl() + " adesso sei un " + UT.getRuolo());
                                Em.setColor(0x3333ff);
                                e.getGuild().getDefaultChannel().sendMessage(Em.build()).queue();


                            } else {
                                Em.setTitle(Utente + " é salito di livello");
                                Em.setDescription(Utente + " è salito al livello " + UT.getLvl());
                                Em.setColor(0x3333ff);
                                e.getGuild().getDefaultChannel().sendMessage(Em.build()).queue();


                            }

                        }
                    }
                } else if (count < 5400) {
                    exp = 4;
                    if (c == 4) {
                        c = 0;
                        AddExpVoice Add = new AddExpVoice(Utente, exp);
                        if (Add.getLivellato()) {
                            OttenimentoUtenti UT = new OttenimentoUtenti(Utente);
                            EmbedBuilder Em = new EmbedBuilder();
                            if (Add.getCambioRuolo()) {
                                Em.setTitle(Utente + " é salito di livello");
                                Em.setDescription(Utente + " è salito al livello " + UT.getLvl() + " adesso sei un " + UT.getRuolo());
                                Em.setColor(0x3333ff);
                                e.getGuild().getDefaultChannel().sendMessage(Em.build()).queue();


                            } else {
                                Em.setTitle(Utente + " é salito di livello");
                                Em.setDescription(Utente + " è salito al livello " + UT.getLvl());
                                Em.setColor(0x3333ff);
                                e.getGuild().getDefaultChannel().sendMessage(Em.build()).queue();


                            }

                        }
                    }
                } else {
                    exp = 5;
                    if (c == 4) {
                        c = 0;
                        AddExpVoice Add = new AddExpVoice(Utente, exp);
                        if (Add.getLivellato()) {
                            OttenimentoUtenti UT = new OttenimentoUtenti(Utente);
                            EmbedBuilder Em = new EmbedBuilder();
                            if (Add.getCambioRuolo()) {
                                Em.setTitle(Utente + " é salito di livello");
                                Em.setDescription(Utente + " è salito al livello " + UT.getLvl() + " adesso sei un " + UT.getRuolo());
                                Em.setColor(0x3333ff);
                                e.getGuild().getDefaultChannel().sendMessage(Em.build()).queue();


                            } else {
                                Em.setTitle(Utente + " é salito di livello");
                                Em.setDescription(Utente + " è salito al livello " + UT.getLvl());
                                Em.setColor(0x3333ff);
                                e.getGuild().getDefaultChannel().sendMessage(Em.build()).queue();


                            }

                        }
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(task, 1000, 1000);


    }

    public void onGuildVoiceLeave(GuildVoiceLeaveEvent e) {
        if (Utente.equals(e.getMember().getEffectiveName())) {


            timer.cancel();
            exp = 1;
            AddExpVoice Add = new AddExpVoice(Utente, exp);
            if (Add.getLivellato()) {
                OttenimentoUtenti UT = new OttenimentoUtenti(Utente);
                EmbedBuilder Em = new EmbedBuilder();
                if (Add.getCambioRuolo()) {
                    Em.setTitle(Utente + " é salito di livello");
                    Em.setDescription(Utente + " è salito al livello " + UT.getLvl() + " adesso sei un " + UT.getRuolo());
                    Em.setColor(0x3333ff);
                    e.getGuild().getDefaultChannel().sendMessage(Em.build()).queue();


                } else {
                    Em.setTitle(Utente + " é salito di livello");
                    Em.setDescription(Utente + " è salito al livello " + UT.getLvl());
                    Em.setColor(0x3333ff);
                    e.getGuild().getDefaultChannel().sendMessage(Em.build()).queue();


                }

            }


        }


    } */
}