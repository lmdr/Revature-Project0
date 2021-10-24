import java.sql.SQLException

object ProductManager {
  def show_vendors(): Unit = {
    println("show_vendors()")
    try {
      val sql = "SELECT * FROM vendor"
      val sql_statement = DBConnection.getConnection().createStatement()
      val sql_results = sql_statement.executeQuery(sql)

      if (!sql_results.next()) {
        println("Error: No Results")
      } else {
        do {
          val vendor_id = sql_results.getString("vendor_id")
          val name = sql_results.getString("name")
          val contact = sql_results.getString("contact")
          val address = sql_results.getString("address")
          val city = sql_results.getString("city")
          val state = sql_results.getString("state")
          val country = sql_results.getString("country")
          val postal_code = sql_results.getString("postal_code")
          val phone = sql_results.getString("phone")
          val email = sql_results.getString("email")

          println("{")
          println("\tvendor_id: " + vendor_id)
          println("\tname: " + name)
          println("\tcontact: " + contact)
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

  def add_vendor(): Unit = {
    println("add_vendor()")
  }

  def remove_vendor(): Unit = {
    println("remove_vendor()")
  }

  def show_products(): Unit = {
    println("show_products()")
    try {
      val sql = "SELECT * FROM product"
      val sql_statement = DBConnection.getConnection().createStatement()
      val sql_results = sql_statement.executeQuery(sql)

      if (!sql_results.next()) {
        println("Error: No Results")
      } else {
        do {
          val product_id = sql_results.getString("product_id")
          val vendor_id = sql_results.getString("vendor_id")
          val name = sql_results.getString("name")
          val description = sql_results.getString("description")
          val weight = sql_results.getString("weight")

          println("{")
          println("\tproduct_id: " + product_id)
          println("\tvendor_id: " + vendor_id)
          println("\tname: " + name)
          println("\tdescription: " + description)
          println("\tweight: " + weight)
          println("}\n")
        } while (sql_results.next())
      }
    } catch {
      case sql: SQLException =>
        sql.printStackTrace()
        println("Error: SQL")
    }
  }

  def add_product(): Unit = {
    println("add_product()")
  }

  def remove_product(): Unit = {
    println("remove_product()")
  }
}