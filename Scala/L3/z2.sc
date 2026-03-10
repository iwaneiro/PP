import scala.annotation.tailrec

def reverse[A] (list: List[A]): List[A] ={
  @tailrec
  def reverseOgon (l:List[A], acc: List[A]): List[A] = l match {
    case Nil => acc
    case h::t => reverseOgon(t, h::acc)
  }
  reverseOgon(list, Nil)
}

def mnozenie (list1: List[Int], list2: List[Int]): List[Int]={
  @tailrec
  def mnozenieOgon (l1:List[Int], l2:List[Int], acc:List[Int]): List[Int] = (l1,l2) match{
    case (h1::t1, h2::t2) => mnozenieOgon(t1,t2, (h1*h2)::acc)
    case (Nil, h2::t2) => mnozenieOgon(Nil, t2, h2::acc)
    case (h1::t1, Nil) => mnozenieOgon(t1, Nil, h1::acc)
    case (Nil, Nil) => reverse(acc)
  }
  mnozenieOgon(list1,list2, Nil)
}

mnozenie(List(1,2,3), List(4,5,6,7,8))
mnozenie(List(4,5,6,7,8), List(1,2,3))
mnozenie(List(), List())
mnozenie(List(1,2,3), List())
mnozenie(List(5,6,7), List(7,6,5))





