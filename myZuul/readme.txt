1.修改了web.xml
  替换了官方给的监听类StartServer，改成InitializeServletListener
2.增加了mysql数据库的操作
  上传groovy的管理界面使用的mysql数据库
  但是，后台扫描变更的groovy文件还是扫描Cassandra数据库，这块也需要改成mysql，待改
3.改成maven管理
4.改成logback打印日志
5.新增了InfoBoard监控代码