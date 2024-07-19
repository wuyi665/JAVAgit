package org.example.mybatisdemo.MyBatisTest;

public class Summarize {
    /*
     *MyBatis:一款持久层的框架,用于简化JDBC(原始操作关系型数据库的api)操作
     *       具体步骤:引入依赖,定义一个与查询表字段名相同的实体类,编写SQL语句
     *       数据库连接池:负责分配,管理数据库连接的容器,原始JDBC需要不断创建与销毁连接,开销太大
     *           标准接口:DataSource.SpringBoot默认为Hikari,阿里连接池是Druid(想使用引入依赖即可)
     *
     *   Lombok可以根据注解自动生成构造器(@Data,@Getter,@ToString,@EqualsAndHashCode,@NoArgsConstructor,@AllArgsConstructor)
     *
     * 预编译SQL:sql语句中的值用占位符替代编译后加入到缓存,不需要多次编译基本相同的语句,性能更高
     *          防止sql注入
     *          预编译参数占位符#(会被替换为?并自动设置参数值)$(直接拼接存在sql注入问题)
     *
     * 用mybatis进行表的查询(实体名与字段名不一致不会自动封装,可以取别名或者@Results注解来修改->打开驼峰命名开关),
     *      插入(返回主键给插入对象@Options),删除(返回操作个数),更新
     * 使用xml映射文件,通过接口名,id和返回值类型对数据库进行操作
     *  要求(xml文件与Mapper接口名保持一致且放在相同包下,xml文件中namespace与接口全类名一致,xml文件中sql语句id与Mapper方法名保持一致)
     *
     * 动态SQL:根据外部条件变化而变化的SQL语句<if>条件判断-> <where>去除‘and’,<set>去除‘，’   常用于更新操作
     *      <foreach> 批量操作
     *      <sql><include> 定义表的片段
     * */
}
