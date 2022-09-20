package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Tag("model")
class PersonTest implements ModelTest {

    @Test
    void groupedAssertions() {
        // given
        Person person = new Person(1L, "Joe", "Buck");
        // then
        assertAll("Test props set",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Buck", person.getLastName())
        );
    }


    @Test
    void groupedAssertionMsgs() {
        // given
        Person person = new Person(1L, "Joe", "Buck");
        // then
        assertAll("Test props set",
                () -> assertEquals("Joe", person.getFirstName(), "First Name Failed"),
                () -> assertEquals("Buck", person.getLastName(), "Last Name Failed")
        );
    }

    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("My repeated Test")
    void myRepeatedTest() {
        //todo - impl
    }

    @RepeatedTest(value = 5)
    @DisplayName("My repeated Test")
    void myRepeatedTestWithId(TestInfo info, RepetitionInfo repetitionInfo) {
        System.out.println(info.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(value = 5, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("My repeated Test")
    void myAssignmentRepeat(TestInfo info, RepetitionInfo repetitionInfo) {

    }

}