package BlockingQueue.builder;

public class User {

    private String firstName;
    private String lastName;

    private int age;
    private int mobile;
    private String address;

    public static class UserBuilderClass {

        //required parameters
        private String firstName;
        private String lastName;

        //optional parameters
        private int age;
        private int mobile;
        private String address;

        public UserBuilderClass(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilderClass withAge(int age){
            this.age = age;
            return this;
        }

        public UserBuilderClass withMobile(int mobile){
            this.mobile = mobile;
            return this;
        }

        public UserBuilderClass withAddress(String address){
            this.address = address;
            return this;
        }

        public User build(){
            if(null == firstName || null == lastName)
                throw new IllegalArgumentException("First and Last Name cannot be empty");
            return new User(this);
        }
    }

    public User(UserBuilderClass userBuilderClass){
        this.firstName  = userBuilderClass.firstName;
        this.lastName = userBuilderClass.lastName;
        this.age = userBuilderClass.age;
        this.mobile = userBuilderClass.mobile;
        this.address = userBuilderClass.address;
    }

    User userObj = new UserBuilderClass("Kaushik", "Das").withAge(12).withMobile(37484).build();

}
