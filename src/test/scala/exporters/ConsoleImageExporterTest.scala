package exporters

import business.exporters.ConsoleImageExporter
import domain.grid.AsciiPixelGrid
import domain.image.AsciiImage
import domain.pixel.AsciiPixel
import org.scalatest.FunSuite

import java.io.{ByteArrayOutputStream, PrintStream}

class ConsoleImageExporterTest extends FunSuite {

  test("Export to console 2x2 image") {
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

    val out: ByteArrayOutputStream = new ByteArrayOutputStream()
    val printStream: PrintStream = new PrintStream(out)
    printStream.flush()

    val exporter = new ConsoleImageExporter(printStream)
    exporter.export(image)

    assert("AB\r\nCD\r\n".equals(out.toString))
  }

  test("Export to console 2x1 image") {
    val grid: AsciiPixelGrid
    = new AsciiPixelGrid(
      Seq(
        Seq(
          new AsciiPixel('A')),
        Seq(
          new AsciiPixel('C'))))

    val image: AsciiImage = new AsciiImage(grid)

    val out: ByteArrayOutputStream = new ByteArrayOutputStream()
    val printStream: PrintStream = new PrintStream(out)
    printStream.flush()

    val exporter = new ConsoleImageExporter(printStream)
    exporter.export(image)

    assert("A\r\nC\r\n".equals(out.toString))
  }

  test("Export to console 1x2 image") {
    val grid: AsciiPixelGrid
    = new AsciiPixelGrid(
        Seq(
          Seq(
            new AsciiPixel('A'),
            new AsciiPixel('B'))))

    val image: AsciiImage = new AsciiImage(grid)

    val out: ByteArrayOutputStream = new ByteArrayOutputStream()
    val printStream: PrintStream = new PrintStream(out)
    printStream.flush()

    val exporter = new ConsoleImageExporter(printStream)
    exporter.export(image)

    assert("AB\r\n".equals(out.toString))

  }

  test("Export to console 0x0 image") {
    val grid: AsciiPixelGrid
    = new AsciiPixelGrid(Seq.empty.appended(Seq.empty))

    val image: AsciiImage = new AsciiImage(grid)

    val out: ByteArrayOutputStream = new ByteArrayOutputStream()
    val printStream: PrintStream = new PrintStream(out)
    printStream.flush()

    val exporter = new ConsoleImageExporter(printStream)
    exporter.export(image)

    assert("\r\n".equals(out.toString))
  }

}
