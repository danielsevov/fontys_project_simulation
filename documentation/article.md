# Article

This article is written as an additional overview of the traffic control system developed by group 12 in PRJ3. 
The purpose of the article is to inform the assessment committee about the overall architecture of the software system, 
as well as to explain which design patterns and principles have been applied and how and why they have been integrated. 
The article will also provide individual explanation of the contribution to the project written by each team member.

## Overall architecture (Daniel)
In terms of architecure our group decided to organize our system into separate layers, where each layer has different responsibilities. There are two main layers - the business logic and the presentation logic layers. The business logic layer is responible for handling the business rules, calculations, and logic within an application which dictate how it behaves. The purpose of the presentation logic layer is to display information to and collect information from the user - in other words it is responible for maintaining the user interface, where the end user interacts with the application. The two layers are closed - all user requests go throught the presentation layer to the business logic layer where they are executed and results are returned to the presentation layer and displayed to the user. The separate layers work in isolation in order to prevent business logic from accessing view logic directly, because we know that a lower level layer should not be able to access a higher level layer. This way we keep our layers as independent from each other as possible, which allows us to easily test them in isolation, maintain and extend them or even completely replace them in case such measures are needed, without worrying about accidentally breaking the system. Changes in one layer do not affect the other layer directly and the amount of rework needed to adapt to those new changes is very low.


## Design patterns
In this part we will describe the design patterns we used in our software design.

## Strategy pattern - Crossing modes (Patrick and Daniel)
Crossings behave differently in different countries and can execute different logic in specific situations (as the night mode fore example where lights are just blinking). 
Therefore, it was essential that the crossings support different crossing behaviours or as we called them - crossing modes. To be able to change the behaviour of a crossing 
during runtime we applied the strategy pattern by separating the actual crossing logic from the crossing object and extracting it to a crossing mode object. The crossing mode 
controls the traffic lights, which are inside the crossing object and thus define the behaviour of the crossing. Applying the strategy pattern here allowed us to easily define new
crossing behaviours and change them during runtime without any issue.


### Strategy and state pattern composition - Traffic lights with different light behaviours and states (Niklas)
First, we created a few requirements for the traffic light. Important to know is that traffic lights can have multiple states (basically the color they show). 
A state can have different meanings, i.e. 'passing', 'stop' and 'transition'. Each traffic lights has one passing and one stopping state and can have additional transition states. 
The traffic lights can have different light behaviours as well. A light behaviour determines which states the traffic light can have and how iteration order looks like.

![Traffic light class diagram](../design/poster_class_diagram.png?raw=true "Class diagram for the traffic light and its corresponding classes")

The class diagram shows the TrafficLight interface and the classes it needs in order to work properly. First, we designed the different light behaviour. 
It is very straight forward that the light behaviour consists of multiple states following one and another, therefor we decided to use a state-machine-pattern like design here. 
Each behaviour-enum implements the LightState interface and therefor each state of this behavior needs to implement the 'getNextState' method. 
This way we can easily define different light states and the order of them. The next design decision was made when we thought of applying different light behaviours to the traffic light. 
The traffic light shall be able to have a different behaviour depending on the location of it (e.g., netherlands/germany/bulgaria). We decided to apply the strategy pattern here, 
so we can supply the traffic lights with their behaviour during runtime so that the traffic light does not depend on the light behaviour. 
Therefor we don't need a separate traffic light for each behaviour. The traffic light just gets supplied with an 'initial' LightState and dependent of the implementation of this LightState, 
the behaviour of the traffic light is determined. 


### Factory Pattern (Henrik)
It is a creational pattern that helps create an object without the user getting exposed to creational logic. By creating the different traffic lights in the factory,
 we directly supply the behavior to the traffic light without creating the behavoir itself every time. With this, we are making sure that at the beginning,
 the trafficlight are always in the "Stop" state. We also implemented a factory for the different traffic light behaviours, crossing modes and crossings. 

### Observer pattern (Patrick)
To make the presentation and business logic loosely coupled we utilized the observer pattern. This servers as the bridge between the GUI and the business logic modules.
The GUI observes specific components of individual traffic lights - part of the business logic. Whenever a light changes it updates automatically the presentation logic module about the change. 
This way we can easily request changes within the GUI, that are applied in the business logic module and then announched to the GUI. 

## Design principles (Daniel)

### Separation of Concerns princple 
One of those principles is the  Separation of Concerns princple, which means that all components of a layer deal only with specific logic,
which pertains to that specific layer. This singularity of purpose of the individual components makes the overall system easier to maintain,
which is something that we wanted to achieve with our design.

### Single Responsibility pricniple
Another principle that we applied is the Single Responsibility pricniple, which states that each class should have one responsibility, one single purpose.
This way changes could be easily made to a class in the system, without a lot or any rework needed in other classes of the system.
With the use of this design principle our application become more maintainable and the code - much easier to read and understand, thereby having fewer defects.

