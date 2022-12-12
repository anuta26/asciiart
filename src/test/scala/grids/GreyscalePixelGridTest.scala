package grids

import domain.grid.GreyscalePixelGrid
import domain.pixel.GreyscalePixel
import org.scalatest.FunSuite

class GreyscalePixelGridTest extends FunSuite {

  test("Get width of ascii grid 2x2") {
    val grid = new GreyscalePixelGrid(
      Seq(
        Seq(new GreyscalePixel(250), new GreyscalePixel(250)),
        Seq(new GreyscalePixel(250), new GreyscalePixel(250))))
    val width = grid.width

    assert(width == 2)
  }

  test("Get height of ascii grid 2x2") {
    val grid = new GreyscalePixelGrid(
      Seq(
        Seq(new GreyscalePixel(250), new GreyscalePixel(250)),
        Seq(new GreyscalePixel(250), new GreyscalePixel(250))))
    val height = grid.height

    assert(height == 2)
  }

  test("Get width of ascii grid 2x1") {
    val grid = new GreyscalePixelGrid(
      Seq(Seq(new GreyscalePixel(250)), Seq(new GreyscalePixel(250))))
    val width = grid.width

    assert(width == 1)
  }

  test("Get height of ascii grid 2x1") {
    val grid = new GreyscalePixelGrid(
      Seq(Seq(new GreyscalePixel(250)), Seq(new GreyscalePixel(250))))
    val height = grid.height

    assert(height == 2)
  }

  test("Get width of ascii grid 0x0") {
    val grid = new GreyscalePixelGrid(Seq.empty)
    val width = grid.width

    assert(width == 0)
  }

  test("Get height of ascii grid 0x0") {
    val grid = new GreyscalePixelGrid(Seq.empty)
    val height = grid.height

    assert(height == 0)
  }

  test("Get element with correct indexes") {
    val grid = new GreyscalePixelGrid(
      Seq(
        Seq(new GreyscalePixel(250), new GreyscalePixel(200)),
        Seq(new GreyscalePixel(150), new GreyscalePixel(100))))
    val pixel: GreyscalePixel = grid.getElement(1, 0)

    assert(pixel.getGreyscale.equals(150.0))
  }

  test("Get element with incorrect indexes") {
    val grid = new GreyscalePixelGrid(
      Seq(
        Seq(new GreyscalePixel(250), new GreyscalePixel(200)),
        Seq(new GreyscalePixel(150), new GreyscalePixel(100))))
    assertThrows[IllegalStateException](grid.getElement(2, 2))
  }

}
