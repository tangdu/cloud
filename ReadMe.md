#SpringCloud Demo

    ek-server   EK服务器、HyMonitor
    user-facade API服务接口
    provider    API服务提供者
    consumer    API服务消费者

>持续更新中


##1.ek控制台 
    http://localhost:9091/
##2.测试服务调用
    http://localhost:9092/s_hello?name=222
##3.hystrix minitor
    http://localhost:9091/hystrix
    输入：
    http://localhost:9092/hystrix.stream
    点击监测即可