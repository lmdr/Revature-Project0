import java.sql.SQLException

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
          val id = sql_results.getString("id")
          val name = sql_results.getString("name")
          val address = sql_results.getString("address")
          val city = sql_results.getString("city")
          val state = sql_results.getString("state")
          val country = sql_results.getString("country")
          val postal_code = sql_results.getString("postal_code")
          val phone = sql_results.getString("phone")
          val email = sql_results.getString("email")

          println("{")
          println("\tid: " + id)
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
        println("Error SQL")
    }
  }

  def add_warehouse(): Unit = {
    println("add_warehouse()")
  }

  def remove_warehouse(): Unit = {
    println("remove_warehouse()")
  }

  def show_locations(): Unit = {
    println("show_locations()")
  }

  def add_location(): Unit = {
    println("add_location()")
  }

  def remove_location(): Unit = {
    println("remove_location()")
  }
}