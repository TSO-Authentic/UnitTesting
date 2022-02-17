package com.ai.sm.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.ai.sm.persistant.dto.UserDTO;
import com.ai.sm.service.UserService;

public class UserServiceTest {

	@Mock
	private UserService uService;

	@BeforeEach
	void setup() {
		uService = Mockito.mock(UserService.class);
	}

	@Test
	void saveTest() {
		UserDTO expected = createUser();
		Mockito.when(uService.save(expected)).thenReturn(expected);
		UserDTO actual = uService.save(expected);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void findAllTest() {
		List<UserDTO> expected = new ArrayList<>();
		Mockito.when(uService.findAll()).thenReturn(expected);
		List<UserDTO> actual = uService.findAll();
		Assertions.assertEquals(expected.size(),actual.size());
	}
	
	@Test
	void findByIdOrNameTest() {
		List<UserDTO> expected = uService.findByIdOrName("admin007", "User Test Name");
		Mockito.when(uService.findByIdOrName("admin007", "User Test Name")).thenReturn(expected);
		List<UserDTO> actual = uService.findByIdOrName("admin007", "User Test Name");
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void deleteById() {
		UserDTO expected = new UserDTO();
		expected.setId("admin007");
		uService.deleteById(expected.getId());
		Mockito.verify(uService).deleteById(expected.getId());
	}

	private UserDTO createUser() {
		UserDTO dto = new UserDTO();
		dto.setId("admin007");
		dto.setName("User Test Name");
		dto.setPassword("User Test Password");
		return dto;
	}
}

