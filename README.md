# Week 6

Given an array of Strings, use merge sort (as described in class) to sort the strings in order of **increasing length**. 
We will also use binary search to look for a string in that sorted list (with some modification). 

You should use the code we developed in class on [September 23rd](https://github.com/CS2401-Fall2020/September23-inClass).

Do not change the method signatures. **Do not use helper methods**. 

## Tasks
### `mergeSortLengths(String[] stringArray)`

This *recursive* method will use merge sort to sort the elements in `stringArry` by thier **string lengths**. 
The method will be implemented by creating two arrays of half the length
(with odd sized arrays having one extra element on the half containing the lower indexes) 
and making recursive calls on those. 
The merge part of the method will then place the elements back into `stringArray`.
In the case of ties in the length of the string they will be put in alphabetical order. 
Again for this method the exercises from class on [September 23rd](https://github.com/CS2401-Fall2020/September23-inClass) 
should be used as a template. 

***Example 1:***
Given the Strings "DeBlasio","Gastelum","Flores","Alvorado","Berkowitz" the returned array would be: 
```
{"Flores", "Alvorado", "DeBlasio","Gastelum","Berkowitz"}
```
The string lengths in the result are 6, 8, 8, 8, 9. 
For the strings with ties in length they are sorted alphabetically. 


***Example 2:***
Given the Strings "AAAAA","BBBB","CCC","DD","E" the returned array would be: 
```
{"E", "DD", "CCC","BBBB","AAAAA"}
```
The string lengths in the result are 1, 2, 3, 4, 5.  

### `binarySearchLengths(String[] inArray, String search, int start, int end)`
This method will take in a array of strings that have been sorted in order of **increasing length**, 
for ties in the string lengths they will be in alphabetical order. 
The method also takes in a search string and range of indexes (start, end). 
The method will return a String formatted with the path of search ranges followed by a decision (true or false), 
see the examples below. 

***Example 1:*** 
`binarySearchLengths({"a","aaa","aaaaa"},"bb",0,2)` would return the string `"(0,2) (0,0) False"`
This means the method first looked in the range `0` to `2`, then made a recursive call to the range `0` to `0`, then made the determiniation that the element was not in the array `"False"`.

***Example 2:***
`binarySearchLengths({"a","b","c","d","e","f","g"},"e",0,6)` would return the string `"(0,6) (4,6) (4,4) True"`
This means the method first looked in the range `0` to `6`, then made a recursive call to the range `4` to `6`, then made a recursive call to the range `4` to `4`, then made the determiniation that the element was in the array `"True"`.

### Testing
You should provide 10 unit tests in your main method that show your new methods satisfy all of the requirements 
These can be formatted using print statements or java assert statements (no need to use JUnit).
Each test should be clearly labeled within the main method, and accompanied by text explaining the expected value for the test and why that test is included.

## Grading
* `binarySearchLengths` -- 50 pts
* `binarySearchLengths` -- 30 pts
* unit tests -- 20 pts (2 pts each) 

Lateness rule: -10 pts for 1 day of lateness / - 20 pts for 2 days of lateness / 0 after that, but you still have to turn in your work
