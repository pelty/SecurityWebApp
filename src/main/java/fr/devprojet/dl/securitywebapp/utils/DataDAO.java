/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devprojet.dl.securitywebapp.utils;

import fr.devprojet.dl.securitywebapp.bean.UserAccount;
import fr.devprojet.dl.securitywebapp.config.SecurityConfig;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dev-pro
 */
public class DataDAO {

   private static final Map<String, UserAccount> mapUsers = new HashMap<String, UserAccount>();

   static {
      initUsers();
   }

   private static void initUsers() {

        // Cet utilisateur a un rôle en tant qu'EMPLOYÉ
        UserAccount emp = new UserAccount("employee1", "123", UserAccount.GENDER_MALE, //
            SecurityConfig.ROLE_EMPLOYEE);

        // Cet utilisateur a 2 rôles EMPLOYEE et MANAGER.
        UserAccount mng = new UserAccount("manager1", "123", UserAccount.GENDER_MALE, //
            SecurityConfig.ROLE_EMPLOYEE, SecurityConfig.ROLE_MANAGER);

        mapUsers.put(emp.getUserName(), emp);
        mapUsers.put(mng.getUserName(), mng);
   }

   // Trouver un utilisateur par nom d'utilisateur et mot de passe.
   public static UserAccount findUser(String userName, String password) {
      UserAccount u = mapUsers.get(userName);
      if (u != null && u.getPassword().equals(password)) {
         return u;
      }
      return null;
   }

}