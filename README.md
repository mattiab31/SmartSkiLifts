# SmartSkiFrag
App for Android. Working with Sensoro Beacon

The idea is to implement this app into the existing app of a ski area. 
The goal is to help skiers to get information without use of hands
Now the app works in this way:

There is a main activity that implement the BeaconListener and when the smartphone where the app is installed go in the region of a beacon the main activity shows a "right" fragment.

There are 3 beacons managed:
1) The first device placed in a ski lift. we get the temperature value and the light value from the beacon and according to these show a "recommended" mask and which slopes we can achieve with this lift.

2) The second device placed in a Chalet. Now the app will show only a flyer with a discount but the idea is that you can show the entire menu to get order without long line.

3) The third one placed in the entrance of the SnowPark. The purpose is to start the camera to get video without any touch of the screen. We can improve this function and we can start our SportCam insted the camera of our smartphone.

This is a Demo App to learn how implement Sensoro method.

I use it to explain this technology.

Go to my slide on slideshare to know more about it!

http://www.slideshare.net/MattiaBrunetti/sensoro-beacon-review

