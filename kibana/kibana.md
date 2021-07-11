### 菜单介绍

- Discover
  - 查看日志的一个窗口
- vusualize（视图可视化）
- dashboard
- canvas
- maps（真实地图）
- Machine Learning（机器学习）
- Infrastructure（检测物理主机、dockers、k8s性能状况等）
- logs
  - 无穷滚动的轻量级日志流，区别Discover菜单
  - 日志和时间明显关联
- APM（帮助追踪程序的components？）
- Uptime（帮助检测web服务，监测api是否一致在线）
- siem（瞄准企业内部安全分析场景，如主机、防火墙事件）
- graph（发现数据之间的关联）
- devTools
- stack monitoring（对es集群的监控）
- management（一些配置）





### 概念

- Index Patterns
  - Index Patterns概括了一组index
  - 作用：
    - 举个例子：往往我们统计的日志里，假如每天生成一个index，则我们的index上都会有一个时间戳。但是我们查/分析数据的时候希望根据一个业务统一去查（通过一个独立的而非时间的index去查）
