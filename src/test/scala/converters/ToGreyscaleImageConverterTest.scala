package converters

import business.converters.ToGreyscaleImageConverter
import domain.grid.RGBPixelGrid
import domain.image.RGBImage
import domain.pixel.RGBPixel
import org.scalatest.FunSuite

class ToGreyscaleImageConverterTest extends FunSuite{
  val converter = new ToGreyscaleImageConverter()

  test("Convert 2x2 rgb image to greyscale image"){
    val grid: RGBPixelGrid = new RGBPixelGrid(
      Seq(
        Seq(new RGBPixel(0,0,0), new RGBPixel(50,50,50)),
        Seq(new RGBPixel(100,100,100), new RGBPixel(255,255,255))))
    val image = new RGBImage(grid)
    val greyscaleImage = converter.convert(image)

    assert(greyscaleImage.getElement(0, 0).getGreyscale == 0.3 * 0 + 0.59 * 0 + 0.11 * 0)
    assert(greyscaleImage.getElement(0, 1).getGreyscale == 0.3 * 50 + 0.59 * 50 + 0.11 * 50)
    assert(greyscaleImage.getElement(1, 0).getGreyscale == 0.3 * 100 + 0.59 * 100 + 0.11 * 100)
    assert(greyscaleImage.getElement(1, 1).getGreyscale == 0.3 * 255 + 0.59 * 255 + 0.11 * 255)
  }
  test("Convert 2x1 rgb image to greyscale image") {
    val grid: RGBPixelGrid = new RGBPixelGrid(
      Seq(
        Seq(new RGBPixel(0, 0, 0)),
        Seq(new RGBPixel(100, 100, 100))))
    val image = new RGBImage(grid)
    val greyscaleImage = converter.convert(image)

    assert(greyscaleImage.getElement(0, 0).getGreyscale == 0.3 * 0 + 0.59 * 0 + 0.11 * 0)
    assert(greyscaleImage.getElement(1, 0).getGreyscale == 0.3 * 100 + 0.59 * 100 + 0.11 * 100)
  }
  test("Convert 1x2 rgb image to greyscale image") {
    val grid: RGBPixelGrid = new RGBPixelGrid(
      Seq(
        Seq(new RGBPixel(0, 0, 0), new RGBPixel(50, 50, 50))))
    val image = new RGBImage(grid)
    val greyscaleImage = converter.convert(image)

    assert(greyscaleImage.getElement(0, 0).getGreyscale == 0.3 * 0 + 0.59 * 0 + 0.11 * 0)
    assert(greyscaleImage.getElement(0, 1).getGreyscale == 0.3 * 50 + 0.59 * 50 + 0.11 * 50)
  }
  test("Convert 0x0 rgb image to greyscale image") {
    val grid: RGBPixelGrid = new RGBPixelGrid(
      Seq.empty.appended(Seq.empty))
    val image = new RGBImage(grid)
    val greyscaleImage = converter.convert(image)

    assert(greyscaleImage.getGrid.pixels.equals(Seq.empty.appended(Seq.empty)))
  }

}
