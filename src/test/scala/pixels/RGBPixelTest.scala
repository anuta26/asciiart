package pixels

import domain.pixel.RGBPixel
import org.scalatest.FunSuite

class RGBPixelTest extends FunSuite {

  test("Get red value of pixel") {
    val pixel: RGBPixel = new RGBPixel(10, 15, 20)
    val value: Int = pixel.red
    assert(value.equals(10))
  }
  test("Get green value of pixel") {
    val pixel: RGBPixel = new RGBPixel(10, 15, 20)
    val value: Int = pixel.green
    assert(value.equals(15))
  }
  test("Get blue value of pixel") {
    val pixel: RGBPixel = new RGBPixel(10, 15, 20)
    val value: Int = pixel.blue
    assert(value.equals(20))
  }

}
