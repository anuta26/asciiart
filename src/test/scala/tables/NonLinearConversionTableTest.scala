package tables

import domain.tables.NonLinearConversionTable
import org.scalatest.FunSuite

class NonLinearConversionTableTest extends FunSuite{

  test("Get symbols of table") {
    val table: NonLinearConversionTable = new NonLinearConversionTable("ABCD", 20)
    val symbols: String = table.getSymbols

    assert(symbols.equals("ABCD"))
  }

  test("Get range of table") {
    val table: NonLinearConversionTable = new NonLinearConversionTable("ABCD", 20)
    val range: Int = table.getRange

    assert(range.equals(20))
  }
}
