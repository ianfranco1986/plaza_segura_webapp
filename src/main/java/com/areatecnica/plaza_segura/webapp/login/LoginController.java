package com.areatecnica.plaza_segura.webapp.login;

import com.areatecnica.plaza_segura.webapp.dao.ILoginDao;
import com.areatecnica.plaza_segura.webapp.dao.impl.ILoginDaoImpl;
import com.areatecnica.plaza_segura.webapp.util.CommonPage;
import com.areatecnica.plaza_segura.webapp.util.UserForm;
import com.areatecnica.plaza_segura_webapp.controller.util.JsfUtil;
import com.areatecnica.plaza_segura_webapp.entities.Usuario;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Omer Faruk KURT
 * @e-mail kurtomerfaruk@gmail.com
 * @blog http://kurtomerfaruk.com
 */
@ManagedBean
@SessionScoped
public class LoginController implements java.io.Serializable {
   
    private static final long serialVersionUID = 1553957937211717410L;
    private String username;
    private String password;
    private boolean loggedIn;
    private ILoginDao dao;
    private Usuario usuario;
    private int sessionCount;
    private List<Usuario> usuarioList;
    private String ipAddress;

    /**
     *
     */
    public LoginController() {
    }

    /**
     *
     */
    @PostConstruct
    public void init() {
        dao = new ILoginDaoImpl();
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     *
     * @param Usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     *
     * @return
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     *
     * @param loggedIn
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    /**
     *
     * @return
     */
    public int getSessionCount() {
        return CommonPage.getUserSessionSize();
    }

    public List<Usuario> getStaffList() {
        return CommonPage.getUsuarioList();
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     *
     */
    public void login() {
        try {
            if (!username.equals("") && !username.equals(null) && !password.equals("") && !password.equals(null)) {
                usuario = dao.login(username, password);
            }

            if (usuario != null) {
                UserForm form = new UserForm();
                loggedIn = true;

                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

                ipAddress = request.getHeader("X-FORWARDED-FOR");
                if (ipAddress == null) {
                    ipAddress = request.getRemoteAddr();
                }

                form.setSessionId(request.getSession().getId());
                form.setSessionCreatedTime(new Date(session.getCreationTime()));
                form.setUserIpAdress(ipAddress);
                form.setSession(request.getSession());
                form.setUsuario(usuario);

                CommonPage.addStaff(form, request.getSession().getId());

                session.setAttribute("staff", usuario);
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");

            } else {
                JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle").getString("alertUsername"));
            }

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     */
    public void logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        try {
            JsfUtil.addSuccessMessage("Su sessión ha expirado");

            CommonPage.removeStaff(usuario);
            /*EventBus eventBus = EventBusFactory.getDefault().eventBus();
            eventBus.publish("/counter", String.valueOf(CommonPage.getUsuarioList().size()));*/
            loggedIn = false;
            usuario = null;
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");

        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onIdle() {
        JsfUtil.addErrorMessage("Sin Actividad durante 5 minutos, su sesión expirará");
    }

    public void onActive() {
        JsfUtil.addSuccessMessage("Su sessión se ha reiniciado");
    }

    public void timeout() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("...loginpage.xhtml");

    }

}
