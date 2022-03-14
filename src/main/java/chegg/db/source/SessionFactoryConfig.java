package chegg.db.source;

import java.io.IOException;
import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class SessionFactoryConfig {

  private String mybatisConfigPath;

  @Value("${mapper-path}")
  private String mapperPath;

  @Autowired
  @Qualifier("dataSource")
  private DataSource dataSource;

  @Value("${type-aliases-package}")
  private String pojoPkg;

  @Bean(name = "sqlSessionFactory")
  public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigPath));
    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    String pkgSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
    sqlSessionFactoryBean.setMapperLocations(resolver.getResources(pkgSearchPath));
    sqlSessionFactoryBean.setDataSource(dataSource);
    sqlSessionFactoryBean.setTypeAliasesPackage(pojoPkg);
    return sqlSessionFactoryBean;
  }
}
