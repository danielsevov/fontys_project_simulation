# Article

This article is written as an additional overview of the traffic control system developed by group 12 in PRJ3. 
The purpose of the article is to inform the assessment committee about the overall architecture of the software system, 
as well as to explain which design patterns and principles have been applied and how and why they have been integrated. 
The article will also provide individual explainaition of the contribution to the project written by each team member.

## Overall architecture

In terms of architecure our group decided to organize our system into separate layers, where each layer has different responsibilities.
There are two main layers - the business logic and the presentation logic layers. The business logic layer is responible for 
handling the business rules, calculations, and logic within an application which dictate how it behaves. The purpose of the
presentation logic layer is to display information to and collect information from the user - in other words it is responible for maintaining the 
user interface, where the end user interacts with the application. The two layers are closed - all user requests go throught the presentation
layer to the business logic layer where they are executed and results are returned to the presentation layer and displayed to the user.
The separate layers work in isolation in order to prevent business logic from accessing view logic directly,
because we know that a lower level layer should not be able to access a higher level layer. This way we keep our layers as independent from each other
as possible, which allows us to easily test them in isolation, maintain and extend them or even completely replace them in case such measures are needed,
without worrying about accidentally breaking the system. Changes in one layer do not affect the other layer directly and the amount of rework needed to adapt 
to those new changes is very low.

## Design patterns

* Singleton/creational pattern - The sole purpose of a singleton/creational software design pattern is to create a single purpose instance. We used this pattern in the 
creation of the BusinessLogicAPI for example, which is supplied to the presentation logic layer and used for accessing the business logic layer.

* Strategy pattern - It is a behavioral software design pattern that enables selecting an algorithm at runtime. We have applied that pattern multiple times, sometimes in composition 
with another design pattern such as the state pattern. The application of the strategy pattern allows us to easily change the behaviour of a object during run-time. An example is the 
existance of the Traffic Light Behaviour and Crossing Mode objects, which encapsulate the operating logic of the object they are supplied to.

* State pattern - It is a behavioral software design pattern that allows an object to alter its behavior when its internal state changes. We applied this pattern when designing the 
traffic light entity where we wanted to supply the traffic light with a light behaviour object (the above-mentioned application of the strategy pattern) and we wanted this 
light behavior to have different states, which when reached change the behaviour of the traffic light behaviour object. This allowed us to separate the operating logic 
of the traffic light from the traffic light object itself and move it to the light behavior object and to eliminate the need for if and switch statements in the light behavior object. 
The light behaviour does not have to worry about which state should be switched to next, as this logic is part of the state itself and every state can transition to only one other state,
making it easy to define traffic light loops and be sure that the right transition will always occur.

* Factory method pattern - It is a creational pattern that helps create an object without the user getting exposed to creational logic. We applied this pattern in a few 
places to be able to create concrete implementations without having to initilize them every time we create them.

* Observer pattern - It is a software design pattern in which an object, named the subject, maintains a list of its dependents, called observers, and notifies them
automatically of any state changes, usually by calling one of their methods. We used this pattern for coupling the graphical representations of the traffic lights, 
which are part of our GUI to the actual corresponding traffic lights - part of our business logic, which execute the actual traffic light logic. The dependents just
observe these traffic lights and correspond to the changes of the lights and shapes of the traffic light. We benefit from the use of the observer pattern as 
it supports the principle of loose coupling between objects that interact with each other, making our system less tightly coupled and easier to maintain and extend.
It also allows sending data from subject to observer effectively without any change in the Subject or Observer classes, which also contributed to the maintainability
and extendibility of our application.

* Facade pattern? - for example how we defined the crossing entity, which basically controls the subsystem - the collection of traffic lights. We implemented that pattern in order to make the 
subsytem easier to use. We access it through the facade - crossing entity.

## Design principles

In order to properly separate our application layers and keep them independent from each other we applied a few very fundemental design principles. 

* Separation of Concerns princple - One of those principles is the  Separation of Concerns princple, which means that all components of a layer deal only with specific logic,
which pertains to that specific layer. This singularity of purpose of the individual components makes the overall system easier to maintain,
which is something that we wanted to achieve with our design.

* Single Responsibility pricniple - Another principle that we applied is the Single Responsibility pricniple, which states that each class should have one responsibility, one single purpose.
This way changes can be easily made to a class in the system, without a lot or any rework needed in other classes of the system. The more classes we have in
the system following this principle, the more maintainable and easier to understand becomes the system. 
The code quality of the application becomes better and much easier to read and understand, thereby having fewer defects.

* Dependency inversion princple, Interface Segregation Principle, Programming to an interface not implementation princple - Our layered system design also contributed to the application of the Dependency inversion princple and the programming to an interface not implementation princple. 
Program to an interface means that we don't depend on a concrete types to do our work, but we depend on types, which implement the needed interface. However, 
this principle doesn't specify how we should get the required dependency. Therefore, we apply the DIP, which says that an object shouldn't control the creation of its dependencies,
it should just advertise what dependency it needs and let the caller provide it. The application of those two principles gives flexibility and stability 
at the level of the entire architecture of our application. We also implemented our interfaces in such a way that they comply with the Interface Segregation Principle. 
This principle states that a client should not implement an interface if it doesn’t use that, which happens mostly when one interface contains more than one functionality,
and the client only needs one functionality and no other. With proper designing we managed to prevent such issues from occuring and we applied the pricniple as much as possible.

* Open/Closed pricnple - With the use of the strategy design pattern in a few places we also managed to properly apply the Open/Closed pricnple, which states that
software entities should be open for extension, but closed for modification. In other words that means creating software entities whose behavior 
can be changed in runtime without the need to edit and recompile the code itself. This allows us to be agile in the use of our system by changing 
its behavior during runtime without worrying about breaking it accidentally. 

* Composition over inheritance princple, Encapsulate what changes pricniple - The use of strategy pattern also helped us apply the Composition over inheritance princple,
which allows changing the behavior of a class at run-time by setting property during run-time which provides flexibility to apply better implementation at any time.
It also helped us to encapsulate what changes so it won’t affect the rest of our code. This way we could easily create new different behaviours or change the old ones for the same object without having to rework this object.

* DRY principle (don’t repeat yourself) - We also applied the DRY principle (don’t repeat yourself) as much as possible in order to keep our system maintanable.
The DRY principle says don’t write duplicate code, instead use Abstraction to abstract common things in one place. It is a very important principle
as it makes application of changes much easier. After all one copy is much easier to maintain than multiple copies so 
if the code needs to be changed, there is only one place to change it.

* Liskov Substitution Principle - We applied another pricniple as well, part of the SOLID principles is the Liskov Substitution Principle, which states that subtypes must be substitutable for supertype.
This means that methods or functions which use the superclass type must be able to work with the object of subclass without any issue. We gained a few benefits from using 
this principle, where the major ones are code re-usability, reduced coupling, and easier maintenance of the overall system.

## Your (individual) role - area(s) you worked on

* Daniel - GUI, setting up basic structure, application of design principles and patterns 
* Henrik - Product owner, project board, tests, factory pattern - Factory
* Niklas - Traffic light + strategy pattern & state pattern - Strategy and stagte
* Patrick - Scrum master, project board, tests, crossing modes - Observer (Connection gui and business logic)
* Tanja -  nothing

## Patterns:
