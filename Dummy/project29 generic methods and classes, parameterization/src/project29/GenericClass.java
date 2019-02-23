/*
A generic class declaration looks like a non-generic class declaration, except that the class name is 
followed by a type parameter section.

As with generic methods, the type parameter section of a generic class can have one or more type parameters 
separated by commas. These classes are known as parameterized classes or parameterized types because they 
accept one or more parameters.
 */
package project29;
//The sinthax for a generic class is just like a basic class dispite that it contains: <T>, which is the type
//object, for the parameter.
public class GenericClass <T> {
   private T t;

   public void set(T t) {
      this.t = t;
   }

   public T get() {
      return t;
   }
}
