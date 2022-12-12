package converters

import business.converters.ToAsciiImageNonLinearConverter
import domain.grid.GreyscalePixelGrid
import domain.image.GreyscaleImage
import domain.pixel.GreyscalePixel
import domain.tables.NonLinearConversionTable
import org.scalatest.FunSuite

class ToAsciiImageNonLinearConverterTest extends FunSuite {

  val table = new NonLinearConversionTable("$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ", 100)

  test("Convert image 2x2 with predefined non-linear table") {
    val grid: GreyscalePixelGrid = new GreyscalePixelGrid(
      Seq(
        Seq(new GreyscalePixel(50), new GreyscalePixel(100)),
        Seq(new GreyscalePixel(200), new GreyscalePixel(255))))
    val image = new GreyscaleImage(grid)
    val converter = new ToAsciiImageNonLinearConverter(table)
    val asciiImage = converter.convert(image)

    assert(asciiImage.getElement(0, 0).getChar == '$')
    assert(asciiImage.getElement(0, 1).getChar == '@')
    assert(asciiImage.getElement(1, 0).getChar == '1')
    assert(asciiImage.getElement(1, 1).getChar == ' ')
  }
  test("Convert image 2x1 with default non-linear table") {
    val grid: GreyscalePixelGrid = new GreyscalePixelGrid(
      Seq(Seq(new GreyscalePixel(0)), Seq(new GreyscalePixel(255))))
    val image = new GreyscaleImage(grid)
    val converter = new ToAsciiImageNonLinearConverter(table)
    val asciiImage = converter.convert(image)

    assert(asciiImage.getElement(0, 0).getChar == '$')
    assert(asciiImage.getElement(1, 0).getChar == ' ')

  }
  test("Convert image 1x2 with predefined non-linear table") {
    val grid: GreyscalePixelGrid = new GreyscalePixelGrid(
      Seq(
        Seq(new GreyscalePixel(50), new GreyscalePixel(100))))
    val image = new GreyscaleImage(grid)
    val converter = new ToAsciiImageNonLinearConverter(table)
    val asciiImage = converter.convert(image)

    assert(asciiImage.getElement(0, 0).getChar == '$')
    assert(asciiImage.getElement(0, 1).getChar == '@')
  }
  test("Convert image 0x0 with default non-linear table") {
    val grid: GreyscalePixelGrid =
      new GreyscalePixelGrid(Seq.empty.appended(Seq.empty))
    val image = new GreyscaleImage(grid)
    val converter = new ToAsciiImageNonLinearConverter(table)
    val asciiImage = converter.convert(image)

    assert(asciiImage.getGrid.pixels.equals(Seq.empty.appended(Seq.empty)))
  }
  test("Convert image 2x2 with greyscale value < 100 (range of predefined table) and with predefined non-linear table") {
    val grid: GreyscalePixelGrid = new GreyscalePixelGrid(
      Seq(
        Seq(new GreyscalePixel(0), new GreyscalePixel(50)),
        Seq(new GreyscalePixel(96), new GreyscalePixel(75))))
    val image = new GreyscaleImage(grid)
    val converter = new ToAsciiImageNonLinearConverter(table)
    val asciiImage = converter.convert(image)

    assert(asciiImage.getElement(0, 0).getChar == '$')
    assert(asciiImage.getElement(0, 1).getChar == '$')
    assert(asciiImage.getElement(1, 0).getChar == '$')
    assert(asciiImage.getElement(1, 1).getChar == '$')
  }

  test("Convert image 2x2 with greyscale value = 100 (range of predefined table) and with predefined non-linear table") {
    val grid: GreyscalePixelGrid = new GreyscalePixelGrid(
      Seq(
        Seq(new GreyscalePixel(100), new GreyscalePixel(100)),
        Seq(new GreyscalePixel(100), new GreyscalePixel(100))))
    val image = new GreyscaleImage(grid)
    val converter = new ToAsciiImageNonLinearConverter(table)
    val asciiImage = converter.convert(image)

    assert(asciiImage.getElement(0, 0).getChar == '@')
    assert(asciiImage.getElement(0, 1).getChar == '@')
    assert(asciiImage.getElement(1, 0).getChar == '@')
    assert(asciiImage.getElement(1, 1).getChar == '@')
  }

  test("Convert image 2x2 with greyscale value > 100 (range of predefined table) and with predefined non-linear table") {
    val grid: GreyscalePixelGrid = new GreyscalePixelGrid(
      Seq(
        Seq(new GreyscalePixel(150), new GreyscalePixel(200)),
        Seq(new GreyscalePixel(225), new GreyscalePixel(255))))
    val image = new GreyscaleImage(grid)
    val converter = new ToAsciiImageNonLinearConverter(table)
    val asciiImage = converter.convert(image)

    assert(asciiImage.getElement(0, 0).getChar == 'Q')
    assert(asciiImage.getElement(0, 1).getChar == '1')
    assert(asciiImage.getElement(1, 0).getChar == '>')
    assert(asciiImage.getElement(1, 1).getChar == ' ')
  }


}