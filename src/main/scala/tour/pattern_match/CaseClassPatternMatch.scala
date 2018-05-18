package tour.pattern_match

abstract class Notification

case class Email(sender: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceRecording(contactName: String, link: String) extends Notification

abstract class Device

case class Phone(model: String) extends Device {
  def screenOff() = s"$model Turning screen off"
}

case class Computer(model: String) extends Device {
  def screenSaverOn() = s"$model Turning screen saver on..."
}

/**
  * trait 和 class可以被标记为sealed，这样它的所有子类就只能在同一个文件中声明
  */
sealed abstract class Furniture
case class Couch() extends Furniture
case class Chair() extends Furniture

object CaseClassPatternMatch {
  def showNotification(notification: Notification): String = {
    notification match {
      case Email(email, title, _) =>
        s"You got an email from $email with title: $title"
      case SMS(number, message) =>
        s"You got an SMS from $number! Message: $message"
      case VoiceRecording(name, link) =>
        s"You received a Voice Recording from $name! Click the link to hear it: $link"
    }
  }

  def testPatternMatch() = {
    val someSms = SMS("12345", "Are you there?")
    val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

    println(showNotification(someSms))
    println(showNotification(someVoiceRecording))
  }

  def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
    notification match {
      case Email(email, _, _) if importantPeopleInfo.contains(email) =>
        "You got an email from special someone!"
      case SMS(number, _) if importantPeopleInfo.contains(number) =>
        "You got an SMS from special someone!"
      case other =>
        showNotification(other) // nothing special, delegate to our original showNotification function
    }
  }

  def testPatternGuards() = {
    val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com")
    val someSms = SMS("867-5309", "Are you there?")
    val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")
    val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
    val importantSms = SMS("867-5309", "I'm here! Where are you?")

    println(showImportantNotification(someSms, importantPeopleInfo))
    println(showImportantNotification(someVoiceRecording, importantPeopleInfo))
    println(showImportantNotification(importantEmail, importantPeopleInfo))
    println(showImportantNotification(importantSms, importantPeopleInfo))
  }

  def goIdle(device: Device) = {
    device match {
      case p: Phone => p.screenOff()
      case c: Computer => c.screenSaverOn()
    }
  }

  def testPatternMatchType() = {
    val phone = Phone("mobile phone")
    println(goIdle(phone))
    val computer = Computer("computer")
    println(goIdle(computer))
  }

  def findPlaceToSit(piece: Furniture): String = {
    piece match {
      case a: Couch => "Lie on couch"
      case b: Chair => "Sit on the chair"
    }
  }

  def testPatternMatchSealedClass() = {
    val couch = Couch()
    val chair = Chair()
    println(findPlaceToSit(couch))
    println(findPlaceToSit(chair))
  }

  def main(args: Array[String]): Unit = {
    testPatternMatch()
    testPatternGuards()
    testPatternMatchType()
    testPatternMatchSealedClass()
  }
}
