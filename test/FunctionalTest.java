import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

public class FunctionalTest {

	@Test
	public void isobe48() throws Exception {
		running(fakeApplication(), new Runnable() {
			public void run() {
				Result result = callAction(
						controllers.routes.ref.Application.countIsobe()
				);
				assertThat(status(result)).isEqualTo(OK);
				assertThat(contentType(result)).isEqualTo("text/plain");
				assertThat(charset(result)).isEqualTo("utf-8");
				assertThat(contentAsString(result)).contains("9");
			}
		});
	}

}
