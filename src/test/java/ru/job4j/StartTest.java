package ru.job4j;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StartTest {
    Start start = new Start();

    @Before
    public void fill() {
        User user1 = new User("user1", new ArrayList<>(List.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru")));
        User user2 = new User("user2", new ArrayList<>(List.of("foo@gmail.com", "ups@pisem.net")));
        User user3 = new User("user3", new ArrayList<>(List.of("xyz@pisem.net", "vasya@pupkin.com")));
        User user4 = new User("user4", new ArrayList<>(List.of("ups@pisem.net", "aaa@bbb.ru")));
        User user5 = new User("user5", new ArrayList<>(List.of("xyz@pisem.net")));
        Collections.addAll(start.listUser, user1, user2, user3, user4, user5);
    }

    @Test
    public void whenAddUsers() {
        start.rsl();
    }
}
