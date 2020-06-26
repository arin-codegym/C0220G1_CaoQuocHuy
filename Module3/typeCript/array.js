/**
 * Array
 */
// declare an array
const list = [1, 2, 3];
const categories = ['Sport', 'IT', 'Car'];
console.log('list');
list.forEach((num) => console.log(num.toFixed(5)));
console.log('categries');
categories.forEach((str) => console.log(str.includes('a')));
// convert mảng từ dạng này sang dạng khác.
const listSquare = list.map(num => num * num);
console.log(listSquare);
// Output: [1, 4, 9]
// lọc các phần tử thỏa mãn
const result = categories.filter(str => str.length > 3);
console.log(result);
// Output: ['Sport', 'Car']
/**
 * Tuple
 */
// Declare a tuple type
let x;
// Initialize it
x = ["hello", 10]; // OK
// Initialize it incorrectly
// x = [10, "hello"]; // Error
console.log(x[0].substr(1)); // OK
console.log(x[0].substr(1,3)); // OK
// console.log(x[1].substr(1));
// Error, Property 'substr' does not exist on type 'number'.
x[3] = "world";
// OK, 'string' can be assigned to 'string | number'
x[5] = 100.25;
console.log(x[5].toString());
// OK, 'string' and 'number' both have 'toString'
// x[6] = true; // Error, 'boolean' isn't 'string | number'
