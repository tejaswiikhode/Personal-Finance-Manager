package Database;

public class TestConnection {
    public static void main(String[] args) {
        DatabaseManager.connect(); // Call the connect method
        
        if (DatabaseManager.getConnection() != null) {
            System.out.println("✅ Database connection successful!");
        } else {
            System.out.println("❌ Database connection failed!");
        }
    }
}
