object Main extends App {
  DBConnection.connect()
  Menu.display_main_menu()
  DBConnection.disconnect()
}