# Shapes and Perimeters

## Specifications

**Concrete Class Implementation**
1. Using package `com.company.concreteapproach`, create a basic class called `Shape`.  Include properties for name, color, x coordinate, and y coordinate. Also provide an empty implementation for `area()` and `perimeter()` methods.
1. Once you have the `Shape` class created, create the below classes. Each class will inherit from the `Shape` class. Each should have properties appropriate to them, and an implementation for `area()` and `perimeter()`.
    - `Circle`
    - `Square`
    - `Triangle`

**Abstract Class Implementation**
1. Using package `com.company.abstractapproach`, create an abstract class called `Shape`.  Include the same basic properties as before, but this time, declare the the `area()` and `perimeter()` methods as `abstract`.
1. Again, create the `Circle`, `Square`, and `Triangle` classes, inheriting from the new abstract `Shape` class.

**Interface Implementation**
1. Examine the starter code found in package `com.company.interfaceapproach`.  This is the same implementation that we previously created in our lesson on interfaces.

**Written Response**
1. In your own words, write a few paragraphs comparing and constrasting these approaches. Which implementation is "best?" Feel free to create an `main` method and test out each, if you feel that helps your understanding.

Interface class is the outline for the class. It can not have concrete methods which are methods with properties. An interface can have static members and method signatures. An interface can extend other interfaces but not classes. 
Also, methods must be declared public.

An abstract class is also the outline for concrete classes. A class can be abstract without methods but it needs at least one abstract method. Static members are allowed. Abstract classes can extend to other abstract or concrete classes.
 A concrete class is the final implementation of an outline. Concrete class can extend and be extended by any class. If you need multiple inheritances it's best to use interface. If you don't need multiple inheritances then abstract is the best option.

---
© 2019 Trilogy Education Services