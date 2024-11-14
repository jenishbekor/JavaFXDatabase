### How to use java.sql in project

firstly, add database dependency in pom.xml

<dependencies>

        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.7.4</version>
        </dependency>
        
</dependencies>

In the module-info.java file add:
 - require java.sql;
to include java.sql library in our project module.
