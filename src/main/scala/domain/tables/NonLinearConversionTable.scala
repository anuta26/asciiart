package domain.tables

class NonLinearConversionTable(private var symbols: String,private var range: Int) extends ConversionTable {
  def getSymbols: String = symbols
  def getRange: Int = range
}
