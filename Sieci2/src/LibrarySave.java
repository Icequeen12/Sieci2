import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Year;
import java.util.Scanner;

public class LibrarySave {

    public void save(Connection connection){

        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj id :");
        String id= scan.nextLine();
        System.out.println("Podaj tytuł :");
        String title = scan.nextLine();
        System.out.println("Podaj autora :");
        String author = scan.nextLine();
        System.out.println("Podaj rok :");
        String year =scan.nextLine();
        System.out.println("Podaj ISBN :");
        String isbn = scan.nextLine();

        final String sql = "insert into books(id,title,author,bookYear,isbn) values(?, ?, ?, ?,?)";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1,id);
            prepStmt.setString(2, title);
            prepStmt.setString(3, author);
            prepStmt.setString(4, year);
            prepStmt.setString(5, isbn);
            prepStmt.executeUpdate();
            System.out.println("\n Saved new record \n");
        } catch (SQLException e) {
            System.out.println("Could not save record");
            e.printStackTrace();
        }

    }
}
