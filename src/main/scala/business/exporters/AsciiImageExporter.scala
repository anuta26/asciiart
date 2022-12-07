package business.exporters

import domain.image.{AsciiImage, Image}

trait AsciiImageExporter {
  def export(image: AsciiImage): Unit
}
