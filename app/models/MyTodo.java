package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Ebean;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class MyTodo extends Model{
	@Id
	public long id;
	public String commentaire;
	public Date creationDate;
	
	public MyTodo(){
		
	}
	
	public static Finder<Long, MyTodo> find = new Finder<Long, MyTodo>(Long.class, MyTodo.class);
	
	public static List<MyTodo> all()
	{
		return find.all();
	}

	public static void create(MyTodo Todo)
	{
		if (!Todo.commentaire.isEmpty())
			Ebean.save(Todo);
	}
}
