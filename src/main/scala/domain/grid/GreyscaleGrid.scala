package domain.grid

import domain.pixel.GreyscalePixel

/** Grid of greyscale pixels
 *
 * @param _pixels sequence of symbols of type GreyscalePixel
 */
class GreyscaleGrid(private var _pixels: Seq[Seq[GreyscalePixel]])
    extends Grid[GreyscalePixel] {
  private val _width: Int = _pixels.length
  private val _height: Int = _pixels.head.length
  def pixels: Seq[Seq[GreyscalePixel]] = _pixels

  def getElement(x: Int, y: Int): GreyscalePixel =
    _pixels(x)(y)
  def width: Int = _width
  def height: Int = _height
}
