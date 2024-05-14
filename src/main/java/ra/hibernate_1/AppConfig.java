package ra.hibernate_1;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ra")
public class AppConfig {
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/employee_hibernate?createDatabaseIfNotExist=true");
        source.setUsername("root");
        source.setPassword("Extratuz123");
        return source;
    }

    //Cấu hình SessionFactory
    @Bean
    public SessionFactory sessionFactory(){
        LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
        //thiết lập các thông số kết nối với csdl
        sf.setDataSource(getDataSource());
        //Quét qua các package tìm các class ORM (class máp với bảng trong database
        sf.setPackagesToScan("ra.hibernate_1.entity");
        //Các thông số cấu hình của hibernate
        Properties props = new Properties();
        props.put("hibernate.show_sql",true); // Khi gọi đếm hàm của hibernate thì sẽ sinh ra câu lệnh sql ở màn hình console
        props.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect"); // Nói cho hibernate biết sẽ làm việc với hệ quản trị csdl nào (mysql, postgree, sqlserver, oracle)
        sf.setHibernateProperties(props);
        try {
            sf.afterPropertiesSet();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sf.getObject();
    }
}
