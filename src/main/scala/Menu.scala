import scala.io.StdIn

object Menu {
  def display_main_menu(): Unit = {
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

  def display_warehouse_menu(): Unit = {
    var exit = false
    do {
      var choice = 0
      println("---------------- Warehouse Management Menu ----------------")
      println("1. Add Warehouse...")
      println("2. Remove Warehouse...")
      println("3. Add Location...")
      println("4. Remove Location...")
      println("0. Exit to Main Menu")

      print("Enter menu choice: ")
      choice = scala.io.StdIn.readInt()

      choice match {
        case 1 => WarehouseManager.add_warehouse()
        case 2 => WarehouseManager.remove_warehouse()
        case 3 => WarehouseManager.add_location()
        case 4 => WarehouseManager.remove_location()
        case 0 => exit = true
        case _ => println("Opps! Please choose a valid menu option.")
      }
    } while (!exit)
  }

  def display_product_menu(): Unit = {
    var exit = false
    do {
      var choice = 0
      println("---------------- Product Management Menu ----------------")
      println("1. Add Vendor...")
      println("2. Remove Vendor...")
      println("3. Add Product...")
      println("4. Remove Product...")
      println("0. Exit to Main Menu")

      print("Enter menu choice: ")
      choice = scala.io.StdIn.readInt()

      choice match {
        case 1 => ProductManager.add_vendor()
        case 2 => ProductManager.remove_vendor()
        case 3 => ProductManager.add_product()
        case 4 => ProductManager.remove_product()
        case 0 => exit = true
        case _ => println("Opps! Please choose a valid menu option.")
      }
    } while (!exit)
  }

  def display_inventory_menu(): Unit = {
    var exit = false
    do {
      var choice = 0
      println("---------------- Inventory Management Menu ----------------")
      println("1. Adjust...")
      println("0. Exit to Main Menu")

      print("Enter menu choice: ")
      choice = scala.io.StdIn.readInt()

      choice match {
        case 1 => InventoryManager.adjust()
        case 0 => exit = true
        case _ => println("Opps! Please choose a valid menu option.")
      }
    } while (!exit)
  }
}