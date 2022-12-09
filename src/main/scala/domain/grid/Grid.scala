package domain.grid

/** Grid of type T
 *
 * @tparam T type of grid elements
 */
trait Grid[T] {
  def getElement(x: Int, y: Int): T
  def width: Int
  def height: Int
}
