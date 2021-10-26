import java.sql.SQLException
import scala.io.Source

object FileReader {
  def import_file():Unit = {
    val input_file = scala.io.Source.fromFile("Project0Data_SampleData.csv")
    for (line <- input_file.getLines().drop(1)) {
      val attributes = line.split(",").map(_.trim)
      println(
      "{\n" +
      s"\tproduct:\n\t{\n\t\tname: ${attributes(0)},\n\t\tdescription: ${attributes(1)},\n\t\tweight: ${attributes(2)}\n\t},\n" +
      s"\tvendor:\n\t{\n\t\tname: ${attributes(3)},\n\t\tcontact: ${attributes(4)}," +
      s"\n\t\taddress: ${attributes(5)},\n\t\tcity: ${attributes(6)}," +
      s"\n\t\tstate: ${attributes(7)},\n\t\tcountry: ${attributes(8)}," +
      s"\n\t\tpostal_code: ${attributes(9)},\n\t\tphone: ${attributes(10)}," +
      s"\n\t\temail: ${attributes(11)}\n\t},\n" +
      s"\tlocation:\n\t{\n\t\tname: ${attributes(12)}\n\t},\n" +
      s"\twarehouse:\n\t{\n\t\tname: ${attributes(13)},\n\t\taddress: ${attributes(14)}," +
      s"\n\t\tcity: ${attributes(15)},\n\t\tstate: ${attributes(16)}," +
      s"\n\t\tcountry: ${attributes(17)},\n\t\tpostal_code: ${attributes(18)}," +
      s"\n\t\tphone: ${attributes(19)},\n\t\temail: ${attributes(20)}\n\t},\n" +
      s"\tinventory:\n\t{\n\t\tquantity: ${attributes(21)}\n\t}\n" +
      "}"
      )

      try {
        val sql_vendor = s"SELECT * from vendor WHERE name='${attributes(3)}' AND contact='${attributes(4)}' AND address='${attributes(5)}' AND city='${attributes(6)}'" +
          s" AND state='${attributes(7)}' AND country='${attributes(8)}' AND postal_code='${attributes(9)}' AND phone=${attributes(10)} AND email='${attributes(11)}'"
        val sql_statement = DBConnection.getConnection().createStatement()
        val sql_results = sql_statement.executeQuery(sql_vendor)
        var vendor_id = 0
        if (!sql_results.next()) {
          val sql_vendor_insert = s"INSERT INTO vendor (name, contact, address, city, state, country, postal_code, phone, email)" +
            s"VALUES ('${attributes(3)}', '${attributes(4)}', '${attributes(5)}', '${attributes(6)}',"+
            s"'${attributes(7)}', '${attributes(8)}', '${attributes(9)}', ${attributes(10)}, '${attributes(11)}')"
          sql_statement.executeUpdate(sql_vendor_insert)
          vendor_id = sql_statement.executeQuery("SELECT LAST_INSERTED_ID()").getInt("vendor_id")
        } else {
          vendor_id = sql_results.getInt("vendor_id")
        }
      } catch {
        case sql: SQLException =>
        sql.printStackTrace()
        println("Error: SQL")
      }
    }
  }
}