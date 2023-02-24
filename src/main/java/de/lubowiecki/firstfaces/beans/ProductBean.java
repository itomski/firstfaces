package de.lubowiecki.firstfaces.beans;


import de.lubowiecki.firstfaces.model.Product;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ManagedBean
@SessionScoped
public class ProductBean implements Serializable {

    private EntityManager entityManager;

    private String msg;

    private Product curProduct = new Product();

    private static Map<String, String> categories;

    static {
        categories = new LinkedHashMap<>();
        categories.put("Kleidung", "C");
        categories.put("Spielzeug", "T");
        categories.put("Lebensmittel", "F");
    }

    public ProductBean() {
        this.entityManager = Persistence.createEntityManagerFactory("ProductsPU").createEntityManager();
    }

    public Map<String, String> getCategories() {
        return categories;
    }

    public List<Product> getProducts() {
        TypedQuery<Product> query = entityManager.createNamedQuery("Product.findAll", Product.class);
        return query.getResultList();
    }

    public void categoryChangeListenerAjax(AjaxBehaviorEvent event) {
        msg = "Wert hast sich geändert...";
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String delete(Product product) {
        entityManager.getTransaction().begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();
        return "products";
    }

    public String edit(Product product) {
        curProduct = product;
        return "product-form";
    }

    public String save() {
        if(curProduct != null) {
            if(curProduct.getId() != null) {
                entityManager.getTransaction().begin();
                entityManager.merge(curProduct);
                entityManager.getTransaction().commit();
            }
            else {
                entityManager.getTransaction().begin();
                entityManager.persist(curProduct);
                entityManager.getTransaction().commit();
                curProduct = new Product();
            }
        }
        return "products";
    }

    public Product getCurProduct() {
        return curProduct;
    }

    public void setCurProduct(Product curProduct) {
        this.curProduct = curProduct;
    }
}
