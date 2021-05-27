package ru.job4j;

import java.util.List;
import java.util.Objects;

public class User {
    private final String name;
    private List<String> emails;

    public User(String name, List<String> emails) {
        this.name = name;
        this.emails = emails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(emails, user.emails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, emails);
    }

    public List<String> getEmails() {
        return emails;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", emails=" + emails +
                '}';
    }
}
