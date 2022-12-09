package domain.pixel

class GreyscalePixel (private var greyscale: Double) extends Pixel{
  def getGreyscale: Double = greyscale
  def setGreyscale(newGreyscale: Double): Unit = {
    greyscale = newGreyscale
  }
}
