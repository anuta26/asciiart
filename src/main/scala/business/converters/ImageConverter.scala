package business.converters

trait ImageConverter[S,T]{
  def convert(input: S): T
}
