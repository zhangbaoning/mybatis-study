package mapper;

import model.User;

import java.util.List;

public interface UserMapper {
    /**
     * 新增用户
     * @param user
     * @return
     * @throws Exception
     */
    public int insertUser(User user)throws Exception;

    /**
     * 修改用户
     * @param user
     * @return
     * @throws Exception
     */
    public int updateUser(User user) throws Exception;

    /**
     * 删除用户
     * @param id
     * @return
     * @throws Exception
     */
    public int deleteUser(Integer id) throws Exception;

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    public User selectUserById(Integer id) throws Exception;

    /**
     * 查询所有的用户信息
     * @return
     * @throws Exception
     */
    public List<User> selectAllUser() throws Exception;
}
