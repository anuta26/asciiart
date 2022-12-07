package business.loaders

import domain.image.PixelImage

trait ImageLoader[S] extends Loader[S,PixelImage]{
}
