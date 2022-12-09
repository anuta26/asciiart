package business.filters

import domain.grid.GreyscaleGrid
import domain.image.GreyscaleImage
import domain.pixel.GreyscalePixel

class RotateGreyscaleImageFilter(private var degree: Int) extends GreyscaleImageFilter {
  override def apply(image: GreyscaleImage): GreyscaleImage = {
    if (degree % 90 != 0)
      throw new IllegalArgumentException("Unsupportable rotate degree.")
    degree = (degree / 90) % 4
    if (degree < 0)
      degree = degree + 4

    val rotatePixels = Array.ofDim[GreyscalePixel](image.getHeight, image.getWidth)
    var grid: GreyscaleGrid = new GreyscaleGrid(rotatePixels)

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

  def rotate(grid: GreyscaleGrid): GreyscaleGrid = {
    val rotatePixels = Array.ofDim[GreyscalePixel](grid.height, grid.width)
    for {
      y <- 0 until grid.height
    } for (x <- 0 until grid.width)
      rotatePixels(grid.height - 1 - y)(x) = grid.getElement(x, y)
    new GreyscaleGrid(rotatePixels)
  }
}
