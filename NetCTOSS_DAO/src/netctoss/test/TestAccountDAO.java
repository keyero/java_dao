package netctoss.test;


import netctoss.dao.AccountDAO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestAccountDAO {

    @Test
    public void TestAccountDao() throws Exception {
        //表示配置文件的名称
        String resource = "configuration.xml";
        //根据配置文件获取sqlsessionfactory对象
        SqlSessionFactory sf = 
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
        
        //sqlsession是用户使用Mybatis的功能
        SqlSession session = sf.openSession();
        
        //session的getMapper方法用于获取DAO的实现对象
        AccountDAO accountdao = session.getMapper(AccountDAO.class);
//        System.out.println(accountdao.findById(70).getRealName());
//        System.out.println(accountdao.findAll().size());
        System.out.println(accountdao.findBy(null, "许珮烜", null, null).size());
        session.commit();           //提交..Mybatis默认不自动提交事务
    }

}
