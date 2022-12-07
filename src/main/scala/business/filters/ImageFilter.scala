package business.filters

trait ImageFilter[T] {
  def apply(image: T): T
}
