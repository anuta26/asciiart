package business.exporters
import domain.image.AsciiImage

import java.io.PrintStream

/** Exporter which exports ascii image to console
 *
 */
class ConsoleImageExporter(out: PrintStream) extends AsciiImageExporter {
  /**
   *
   * @param image ascii image to export
   */
  override def export(image: AsciiImage): Unit =
    for (x <- 0 until image.getHeight) {
      for (y <- 0 until image.getWidth)
        out.print(image.getGrid.getElement(x, y).getChar)
      out.println()
    }
}
