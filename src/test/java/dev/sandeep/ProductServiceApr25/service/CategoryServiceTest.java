package dev.sandeep.ProductServiceApr25.service;

import dev.sandeep.ProductServiceApr25.dto.CategoryRequestDTO;
import dev.sandeep.ProductServiceApr25.exception.CategoryNotFoundException;
import dev.sandeep.ProductServiceApr25.exception.DuplicateCategoryNameException;
import dev.sandeep.ProductServiceApr25.model.Category;
import dev.sandeep.ProductServiceApr25.model.Product;
import dev.sandeep.ProductServiceApr25.repository.CategoryRepository;
import io.micrometer.common.annotation.ValueExpressionResolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private ProductService productService;

    @InjectMocks
    private CategoryService categoryService;

    private Category category;
    private Product product1;
    private Product product2;

    @BeforeEach // setUp method runs before each test
    void setUp() {
        category = new Category();
        category.setId(1);
        category.setName("Electronics");
        category.setDescription("Electronic Items");

        product1 = new Product();
        product1.setId(101);
        product1.setName("Phone");

        product2 = new Product();
        product2.setId(102);
        product2.setName("Laptop");

        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        category.setProducts(products);
    }

    @Test
    void createCategory_Success(){
        //setup
        //input creation
        CategoryRequestDTO categoryRequestDTO = new CategoryRequestDTO("Home Appliances", "All appliances");
        //mocking
        when(categoryRepository.findByName("Home Appliances")).thenReturn(Optional.empty());
        //object required creation
        Category savedCategory = new Category();
        savedCategory.setId(10);
        savedCategory.setName("Home Appliances");
        savedCategory.setDescription("All appliances");
        //mocking
        when(categoryRepository.save(any(Category.class))).thenReturn(savedCategory);

        //call the actual method to test
        Category result = categoryService.createCategory(categoryRequestDTO);

        //verifications and tests
        Assertions.assertNotNull(result);
        Assertions.assertEquals(savedCategory.getId(), result.getId());
        Assertions.assertEquals("Home Appliances", result.getName());
        Assertions.assertEquals("All appliances", result.getDescription());
        verify(categoryRepository).findByName("Home Appliances");
        verify(categoryRepository).save(any(Category.class));
    }

    @Test
    void createCategory_duplicateCategoryException(){
        // setup
        CategoryRequestDTO categoryRequestDTO = new CategoryRequestDTO("Home Appliances", "All appliances");
        //mocking
        Category savedCategory = new Category();
        savedCategory.setId(10);
        savedCategory.setName("Home Appliances");
        savedCategory.setDescription("All appliances");
        when(categoryRepository.findByName("Home Appliances")).thenReturn(Optional.of(savedCategory));

        Assertions.assertThrows(DuplicateCategoryNameException.class, () -> categoryService.createCategory(categoryRequestDTO));
        verify(categoryRepository).findByName("Home Appliances");
        verify(categoryRepository, never()).save(any(Category.class));
    }

    @Test
    void getCategory_success(){
        //setup
        when(categoryRepository.findById(1)).thenReturn(Optional.of(category));
        // call
        Category result = categoryService.getCategory(1);
        //verifications
        Assertions.assertNotNull(result);
        Assertions.assertEquals(category.getId(), result.getId());
        Assertions.assertEquals(category.getName(), result.getName());
        Assertions.assertEquals(category.getDescription(), result.getDescription());
    }

    @Test
    void getCategory_categoryNotFoundException(){
        when(categoryRepository.findById(12345)).thenReturn(Optional.empty());
        Assertions.assertThrows(CategoryNotFoundException.class, () -> categoryService.getCategory(12345));
    }

    @Test
    void getProductsInCategory_success(){
        //setup and mocking
        int mockNoOfProducts = 10;

        //actual call
        int actualNoOfProducts = categoryService.getProductsInCategory(1);

        //verifications
        Assertions.assertEquals(mockNoOfProducts, actualNoOfProducts);

    }

    @Test
    void getProductsInCategory_Success_NoProducts(){

    }

    @Test
    void getProductsInCategory_CategoryNotFoundException(){

    }


}
/*
        Test for a particular class
        1. Create a test class
        2. @ExtendWith
        3. Add dependencies -> autowired in actual class, @Mock in test class
        4. @InjectMocks -> with actual class we want to test
        5. Data creation -> @Before @BeforeEach
        6. Destroy data, resources etc -> @After and @AfterEach
        7. @Test -> test
            a. Three parts -> setup / call / verify
            b. Setup -> method input object creation and mocks
                i. mocks -> for each mock -> input obj creation, output obj creation and mocking line
            c. actual call
            d. verifications -> assertions and verify
        8. Run with coverage to test overall coverage
 */