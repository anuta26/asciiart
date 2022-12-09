package domain.tables

/** Non-linear conversion table where 255 greyscale values are divided un-equally.
 *  One character is for values 0-Range, and the rest is divided between other characters in table.
 *
 * @param symbols symbols of the table (content)
 * @param range number value for interval of conversion
 */
class NonLinearConversionTable(private var symbols: String,private var range: Int) extends ConversionTable {
  def getSymbols: String = symbols
  def getRange: Int = range
}
