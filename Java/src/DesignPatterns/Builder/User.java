package Java.src.DesignPatterns.Builder;

import jdk.internal.joptsimple.internal.Strings;

public class User {

    private String firstName;
    private String lastName;
    private int age;
    private int mobile;
    private String email;

    public static class UserBuilder{
        //required parameters
        private String firstName;
        private String lastName;

        //optional parameters
        private int age;
        private int mobile;
        private String email;

        public UserBuilder(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder withAge(int age){
            this.age = age;
            return this;
        }

        public UserBuilder withMobile(int mobile){
            this.mobile = mobile;
            return this;
        }

        public UserBuilder withEmail(String email){
            this.email = email;
            return this;
        }

        public User build(){
            if (Strings.isNullOrEmpty(firstName) || Strings.isNullOrEmpty(lastName))
                throw new IllegalArgumentException("First name and last name cannot be empty:: ");

            return new User(this);
        }
    }

    public User(UserBuilder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;

        this.age = builder.age;
        this.mobile = builder.mobile;
        this.email = builder.email;
    }

    User userObj = new User.UserBuilder("Kaushik","Das").withAge(30).withMobile(818272).withEmail("kaushik.das").build();

}
