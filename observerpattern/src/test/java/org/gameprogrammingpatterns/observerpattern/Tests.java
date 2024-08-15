
package org.gameprogrammingpatterns.observerpattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Tests {

	@Test
	@DisplayName("attach/detach observer test") 
	void detachTest() {
		Noise n1 = new Noise("beep");
		Ear e1 = new Ear("one");
		Ear e2 = new Ear("two");

		n1.addObserver(e1);
		assertEquals(1, n1.countObservers());

		n1.addObserver(e2);
		assertEquals(2, n1.countObservers());
		
		n1.deleteObservers();
		assertEquals(0, n1.countObservers());
		
	}

	@Test
	@DisplayName("notify test")
	void testNotify() {
		Noise n1 = new Noise("beep");
		Ear e1 = new Ear("one");
		Ear e2 = new Ear("two");
		Ear e3 = new Ear("three");

		n1.sound();
		assertEquals(e1.numObserved, 0);
		assertEquals(e2.numObserved, 0);
		assertEquals(e3.numObserved, 0);
		
		n1.addObserver(e1);
		n1.sound();
		assertEquals(e1.numObserved, 1);
		assertEquals(e2.numObserved, 0);
		assertEquals(e3.numObserved, 0);

		n1.addObserver(e2);
		n1.sound();
		assertEquals(e1.numObserved, 2);
		assertEquals(e2.numObserved, 1);
		assertEquals(e3.numObserved, 0);

		n1.addObserver(e3);
		n1.sound();
		assertEquals(e1.numObserved, 3);
		assertEquals(e2.numObserved, 2);
		assertEquals(e3.numObserved, 1);

		n1.deleteObserver(e2);
		n1.sound();
		assertEquals(e1.numObserved, 4);
		assertEquals(e2.numObserved, 2);
		assertEquals(e3.numObserved, 2);

		n1.deleteObserver(e1);
		n1.sound();
		assertEquals(e1.numObserved, 4);
		assertEquals(e2.numObserved, 2);
		assertEquals(e3.numObserved, 3);

		n1.deleteObserver(e3);
		n1.sound();
		assertEquals(e1.numObserved, 4);
		assertEquals(e2.numObserved, 2);
		assertEquals(e3.numObserved, 3);

	}
}