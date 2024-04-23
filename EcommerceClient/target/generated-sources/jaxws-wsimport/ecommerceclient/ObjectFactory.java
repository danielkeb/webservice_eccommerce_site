
package ecommerceclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecommerceclient package. 
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

    private final static QName _DeleteCategory_QNAME = new QName("http://soapapi/", "deleteCategory");
    private final static QName _SearchCategory_QNAME = new QName("http://soapapi/", "searchCategory");
    private final static QName _DeleteCategoryResponse_QNAME = new QName("http://soapapi/", "deleteCategoryResponse");
    private final static QName _GetAllCategories_QNAME = new QName("http://soapapi/", "getAllCategories");
    private final static QName _AddCategory_QNAME = new QName("http://soapapi/", "addCategory");
    private final static QName _AddCategoryResponse_QNAME = new QName("http://soapapi/", "addCategoryResponse");
    private final static QName _SearchCategoryResponse_QNAME = new QName("http://soapapi/", "searchCategoryResponse");
    private final static QName _UpdateCategoryResponse_QNAME = new QName("http://soapapi/", "updateCategoryResponse");
    private final static QName _UpdateCategory_QNAME = new QName("http://soapapi/", "updateCategory");
    private final static QName _GetAllCategoriesResponse_QNAME = new QName("http://soapapi/", "getAllCategoriesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecommerceclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllCategoriesResponse }
     * 
     */
    public GetAllCategoriesResponse createGetAllCategoriesResponse() {
        return new GetAllCategoriesResponse();
    }

    /**
     * Create an instance of {@link UpdateCategory }
     * 
     */
    public UpdateCategory createUpdateCategory() {
        return new UpdateCategory();
    }

    /**
     * Create an instance of {@link AddCategoryResponse }
     * 
     */
    public AddCategoryResponse createAddCategoryResponse() {
        return new AddCategoryResponse();
    }

    /**
     * Create an instance of {@link UpdateCategoryResponse }
     * 
     */
    public UpdateCategoryResponse createUpdateCategoryResponse() {
        return new UpdateCategoryResponse();
    }

    /**
     * Create an instance of {@link SearchCategoryResponse }
     * 
     */
    public SearchCategoryResponse createSearchCategoryResponse() {
        return new SearchCategoryResponse();
    }

    /**
     * Create an instance of {@link DeleteCategoryResponse }
     * 
     */
    public DeleteCategoryResponse createDeleteCategoryResponse() {
        return new DeleteCategoryResponse();
    }

    /**
     * Create an instance of {@link GetAllCategories }
     * 
     */
    public GetAllCategories createGetAllCategories() {
        return new GetAllCategories();
    }

    /**
     * Create an instance of {@link DeleteCategory }
     * 
     */
    public DeleteCategory createDeleteCategory() {
        return new DeleteCategory();
    }

    /**
     * Create an instance of {@link SearchCategory }
     * 
     */
    public SearchCategory createSearchCategory() {
        return new SearchCategory();
    }

    /**
     * Create an instance of {@link AddCategory }
     * 
     */
    public AddCategory createAddCategory() {
        return new AddCategory();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapapi/", name = "deleteCategory")
    public JAXBElement<DeleteCategory> createDeleteCategory(DeleteCategory value) {
        return new JAXBElement<DeleteCategory>(_DeleteCategory_QNAME, DeleteCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapapi/", name = "searchCategory")
    public JAXBElement<SearchCategory> createSearchCategory(SearchCategory value) {
        return new JAXBElement<SearchCategory>(_SearchCategory_QNAME, SearchCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapapi/", name = "deleteCategoryResponse")
    public JAXBElement<DeleteCategoryResponse> createDeleteCategoryResponse(DeleteCategoryResponse value) {
        return new JAXBElement<DeleteCategoryResponse>(_DeleteCategoryResponse_QNAME, DeleteCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCategories }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapapi/", name = "getAllCategories")
    public JAXBElement<GetAllCategories> createGetAllCategories(GetAllCategories value) {
        return new JAXBElement<GetAllCategories>(_GetAllCategories_QNAME, GetAllCategories.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapapi/", name = "addCategory")
    public JAXBElement<AddCategory> createAddCategory(AddCategory value) {
        return new JAXBElement<AddCategory>(_AddCategory_QNAME, AddCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapapi/", name = "addCategoryResponse")
    public JAXBElement<AddCategoryResponse> createAddCategoryResponse(AddCategoryResponse value) {
        return new JAXBElement<AddCategoryResponse>(_AddCategoryResponse_QNAME, AddCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapapi/", name = "searchCategoryResponse")
    public JAXBElement<SearchCategoryResponse> createSearchCategoryResponse(SearchCategoryResponse value) {
        return new JAXBElement<SearchCategoryResponse>(_SearchCategoryResponse_QNAME, SearchCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapapi/", name = "updateCategoryResponse")
    public JAXBElement<UpdateCategoryResponse> createUpdateCategoryResponse(UpdateCategoryResponse value) {
        return new JAXBElement<UpdateCategoryResponse>(_UpdateCategoryResponse_QNAME, UpdateCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapapi/", name = "updateCategory")
    public JAXBElement<UpdateCategory> createUpdateCategory(UpdateCategory value) {
        return new JAXBElement<UpdateCategory>(_UpdateCategory_QNAME, UpdateCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCategoriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapapi/", name = "getAllCategoriesResponse")
    public JAXBElement<GetAllCategoriesResponse> createGetAllCategoriesResponse(GetAllCategoriesResponse value) {
        return new JAXBElement<GetAllCategoriesResponse>(_GetAllCategoriesResponse_QNAME, GetAllCategoriesResponse.class, null, value);
    }

}
