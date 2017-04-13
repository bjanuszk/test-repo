package springboot.hibernate.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionComposer transactionComposer;

    @RequestMapping("/transactionTest")
    public String transactionTest() {
        String result = "OK";
        try {
            transactionComposer.test();
        } catch (Exception e) {
            result = "EXCEPTION";
            e.printStackTrace();
        }
        return result;
    }
}
