package domain.image

class Pixel (_red: Int, _green: Int, _blue: Int) {
  private var _greyscale: Double = ((0.3 * red) + (0.59 * green) + (0.11 * blue))
  def red: Int = _red
  def green: Int = _green
  def blue: Int = _blue
  def greyscale: Double = _greyscale

  def setGreyscale(value: Double): Unit = {
    _greyscale = value
  }
}
