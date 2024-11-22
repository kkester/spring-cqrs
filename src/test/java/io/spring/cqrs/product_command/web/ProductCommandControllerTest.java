package io.spring.cqrs.product_command.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.spring.cqrs.common.ProductRecord;
import io.spring.cqrs.product_command.service.CreateProduct;
import io.spring.cqrs.product_command.service.NewProductRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static io.spring.cqrs.product_query.ProductFactory.newProductRecord;
import static io.spring.cqrs.product_query.ProductFactory.productRecord;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ProductCommandControllerTest {

    @Mock
    CreateProduct createProduct;

    @InjectMocks
    ProductCommandController controller;

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void createProduct() throws Exception {
        ProductRecord productRecord = productRecord();
        NewProductRecord newProductRecord = newProductRecord();
        when(createProduct.createProduct(newProductRecord)).thenReturn(productRecord);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newProductRecord)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(productRecord), true));
    }
}