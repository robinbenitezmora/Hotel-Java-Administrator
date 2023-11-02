import java.io.Serializable;
import java.util.ArrayList;

class Food implements Serializable {
 int itemno;
 int quantity;
 float price;

 Food(int itemno, int quantity) {
  this.itemno = itemno;
  this.quantity = quantity;
  switch (itemno) {
   case 1:
    price = quantity * 50;
    break;
   case 2:
    price = quantity * 60;
    break;
   case 3:
    price = quantity * 70;
    break;
   case 4:
    price = quantity * 30;
    break;
  }
 }
}

class Singleroom implements Serializable {
 String name;
 String contact;
 String gender;
 String address;
 String checkin;
 String checkout;
 int days;
 int roomno;
 int roomtype;
 float roomprice;

 ArrayList<Food> food = new ArrayList<>();

 Singleroom() {
  this.name = "";
 }

 Singleroom(String name, String contact, String gender, String address, String checkin, String checkout, int days,
   int roomno, int roomtype, float roomprice) {
  this.name = name;
  this.contact = contact;
  this.gender = gender;
  this.address = address;
  this.checkin = checkin;
  this.checkout = checkout;
  this.days = days;
  this.roomno = roomno;
  this.roomtype = roomtype;
  this.roomprice = roomprice;
 }
}

class DoubleRoom extends Singleroom {
 String name2;
 String contact2;
 String gender2;
 String address2;
 String checkin2;
 String checkout2;
 int days2;
 int roomno2;
 int roomtype2;
 float roomprice2;

 DoubleRoom() {
  this.name = "";
  this.name2 = "";
 }

 DoubleRoom(String name, String contact, String gender, String name2, String contact2, String gender2) {
  this.name = name;
  this.contact = contact;
  this.gender = gender;
  this.name2 = name2;
  this.contact2 = contact2;
  this.gender2 = gender2;
 }
}