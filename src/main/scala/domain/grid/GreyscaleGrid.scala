package domain.grid

import domain.pixel.GreyscalePixel

class GreyscaleGrid(private var _pixels: Array[Array[GreyscalePixel]]) extends Grid[GreyscalePixel]{
  private val _width: Int = _pixels.length
  private val _height: Int = _pixels(0).length
  def pixels: Array[Array[GreyscalePixel]] = _pixels

  def getElement(x: Int, y: Int): GreyscalePixel = {
    _pixels(x)(y)
  }
  def width: Int = _width
  def height: Int = _height
}
