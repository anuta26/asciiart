package business.exporters
import domain.image.AsciiImage

import java.io.{BufferedWriter, File, FileNotFoundException, FileWriter, IOException}

class TxtFileImageExporter(private var _pathToFile: String) extends FileImageExporter{
  override def pathToFile: String = _pathToFile
  override def export(image: AsciiImage): Unit ={
    println(_pathToFile.substring(_pathToFile.length - 3, _pathToFile.length))
    if (_pathToFile.substring(_pathToFile.length - 3, _pathToFile.length) != "txt") {
      throw new IllegalArgumentException("Wrong format of file.")
    }
    try {
      val file = new File(_pathToFile)
      val writer = new BufferedWriter(new FileWriter(file))

      for (y <- 0 until image.getHeight) {
        for (x <- 0 until image.getWidth) {
          writer.write(image.getGrid.getElement(x,y))
        }
        writer.write("\n")
      }
      writer.close()
    } catch {
      case ex: FileNotFoundException => {
        println("Cannot open file to write.")
      }

      case ex: IOException => {
        println("Exception while writing to file.")
      }
    }

  }

}
