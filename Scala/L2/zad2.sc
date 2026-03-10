import scala.annotation.tailrec

def dlugosc[A] (list: List[A]): Int={
  @tailrec
  def dlugoscIter (l: List[A], acc: Int): Int ={
    l match{
      case Nil => acc
      case _::t => dlugoscIter(t, acc+1)
    }
  }
  dlugoscIter(list, 0)
}

dlugosc(List())
dlugosc(List(1,2,3))
dlugosc(List("Ala", "ma", "kota"))
dlugosc(List(List(1,2), List(3)))
