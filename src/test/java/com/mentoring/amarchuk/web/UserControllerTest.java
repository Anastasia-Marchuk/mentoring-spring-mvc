package com.mentoring.amarchuk.web;

import com.mentoring.amarchuk.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:config.xml"})
@WebAppConfiguration
class UserControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Autowired
    UserController userController;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    void startPage() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"));
    }

    @Test
    void allUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/allUsers"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("list_users"));
    }

    @Test
    void createUser() throws Exception {
        User user = new User("testName", "test@test.com");
        mvc.perform(MockMvcRequestBuilders.get("/create")
                .param("name", user.getName())
                .param("email", user.getEmail()))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));

    }

    @Test
    void newUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("new_user"));
    }

//    @Test
//    void updateUser() throws Exception {
//
//        User user = new User(1,"testName", "test@test.com");
//        mvc.perform(MockMvcRequestBuilders.get("/user/update")
//                .param("name", user.getName())
//                .param("email", user.getEmail()))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(view().name("facade"));
//    }
//    @PostMapping("/update")
//    public String updateTransportInDb(@ModelAttribute("transport") @Valid Transport transport, BindingResult bindingResult,
//                                      Model model, RedirectAttributes redirectAttributes) {
//        LOGGER.debug("Update transport with parameters =>{}", transport);
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("title", "Edit");
//            model.addAttribute("method", "update");
//            model.addAttribute("hidden", true);
//            return "transport_edit";
//        }
//        transportService.update(transport);
//        LOGGER.info("View start URL method POST => ( 'transport/update/' )");
//        if (transport.getNumberRoute() != null) {
//            redirectAttributes.addAttribute("numberRoute", transport.getNumberRoute());
//            return "redirect:route/{numberRoute}";
//        }
//        return "redirect:/transport";
//    }


    @Test
    void deleteTransport_whenIdIsCorrect() throws Exception {
        mvc.perform(get("/delete/{id}", 1)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("facade"));
    }

    @Test
    void getCorrectUser() throws Exception {
        mvc.perform(get("/user/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(view().name("facade"));
    }


    @Test
    void getIncorrectUser2() throws Exception {
        mvc.perform(get("/user/{id}", " "))
                .andExpect(status().isBadRequest());

    }

    @Test
    void getUserByName() throws Exception {
        mvc.perform(get("/user/name")
                .param("name", "Stacy"))
                .andExpect(status().isOk())
                .andExpect(view().name("facade"));
    }

    @Test
    void getUserByEmail() throws Exception {
        mvc.perform(get("/user/email")
                .param("email", "stacy2@gmail.com"))
                .andExpect(status().isOk())
                .andExpect(view().name("facade"));
    }
}