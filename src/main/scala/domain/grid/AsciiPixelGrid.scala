package domain.grid

import domain.pixel.AsciiPixel

/** Grid of AsciiPixel elements
 *
 * @param _symbols sequence of symbols of type AsciiPixel
 */
class AsciiPixelGrid(private var _symbols: Seq[Seq[AsciiPixel]]) extends Grid[AsciiPixel] {
  private val _width: Int = _symbols.length
  private val _height: Int = _symbols.head.length
  def pixels: Seq[Seq[AsciiPixel]] = _symbols

  def getElement(x: Int, y: Int): AsciiPixel =
    _symbols(x)(y)
  def width: Int = _width
  def height: Int = _height

}
