package com.ai.sm.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.ai.sm.persistant.dto.StudentDTO;
import com.ai.sm.service.StudentService;

public class StudentServiceTest {

	
	@Mock
	private StudentService sService;

	@BeforeEach
	void setUp() {
		sService = Mockito.mock(StudentService.class);
	}

	@Test
	void saveTest() {
		StudentDTO expected = createStudent();
		Mockito.when(sService.save(expected)).thenReturn(expected);
		StudentDTO actual = sService.save(expected);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void findAllTest() {
		List<StudentDTO> expected = new ArrayList<StudentDTO>();
		Mockito.when(sService.findAll()).thenReturn(expected);
		List<StudentDTO> actual = sService.findAll();
		Assertions.assertEquals(expected.size(), actual.size());
	}
	
	@Test
	void findByStudentIdOrStudentNameOrClassNameTest() {
		List<StudentDTO> expected = sService.findByStudentIdOrStudentNameOrClassName("S007", "Student Test Name", "Class Test Name");
		Mockito.when(sService.findByStudentIdOrStudentNameOrClassName("S007", "Student Test Name", "Class Test Name")).thenReturn(expected);
		List<StudentDTO> actual = sService.findByStudentIdOrStudentNameOrClassName("S007", "Student Test Name", "Class Test Name");
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void deleteByIdTest() {
		StudentDTO expected = new StudentDTO();
		expected.setStudentId("S007");
		sService.deleteById(expected.getStudentId());
		Mockito.verify(sService).deleteById(expected.getStudentId());
	}
	
	private StudentDTO createStudent() {
		StudentDTO dto = new StudentDTO();
		dto.setStudentId("S007");
		dto.setStudentName("Student Test Name");
		dto.setClassName("Class Test Name");
		dto.setRegisterDate("2022-2-22");
		dto.setStatus("Passed");
		return dto;
	}
}


