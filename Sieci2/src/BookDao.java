import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class BookDao {

    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection connection;


    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("No driver found");
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
        }


        Scanner scan = new Scanner(System.in);
        String odp ="";

        while (!odp.equals("5")) {

            System.out.println("Wybierz opcję: \n 1 - Dodaj nowy rekord \n 2 - Wyświetl wszystkie książki \n 3 - Aktualizacja \n 4 - Usuwanie \n 5 - Zakończ");
            odp = scan.nextLine();

            if (odp.equals("1")) {
                LibrarySave saveBook = new LibrarySave();
                saveBook.save(connection);
            }

            if (odp.equals("2")) {
                LibraryRead readLibrary = new LibraryRead();
                readLibrary.read(connection);

            }

            if (odp.equals("3")) {
                LibraryUpdate updateBook = new LibraryUpdate();
                updateBook.upDate(connection);
            }


            if (odp.equals("4")) {
                LibraryDelete deleteBook = new LibraryDelete();
                deleteBook.delete(connection);
            }
        }
            close();

    }

    public static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
