package ui

import business.filters.RotateGreyscaleImageFilter
import org.scalatest.FunSuite

class ArgumentParserTest extends FunSuite {

  test("Parse correct arguments") {
    val args = Array(
      "--table",
      "non-linear",
      "--image",
      "src/test/resources/test-image.png",
      "--output-file",
      "out2.txt",
      "--rotate",
      "+90",
      "--invert",
      "--brightness",
      "20",
      "--invert"
    )
    val parser: ArgumentsParser = new ArgumentsParser
    val result: Boolean = parser.parse(args)

    assert(result.equals(true))
  }

  test("Parse correct arguments only input and output") {
    val args = Array(
      "--image",
      "src/test/resources/test-image.png",
      "--output-file",
      "out2.txt"
    )
    val parser: ArgumentsParser = new ArgumentsParser
    val result: Boolean = parser.parse(args)

    assert(result.equals(true))
  }

  test("Parse correct arguments with filters") {
    val args = Array(
      "--image",
      "src/test/resources/test-image.png",
      "--output-file",
      "out2.txt",
      "--rotate",
      "+90",
      "--invert",
      "--brightness",
      "20",
      "--invert"
    )
    val parser: ArgumentsParser = new ArgumentsParser
    val result: Boolean = parser.parse(args)

    assert(result.equals(true))
  }

  test("Parse incorrect arguments: without input") {
    val args = Array(
      "--output-file",
      "out2.txt"
    )
    val parser: ArgumentsParser = new ArgumentsParser
    assertThrows[IllegalArgumentException](parser.parse(args))
  }

  test("Parse incorrect arguments: without output") {
    val args = Array(
      "--image",
      "src/test/resources/test-image.png",
      "--rotate",
      "+90",
      "--invert",
      "--brightness",
      "20",
      "--invert"
    )
    val parser: ArgumentsParser = new ArgumentsParser
    assertThrows[IllegalArgumentException](parser.parse(args))
  }

  test("Parse path to load: --image") {
    val args = Array(
      "--image",
      "src/test/resources/test-image.png",
      "--rotate",
      "+90",
      "--invert",
      "--brightness",
      "20",
      "--invert"
    )
    val parser: ArgumentsParser = new ArgumentsParser
    parser.parsePathToLoad(args)
    val pathToLoad: String = parser.pathToLoad
    assert(pathToLoad.equals("src/test/resources/test-image.png"))
  }

  test("Parse path to load: --image-random") {
    val args = Array(
      "--image-random",
      "--rotate",
      "+90",
      "--invert",
      "--brightness",
      "20",
      "--invert"
    )
    val parser: ArgumentsParser = new ArgumentsParser
    parser.parsePathToLoad(args)
    val pathToLoad: String = parser.pathToLoad
    assert(pathToLoad.equals("--image-random"))
  }

  test("Parse path to load: no path") {
    val args = Array(
      "--rotate",
      "+90",
      "--invert",
      "--brightness",
      "20",
      "--invert"
    )
    val parser: ArgumentsParser = new ArgumentsParser
    assertThrows[IllegalArgumentException](parser.parsePathToLoad(args))
  }

  test("Parse outputs: --output-console, --output-file") {
    val args = Array(
      "--image",
      "src/test/resources/test-image.png",
      "--output-file",
      "out2.txt",
      "--output-console",
      "--rotate",
      "+90",
      "--invert",
      "--brightness",
      "20",
      "--invert"
    )
    val parser: ArgumentsParser = new ArgumentsParser
    parser.parseOutputs(args)
    assert(parser.outputs(0).equals("--output-console"))
    assert(parser.outputs(1).equals("out2.txt"))
  }

  test("Parse outputs: --output-console") {
    val args = Array(
      "--image",
      "src/test/resources/test-image.png",
      "--output-console",
      "--rotate",
      "+90",
      "--invert",
      "--brightness",
      "20",
      "--invert"
    )
    val parser: ArgumentsParser = new ArgumentsParser
    parser.parseOutputs(args)
    assert(parser.outputs(0).equals("--output-console"))
    assert(parser.outputs.length == 1)
  }

  test("Parse outputs: --output-file") {
    val args = Array(
      "--image",
      "src/test/resources/test-image.png",
      "--output-file",
      "out2.txt",
      "--rotate",
      "+90",
      "--invert",
      "--brightness",
      "20",
      "--invert"
    )
    val parser: ArgumentsParser = new ArgumentsParser
    parser.parseOutputs(args)
    assert(parser.outputs(0).equals("out2.txt"))
    assert(parser.outputs.length == 1)
  }

  test("Parse outputs: no outputs") {
    val args = Array(
      "--image",
      "src/test/resources/test-image.png",
      "--rotate",
      "+90",
      "--invert",
      "--brightness",
      "20",
      "--invert"
    )
    val parser: ArgumentsParser = new ArgumentsParser
    assertThrows[IllegalArgumentException](parser.parseOutputs(args))
  }

  test("Parse table: --custom-table") {
    val args = Array(
      "--image",
      "src/test/resources/test-image.png",
      "--output-file",
      "out2.txt",
      "--custom-table",
      "ABCD"
    )
    val parser: ArgumentsParser = new ArgumentsParser
    parser.parseTable(args)
    val table: String = parser.table

    assert(table.equals("ABCD"))
  }

  test("Parse table: --table") {
    val args = Array(
      "--image",
      "src/test/resources/test-image.png",
      "--output-file",
      "out2.txt",
      "--table",
      "non-linear"
    )
    val parser: ArgumentsParser = new ArgumentsParser
    parser.parseTable(args)
    val table: String = parser.table

    assert(table.equals("non-linear"))
  }

  test("Parse table: no table") {
    val args = Array(
      "--image",
      "src/test/resources/test-image.png",
      "--output-file",
      "out2.txt"
    )
    val parser: ArgumentsParser = new ArgumentsParser
    parser.parseTable(args)
    val table: String = parser.table

    assert(table.equals("default"))
  }

  test("Parse filters: --rotate, --brightness, --invert"){
    val args = Array(
      "--image",
      "src/test/resources/test-image.png",
      "--output-file",
      "out2.txt",
      "--rotate",
      "+90",
      "--brightness",
      "20",
      "--invert"
    )
    val parser: ArgumentsParser = new ArgumentsParser
    parser.parseFilters(args)
    assert(parser.filters(0).getClass.getName.equals("business.filters.RotateGreyscaleImageFilter"))
    assert(parser.filters(1).getClass.getName.equals("business.filters.BrightnessGreyscaleImageFilter"))
    assert(parser.filters(2).getClass.getName.equals("business.filters.InvertGreyscaleImageFilter"))

  }


}
