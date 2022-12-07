package domain.image.grid

trait Grid[T] {
  def getElement(x: Int, y: Int): T
  def width: Int
  def height: Int
}
