# Introduction
This is the first project of the Udacity's Android Kotlin Developer nanodegree program

The items I chose for the inventory are fruits instead of shoes.

## Screenshots
![Log In screen](https://github.com/takathepug/udacity_1_storeinventory/blob/main/screenshots/log_in_screen.png)
![Welcome screen](https://github.com/takathepug/udacity_1_storeinventory/blob/main/screenshots/welcome_screen.png)
![Instructions screen](https://github.com/takathepug/udacity_1_storeinventory/blob/main/screenshots/instructions_screen.png)
![List screen](https://github.com/takathepug/udacity_1_storeinventory/blob/main/screenshots/list_screen.png)
![Add screen](https://github.com/takathepug/udacity_1_storeinventory/blob/main/screenshots/add_screen.png)

## Layout choices
ConstraintLayout was chosen over LinearLayout when fine control of the layout of the elements
in the screen is required.

All the different screens and the layout that defines each item in the list that implements the
inventory require to define relationships between UI elements. That's when ConstraintLayout is the 
way to go.

On the other hand, when a simple array of UI elements, in our case vertical successions, is enough,
LinearLayout has better performance. Examples of usages are the inventory list containing
the elements, or the only children of the NestedScrollView that contains a succession of text
instructions and pics.