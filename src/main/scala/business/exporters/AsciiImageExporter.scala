package business.exporters

import domain.image.{AsciiImage, Image}

/** Exporter which exports AsciiImage
 *
 */
trait AsciiImageExporter {
  /** Exports image
   *
   * @param image ascii image to export
   */
  def export(image: AsciiImage): Unit
}
