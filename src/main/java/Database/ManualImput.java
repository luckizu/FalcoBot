package Database;

import java.io.*;
import java.util.Scanner;

public class ManualImput {


  /*  public static void ManualI() throws IOException {
        System.out.println("Inizializzazione");
        String[] SData = SData();
        int[] NData = NData();
        InserimentoUtenti.ScritturaData(SData, NData);


    }

    public static String[] SData() {
        //TODO inserire altre frasi
        int z = 0;
        String[] SData = new String[3];
        String[] y = {"Inserire Nome\n", "\nInserire id\n", "\nInserire Lvl\n"};
        Scanner scan = new Scanner(System.in);
        System.out.println("funziona");
        String lvl = "Nababbo";
        System.out.println(SData.length);
        for (int index = 0; index < SData.length; index++) {
            System.out.println(y[index]);
            SData[index] = scan.nextLine();
        }


        return SData;

    }

    public static int[] NData() {
        int[] NData = new int[3];
        int c = 0;
        int d = 1;
        NData[0] = d;
        NData[1] = c;
        System.out.println("funz");

        return NData;
    }

    public static void ScritturaConfig() {
        Scanner Scrittura = new Scanner(System.in);

        try {
            ObjectOutputStream Scrit = new ObjectOutputStream(new FileOutputStream("Config.cf"));
            for (int x = 0; x < 2; x++) {
                Scrit.writeInt(Scrittura.nextInt());

            }
            Scrit.close();

        } catch (IOException e) {
            System.out.println("errore");
        }

    }

    public static void main(String arg[]) {

        //  ScritturaConfig();
        // System.out.println(Config.getDirectory());
        // System.out.println(Config.getToken());
    /*  try {
         FileOutputStream DataBase = new FileOutputStream("DataBase.dat");
          ObjectOutputStream caso = new ObjectOutputStream(DataBase);
          Utenti Ut = new Utenti("Miranda", "834956834", "fioco", 1, 0);
          Utenti nw = new Utenti("dio", "Merada", "porco", 1, 0);
          caso.writeUTF(Ut.ToString());
          caso.writeUTF(nw.ToString());
          caso.close();
      }catch (IOException e){


      }


        String[] SData = new String[3];
        int[] NData = new int[2];
       Scanner caso = new Scanner(System.in);
        for (int x = 0; x < 3; x++) {
            SData[x] = caso.nextLine();
        }
        for (int z = 0; z<2; z++){
            NData[z] = caso.nextInt();
        }
        Utenti NEW = new Utenti(SData[0], SData[1], SData[2], NData[0], NData[1]);
        InserimentoUtenti new

        String dio = "caso";
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("DataBase.dat"));
                while(dio != null) {


                    dio = in.readUTF();
                    System.out.println(dio);
              //      caso[x] = dio;
                //    x++;

                }


        } catch (IOException e) {
            System.out.println("ereredfe");
        }

    }



   */

}


