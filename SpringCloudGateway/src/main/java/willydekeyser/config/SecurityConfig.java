package willydekeyser.config;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

	@Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http
        		.cors(cors -> cors.configurationSource(corsConfigurationSource()))
        		.csrf(csrf -> csrf.disable())
                .authorizeExchange(exchange -> exchange.anyExchange().permitAll())
                .oauth2Login(withDefaults())
                .build();
    }
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080"));
		configuration.setAllowedMethods(Arrays.asList("*"));
		configuration.setAllowedHeaders(Arrays.asList("*"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
