package controllers;

import models.Contact;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

    static Form<Contact> contactForm = form(Contact.class);

    public static Result index() {
        return redirect(routes.Application.contacts());
    }

    public static Result contacts() {
        return ok(views.html.index.render(Contact.all(), contactForm));
    }

    public static Result newContact() {
        Form<Contact> filledContact = contactForm.bindFromRequest();

        if (filledContact.hasErrors()) {
            return ok(views.html.index.render(Contact.all(), filledContact));
        }

        Contact.create(filledContact.get());

        return redirect(routes.Application.contacts());
    }

}