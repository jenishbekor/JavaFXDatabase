# Using `java.sql` in Project

To integrate `java.sql` into Java project and connect to a PostgreSQL database, follow these steps:

1. **Add Database Dependency**: In the `pom.xml` file, add the PostgreSQL dependency to connect to your database. For example:

    ```xml
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.7.4</version>
    </dependency>
    ```

2. **Reload Maven**: After adding the dependency, make sure to reload Maven to download and apply it.

3. **Update `module-info.java`**: If your project uses the Java Module System, you need to declare `java.sql` in your `module-info.java` file by adding:

    ```java
    requires java.sql;
    ```

   This line ensures that the `java.sql` library is available in your project, enabling you to use classes like `Connection`, `Statement`, and `ResultSet`.

With these steps, your project is now set up to use `java.sql` for database operations.
