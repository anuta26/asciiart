package pixels

import domain.pixel.GreyscalePixel
import org.scalatest.FunSuite

class GreyscalePixelTest extends FunSuite {

  test("Get greyscale of pixel") {
  val pixel: GreyscalePixel = new GreyscalePixel(10)
  val symbol: Double = pixel.getGreyscale
  assert(symbol.equals(10.0))
}

  test("Set greyscale of pixel from 0 to 255") {
    val pixel: GreyscalePixel = new GreyscalePixel(10)
    pixel.setGreyscale(20)
    val symbol: Double = pixel.getGreyscale
    assert(symbol.equals(20.0))
  }

  test("Set greyscale of pixel less than 0") {
    val pixel: GreyscalePixel = new GreyscalePixel(10)
    assertThrows[IllegalStateException](pixel.setGreyscale(-10))
  }

  test("Set greyscale of pixel more than 255") {
    val pixel: GreyscalePixel = new GreyscalePixel(10)
    assertThrows[IllegalStateException](pixel.setGreyscale(260))
  }

}
