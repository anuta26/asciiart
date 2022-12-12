package loaders.tables

import business.loaders.tables.LinearTableLoader
import domain.tables.LinearConversionTable
import org.scalatest.FunSuite

class LinearTableLoaderTest extends FunSuite {
  test("Load default linear table") {
    val table: LinearConversionTable = new LinearTableLoader("default").load()
    assert(table.getSymbols.equals("$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "))
  }

  test("Load Paul Bourkes’ table linear table") {
    val table: LinearConversionTable = new LinearTableLoader("default").load()
    assert(table.getSymbols.equals("$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "))
  }

  test("Load custom linear table") {
    val table: LinearConversionTable = new LinearTableLoader("my table").load()
    assert(table.getSymbols.equals("my table"))
  }
}
