package com.rodion.educative.spring_5_and_spring_boot_2.spring_unit_testing;

import com.rodion.educative.spring_5_and_spring_boot_2.spring_unit_testing.basics.StudentDao;
import com.rodion.educative.spring_5_and_spring_boot_2.spring_unit_testing.basics.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // This annotation is required to use @Mock and @InjectMocks annotations
class StudentServiceMockTest {

    @Mock
    StudentDao studentDaoMock;

    @InjectMocks
    StudentService studentService;

    @Test
    void testFindTotal() {
//        StudentDao studentDaoMock = mock(StudentDao.class);
//        when(studentDaoMock.getMarks()).thenReturn(new int[]{15, 20, 5});
//
//        StudentService studentService = new StudentService(studentDaoMock);
//        int total = studentService.findTotal();
//        assertEquals(40, total);

        when(studentDaoMock.getMarks()).thenReturn(new int[]{15, 20, 5});
        assertEquals(40, studentService.findTotal());
    }

    @Test
    void testFindTotal_EmptyArray() {
//        StudentDao studentDaoMock = mock(StudentDao.class);
//        when(studentDaoMock.getMarks()).thenReturn(new int[]{});
//
//        StudentService studentService = new StudentService(studentDaoMock);
//        int total = studentService.findTotal();
//        assertEquals(0, total);

        when(studentDaoMock.getMarks()).thenReturn(new int[]{});
        assertEquals(0, studentService.findTotal());
    }
}