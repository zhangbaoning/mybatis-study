package test;

import mapper.UserMapper;
import model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UserTest {
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) {
        String resource = "mybatis.cfg.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //insertUser();
        //deleteUser(1);
        selectUserById(3);

    }
    public static void insertUser(){
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("zhangbaoning");
        user.setPassword("123456");
        user.setSex("男");
        user.setAddress("宝鸡市");
        try {
            mapper.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        session.commit();
        session.close();
    }
    public static void selectUserById(int id){
        User user = null;
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            user = mapper.selectUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        session.commit();
        session.close();
        user.toString();
    }
    public static void updateUser(User user){
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            mapper.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        session.commit();
        session.close();
    }
    public static void deleteUser(int id){
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            mapper.deleteUser(id);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        session.commit();
        session.close();
    }
    public static void getAllUser(){
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            mapper.selectAllUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.commit();
        session.close();
    }
}
