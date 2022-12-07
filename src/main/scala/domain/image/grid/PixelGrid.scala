package domain.image.grid

import domain.image.Pixel

class PixelGrid(private var _pixels: Array[Array[Pixel]]) extends Grid[Pixel]{
  private val _width: Int = _pixels.length
  private val _height: Int = _pixels(0).length
  def pixels: Array[Array[Pixel]] = _pixels

  def getElement(x: Int, y: Int): Pixel = {
    _pixels(x)(y)
  }
  def width: Int = _width
  def height: Int = _height


}
