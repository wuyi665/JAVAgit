public class Summarize {
    /*
     * 常用增删(批量删除)查（条件查询）改三层架构
     *
     * 文件上传操作：文件上传到服务器供其他用户浏览或下载
     *      后端文件上传操作：服务端定义一个controller其中PostMapping（"/upload"）来接收文件，其中的文件变量为MultipartFile
     *      服务端接收后会生成临时文件，需要将临时文件保存为本地文件或者云文件,这样保存时为了不产生同名覆盖，使用uuid识别码
     *
     *      本地存储：此时保存的文件会出现单个请求大小限制问题，需要相应配置来解决
     *      云存储：阿里云OSS
     *          思路：1.注册登录，创建存储容器以及身份凭证等准备工作
     *               2.下载SDK编写试验程序
     *               3.集成使用，指定OSS服务地址并连接到自己的存储空间通过IO流读写文件（需要有一个OSS开发工具类并交给IOC容器管理）
     *
     * 配置文件优化：工具类中定义变量过多，不方便维护和管理
     *          解决方法：springboot的@value("${配置文件中的key}")注解进行属性注入
     *                  或者yml配置文件（properties是key=value格式，yml文件是按照层级key：value格式）
     *              @value注解可能重复次数过多
     *              此时只要保证Bean中变量名和配置名相等，加上@ConfigurationProperties（prefix=""）同时引入依赖即可自动注入，之后用get方法获取即可
     *
     * 登录功能认证校验:定义Login架构,因为登录员工身份信息,所以直接用员工的service和dao层
     *              这时校验功能要用到登录标记并进行统一拦截->过滤器Filter||拦截器Interceptor
     *          会话跟踪技术:客户端Cookie:保存在本地,自动跟服务端交互发送请求头,并自动接收响应头数据,在一个浏览器中的请求会自动携带cookie的值
     *                                  但是移动端不能使用,cookie不能跨域,用户可以自己禁用cookie,
     *                     服务端Session:底层是cookie,在cookie中保存sessionid,拿到之后根据sessionid找到相应数据,数据保存在服务端
     *                                  但在服务器集群的时候由于经过负载均衡服务器,会定位到不同的服务端返回不同的session,
     *                     令牌技术:请求时服务端返回一个字符串令牌存储在客户端,每次请求的时候携带令牌
     *          JWT(JsonWebToken)令牌:包括Header,Payload,Signature
     *              使用步骤:1.引入依赖 2.使用工具类进行令牌生成和校验
     *
     *          过滤器Filter(服务器中集成的):1.定义Filter接口实例对象并重写方法
     *                      2.加上@WebFliter注解配置拦截路径,引导类加上@ServletCompomentScan开启组件支持
     *                        过滤器链会根据类名逐个放行
     *          拦截器Interceptor(Spring集成的,只会拦截进入spring环境的资源):1.定义拦截器
     *                          2.注册拦截器
     *
     * 异常处理:全局异常处理器
     *
     * 事务管理:@Transactional注解实现事务管理,方法执行前开启事务,之后提交或回滚事务,一般在增删改方法上加上注解(事务管理日志配置)
     *          事务属性:回滚操作->默认情况下只有运行时异常才会回滚,想要所有异常回滚要用到rollbackfor属性
     *                 传播行为->一个事务方法被另一个事务方法调用,默认情况required下只有一个事务,可用propagation属性控制(requires_new)
     *
     * AOP:面向切面(特定方法)编程->底层通过动态代理技术对特定方法编程
     *          导入依赖之后编写aop程序
     *      核心概念:连接点JoinPoint, 通知Advice(共性方法), 切入点PointCut(匹配连接点的条件), 切面Aspect(Advice+PointCut), 目标对象Target
     *          通知类型:@Around(Target方法执行前后都被执行) @Before @After @AfterReturning @AfterThrowing
     *          通知顺序:多个切面类执行顺序@Order()注解来排序
     *      PointCut表达式:决定加入Advice的Target
     *                  execution(返回值 包名.类名.?方法名(方法参数) throws ?异常), *为单个独立的任意符号, ..为多个任意符号
     *                  @annotation(自定义注解全类名),根据自定义注解位置定义切入点
     *                      自定义注解:@Retention(生效时间) @Target(生效对象)
     * */
}
