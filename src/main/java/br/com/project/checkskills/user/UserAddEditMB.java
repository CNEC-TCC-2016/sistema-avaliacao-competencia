package br.com.project.checkskills.user;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.project.checkskills.entities.autenticacao.UsuarioEntity;
import br.com.project.checkskills.repositories.autenticacao.IUsuarioRepository;


//ConfigurableBeanFactory.SCOPE_SINGLETON, ConfigurableBeanFactory.SCOPE_PROTOTYPE,
//WebApplicationContext.SCOPE_REQUEST, WebApplicationContext.SCOPE_SESSION
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Named(value = "userAddEditMB")
public class UserAddEditMB implements Serializable {

	private static final long serialVersionUID = 201311132355L;

	@Inject
	private IUsuarioRepository userRepository;

	@Inject
	private UserMB mbUserBean;

	@Inject
	private FacesContext context;

	private UsuarioEntity user;

	private String title;

	public UserAddEditMB() {
		this.user = new UsuarioEntity();
	}

	public UsuarioEntity getUser() {
		return this.user;
	}

	public void setUser(UsuarioEntity user) {
		this.user = user;
	}

	public void add() {
		this.title = this.getResourceProperty("labels", "user_add");
	}

	public void update() {
		this.user = this.mbUserBean.getSelectedUser();
		this.title = this.getResourceProperty("labels", "user_update");
	}

	public void cancel() {
		this.mbUserBean.unselectUser();
	}

	public void save() {
		if (this.user != null) {
			if (this.user.getId() == null) {
				// Add
				this.userRepository.save(this.user);
			} else {
				// Update
				this.userRepository.save(this.user);
			}
		}
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String getResourceProperty(String resource, String label) {
		Application application = this.context.getApplication();
		ResourceBundle bundle = application.getResourceBundle(this.context, resource);

		return bundle.getString(label);
	}

}
