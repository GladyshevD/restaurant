package ru.vote.api;

import ru.vote.api.model.Role;
import ru.vote.api.model.User;

import static ru.vote.api.model.AbstractBaseEntity.START_SEQ;

public class TestData {
    private static final int ADMIN_ID = START_SEQ;
    public static final int USER_ID= START_SEQ + 1;

    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@mail.ru", "admin", Role.ROLE_ADMIN);
    public static final User USER = new User(USER_ID, "User", "user@mail.ru", "password", Role.ROLE_USER);
}
