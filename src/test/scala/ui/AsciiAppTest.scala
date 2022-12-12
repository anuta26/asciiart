package ui

import org.scalatest.FunSuite

class AsciiAppTest extends FunSuite {

  test("Run with correct arguments only input and output") {
    val args = Array(
      "--image",
      "src/test/resources/test-image.png",
      "--output-file",
      "out2.txt")
    val app: AsciiApp = new AsciiApp
    val result: Boolean = app.run(args)

    assert(result.equals(true))
  }

  test("Run with correct arguments with filters") {
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
      "--invert")
    val app: AsciiApp = new AsciiApp
    val result: Boolean = app.run(args)

    assert(result.equals(true))
  }

  test("Run with correct arguments with table") {
    val args = Array(
      "--image",
      "src/test/resources/test-image.png",
      "--output-file",
      "out2.txt",
      "--table",
      "non-linear")
    val app: AsciiApp = new AsciiApp
    val result: Boolean = app.run(args)

    assert(result.equals(true))
  }

  test("Run with wrong format of input file") {
    val args = Array(
      "--image",
      "src/test/resources/test-image.txt",
      "--output-file",
      "out2.txt")
    val app: AsciiApp = new AsciiApp
    assertThrows[IllegalArgumentException](app.run(args))
  }
}
