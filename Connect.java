package banks.management.systems;

import java.sql.*;

public class Connect {
    Connection connection;
    Statement statement;
    public Connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankatm","root","@1Anirban@9111");
            statement = connection.createStatement();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

