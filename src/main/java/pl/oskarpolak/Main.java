package pl.oskarpolak;

import pl.oskarpolak.models.ContactModel;
import pl.oskarpolak.models.dao.ContactDao;
import pl.oskarpolak.models.dao.impl.ContactDaoImpl;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String response;
        ContactDao contactDao = new ContactDaoImpl();

        do {
            System.out.println("Wpisz: ");
            System.out.println("1 - aby dodać nowy kontakt");
            System.out.println("2 - aby usunąć kontakt");
            System.out.println("3 - aby wyświetlić wszystkie kontakty");

            System.out.print("Odpowiedź: ");
            response = scanner.nextLine();

            switch (response){
                case "1": {
                    ContactModel model = new ContactModel(scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
                    contactDao.addContact(model);
                    break;
                }
                case "2": {
                    System.out.print("Podaj numer który chcesz usunąć: ");
                    contactDao.removeContact(scanner.nextLine());
                    break;
                }
                case "3": {
                    for (ContactModel contactModel : contactDao.getAllContacts()) {
                        System.out.println(contactModel.toString());
                    }
                    break;
                }
            }

        }while (!response.equals("exit"));
    }
}
