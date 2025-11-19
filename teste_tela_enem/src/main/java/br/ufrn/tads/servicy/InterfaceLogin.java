package br.ufrn.tads.servicy;

import br.ufrn.tads.model.User;

public interface InterfaceLogin {
    
    boolean loginRequest(String login,String senha);
    
    void registerRequest(User user);

}
