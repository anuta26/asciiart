package filters

import business.filters.RotateGreyscaleImageFilter
import domain.grid.GreyscalePixelGrid
import domain.image.GreyscaleImage
import domain.pixel.GreyscalePixel
import org.scalatest.FunSuite

class RotateFilterTest extends FunSuite{

  test ("rotate square image +90" ) {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(75),
          new GreyscalePixel(50)),
        Seq(
          new GreyscalePixel(150),
          new GreyscalePixel(200))))

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: RotateGreyscaleImageFilter =
      new RotateGreyscaleImageFilter(+90)
    val filteredImage: GreyscaleImage = filter.apply(image)


    assert(filteredImage.getElement(0, 0).getGreyscale == 150)
    assert(filteredImage.getElement(0, 1).getGreyscale == 75)
    assert(filteredImage.getElement(1, 0).getGreyscale == 200)
    assert(filteredImage.getElement(1, 1).getGreyscale == 50)
  }

  test("rotate square image -90") {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(75),
          new GreyscalePixel(50)),
        Seq(
          new GreyscalePixel(150),
          new GreyscalePixel(200))))

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: RotateGreyscaleImageFilter =
      new RotateGreyscaleImageFilter(-90)
    val filteredImage: GreyscaleImage = filter.apply(image)


    assert(filteredImage.getElement(0, 0).getGreyscale == 50)
    assert(filteredImage.getElement(0, 1).getGreyscale == 200)
    assert(filteredImage.getElement(1, 0).getGreyscale == 75)
    assert(filteredImage.getElement(1, 1).getGreyscale == 150)
  }

  test("rotate square image +180") {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(75),
          new GreyscalePixel(50)),
        Seq(
          new GreyscalePixel(150),
          new GreyscalePixel(200))))

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: RotateGreyscaleImageFilter =
      new RotateGreyscaleImageFilter(+180)
    val filteredImage: GreyscaleImage = filter.apply(image)


    assert(filteredImage.getElement(0, 0).getGreyscale == 200)
    assert(filteredImage.getElement(0, 1).getGreyscale == 150)
    assert(filteredImage.getElement(1, 0).getGreyscale == 50)
    assert(filteredImage.getElement(1, 1).getGreyscale == 75)
  }

  test("rotate square image -180") {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(75),
          new GreyscalePixel(50)),
        Seq(
          new GreyscalePixel(150),
          new GreyscalePixel(200))))

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: RotateGreyscaleImageFilter =
      new RotateGreyscaleImageFilter(-180)
    val filteredImage: GreyscaleImage = filter.apply(image)


    assert(filteredImage.getElement(0, 0).getGreyscale == 200)
    assert(filteredImage.getElement(0, 1).getGreyscale == 150)
    assert(filteredImage.getElement(1, 0).getGreyscale == 50)
    assert(filteredImage.getElement(1, 1).getGreyscale == 75)
  }

  test("rotate square image +270") {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(75),
          new GreyscalePixel(50)),
        Seq(
          new GreyscalePixel(150),
          new GreyscalePixel(200))))

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: RotateGreyscaleImageFilter =
      new RotateGreyscaleImageFilter(270)
    val filteredImage: GreyscaleImage = filter.apply(image)


    assert(filteredImage.getElement(0, 0).getGreyscale == 50)
    assert(filteredImage.getElement(0, 1).getGreyscale == 200)
    assert(filteredImage.getElement(1, 0).getGreyscale == 75)
    assert(filteredImage.getElement(1, 1).getGreyscale == 150)
  }

  test("rotate square image -270") {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(75),
          new GreyscalePixel(50)),
        Seq(
          new GreyscalePixel(150),
          new GreyscalePixel(200))))

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: RotateGreyscaleImageFilter =
      new RotateGreyscaleImageFilter(+90)
    val filteredImage: GreyscaleImage = filter.apply(image)


    assert(filteredImage.getElement(0, 0).getGreyscale == 150)
    assert(filteredImage.getElement(0, 1).getGreyscale == 75)
    assert(filteredImage.getElement(1, 0).getGreyscale == 200)
    assert(filteredImage.getElement(1, 1).getGreyscale == 50)
  }

  test("rotate square image +360") {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(75),
          new GreyscalePixel(50)),
        Seq(
          new GreyscalePixel(150),
          new GreyscalePixel(200))))

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: RotateGreyscaleImageFilter =
      new RotateGreyscaleImageFilter(+360)
    val filteredImage: GreyscaleImage = filter.apply(image)


    assert(filteredImage.getElement(0, 0).getGreyscale == 75)
    assert(filteredImage.getElement(0, 1).getGreyscale == 50)
    assert(filteredImage.getElement(1, 0).getGreyscale == 150)
    assert(filteredImage.getElement(1, 1).getGreyscale == 200)
  }

  test("rotate square image -360") {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(75),
          new GreyscalePixel(50)),
        Seq(
          new GreyscalePixel(150),
          new GreyscalePixel(200))))

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: RotateGreyscaleImageFilter =
      new RotateGreyscaleImageFilter(-360)
    val filteredImage: GreyscaleImage = filter.apply(image)


    assert(filteredImage.getElement(0, 0).getGreyscale == 75)
    assert(filteredImage.getElement(0, 1).getGreyscale == 50)
    assert(filteredImage.getElement(1, 0).getGreyscale == 150)
    assert(filteredImage.getElement(1, 1).getGreyscale == 200)
  }

  test("rotate rectangle image +90") {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(75),
          new GreyscalePixel(50),
          new GreyscalePixel(25)),
        Seq(
          new GreyscalePixel(150),
          new GreyscalePixel(200),
          new GreyscalePixel(225))))

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: RotateGreyscaleImageFilter =
      new RotateGreyscaleImageFilter(+90)
    val filteredImage: GreyscaleImage = filter.apply(image)


    assert(filteredImage.getElement(0, 0).getGreyscale == 150)
    assert(filteredImage.getElement(0, 1).getGreyscale == 75)
    assert(filteredImage.getElement(1, 0).getGreyscale == 200)
    assert(filteredImage.getElement(1, 1).getGreyscale == 50)
    assert(filteredImage.getElement(2, 0).getGreyscale == 225)
    assert(filteredImage.getElement(2, 1).getGreyscale == 25)

  }

  test("rotate rectangle image -90") {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(75),
          new GreyscalePixel(50),
          new GreyscalePixel(25)),
        Seq(
          new GreyscalePixel(150),
          new GreyscalePixel(200),
          new GreyscalePixel(225))))

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: RotateGreyscaleImageFilter =
      new RotateGreyscaleImageFilter(-90)
    val filteredImage: GreyscaleImage = filter.apply(image)


    assert(filteredImage.getElement(0, 0).getGreyscale == 25)
    assert(filteredImage.getElement(0, 1).getGreyscale == 225)
    assert(filteredImage.getElement(1, 0).getGreyscale == 50)
    assert(filteredImage.getElement(1, 1).getGreyscale == 200)
    assert(filteredImage.getElement(2, 0).getGreyscale == 75)
    assert(filteredImage.getElement(2, 1).getGreyscale == 150)
  }

  test("rotate rectangle image +180") {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(75),
          new GreyscalePixel(50),
          new GreyscalePixel(25)),
        Seq(
          new GreyscalePixel(150),
          new GreyscalePixel(200),
          new GreyscalePixel(225))))

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: RotateGreyscaleImageFilter =
      new RotateGreyscaleImageFilter(+180)
    val filteredImage: GreyscaleImage = filter.apply(image)


    assert(filteredImage.getElement(0, 0).getGreyscale == 225)
    assert(filteredImage.getElement(0, 1).getGreyscale == 200)
    assert(filteredImage.getElement(0, 2).getGreyscale == 150)
    assert(filteredImage.getElement(1, 0).getGreyscale == 25)
    assert(filteredImage.getElement(1, 1).getGreyscale == 50)
    assert(filteredImage.getElement(1, 2).getGreyscale == 75)
  }

  test("rotate rectangle image -180") {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(75),
          new GreyscalePixel(50),
          new GreyscalePixel(25)),
        Seq(
          new GreyscalePixel(150),
          new GreyscalePixel(200),
          new GreyscalePixel(225))))

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: RotateGreyscaleImageFilter =
      new RotateGreyscaleImageFilter(-180)
    val filteredImage: GreyscaleImage = filter.apply(image)


    assert(filteredImage.getElement(0, 0).getGreyscale == 225)
    assert(filteredImage.getElement(0, 1).getGreyscale == 200)
    assert(filteredImage.getElement(0, 2).getGreyscale == 150)
    assert(filteredImage.getElement(1, 0).getGreyscale == 25)
    assert(filteredImage.getElement(1, 1).getGreyscale == 50)
    assert(filteredImage.getElement(1, 2).getGreyscale == 75)
  }

  test("rotate rectangle image +270") {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(75),
          new GreyscalePixel(50),
          new GreyscalePixel(25)),
        Seq(
          new GreyscalePixel(150),
          new GreyscalePixel(200),
          new GreyscalePixel(225))))

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: RotateGreyscaleImageFilter =
      new RotateGreyscaleImageFilter(270)
    val filteredImage: GreyscaleImage = filter.apply(image)


    assert(filteredImage.getElement(0, 0).getGreyscale == 25)
    assert(filteredImage.getElement(0, 1).getGreyscale == 225)
    assert(filteredImage.getElement(1, 0).getGreyscale == 50)
    assert(filteredImage.getElement(1, 1).getGreyscale == 200)
    assert(filteredImage.getElement(2, 0).getGreyscale == 75)
    assert(filteredImage.getElement(2, 1).getGreyscale == 150)
  }

  test("rotate rectangle image -270") {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(75),
          new GreyscalePixel(50),
          new GreyscalePixel(25)),
        Seq(
          new GreyscalePixel(150),
          new GreyscalePixel(200),
          new GreyscalePixel(225))))

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: RotateGreyscaleImageFilter =
      new RotateGreyscaleImageFilter(+90)
    val filteredImage: GreyscaleImage = filter.apply(image)

    assert(filteredImage.getElement(0, 0).getGreyscale == 150)
    assert(filteredImage.getElement(0, 1).getGreyscale == 75)
    assert(filteredImage.getElement(1, 0).getGreyscale == 200)
    assert(filteredImage.getElement(1, 1).getGreyscale == 50)
    assert(filteredImage.getElement(2, 0).getGreyscale == 225)
    assert(filteredImage.getElement(2, 1).getGreyscale == 25)
  }

  test("rotate rectangle image +360") {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(75),
          new GreyscalePixel(50),
          new GreyscalePixel(25)),
        Seq(
          new GreyscalePixel(150),
          new GreyscalePixel(200),
          new GreyscalePixel(225))))

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: RotateGreyscaleImageFilter =
      new RotateGreyscaleImageFilter(+360)
    val filteredImage: GreyscaleImage = filter.apply(image)


    assert(filteredImage.getElement(0, 0).getGreyscale == 75)
    assert(filteredImage.getElement(0, 1).getGreyscale == 50)
    assert(filteredImage.getElement(0, 2).getGreyscale == 25)
    assert(filteredImage.getElement(1, 0).getGreyscale == 150)
    assert(filteredImage.getElement(1, 1).getGreyscale == 200)
    assert(filteredImage.getElement(1, 2).getGreyscale == 225)
  }

  test("rotate rectangle image -360") {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(
      Seq(
        Seq(
          new GreyscalePixel(75),
          new GreyscalePixel(50),
          new GreyscalePixel(25)),
      Seq(
          new GreyscalePixel(150),
          new GreyscalePixel(200),
          new GreyscalePixel(225))))

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: RotateGreyscaleImageFilter =
      new RotateGreyscaleImageFilter(-360)
    val filteredImage: GreyscaleImage = filter.apply(image)

    assert(filteredImage.getElement(0, 0).getGreyscale == 75)
    assert(filteredImage.getElement(0, 1).getGreyscale == 50)
    assert(filteredImage.getElement(0, 2).getGreyscale == 25)
    assert(filteredImage.getElement(1, 0).getGreyscale == 150)
    assert(filteredImage.getElement(1, 1).getGreyscale == 200)
    assert(filteredImage.getElement(1, 2).getGreyscale == 225)
  }

  test("rotate rectangle image 0x0") {
    val grid: GreyscalePixelGrid
    = new GreyscalePixelGrid(Seq.empty)

    val image: GreyscaleImage = new GreyscaleImage(grid)
    val filter: RotateGreyscaleImageFilter =
      new RotateGreyscaleImageFilter(90)
    val filteredImage: GreyscaleImage = filter.apply(image)
    assert(filteredImage.grid.pixels.equals(Seq.empty))
  }

}
