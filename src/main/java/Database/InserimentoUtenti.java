package Database;

import java.io.*;

public class InserimentoUtenti {
    String Utente;

    public static void Inserisci(String Utente) {

        String[] caso = new String[1000000000];


        int x = 0;
        caso[x] = "caso";
        String dio = "caso";
        try {
            FileInputStream IN = new FileInputStream("DataBase.dat");
            try {
                ObjectInputStream Lett = new ObjectInputStream(IN);


                while (dio != null) {


                    dio = Lett.readUTF();
                    System.out.println(dio);
                    caso[x] = dio;
                    x++;

                }


                Lett.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            System.out.println("erorrro");
        }
        caso[x] = Utente;
        System.out.println(caso[2]);
        System.out.println(caso[0] + caso[1]);

        try {
            ObjectOutputStream Scrit = new ObjectOutputStream(new FileOutputStream("DataBase.dat"));

            x = 0;
            String merda = "caso";
            while (merda != null) {
                merda = caso[x];
                System.out.println(caso[x]);
                if (merda != null) {
                    try {
                        Scrit.writeUTF(merda);
                    } catch (IOException ex) {
                        System.out.println("error");
                    }
                }

                x++;
            }

            Scrit.close();

        } catch (IOException e) {
            System.out.println("diocane");
        }

    }

    public static void Cambio(String NuovoNome, String VecchioNome){
    int count = 0;
    String[] Nome = new String[5];
    String Utente1;
        try {

            FileInputStream IN = new FileInputStream("DataBase.dat");

            try {

                ObjectInputStream Lett = new ObjectInputStream(IN);

                while (Nome[0] != VecchioNome){

                    Utente1 = Lett.readUTF();
                    Nome = Utente1.split(" ");
                    count++;


                }
                Lett.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Utenti CAMBIO = new Utenti(NuovoNome, Nome[1], Nome[2], Integer.parseInt(Nome[3]), Integer.parseInt(Nome[4]));

        String[] caso = new String[1000000000];


        int x = 0;
        caso[x] = "caso";
        String dio = "caso";
        try {
            FileInputStream IN = new FileInputStream("DataBase.dat");
            try {
                ObjectInputStream Lett = new ObjectInputStream(IN);


                while (Lett.readBoolean()) {


                    dio = Lett.readUTF();
                    System.out.println(dio);
                    caso[x] = dio;
                    x++;

                }


                Lett.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            System.out.println("erorrro");
        }
        caso[count] = CAMBIO.ToString();

        try {
            ObjectOutputStream Scrit = new ObjectOutputStream(new FileOutputStream("DataBase.dat"));

            x = 0;
            String merda = "caso";
            while (merda != null) {
                merda = caso[x];

                if (merda != null) {
                    try {
                        Scrit.writeUTF(merda);
                    } catch (IOException ex) {

                    }
                }

                x++;
            }

            Scrit.close();

        } catch (IOException e) {
            System.out.println("diocane");
        }

    }

    }


