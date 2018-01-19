package test;

import onetoone.mapper.ClassesMapper;
import onetoone.model.Classes;
import onetoone.model.HeadTeacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class OnetooneTest {
    public static void main(String[] args) throws Exception {
        String resources = "mybatis.cfg.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        ClassesMapper mapper = session.getMapper(ClassesMapper.class);
        Classes classes = mapper.selectClassById(1);
        HeadTeacher teacher = classes.getTeacher();
        System.out.println(classes.toString());
        System.out.println(teacher.toString());


    }
}
