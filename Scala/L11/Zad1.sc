import java.lang.reflect.Field

trait Debug {
  def debugVars(): Unit = {
    val objectClass = this.getClass
    println(s"Klasa: ${objectClass.getSimpleName}")

    val fields: Array[Field] = objectClass.getDeclaredFields
    for (field <- fields) {
      field.setAccessible(true)

      val name = field.getName
      val typeName = field.getType.getSimpleName
      val value = field.get(this)

      println(s"Pole: $name => $typeName, $value")
    }
  }
}

class Point(xv: Int, yv: Int) extends Debug {
  var x: Int = xv
  var y: Int = yv
  var a: String = "test"
}

class Student(imie: String, wiek: Int, czyZdal: Boolean) extends Debug {
  val name: String = imie
  private val age: Int = wiek
  var passed: Boolean = czyZdal
  val avg: Double = 4.5

  // Zeby kompilator nie pomijał prywantego age
//  override def toString = s"Student($name, $age, $passed, $avg)"
}

class Empty extends Debug{}

var p: Point = new Point(3, 4)
p.debugVars()

val s: Student = new Student("Adam", 21, true)
s.debugVars()

val e: Empty = new Empty()
e.debugVars()