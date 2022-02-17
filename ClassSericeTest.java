package com.ai.sm.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.ai.sm.persistant.dto.ClassDTO;
import com.ai.sm.service.ClassService;

public class ClassServiceTest {

	
	@Mock
	private ClassService cService;
	
	@BeforeEach
	void setup() {
		cService = Mockito.mock(ClassService.class);
	}
	
	
	@Test
	void saveTest() {
		ClassDTO expected = createClass();
		Mockito.when(cService.save(expected)).thenReturn(expected);
		ClassDTO actual = cService.save(expected);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void findAllTest() {
		List<ClassDTO> expected = new ArrayList<>();
		Mockito.when(cService.findAll()).thenReturn(expected);
		List<ClassDTO> actual = cService.findAll();
		Assertions.assertEquals(expected.size(), actual.size());
	}
	
	@Test
	void findByClassIdOrClassNameTest() {
		List<ClassDTO> expected = cService.findByClassIdOrClassName("c007", "Class Test Name");
		Mockito.when(cService.findByClassIdOrClassName("c007", "Class Test Name")).thenReturn(expected);
		List<ClassDTO> actual = cService.findByClassIdOrClassName("c007", "Class Test Name");
		Assertions.assertEquals(expected , actual);
	}
	
	
	private ClassDTO createClass() {
		ClassDTO dto = new ClassDTO();
		dto.setClassId("c007");
		dto.setClassName("Class Test Name");
		return dto;
	}
}

