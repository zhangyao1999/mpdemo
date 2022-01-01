package com.zy.mpdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    /**
     * 分页查询
     */
    @Test
    public void pagination() {
        // 1.创建 Page 对象
        Page<User> page = new Page<>();

        // 2.设置 查询的起始页，每页的数据量。
        page.setCurrent(1);
        page.setSize(3);

        // 3. 调用 MyBatis-Plus 分页查询的方法
        userMapper.selectPage(page, null);

        // 4. 从返回的 IPage 对象中获取分页数据
        System.out.println("当前是第 " + page.getCurrent() + " 页");
        System.out.println("总共有 " + page.getPages() + " 页");
        System.out.println("当前页有 " + page.getSize() + " 条数据");
        System.out.println("总共有 " + page.getTotal() + " 条数据");
        System.out.println("是否还有下一页 " + page.hasNext());
        System.out.println("是否还有上一页 " + page.hasPrevious());
        List<User> users = page.getRecords();
        users.forEach(System.out :: println);
    }

    /**
     * 逻辑删除
     */
    @Test
    public void logicDeleteById() {
        userMapper.deleteById(2L);
    }

    @Test
    public void complexQuery(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.ge("age", 21);
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

}
