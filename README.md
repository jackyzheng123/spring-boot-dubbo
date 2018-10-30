 springboot 整合 dubbo、myBatis、druid，支持监控、分页、事务
=============================================================

 1).dubbo-api 暴露接口 <br>
 2).dubbo-service 实现接口，用于暴露dubbo服务。作为provider <br>
 3).dubbo-web 控制层，调用dubbo服务，提供对外访问 <br>
 注：@Service 和 @Transactional 不可以同时使用，若同时使用，dubbo 服务不能发布。 <br>
 解决方法： 暴露dubbo 服务 改为 xml配置方式，事务 还是使用 @Transactional 注解方式<br>

1.调用查询接口
-------
    http://localhost:8002/findUsers/admin，支持分页，admin可更换。
2.测试事务
-------
    测试事务的时候，可以将 RoleMapper.xml 中的sql故意修改错误，然后调用 
http://localhost:8002/addUserAndRole?username=xbq&rolename=test，执行完之后，调用查询接口，没有插入成功，事务ok
