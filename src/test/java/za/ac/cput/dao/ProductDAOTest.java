/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.dao;

import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.Products.Products;

/**
 *
 * @author Juan
 */
public class ProductDAOTest {
    
    private ProductDAO dao;
    
    public ProductDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws SQLException {
        this.dao = new ProductDAO();
    }
    
    @AfterEach
    public void tearDown() throws SQLException {
        this.dao.closeResources();
    }

    /**
     * Test of save method, of class ProductDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Products product = new Products("Milk", 31.99, 100, "542135245763");
        Products expResult = product;
        Products result = this.dao.save(product);
        assertEquals(expResult, result);
    }

}
