package onetomany.mapper;

import onetomany.model.MClasses;

public interface MClassesMapper {
    MClasses selectClassAndStudentById(Integer id) throws Exception;
}
