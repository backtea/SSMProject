package com.gxa.p2p.common.mapper;

import com.gxa.p2p.common.domain.Logininfo;
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

}