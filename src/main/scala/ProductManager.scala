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
    val name = scala.io.StdIn.readLine("Input vendor name: ")
    val contact = scala.io.StdIn.readLine("Input contact name: ")
    val address = scala.io.StdIn.readLine("Input address: ")
    val city = scala.io.StdIn.readLine("Input city: ")
    val state = scala.io.StdIn.readLine("Input state: ")
    val country = scala.io.StdIn.readLine("Input country: ")
    val postal_code = scala.io.StdIn.readLine("Input postal code: ")
    val phone = scala.io.StdIn.readLine("Input phone number: ")
    val email = scala.io.StdIn.readLine("Input email address: ")

    try {
      val sql = s"INSERT INTO vendor (name, contact, address, city, state, country, postal_code, phone, email)" +
        s"VALUES ('$name', '$contact', '$address', '$city', '$state', '$country', '$postal_code', $phone, '$email')"
      val sql_statement = DBConnection.getConnection().createStatement()
      val sql_results = sql_statement.executeUpdate(sql)
      } catch {
      case sql: SQLException =>
        sql.printStackTrace()
        println("Error: SQL")
    }
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
    val vendor_id = scala.io.StdIn.readLine("Input vendor id: ")
    val name = scala.io.StdIn.readLine("Input product name: ")
    val description = scala.io.StdIn.readLine("Input description: ")
    val weight = scala.io.StdIn.readLine("Input weight: ")

    try {
      val sql = s"INSERT INTO product (vendor_id, name, description, weight)" +
        s"VALUES ('$vendor_id', '$name', '$description', '$weight')"
      val sql_statement = DBConnection.getConnection().createStatement()
      val sql_results = sql_statement.executeUpdate(sql)
      } catch {
      case sql: SQLException =>
        sql.printStackTrace()
        println("Error: SQL")
    }
  }

  def remove_product(): Unit = {
    println("remove_product()")
  }
}