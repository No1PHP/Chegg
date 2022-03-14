package chegg.db.source;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan("chegg.db")
public class DataSourceConfig {

  @Value("${spring.datasource.driver-class-name}")
  private String jdbcDriver;

  @Value("${spring.datasource.url}")
  private String jdbcUrl;

  @Value("${spring.datasource.username}")
  private String jdbcUserName;

  @Value("${spring.datasource.password}")
  private String jdbcPassword;

  @Bean(name = "dataSource")
  public ComboPooledDataSource createDataSource() throws PropertyVetoException {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setDriverClass(jdbcDriver);
    dataSource.setJdbcUrl(jdbcUrl);
    dataSource.setUser(jdbcUserName);
    dataSource.setPassword(jdbcPassword);
    dataSource.setAutoCommitOnClose(false);
    return dataSource;
  }

}
