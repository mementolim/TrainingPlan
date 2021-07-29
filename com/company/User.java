package com.company;

public class User {
    private final String firstName;
    private final String lastName;
    private int age;
    private String phone;
    private User(UserBuilder builder) {
        this.age = builder.age;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phone = builder.phone;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }
    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private int age = 0;
        private String phone = "";

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }
        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public User build() {
            if (firstName == null || lastName == null) {
                throw new IllegalArgumentException("required not set");
            }
            return new User(this);
        }
    }
    public static void main(String[] argv) {
        User user = new UserBuilder().lastName("").firstName("Sun").age(18).phone("18918850499").build();
    }
}
