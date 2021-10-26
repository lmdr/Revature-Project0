import scala.io.Source

object FileReader {
  def import_file():Unit = {
    val input_file = scala.io.Source.fromFile("Project0Data_SampleData.csv")
    for (line <- input_file.getLines()) {
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
    }
  }
}