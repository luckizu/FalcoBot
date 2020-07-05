package Ranking;

public class LVLUP {
    int exp;
    Boolean Salito;
    int MaxExp;
    public LVLUP(int lvl, int exp, int MaxExp){
        this.MaxExp = MaxExp;
        this.exp = exp;
        if(MaxExp<=exp & lvl != 30){

          Salito = true;

        } else {

            Salito = false;
        }
    }

    public Boolean getSalito(){


        return this.Salito;
    }

    public int getExpSup(){

            int Sup = this.exp - this.MaxExp;


        return Sup;
    }

}
