package com.example.ey;

public class UserDBschema {
    public static final class UserTable {
        public static final String NAME = "users";

        public static final class Cols {
            public static final String UID = "uid";
            public static final String LOGIN = "login";
            public static final String PASSWORD = "password";
        }
    }
    public static final class BookTable {
        public static final String NAME = "books";
        public static final class Cols {
            public static final String BID = "bid";
            public static final String BOOKNAME = "bookname";
            public static final String AUTORNAME = "autorname";
            public static final String NPAGES = "npages";
            public static final String ABOUTBOOK = "aboutbook";
        }
    }
}
