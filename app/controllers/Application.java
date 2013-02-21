package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import twitter4j.*;

public class Application extends Controller {

	public static Result index() {
		TwitterFactory twitterFactory = new TwitterFactory();
		Twitter twitter = twitterFactory.getInstance();
		try {
			twitter.updateStatus("test");
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		return ok(index.render("Your new application is ready."));
	}

}
