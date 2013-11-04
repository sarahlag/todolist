package controllers;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import models.MyTodo;
import play.*;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import views.html.*;

public class Application extends Controller {
	
	final static Form<MyTodo> TodoForm = Form.form(MyTodo.class);

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result addTodo() throws IOException {
   	
		Form<MyTodo> form = Form.form(MyTodo.class).bindFromRequest();
		MyTodo todo = new MyTodo();

		todo.commentaire = form.field("comment").value();
		todo.creationDate = new Date();
;
		MyTodo.create(todo);

		return redirect(routes.Application.showTodolist());
	}
    
    public static Result showTodolist() {
		List<MyTodo> Todos = MyTodo.all();

		if (request().accepts("text/html"))
			return ok(views.html.todopage.render(Todos, TodoForm));
		else if (request().accepts("application/json"))
			return ok(Json.toJson(Todos));
		else if (request().accepts("application/rdf+xml"))
			return ok("this will be RDF XML");
		return badRequest();
	}
}
