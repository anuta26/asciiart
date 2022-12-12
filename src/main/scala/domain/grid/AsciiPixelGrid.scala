package domain.grid

import domain.pixel.AsciiPixel

/** Grid of AsciiPixel elements
 *
 * @param _symbols sequence of symbols of type AsciiPixel
 */
class AsciiPixelGrid(private var _symbols: Seq[Seq[AsciiPixel]])
    extends PixelGrid[AsciiPixel] {
  private val _height: Int = _symbols.length
  private val _width: Int =
    if (_height == 0)
      0
    else
      _symbols.head.length
  def pixels: Seq[Seq[AsciiPixel]] = _symbols

  def getElement(x: Int, y: Int): AsciiPixel = {
    if (x < 0 || x >= _height || y < 0 || y >= _width)
      throw new IllegalStateException("Index is out of borders.")
    _symbols(x)(y)
  }

  def height: Int = _height
  def width: Int = _width

}
