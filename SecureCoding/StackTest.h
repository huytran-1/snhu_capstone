/* StackTest.h declares a test-class for a dynamically allocated (array) Stack.
 * Student Name:
 * Date:
*/

#ifndef STACKTEST_H_
#define STACKTEST_H_


class StackTest {
public:
	void runTests();
	void testConstructor();
	void testIsEmpty();
	void testPushPeekTopAndIsFull();
	void testPop();
	void testCopyConstructor();
	void testAssignment();
	void testDestructor();
};

#endif /*STACKTEST_H_*/