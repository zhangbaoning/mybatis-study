package onetomany.test;

import onetomany.mapper.MClassesMapper;
import onetomany.model.MClasses;
import onetomany.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception{
        String resource = "mybatis.cfg.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sessionFactory.openSession();
        MClassesMapper mapper = session.getMapper(MClassesMapper.class);
        MClasses MClasses = mapper.selectClassAndStudentById(1);
        List<Student> students = MClasses.getStudents();
        System.out.println(MClasses.toString());
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()){
            Student student = iterator.next();
            System.out.println(student.toString());
        }
    }
}
