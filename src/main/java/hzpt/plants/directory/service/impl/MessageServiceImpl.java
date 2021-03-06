package hzpt.plants.directory.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoTools.core.result.Result;
import hzpt.plants.directory.entity.po.Message;
import hzpt.plants.directory.mapper.MessageMapper;
import hzpt.plants.directory.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p></p>
 * @author tfj
 * @since 2021/6/12
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {
    @Resource
    private MessageMapper messageMapper;
    /**
     * <p>展示所有用户留言</p>
     * @author tfj
     * @since 2021/6/12
     */
    @Override
    public Result getAllMessages(Integer currentPage,String path) {
        QueryWrapper<Message> wrapper= Wrappers.query();
        wrapper.orderByDesc("createTime");
        Page<Message> page=new Page<>(currentPage,21);
        IPage<Message> messages=messageMapper.selectPage(page,wrapper);
        return new Result().result200(messages,path);
    }
    /**
     * <p>删除用户留言</p>
     * @author tfj
     * @since 2021/6/22
     */
    @Override
    public Result deleteUserMessages(String messageId, String path) {
        if (messageMapper.deleteById(messageId)==1){
            return new Result().result200("删除成功",path);
        }
        return new Result().result500("删除失败",path);
    }
}
