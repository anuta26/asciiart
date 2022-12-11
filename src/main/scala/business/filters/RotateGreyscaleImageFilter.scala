package business.filters

import domain.grid.GreyscalePixelGrid
import domain.image.GreyscaleImage
import domain.pixel.GreyscalePixel

/** Filter which rotates image by certain number of degrees
 *  +90 degrees rotate one time to right
 *  -90 degrees rotate one time to left
 *
 *  The number of degrees must be a multiply of 90
 *
 * @param degree number of degrees to rotate
 */
class RotateGreyscaleImageFilter(private var degree: Int)
    extends GreyscaleImageFilter {
  /** Rotates image by certain degrees
   *
   * @param image image to be filtered
   *  @return result image
   */
  override def apply(image: GreyscaleImage): GreyscaleImage = {
    if (degree % 90 != 0)
      throw new IllegalArgumentException("Unsupportable rotate degree.")
    degree = (degree / 90) % 4
    if (degree < 0)
      degree = degree + 4

    val rotatePixels =
      Array.ofDim[GreyscalePixel](image.getHeight, image.getWidth)
    var grid: GreyscalePixelGrid = new GreyscalePixelGrid(
      rotatePixels.map(array => array.toSeq))

    degree match {
      case 1 =>
        grid = rotate(image.getGrid)
      case 2 =>
        grid = rotate(image.getGrid)
        grid = rotate(grid)
      case 3 =>
        grid = rotate(image.getGrid)
        grid = rotate(grid)
        grid = rotate(grid)
      case 0 =>
        grid = image.getGrid

    }
    new GreyscaleImage(grid)
  }

  /** Rotates image 90 degrees to right
   *
   * @param grid grid of image to rotate
   * @return rotated grid
   */
  def rotate(grid: GreyscalePixelGrid): GreyscalePixelGrid = {
    val rotatePixels = Array.ofDim[GreyscalePixel](grid.height, grid.width)
    for {
      y <- 0 until grid.height
    } for (x <- 0 until grid.width)
      rotatePixels(y)(grid.width - 1 - x ) = grid.getElement(x, y)
    new GreyscalePixelGrid(rotatePixels.map(array => array.toSeq))
  }
}
