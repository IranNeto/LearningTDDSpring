package com.example.tdddemo.services;

import com.example.tdddemo.BaseTest;
import com.example.tdddemo.entities.User;
import com.example.tdddemo.repository.UsuarioRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTests {

    @MockBean
    UsuarioService usuarioService;

    UsuarioRepository usuarioRepository;

    @Mock
    private List<User> userList = new ArrayList<>();

    @Mock
    private User user = new User();

    @BeforeAll
    void x() {
        when(usuarioRepository.save(any(User.class))).thenReturn(new User());
        usuarioRepository = mock(UsuarioRepository.class);
    }

    @DisplayName("Return findAll is not null")
    @Test
    void getAllIsNotNull(){
        when(usuarioRepository.findAll()).thenReturn(this.userList);
        Assertions.assertThat(usuarioService.findAll()).isNotNull();
    }

    @DisplayName("Return registerUser is not null")
    @Test
    void registerUserIsNotNull(){
        User x = new User();

        Assertions.assertThat(usuarioService.registerUser(any(User.class))).isNotNull();
    }

//    @DisplayName("Return registerUser is a User")
//    @Test
//    void registrarUsuario(){
//        Assertions.assertThat(usuarioService.registerUser(user).getClass()).isEqualTo(user.getClass());
//    }
}
