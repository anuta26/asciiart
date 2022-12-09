package business.filters

import domain.image.GreyscaleImage

/** Filter which inverts image by changing greyscale value of every pixel with formula:
 *  255 - greyscale value
 *
 */
class InvertGreyscaleImageFilter extends GreyscaleImageFilter {
  /**
   *
   * @param image image to be filtered
   *  @return result image
   */
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
