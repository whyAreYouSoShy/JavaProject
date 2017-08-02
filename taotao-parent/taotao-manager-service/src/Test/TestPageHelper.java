import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by aichexiaowu on 2017/8/2.
 */
public class TestPageHelper {


    @Test
    public void testPageHelper() throws Exception {

        //在执行查询之前配置分页条件,使用pageHelper的静态方法
        PageHelper.startPage(1, 15);
        //执行查询

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring.xml");

        TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);

        TbItemExample itemExample = new TbItemExample();
        List<TbItem> itemList = itemMapper.selectByExample(itemExample);

        //取分页信息 使用pageInfo对象取
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(itemList);

        System.out.println(pageInfo);

    }
}
