package petClinics;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();


        while (n-- > 0) {
            String[] commandArgs = scanner.nextLine().split("\\s+");
            String clinicName = "";

            switch (commandArgs[0]) {
                case "Create" -> {
                    if (commandArgs[1].equals("Pet")) {
                        pets.put(commandArgs[2], new Pet(commandArgs[2], Integer.parseInt(commandArgs[3]), commandArgs[4]));

                    } else if (commandArgs[1].equals("Clinic")) {
                        try {
                            Clinic c = new Clinic(commandArgs[2], Integer.parseInt(commandArgs[3]));
                            clinics.put(commandArgs[2], c);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                case "Add" -> {
                    String petName = commandArgs[1];
                    clinicName = commandArgs[2];
                    Pet pet = pets.get(petName);
                    System.out.println(clinics.get(clinicName).add(pet));
                }
                case "Release" -> {
                    clinicName = commandArgs[1];
                    System.out.println(clinics.get(clinicName).release());
                }
                case "HasEmptyRooms" -> {
                    clinicName = commandArgs[1];
                    System.out.println(clinics.get(clinicName).hasEmptyRooms());
                }
                case "Print" -> {
                    if (commandArgs.length == 2) {
                        clinicName = commandArgs[1];
                        clinics.get(clinicName).print();
                    } else {
                        clinicName = commandArgs[1];
                        int room = Integer.parseInt(commandArgs[2]);
                        clinics.get(clinicName).print(room);
                    }
                }
            }
        }
    }

}