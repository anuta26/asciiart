package images

import domain.grid.RGBPixelGrid
import domain.image.RGBImage
import domain.pixel.RGBPixel
import org.scalatest.FunSuite

class RGBImageTest extends FunSuite {
  test("Get grid of rgb image"){
    val grid = new RGBPixelGrid(Seq(
      Seq(
        new RGBPixel(0,0,0),
        new RGBPixel(0,0,0)),
      Seq(
        new RGBPixel(0,0,0),
        new RGBPixel(0,0,0))))
    val image = new RGBImage(grid)
    val newGrid = image.getGrid
    assert(grid.equals(newGrid))
  }

  test("Get width of rgb image 2x2"){
    val grid = new RGBPixelGrid(Seq(
      Seq(
        new RGBPixel(0, 0, 0),
        new RGBPixel(0, 0, 0)),
      Seq(
        new RGBPixel(0, 0, 0),
        new RGBPixel(0, 0, 0))))
    val image = new RGBImage(grid)
    val width = image.getWidth

    assert(width == 2)
  }

  test("Get height of rgb image 2x2") {
    val grid = new RGBPixelGrid(Seq(
      Seq(
        new RGBPixel(0, 0, 0),
        new RGBPixel(0, 0, 0)),
      Seq(
        new RGBPixel(0, 0, 0),
        new RGBPixel(0, 0, 0))))
    val image = new RGBImage(grid)
    val height = image.getHeight

    assert(height == 2)
  }

  test("Get width of rgb image 2x1") {
    val grid = new RGBPixelGrid(Seq(
      Seq(
        new RGBPixel(0,0,0)),
      Seq(
        new RGBPixel(0,0,0))))
    val image = new RGBImage(grid)
    val width = image.getWidth

    assert(width == 1)
  }

  test("Get height of rgb image 2x1") {
    val grid = new RGBPixelGrid(Seq(
      Seq(
        new RGBPixel(0, 0, 0)),
      Seq(
        new RGBPixel(0, 0, 0))))
    val image = new RGBImage(grid)
    val height = image.getHeight

    assert(height == 2)
  }

  test("Get width of rgb image 0x0") {
    val grid = new RGBPixelGrid(Seq.empty)
    val image = new RGBImage(grid)
    val width = image.getWidth

    assert(width == 0)
  }

  test("Get height of image 0x0") {
    val grid = new RGBPixelGrid(Seq.empty)
    val image = new RGBImage(grid)
    val height = image.getHeight

    assert(height == 0)
  }

  test("Get element with correct indexes") {
    val grid = new RGBPixelGrid(Seq(
      Seq(
        new RGBPixel(0,0,0),
        new RGBPixel(10,10,10)),
      Seq(
        new RGBPixel(5,5,5),
        new RGBPixel(15,15,15))))
    val image = new RGBImage(grid)
    val pixel: RGBPixel = image.getElement(1,0)

    assert (pixel.red.equals(5))
    assert (pixel.green.equals(5))
    assert (pixel.blue.equals(5))

  }

  test("Get element with incorrect indexes") {
    val grid = new RGBPixelGrid(Seq(
      Seq(
        new RGBPixel(0, 0, 0),
        new RGBPixel(10, 10, 10)),
      Seq(
        new RGBPixel(5, 5, 5),
        new RGBPixel(15, 15, 15))))
    val image = new RGBImage(grid)
    assertThrows[IllegalStateException](image.getElement(2,2))
  }


}