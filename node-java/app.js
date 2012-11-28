var java = require("java");
//groovy need lib
java.classpath.push("groovy-1.7.10.jar");
java.classpath.push("asm-3.2.jar");


java.classpath.push("node-java.jar");

var ArrayList = java.import('java.util.ArrayList');
var list = new ArrayList();
list.addSync('item1');
console.log("list get 0="+list.getSync(0))


var JavaHello = java.import('JavaHello');
var javaHello = new JavaHello();
javaHello.sayHiSync();

var GroovyHello = java.import('GroovyHello');
var groovyHello = new GroovyHello();
groovyHello.sayHiSync();







