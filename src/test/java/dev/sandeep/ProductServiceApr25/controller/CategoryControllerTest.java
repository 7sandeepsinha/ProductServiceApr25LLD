package dev.sandeep.ProductServiceApr25.controller;

import dev.sandeep.ProductServiceApr25.dto.CategoryResponseDTO;
import dev.sandeep.ProductServiceApr25.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;


    @Test
    void createCategory_success(){
        //initial setup

        //actual call
        ResponseEntity<CategoryResponseDTO> savedCategoryResp =
                categoryController.createCategory(null);

        //verification
    }
}
