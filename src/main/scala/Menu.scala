import scala.io.StdIn

object Menu {
  def display_main_menu() = {
    var exit = false
    do {
      var choice = 0
      println("---------------- Main Menu ----------------")
      println("1. Warehouse Management...")
      println("2. Product Management...")
      println("3. Inventory Management...")
      println("0. Exit")

      print("Enter menu choice: ")
      choice = scala.io.StdIn.readInt()

      choice match {
        case 1 => display_warehouse_menu()
        case 2 => display_product_menu()
        case 3 => display_inventory_menu()
        case 0 => exit = true
        case _ => println("Opps! Please choose a valid menu option.")
      }
    } while (!exit)
  }

  def display_warehouse_menu() = {

  }

  def display_product_menu() = {

  }

  def display_inventory_menu() = {

  }
}