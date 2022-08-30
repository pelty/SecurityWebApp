
package fr.devprojet.dl.securitywebapp.request;

import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Une extension pour HTTPServletRequest qui remplace getUserPrincipal()
 * et isUserInRole(). Nous fournissons ces implémentations ici, là où elles ne sont pas
 * normalement peuplé sauf si nous passons par l'installation fournie par le
 * récipient.
 * <p>
 * Si l'utilisateur ou les rôles sont nuls sur ce wrapper, la requête parent est consultée
 * pour essayer de récupérer ce que le conteneur a défini pour nous. Ceci est destiné à
 * être créé et utilisé par UserRoleFilter.
 * @author dev-pro
 *
 */
public class UserRoleRequestWrapper extends HttpServletRequestWrapper {

    private String user;
    private List<String> roles = null;
    private HttpServletRequest realRequest;

    
    public UserRoleRequestWrapper(String user, List<String> roles, HttpServletRequest request) {
        super(request);
        this.user = user;
        this.roles = roles;
        this.realRequest = request;
    }

    @Override
    public boolean isUserInRole(String role) {
        if (roles == null) {
            return this.realRequest.isUserInRole(role);
        }
        return roles.contains(role);
    }

    @Override
    public Principal getUserPrincipal() {
        if (this.user == null) {
            return realRequest.getUserPrincipal();
        }

        // Faire une implémentation anonyme pour simplement renvoyer notre utilisateur
        return new Principal() {
            @Override
            public String getName() {
                return user;
            }
        };
    }
}