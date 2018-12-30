package tugce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NameService {


    public String getUserName(String id){
        return "Real user name";
    }
}
