import java.sql.{Connection, DriverManager}

object Main extends App {
  DBConnection.connect()
  FileReader.import_file()
  Menu.display_main_menu()
  DBConnection.disconnect()
}