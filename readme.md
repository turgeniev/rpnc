# Reverse Polish Notation Calculator

Reverse Polish Notation (RPN) provides the quickest way to enter data in a calculator because it eliminates the need for parenthesis. It was made mainstream by HP when they implemented it in their famous programmable calculators.

## How to use it

Unlike with a traditional calculator, you enter the parameters first, than the operator.

Supported operations:
 - '+' plus
 - '-' minus
 - '*' multiply
 - '/' divide
 - dup duplicate value of previous expression

For example, to calculate '20+50': type '20 50 +' = 70
Other examples:
 - '7 * 7': type '7 dup *' = 49
 - '2 2 * dup dup +' = 42

# Build

    ./gradlew build
    
# Run

    ./gradlew run