package controllers

import models.Contact
import play.api.mvc.Results.Redirect
import play.api.mvc.Action
import play.api.mvc.Controller

object ScalaApplication extends Controller {

  def deleteContact(id: Long) = Action {
    Contact.delete(id);
    Redirect(routes.Application.contacts());
  }

}