### DRY (Don't repeat yourself)
One of the design principles, which we applied throught the whole development phase is the DRY principle (don’t repeat yourself).
The DRY principle says don’t write duplicate code, instead use Abstraction to abstract common things in one place. It is an important for us principle
as it makes application of changes much easier and the maintanability of our system. After all one copy is much easier to maintain than multiple copies so 
if the code needs to be changed, there is only one place to change it.

### Encapsulate what changes
In order to keep the amount of rework and redesign needed to a minimum we tried to encapsulate what varies and isolate it from the rest of the code, which stays the same.
By isolating the parts which are prone to change we limit the surface area that will be affected by a shift in requirements. This improves the usability and maintanability of our system as
changes can be made independently and without breaking the rest of the code. The code also becomes easier to read and understand. The application of this principle is important part of the application of the strategy and state design patterns.

### Composition over inheritance 
The application of strategy and state patterns also provoked us to apply the Composition over inheritance princple, which allows changing the behavior of a class at run-time by setting property during run-time.
This provides flexibility to change the behaviour of the application at any time, without having to rewrite code. This way we could easily implement and apply new different behaviours for an object without having to rework this object but just supply it with the new behaviour.
The end result is a much more flexible system, which is also much easier to test in isolation as behaviour objects can be easily mocked.

### Programming to an interface not implementation
The application of the Program to an interface principle means that we don't depend on a concrete types to do our work, but we depend on types, which implement the needed interface.
This way the client program is not worried about implementation because the interface signature determines what operations can be done. This can be used to change the behavior of a program at run-time, which is also wanted with the application of the strategy pattern.
It also made our application more maintainable and stable as we could independently change the implementation and so the behaviour of the system without any other rework needed.

### Strive for loose coupling
We tried to enable isolation throught our system by segregating the different software processes to prevent them from accessing memory space they do not own. An example for this is the coupling of the different layers for example,
where they are connected only via a bridge but can easily work or be tested in isolation. We applied this principle not only for our layers but also for all objects interacting between each other. 
This way we achieved good level of stability and testability in our system.

## Individual roles

### Everyone

Research - 
All team members contributed to the project by doing research about traffic systems in Europe and around the world. The collected intel was used to define the behaviour of business objects such 
as the traffic lights and crossings.

Design - 
All design decisions were made together in the group via discussions and all members contributed to final design of our system.

Tests - 
The application itself has gotten quite big. It was paramount that we implemented high-quality tests with an excellent coverage. 
We also configured a task in GitHub which automatically runs all our tests for every new push. This made sure that our application continued to work as expected throughout the project. 
It also saved us a lot of time because we didn’t have to test everything manually after every sprint.
Our layered architecture also makes testing quite easy because we had the possibility to test every module independently.

### Patrick
As the scrum master I was responsible for the general organization of the project team. I made sure that everyone knew when the meetings took place through the Outlook Calendar, 
checked that everyone is present and got a chance to voice their opinion or concerns. 
I also made sure that the meetings took place within the limitations of the timebox. Henrik and I worked together closely to make sure that he, as product owner, got the deliverables he wanted in-time. 
We planned the deliverables together in the project board and I made sure that everyone knew what their tasks were. 

As a team member, I took part in the group designing discussions and contributed to the decisions we made as a group. I primarily worked on the Visual Paradigm file. During the implementation I primarily focussed on creating tests and also focussed on the trafficlights themselves.

### Henrik
As a product owner, I was responsible for frequently updating the product backlog. After every sprint planning meeting, I set up the "To Do" log for the next sprint. 
At the start of every meeting of the group, I basically communicated the current status of our work and where we are right now. What we are actually doing in a specific meeting is either decided by the group itself or by me. 
I prioritized the different worked out user stories and based on that, put them into the "To Do" log for each sprint. At the sprint review meeting, I took a look at our work and determined what eventually missed and how we could improve. 

As a team member, I tried to contribute to the design of the hole application as much as possible. Moreover, as well as Patrick, I primarily worked on the Visual Paradigm file, more precisely on the specific requirements of each user story and on different diagrams (for example state machine diagrams of the different light behaviours). I also worked on the factory pattern, wrote tests for different light behaviors and for the factories. Besides that, I worked on the data dictionary.

### Niklas
As a team member, I always tried to understand the design ideas of my group members and liked to discuss them together. I really liked that we designed the whole business logic together, so that we could consider different design approaches and find the best one. I have also written a lot of tests for our project in order to get a good test coverage. I am proud of the traffic light design we came up with where we used the strategy and state pattern together. 

### Daniel 
As a team member I did research on traffic control systems around the world. I took part in the group designing discussions and contributed to the decisions taken.
I set up the initial structure of our application and of our repository on Github with Continious Integration using Github Actions. During the implementation I worked 
on some parts of our business logic by defining business objects and their behaviours based on the design choices we made together.
I implemented a simple GUI to allow us to easily showcase our major use cases. I wrote tests for some of the business objects I implemented.

