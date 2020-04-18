/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Rick
 */
// esto significa que es una clase administrada
// y que sera accesible desde la vista
@ManagedBean
@RequestScoped
public class IndexManagedBean {

    private String user;
    private String pswd;

    /**
     * Creates a new instance of IndexManagedBean
     */
    public IndexManagedBean() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String validar() {
        if (this.user.equals("Rick") && this.pswd.equals("root")) {
            return "ir";
        } else {
            return ""; // null 
        }
    }
}
