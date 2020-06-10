package com.jkl.test.factory;

import com.jkl.test.bean.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by Daryl on 2020/06/05 14:40
 */
public class MyFactory implements FactoryBean<Car> {

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        car.setBrand("奥迪双钻");
        car.setPrice(300000.0);
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
