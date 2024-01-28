package br.com.agenda.data.menu;

import br.com.agenda.data.base.ContactList;
import br.com.agenda.functionalities.InsertAndModify;

import java.util.Scanner;

public class Menu {
    public void displayMenu() {
        String menu = """
                   >>>> Menu <<<<     
                 1 - Listar Contatos   
                 2 - Adicionar Contato 
                 3 - Remover Contato   
                 4 - Editar Contato    
                 5 - \u001B[31mSair\u001B[0m              
                """;
        System.out.println(menu);
        System.out.print("Digite uma opção: ");
    }

    public boolean checkOptionsMenu(long option, Scanner scanner, ContactList contactList) {
        InsertAndModify action = new InsertAndModify();

        if (contactList.isEmpty() && ((option != 2) && (option != 5))) { //if it is different from insert and exit
            System.out.println("\u001B[33m" + "Agenda de contatos vazia" + "\u001B[0m\n"); //yellow
            return true;
        }
        switch ((int) option) {
            case 1:
                contactList.displayList();
                break;
            case 2:
                contactList.addDataBase(action.inputContact(scanner, contactList));
                break;
            case 3:
                contactList.displayList();
                System.out.print("Digite o ID do contato que deseja remover: ");
                contactList.rmDataBase(action.inputIdContact(scanner, contactList));
                break;
            case 4:
                action.editContact(scanner, contactList);
                break;
            case 5:
                return false;
        }
        return true;
    }

    public boolean validateEntry(long option) {
        option = (int) option;

        if (option == 1 || option == 2 || option == 3 || option == 4 || option == 5) {
            return true;
        } else {
            System.out.println("\u001B[31m" + "Opção inválida" + "\u001B[0m"); //red
            return false;
        }
    }
}
