package com.example

class TestFunction {

  def m(x: Int) = x + 1

  val f = (x: Int) => x + 1
  val f2 = (x: Int) => x + 1

  val simpleStringFun = () => "Hi There!"

  val evenOrOdd = (x: Int) => {
    if (x % 2 == 0)
      "even"
    else
      "odd"
  }

  def sumSalary(eList: List[Employee]) = {
    var sum = 0
    eList.foreach(e => sum += e.salary)
    sum
  }

  def sumSalaryForDept10(eList: List[Employee]) = {
    var sum = 0
    eList.foreach(e => {
      if (e.dept == 10)
        sum += e.salary
    })
    sum
  }

  def sumSalarySmart(eList: List[Employee], selection: Employee => Boolean) = {
    var sum = 0
    eList.foreach(e => {
      if (selection(e))
        sum += e.salary
    })
    sum
  }

}

object Main1 {
  def main(args: Array[String]): Unit = {

    val t = new TestFunction()
    println(t.m(10))
    println(t.f(10))

    println(t.simpleStringFun())
    println(t.evenOrOdd(11))

    var emily = new Employee("Emily", 1000)
    emily.dept = 10
    var john = new Employee("John", 2000)
    john.dept = 11
    var sam = new Employee("Sam", 10000)
    sam.dept = 10
    var riley = new Employee("Riley", 3000)
    riley.dept = 13
    var jim = new Employee("Jim", 6000)
    jim.dept = 10

    val elist = List(emily, john, sam, riley, jim)

    println("Total salary: " + t.sumSalary(elist))

    println("Total salary for dept 10: " + t.sumSalaryForDept10(elist))

    println("Total salary for dept greater than 10: " + t.sumSalarySmart(elist, (x: Employee) => x.dept > 10))

    println("Total salary for dept greater than 10: " + t.sumSalarySmart(elist, x => x.dept > 10))

  }
}