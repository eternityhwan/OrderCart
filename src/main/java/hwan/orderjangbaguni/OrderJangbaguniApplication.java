package hwan.orderjangbaguni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderJangbaguniApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderJangbaguniApplication.class, args);
        Hello hello = new Hello();
        hello.setData("hello");
        String data = hello.getData();
        System.out.println("data = " + data);

    }
}

