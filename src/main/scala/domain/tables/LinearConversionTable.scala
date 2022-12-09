package domain.tables

/** Linear conversion table, table where the range of 255 greyscale values is equally divied between a set of ASCII characters
 *
 * @param symbols symbols of the table (content)
 */
class LinearConversionTable(private var symbols: String) extends ConversionTable {
  def getSymbols: String = symbols


}
