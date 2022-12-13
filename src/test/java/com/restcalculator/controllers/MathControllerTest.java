package com.restcalculator.controllers;

import com.restcalculator.services.MathOperatorImpl;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MathControllerTest extends TestCase {
    @MockBean
    private MathOperatorImpl calculatorMock;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void calculate() throws Exception {

        when(calculatorMock.doMath(2,3,"*")).thenReturn(6.0);


        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/doMath")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().json("{\"calcResponse\":6}"))
                .andReturn();

    }



}