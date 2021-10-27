import scala.io.StdIn

object Menu {
  def display_main_menu(): Unit = {
    var exit = false
    do {
      var choice = 0
      println("\n---------------- Main Menu ----------------")
      println("1. Warehouse Management...")
      println("2. Product Management...")
      println("3. Inventory Management...")
      println("0. Exit")

      print("Enter menu choice: ")
      choice = scala.io.StdIn.readInt()
      println("\n")

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
      println("\n---------------- Warehouse Management Menu ----------------")
      println("1. Show Warehouses...")
      println("2. Add Warehouse...")
      // println("3. Remove Warehouse...")
      println("4. Show Locations...")
      println("5. Add Location...")
      // println("6. Remove Location...")
      println("0. Exit to Main Menu")

      print("Enter menu choice: ")
      choice = scala.io.StdIn.readInt()
      println("\n")

      choice match {
        case 1 => WarehouseManager.show_warehouses()
        case 2 => WarehouseManager.add_warehouse()
        case 3 => WarehouseManager.remove_warehouse()
        case 4 => WarehouseManager.show_locations()
        case 5 => WarehouseManager.add_location()
        case 6 => WarehouseManager.remove_location()
        case 0 => exit = true
        case _ => println("Opps! Please choose a valid menu option.")
      }
    } while (!exit)
  }

  def display_product_menu(): Unit = {
    var exit = false
    do {
      var choice = 0
      println("\n---------------- Product Management Menu ----------------")
      println("1. Show Vendors...")
      println("2. Add Vendor...")
      // println("3. Remove Vendor...")
      println("4. Show Products...")
      println("5. Add Product...")
      // println("6. Remove Product...")
      println("0. Exit to Main Menu")

      print("Enter menu choice: ")
      choice = scala.io.StdIn.readInt()
      println("\n")

      choice match {
        case 1 => ProductManager.show_vendors()
        case 2 => ProductManager.add_vendor()
        case 3 => ProductManager.remove_vendor()
        case 4 => ProductManager.show_products()
        case 5 => ProductManager.add_product()
        case 6 => ProductManager.remove_product()
        case 0 => exit = true
        case _ => println("Opps! Please choose a valid menu option.")
      }
    } while (!exit)
  }

  def display_inventory_menu(): Unit = {
    var exit = false
    do {
      var choice = 0
      println("\n---------------- Inventory Management Menu ----------------")
      println("1. Show Inventory...")
      println("2. Load Data From File...")
      // println("3. Adjust...")
      println("0. Exit to Main Menu")

      print("Enter menu choice: ")
      choice = scala.io.StdIn.readInt()
      println("\n")
      
      choice match {
        case 1 => InventoryManager.show_inventory()
        case 2 => FileReader.import_file()
        case 3 => InventoryManager.adjust()
        case 0 => exit = true
        case _ => println("Opps! Please choose a valid menu option.")
      }
    } while (!exit)
  }
}