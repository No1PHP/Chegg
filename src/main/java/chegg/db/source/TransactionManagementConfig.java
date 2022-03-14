package chegg.db.source;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


@Configuration
@EnableTransactionManagement
public class TransactionManagementConfig  implements TransactionManagementConfigurer {
  @Autowired
  private DataSource dataSource;
  @Override
  public TransactionManager annotationDrivenTransactionManager() {
    return new DataSourceTransactionManager(dataSource);
  }
}
