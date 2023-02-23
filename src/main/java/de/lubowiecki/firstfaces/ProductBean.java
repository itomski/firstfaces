package de.lubowiecki.firstfaces;


import de.lubowiecki.firstfaces.model.Product;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.io.Serializable;
import java.util.List;

@ManagedBean
@RequestScoped
public class ProductBean implements Serializable {

    private EntityManager entityManager;

    private Product curProduct = new Product();


    public ProductBean() {
        this.entityManager = Persistence.createEntityManagerFactory("ProductsPU").createEntityManager();
    }

    public List<Product> getProducts() {
        TypedQuery<Product> query = entityManager.createNamedQuery("Product.findAll", Product.class);
        return query.getResultList();
    }

    public String save() {
        if(curProduct != null) {
            if(curProduct.getId() != null) {
                // TODO: Update
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
