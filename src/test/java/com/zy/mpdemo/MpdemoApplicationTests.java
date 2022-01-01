package com.zy.mpdemo;

import com.zy.mpdemo.entity.User;
import com.zy.mpdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MpdemoApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void selectAll() {
        List<User> list = userMapper.selectList(null);
        for (User user:list) {
            System.out.println(user);
        }
    }
    @Test
    void insert(){
        User user = new User();
        user.setAge(18);
        user.setEmail("2131@qq.com");
        user.setName("mike");
        userMapper.insert(user);
    }

    @Test
    public void updateUser() {
        User user = new User();
        // 根据 id 修改，要设置id
        user.setId(1477204721558106113L);
        // 要修改的新值，要修改哪些，就设置哪些，没有设置的数据库中的不会修改。
        user.setAge(30);
        userMapper.updateById(user);
    }

    @Test
    public void leguansuo(){
        User user = userMapper.selectById(1477214594203176962L);
        user.setName("niko");
        userMapper.updateById(user);

    }

}
