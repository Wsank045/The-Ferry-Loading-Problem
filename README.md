# The-Ferry-Loading-Problem

In this assignment, you will solve the Ferry Loading problem, a problem used for practice for ACM
programming competitions. The focus here is for you to solve the problem on your own, and not inspect
any previous solutions to this problem. Indeed, we will be asking you to use a specific algorithm, which
is not the most common method used to solve this problem. For this assignment, you will be submitting
your code to an online judge which tests your code and gives a verdict. To receive the “accepted”
verdict, your code needs to correctly solve their battery of tests within the allotted maximum time.

Ferry Loading problem description PC/UVa IDs: 111106/10261 obtained at https://onlinejudge.org/

![index](https://user-images.githubusercontent.com/62038563/167182964-8b891248-f8bd-481e-8ddd-5c8ecc7d5cc0.png)


## Input
The input begins with a single positive integer on a line by itself indicating the number of the cases
following, each of them as described below. This line is followed by a blank line, and there is also a
blank line between two consecutive inputs.
The first line of input contains a single integer between 1 and 100: the length of the ferry (in metres).
For each car in the queue there is an additional line of input specifying the length of the car (in cm, an
integer between 100 and 3000 inclusive). A final line of input contains the integer 0. The cars must be
loaded in order, subject to the constraint that the total length of cars on either side does not exceed
the length of the ferry. Subject to this constraint as many cars should be loaded as possible, starting
with the first car in the queue and loading cars in order until no more can be loaded

## Output
For each test case, the output must follow the description below. The outputs of two consecutive cases
will be separated by a blank line.
The first line of outuput should give the number of cars that can be loaded onto the ferry. For each
car that can be loaded onto the ferry, in the order the cars appear in the input, output a line containing
‘port’ if the car is to be directed to the port side and ‘starboard’ if the car is to be directed to the
starboard side. If several arrangements of the cars meet the criteria above, any one will do.

## Sample Input
1\
50\
2500\
3000\
1000\
1000\
1500\
700\
800\
0\

## Sample Output
6\
port\
starboard\
starboard\
starboard\
port\
port\
