package com.hospital.hospital.controller;

import com.hospital.hospital.dao.NurseRepository;
import entity.Nurse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(NurseController.class)
class NurseControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private NurseRepository nurseRepository;

	// 1. Test endpoint getAll()
	@Test
	void testGetAllNurses_withData() throws Exception {
		Nurse nurse = new Nurse();
		nurse.setId(1);
		nurse.setName("John Doe");

		when(nurseRepository.findAll()).thenReturn(Collections.singletonList(nurse));

		mockMvc.perform(MockMvcRequestBuilders.get("/nurse")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name").value("John Doe"));
	}

	@Test
	void testGetAllNurses_noData() throws Exception {
		when(nurseRepository.findAll()).thenReturn(Collections.emptyList());

		mockMvc.perform(MockMvcRequestBuilders.get("/nurse")).andExpect(status().isNoContent());
	}

	// 2. Test endpoint findById()
	@Test
	void testFindNurseById_found() throws Exception {
		Nurse nurse = new Nurse();
		nurse.setId(1);
		nurse.setName("John Doe");

		when(nurseRepository.findById(1)).thenReturn(Optional.of(nurse));

		mockMvc.perform(MockMvcRequestBuilders.get("/nurse/id/1")).andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("John Doe"));
	}

	@Test
	void testFindNurseById_notFound() throws Exception {
		when(nurseRepository.findById(anyInt())).thenReturn(Optional.empty());

		mockMvc.perform(MockMvcRequestBuilders.get("/nurse/id/1")).andExpect(status().isNotFound());
	}

	// 3. Test endpoint findByName()
	@Test
	void testFindNurseByName_found() throws Exception {
		Nurse nurse = new Nurse();
		nurse.setName("Jane Doe");

		when(nurseRepository.findByName("Jane Doe")).thenReturn(Optional.of(nurse));

		mockMvc.perform(MockMvcRequestBuilders.get("/nurse/name/Jane Doe")).andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Jane Do"));
	}

	@Test
	void testFindNurseByName_notFound() throws Exception {
		when(nurseRepository.findByName(anyString())).thenReturn(Optional.empty());

		mockMvc.perform(MockMvcRequestBuilders.get("/nurse/name/NonExistent")).andExpect(status().isNotFound());
	}

	// 4. Test endpoint login()
	@Test
	void testLogin_successful() throws Exception {
		Nurse nurse = new Nurse();
		nurse.setName("Jane Doe");
		nurse.setPassword("password");

		when(nurseRepository.findByName("Jane Doe")).thenReturn(Optional.of(nurse));

		mockMvc.perform(MockMvcRequestBuilders.post("/nurse/login").param("name", "Jane Doe")
				.param("password", "password").contentType(MediaType.APPLICATION_FORM_URLENCODED))
				.andExpect(status().isOk()).andExpect(content().string("Login successful"));
	}

	@Test
	void testLogin_invalidPassword() throws Exception {
		Nurse nurse = new Nurse();
		nurse.setName("Jane Doe");
		nurse.setPassword("correctPassword");

		when(nurseRepository.findByName("Jane Doe")).thenReturn(Optional.of(nurse));

		mockMvc.perform(MockMvcRequestBuilders.post("/nurse/login").param("name", "Jane Doe")
				.param("password", "wrongPassword").contentType(MediaType.APPLICATION_FORM_URLENCODED))
				.andExpect(status().isUnauthorized()).andExpect(content().string("Invalid password"));
	}

	@Test
	void testLogin_userNotFound() throws Exception {
		when(nurseRepository.findByName(anyString())).thenReturn(Optional.empty());

		mockMvc.perform(MockMvcRequestBuilders.post("/nurse/login").param("name", "NonExistent")
				.param("password", "password").contentType(MediaType.APPLICATION_FORM_URLENCODED))
				.andExpect(status().isNotFound()).andExpect(content().string("Nurse not found"));
	}

	// 5. Test endpoint signin()
	@Test
	void testRegister_successful() throws Exception {
		when(nurseRepository.existsByName("New Nurse")).thenReturn(false);

		mockMvc.perform(MockMvcRequestBuilders.post("/nurse/signin").param("name", "New Nurse")
				.param("password", "password123").contentType(MediaType.APPLICATION_FORM_URLENCODED))
				.andExpect(status().isOk()).andExpect(content().string("Saved"));
	}

	@Test
	void testRegister_existingNurse() throws Exception {
		when(nurseRepository.existsByName("Existing Nurse")).thenReturn(true);

		mockMvc.perform(MockMvcRequestBuilders.post("/nurse/signin").param("name", "Existing Nurse")
				.param("password", "password123").contentType(MediaType.APPLICATION_FORM_URLENCODED))
				.andExpect(status().isConflict()).andExpect(content().string("Nurse with this name already exists"));
	}

	@Test
	void testRegister_emptyFields() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/nurse/signin").param("name", "").param("password", "")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isBadRequest())
				.andExpect(content().string("Name and password cannot be empty"));
	}

	@Test
	void testRegister_internalServerError() throws Exception {
		when(nurseRepository.existsByName("Error Nurse")).thenReturn(false);
		Mockito.doThrow(new RuntimeException("Database error")).when(nurseRepository).save(Mockito.any(Nurse.class));

		mockMvc.perform(MockMvcRequestBuilders.post("/nurse/signin").param("name", "Error Nurse")
				.param("password", "password123").contentType(MediaType.APPLICATION_FORM_URLENCODED))
				.andExpect(status().isInternalServerError())
				.andExpect(content().string("An error occurred while saving the nurse"));
	}

	// 6. Test endpoint updateNurse()
	@Test
    void testUpdateNurse_emptyName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/nurse/1")
                        .param("name", "")
                        .param("password", "password123")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Name cannot be empty"));
    }

    @Test
    void testUpdateNurse_emptyPassword() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/nurse/1")
                        .param("name", "Updated Nurse")
                        .param("password", "")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Password cannot be empty"));
    }

    @Test
    void testUpdateNurse_notFound() throws Exception {
        when(nurseRepository.findById(anyInt())).thenReturn(Optional.empty());

        mockMvc.perform(MockMvcRequestBuilders.put("/nurse/1")
                        .param("name", "Updated Nurse")
                        .param("password", "password123")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Nurse not found"));
    }

    @Test
    void testUpdateNurse_successful() throws Exception {
        Nurse existingNurse = new Nurse();
        existingNurse.setId(1);
        existingNurse.setName("Original Nurse");
        existingNurse.setPassword("oldPassword");

        when(nurseRepository.findById(1)).thenReturn(Optional.of(existingNurse));

        mockMvc.perform(MockMvcRequestBuilders.put("/nurse/1")
                        .param("name", "Updated Nurse")
                        .param("password", "newPassword123")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andExpect(content().string("Nurse updated successfully"));
    }

	// 7. Test endpoint deleteById()
	@Test
	void testDeleteNurse_successful() throws Exception {
		when(nurseRepository.existsById(1)).thenReturn(true);

		mockMvc.perform(MockMvcRequestBuilders.delete("/nurse/1")).andExpect(status().isOk())
				.andExpect(content().string("Nurse deleted successfully"));
	}

	@Test
	void testDeleteNurse_notFound() throws Exception {
		when(nurseRepository.existsById(anyInt())).thenReturn(false);

		mockMvc.perform(MockMvcRequestBuilders.delete("/nurse/1")).andExpect(status().isNotFound())
				.andExpect(content().string("Nurse not found"));
	}
}
