package dev.sandeep.ProductServiceApr25.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.sandeep.ProductServiceApr25.dto.CategoryRequestDTO;
import dev.sandeep.ProductServiceApr25.model.Category;
import dev.sandeep.ProductServiceApr25.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CategoryController.class)
public class CategoryControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private CategoryService categoryService; // dependency for CategoryController

    @Test
    void createCategory_Success() throws Exception {
        //intial setup and mock
        CategoryRequestDTO requestDTO = new CategoryRequestDTO("Electronics", "All electronics");
        Category saved = new Category();
        saved.setId(1);
        saved.setName("Electronics");
        saved.setDescription("All electronics");

        Mockito.when(categoryService.createCategory(Mockito.any(CategoryRequestDTO.class))).thenReturn(saved);

        //actual call and verifications
        mockMvc.perform(
                        post("/category")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(requestDTO))
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.categoryName").value("Electronics"))
        .andExpect(jsonPath("$.categoryDescription").value("All electronics"));
    }
}
