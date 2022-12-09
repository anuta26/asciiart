package domain.grid

import domain.pixel.Pixel

trait Grid[T] {
  def getElement(x: Int, y: Int): T
  def width: Int
  def height: Int
}
