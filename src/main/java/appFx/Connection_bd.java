package appFx;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connection_bd {
    public Connection lienBd;

    public Connection getConnection(){
        String nomDb = "Cfun";
        String utilisateurDb = "root";
        String motDePasseDb = "Hermine56";
        String url = "jdbc:mysql://localhost/" + nomDb;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            lienBd = DriverManager.getConnection(url,utilisateurDb,motDePasseDb);
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    return lienBd;
    }

}
