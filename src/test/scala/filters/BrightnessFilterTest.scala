package filters

import business.filters.BrightnessGreyscaleImageFilter
import domain.grid.GreyscalePixelGrid
import domain.image.GreyscaleImage
import domain.pixel.GreyscalePixel
import org.scalatest.FunSuite

class BrightnessFilterTest extends FunSuite {

  test("Brightness with positive value and result greyscale from 0 to 255") {

    val grid: GreyscalePixelGrid = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(0),
          new GreyscalePixel(50),
          new GreyscalePixel(100)),
        Seq(
          new GreyscalePixel(150),
          new GreyscalePixel(200),
          new GreyscalePixel(25))))

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: BrightnessGreyscaleImageFilter =
      new BrightnessGreyscaleImageFilter(50)
    val filteredImage: GreyscaleImage = filter.apply(image)

    assert(filteredImage.getElement(0, 0).getGreyscale == 50)
    assert(filteredImage.getElement(0, 1).getGreyscale == 100)
    assert(filteredImage.getElement(0, 2).getGreyscale == 150)
    assert(filteredImage.getElement(1, 0).getGreyscale == 200)
    assert(filteredImage.getElement(1, 1).getGreyscale == 250)
    assert(filteredImage.getElement(1, 2).getGreyscale == 75)

  }

  test("Brightness with positive value and result greyscale more then 255") {
    val grid: GreyscalePixelGrid = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(0),
          new GreyscalePixel(50),
          new GreyscalePixel(100)),
        Seq(
          new GreyscalePixel(100),
          new GreyscalePixel(100),
          new GreyscalePixel(25))))
    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: BrightnessGreyscaleImageFilter =
      new BrightnessGreyscaleImageFilter(200)
    val filteredImage: GreyscaleImage = filter.apply(image)

    assert(filteredImage.getElement(0, 0).getGreyscale == 200)
    assert(filteredImage.getElement(0, 1).getGreyscale == 250)
    assert(filteredImage.getElement(0, 2).getGreyscale == 255)
    assert(filteredImage.getElement(1, 0).getGreyscale == 255)
    assert(filteredImage.getElement(1, 1).getGreyscale == 255)
    assert(filteredImage.getElement(1, 2).getGreyscale == 225)

  }

  test("Brightness with negative value and result greyscale from 0 to 255") {
    val grid: GreyscalePixelGrid = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(50),
          new GreyscalePixel(100),
          new GreyscalePixel(150)),
        Seq(
          new GreyscalePixel(200),
          new GreyscalePixel(250),
          new GreyscalePixel(75))))
    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: BrightnessGreyscaleImageFilter =
      new BrightnessGreyscaleImageFilter(-50)
    val filteredImage: GreyscaleImage = filter.apply(image)

    assert(filteredImage.getElement(0, 0).getGreyscale == 0)
    assert(filteredImage.getElement(0, 1).getGreyscale == 50)
    assert(filteredImage.getElement(0, 2).getGreyscale == 100)
    assert(filteredImage.getElement(1, 0).getGreyscale == 150)
    assert(filteredImage.getElement(1, 1).getGreyscale == 200)
    assert(filteredImage.getElement(1, 2).getGreyscale == 25)

  }

  test("Brightness with negative value and result greyscale less then 0") {
    val grid: GreyscalePixelGrid = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(0),
          new GreyscalePixel(50),
          new GreyscalePixel(100)),
        Seq(
          new GreyscalePixel(100),
          new GreyscalePixel(225),
          new GreyscalePixel(250))))
    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: BrightnessGreyscaleImageFilter =
      new BrightnessGreyscaleImageFilter(-200)
    val filteredImage: GreyscaleImage = filter.apply(image)

    assert(filteredImage.getElement(0, 0).getGreyscale == 0)
    assert(filteredImage.getElement(0, 1).getGreyscale == 0)
    assert(filteredImage.getElement(0, 2).getGreyscale == 0)
    assert(filteredImage.getElement(1, 0).getGreyscale == 0)
    assert(filteredImage.getElement(1, 1).getGreyscale == 25)
    assert(filteredImage.getElement(1, 2).getGreyscale == 50)

  }

  test("Brightness image 0x0") {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(Seq.empty)

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: BrightnessGreyscaleImageFilter =
      new BrightnessGreyscaleImageFilter(90)
    val filteredImage: GreyscaleImage = filter.apply(image)
    assert(filteredImage.getGrid.pixels.equals(Seq.empty))
  }
}
