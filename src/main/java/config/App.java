package config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Default JAX-RS application listening on /app
 */
@ApplicationPath("/app")
public class App extends Application {
}
