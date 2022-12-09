package business.exporters
import domain.image.AsciiImage

class ConsoleImageExporter extends AsciiImageExporter {
  override def export (image: AsciiImage): Unit = {
    for (x <- 0 until image.getWidth) {
      for (y <- 0 until image.getHeight) {
        print(image.getGrid.getElement(x, y))
      }
      println()
    }
  }
}
