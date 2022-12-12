package converters

import business.converters.ToAsciiImageLinearConverter
import domain.grid.GreyscalePixelGrid
import domain.image.GreyscaleImage
import domain.pixel.GreyscalePixel
import domain.tables.LinearConversionTable
import org.scalatest.FunSuite

class ToAsciiImageLinearConverterTest extends FunSuite {
  test("Convert image 2x2 with default linear table") {
    val grid: GreyscalePixelGrid = new GreyscalePixelGrid(
      Seq(
        Seq(new GreyscalePixel(50), new GreyscalePixel(100)),
        Seq(new GreyscalePixel(200), new GreyscalePixel(255))))
    val image = new GreyscaleImage(grid)
    val table = new LinearConversionTable(
      "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ")
    val converter = new ToAsciiImageLinearConverter(table)
    val asciiImage = converter.convert(image)

    assert(asciiImage.getElement(0, 0).getChar == 'k')
    assert(asciiImage.getElement(0, 1).getChar == 'U')
    assert(asciiImage.getElement(1, 0).getChar == '~')
    assert(asciiImage.getElement(1, 1).getChar == ' ')
  }
  test("Convert image 2x1 with default linear table") {
    val grid: GreyscalePixelGrid = new GreyscalePixelGrid(
      Seq(Seq(new GreyscalePixel(0)), Seq(new GreyscalePixel(255))))
    val image = new GreyscaleImage(grid)
    val table = new LinearConversionTable(
      "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ")
    val converter = new ToAsciiImageLinearConverter(table)
    val asciiImage = converter.convert(image)

    assert(asciiImage.getElement(0, 0).getChar == '$')
    assert(asciiImage.getElement(1, 0).getChar == ' ')

  }
  test("Convert image 0x0 with default linear table") {
    val grid: GreyscalePixelGrid =
      new GreyscalePixelGrid(Seq.empty.appended(Seq.empty))
    val image = new GreyscaleImage(grid)
    val table = new LinearConversionTable(
      "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ")
    val converter = new ToAsciiImageLinearConverter(table)
    val asciiImage = converter.convert(image)

    assert(asciiImage.getGrid.pixels.equals(Seq.empty.appended(Seq.empty)))
  }
  test("Convert image 2x2 with custom linear table") {
    val grid: GreyscalePixelGrid = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(50),
          new GreyscalePixel(100)),
        Seq(
          new GreyscalePixel(150),
          new GreyscalePixel(200))))

    val image = new GreyscaleImage(grid)

    val table = new LinearConversionTable(
      "ABCD")
    val converter = new ToAsciiImageLinearConverter(table)

    val asciiImage = converter.convert(image)

    assert(asciiImage.getElement(0, 0).getChar == 'A')
    assert(asciiImage.getElement(0, 1).getChar == 'B')
    assert(asciiImage.getElement(1, 0).getChar == 'C')
    assert(asciiImage.getElement(1, 1).getChar == 'D')
  }
  test("Convert image 2x1 with custom linear table") {
    val grid: GreyscalePixelGrid = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(50)),
        Seq(
          new GreyscalePixel(200))))

    val image = new GreyscaleImage(grid)

    val table = new LinearConversionTable("ABCD")
    val converter = new ToAsciiImageLinearConverter(table)

    val asciiImage = converter.convert(image)

    assert(asciiImage.getElement(0, 0).getChar == 'A')
    assert(asciiImage.getElement(1, 0).getChar == 'D')

  }
  test("Convert image 0x0 with custom linear table") {
    val grid: GreyscalePixelGrid =
      new GreyscalePixelGrid(Seq.empty.appended(Seq.empty))
    val image = new GreyscaleImage(grid)
    val table = new LinearConversionTable(
      "ABCD")
    val converter = new ToAsciiImageLinearConverter(table)
    val asciiImage = converter.convert(image)

    assert(asciiImage.getGrid.pixels.equals(Seq.empty.appended(Seq.empty)))

  }
  test("Convert image 2x2 with empty linear table") {
    val grid: GreyscalePixelGrid = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(50),
          new GreyscalePixel(100)),
        Seq(
          new GreyscalePixel(200),
          new GreyscalePixel(250))))

    val image = new GreyscaleImage(grid)

    val table = new LinearConversionTable(
      "")
    val converter = new ToAsciiImageLinearConverter(table)

    val asciiImage = converter.convert(image)

    assert(asciiImage.getGrid.pixels.equals(Seq.empty.appended(Seq.empty)))
  }

}
