package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Contact extends Model {

    @Id
    public Long id;

    @Required
    public String name;

    @Required
    @Constraints.Email
    public String mail;

    public static List<Contact> all() {
        return find.all();
    }

    public static void create(Contact contact) {
        contact.save();
    }

    public static void delete(Long id) {
        find.ref(id).delete();
    }

    public static Finder<Long, Contact> find = new Finder<Long, Contact>(Long.class, Contact.class);

}