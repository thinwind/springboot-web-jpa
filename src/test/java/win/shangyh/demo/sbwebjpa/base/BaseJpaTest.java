package win.shangyh.demo.sbwebjpa.base;

import java.util.EnumSet;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

import com.github.database.rider.core.DBUnitRule;

import org.hibernate.boot.Metadata;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.DependsOn;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * BaseJpaTest
 * 
 * 参考资料 
 * https://www.soinside.com/question/PENNqEtkYccg3nqUPTaazP
 * https://stackoverflow.com/questions/51501405/how-to-get-the-all-table-metadata-in-spring-boot-jpa-hibernate
 * https://stackoverflow.com/questions/44737662/how-do-you-programmatically-generate-a-hibernate-jpa-schema
 * https://database-rider.github.io/database-rider/latest/documentation.html?theme=foundation
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DependsOn("myHibernateConfig")
public class BaseJpaTest {

    @Autowired
    protected DataSource datasource;

    @Autowired
    protected EntityManager entityManager;

    @Autowired
    MetadataExtractorIntegrator integrator;

    @Rule
    public DBUnitRule dbUnitRule;

    SchemaExport schemaExport;

    Metadata metadata;

    // 初始化设置
    @PostConstruct
    public void init() throws SQLException{
        dbUnitRule = DBUnitRule.instance(datasource.getConnection());
        metadata = integrator.getMetadata();
        schemaExport= new SchemaExport();
        schemaExport.setHaltOnError(true);
        //格式化ddl语句，方便日志打印
        schemaExport.setFormat(true);
        schemaExport.setDelimiter(";");
    }

    //每个测试方法执行前都会调用此方法
    @Before
    public void setup(){
        schemaExport.create(EnumSet.of(TargetType.DATABASE), metadata);
        afterSetup();
    }

    /**
     * 子类可以覆盖此方法，实现一些初始化操作
     */
    protected void afterSetup(){

    }

    //每个方法执行后都会调用此方法
    @After
    public void tearDown(){
        try{
            beforeTearDown();
        }finally{
            schemaExport.drop(EnumSet.of(TargetType.DATABASE), metadata);
        }
    }

    //子类可以覆盖此方法，执行销毁数据前的一些操作
    protected void beforeTearDown(){

    }
}