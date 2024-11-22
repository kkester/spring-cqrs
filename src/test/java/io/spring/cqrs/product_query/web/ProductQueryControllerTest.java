package io.spring.cqrs.product_query.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.spring.cqrs.common.ProductRecord;
import io.spring.cqrs.product_query.RetrieveProducts;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static io.spring.cqrs.product_query.ProductFactory.productRecord;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductQueryController.class)
@ContextConfiguration(classes = ProductQueryController.class)
class ProductQueryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    RetrieveProducts retrieveProducts;

    @Test
    void getProducts() throws Exception {
        List<ProductRecord> productRecords = List.of(productRecord());
        when(retrieveProducts.getProducts()).thenReturn(productRecords);

        mockMvc.perform(get("/api/products")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(productRecords), true));
    }
}