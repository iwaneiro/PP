import scala.annotation.tailrec

sealed trait Instr
case class Push(x: Int) extends Instr
case object Pop extends Instr
case object Inc extends Instr // zwiększ wierzchołek stosu o 1

type Stack = List[Int]

def eval(instrs: List[Instr]): Stack ={
  @tailrec
  def process(remaining: List[Instr], stack: Stack):Stack = {
    remaining match {
      case Nil => stack

      case Push(x) :: tail =>
        process(tail, x :: stack)

      case Pop :: tail =>
        stack match {
          case _ :: s_tail => process(tail, s_tail)
          case Nil => process(tail, Nil)
        }

      case Inc :: tail =>
        stack match {
          case h :: s_tail => process(tail, (h + 1) :: s_tail)
          case Nil => process(tail, Nil)
        }
    }
  }
  process(instrs, Nil)
}

eval(List(Push(3), Push(5), Inc))
eval(List(Push(10), Push(20), Pop))
eval(List())
eval(List(Pop, Pop, Push(10), Inc, Push(5)))