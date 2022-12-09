package domain.grid

import domain.pixel.RGBPixel

class PixelGrid(private var _pixels: Array[Array[RGBPixel]]) extends Grid[RGBPixel]{
  private val _width: Int = _pixels.length
  private val _height: Int = _pixels(0).length
  def pixels: Array[Array[RGBPixel]] = _pixels

  def getElement(x: Int, y: Int): RGBPixel = {
    _pixels(x)(y)
  }
  def width: Int = _width
  def height: Int = _height
}
