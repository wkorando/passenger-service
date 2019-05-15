package com.ibm.developer.passengerservice;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;

@SpringJUnitWebConfig
@WebMvcTest(controllers = PassengerController.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@AutoConfigureMockMvc
public class TestPassengerController {
	@MockBean
	PassengerRepo repo;
	
	@MockBean
	PassengerService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void callFindAllEndpoint() throws Exception {
		// Setup
		when(repo.findAll()).thenReturn(Arrays.asList(new Passenger(1, "Thor","Odinson", 4.95)));

		// When
		mockMvc.perform(get("/api/v1/passengers"))

				// Then
				.andDo(document("find-all-passengers",
						responseFields(fieldWithPath("[].id").description("The passenger's id"),
								fieldWithPath("[].firstName").description("The passenger's first name"),
								fieldWithPath("[].lastName").description("The passenger's last name"),
								fieldWithPath("[].rating").description("The passenger's rating")))); //

	}
}
