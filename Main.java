import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import packageName.holder;
import packageName.holder;

class Food implements Serializable {
  int itemno;
  int quantity;
  float price;

  Food(String i, int quantity) {
    this.itemno = i;
    this.quantity = quantity;
    switch (i) {
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
        System.out.println();("Wrong option");
        break;
    }
  }

  static void BookRoom(int i) throws NotAvailable {
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
                + hotel_ob.luxury_DoubleRoom[rn].food.get(i).quantity + " "
                + hotel_ob.luxury_DoubleRoom[rn].food.get(i).price);
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
                + hotel_ob.deluxe_DoubleRoom[rn].food.get(i).quantity + " "
                + hotel_ob.deluxe_DoubleRoom[rn].food.get(i).price);
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
                + hotel_ob.luxury_SingleRoom[rn].food.get(i).quantity + " "
                + hotel_ob.luxury_SingleRoom[rn].food.get(i).price);
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
                + hotel_ob.deluxe_SingleRoom[rn].food.get(i).quantity + " "
                + hotel_ob.deluxe_SingleRoom[rn].food.get(i).price);
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

  static void deallocate(int rn, int rtype) {
    int j;
    char w;
    switch (rtype) {
      case 1:
        if (hotel_ob.luxury_DoubleRoom[rn] != null) {
          System.out.println("Room used by " + hotel_ob.luxury_DoubleRoom[rn].name);
        } else {
          System.out.println("Empty room");
          return;
        }
        System.out.print("Do you want to checkout? (y/n): ");
        w = sc.next().charAt(0);
        if (w == 'y' || w == 'Y') {
          bill(rn, rtype);
          hotel_ob.luxury_DoubleRoom[rn] = null;
          System.out.println("Room deallocated");
        } else {
          System.out.println("Thank you for staying");
        }
        break;
      case 2:
        if (hotel_ob.deluxe_DoubleRoom[rn] != null) {
          System.out.println("Room used by " + hotel_ob.deluxe_DoubleRoom[rn].name);
        } else {
          System.out.println("Empty room");
          return;
        }
        System.out.print("Do you want to checkout? (y/n): ");
        w = sc.next().charAt(0);
        if (w == 'y' || w == 'Y') {
          bill(rn, rtype);
          hotel_ob.deluxe_DoubleRoom[rn] = null;
          System.out.println("Room deallocated");
        } else {
          System.out.println("Thank you for staying");
        }
        break;
      case 3:
        if (hotel_ob.luxury_SingleRoom[rn] != null) {
          System.out.println("Room used by " + hotel_ob.luxury_SingleRoom[rn].name);
        } else {
          System.out.println("Empty room");
          return;
        }
        System.out.print("Do you want to checkout? (y/n): ");
        w = sc.next().charAt(0);
        if (w == 'y' || w == 'Y') {
          bill(rn, rtype);
          hotel_ob.luxury_SingleRoom[rn] = null;
          System.out.println("Room deallocated");
        } else {
          System.out.println("Thank you for staying");
        }
        break;
      case 4:
        if (hotel_ob.deluxe_SingleRoom[rn] != null) {
          System.out.println("Room used by " + hotel_ob.deluxe_SingleRoom[rn].name);
        } else {
          System.out.println("Empty room");
          return;
        }
        System.out.print("Do you want to checkout? (y/n): ");
        w = sc.next().charAt(0);
        if (w == 'y' || w == 'Y') {
          bill(rn, rtype);
          hotel_ob.deluxe_SingleRoom[rn] = null;
          System.out.println("Room deallocated");
        } else {
          System.out.println("Thank you for staying");
        }
        break;
      default:
        System.out.println("Wrong option");
        break;
    }
  }

  static void orderFood(int rn, int rtype) {
    String i;
    int q;
    char wish;
    try {
      System.out.println(
          "\n==========\n   Menu:  \n==========\n\n1.Sandwich\tRs.50\n2.Pasta\t\tRs.60\n3.Noodles\tRs.70\n4.Coke\t\tRs.30\n");
      do {
        i = sc.nextLine();
        System.out.print("Quantity: ");
        q = sc.nextInt();

        switch (rtype) {
          case 1:
            hotel_ob.luxury_DoubleRoom[rn].food.add(new Food(i, q));
            break;
          case 2:
            hotel_ob.deluxe_DoubleRoom[rn].food.add(new Food(i, q));
            break;
          case 3:
            hotel_ob.luxury_SingleRoom[rn].food.add(new Food(i, q));
            break;
          case 4:
            hotel_ob.deluxe_SingleRoom[rn].food.add(new Food(i, q));
            break;
        }
        System.out.print("Do you want to order anything else? (y/n): ");
        wish = sc.next().charAt(0);
      } while (wish == 'y' || wish == 'Y');
    } catch (NullPointerException e) {
      System.out.println("Room not booked");
    } catch (Exception e) {
      System.out.println("Invalid Input");
    }
  }
}

