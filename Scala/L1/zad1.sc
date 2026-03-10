import scala.annotation.tailrec

def dlugosc[A] (list: List[A]): Int={
  @tailrec
  def dlugoscIter (l: List[A], acc: Int): Int ={
    l match{
      case Nil => acc
      case h::t => dlugoscIter(t, acc+1)
    }
  }
  dlugoscIter(list, 0)
}

dlugosc(List())
dlugosc(List(1,2,3))
dlugosc(List(9999,10,625))