package business.filters

import domain.image.GreyscaleImage

class InvertGreyscaleImageFilter extends GreyscaleImageFilter {
  override def apply(image: GreyscaleImage): GreyscaleImage = {
    for {
      y <- 0 until image.getHeight
      x <- 0 until image.getWidth
    } {
      val greyscale = image.getElement(x, y).getGreyscale
      image.getElement(x, y).setGreyscale(255 - greyscale)
    }
    image
  }

}
