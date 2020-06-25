package FalcoBot.Comandi;

import Database.Config;
import Database.OttenimentoUtenti;

import java.io.IOException;

public class Comandi {

    public static String[] EsecuzioneComandi(String[] Text, String Nome, String Ruolo) throws IOException {
        String Case = Text[0];
        switch (Case) {
            case "/help":

            String[] EMB2 = Help(Ruolo, Case);
            return EMB2;

            case "/stat":
                String[] EMB1 = Stat(Nome, Case);
                return EMB1;

            default:
                String[] EMBD = {"Errore", "Comando insesistente"};
                return EMBD;


        }


    }


        public static String[] Help (String Ruolo, String Comando) {
            Config Conf = new Config();
            String[] Comandi = Conf.getCommand();
             CreateEMB Create1 = new CreateEMB();
            String[] EMB = Create1.EMBauto(Comando, Comandi);

            return EMB;
        }

        public static String[] Stat (String Nome, String Comando) throws IOException {
            OttenimentoUtenti OTT = new OttenimentoUtenti();
            String[] DATA = OTT.Ottenimento(Nome);
            CreateEMB Create = new CreateEMB();
            String[] EMB = Create.EMBauto(Comando, DATA);


            return EMB;

        }
    public static String[] Error (){
        String[]EMB = {"Errore", "Comando inesistente"};
        return EMB;
    }

    }

