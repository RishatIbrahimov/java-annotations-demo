package ru.kpfu.entity;

import ru.kpfu.annotation.In;
import ru.kpfu.annotation.Out;

/**
 * @author Rishat Ibrahimov
 */
public class Car {
  @Out(caption = "cost")
  private int cost;
  @In(caption = "power")
  private int power;
  @In(caption = "label")
  private String label;
  @In(caption = "year")
  private int year;

  public String color;

  public Car(int cost, int power, String label, int year, String color) {
    this.cost = cost;
    this.power = power;
    this.label = label;
    this.year = year;
    this.color = color;
  }

  public Car(String color) {
    this.color = color;
  }

  public Car() {
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public int getPower() {
    return power;
  }

  public void setPower(int power) {
    this.power = power;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label, int test) {
    this.label = label;
  }

  public void setLabel(int label, String test) {
    this.label = String.valueOf(label);
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  private void calculateCost() {
    this.cost = (int) (Math.random() * 1000);
  }
}
