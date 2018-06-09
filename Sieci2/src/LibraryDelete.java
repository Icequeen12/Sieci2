import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LibraryDelete {


    public void delete(Connection connection) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj id książki do  usunięcia: ");
        String id = scan.nextLine();

            final String sql = "delete from books where id = ?";
            try {
                PreparedStatement prepStmt = connection.prepareStatement(sql);
                prepStmt.setString(1, id);
                prepStmt.executeUpdate();

                System.out.println("\n Usunięto \n");
            } catch (SQLException e) {
                System.out.println("Could not delete row");
            }
        }

    }

