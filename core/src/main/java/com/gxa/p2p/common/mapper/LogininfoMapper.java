package com.gxa.p2p.common.mapper;

import com.gxa.p2p.common.domain.Logininfo;
import com.gxa.p2p.common.query.LoginInfoQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogininfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Logininfo record);

    Logininfo selectByPrimaryKey(Long id);

    List<Logininfo> selectAll();

    int updateByPrimaryKey(Logininfo record);

    int selectCountByUsername(String username);

    Long selectIdByUsername(String username);

    String selectPasswordByUsername(String username);

//    Logininfo login(@Param("username") String username,@Param("password") String password);
    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @param usertype
     * @return
     */
    Logininfo login(@Param("username") String username,
                    @Param("password") String password,
                    @Param("usertype") Byte usertype);

    /**
     * 查询数据的数量
     *
     * @return
     */
    int queryForCount();


    /**
     * 查询当前页数据（分页查询）
     *
     * @return
     */
    List<Logininfo> queryForPage(LoginInfoQueryObject loginInfoQueryObject);
}