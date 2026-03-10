import scala.annotation.tailrec

sealed trait BT[+A]
case object Empty extends BT[Nothing]
case class Node[+A](elem: A, left: BT[A], right: BT[A]) extends BT[A]


def tree_sum(tree: BT[Int]): Int ={
  @tailrec
  def sum_helper(trees_to_visit: List[BT[Int]], acc: Int):Int ={
    trees_to_visit match{
      case Nil => acc
      case Empty::rest => sum_helper(rest, acc)
      case Node(elem, left, right) :: rest => sum_helper(left::right::rest, acc+elem)
    }
  }
  sum_helper(List(tree), 0)
}

val tt: BT[Int] = Node(1,
  Node(2,
    Node(4, Empty, Empty),
    Empty
  ),
  Node(3,
    Node(5,
      Empty,
      Node(6, Empty, Empty)
    ),
    Empty
  )
)

tree_sum(Empty)
tree_sum(tt)
tree_sum(Node(10,Empty,Empty))
tree_sum(Node(1, Node(2, Node(3, Empty, Empty), Empty), Empty))
