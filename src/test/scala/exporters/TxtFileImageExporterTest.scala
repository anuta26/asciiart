package exporters

import business.exporters.TxtFileImageExporter
import domain.grid.AsciiPixelGrid
import domain.image.AsciiImage
import domain.pixel.AsciiPixel
import org.scalatest.FunSuite

import scala.io.Source

class TxtFileImageExporterTest extends FunSuite {

  test ("Export to txt file 2x2 image") {
    val grid: AsciiPixelGrid
    = new AsciiPixelGrid(
      Seq(
        Seq(
          new AsciiPixel('A'),
          new AsciiPixel('B')),
        Seq(
          new AsciiPixel('C'),
          new AsciiPixel('D'))))

    val image: AsciiImage = new AsciiImage(grid)

    val exporter = new TxtFileImageExporter("src/test/resources/output.txt")
    exporter.export(image)

    val bufferedSource = Source.fromFile("src/test/resources/output.txt")
    assert("AB" == bufferedSource.getLines().next())
    assert("CD" == bufferedSource.getLines().next())
    bufferedSource.close
  }

  test("Export to txt file 2x1 image") {
    val grid: AsciiPixelGrid
    = new AsciiPixelGrid(
      Seq(
        Seq(
          new AsciiPixel('A')),
        Seq(
          new AsciiPixel('C'))))

    val image: AsciiImage = new AsciiImage(grid)

    val exporter = new TxtFileImageExporter("src/test/resources/output.txt")
    exporter.export(image)

    val bufferedSource = Source.fromFile("src/test/resources/output.txt")
    assert("A" == bufferedSource.getLines().next())
    assert("C" == bufferedSource.getLines().next())
    bufferedSource.close
  }

  test("Export to txt file 1x2 image") {
    val grid: AsciiPixelGrid
    = new AsciiPixelGrid(
      Seq(
        Seq(
          new AsciiPixel('A'),
          new AsciiPixel('B'))))

    val image: AsciiImage = new AsciiImage(grid)

    val exporter = new TxtFileImageExporter("src/test/resources/output.txt")
    exporter.export(image)

    val bufferedSource = Source.fromFile("src/test/resources/output.txt")
    assert("AB" == bufferedSource.getLines().next())
    bufferedSource.close
  }
  test("Export to txt file 0x0 image") {
    val grid: AsciiPixelGrid
    = new AsciiPixelGrid(
      Seq.empty.appended(Seq.empty))

    val image: AsciiImage = new AsciiImage(grid)

    val exporter = new TxtFileImageExporter("src/test/resources/output.txt")
    exporter.export(image)

    val bufferedSource = Source.fromFile("src/test/resources/output.txt")
    assert("" == bufferedSource.getLines().next())
    bufferedSource.close
  }

}
