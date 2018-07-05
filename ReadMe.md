#SpringCloud Demo

    ek-server   EK服务器、HyMonitor
    user-facade API服务接口定义
    provider    API服务提供者
    consumer    API服务消费者
    gateway     API网关

#更新日期
1.升级到SpringCloud Finchley[2018-7-5]


##1.ek控制台 
    http://localhost:9091/
##2.测试服务调用
    http://localhost:9092/s_hello?name=222
##3.hystrix minitor
    http://localhost:9091/hystrix
    输入：
    http://localhost:9092/hystrix.stream
    点击监测即可
##4.网关
    http://localhost:9000/s_hello?name=222
##5.权限
    实现了简单的鉴权
    GateWay提供授权服务 curl -d "" http://localhost:9000/auth/login
    然后Post提交中再增加Authorization请求头         
    
    
`没有使用SpringSecurity,太麻烦`