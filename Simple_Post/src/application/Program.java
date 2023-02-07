package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Locale;

import entities.Comment;
import entities.Post;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Comment c1 = new Comment("Have a nice trip!");
		Comment c2 = new Comment("WOW, that's awesome!");
		
		Post p1 = new Post(fmt.parse("21/06/2018 13:05:44"), "Traveling to New Zeland",
				"I'm going to visit this wonderful country!", 12 );
		p1.addComment(c1);
		p1.addComment(c2);
		
		System.out.println(p1.toString());
		System.out.println();
		
		Comment c3 = new Comment("Good night fellow!");
		Comment c4 = new Comment("May the force be with you");
		
		LocalDateTime t2 = LocalDateTime.parse("2024-05-04T12:18:28");

		Post p2 = new Post(fmt.parse("04/05/2024 12:18:28"), "Cinema timeee",
				"Good night guys", 5);
		p2.addComment(c3);
		p2.addComment(c4);
		
		System.out.println(p2.toString());
		
	}

}
