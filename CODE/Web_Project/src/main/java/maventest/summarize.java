package maventest;

public class summarize {
    /*
    * 通过maven中的xml文件可以快速的引入依赖（dependency），主要通过组织名（groupId）项目名（artifactId）和版本号（version）来引入
    *
    * maven作用:依赖管理,统一项目结构,标准的项目构建流程
    *
    *依赖传递:依赖具有传递性,分为直接依赖和间接依赖
    *   如果想要排除依赖,可以在xml文件中用exclusions标签来排除依赖
    *   同时可以用scope标签来定义依赖作用范围compile(默认) test provided runtime,不同范围在主程序,测试程序,打包中能否运行不同
    *
    * maven生命周期:对所有项目构建过程进行抽象和统一
    *   分为clean,default(compile,test->junit,package->jar,install),site
    * */
}
