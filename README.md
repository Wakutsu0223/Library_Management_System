# Java课程设计 图书管理系统

![10](https://s1.328888.xyz/2022/09/25/Vfftk.png)
这次课设用的是标准入门技术「JavaSE+MySql」。大概有29个主类和1个sql文件。
## 数据库设计
在数据库中创建一个名为db_book的数据库，共分为6个表，分别是：t_user、t_booktype、t_book、t_borrow、t_history、t_audit。每张表的功能详情如下：
> t_user：存储管理员和读者的账号信息
> t_booktype：存储书籍的类别信息
> t_book：存储图书信息
> t_borrow：存储读者借阅图书信息
> t_history：存储历史借阅记录
> t_audit：存储待审核新用户

![1](https://s1.328888.xyz/2022/09/25/VfwSd.png)

### 各表结构如下：

![2](https://s1.328888.xyz/2022/09/25/VfakB.png)
![3](https://s1.328888.xyz/2022/09/25/VfkJR.png)
![4](https://s1.328888.xyz/2022/09/25/Vf9B6.png)
![5](https://s1.328888.xyz/2022/09/25/VfcYI.png)
![6](https://s1.328888.xyz/2022/09/25/Vf20j.png)
![7](https://s1.328888.xyz/2022/09/25/VfIor.png)

### 各表间的架构如下图：

![8](https://s1.328888.xyz/2022/09/25/VfMmm.png)
![9](https://s1.328888.xyz/2022/09/25/VfPk7.png)

## 详细介绍：
https://smmradch.github.io/2022/08/16/Java%E8%AF%BE%E8%AE%BE-%E5%9B%BE%E4%B9%A6%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9F/
