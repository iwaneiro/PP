import scala.annotation.tailrec

def printAll(args: Any*): Unit = {
  @tailrec
  def printRecursive(list: List[Any]): Unit = {
    if (list.nonEmpty) {
      val head = list.head

      if (head != null) {
        val typeName = head.getClass.getSimpleName
        println(s"$typeName: $head")
      } else {
        println("Null: null")
      }
      printRecursive(list.tail)
    }
  }
  printRecursive(args.toList)
}
printAll(1, "hello", 3.14)
printAll(true, 'A', 100L)
printAll("Hello", null, 999)
printAll(Nil)