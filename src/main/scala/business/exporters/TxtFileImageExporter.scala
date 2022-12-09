package business.exporters
import domain.image.AsciiImage

import java.io.{BufferedWriter, File, FileWriter}

/** Exporter which exports ascii image to txt file
 *
 * @param _pathToFile path to file for export
 */
class TxtFileImageExporter(private var _pathToFile: String)
    extends FileImageExporter {
  override def pathToFile: String = _pathToFile

  /** exports image to txt file
   *
   * @param image ascii image to export
   */
  override def export(image: AsciiImage): Unit = {
    if (_pathToFile.substring(_pathToFile.length - 3, _pathToFile.length) != "txt")
      throw new IllegalArgumentException("Wrong format of output file.")
    val file = new File(_pathToFile)
    val writer = new BufferedWriter(new FileWriter(file))

    for (x <- 0 until image.getWidth) {
      for (y <- 0 until image.getHeight)
        writer.write(image.getGrid.getElement(x, y).getChar)
      writer.write("\n")
    }
    writer.close()
  }
}
