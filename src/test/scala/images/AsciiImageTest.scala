package images

import domain.grid.AsciiPixelGrid
import domain.image.AsciiImage
import domain.pixel.AsciiPixel
import org.scalatest.FunSuite

class AsciiImageTest extends FunSuite {
  test("Get grid of ascii image"){
    val grid = new AsciiPixelGrid(Seq(
      Seq(
        new AsciiPixel('l'),
        new AsciiPixel('l')),
      Seq(
        new AsciiPixel('l'),
        new AsciiPixel('l'))))
    val image = new AsciiImage(grid)
    val newGrid = image.getGrid
    assert(grid.equals(newGrid))
  }

  test("Get width of ascii image 2x2"){
    val grid = new AsciiPixelGrid(Seq(
      Seq(
        new AsciiPixel('l'),
        new AsciiPixel('l')),
      Seq(
        new AsciiPixel('l'),
        new AsciiPixel('l'))))
    val image = new AsciiImage(grid)
    val width = image.getWidth

    assert(width == 2)
  }

  test("Get height of ascii image 2x2") {
    val grid = new AsciiPixelGrid(Seq(
      Seq(
        new AsciiPixel('l'),
        new AsciiPixel('l')),
      Seq(
        new AsciiPixel('l'),
        new AsciiPixel('l'))))
    val image = new AsciiImage(grid)
    val height = image.getHeight

    assert(height == 2)
  }

  test("Get width of ascii image 2x1") {
    val grid = new AsciiPixelGrid(Seq(
      Seq(
        new AsciiPixel('l')),
      Seq(
        new AsciiPixel('l'))))
    val image = new AsciiImage(grid)
    val width = image.getWidth

    assert(width == 1)
  }

  test("Get height of ascii image 2x1") {
    val grid = new AsciiPixelGrid(Seq(
      Seq(
        new AsciiPixel('l')),
      Seq(
        new AsciiPixel('l'))))
    val image = new AsciiImage(grid)
    val height = image.getHeight

    assert(height == 2)
  }

  test("Get width of ascii image 0x0") {
    val grid = new AsciiPixelGrid(Seq.empty)
    val image = new AsciiImage(grid)
    val width = image.getWidth

    assert(width == 0)
  }

  test("Get height of ascii image 0x0") {
    val grid = new AsciiPixelGrid(Seq.empty)
    val image = new AsciiImage(grid)
    val height = image.getHeight

    assert(height == 0)
  }

  test("Get element with correct indexes") {
    val grid = new AsciiPixelGrid(Seq(
      Seq(
        new AsciiPixel('A'),
        new AsciiPixel('B')),
      Seq(
        new AsciiPixel('C'),
        new AsciiPixel('D'))))
    val image = new AsciiImage(grid)
    val pixel: AsciiPixel = image.getElement(1,0)

    assert (pixel.getChar.equals('C'))
  }

  test("Get element with incorrect indexes") {
    val grid = new AsciiPixelGrid(Seq(
      Seq(
        new AsciiPixel('A'),
        new AsciiPixel('B')),
      Seq(
        new AsciiPixel('C'),
        new AsciiPixel('D'))))
    val image = new AsciiImage(grid)
    assertThrows[IllegalStateException](image.getElement(2,2))
  }


}
