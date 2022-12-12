package filters

import business.filters.InvertGreyscaleImageFilter
import domain.grid.GreyscalePixelGrid
import domain.image.GreyscaleImage
import domain.pixel.GreyscalePixel
import org.scalatest.FunSuite

class InvertFilterTest extends FunSuite {
  test("invert image with greyscale from 0 to 255") {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(75),
          new GreyscalePixel(50),
          new GreyscalePixel(100)),
        Seq(
          new GreyscalePixel(150),
          new GreyscalePixel(200),
          new GreyscalePixel(25))))

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: InvertGreyscaleImageFilter =
      new InvertGreyscaleImageFilter
    val filteredImage: GreyscaleImage = filter.apply(image)

    assert(filteredImage.getElement(0, 0).getGreyscale == (255 - 75))
    assert(filteredImage.getElement(0, 1).getGreyscale == (255 - 50))
    assert(filteredImage.getElement(0, 2).getGreyscale == (255 - 100))
    assert(filteredImage.getElement(1, 0).getGreyscale == (255 - 150))
    assert(filteredImage.getElement(1, 1).getGreyscale == (255 - 200))
    assert(filteredImage.getElement(1, 2).getGreyscale == (255 - 25))
  }

  test("invert image with greyscale 0") {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(0),
          new GreyscalePixel(0),
          new GreyscalePixel(0)),
        Seq(
          new GreyscalePixel(0),
          new GreyscalePixel(0),
          new GreyscalePixel(0))))

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: InvertGreyscaleImageFilter =
      new InvertGreyscaleImageFilter
    val filteredImage: GreyscaleImage = filter.apply(image)

    assert(filteredImage.getElement(0, 0).getGreyscale == 255)
    assert(filteredImage.getElement(0, 1).getGreyscale == 255)
    assert(filteredImage.getElement(0, 2).getGreyscale == 255)
    assert(filteredImage.getElement(1, 0).getGreyscale == 255)
    assert(filteredImage.getElement(1, 1).getGreyscale == 255)
    assert(filteredImage.getElement(1, 2).getGreyscale == 255)
  }

  test("invert image with greyscale 255") {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(255),
          new GreyscalePixel(255),
          new GreyscalePixel(255)),
        Seq(
          new GreyscalePixel(255),
          new GreyscalePixel(255),
          new GreyscalePixel(255))))

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: InvertGreyscaleImageFilter =
      new InvertGreyscaleImageFilter
    val filteredImage: GreyscaleImage = filter.apply(image)

    assert(filteredImage.getElement(0, 0).getGreyscale == 0)
    assert(filteredImage.getElement(0, 1).getGreyscale == 0)
    assert(filteredImage.getElement(0, 2).getGreyscale == 0)
    assert(filteredImage.getElement(1, 0).getGreyscale == 0)
    assert(filteredImage.getElement(1, 1).getGreyscale == 0)
    assert(filteredImage.getElement(1, 2).getGreyscale == 0)
  }
  test("invert image 0x0") {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(Seq.empty)

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: InvertGreyscaleImageFilter =
      new InvertGreyscaleImageFilter
    val filteredImage: GreyscaleImage = filter.apply(image)
    assert(filteredImage.getGrid.pixels.equals(Seq.empty))
  }

}
