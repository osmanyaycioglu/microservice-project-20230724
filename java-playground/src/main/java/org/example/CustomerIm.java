package org.example;
public class CustomerIm {
    private final String name;
    private final String surname;
    private final int accessCount;

    private CustomerIm(String name, String surname, int accessCount) {
        this.name = name;
        this.surname = surname;
        this.accessCount = accessCount;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAccessCount() {
        return accessCount;
    }

    public static CustomerImBuilder getBuilder() {
        return new CustomerImBuilder();
    }

    public static class CustomerImBuilder {
        private String name;
        private String surname;
        private int accessCount;

        private CustomerImBuilder() {
        }

        public String getName() {
            return name;
        }

        public CustomerImBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public String getSurname() {
            return surname;
        }

        public CustomerImBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public int getAccessCount() {
            return accessCount;
        }

        public CustomerImBuilder setAccessCount(int accessCount) {
            this.accessCount = accessCount;
            return this;
        }

        public CustomerIm build() {
            return new CustomerIm(name, surname, accessCount);
        }
    }
}
