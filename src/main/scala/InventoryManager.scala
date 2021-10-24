import java.sql.SQLException

object InventoryManager {
  def show_inventory(): Unit = {
    println("show_inventory()")
    try {
      val sql = "SELECT * FROM inventory"
      val sql_statement = DBConnection.getConnection().createStatement()
      val sql_results = sql_statement.executeQuery(sql)

      if (!sql_results.next()) {
        println("Error: No Results")
      } else {
        do {
          val inventory_id = sql_results.getString("inventory_id")
          val product_id = sql_results.getString("product_id")
          val location_id = sql_results.getString("location_id")
          val quantity = sql_results.getString("quantity")

          println("{")
          println("\tinventory_id: " + inventory_id)
          println("\tproduct_id: " + product_id)
          println("\tlocation_id: " + location_id)
          println("\tquantity: " + quantity)
          println("}\n")
        } while (sql_results.next())
      }
    } catch {
      case sql: SQLException =>
        sql.printStackTrace()
        println("Error: SQL")
    }
  }

  def adjust(): Unit = {
    println("adjust()")
  }
}