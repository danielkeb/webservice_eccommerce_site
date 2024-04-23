
package com.mycompany.ecommerceclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.ecommerceclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeleteAccount_QNAME = new QName("http://soapapi/", "deleteAccount");
    private final static QName _Login_QNAME = new QName("http://soapapi/", "login");
    private final static QName _RegisterUserResponse_QNAME = new QName("http://soapapi/", "registerUserResponse");
    private final static QName _RegisterUser_QNAME = new QName("http://soapapi/", "registerUser");
    private final static QName _UpdateProfile_QNAME = new QName("http://soapapi/", "updateProfile");
    private final static QName _UpdateProfileResponse_QNAME = new QName("http://soapapi/", "updateProfileResponse");
    private final static QName _DeleteAccountResponse_QNAME = new QName("http://soapapi/", "deleteAccountResponse");
    private final static QName _LoginResponse_QNAME = new QName("http://soapapi/", "loginResponse");
    private final static QName _LogoutResponse_QNAME = new QName("http://soapapi/", "logoutResponse");
    private final static QName _Logout_QNAME = new QName("http://soapapi/", "logout");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.ecommerceclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteAccountResponse }
     * 
     */
    public DeleteAccountResponse createDeleteAccountResponse() {
        return new DeleteAccountResponse();
    }

    /**
     * Create an instance of {@link Logout }
     * 
     */
    public Logout createLogout() {
        return new Logout();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link LogoutResponse }
     * 
     */
    public LogoutResponse createLogoutResponse() {
        return new LogoutResponse();
    }

    /**
     * Create an instance of {@link UpdateProfile }
     * 
     */
    public UpdateProfile createUpdateProfile() {
        return new UpdateProfile();
    }

    /**
     * Create an instance of {@link UpdateProfileResponse }
     * 
     */
    public UpdateProfileResponse createUpdateProfileResponse() {
        return new UpdateProfileResponse();
    }

    /**
     * Create an instance of {@link RegisterUser }
     * 
     */
    public RegisterUser createRegisterUser() {
        return new RegisterUser();
    }

    /**
     * Create an instance of {@link DeleteAccount }
     * 
     */
    public DeleteAccount createDeleteAccount() {
        return new DeleteAccount();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link RegisterUserResponse }
     * 
     */
    public RegisterUserResponse createRegisterUserResponse() {
        return new RegisterUserResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapapi/", name = "deleteAccount")
    public JAXBElement<DeleteAccount> createDeleteAccount(DeleteAccount value) {
        return new JAXBElement<DeleteAccount>(_DeleteAccount_QNAME, DeleteAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapapi/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapapi/", name = "registerUserResponse")
    public JAXBElement<RegisterUserResponse> createRegisterUserResponse(RegisterUserResponse value) {
        return new JAXBElement<RegisterUserResponse>(_RegisterUserResponse_QNAME, RegisterUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapapi/", name = "registerUser")
    public JAXBElement<RegisterUser> createRegisterUser(RegisterUser value) {
        return new JAXBElement<RegisterUser>(_RegisterUser_QNAME, RegisterUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapapi/", name = "updateProfile")
    public JAXBElement<UpdateProfile> createUpdateProfile(UpdateProfile value) {
        return new JAXBElement<UpdateProfile>(_UpdateProfile_QNAME, UpdateProfile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateProfileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapapi/", name = "updateProfileResponse")
    public JAXBElement<UpdateProfileResponse> createUpdateProfileResponse(UpdateProfileResponse value) {
        return new JAXBElement<UpdateProfileResponse>(_UpdateProfileResponse_QNAME, UpdateProfileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapapi/", name = "deleteAccountResponse")
    public JAXBElement<DeleteAccountResponse> createDeleteAccountResponse(DeleteAccountResponse value) {
        return new JAXBElement<DeleteAccountResponse>(_DeleteAccountResponse_QNAME, DeleteAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapapi/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapapi/", name = "logoutResponse")
    public JAXBElement<LogoutResponse> createLogoutResponse(LogoutResponse value) {
        return new JAXBElement<LogoutResponse>(_LogoutResponse_QNAME, LogoutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Logout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapapi/", name = "logout")
    public JAXBElement<Logout> createLogout(Logout value) {
        return new JAXBElement<Logout>(_Logout_QNAME, Logout.class, null, value);
    }

}
