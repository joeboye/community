package com.njust.community.service;

import com.njust.community.dao.DiscussPostMapper;
import com.njust.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhangpeng
 * @Date 2023/5/16 15:39
 * @PackageName:com.njust.community.service
 * @ClassName: DiscussPostService
 * @Description: TODO
 * @Version 1.0
 */
@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return discussPostMapper.selectDiscussPosts(userId, offset, limit);
    }

    public int findDiscussPostRows(int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }

}
