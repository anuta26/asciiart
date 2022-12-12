package business.filters

import domain.image.GreyscaleImage

/** Filter which changes brightness of image by adding certain number to greyscale value of every pixel in image
 *
 *  If greyscale value is more than 255 then value will be 255.
 *  If greyscale value is less than 0 then value will be 0.
 *
 * @param value number to add to greyscale value
 */
class BrightnessGreyscaleImageFilter(value: Int) extends GreyscaleImageFilter {
  /**
   *
   * @param image image to be filtered
   *  @return result image
   */
  override def apply(image: GreyscaleImage): GreyscaleImage = {
    for (x <- 0 until image.getHeight)
      for (y <- 0 until image.getWidth){
      var greyscale = image.getElement(x, y).getGreyscale
      greyscale += value
      if (greyscale > 255)
        greyscale = 255
      if (greyscale < 0)
        greyscale = 0
      image.getGrid.getElement(x, y).setGreyscale(greyscale)
    }
    image
  }

}
