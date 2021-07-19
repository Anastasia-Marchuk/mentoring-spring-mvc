//package com.mentoring.amarchuk.web;
//
//import com.mentoring.amarchuk.facade.BookingFacade;
//import com.mentoring.amarchuk.facade.BookingFacadeImpl;
//import com.mentoring.amarchuk.model.User;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//
//@WebMvcTest(controllers = UserController.class)
//class UserControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    BookingFacade bookingFacade;
//
//    @Test
//    void startPage() throws Exception {
//        mvc.perform(get("/"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(view().name("welcome"));
//    }
//
////    @Test
////    void createUser() throws Exception {
////        User user = new User("TestMVC", "TestMvc@test.com");
////        mvc.perform(get("/create")
////                .param("name", user.getName())
////                .param("email", user.getEmail()))
////                .andDo(print())
////                .andExpect(status().is3xxRedirection())
////                .andExpect(view().name("redirect:/"));
////    }
//}
//
////    @Autowired
////    private MockMvc mvc;
////
////    @MockBean
////    BookingFacadeImpl bookingFacade;
////
////    @Test
////    void startPage() throws Exception {
////        mvc.perform(get("/"))
////                .andDo(print())
////                .andExpect(status().isOk())
////                .andExpect(view().name("welcome"));
////    }
////
////    @Test
////    void allUsers() throws Exception {
////        mvc.perform(MockMvcRequestBuilders.get("allUsers"))
////                .andDo(print())
////                .andExpect(status().isOk())
////                .andExpect(view().name("list_users"));
////    }
////
////    @Test
////    void createUser() throws Exception {
////        User user = new User("testName", "test@test.com");
////
////        mvc.perform(get("create")
////                .param("name", user.getName())
////                .param("email", user.getEmail()))
////                .andDo(print())
////                .andExpect(status().is3xxRedirection())
////                .andExpect(view().name("redirect:/"));
////
////    }
////
////    @Test
////    void newUser() throws Exception {
////        mvc.perform(get("new"))
////                .andExpect(status().isOk())
////                .andExpect(view().name("new_user"));
////    }
////
//////    @Test
//////    void updateUser() throws Exception {
//////
//////        User user = new User(1,"testName", "test@test.com");
//////        mvc.perform(MockMvcRequestBuilders.get("/user/update")
//////                .param("name", user.getName())
//////                .param("email", user.getEmail()))
//////                .andDo(print())
//////                .andExpect(status().isOk())
//////                .andExpect(view().name("facade"));
//////    }
//////    @PostMapping("/update")
//////    public String updateTransportInDb(@ModelAttribute("transport") @Valid Transport transport, BindingResult bindingResult,
//////                                      Model model, RedirectAttributes redirectAttributes) {
//////        LOGGER.debug("Update transport with parameters =>{}", transport);
//////        if (bindingResult.hasErrors()) {
//////            model.addAttribute("title", "Edit");
//////            model.addAttribute("method", "update");
//////            model.addAttribute("hidden", true);
//////            return "transport_edit";
//////        }
//////        transportService.update(transport);
//////        LOGGER.info("View start URL method POST => ( 'transport/update/' )");
//////        if (transport.getNumberRoute() != null) {
//////            redirectAttributes.addAttribute("numberRoute", transport.getNumberRoute());
//////            return "redirect:route/{numberRoute}";
//////        }
//////        return "redirect:/transport";
//////    }
////
////
////    @Test
////    void deleteTransport_whenIdIsCorrect() throws Exception {
////
////        mvc.perform(get("/delete/{id}", 1)
////        ).andDo(print())
////                .andExpect(status().isOk())
////                .andExpect(view().name("facade"));
////    }
////
////    @Test
////    void getCorrectUser() throws Exception {
////        mvc.perform(get("/user/{id}", 1))
////                .andExpect(status().isOk())
////                .andExpect(view().name("facade"));
////    }
////
////
////    @Test
////    void getIncorrectUser2() throws Exception {
////        mvc.perform(get("/user/{id}", " "))
////                .andExpect(status().isBadRequest());
////
////    }
////
////    @Test
////    void getUserByName() throws Exception {
////        mvc.perform(get("/user/name")
////                .param("name", "Stacy"))
////                .andExpect(status().isOk())
////                .andExpect(view().name("facade"));
////    }
////
////    @Test
////    void getUserByEmail() throws Exception {
////        mvc.perform(get("/user/email")
////                .param("email", "stacy2@gmail.com"))
////                .andExpect(status().isOk())
////                .andExpect(view().name("facade"));
////    }
////}