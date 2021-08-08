This repo contains all type of input validation example
#Update document and add unit test
two type of Custom validation one class level another field level

### Custom Validator
1. include
```   
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
  </dependency>
```
2. @Validated in Controller (org.springframework.validation.annotation.Validated)
3. Check two files ValidSearchParameter and ValidSearchParameterValidator
4. test in postman 
   * valid /search?postal_code=11 
   * invalid /search?postal_code=11&city=x
            /search
