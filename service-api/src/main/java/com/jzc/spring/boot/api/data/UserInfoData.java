package com.jzc.spring.boot.api.data;

import com.jzc.spring.boot.api.model.Authority;
import com.jzc.spring.boot.api.model.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class UserInfoData {

    public User findUserByUsername(String username) {
        return list.stream()
                .filter(user -> !StringUtils.isEmpty(username) && username.equals(user.getUsername()))
                .findFirst()
                .get();
    }



    private List<User> list = new ArrayList<User>() {{
        add(new User(1l, "姜志超", "jzc", "123456", "switchrouter@qq.com", new HashSet<Authority>() {{
            add(new Authority(1l, "admin"));
        }} ));
    }};

}
