# Spring 和 Log4j 演示环境

# 构建
mvn clean package

# 测试

id 参数将会被打印到 Console  
```
curl http://127.0.0.1:8190/log?id=test
```


User-Agent 将会5秒过后被打印到 Console  
```
curl http://127.0.0.1:8190/
```


Referer 将会5秒过后被打印到 Console  
```
curl  -H 'Referer: http://www.baidu.com' http://127.0.0.1:8190/article
```
