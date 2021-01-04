# Java-Project
The following Java program simulates the working of an Elevator.

# Explanation:
-The user is given a choice to either simulate inside panel or outside panel of an elevator.
 	
-The current floor of the elevator is always stored in a "currentfloor.txt" file. It can be read at any moment to determine the floor at which the elevator is. It is so   incase the elevator shuts down, its current floor can be restored after it restarts.
 	
-For 'inside elevator', the user is asked to enter their destination floor. If the destination floor is above the current floor, the elevator moves up(through 'moveup'     method), otherwise it moves down(through 'movedown' method).
 	
-For 'outside elevator', the user is asked to enter their current floor. If their current floor is above the lift's current floor, the elevator moves up(through 'moveup'   method), otherwise it moves down(through 'movedown' method).
 	
-The Elevator is programmed in a way such that whenever it is needed to 	move to a non-subsequent floor, it goes through each floor that is in between the source and       destination floor. Eg:if the lift needs to go to floor 5 from floor 1, it moves in following 	fashion: 1->2, 2->3, 3->4, 4->5. 	 	
 	
-An additional abstract class 'Lift' is defined which has two abstract methods 'emergency' and 'nonstop' for future use.

