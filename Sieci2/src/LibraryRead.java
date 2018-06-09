import java.sql.*;

public class LibraryRead {

    public void read(Connection connection) {

        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "select * from books";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String year = resultSet.getString("bookYear");
                String isbn = resultSet.getString("isbn");

                System.out.println("nr id: "+id +"\n Title: " + title + "\n Author: " + author+"\n Year: "+year+"\n ISBN: "+isbn+"\n");
            }
        } catch (SQLException e) {
            System.out.println("Nie można wczytać zawartości bazy");
        }
    }
}
