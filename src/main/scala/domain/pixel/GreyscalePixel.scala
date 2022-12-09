package domain.pixel

/** Pixel which contains greyscale value (from 0 to 255)
 *
 * @param greyscale greyscale of pixel
 */
class GreyscalePixel (private var greyscale: Double) extends Pixel{
  def getGreyscale: Double = greyscale
  def setGreyscale(newGreyscale: Double): Unit = {
    greyscale = newGreyscale
  }
}
