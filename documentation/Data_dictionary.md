# Data Dictionary

|Entity|Description|
|--|--|
|Admin|Person who is responsible for maintaining and extending the simulation|
|Street traffic light|A street traffic light is a traffic light for the vehicles on the road|
|Pedestrian traffic light|A pedestrian traffic light is a traffic light for the pedestrians on the sidewalk trying to cross the street|
|Trafficlight type| Type can be either pedestrian or street|
|Trafficlight signal| Combinition of the lightstate and the shape of the trafficlight|
|Traffic light state|A traffic light state describes the state (in terms of color) the traffic light is currently in (e.g. red/yellow/green). The states are divided in pedestrian and street light states and are pre-ordered|
|Light state meaning|Each traffic light state has a meaning which provides the information what to do when the traffic light is in this state (stop/pass/transition/emergency)|
|Traffic light shape|The shape determines how the traffic lights actually look like, light states are not affected by that|
|Crossing|A crossing contains multiple traffic lights for the different roads/pedestrian crossings. It follows straight rules which determine how the different traffic lights have to work together. In a crossing, there are two dimensions - horizontal and vertrical. The trafficlights of the opposite sides of the axis get the same signal. |
|Trafficlight behaviour|The object holding the lightstate transition logic of the trafficlight|
|Crossing mode|The object holding the crossing loop logic. The mode defines the way how trafficlights change states and interact with each other|
