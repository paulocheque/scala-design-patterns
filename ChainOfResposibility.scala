package scala.behavioral

import scala.collection.jcl.ArrayList

abstract class HandlerResponsability[D,V]() {
  var responsable = false

  def isResponsable():Boolean = responsable

  def execute(data:D) : V
}

// Composite style
class ChainOfResponsability[D,V] extends HandlerResponsability[D, V] {
  this.responsable = true
  val handlers = new ArrayList[HandlerResponsability[D,V]]()

  override def execute(data:D) : V = {
    for(handler <- handlers) {
     var value = handler.execute(data)
      if(handler.isResponsable())
        return value
    }
    throw new RuntimeException("Throw unsolved or return a default value")
  }

  def addHandler(handler:HandlerResponsability[D,V]) {
    handlers += handler
  }
}

class MyData(val value:Int)

class MyResult(val str:String) {
  override def toString():String = str
}

class SomeConcreteHandler extends HandlerResponsability[MyData, MyResult] {
  override def execute(data:MyData) : MyResult = {
    // set true or false, depends on the data
    println("Running SomeConcreteHandler")
    if(data.value == 5) {
     this.responsable = true
     return new MyResult("result from SomeConcreteHandler")
    }
   return null
  }
}

class AnotherConcreteHandler extends HandlerResponsability[MyData, MyResult] {
  override def execute(data:MyData) : MyResult = {
    println("Running AnotherConcreteHandler")
    // set true or false, depends on the data
    if(data.value == 3) {
     this.responsable = true
      return new MyResult("result from AnotherConcreteHandler")
    }
    return null
  }
}

// Composite style
class MyChainOfResponsability extends ChainOfResponsability[MyData, MyResult] {
  super.addHandler(new SomeConcreteHandler())
  super.addHandler(new AnotherConcreteHandler())
}

object ChainOfResponsabilityClient extends Application {
  var handler = new MyChainOfResponsability()
  println(handler.execute(new MyData(3)))
  println(handler.execute(new MyData(5)))
}