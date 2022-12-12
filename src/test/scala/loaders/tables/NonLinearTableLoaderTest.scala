package loaders.tables

import business.loaders.tables.NonLinearTableLoader
import domain.tables.NonLinearConversionTable
import org.scalatest.FunSuite

class NonLinearTableLoaderTest extends FunSuite {
  test("Load predefined non-linear table") {
    val table: NonLinearConversionTable = new NonLinearTableLoader().load()
    assert(table.getSymbols.equals("$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "))
    assert(table.getRange.equals(100))
  }
}
