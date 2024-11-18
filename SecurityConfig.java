package com.example.security;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

@CustomFormAuthenticationMechanismDefinition(
    loginToContinue = @LoginToContinue(
        loginPage = "/login.xhtml",
        errorPage = "/error.xhtml"
    )
)
@DatabaseIdentityStoreDefinition(
    dataSourceLookup = "java:app/jdbc/yourDataSource",
    callerQuery = "SELECT password FROM User WHERE username = ?",
    groupsQuery = "SELECT g.name FROM Group g INNER JOIN user_group ug ON g.id = ug.group_id WHERE ug.user_id = ?"
)
@DeclareRoles({"admin", "user"})
@ApplicationScoped
public class SecurityConfig {
}
