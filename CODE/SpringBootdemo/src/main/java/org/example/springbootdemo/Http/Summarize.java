package org.example.springbootdemo.Http;

public class Summarize {
    /*
     * http为超文本传输协议
     *
     * 请求协议:1.请求行(请求方式get->请求参数携带在网址之后和post,请求路径,网络协议)
     *        2.请求头(k-v格式)
     *        3.请求体(存放请求参数)
     *   请求参数格式：简单参数，复杂参数（参数中有对象），数组集合参数（相同的请求参数有多个）,日期参数，json参数(必须是post)，路径参数
     *
     *
     * 响应协议:1.响应行(网络协议,状态码,描述)
     *           状态码细则:1开头为响应中; 2开头为成功; 3开头为重定向; 4开头为客户端错误; 5开头为服务端错误
     *        2.响应头(k-v格式)type,length,encoding,control,cookie
     *        3.响应体(存放响应数据)
     *   响应注解：@ResponseBody，返回值是实体对象或者是集合时，会转换为json格式响应,用于统一响应体格式便于管理
     *
     * 前端控制器:DispatcherServlet处理前端发送的请求数据再发送给后端程序
     *
     * 接口测试工具Postman:网页调试与发送网页Http请求的插件
     *
     * web开发分层解耦
     *   三层架构：1.controller：控制层，控制前端发送的请求并对请求进行处理响应
     *           2.service：业务逻辑层，处理具体的业务逻辑
     *           3.dao：数据访问层，负责数据访问操作
     *  三层架构执行流程：前端发送数据到服务端controller，dao层从数据库中获取数据，service层从dao层获取到返回的数据并进行处理
     *                  ，controller层从service层获取到处理之后的数据返回到前端
     *  但是这样就出现了高内聚高耦合的结果，在程序变动的时候需要改动的位置过多
     *
     * 为了实现高内聚低耦合的效果，要进行分层解耦，这时候就需要一个容器
     * 也就是熟知的IOC容器（控制反转）和DI（依赖注入），容器中创建管理的对象叫做Bean
     *
     * 将对象交给IOC容器管理用@Component注解，为对象提供依赖注入用@Autowired注解(太优雅了！)
     *      其中@Autowired注解是按照类型输入Bean,存在多个类型时会出现错误，
     *      此时解决方案是：@Primary（优先） @Qualifier（"name"）->name为Bean的名字  @Resource（"name"）（按照名字来注入）
     * @Autowired是Spring提供的注解，@Resource是JDK提供的注解
     * */
}
