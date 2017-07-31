# starbuzz

This is a simple implementation of a coffee-shop order-taking system that accepts a user's drink order and returns the price of the drink. 

## Execution

1. Clone this repository using https
```
git clone https://github.com/MeghnaM/design-patterns.git
```
2. Navigate to the appropriate folder using the command line
```
cd design-patterns/coffee-shop/
```
3. Run the following command to build all the files in this project
```
make
```
4. Run the following command to execute the main class
```
java StarBuzzClient [beverage] [ingredient]
```

### Input Format

Following are the beverage options available to a user:

**BEVERAGE        : [INGREDIENTS]**
Tea\_Latte        : [RedTea, Milk]
White\_Tea        : [WhiteTea]
Red\_Tea          : [RedTea]
Flower\_Tea       : [GreenTea, Jasmine]
Decaf\_Cappuccino : [Decaf, WhipCream]
Ginger\_Tea       : [GreenTea, Ginger]
Espresso          : [Espresso]
HouseBlend        : [Houseblend]
Decaf\_Mocha      : [Decaf, Chocolate]
Decaf             : [Decaf]
Mocha             : [Espresso, Chocolate]
Latte             : [Espresso, Milk]
Decaf\_Latte      : [Decaf, Milk]
Green\_Tea        : [GreenTea]
Cappuccino        : [Espresso, WhipCream]

### Example:

Here is an example of a command that will give you the correct price of a drink:
```
java StarBuzzClient Tea_Latte Milk
```

### Disclaimer

The code in this repository does not handle many error cases and the execution might fail if incorrect input is entered.
