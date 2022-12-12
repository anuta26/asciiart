package grids

import domain.grid.AsciiPixelGrid
import domain.pixel.AsciiPixel
import org.scalatest.FunSuite

class AsciiPixelGridTest extends FunSuite {

  test("Get width of ascii grid 2x2") {
    val grid = new AsciiPixelGrid(
      Seq(
        Seq(new AsciiPixel('l'), new AsciiPixel('l')),
        Seq(new AsciiPixel('l'), new AsciiPixel('l'))))
    val width = grid.width

    assert(width == 2)
  }

  test("Get height of ascii grid 2x2") {
    val grid = new AsciiPixelGrid(
      Seq(
        Seq(new AsciiPixel('l'), new AsciiPixel('l')),
        Seq(new AsciiPixel('l'), new AsciiPixel('l'))))
    val height = grid.height

    assert(height == 2)
  }

  test("Get width of ascii grid 2x1") {
    val grid = new AsciiPixelGrid(
      Seq(Seq(new AsciiPixel('l')), Seq(new AsciiPixel('l'))))
    val width = grid.width

    assert(width == 1)
  }

  test("Get height of ascii grid 2x1") {
    val grid = new AsciiPixelGrid(
      Seq(Seq(new AsciiPixel('l')), Seq(new AsciiPixel('l'))))
    val height = grid.height

    assert(height == 2)
  }

  test("Get width of ascii grid 0x0") {
    val grid = new AsciiPixelGrid(Seq.empty)
    val width = grid.width

    assert(width == 0)
  }

  test("Get height of ascii grid 0x0") {
    val grid = new AsciiPixelGrid(Seq.empty)
    val height = grid.height

    assert(height == 0)
  }

  test("Get element with correct indexes") {
    val grid = new AsciiPixelGrid(
      Seq(
        Seq(new AsciiPixel('A'), new AsciiPixel('B')),
        Seq(new AsciiPixel('C'), new AsciiPixel('D'))))
    val pixel: AsciiPixel = grid.getElement(1, 0)

    assert(pixel.getChar.equals('C'))
  }

  test("Get element with incorrect indexes") {
    val grid = new AsciiPixelGrid(
      Seq(
        Seq(new AsciiPixel('A'), new AsciiPixel('B')),
        Seq(new AsciiPixel('C'), new AsciiPixel('D'))))
    assertThrows[IllegalStateException](grid.getElement(2, 2))
  }

}
