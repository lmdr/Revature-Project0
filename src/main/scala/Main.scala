import java.sql.{Connection, DriverManager}

object Main extends App {
  println("Hello, World!")
  DBConnection.connect()
  println("Connection established")
  DBConnection.disconnect()
}