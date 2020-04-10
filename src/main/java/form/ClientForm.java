package form;

import javax.mvc.binding.MvcBinding;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;
import java.io.Serializable;
/**
 *
 * @author cleme
 */
public class ClientForm implements Serializable{
    
        @MvcBinding @FormParam("societe")
	@Size(max = 40)
        @NotEmpty
	private String societe;

	public String getSociete() {
		return societe;
	}

	public void setSociete(final String societe) {
		this.societe = societe;
	}
    
        @MvcBinding @FormParam("contact")
	@Size(max = 30)
        @NotEmpty
	private String contact;

	public String getContact() {
		return contact;
	}

	public void setContact(final String contact) {
		this.contact = contact;
	}

	@MvcBinding @FormParam("fonction")
	@Size(max = 30)
	private String fonction;

	public String getFonction() {
		return fonction;
	}

	public void setFonction(final String fonction) {
		this.fonction = fonction;
	}
    
        @MvcBinding @FormParam("adresse")
	@Size(max = 60)
	private String adresse;

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(final String adresse) {
		this.adresse = adresse;
        }
                
	@MvcBinding @FormParam("ville")
	@Size(max = 15)
	private String ville;

	public String getVille() {
		return ville;
	}

	public void setVille(final String ville) {
		this.ville = ville;
	}
        
        @MvcBinding @FormParam("region")
	@Size(max = 15)
	private String region;

	public String getRegion() {
		return region;
	}

	public void setRegion(final String region) {
		this.region = region;
	}
        
        @MvcBinding @FormParam("code_postal")
	@Size(max = 10)
	private String code_postal;

	public String getCodePostal() {
		return code_postal;
	}

	public void setCodePostal(final String code_postal) {
		this.code_postal = code_postal;
	}
        
        @MvcBinding @FormParam("pays")
	@Size(max = 15)
	private String pays;

	public String getPays() {
		return pays;
	}

	public void setPays(final String pays) {
		this.pays = pays;
	}
        
        @MvcBinding @FormParam("telephone")
	@Size(max = 24)
	private String telephone;

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(final String telephone) {
		this.telephone = telephone;
	}
        
        @MvcBinding @FormParam("fax")
	@Size(max = 24)
	private String fax;

	public String getFax() {
		return fax;
	}

	public void setFax(final String fax) {
		this.fax = fax;
	}
        
}
