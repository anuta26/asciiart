package business.exporters
import domain.image.AsciiImage

/** Exporter which exports ascii image to console
 *
 */
class ConsoleImageExporter extends AsciiImageExporter {
  /**
   *
   * @param image ascii image to export
   */
  override def export(image: AsciiImage): Unit =
    for (x <- 0 until image.getWidth) {
      for (y <- 0 until image.getHeight)
        print(image.getGrid.getElement(x, y))
      println()
    }
}
