package scala.behavioral

import scala.collection.jcl.ArrayList

// Observer = Publisher-Subscriber
// Dependência 1-N onde os N dependentes serão notificados e atualizos a cada mudança de estado do objeto que está sendo observado

// Abstract implementation

trait Observable { // Publisher
 val observers = new ArrayList[Observer]()

 def notifyObservers() {
  for(observer <- observers)
   observer.notification()
 }

 def addObserver(observer:Observer) {
  observers += observer
 }

 def removeObserver(observer:Observer) {
  observers -= observer
 }
}

trait Observer { // Subscriber
  def notification()
}

// Concrete Implementation

class SomeObservable extends Observable

class SomeObserver extends Observer {
 override def notification() {
  println("do something here: SomeObserver")
 }
}

class AnotherObserver extends Observer {
 override def notification() {
  println("do something here: AnotherObserver")
 }
}

// Client

object ObserverClient extends Application {
 var observable = new SomeObservable()
 var observer1 = new SomeObserver()
 var observer2 = new AnotherObserver()
 observable.addObserver(observer1)
 observable.addObserver(observer2)
 observable.notifyObservers()
 observable.removeObserver(observer2)
 observable.notifyObservers()
}