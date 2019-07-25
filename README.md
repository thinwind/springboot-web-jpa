# springboot-web-jpa
基于Spring Data JPA的web项目demo

## 集成功能

- [x] Spring Boot Web
- [x] Spring Data JPA
- [x] Spring Boot Test
- [x] Log4j2 (using disruptor)
- [x] H2database
- [x] Lombok
- [x] Database Rider(DbUnit+Junit)


## 特色
1. test 包下完成了基于Hibernate的JPA手动DDL控制语句，继承`BaseJpaTest`类，可以实现在每个方法调用前，自动生成数据库表，调用完成之后清理所有表，实现每个单测方法执行之前，是完全相同的干净数据库环境，不会彼此产生影响，任何的单测方法都相互独立，测试场景完全可重现。
2. 结合Database Rider([文档](https://database-rider.github.io/database-rider/latest/documentation.html?theme=foundation))的数据准备功能，可以方便的实现数据库相关接口的独立快速测试