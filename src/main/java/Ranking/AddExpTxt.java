package Ranking;

import Database.AggiornamentoUtente;
import Database.OttenimentoLivelli;
import Database.OttenimentoUtenti;

import java.io.FileInputStream;

public class AddExpTxt {
    String Nome;
    String id;
    String Ruolo;
    int exp;
    int lvl;
    int MaxExp;
    boolean CambioRuolo;
    Boolean Livellato;

    public AddExpTxt(String Nome){
        this.Nome = Nome;
        OttenimentoUtenti OU = new OttenimentoUtenti(Nome);
        OttenimentoLivelli OL = new OttenimentoLivelli(OU.getLvl());

        this.lvl = OU.getLvl();
        this.exp = OU.getexp() + 1;
        this.MaxExp = OL.getMaxExp();
        this.id = OU.getid();
        this.Ruolo = OL.getRuolo();

        LVLUP Up = new LVLUP(lvl,exp,MaxExp);
        if(Up.getSalito() & lvl != 30){
            this.exp = Up.getExpSup();
            System.out.println("Salito");
            System.out.println(exp+ "aggiuntiva");
            this.lvl++;
            OttenimentoLivelli OT = new OttenimentoLivelli(lvl);
            AggiornamentoUtente ag = new AggiornamentoUtente(Nome, id, OT.getRuolo(), lvl, exp);
            System.out.println(OT.getRuolo() != Ruolo);
            this.Livellato = true;
            if(lvl == 6 || lvl == 11 || lvl == 16 || lvl == 21 || lvl == 26 || lvl == 30){
                this.CambioRuolo = true;

            } else {

                this.CambioRuolo = false;

            }


        } else {
            this.Livellato = false;

            if (lvl == 30) {
                System.out.println("Cap Massimo");

                AggiornamentoUtente AG = new AggiornamentoUtente(Nome, id, Ruolo, lvl, MaxExp);
                this.CambioRuolo = false;


            } else {
                System.out.println("Cap non massimo");
                AggiornamentoUtente AG = new AggiornamentoUtente(Nome, id, Ruolo, lvl, exp);
                this.CambioRuolo = false;

            }

        }
    }
    public Boolean getLivellato(){
        return this.Livellato;
    }

    public Boolean getCambioRuolo(){

        return CambioRuolo;
    }



}
