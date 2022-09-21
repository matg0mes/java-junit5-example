package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelTest {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1L, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("12345678");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "First Name Did Not Match"),
                        () -> assertEquals("Buck", owner.getLastName(), "Last Name Did Not Match")
                ),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Key West", owner.getCity(), "City Dis Not Match"),
                        () -> assertEquals("12345678", owner.getTelephone(), "Telephone Did Not Match")
                )
        );
    }

    @DisplayName("Value Source Test - ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Framework"})
    void testValueSource(String val) {
        System.out.println(val);
    }

    @DisplayName("Enum Source Test - ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }

    @DisplayName("CSV Input Test - ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "FL, 1, 1",
            "OH, 1, 1",
            "MI, 1, 1",
    })
    void csvInputTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }

    @DisplayName("CSV From File Test - ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFileTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }

    @DisplayName("Method Provider Test - ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getArgs")
    void fromMethodTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }

    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of("FL", 1, 1),
                Arguments.of("OH", 1, 1),
                Arguments.of("MI", 1, 1)
        );
    }
}