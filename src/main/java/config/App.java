package config;

import javax.mvc.View;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.core.Application;

/**
 * Default JAX-RS application listening on /
 */
@ApplicationPath("/app")
public class App extends Application {
}
