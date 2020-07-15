package Database;

import java.io.File;

public class DatabasePath {

    File Database = new File("C:\\Users\\luckizu\\Documents\\FalcoBot\\DataBase.dat") ;
    File DatabaseTest = new File("C:\\Users\\luckizu\\Documents\\FalcoBot\\DataBaseTest.dat") ;

    public File getPath(){


        return this.Database;
    }

}
