package com.examplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserCustom {
    private User user;
    private List<User> list;
    private Map<String, Object> map;;
    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
