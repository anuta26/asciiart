package domain.tables

/** Conversion table which will be used to convert GreyscaleImage to AsciiImage
 *
 * */
trait ConversionTable {
  def getSymbols: String
}
