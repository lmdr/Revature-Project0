import java.sql.{Connection, DriverManager, SQLTimeoutException, SQLException}

object DBConnection {
  private var connection: Connection = _

  def connect(): Unit = {
    val uri = "jdbc:mysql://localhost/project0"
    val user = "user"
    val pass = "password"

    try {
      connection = DriverManager.getConnection(uri, user, pass)
    } catch {
      case timeout: SQLTimeoutException =>
        timeout.printStackTrace();
        println("Error: SQL Timeout")
      case sql: SQLException =>
        sql.printStackTrace();
        println("Error: SQL")
    }
    
  }

  def disconnect(): Unit = {
    connection.close()
  }

  def getConnection(): Connection = {
    connection
  }
}