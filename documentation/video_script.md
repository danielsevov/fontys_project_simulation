# Script for the video

1: Show pedestrian and traffic light where you can change the shape and behavior, execute the state-logic.
2: Showcase Simple crossing.
3: Showcase advanced crossing (use simple crossing as reference, how did we extend it, etc).


---------
1: Introduction
2: Explain which usecases the feature has
3: Show feature

---Intro---

[On GUI homescreen]

Hello guys, this is group 12. We would like to show you several features which we've implemented into our traffic control system.

We would like to start off with showcasing the pedestrian traffic light logic where you can change the shape and behavior and execute the state-logic.

In the video you'll see the console on the right side and the GUI on the left. All events that appear on the GUI are also displayed on the console.

[Screen 1]
The pedestrian traffic light can support different light behaviors and light shapes, which can be changed in runtime.

The light behaviors all have different states. These states all have a different meaning. The main states are PASSING and STOP with an extra state called TRANSITION which is used within our transition of main states.

We have done the same logic with the street traffic light. (showcase).

[Screen 2]

In order to combine the pedestrian and street trafficlights we've created the basic crossing entity, which consists of 4 pedestrian and 4 street traffic lights. They work in a specific logic which is based on a crossing-mode. For the basic-crossing we made a very trivial, simple crossing mode where the opposite lanes get the same light. (showcase)

For the purpose of the GUI we only show our main states. The transition-states are utilized and are visible in the console.

[Screen 3]

To extend the basic crossing we have implemented an advanced crossing. In this crossing all crossing-sides can have up to three street traffic lights, which all control specific lanes for a certain direction. The straight traffic light is mandatory, the lights for left and right are optional.

In order to control the crossing we've implemented different crossing modes which all have a different crossing logic. The crossing mode can control either the main traffic light or more. Crossing modes can be changed during runtime.

(Showcase simple crossing mode, showcase dutch/german and how they can be changed within runtime)


[outro]

THANK YOU FOR WATCHING DONT FORGET TO LIKE SUBSCRIBE AND HIT THAT BELL ICON SO YOU WILL GET NOTIFIED EVERY TIME WE UPLOAD A VIDEO!!!!!!!!!!!!!
