package filters

import business.filters.BrightnessGreyscaleImageFilter
import domain.grid.GreyscaleGrid
import domain.image.GreyscaleImage
import domain.pixel.GreyscalePixel
import org.scalatest.FunSuite

class BrightnessFilterTest extends FunSuite {

  test("Brightness with positive value and result greyscale from 0 to 255") {
    val width = 3
    val height = 2
    val pixels = Array.ofDim[GreyscalePixel](height, width)
    pixels(0)(0) = new GreyscalePixel(0)
    pixels(0)(1) = new GreyscalePixel(50)
    pixels(0)(2) = new GreyscalePixel(100)
    pixels(1)(0) = new GreyscalePixel(150)
    pixels(1)(1) = new GreyscalePixel(200)
    pixels(1)(2) = new GreyscalePixel(25)

    val grid: GreyscaleGrid =
      new GreyscaleGrid(pixels.map(array => array.toSeq))
    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: BrightnessGreyscaleImageFilter = new BrightnessGreyscaleImageFilter(50)
    val filteredImage: GreyscaleImage = filter.apply(image)

    assert(filteredImage.getElement(0,0).getGreyscale == 50)
    assert(filteredImage.getElement(0,1).getGreyscale == 100)
    assert(filteredImage.getElement(0,2).getGreyscale == 150)
    assert(filteredImage.getElement(1,0).getGreyscale == 200)
    assert(filteredImage.getElement(1,1).getGreyscale == 250)
    assert(filteredImage.getElement(1,2).getGreyscale == 75)

  }

  test("Brightness with positive value and result greyscale more then 255") {
    val width = 3
    val height = 2
    val pixels = Array.ofDim[GreyscalePixel](height, width)
    pixels(0)(0) = new GreyscalePixel(0)
    pixels(0)(1) = new GreyscalePixel(50)
    pixels(0)(2) = new GreyscalePixel(100)
    pixels(1)(0) = new GreyscalePixel(100)
    pixels(1)(1) = new GreyscalePixel(100)
    pixels(1)(2) = new GreyscalePixel(25)

    val grid: GreyscaleGrid =
      new GreyscaleGrid(pixels.map(array => array.toSeq))
    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: BrightnessGreyscaleImageFilter = new BrightnessGreyscaleImageFilter(200)
    val filteredImage: GreyscaleImage = filter.apply(image)

    assert(filteredImage.getElement(0, 0).getGreyscale == 200)
    assert(filteredImage.getElement(0, 1).getGreyscale == 250)
    assert(filteredImage.getElement(0, 2).getGreyscale == 255)
    assert(filteredImage.getElement(1, 0).getGreyscale == 255)
    assert(filteredImage.getElement(1, 1).getGreyscale == 255)
    assert(filteredImage.getElement(1, 2).getGreyscale == 225)

  }


  test("Brightness with negative value and result greyscale from 0 to 255") {
    val width = 3
    val height = 2
    val pixels = Array.ofDim[GreyscalePixel](height, width)
    pixels(0)(0) = new GreyscalePixel(50)
    pixels(0)(1) = new GreyscalePixel(100)
    pixels(0)(2) = new GreyscalePixel(150)
    pixels(1)(0) = new GreyscalePixel(200)
    pixels(1)(1) = new GreyscalePixel(250)
    pixels(1)(2) = new GreyscalePixel(75)

    val grid: GreyscaleGrid =
      new GreyscaleGrid(pixels.map(array => array.toSeq))
    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: BrightnessGreyscaleImageFilter = new BrightnessGreyscaleImageFilter(-50)
    val filteredImage: GreyscaleImage = filter.apply(image)

    assert(filteredImage.getElement(0, 0).getGreyscale == 0)
    assert(filteredImage.getElement(0, 1).getGreyscale == 50)
    assert(filteredImage.getElement(0, 2).getGreyscale == 100)
    assert(filteredImage.getElement(1, 0).getGreyscale == 150)
    assert(filteredImage.getElement(1, 1).getGreyscale == 200)
    assert(filteredImage.getElement(1, 2).getGreyscale == 25)

  }

  test("Brightness with negative value and result greyscale less then 100") {
    val width = 3
    val height = 2
    val pixels = Array.ofDim[GreyscalePixel](height, width)
    pixels(0)(0) = new GreyscalePixel(0)
    pixels(0)(1) = new GreyscalePixel(50)
    pixels(0)(2) = new GreyscalePixel(100)
    pixels(1)(0) = new GreyscalePixel(100)
    pixels(1)(1) = new GreyscalePixel(225)
    pixels(1)(2) = new GreyscalePixel(250)

    val grid: GreyscaleGrid =
      new GreyscaleGrid(pixels.map(array => array.toSeq))
    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: BrightnessGreyscaleImageFilter = new BrightnessGreyscaleImageFilter(-200)
    val filteredImage: GreyscaleImage = filter.apply(image)

    assert(filteredImage.getElement(0, 0).getGreyscale == 0)
    assert(filteredImage.getElement(0, 1).getGreyscale == 0)
    assert(filteredImage.getElement(0, 2).getGreyscale == 0)
    assert(filteredImage.getElement(1, 0).getGreyscale == 0)
    assert(filteredImage.getElement(1, 1).getGreyscale == 25)
    assert(filteredImage.getElement(1, 2).getGreyscale == 50)

  }
}
