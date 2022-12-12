package domain.grid

import domain.pixel.GreyscalePixel

/** Grid of greyscale pixels
 *
 * @param _pixels sequence of symbols of type GreyscalePixel
 */
class GreyscalePixelGrid(private var _pixels: Seq[Seq[GreyscalePixel]])
    extends PixelGrid[GreyscalePixel] {
  private val _height: Int = _pixels.length
  private val _width: Int =
    if (_height == 0)
      0
    else
      _pixels.head.length
  def pixels: Seq[Seq[GreyscalePixel]] = _pixels

  def getElement(x: Int, y: Int): GreyscalePixel = {
    if (x < 0 || x >= _height || y < 0 || y >= _width) {
      throw new IllegalStateException("Index is out of borders.")
    }
    _pixels(x)(y)
  }

  def height: Int = _height
  def width: Int = _width
}
