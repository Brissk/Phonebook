package Model.Storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Contact;
import Model.ContactBuilder;
import Model.Phonebook;

public class MyCsv implements Storage {

    private String name = "pb.csv";
    private File file;

    public MyCsv() throws IOException {
        file = new File(this.name);
        file.createNewFile(); //создаст файл
    }

    @Override
    public void myExport(Phonebook pb) throws IOException {
        FileWriter fw = new FileWriter(this.name);
        fw.write(serialize(pb.contacts));
        fw.close();
    }

    @Override
    public void myImport(Phonebook pb) throws IOException, ParseException {
        String content = "";
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            content += scan.nextLine();
        }
        scan.close();
        pb.contacts = deserialize(content);
    }

    @Override
    public String serialize(ArrayList<Contact> contacts) {
        StringBuilder csv = new StringBuilder();
        csv.append("id ").append("name ").append("phonenumber").append(";");
        System.out.println(csv);

        for (Contact c : contacts) {
            csv.append(c.getId()).append("\t").append(c.getName()).append("\t").append(c.getPhoneNumber());
            System.out.println(c);
        }

        return csv.toString();
    }

    @Override
    public ArrayList<Contact> deserialize(String content) throws ParseException {
        ArrayList<Contact> contacts = new ArrayList<>();
        ContactBuilder builder = new ContactBuilder();
        String[] row = content.split(";");
        for (int i = 1; i < row.length; i++) {
            String[] data = row[i].split("\t");
            Integer id = Integer.parseInt(data[0]);
            String name = data[1];
            String phonenumber = data[2];
            Contact thisContact = builder.setId(id).setName(name).setPhoneNumber(phonenumber).createContact();
            contacts.add(thisContact);
        }
        return contacts;
    }

}