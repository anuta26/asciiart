package business.exporters
import domain.image.AsciiImage

class ConsoleImageExporter extends AsciiImageExporter {
  override def export (image: AsciiImage): Unit = {
    for (y <- 0 until image.getHeight) {
      for (x <- 0 until image.getWidth) {
        print(image.getGrid.getElement(x,y))
      }
      println()
    }
  }
}
