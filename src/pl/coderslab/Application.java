package pl.coderslab;

import pl.coderslab.DAO.UserDAO;
import pl.coderslab.models.User;

public class Application {
	public static void main (String[] args) {
		User user = new User ("Michał", "m@m.m", "hasło");

		UserDAO userDAO = new UserDAO ();

		System.out.println ("Przed" + user);
		user = userDAO.create (user);
		System.out.println ("Po" + user);
	}
}
