/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.securitywebapp.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author dev-pro
 */
public class SecurityConfig {

    public static final String ROLE_MANAGER = "MANAGER";
    public static final String ROLE_EMPLOYEE = "EMPLOYEE";

    // String: Role
    // List<String>: urlPatterns.
    private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

    static {
        init();
    }

    private static void init() {

        // Configurez pour le rôle "EMPLOYEE".
        List<String> urlPatterns1 = new ArrayList<String>();

        urlPatterns1.add("/userInfo");
        urlPatterns1.add("/employeeTask");

        mapConfig.put(ROLE_EMPLOYEE, urlPatterns1);

        // Configurez pour le rôle "MANAGER".
        List<String> urlPatterns2 = new ArrayList<String>();

        urlPatterns2.add("/userInfo");
        urlPatterns2.add("/managerTask");

        mapConfig.put(ROLE_MANAGER, urlPatterns2);
    }

    public static Set<String> getAllAppRoles() {
            return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
            return mapConfig.get(role);
    }

}