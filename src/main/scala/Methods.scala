
import com.sun.xml.internal.bind.v2.runtime.Name

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 14/06/2016.
  */

object Methods {

  def main(args: Array[String]): Unit = {
  }

  var item1 = new StockStore("Guantana-gnomebay", 100)
  var item2 = new StockStore("Alca-gnome", 100)
  var item3 = new StockStore("Tupac", 100)
  var item4 = new StockStore("Rick James", 100)


  var order1 = new Order(1, "Alca-gnome", "554", 23.00, 12, "Good as new", false, "Un-allocated", "00", "Canterbury", "ct5")
  var order2 = new Order(2, "Alca-gnome", "555", 11.00, 5, "Good as new", false, "Un-allocated", "42", "Canterbury", "ct5")
  var order3 = new Order(3, "Tupac", "464", 1.00, 4, "Clearance", true, "Un-allocated", "62", "penton", "hfg")
  var order4 = new Order(4, "Rick James", "65415", 111.00, 4, "Good as new", false, "Unalocated", "654", "London", "hg7")
  var order5 = new Order(5, "Guantana-gnomebay", "4114", 564.00, 21, "clearance", true, "Un-allocated", "54", "Lincoln", "LN1 1QL")
  var myArray = Array(order1, order2, order3, order4, order5)
  var exit = false
  var limit = myArray.length

  while (exit == false) {
    println("\n \nTo view an order press: 1 \nTo change order status: 2 \nTo add stock press: 3 \nTo exit the application press: q")
    var menuChoice = scala.io.StdIn.readLine()

    match {
      case "1" =>
        viewOrder()

      case "2" =>
        orderStatus()

      case "3" =>

        addStock()
      case q =>
        exit = true
    }
  }
  def viewOrder(): Unit = {
    println("Pleas enter the order number to display")
    var orderNumberChoice = scala.io.StdIn.readInt()

    for (i <- 0 until myArray.length) {
      if (myArray(i).OrderID == orderNumberChoice) {
        println("Order ID: " + myArray(i).OrderID + "\nName of product: " + myArray(i).NameOfProduct + "\nProduct ID: " + myArray(i).productID + "\nPrice: " + myArray(i).Price + "\nQuantity: " + myArray(i).quantityOf + "\nDamage Status: " + myArray(i).Damaged
          + "\nPorousware: " + myArray(i).porousware + "\nOrder Staus: " + myArray(i).checkedOut + "\nAddress: " + myArray(i).houseNumber + " " + myArray(i).City + " " + myArray(i).postCode)

      }

    }
    println("Would you like to print the order? Press y to print \nPress n to continue without printing")
    var printOption = scala.io.StdIn.readLine()

    if (printOption == "y") {
      println("Printing order")
    }
  }
  def orderStatus(): Unit ={
    println("please enter the order number to change the status of")
    var orderNumberChoice = scala.io.StdIn.readInt() //Reads the users input


    for (i <- 0 until myArray.length) {
      //searches the length of the array to find the item
      if (myArray(i).OrderID == orderNumberChoice) {
        //if the item number matches then...
        print("Please enter your name to show the order is being worked on or enter 'Disspatch' to mark the order as disspatched \n") //Ask the user for new order status
        var newStatus = scala.io.StdIn.readLine() //read in the order status
        myArray(i).checkedOut = newStatus //update the order status
        println("Status changed to " + newStatus) //display the new order status
        if (newStatus == "Disspatch"){
          notifyAccounts()
        }


        if (myArray(i).NameOfProduct == "Guantana-gnomebay") {
          item1.itemQuantity = item1.itemQuantity - myArray(i).quantityOf
        }
        else if (myArray(i).NameOfProduct == "Alca-gnome") {
          item2.itemQuantity = item2.itemQuantity - myArray(i).quantityOf
        }
        else if (myArray(i).NameOfProduct == "Tupac") {
          item3.itemQuantity = item3.itemQuantity - myArray(i).quantityOf
        }
        else if (myArray(i).NameOfProduct == "Rick James") {
          item4.itemQuantity = item4.itemQuantity - myArray(i).quantityOf
        }
        else println("Item not found")
      }


    }

  }
  def addStock(): Unit ={
    println("Enter the name of the item")
    var nameOfItem = scala.io.StdIn.readLine()
    println("\n Please enter the quantity of the item")
    var numberOfItem = scala.io.StdIn.readInt()
    if (nameOfItem == "Guantana-gnomebay") {
      item1.itemQuantity = item1.itemQuantity + numberOfItem
      println("There are now: " + item1.itemQuantity + nameOfItem)
    }
    else if (nameOfItem == "Alca-gnome") {
      item2.itemQuantity = item2.itemQuantity + numberOfItem
      println("There are now: " + item2.itemQuantity + nameOfItem)
    }
    else if (nameOfItem == "Tupac") {
      item3.itemQuantity = item3.itemQuantity + numberOfItem
      println("There are now: " + item3.itemQuantity + nameOfItem)
    }
    else if (nameOfItem == "Rick James") {
      item4.itemQuantity = item4.itemQuantity + numberOfItem
      println("There are now: " + item4.itemQuantity + nameOfItem)
    }
    else println("Item not found")
    println("Accounts have been notified of delivery.")
  }
  def notifyAccounts(): Unit ={
    println("Accounts have been notified of the order disspatch")
  }
}


