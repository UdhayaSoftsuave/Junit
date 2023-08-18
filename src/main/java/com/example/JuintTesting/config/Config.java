package com.example.JuintTesting.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.CompositeTokenGranter;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.password.ResourceOwnerPasswordTokenGranter;
import org.springframework.security.oauth2.provider.refresh.RefreshTokenGranter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;

import java.util.List;

@Configuration
@AllArgsConstructor
public class Config {

    private final AuthenticationManager authenticationManager;
    private final ClientDetailsService clientDetailsService;
    private final UserDetailsService userDetailsService;
    private final OAuth2RequestFactory oAuth2RequestFactory;
    private final TokenEnhancer tokenEnhancer;
    private final JwtTokenStore tokenStore;

    @Bean
    public TokenGranter tokenGranter() {
        return new CompositeTokenGranter(getTokenGranderList());
    }

    private List<TokenGranter> getTokenGranderList(){
        return List.of(new ResourceOwnerPasswordTokenGranter(authenticationManager,tokenServices() , clientDetailsService, oAuth2RequestFactory));
    }



    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        var tokenServices = new DefaultTokenServices();
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setTokenStore(tokenStore);
        tokenServices.setTokenEnhancer(tokenEnhancer);
        tokenServices.setAuthenticationManager(preAuthProvider());
        tokenServices.setClientDetailsService(clientDetailsService);
        return tokenServices;
    }

    private ProviderManager preAuthProvider() {
        PreAuthenticatedAuthenticationProvider provider = new PreAuthenticatedAuthenticationProvider();
        provider.setPreAuthenticatedUserDetailsService(new UserDetailsByNameServiceWrapper<>(userDetailsService));
        return new ProviderManager(provider);
    }


}
