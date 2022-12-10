package business.loaders

import domain.tables.LinearConversionTable

/** Loader which loads linear conversion table
 *
 */
class LinearTableLoader(arg: String) extends TableLoader[LinearConversionTable] {
  /** Loads linear conversion table
   *  If value of path is "Paul Bourkes’ table" then the predefined table will be loaded
   *  This table is also default table.
   *  If not then custom table will be loaded.
   *
   *  @return loaded table
   */
  def load(): LinearConversionTable = {
    if (arg == "Paul Bourkes’ table") {
      return new LinearConversionTable("$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ")
    }
    new LinearConversionTable(arg)
  }

}
