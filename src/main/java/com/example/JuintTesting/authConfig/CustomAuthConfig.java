package com.example.JuintTesting.authConfig;

import com.example.JuintTesting.client.ClientServiceDetails;
import com.example.JuintTesting.user.UserServiceDetails;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.time.Duration;

@Configuration
@EnableAuthorizationServer
@AllArgsConstructor
public class CustomAuthConfig extends AuthorizationServerConfigurerAdapter {

    private final UserServiceDetails userService;
    private final ClientServiceDetails clientService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final DefaultTokenServices tokenServices;
    private final AuthorizationCodeServices authorizationCodeServices;
    private final AccessTokenConverter accessTokenConverter;
    private final OAuth2RequestFactory oAuth2RequestFactory;
    private final TokenGranter tokenGranter;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.tokenKeyAccess("isAnonymous() || hasAuthority('ROLE_CLIENT')")
                .checkTokenAccess("hasAuthority('ROLE_CLIENT')")
                .passwordEncoder(passwordEncoder);


        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.applyPermitDefaultValues();
        corsConfig.setMaxAge(Duration.ofMinutes(10L));

        source.registerCorsConfiguration("/oauth2/token", corsConfig);
        CorsFilter filter = new CorsFilter(source);

        security.addTokenEndpointAuthenticationFilter(filter);

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientService);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.
                authenticationManager(authenticationManager)
                .userDetailsService(userService)
                .accessTokenConverter(accessTokenConverter)
                .authorizationCodeServices(authorizationCodeServices)
                .tokenServices(tokenServices)
                .requestFactory(oAuth2RequestFactory)
                .tokenGranter(tokenGranter)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST, HttpMethod.OPTIONS);

        endpoints
                .pathMapping("/oauth/check_token", "/oauth2/check_token")
                .pathMapping("/oauth/token_key", "/oauth2/token_key")
                .pathMapping("/oauth/token", "/oauth2/token")
                .pathMapping("/oauth/revoke", "/oauth2/revoke");
    }
}
