package com.zoo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.zoo.controller.AnimalController;
import com.zoo.controller.EnclosureController;
import com.zoo.controller.FeedLogController;
import com.zoo.controller.StaffController;
import com.zoo.model.Animal;
import com.zoo.model.Enclosure;
import com.zoo.model.FeedLog;
import com.zoo.model.Staff;

public class Main {
  public static void main(String[] args) {

    // scanner
    Scanner scanner = new Scanner(System.in);

    // cool stuff
    // https://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20
    System.out.println("\r\n" + 
        "    ______                      _                 __\r\n" + 
        "   / ____/___ ___  ____  ____  (_)___ ___  ____ _/ /\r\n" + 
        "  / __/ / __ `__ \\/ __ \\/ __ \\/ / __ `__ \\/ __ `/ / \r\n" + 
        " / /___/ / / / / / /_/ / / / / / / / / / / /_/ / /  \r\n" + 
        "/_____/_/ /_/ /_/\\____/_/ /_/_/_/ /_/ /_/\\__,_/_/   \r\n" + 
        "/__  /  ____  ____                                  \r\n" + 
        "  / /  / __ \\/ __ \\                                 \r\n" + 
        " / /__/ /_/ / /_/ /                                 \r\n" + 
        "/____/\\____/\\____/                                  \r\n" + 
        "                                                    \r\n");
    
    // title
    System.out.println("Welcome to Emonimal Zoo Management System v1.0.0.");
    System.out.println("Type \"help\" for more information.");

    // type exit
    boolean exit = false;

    // loop
    while(!exit){
      // read start
      System.out.print("> ");
      String command = scanner.next();

      Animal animal = new Animal();
      Enclosure enclosure = new Enclosure();
      Staff staff = new Staff();
      FeedLog feedLog = new FeedLog();
      int id;
      // comand switch
      switch (command) {
        case "help":
          System.out.println(help());
          break;
        case "anis":
          System.out.println(AnimalController.anis());
          break;
        case "anibyenc":
          System.out.print("Target Enclouser ID");
          id = scanner.nextInt();
          System.out.println(AnimalController.anibyenc(id));
          break;
        case "aniadd":
          System.out.print("Animal type ID: ");
          animal.id_animal_type = scanner.nextInt();
          System.out.print("Zoo ID: ");
          animal.id_zoo = scanner.nextInt();
          System.out.print("Enclosure ID: ");
          animal.idEnclosure = scanner.nextInt();
          System.out.print("Status ID: ");
          animal.id_status = scanner.nextInt();
          System.out.print("Name: ");
          animal.name = scanner.next();
          System.out.print("Introduction: ");
          animal.introduction = scanner.next();
          System.out.print("Nofication: ");
          animal.nofication = scanner.next();
          System.out.print("Img url: ");
          animal.img_url = scanner.next();
          System.out.println(AnimalController.aniadd(animal));
          break;
        case "aniupg":
          System.out.print("Target Animal ID: ");
          animal.id_animal = scanner.nextInt();
          System.out.print("Animal type ID: ");
          animal.id_animal_type = scanner.nextInt();
          System.out.print("Zoo ID: ");
          animal.id_zoo = scanner.nextInt();
          System.out.print("Enclosure ID: ");
          animal.idEnclosure = scanner.nextInt();
          System.out.print("Status ID: ");
          animal.id_status = scanner.nextInt();
          System.out.print("Name: ");
          animal.name = scanner.next();
          System.out.print("Introduction: ");
          animal.introduction = scanner.next();
          System.out.print("Nofication: ");
          animal.nofication = scanner.next();
          System.out.print("Img url: ");
          animal.img_url = scanner.next();
          System.out.println(AnimalController.aniupg(animal));
          break;
        case "anidel":
          System.out.print("Target Animal ID");
          id = scanner.nextInt();
          System.out.println(AnimalController.anidel(id));
          break;
        case "encs":
          System.out.println(EnclosureController.encs());
          break;
        case "encadd":
          System.out.print("Zoo ID: ");
          enclosure.id_zoo = scanner.nextInt();
          System.out.print("Name: ");
          enclosure.name = scanner.next();
          System.out.print("Introduce: ");
          enclosure.introduce = scanner.next();
          System.out.println(EnclosureController.encadd(enclosure));
          break;
        case "encupg":
          System.out.print("Target Enclosure ID: ");
          enclosure.id_enclosure = scanner.nextInt();
          System.out.print("Zoo ID: ");
          enclosure.id_zoo = scanner.nextInt();
          System.out.print("Name: ");
          enclosure.name = scanner.next();
          System.out.print("Introduce: ");
          enclosure.introduce = scanner.next();
          System.out.println(EnclosureController.encupg(enclosure));
          break;
        case "encdel":
          System.out.print("Target Enclosure ID");
          id = scanner.nextInt();
          System.out.println(EnclosureController.encdel(id));
          break;
        case "staffs":
          System.out.println(StaffController.staffs());
          break;
        case "staffadd":
          System.out.print("Zoo ID: ");
          staff.id_zoo = scanner.nextInt();
          System.out.print("Staff type ID: ");
          staff.id_staff_type = scanner.nextInt();
          System.out.print("Name: ");
          staff.name = scanner.next();
          System.out.print("Salary: ");
          staff.salary = scanner.nextInt();
          System.out.println(StaffController.staffadd(staff));
          break;
        case "staffupg":
          System.out.print("Target Staff ID: ");
          staff.id_staff = scanner.nextInt();
          System.out.print("Zoo ID: ");
          staff.id_zoo = scanner.nextInt();
          System.out.print("Staff type ID: ");
          staff.id_staff_type = scanner.nextInt();
          System.out.print("Name: ");
          staff.name = scanner.next();
          System.out.print("Salary: ");
          staff.salary = scanner.nextInt();
          System.out.println(StaffController.staffupg(staff));
          break;
        case "staffdel":
          System.out.print("Target Staff ID");
          id = scanner.nextInt();
          System.out.println(StaffController.staffdel(id));
          break;
        case "fedbyani":
          System.out.print("Target Animal ID");
          id = scanner.nextInt();
          System.out.println(FeedLogController.fedbyani(id));
          break;
        case "fedadd":
          System.out.print("Food ID: ");
          feedLog.id_food = scanner.nextInt();
          System.out.print("Animal ID: ");
          feedLog.idAnimal = scanner.nextInt();
          LocalDateTime now = LocalDateTime.now();
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
          String formattedDateTime = now.format(formatter);
          feedLog.time = formattedDateTime;
          System.out.println(FeedLogController.fedadd(feedLog));
          break;
        case "exit":
          exit = true;
          break;
        default:
          System.out.println("Uncaught ReferenceError: "+command+" is not defined");
          break;
      }
    }

    scanner.close();
  }

  // help
  public static String help(){
    String msg = "" + 
    "anis        Get all animal list\n" +
    "anibyenc    Get animal by enclosure id\n" +
    "aniadd      Add animal\n" +
    "aniupg      Update animal by animal id\n" +
    "anidel      Delete animal by animal id\n" +
    "encs        Get all enclosure list\n" +
    "encadd      Add enclosure\n" +
    "encupg      Update enclosure by enclosure id\n" +
    "encdel      Delete enclosure by enclosure id\n" +
    "staffs      Get all staff list\n" +
    "staffadd    Add staff\n" +
    "staffupg    Update staff by staff id\n" +
    "staffdel    Delete staff by staff id\n" +
    "fedbyani    Get feed log by animal id\n" +
    "fedadd      Add feed log\n" +
    "\nType exit to exit the program";
    return msg;
  }

}