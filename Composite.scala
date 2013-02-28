package scala.structural

import scala.collection.jcl.ArrayList

// Permite tratar uma requisição a uma composição de componentes da mesma forma a um único componente

class SomeObject {
 def someTask() {}
}

class Composite extends SomeObject {
 var objects = new ArrayList[SomeObject]()

 override def someTask() {
  for(o <- objects)
   o.someTask()
 }
}

// Client
object CompositeClient extends Application {
 var someObject1 = new SomeObject()
 var someObject2 = new Composite()
 someObject1.someTask()
 someObject2.someTask()
}