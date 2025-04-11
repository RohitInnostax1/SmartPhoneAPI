package com.springrest.springrest.services;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springrest.springrest.entities.SmartPhone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



import com.springrest.springrest.controller.SmartPhoneController;

@ExtendWith(MockitoExtension.class)
 class SmartPhoneControllerTest {

    private MockMvc mockMvc;

    @Mock
    private SmartPhoneService smartPhoneService;

    @InjectMocks
    private SmartPhoneController smartPhoneController;

    private SmartPhone phone1;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(smartPhoneController).build();
        
        phone1 = new SmartPhone(1L, "iPhone 14", 1000L, 800L);
    
    }

   

    @Test
    void testGetSmartPhoneById() throws Exception {
        when(smartPhoneService.getSmartPhoneById(1L)).thenReturn(phone1);

        mockMvc.perform(get("/smartPhones/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("iPhone 14"));

        verify(smartPhoneService, times(1)).getSmartPhoneById(1L);
    }

    @Test
    void testAddSmartPhone() throws Exception {
        when(smartPhoneService.saveSmartPhone(any(SmartPhone.class))).thenReturn(phone1);

        mockMvc.perform(post("/smartPhones")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(phone1)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("iPhone 14"));

        verify(smartPhoneService, times(1)).saveSmartPhone(any(SmartPhone.class));
    }

   

    @Test
    void testDeleteSmartPhone() throws Exception {
        doNothing().when(smartPhoneService).deleteSmartPhone(1L);

        mockMvc.perform(delete("/smartPhones/1"))
                .andExpect(status().isOk());

        verify(smartPhoneService, times(1)).deleteSmartPhone(1L);
    }
}
