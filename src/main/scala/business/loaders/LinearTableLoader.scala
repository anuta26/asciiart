package business.loaders

import domain.tables.LinearConversionTable

class LinearTableLoader extends TableLoader[LinearConversionTable] {
  def load(arg: String): LinearConversionTable = {
    if (arg == "Paul Bourkes’ table") {
      return new LinearConversionTable("$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ")
    }
    new LinearConversionTable(arg)
  }

}
