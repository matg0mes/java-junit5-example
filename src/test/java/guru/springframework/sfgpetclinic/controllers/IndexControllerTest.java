package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    @DisplayName("Test Proper View Name is Returned for index page")
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong View Returned");

        assertEquals("index", controller.index(), () -> "Another expensive message" +
                "make me only if you have to ");
    }

    @Test
    @DisplayName("Test Exception")
    void oupsHandler() {
//        assertTrue("notimplemented".equals(controller.oopsHandler()), () -> "This Window is some expensive" +
//                "Message to build" +
//                "For my test"
//        );
    }
}