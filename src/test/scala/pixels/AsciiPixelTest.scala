package pixels

import domain.pixel.AsciiPixel
import org.scalatest.FunSuite

class AsciiPixelTest extends FunSuite {

  test("Get symbol of pixel") {
    val pixel: AsciiPixel = new AsciiPixel('c')
    val symbol: Char = pixel.getChar
    assert(symbol.equals('c'))
  }

}
