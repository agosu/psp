package events

trait CrazyEvents {
  var events: Array[Event] = new Array[Event](10)
  var numberOfEvents: Integer = 0

  def organizeEvent(budget: Integer, numberOfAttendees: Integer): Unit = {
    events(numberOfEvents) = new Event("crazy", "crazy", "crazy", budget, numberOfAttendees)
    numberOfEvents += 1
  }

  def getEventsType: String = {
    "crazy events"
  }

  def getEvents: Array[Event] = {
    events
  }
}
