package tables

import domain.tables.LinearConversionTable
import org.scalatest.FunSuite

class LinearConversionTableTest extends FunSuite {
  test("Get symbols of table"){
    val table: LinearConversionTable = new LinearConversionTable("ABCD")
    val symbols: String = table.getSymbols

    assert(symbols.equals("ABCD"))
  }

}
