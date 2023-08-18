package com.example.JuintTesting.client;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class ClientServiceDetails implements ClientDetailsService {

    private final PasswordEncoder encoder;
    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {

        BaseClientDetails baseClientDetails = new BaseClientDetails();
        baseClientDetails.setClientId("Test-app");
        baseClientDetails.setClientSecret(encoder.encode("secret"));
        baseClientDetails.setAccessTokenValiditySeconds(10 * 60);
        baseClientDetails.setRefreshTokenValiditySeconds(15 * 60);
        baseClientDetails.setResourceIds(List.of("test"));
        baseClientDetails.setScope(List.of("read", "read:appointments", "write", "remove", "profile", "openid", "email"));
        baseClientDetails.setAuthorizedGrantTypes( List.of("authorization_code", "implicit", "password","client_credentials","refresh_token"));

        baseClientDetails.setRegisteredRedirectUri(Set.of("http://localhost:9090/login/oauth2/code/",
                "http://localhost:3000/"));

        return baseClientDetails;
    }
}
