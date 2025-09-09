package org.samsung;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import com.sun.jdi.request.DuplicateRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class EmailValidationTest {
    @Test
    @Tag("R")
    public void validMailTest1() {
        String email = "";
        boolean expected = false;
        assertThat(expected, equalTo(EmailValidate.isEmailValidate(email)));
    }
    @Test
    @Tag("G")
    public void emptyMailTest2() {
        String email = "duox@gmail.com";
        boolean expected = true;
        assertThat(expected, equalTo(EmailValidate.isEmailValidate(email)));
    }
    @Test
    @Tag("G")
    public void validMailTest3() {
        String email = "duox@gmail.co";
        boolean expected = true;
        assertThat(expected, equalTo(EmailValidate.isEmailValidate(email)));
    }
    @Test
    @Tag("R")
    public void validMailTest4() {
        String email = "duoxgmail.co";
        boolean expected = false;
        assertThat(expected, equalTo(EmailValidate.isEmailValidate(email)));
    }
    @Test
    @Tag("R")
    public void validMailTest5() {
        String email = "duox@gmailco";
        boolean expected = false;
        assertThat(expected, equalTo(EmailValidate.isEmailValidate(email)));
    }
    @Test
    @Tag("R")
    public void validMailTest6() {
        String email = "duoxgmailco";
        boolean expected = false;
        assertThat(expected, equalTo(EmailValidate.isEmailValidate(email)));
    }
    @Test
    @Tag("R")
    public void validMailTest7() {
        String email = "duox@#$%^&&*(gmail.co";
        boolean expected = false;
        assertThat(expected, equalTo(EmailValidate.isEmailValidate(email)));
    }


    @Test
    @Tag("R")
    public void duplicateMailTest1() {
        String email = "duox@gmail.com";
        EmailValidate.addMailToList(email);
        assertThrows(DuplicateRequestException.class, () -> EmailValidate.isEmailDuplicated(email));
    }
    @Test
    @Tag("R")
    public void duplicateMailTest2() {
        String email1 = "duox@gmail.com";
        String email2 = "duox1@gmail.com";
        boolean expected = false;
        EmailValidate.addMailToList(email1);
        assertThat(expected, equalTo(EmailValidate.isEmailDuplicated(email2)));
    }


    @Test
    @Tag("R")
    public void registerTest1() {
        String email = "duoxgmail.com";
        String expected = "Register Failed";
        assertThat(expected, equalTo(EmailValidate.Register(email)));
    }
    @Test
    @Tag("G")
    public void registerTest2() {
        String email = "duox@gmail.com";
        String expected = "Register Success";
        assertThat(expected, equalTo(EmailValidate.Register(email)));
    }

    @Test
    @Tag("R")
    public void registerTest3() {
        String email = "duox@gmail.com";
        EmailValidate.Register(email);
        assertThrows(DuplicateRequestException.class, () -> EmailValidate.Register(email));
    }

    @BeforeEach
    public void setup() {
        EmailValidate.emptyMailList();
    }
}
