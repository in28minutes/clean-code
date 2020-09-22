# Clean Code with Java: Learn Simple Design, Refactoring & TDD

Learn to Write Clean Code with Java. Get Hands-on with 20+ Code Examples involving 4 principles of Simple Design, Refactoring & TDD.

## Todos

## Course Notes

This will be exercise based course. You cannot learn to write great code without trying it yourselves. So, before looking at the solution video, I urge you to try it yourselves.

No solution is perfect!

NO CHANGES To Gilded Rose Statement
- What is 3? Why is it 3 and not 10?
- Is there a relationship between values?

Try to make this test more readable

What is it testing? What is input and output and what is the relationship?

Constant => What is the concept it is representing? The value is not important. I can create a value FIFTEEN but does that really mean anything. Does it really matter that it is 15. Can it be 14 or 13?

Since we have a good understanding of what the test is doing, let's give it a name!

Three parts of the test! Setup, Invoke, Verify

Comments are not needed anymore!

Readability is all about Naming.

TDD - https://www.youtube.com/playlist?list=PLBD6D61C0A9F671F6

http://butunclebob.com/ArticleS.UncleBob.TheBowlingGameKata

4 Principles of Simple Design - https://www.youtube.com/playlist?list=PL066F8F24976D837C

Handbook To Participants - Programming Excellence Workshops => https://docs.google.com/document/d/1LgEvxsjALF3uWy1Plii8kzeCnnVInNXtbRwoteA2Wic/edit#

First Step - Path to Programming Craftsmanship => https://docs.google.com/document/d/1PWJ3uRO1HlqDPUtVV2X5DPS0RD8-b2TW5xu2tTXJRio/edit#


Category	SubCategory	Priority(1-6)
Clarity in Code	General	6
Clarity in Code	Naming of Variables	5
Clarity in Code	Naming of Methods	5
Clarity in Code	Proper use of Enums	2
Clarity in Code	Proper use of Constants	2
Clarity in Code	Creation of temporary Variables as needed	2
Clarity in Code	Creation of proper Utility Methods	5
Duplication	Very Less Duplication in code	5
Clarity in Code	High level and low level methods	5
Clarity in Code	Proper Naming of Test Methods	5
Clarity in Code	Proper organization of test methods (setup, invoke, check)	5
Clarity in Code	Clarity in expressing what is being tested in a test method	6
Duplication	Very Less Duplication in test method	5
Clarity in Code	Proper and clear Asserts	5
TDD	Signs of following TDD	5

No Big Design Up Front
Design vs Architecture
Focus on Todays Requirements => Do them well
Change is expected

4 Principles of Simple Design
Refactoring
- Altering Structure of Code without affecting "Behavior"
- Toughest part of Refactoring is the order or sequencing of steps
- Continuous Refactoring aided by Tests - Leads to "Clean Code"

Unit Testing Organization/Attitude 
- More important than Code.
	- Lead to Better Design (due to Continuous Refactoring)
- Best written before Code (TDD ).
	- TDD improves Design and Code Quality
- Separated from Production Code
- Find Defects Early
	- Continuous Integration

Unit Testing Principles
- Easy to understand (Typical test should take no longer than 15 seconds to read.)
- Test should fail only when there is a problem with production code.
- Tests should find all problems with production code.
- Tests should have as minimum duplication as possible.
- Should run quickly.

Principle 1: Easy to understand
- Name of the Unit Test
	- Should indicate the condition being tested and (if needed) the result
		- testClientProductSum_AllProductsSameCurrency vs testClientProductSum
		- testClientProductSum_DifferentCurrencies_ThrowsException vs testClientProductSum1
		- testClientProductSum_NoProducts vs testClientProductSum2
	- Keyword test at start of method name is now superfluous. (Junit 4 does not need it.)
		- Methods can as well be named clientProductSum_DifferentCurrencies_ThrowsException
- Highlight values important to the test
Test Setup
  - List<Product> products = new ArrayList<Product>();
  - products.add(new ProductImpl(100, "Product 15",ProductType.BANK_GUARANTEE, new
AmountImpl(new BigDecimal("5.0"), Currency.EURO)));
  - products.add(new ProductImpl(120, "Product 20",ProductType.BANK_GUARANTEE, new
AmountImpl(new BigDecimal("6.0"), Currency.EURO)));

COMPARED TO
Amount[] amounts = {
                new AmountImpl(new BigDecimal("5.0"), Currency.EURO),
                new AmountImpl(new BigDecimal("6.0"), Currency.EURO) };
                List<Product> products = createProductListWithAmounts(amounts);

- One condition per test
	- Results in simple code without if's , for's etc.
	- If a test fails, you would know the exact condition which is failing.
	- Create useful assert methods to test the condition
assertAmount(expected, actual);
       private void assertAmount(Amount expected, Amount actual) {
           assertEquals(expected.getCurrency(), actual.getCurrency());
           assertEquals(expected.getValue(), actual.getValue());
}

- No Exception Handling in a test method.

public void testClientProductSum_NoProducts() throws DifferentCurrenciesException
INSTEAD OF
           public void testClientProductSum(){
               try {
                   temp = clientBO.getClientProductsSum(products);
               } catch (DifferentCurrenciesException e) {
fail(); }
}

Use annotated ExceptionHandling to test for exceptions.
       @Test(expected = DifferentCurrenciesException.class)
       public void testClientProductSum_DifferentCurrencies_ThrowsException() throws Exception
       {
           CODE THAT THROWS EXCEPTION;
}
@Test
       public void testClientProductSum1() {
           try {
               CODE THAT THROWS EXCEPTION;
               fail("DifferentCurrenciesException is expected");
           } catch (DifferentCurrenciesException e) {
           }}

- Compare Arrays assertArrayEquals(expectedArray,actualArray)
- Testing Exceptions
Annotation (exception = Exception.class)
- Testing Performance
	– Annotation (timeout = 2) 2 milliseconds


Principle 2 : Fail only when there is a defect in CUT (Code Under Test)
- No dependencies between test conditions.
	- Don't assume the order in which tests would run.
- Avoid External Dependancies
	- Avoid depending on (db, external interface,network connection,container).. Use Stubs/Mocks.
- Avoid depending on system date and random.
	- Avoid hardcoding of paths (“C:\\TestData\\dataSet1.dat”);//Runs well on my machine..

Principle 3 : Test's should find all defect's in code
- Why else do we write test :)
- Test everything that could possibly break.
	- Test Exceptions.
	- Test Boundary Conditions.
- Use Strong Assertions
	- Do not write “Tests for Coverage”
- Favorite maxim from Junit FAQ
	- “Test until fear turns to boredom.”
- Junit FAQ : Should we test setters and getters?
becomeTimidAndTestEverything
while writingTheSameThingOverAndOverAgain
becomeMoreAggressive writeFewerTests writeTestsForMoreInterestingCases if getBurnedByStupidDefect
feelStupid
becomeTimidAndTestEverything end
End
Remember this is a infinite loop :)

Principle 4 : Less Duplication 
- No Discussion on this :)

Principle 5 : Test's should run quickly
- To maximize benefits, tests should be run as often as possible. Long running tests stop tests from being run often.
	- Avoid reading from File System or Network
	- A temporary solution might be to “collect long running tests into a separate test suite” and run it less often.

Result : Tests as Documentation
- Well written tests act as documentation and can be used for discussions with Business as well.
- Examples
	- testClientProductSum_AllProductsSameCurrency
	- testClientProductSum_DifferentCurrencies_ThrowsExcep tion
	- testClientProductSum_NoProducts

