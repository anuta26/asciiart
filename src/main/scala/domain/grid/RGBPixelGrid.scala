package domain.grid

import domain.pixel.RGBPixel

/** Grid of RGB pixels
 *
 * @param _pixels sequence of symbols of type RGBPixel
 */
class RGBPixelGrid(private var _pixels: Seq[Seq[RGBPixel]])
    extends PixelGrid[RGBPixel] {
  private val _height: Int = _pixels.length
  private val _width: Int =
    if (_height == 0)
      0
    else
      _pixels.head.length
  def pixels: Seq[Seq[RGBPixel]] = _pixels

  def getElement(x: Int, y: Int): RGBPixel = {
    if (x < 0 || x >= _height || y < 0 || y >= _width) {
      throw new IllegalStateException("Index is out of borders.")
    }
    _pixels(x)(y)
  }

  def height: Int = _height
  def width: Int = _width
}
