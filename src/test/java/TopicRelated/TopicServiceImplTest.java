package TopicRelated;

import com.cris.domain.Topic;
import com.cris.service.TopicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * 测试发帖删帖的事务能否实现，测试的时候在所测方法里加 int i= 1/0 即可
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TopicServiceImplTest {
    @Autowired
    private TopicService topicService;

    @Test
    public void testDeleteTopic(){
        topicService.deleteTopic(26);
    }

    @Test
    public void testAddTopic(){
        Topic topic = new Topic();
        topic.setTitle("测测事务");
        topic.setContent("...");
        topic.setUserId(18);
        topic.setClick(0);
        topic.setTabId(new Byte("1"));
        topicService.addTopic(topic);
    }

}
