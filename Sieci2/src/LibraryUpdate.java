import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LibraryUpdate {

    public void upDate(Connection connection) {


        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj id książki którą chcesz uaktualnić:");
        String id = scan.nextLine();
        System.out.println("Podaj tytuł :");
        String title = scan.nextLine();
        System.out.println("Podaj autora :");
        String author = scan.nextLine();
        System.out.println("Podaj rok :");
        Integer year = Integer.valueOf(scan.nextLine());
        System.out.println("Podaj ISBN: ");
        String isbn = scan.nextLine();

        final String sql = "update books set title=?, author=?, bookYear=?, isbn=? where id = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, title);
            prepStmt.setString(2, author);
            prepStmt.setInt(3, year);
            prepStmt.setString(4, isbn);
            prepStmt.setString(5, id);
            prepStmt.executeUpdate();

            System.out.println("\n Zakualizowano \n");

        } catch (SQLException e) {
            System.out.println("Could not update record");
        }

    }
}
