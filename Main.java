import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

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

  public Singleroom(String name2, String contact2, String gender2) {
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

class NotAvailable extends Exception {
  @Override
  public String toString() {
    return "Room Not Available";
  }
}

class Holder implements Serializable {
  DoubleRoom luxury_DoubleRoom[] = new DoubleRoom[10];
  DoubleRoom deluxe_DoubleRoom[] = new DoubleRoom[20];
  Singleroom luxury_SingleRoom[] = new Singleroom[10];
  Singleroom deluxe_SingleRoom[] = new Singleroom[20];
}

class Hotel {
  static Holder hotel_ob = new Holder();
  static Scanner sc = new Scanner(System.in);

  static void CustDetails(int i, int rn) {
    String name, contact, gender;
    String name2 = null, contact2 = null;
    String gender2 = "";
    System.out.print("\nEnter customer name: ");
    name = sc.next();
    System.out.print("Enter contact number: ");
    contact = sc.next();
    System.out.print("Enter gender: ");
    gender = sc.next();

    if (i < 3) {
      System.out.print("Enter second customer name: ");
      name2 = sc.next();
      System.out.print("Enter contact number: ");
      contact2 = sc.next();
      System.out.print("Enter gender: ");
      gender2 = sc.next();
    }

    switch (i) {
      case 1:
        hotel_ob.luxury_DoubleRoom[rn] = new DoubleRoom(name, contact, gender, name2, contact2, gender2);
        break;
      case 2:
        hotel_ob.deluxe_DoubleRoom[rn] = new DoubleRoom(name, contact, gender, name2, contact2, gender2);
        break;
      case 3:
        hotel_ob.luxury_SingleRoom[rn] = new Singleroom(name, contact, gender);
        break;
      case 4:
        hotel_ob.deluxe_SingleRoom[rn] = new Singleroom(name, contact, gender);
        break;
      default:
        System.out.printl("Wrong option");
        break;
    }
  }

  static void BookRoom(int i) {
    int j, rn;
    System.out.println("\nChoose room number from: ");
    switch (i) {
      case 1:
        for (j = 0; j < 10; j++) {
          if (hotel_ob.luxury_DoubleRoom[j] == null) {
            System.out.print(j + 1 + " ");
          } else {
            System.out.print("N/A ");
          }
        }
        System.out.print("\nEnter room number: ");
        rn = sc.nextInt();
        if (hotel_ob.luxury_DoubleRoom[rn - 1] == null) {
          CustDetails(i, rn - 1);
        } else {
          throw new NotAvailable();
        }
        break;
      case 2:
        for (j = 0; j < 20; j++) {
          if (hotel_ob.deluxe_DoubleRoom[j] == null) {
            System.out.print(j + 1 + " ");
          } else {
            System.out.print("N/A ");
          }
        }
        System.out.print("\nEnter room number: ");
        rn = sc.nextInt();
        if (hotel_ob.deluxe_DoubleRoom[rn - 1] == null) {
          CustDetails(i, rn - 1);
        } else {
          throw new NotAvailable();
        }
        break;
      case 3:
        for (j = 0; j < 10; j++) {
          if (hotel_ob.luxury_SingleRoom[j] == null) {
            System.out.print(j + 1 + " ");
          } else {
            System.out.print("N/A ");
          }
        }
        System.out.print("\nEnter room number: ");
        rn = sc.nextInt();
        if (hotel_ob.luxury_SingleRoom[rn - 1] == null) {
          CustDetails(i, rn - 1);
        } else {
          throw new NotAvailable();
        }
        break;
      case 4:
        for (j = 0; j < 20; j++) {
          if (hotel_ob.deluxe_SingleRoom[j] == null) {
            System.out.print(j + 1 + " ");
          } else {
            System.out.print("N/A ");
          }
        }
        System.out.print("\nEnter room number: ");
        rn = sc.nextInt();
        if (hotel_ob.deluxe_SingleRoom[rn - 1] == null) {
          CustDetails(i, rn - 1);
        } else {
          throw new NotAvailable();
        }
        break;
      default:
        System.out.println("Wrong option");
        break;
    }
    System.out.println("Room Booked");
  }

  static void features(int i) {
    switch (i) {
      case 1:
        System.out.println("Room no\t\t\t\tFeatures");
        System.out
            .println("1-10\t\t\t\t2 Double beds, AC, TV, sofa, fridge, bathtub, balcony, WiFi, breakfast included");
        break;
      case 2:
        System.out.println("Room no\t\t\t\tFeatures");
        System.out
            .println("1-20\t\t\t\t1 Double bed, AC, TV, sofa, fridge, bathtub, balcony, WiFi, breakfast included");
        break;
      case 3:
        System.out.println("Room no\t\t\t\tFeatures");
        System.out
            .println("1-10\t\t\t\t1 Single bed, AC, TV, sofa, fridge, bathtub, balcony, WiFi, breakfast included");
        break;
      case 4:
        System.out.println("Room no\t\t\t\tFeatures");
        System.out
            .println("1-20\t\t\t\t1 Single bed, AC, TV, sofa, fridge, bathtub, balcony, WiFi, breakfast included");
        break;
      default:
        System.out.println("Wrong option");
        break;
    }
  }

  static void availability(int i) {
    int j, count = 0;
    switch (i) {
      case 1:
        for (j = 0; j < 10; j++) {
          if (hotel_ob.luxury_DoubleRoom[j] == null) {
            count++;
          }
        }
        System.out.println("Number of rooms available: " + count);
        break;
      case 2:
        for (j = 0; j < 20; j++) {
          if (hotel_ob.deluxe_DoubleRoom[j] == null) {
            count++;
          }
        }
        System.out.println("Number of rooms available: " + count);
        break;
      case 3:
        for (j = 0; j < 10; j++) {
          if (hotel_ob.luxury_SingleRoom[j] == null) {
            count++;
          }
        }
        System.out.println("Number of rooms available: " + count);
        break;
      case 4:
        for (j = 0; j < 20; j++) {
          if (hotel_ob.deluxe_SingleRoom[j] == null) {
            count++;
          }
        }
        System.out.println("Number of rooms available: " + count);
        break;
      default:
        System.out.println("Wrong option");
        break;
    }
  }

  static void bill(int rn, int rtype) {
    float total = 0;
    int i;
    System.out.println("\n*****HOTEL BILL*****");
    System.out.println("---------------------------------------------");
    switch (rtype) {
      case 1:
        for (i = 0; i < 10; i++) {
          if (hotel_ob.luxury_DoubleRoom[rn].food.get(i) != null) {
            System.out.println(hotel_ob.luxury_DoubleRoom[rn].food.get(i).itemno + " "
                + hotel_ob.luxury_DoubleRoom[rn].food.get(i).quantity + " " + hotel_ob.luxury_DoubleRoom[rn].food.get(i).price);
            total += hotel_ob.luxury_DoubleRoom[rn].food.get(i).price;
          }
        }
        total += hotel_ob.luxury_DoubleRoom[rn].roomprice;
        System.out.println("Room Price: " + hotel_ob.luxury_DoubleRoom[rn].roomprice);
        break;
      case 2:
        for (i = 0; i < 10; i++) {
          if (hotel_ob.deluxe_DoubleRoom[rn].food.get(i) != null) {
            System.out.println(hotel_ob.deluxe_DoubleRoom[rn].food.get(i).itemno + " "
                + hotel_ob.deluxe_DoubleRoom[rn].food.get(i).quantity + " " + hotel_ob.deluxe_DoubleRoom[rn].food.get(i).price);
            total += hotel_ob.deluxe_DoubleRoom[rn].food.get(i).price;
          }
        }
        total += hotel_ob.deluxe_DoubleRoom[rn].roomprice;
        System.out.println("Room Price: " + hotel_ob.deluxe_DoubleRoom[rn].roomprice);
        break;
      case 3:
        for (i = 0; i < 10; i++) {
          if (hotel_ob.luxury_SingleRoom[rn].food.get(i) != null) {
            System.out.println(hotel_ob.luxury_SingleRoom[rn].food.get(i).itemno + " "
                + hotel_ob.luxury_SingleRoom[rn].food.get(i).quantity + " " + hotel_ob.luxury_SingleRoom[rn].food.get(i).price);
            total += hotel_ob.luxury_SingleRoom[rn].food.get(i).price;
          }
        }
        total += hotel_ob.luxury_SingleRoom[rn].roomprice;
        System.out.println("Room Price: " + hotel_ob.luxury_SingleRoom[rn].roomprice);
        break;
      case 4:
        for (i = 0; i < 10; i++) {
          if (hotel_ob.deluxe_SingleRoom[rn].food.get(i) != null) {
            System.out.println(hotel_ob.deluxe_SingleRoom[rn].food.get(i).itemno + " "
                + hotel_ob.deluxe_SingleRoom[rn].food.get(i).quantity + " " + hotel_ob.deluxe_SingleRoom[rn].food.get(i).price);
            total += hotel_ob.deluxe_SingleRoom[rn].food.get(i).price;
          }
        }
        total += hotel_ob.deluxe_SingleRoom[rn].roomprice;
        System.out.println("Room Price: " + hotel_ob.deluxe_SingleRoom[rn].roomprice);
        break;
      default:
        System.out.println("Wrong option");
        break;
    }
    System.out.println("---------------------------------------------");
    System.out.println("Total Price: " + total);
    System.out.println("---------------------------------------------");
  }
