package controllers;

import java.util.*;
import java.util.regex.*;

import play.*;
import play.mvc.*;
import views.html.*;

import twitter4j.*;

import org.fusesource.scalate.japi.TemplateEngineFacade;


public class Application extends Controller {

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	public static Result countIsobe() {
		TwitterFactory twitterFactory = new TwitterFactory();
		Twitter twitter = twitterFactory.getInstance();
		try {
			Query query = new Query("#磯辺焼");
			QueryResult result = twitter.search(query);
			Pattern p = Pattern.compile(".*(\\d+) .*");
			List<twitter4j.Status> tweets = new ArrayList<twitter4j.Status>();
			for (twitter4j.Status status : result.getTweets()) {
				Matcher m = p.matcher(status.getText());
				if (m.matches()) {
					tweets.add(status);
				}
			}
			return ok(views.html.count.render(tweets));
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		return TODO;
	}
}
