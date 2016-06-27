/**
  * Created by Administrator on 14/06/2016.
  */
case class Order( var OrderID: Int, var NameOfProduct: String, var productID: String, var Price: Double, var quantityOf: Int, var Damaged: String, var porousware: Boolean, var checkedOut: String,
                  var houseNumber: String,  var City: String,  var postCode: String) extends ItemDetails with Address {
}

