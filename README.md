# Java课程设计 图书管理系统

![img/10.png](https://github.com/ToyamaFuyutsuki/Library_Management_System/blob/master/img/10.png)

这次课设用的是标准入门技术「JavaSE+MySql」。大概有29个主类和1个sql文件。
## 数据库设计
在数据库中创建一个名为db_book的数据库，共分为6个表，分别是：t_user、t_booktype、t_book、t_borrow、t_history、t_audit。每张表的功能详情如下：
> t_user：存储管理员和读者的账号信息

> t_booktype：存储书籍的类别信息

> t_book：存储图书信息

> t_borrow：存储读者借阅图书信息

> t_history：存储历史借阅记录

> t_audit：存储待审核新用户

![1](https://github.com/ToyamaFuyutsuki/Library_Management_System/blob/master/img/1.png)

### 各表结构如下：

![2](https://github.com/ToyamaFuyutsuki/Library_Management_System/blob/master/img/2.png)
![3](https://github.com/ToyamaFuyutsuki/Library_Management_System/blob/master/img/3.png)
![4](https://github.com/ToyamaFuyutsuki/Library_Management_System/blob/master/img/4.png)
![5](https://github.com/ToyamaFuyutsuki/Library_Management_System/blob/master/img/5.png)
![6](https://github.com/ToyamaFuyutsuki/Library_Management_System/blob/master/img/6.png)
![7](https://github.com/ToyamaFuyutsuki/Library_Management_System/blob/master/img/7.png)

### 各表间的架构如下图：

![8](https://github.com/ToyamaFuyutsuki/Library_Management_System/blob/master/img/8.png)
![9](https://github.com/ToyamaFuyutsuki/Library_Management_System/blob/master/img/9.png)

