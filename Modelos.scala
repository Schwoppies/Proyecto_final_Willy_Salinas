// Categorías de libros en el sistema
sealed trait CategoriaLibro
case object Ficcion extends CategoriaLibro
case object Ciencia extends CategoriaLibro
case object Historia extends CategoriaLibro
case object Tecnologia extends CategoriaLibro

// Estados pojsibles de un préstamo
sealed trait EstadoPrestamo
case object Activo extends EstadoPrestamo
case object Devuelto extends EstadoPrestamo
case object Vencido extends EstadoPrestamo

// Tipos de membresía de usuarios
sealed trait TipoUsuario
case object Estudiante extends TipoUsuario
case object Profesor extends TipoUsuario
case object Regular extends TipoUsuario

// Entidades inmutables
case class Libro[T](
  isbn: String,
  titulo: String,
  autor: String,
  categoria: CategoriaLibro,
  detallesExtra: T
)

case class Usuario(
  idUsuario: String,
  nombre: String,
  email: String,
  tipo: TipoUsuario
)

case class Prestamo(
  idPrestamo: String,
  isbnLibro: String,
  idUsuario: String,
  fechaInicio: String,
  estado: EstadoPrestamo
)

// Contenedor principal del estado inmutable
case class Biblioteca[T](
  libros: List[Libro[T]],
  usuarios: List[Usuario],
  prestamos: List[Prestamo]
)