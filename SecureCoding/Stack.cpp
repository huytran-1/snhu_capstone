/* Stack.cpp defines the dynamically allocated (array-based ) Stack operations..
 * Student Name:
 * Date:
 */

#include "Stack.h"

/* explicit-value constructor
 * Parameter: capacity, an unsigned value.
 * Precondition: capacity > 0.
 * Postcondition: mySize == 0 && myCapacity == capacity
 *              && myArray contains the address of a dynamic array of 'capacity' entries.
 */
Stack::Stack(unsigned capacity) {
   mySize = 0;
   myCapacity = capacity;
   myArray = new Item[capacity];
}

/* copy constructor
 * Parameter: original, a Stack (const reference).
 * Postcondition: I am a copy of original.
 */
Stack::Stack(const Stack& original) {
	makeCopyOf(original);
}

/* utility method containing code refactored from
 *  the copy constructor and operator=.
 * Parameter: original, a Stack (const reference).
 * Precondition: original.myCapacity > 0.
 * Postcondition: I am a copy of original.
 */
void Stack::makeCopyOf(const Stack& original) {
	myCapacity = original.myCapacity;
	myArray = new Item[myCapacity];

	for (unsigned i = 0; i < myCapacity; i++) {
		myArray[i] = original.myArray[i];
	}
	mySize = original.mySize;
}

/* destructor
 * Postcondition: myCapacity == 0 && mySize == 0
 *             && myArray has been deallocated.
 */
Stack::~Stack() {
	delete [] myArray;
	myArray = NULL;
	myCapacity = 0;
	mySize = 0;
}

/* assignment operator
 * Parameter: original, a Stack (const reference).
 * Postcondition: I am a copy of original
 *              && I have been returned.
 */
Stack& Stack::operator=(const Stack& original) {
	if (this != &original) {
		delete [] myArray;
		makeCopyOf(original);
	}
	return *this;
}

bool Stack::isEmpty() const
{
  if(mySize == 0) {  
    return true;
  }
  return false;
}
bool Stack::isFull() const 
{
  if(mySize == myCapacity) {  
    return true;
  }
  return false;  
}
void Stack::push(const Item& it) 
{
  myArray[mySize] = it;
  mySize = mySize + 1;
}

Item Stack::pop() 
{
  mySize = mySize - 1;
  return myArray[mySize];
}

Item Stack::peekTop() const 
{
  if(mySize != 0) 
  {  
    return myArray[mySize - 1];
  }
}

int Stack::getMyCapacity()
{
	return myCapacity;
}
