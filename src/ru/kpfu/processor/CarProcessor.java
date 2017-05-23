package ru.kpfu.processor;

import ru.kpfu.annotation.In;
import ru.kpfu.annotation.Out;
import ru.kpfu.entity.Car;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author Rishat Ibrahimov
 */
public class CarProcessor {
  public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
    Car car = read();
    Method calculateCost = Car.class.getDeclaredMethod("calculateCost");
    calculateCost.setAccessible(true);
    calculateCost.invoke(car);
    write(car);
  }

  private static void write(Car car) throws IllegalAccessException {
    Class<Car> carClass = Car.class;
    Field[] declaredFields = carClass.getDeclaredFields();
    for (Field field : declaredFields) {
      Out annotation = field.getAnnotation(Out.class);
      field.setAccessible(true);
      if (annotation != null) {
        System.out.println(annotation.caption() + ": " + field.get(car));
      }
    }
  }

  private static Car read() throws IllegalAccessException {
    Car car = new Car();
    Class<Car> carClass = Car.class;
    Field[] declaredFields = carClass.getDeclaredFields();
    Scanner sc = new Scanner(System.in);
    for (Field field : declaredFields) {
      In annotation = field.getAnnotation(In.class);
      if (annotation != null) {
        System.out.println("Enter " + annotation.caption() + " value: ");
        field.setAccessible(true);
        if (field.getType() == String.class) {
          field.set(car, sc.next());
        } else {
          field.set(car, sc.nextInt());
        }
      }
    }
    return car;
  }
}
