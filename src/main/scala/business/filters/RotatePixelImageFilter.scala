package business.filters

import domain.image.grid.PixelGrid
import domain.image.{Pixel, PixelImage}

class RotatePixelImageFilter(private var degree: Int) extends PixelImageFilter {
  override def apply(image: PixelImage): PixelImage = {
    if (degree % 90 != 0)
      throw new IllegalArgumentException("Unsupportable rotate degree.")
    degree = (degree / 90) % 4
    if (degree < 0)
      degree = degree + 4

    val rotatePixels = Array.ofDim[Pixel](image.getHeight, image.getWidth)
    var pixelGrid: PixelGrid = new PixelGrid(rotatePixels)

    degree match {
      case 1 =>
        pixelGrid = rotate(image.getGrid)
      case 2 =>
        pixelGrid = rotate(image.getGrid)
        pixelGrid = rotate(pixelGrid)
      case 3 =>
        pixelGrid = rotate(image.getGrid)
        pixelGrid = rotate(pixelGrid)
        pixelGrid = rotate(pixelGrid)
      case 0 =>
        pixelGrid = image.getGrid

    }

    new PixelImage(pixelGrid)
  }

  def rotate(grid: PixelGrid): PixelGrid = {
    val rotatePixels = Array.ofDim[Pixel](grid.height, grid.width)

    for {
      y <- 0 until grid.height
      x <- 0 until grid.width
    } rotatePixels(x)(grid.height - 1 - y) = grid.getElement(y, x)

    new PixelGrid(rotatePixels)
  }
}
