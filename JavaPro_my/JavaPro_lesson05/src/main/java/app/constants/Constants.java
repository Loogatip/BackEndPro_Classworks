package app.constants;

public interface Constants {

    // http://120.230.12.10:8080/cars?id=5
    // jdpc:postgresql://120.230.12.10:5432/javapro_database1_cars?user=postgres&password=Ed-3980313

    String DB_DRIVER_PATH = "org.postgresql.Driver";
    String DB_ADDRESS = "jdbc:postgresql://localhost:5432/";
    String DB_NAME = "JavaPro_Database1_Cars";
    String DB_USERNAME = "postgres";
    String DB_PASSWORD = "postgres";
}
