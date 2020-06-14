# Spring

## Spring核心简介

###  IOC

1. ioc又被称为控制反转，其实现是通过依赖注入的方式让Spring容器来帮助我们管理bean对象。

2. 可以通过自动装配来自动赋值（有两种方式，一种是byName,一种是byType），注意**autowire只能为非字面量的属性进行赋值**。

   byName:通过属性名和spring容器中的bean的id进行比较，若一致则赋值。

   byType:通过spring容器中的bean的类型，为兼容性的属性进行赋值。要求spring管理的容器范围内只能存在一个被属性赋值的bean。

   当设置了autowire属性后，会作用于该bean中的所有属性，所以不建议这么做。

    ```xml
    <bean id="emp" class="com.jkl.test.auto.Emp" autowire="byType">
        <property name="id" value="1"/>
        <property name="name" value="小明"/>

    </bean>

    <bean id="car" class="com.jkl.test.auto.Car">
        <property name="cid" value="111"/>
        <property name="cname" value="奥迪"/>
    </bean>

    <bean id="dept" class="com.jkl.test.auto.Dept">
        <property name="did" value="222222"/>
        <property name="dname" value="技术"/>
    </bean>
    ```

3. 注解

   - @Component：标识一个受spring ioc容器管理的组件
   - @Repository:标识一个受spring ioc容器管理的持久化层组件
   - @Service：标识一个受spring ioc容器管理的业务逻辑层组件
   - @Controller：标识一个受Spring ioc容器管理的表述层控制器组件

   在对应的类上加上对应的注解，但是此时spring还不能识别到你的注解，需要在xml文件中手动进行包扫描，在包目录下的类的注解才会被识别。

   ```xml
   <context:component-scan base-package="com.jkl.test.userMod"/>
   ```

   还可以指定完扫描的包目录后，再在里面指定指定具体的注解，或者指定具体的类

   type="annotation" 用来指定注解。

   type="assignable" 用来指定具体的类。

   注意在使用include的时候需要把```use-default-filters```设置为false，默认为true，会忽略下面的**inclue-filter**，

   但是在使用exclude的时候需要把```use-default-filters```设置为true，先把所有包扫进来，再排除。

   ```xml
   <context:component-scan base-package="com.jkl.test.userMod" use-default-filters="false">
       <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
   </context:component-scan>
   ```

   @Autowired自动装配：有了这个注解，可以不必在xml文件中手动去指定bean属性。

   当一个属性上被加上了这个注解，但是该属性对应的类并没有被spring管理的话，这时候会找不到bean，spring会报错，此时可以修改```@Autowired(required = false)```，不过这样的话虽然可以避免spring的报错，但由于属性对应的类没有被spring管理，所以这个实例对象依旧是个null，调用它的方法会报空指针异常。

   ```java
   @Service
   public class UserServiceImpl implements UserService {
       @Autowired(required = false)
       public UserDao userDao;
       public UserServiceImpl(){
           System.out.println("UserServiceImpl");
       }
   
       @Override
       public void addUser() {
           userDao.addUser();
       }
   }
   ```

   @Component、@Repository、@Service、@Controller可以通过value值来指定spring容器中生成的id的名字。如下面的代码，这个时候spring中生成bean的id则为aaa而不是userDaoImpl。

   ```java
   @Repository("aaa")
   public class UserDaoImpl implements UserDao {
       public  UserDaoImpl(){
           System.out.println("UserDaoImpl");
       }
   
       @Override
       public void addUser() {
           System.out.println("添加用户");
       }
   }
   ```

   如果有两个持久层类实现了同一个接口，这个两个实现类都被打上了@Repository注解，那么在自动装备的时候，需要再加一个@Qualifier来指定需要装备的具体的类；

   ```java
   @Repository
   public class UserMyBatisImpl implements UserDao{
   
       @Override
       public void addUser() {
           System.out.println("UserMyBatisImpl:添加用户成功");
       }
   }
   ```

   ```java
   @Repository
   public class UserDaoImpl implements UserDao {
       public  UserDaoImpl(){
           System.out.println("UserDaoImpl");
       }
   
       @Override
       public void addUser() {
           System.out.println("添加用户");
       }
   }
   ```

   ```java
   public class UserServiceImpl implements UserService {
   
       @Autowired
       @Qualifier(value = "userMyBatisImpl")
       public UserDao userDao;
   
       public UserServiceImpl(){
           System.out.println("UserServiceImpl");
       }
   
       @Override
       public void addUser() {
           userDao.addUser();
       }
   }
   ```



### AOP

@Before,将方法标注为前置通知，作用于方法执行之前。

```java
@Before(value = "execution(* com.jkl.test.aop.*.*(..))")
public void beforeMethod(JoinPoint jp){
    Object[] args = jp.getArgs();
    String name = jp.getSignature().getName();
    System.out.println(MessageFormat.format("method is {0},arguments:{1}",name, Arrays.toString(args)));
}
```

@After，将方法标注为后置通知，作用于finally方法。

```java
@After(value = "execution(* com.jkl.test.aop.*.*(..))")
public void afterMethod(){
    System.out.println("后置通知");
}
```

@AfterReturning,将方法标注为返回通知，返回通知一般是在方法执行后，可以理解为try语句块中的最后一行return一句。

注意方法中的返回值这个参数的名字需要和returning的变量名保持一致，这样在方法中才可以获取到返回值。如果被代理的方法本身没有返回值，则这边获得的返回值会为null。

```java
@AfterReturning(value = "execution(* com.jkl.test.aop.*.*(..))", returning = "result")
public void returnMethod(Object result) {
    System.out.println("The result is : " + result);
}
```

@AfterThrowing,将方法标注为异常通知，作用于方法抛出异常的时候。

```java
@AfterThrowing(value = "execution(* com.jkl.test.aop.*.*(..))",throwing = "ex")
public void exceptionMethod(Exception ex){
    System.out.println(ex);
}
```

@Around将方法标注为返回通知。

```java
@Around(value = "execution(* com.jkl.test.aop.*.*(..))")
public Object aroud(ProceedingJoinPoint pjp){
    Object res=null;
    try {
        System.out.println("前置");
        res=pjp.proceed();
        System.out.println("返回");
        return res;
    } catch (Throwable throwable) {
        throwable.printStackTrace();
        System.out.println("异常");
    }finally {
        System.out.println("后置");
    }
    return -1;
}
```