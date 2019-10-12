package com.trilogyed.authorizationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class OAuthConfig extends AuthorizationServerConfigurerAdapter {
    private AuthenticationManager authenticationManager;

    @Autowired
    public OAuthConfig(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.inMemory()

                .withClient("html5")
                .authorizedGrantTypes("password")
                .scopes("ROLE_LVL1", "ROLE_LVL2")
                .secret("$2a$10$UON1Q9D3HLjjo9PUMK4.eOP1zq74HdLV97ocJkxrXJEzrIcB6CGJG")
                .and()


                .withClient("android")
                .authorizedGrantTypes("password")
                .scopes("ROLE_LVL1", "ROLE_LVL2", "ROLE_ADMIN")
                .secret("$2a$10$6ML3jZ4n8lJzA55yhyP2fO.MSb15JdOMajF/HeXGuvmi/8BX2ovGe")

                .and()
                .withClient("iPhone")
                .authorizedGrantTypes("password")
                .scopes("ROLE_LVL1", "ROLE_LVL2", "ROLE_ADMIN")
                .secret("$2a$10$xcTlDJUU.QL2YhHlAMkEl.AnyLuRsaGTWIJQCfk6BE/nSpemN4R9u");

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(this.authenticationManager);
    }
}
