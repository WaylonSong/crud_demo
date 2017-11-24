# crud_demo
---

## 技术栈
Springboot+SpringDataRest+SpringSecurity+React+Antd

## 目标
* 简化前后端代码重复劳动，提高代码重用与开发效率。
* 对于典型CRUD业务场景，后端只需要确定Entity，前端只需要根据Entity属性确定FormItem种类便可完成页面生成。
* 解耦权限管理与资源权限的访问控制。
* CRUD覆盖了大量的业务场景，处理好前后端模块化易于扩展敏捷构建各类业务场景。

## 功能介绍
* 主要实现了Model对象的增删改列表等功能，通过SpringDataRest提供数据的Rest接口，结合SpringSecurity注解实现资源页面、资源权限管理。
* 可以通过@RepositoryRestController扩充model对象Rest Api。
* 前端根据实体对象生成一致的增删改列表页面，并实现分页，以及各字段的排序、过滤。前端根据model属性可配置多种输入组件：input、number、select、radio、file等。
* 列表和表单可以配置属性值的可见性。

## 后续工作
* 补充代码模板生成，通过反射、注解等自动生成实体页面入口数据。
* 补充缓存使用、事件驱动等事例。

## 使用方法
* 请配置Properties中的Mysql地址，以及上传文件路径。
* 运行SysUserRepositoryTest，生成事例管理员用户和一般用户。
* 本事例提供三个实体，分别配置了权限检查和没有配置权限，以及实体关联关系。


## 展示截图

![image](https://github.com/WaylonSong/crud_demo/blob/master/intro/WechatIMG239.jpeg)
![image](https://github.com/WaylonSong/crud_demo/blob/master/intro/WechatIMG241.jpeg)
![image](https://github.com/WaylonSong/crud_demo/blob/master/intro/WechatIMG240.jpeg)