class write implements Runnable {
  Holder hotel_ob;

  write(Holder hotel_ob) {
    this.hotel_ob = hotel_ob;
  }

  @Override
  public void run() {
    try {
      FileOutputStream fout = new FileOutputStream("backup");
      ObjectOutputStream oos = new ObjectOutputStream(fout);
      oos.writeObject(hotel_ob);
      oos.close();
      fout.close();
    } catch (Exception e) {
      System.out.println("Error in writing " + e);
    }
  }
}

public class Main {
  public static void main(String[] args) {
    try {
      File f = new File("backup");
      if (f.exists()) {
        FileInputStream fin = new FileInputStream("backup");
        ObjectInputStream ois = new ObjectInputStream(fin);
        Hotel.hotel_ob = (Holder) ois.readObject();
        ois.close();
        fin.close();
      }
      Scanner sc = new Scanner(System.in);
      int ch, ch2;
      char wish;
      x: do {
        System.out.println(
            "\nEnter your choice :\n1.Display room details\n2.Display room availability \n3.Book\n4.Order food\n5.Checkout\n6.Exit\n");
        ch = sc.nextInt();
        switch (ch) {
          case 1:
            System.out.println(
                "\nChoose room type:\n1.Luxury Double Room\n2.Deluxe Double Room\n3.Luxury Single Room\n4.Deluxe Single Room\n");
            ch2 = sc.nextInt();
            Hotel.features(ch2);
            break;
          case 2:
            System.out.println(
                "\nChoose room type:\n1.Luxury Double Room\n2.Deluxe Double Room\n3.Luxury Single Room\n4.Deluxe Single Room\n");
            ch2 = sc.nextInt();
            Hotel.availability(ch2);
            break;
          case 3:
            System.out.println(
                "\nChoose room type:\n1.Luxury Double Room\n2.Deluxe Double Room\n3.Luxury Single Room\n4.Deluxe Single Room\n");
            ch2 = sc.nextInt();
            Hotel.BookRoom(ch2);
            break;
          case 4:
            System.out.println(
                "\nChoose room type:\n1.Luxury Double Room\n2.Deluxe Double Room\n3.Luxury Single Room\n4.Deluxe Single Room\n");
            ch2 = sc.nextInt();
            System.out.print("Room number: ");
            int rn = sc.nextInt();
            Hotel.orderFood(rn - 1, ch2);
            break;
          case 5:
            System.out.println(
                "\nChoose room type:\n1.Luxury Double Room\n2.Deluxe Double Room\n3.Luxury Single Room\n4.Deluxe Single Room\n");
            ch2 = sc.nextInt();
            System.out.print("Room number: ");
            rn = sc.nextInt();
            Hotel.deallocate(rn - 1, ch2);
            break;
          case 6:
            Thread t = new Thread(new write(Hotel.hotel_ob));
            t.start();
            break x;
          default:
            System.out.println("Wrong option");
            break;
        }
        System.out.println("\nContinue : (y/n)");
        wish = sc.next().charAt(0);
        if (!(wish == 'y' || wish == 'Y' || wish == 'n' || wish == 'N')) {
          System.out.println("Invalid Input");
          System.out.println("\nContinue : (y/n)");
          wish = sc.next().charAt(0);
        }
      } while (wish == 'y' || wish == 'Y');
      Thread t = new Thread(new write(Hotel.hotel_ob));
      t.start();
    } catch (Exception e) {
      System.out.println("Error in main " + e);
    }
  }
}
