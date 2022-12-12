package images

import domain.grid.GreyscalePixelGrid
import domain.image.GreyscaleImage
import domain.pixel.GreyscalePixel
import org.scalatest.FunSuite

class GreyscaleImageTest extends FunSuite{
  test("Get grid of ascii image") {
    val grid = new GreyscalePixelGrid(Seq(
      Seq(
        new GreyscalePixel(255),
        new GreyscalePixel(255)),
      Seq(
        new GreyscalePixel(255),
        new GreyscalePixel(255))))
    val image = new GreyscaleImage(grid)
    val newGrid = image.getGrid
    assert(grid.equals(newGrid))
  }

  test("Get width of ascii image 2x2") {
    val grid = new GreyscalePixelGrid(Seq(
      Seq(
        new GreyscalePixel(255),
        new GreyscalePixel(255)),
      Seq(
        new GreyscalePixel(255),
        new GreyscalePixel(255))))
    val image = new GreyscaleImage(grid)
    val width = image.getWidth

    assert(width == 2)
  }

  test("Get height of ascii image 2x2") {
    val grid = new GreyscalePixelGrid(Seq(
      Seq(
        new GreyscalePixel(255),
        new GreyscalePixel(255)),
      Seq(
        new GreyscalePixel(255),
        new GreyscalePixel(255))))
    val image = new GreyscaleImage(grid)
    val height = image.getHeight

    assert(height == 2)
  }

  test("Get width of ascii image 2x1") {
    val grid = new GreyscalePixelGrid(Seq(
      Seq(
        new GreyscalePixel(255)),
      Seq(
        new GreyscalePixel(255))))
    val image = new GreyscaleImage(grid)
    val width = image.getWidth

    assert(width == 1)
  }

  test("Get height of ascii image 2x1") {
    val grid = new GreyscalePixelGrid(Seq(
      Seq(
        new GreyscalePixel(255)),
      Seq(
        new GreyscalePixel(255))))
    val image = new GreyscaleImage(grid)
    val height = image.getHeight

    assert(height == 2)
  }

  test("Get width of ascii image 0x0") {
    val grid = new GreyscalePixelGrid(Seq.empty)
    val image = new GreyscaleImage(grid)
    val width = image.getWidth

    assert(width == 0)
  }

  test("Get height of ascii image 0x0") {
    val grid = new GreyscalePixelGrid(Seq.empty)
    val image = new GreyscaleImage(grid)
    val height = image.getHeight

    assert(height == 0)
  }

  test("Get element with correct indexes") {
    val grid = new GreyscalePixelGrid(Seq(
      Seq(
        new GreyscalePixel(255),
        new GreyscalePixel(200)),
      Seq(
        new GreyscalePixel(100),
        new GreyscalePixel(50))))
    val image = new GreyscaleImage(grid)
    val pixel: GreyscalePixel = image.getElement(1, 0)

    assert(pixel.getGreyscale.equals(100.0))
  }

  test("Get element with incorrect indexes") {
    val grid = new GreyscalePixelGrid(Seq(
      Seq(
        new GreyscalePixel(255),
        new GreyscalePixel(200)),
      Seq(
        new GreyscalePixel(100),
        new GreyscalePixel(50))))
    val image = new GreyscaleImage(grid)
    assertThrows[IllegalStateException](image.getElement(2, 2))
  }



}
