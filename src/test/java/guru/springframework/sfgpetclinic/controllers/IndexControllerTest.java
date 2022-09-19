package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

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

        assertThat(controller.index()).isEqualTo("index");
    }

    @Test
    @DisplayName("Test Exception")
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            controller.oopsHandler();
        });
//        assertTrue("notimplemented".equals(controller.oopsHandler()), () -> "This Window is some expensive" +
//                "Message to build" +
//                "For my test"
//        );
    }

    @Test
    @DisplayName("Timeout test")
    @Disabled("Demo timeout")
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);

            System.out.println("test");
        });
    }

    @Test
    @DisplayName("Timeout test preempt")
    @Disabled("Demo timeout")
    void testTimeOutPreempt() {
        assertTimeoutPreemptively(Duration.ofMillis(120), () -> {
            Thread.sleep(5000);

            System.out.println("test");
        });
    }

    @Test
    @DisplayName("Test assumption")
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    @DisplayName("Test assumption")
    void testAssumptionTrueIsAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }
}