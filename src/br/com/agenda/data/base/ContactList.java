package br.com.agenda.data.base;

import br.com.agenda.details.contact.Contact;
import br.com.agenda.details.telephone.Telephone;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactList {
    private List<Contact> contactList = new ArrayList<>();

    public boolean isEmpty() {
        return contactList.isEmpty();
    }

    public boolean emptyTelephoneList(Long id) {
        return contactList.get(Math.toIntExact(id)).getTelephones().isEmpty();
    }

    public void displayList() {
        System.out.println("\u001B[34m" + "----------- AGENDA ----------" + "\u001B[0m");
        for (Contact contact : contactList) {
            System.out.print("\u001B[34m"); //blue
            System.out.println(contact.getId() + "\u001B[34m" + " | " + " " + contact.getName() + " " + contact.getSurname() + "\u001B[0m");
            System.out.print(contact.formatPhoneList());
        }
        System.out.println("\u001B[34m" + "-----------------------------" + "\u001B[0m");
    }

    public void phoneDisplayList(Long idContact) {
        contactList.get(Math.toIntExact(idContact)).formatPhoneList();
    }

    public void addDataBase(Contact newContact) {
        contactList.add(newContact);
        System.out.println("\u001B[32m" + "Contato adicionado com sucesso\n" + "\u001B[0m"); //green
    }

    public void rmDataBase(Long id) {
        //resolver bug
        for (Contact contact : contactList) {
            if (Objects.equals(id, contact.getId())) {
                contactList.remove(contact);
                System.out.println("\u001B[32m" + "Contato removido com sucesso\n" + "\u001B[0m"); //green
            }
        }
    }

    public void addTelephoneContact(Telephone telephone, Long id) {
        for (Contact contact : contactList) {
            if (Objects.equals(id, contact.getId())) {
                contact.addTelephones(telephone);
                System.out.println("\u001B[32m" + "Telefone adicionado com sucesso\n" + "\u001B[0m"); //green
                break;
            }
        }
    }

    public void rmTelephoneContact(Long idTelephone, Long idContact) {
        //resolver bug
        List<Telephone> telephoneList = contactList.get(Math.toIntExact(idContact)).getTelephones();

        for (Telephone telephone : telephoneList) {
            if (Objects.equals(idTelephone, telephone.getId())) {
                telephoneList.remove(telephone);
                System.out.println("\u001B[32m" + "Telefone removido com sucesso\n" + "\u001B[0m"); //green
            }
        }
    }

    public void editTelephoneContact(Long idTelephone, Telephone edited, Long idContact) {
        List<Telephone> telephoneList = contactList.get(Math.toIntExact(idContact)).getTelephones();

        for (Telephone telephone : telephoneList) {
            if (Objects.equals(idTelephone, telephone.getId())) {
                telephone.setDdd(edited.getDdd());
                telephone.setNumber(edited.getNumber());
                System.out.println("\u001B[32m" + "Telefone Editado com sucesso\n" + "\u001B[0m"); //green
            }
        }
    }

    public void editNameContact(Contact edited, Long idContato) {
        for (Contact contact : contactList) {
            if (Objects.equals(idContato, contact.getId())) {
                contact.setName(edited.getName());
                contact.setSurname(edited.getSurname());
                System.out.println("\u001B[32m" + "Nome editado com sucesso\n" + "\u001B[0m"); //green
            }
        }
    }

    public boolean verificationIdContact(Long id) {
        for (Contact contact : contactList) {
            if (Objects.equals(id, contact.getId())) {
                return true;
            }
        }
        return false;
    }

    public Long nextIdContact() {
        return contactList.getLast().getId() + 1L;
    }

    public boolean verificationIdTelephone(Long id, long idContact) {
        List<Telephone> telephoneList = contactList.get(Math.toIntExact(idContact)).getTelephones();

        for (Telephone telephone : telephoneList) {
            if (Objects.equals(id, telephone.getId())) {
                return true;
            }
        }
        return false;
    }

    public Long nextIdTelephone(Long id) {
        return contactList.get(Math.toIntExact(id)).getTelephones().getLast().getId() + 1L;
    }
}
