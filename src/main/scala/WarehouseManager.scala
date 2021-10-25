import java.sql.SQLException
import scala.io.StdIn

object WarehouseManager {
  def show_warehouses(): Unit = {
    println("show_warehouses()")
    try {
      val sql = "SELECT * FROM warehouse"
      val sql_statement = DBConnection.getConnection().createStatement()
      val sql_results = sql_statement.executeQuery(sql)

      if (!sql_results.next()) {
        println("Error: No Results")
      } else {
        do {
          val warehouse_id = sql_results.getString("warehouse_id")
          val name = sql_results.getString("name")
          val address = sql_results.getString("address")
          val city = sql_results.getString("city")
          val state = sql_results.getString("state")
          val country = sql_results.getString("country")
          val postal_code = sql_results.getString("postal_code")
          val phone = sql_results.getString("phone")
          val email = sql_results.getString("email")

          println("{")
          println("\twarehouse_id: " + warehouse_id)
          println("\tname: " + name)
          println("\taddress: " + address)
          println("\tcity: " + city)
          println("\tstate: " + state)
          println("\tcountry: " + country)
          println("\tpostal_code: " + postal_code)
          println("\tphone: " + phone)
          println("\temail: " + email)
          println("}\n")
        } while (sql_results.next())
      }
    } catch {
      case sql: SQLException =>
        sql.printStackTrace()
        println("Error: SQL")
    }
  }

  def add_warehouse(): Unit = {
    println("add_warehouse()")
    val name = scala.io.StdIn.readLine("Input warehouse name: ")
    val address = scala.io.StdIn.readLine("Input address: ")
    val city = scala.io.StdIn.readLine("Input city: ")
    val state = scala.io.StdIn.readLine("Input state: ")
    val country = scala.io.StdIn.readLine("Input country: ")
    val postal_code = scala.io.StdIn.readLine("Input postal code: ")
    val phone = scala.io.StdIn.readLine("Input phone number: ")
    val email = scala.io.StdIn.readLine("Input email address: ")

    try {
      val sql = s"INSERT INTO warehouse (name, address, city, state, country, postal_code, phone, email)" +
        s"VALUES ('$name', '$address', '$city', '$state', '$country', '$postal_code', $phone, '$email')"
      val sql_statement = DBConnection.getConnection().createStatement()
      val sql_results = sql_statement.executeUpdate(sql)
      } catch {
      case sql: SQLException =>
        sql.printStackTrace()
        println("Error: SQL")
    }
  }

  def remove_warehouse(): Unit = {
    println("remove_warehouse()")
  }

  def show_locations(): Unit = {
    println("show_locations()")
    try {
      val sql = "SELECT * FROM location"
      val sql_statement = DBConnection.getConnection().createStatement()
      val sql_results = sql_statement.executeQuery(sql)

      if (!sql_results.next()) {
        println("Error: No Results")
      } else {
        do {
          val location_id = sql_results.getString("location_id")
          val warehouse_id = sql_results.getString("warehouse_id")
          val name = sql_results.getString("name")

          println("{")
          println("\tlocation_id: " + location_id)
          println("\twarehouse_id: " + warehouse_id)
          println("\tname: " + name)
          println("}\n")
        } while (sql_results.next())
      }
    } catch {
      case sql: SQLException =>
        sql.printStackTrace()
        println("Error: SQL")
    }
  }

  def add_location(): Unit = {
    println("add_location()")
    val warehouse_id = scala.io.StdIn.readLine("Input warehouse id: ")
    val name = scala.io.StdIn.readLine("Input location name: ")

    try {
      val sql = s"INSERT INTO location (warehouse_id, name)" +
        s"VALUES ($warehouse_id, '$name')"
      val sql_statement = DBConnection.getConnection().createStatement()
      val sql_results = sql_statement.executeUpdate(sql)
      } catch {
      case sql: SQLException =>
        sql.printStackTrace()
        println("Error: SQL")
    }
  }

  def remove_location(): Unit = {
    println("remove_location()")
  }
}