package domain.grid

import domain.pixel.RGBPixel

/** Grid of RGB pixels
 *
 * @param _pixels sequence of symbols of type RGBPixel
 */
class RGBPixelGrid(private var _pixels: Seq[Seq[RGBPixel]])
    extends Grid[RGBPixel] {
  private val _width: Int = _pixels.length
  private val _height: Int = _pixels.head.length
  def pixels: Seq[Seq[RGBPixel]] = _pixels

  def getElement(x: Int, y: Int): RGBPixel =
    _pixels(x)(y)
  def width: Int = _width
  def height: Int = _height
}
