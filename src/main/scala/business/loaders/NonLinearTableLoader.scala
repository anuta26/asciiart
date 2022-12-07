package business.loaders

import domain.tables.NonLinearConversionTable

class NonLinearTableLoader extends TableLoader [NonLinearConversionTable] {
  def load(arg: String): NonLinearConversionTable = {
    new NonLinearConversionTable("$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ", 100)
  }

}
