package domain.pixel

/** Pixel which contains rgb values
 *
 * @param _red red value from 0 to 255
 * @param _green green value from 0 to 255
 * @param _blue blue value from 0 to 255
 */
class RGBPixel(_red: Int, _green: Int, _blue: Int) extends Pixel{
  private var _greyscale: Double = 0.3 * red + 0.59 * green + 0.11 * blue
  def red: Int = _red
  def green: Int = _green
  def blue: Int = _blue
  def greyscale: Double = _greyscale

  def setGreyscale(value: Double): Unit = {
    _greyscale = value
  }
}
