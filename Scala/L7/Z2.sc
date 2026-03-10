def ldzialanie[A](l1: LazyList[A], l2: LazyList[A], op: (A, A) => A): LazyList[A] = {
  (l1, l2) match {
    case (LazyList(), LazyList()) => LazyList.empty
    case (LazyList(), list2) => list2
    case (list1, LazyList()) => list1
    case (h1 #:: t1, h2 #:: t2) =>
      op(h1, h2) #:: ldzialanie(t1, t2, op)
  }
}
val l1 = LazyList(1,2,3)
val l2 = LazyList(2,3,4,5)
ldzialanie(l1, l2, (x:Int, y:Int) => x+y).toList

val l3 = LazyList(2, 2, 2, 10, 10)
val l4 = LazyList(3, 4, 5)
ldzialanie(l3, l4, (x: Int, y: Int)=> x * y).toList

val l5 = LazyList[Int]()
val l6 = LazyList[Int]()
ldzialanie(l5,l6, (x:Int, y:Int) => x+y).toList

val l7 = LazyList.from(1)
val l8 = LazyList(1,2,3)
ldzialanie(l7,l8, (x:Int, y:Int)=> x + y).take(10).toList
