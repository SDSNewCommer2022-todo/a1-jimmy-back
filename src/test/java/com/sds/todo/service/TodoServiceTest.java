package com.sds.todo.service;

import com.sds.todo.domain.entity.TaskEntity;
import com.sds.todo.domain.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock
    TaskRepository mockTaskRepository;

    @InjectMocks
    TodoService subject;

    private TaskEntity mockTaskEntity = new TaskEntity("kim", "123123");

    @BeforeEach
    public void setUp() throws Exception{

    }
    @Test
    public void 태스크_추가() throws Exception{
        // when
        subject.addTask("kim", "123123");
        // then
        verify(mockTaskRepository, times(1)).save(any(TaskEntity.class));
    }

    @Test
    public void 태스트_상태_업데이트() throws  Exception {
        // given
        when(mockTaskRepository.findById(1L)).thenReturn(Optional.of(mockTaskEntity));

        // when
        subject.updateTaskStatus(1L, "DELETED");

        // then
        verify(mockTaskRepository, times(1)).save(any(TaskEntity.class));
    }


    @Test
    public void 태스트리스트_상태삭제_업데이트() throws  Exception {
        // given
        when(mockTaskRepository.findTaskEntitiesByOwner("kim")).thenReturn(Arrays.asList(mockTaskEntity));

        // when
        subject.updateAllTaskStatus("kim", "DELETED");

        // then
        verify(mockTaskRepository, times(1)).saveAll(any(List.class));
    }

    @Test
    public void 태스트리스트_상태완료_업데이트() throws  Exception {
        //given
        when(mockTaskRepository.findTaskEntitiesByOwner("kim")).thenReturn(Arrays.asList(mockTaskEntity));

        // when
        subject.updateAllTaskStatus("kim", "COMPLETED");

        // then
        verify(mockTaskRepository, times(1)).saveAll(any(List.class));
    }

    @Test
    public void 테스크_내용_변경_업데이트() throws Exception {
        // given
        when(mockTaskRepository.findById(1L)).thenReturn(Optional.of(mockTaskEntity));

        // when
        subject.updateTaskContent(1, "456456");

        // then
        verify(mockTaskRepository, times(1)).save(any(TaskEntity.class));
    }

    @Test
    public void 태스크가_존재하는_유저의_태스크를_조회하면_해당태스크가포함된리스트를_반환한다() throws Exception{
        // when
        when(mockTaskRepository.findTaskEntitiesByOwner("kim")).thenReturn(Arrays.asList(mockTaskEntity));
        List<TaskEntity> result = subject.findAllTasksByName("kim");

        // then
        assertEquals( false, result.isEmpty());
    }

    @Test
    public void 태스크가_존재하는_유저의_태스크를_조회하면_해당태스크가포함된리스트를_반환한다2() throws Exception {
        // when
        when(mockTaskRepository.findTaskEntitiesByOwner("kim")).thenReturn(Arrays.asList(mockTaskEntity));
        List<TaskEntity> result = subject.findAllTasksByName("kim");

        // then
        assertEquals( "kim", result.get(0).getOwner());
        assertEquals( "123123", result.get(0).getContent());
        assertEquals( "REGISTERED", result.get(0).getStatus());
    }


}