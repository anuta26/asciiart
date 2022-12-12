package grids

import domain.grid.RGBPixelGrid
import domain.pixel.RGBPixel
import org.scalatest.FunSuite

class RGBPixelGridTest extends FunSuite {

  test("Get width of rgb grid 2x2") {
    val grid = new RGBPixelGrid(
      Seq(
        Seq(new RGBPixel(10,10,10), new RGBPixel(10,10,10)),
        Seq(new RGBPixel(10,10,10), new RGBPixel(10,10,10))))
    val width = grid.width

    assert(width == 2)
  }

  test("Get height of rgb grid 2x2") {
    val grid = new RGBPixelGrid(
      Seq(
        Seq(new RGBPixel(10,10,10), new RGBPixel(10,10,10)),
        Seq(new RGBPixel(10,10,10), new RGBPixel(10,10,10))))
    val height = grid.height

    assert(height == 2)
  }

  test("Get width of rgb grid 2x1") {
    val grid = new RGBPixelGrid(
      Seq(Seq(new RGBPixel(10,10,10)), Seq(new RGBPixel(10,10,10))))
    val width = grid.width

    assert(width == 1)
  }

  test("Get height of rgb grid 2x1") {
    val grid = new RGBPixelGrid(
      Seq(Seq(new RGBPixel(10,10,10)), Seq(new RGBPixel(10,10,10))))
    val height = grid.height

    assert(height == 2)
  }

  test("Get width of rgb grid 0x0") {
    val grid = new RGBPixelGrid(Seq.empty)
    val width = grid.width

    assert(width == 0)
  }

  test("Get height of rgb grid 0x0") {
    val grid = new RGBPixelGrid(Seq.empty)
    val height = grid.height

    assert(height == 0)
  }

  test("Get element with correct indexes") {
    val grid = new RGBPixelGrid(
      Seq(
        Seq(new RGBPixel(10,10,10), new RGBPixel(20,20,20)),
        Seq(new RGBPixel(30,30,30), new RGBPixel(40,40,40))))
    val pixel: RGBPixel = grid.getElement(1, 0)

    assert(pixel.red.equals(30))
    assert(pixel.green.equals(30))
    assert(pixel.blue.equals(30))

  }

  test("Get element with incorrect indexes") {
    val grid = new RGBPixelGrid(
      Seq(
        Seq(new RGBPixel(10, 10, 10), new RGBPixel(20, 20, 20)),
        Seq(new RGBPixel(30, 30, 30), new RGBPixel(40, 40, 40))))
    assertThrows[IllegalStateException](grid.getElement(2, 2))
  }

}
