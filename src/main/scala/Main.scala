import java.sql.{Connection, DriverManager}

object Main extends App {
  println("Hello, World!")
  val con = DriverManager.getConnection("jdbc:mysql://localhost/project0", "root", "cubicsystem")
  println("Connection established")
  con.close()
}