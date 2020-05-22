package com.interview.java.designpatterns.ratelimiter.model;

public class UserApiModel {

    private String username;
    private String api;

    public UserApiModel(String username, String api){
        this.username = username;
        this.api = api;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((api == null) ? 0 : api.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserApiModel other = (UserApiModel) obj;
        if (username.equals(other.username)  && api.equals(other.api) )
            return false;
        return true;
    }


}
